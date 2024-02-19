package com.hyper.medicineapp.feature_home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hyper.medicineapp.common.api.NetworkResult
import com.hyper.medicineapp.common.dispatchers.BaseDispatcherProvider
import com.hyper.medicineapp.feature_home.data.model.toMedicationUi
import com.hyper.medicineapp.feature_home.data.repository.MedicationRepository
import com.hyper.medicineapp.feature_home.presentation.state.MedicationListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MedicationListViewModel @Inject constructor
    (
    private val medicationRepository: MedicationRepository,
    private val baseSchedulerProvider: BaseDispatcherProvider
) : ViewModel() {

    private val _uiState = MutableStateFlow(MedicationListState())

    val uiState = _uiState.asStateFlow()

    fun getMedicationList() {
        viewModelScope.launch(baseSchedulerProvider.ui()) {


            medicationRepository.getMedicationList()
                .flowOn(baseSchedulerProvider.io())
                .onStart { _uiState.value = MedicationListState(isLoading = true) }
                .catch { e ->
                    _uiState.value = MedicationListState(
                        error = e.message ?: "An exception occurred",
                        isLoading = false
                    )
                }
                .collectLatest { medicationList ->
                    when (medicationList) {
                        is NetworkResult.Success ->
                            _uiState.value = MedicationListState(
                                medicationList = medicationList.data.toMedicationUi(),
                                isLoading = false
                            )

                        is NetworkResult.Error -> {
                            _uiState.value = MedicationListState(
                                error = medicationList.errorMsg ?: "An error occurred",
                                isLoading = false
                            )
                        }

                        is NetworkResult.Exception -> {
                            _uiState.value = MedicationListState(
                                error = medicationList.e.message ?: "An exception occurred",
                                isLoading = false
                            )
                        }

                    }
                }

        }
    }
}