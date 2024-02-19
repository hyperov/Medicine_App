package com.hyper.medicineapp

import com.hyper.medicineapp.common.api.NetworkResult
import com.hyper.medicineapp.common.dispatchers.TestDispatchers
import com.hyper.medicineapp.feature_home.data.model.AssociatedDrug
import com.hyper.medicineapp.feature_home.data.model.ClassName
import com.hyper.medicineapp.feature_home.data.model.Diabete
import com.hyper.medicineapp.feature_home.data.model.Medication
import com.hyper.medicineapp.feature_home.data.model.MedicationRes
import com.hyper.medicineapp.feature_home.data.model.MedicationsClasses
import com.hyper.medicineapp.feature_home.data.model.Problem
import com.hyper.medicineapp.feature_home.data.repository.MedicationRepository
import com.hyper.medicineapp.feature_home.presentation.state.MedicationUiModel
import com.hyper.medicineapp.feature_home.presentation.viewmodel.MedicationListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class MedicationViewModelTest {

    // Mocking dependencies
    private val mockMedicationRepository = mock(MedicationRepository::class.java)

    private lateinit var medicationListViewModel: MedicationListViewModel

    @Before
    fun setup() {
        medicationListViewModel =
            MedicationListViewModel(mockMedicationRepository, TestDispatchers())
    }

    @Test
    fun `test medication list success`() = runTest {
        // Mock successful response
        val mockMedicationList = listOf(
            MedicationUiModel("Medication 1", "10mg", strength = "10mg"),
            MedicationUiModel("Medication 2", "20mg", strength = "20mg")
        )
        Mockito.`when`(mockMedicationRepository.getMedicationList()).thenReturn(
            flow {
                emit(
                    NetworkResult.Success(
                        MedicationRes(
                            problems = listOf(
                                Problem(
                                    diabetes = listOf(
                                        Diabete(
                                            medications = listOf(
                                                Medication(
                                                    medicationsClasses = listOf(
                                                        MedicationsClasses(
                                                            className = listOf(
                                                                ClassName(
                                                                    associatedDrug = listOf(
                                                                        AssociatedDrug(
                                                                            name = "Medication 1",
                                                                            strength = "10mg",
                                                                            dose = "10mg"
                                                                        )
                                                                    ),
                                                                    associatedDrug2 = listOf(
                                                                        AssociatedDrug(
                                                                            name = "Medication 2",
                                                                            strength = "20mg",
                                                                            dose = "20mg"
                                                                        )
                                                                    )
                                                                )
                                                            ),
                                                            className2 = listOf(
                                                                ClassName(
                                                                    associatedDrug = listOf(
                                                                        AssociatedDrug(
                                                                            name = "Drug 2",
                                                                            strength = "20mg",
                                                                            dose = "20mg"
                                                                        )
                                                                    ),
                                                                    associatedDrug2 = listOf(
                                                                        AssociatedDrug(
                                                                            name = "Drug 2",
                                                                            strength = "20mg",
                                                                            dose = "20mg"
                                                                        )
                                                                    )
                                                                )
                                                            )
                                                        )
                                                    )
                                                )
                                            ),
                                            labs = listOf(),
                                        )
                                    ), asthma = listOf()
                                )
                            )
                        )
                    )
                )
            })

        // Execute
        medicationListViewModel.getMedicationList()

        Mockito.verify(mockMedicationRepository).getMedicationList()
        // Verify
        assertEquals(
            medicationListViewModel.uiState.value.medicationList[0].toString(),
            mockMedicationList[0].toString()
        )
        assertEquals(
            medicationListViewModel.uiState.value.medicationList[1].toString(),
            mockMedicationList[1].toString()
        )
    }

    @Test
    fun `test medication list error`() = runTest {
        // Mock error response
        val errorMsg = "Failed to fetch medication list"

        `when`(mockMedicationRepository.getMedicationList()).thenReturn(
            flow { emit(NetworkResult.Error(400, errorMsg)) })

        // Execute
        medicationListViewModel.getMedicationList()


        // Verify
        Mockito.verify(mockMedicationRepository).getMedicationList()

        assertEquals(
            medicationListViewModel.uiState.value.error,
            errorMsg
        )
    }

    @Test
    fun `test medication list exception`() = runTest {
        // Mock exception response
        val exceptionMsg = "Network exception occurred"
        `when`(mockMedicationRepository.getMedicationList())
            .thenReturn(
                flow {
                    emit(NetworkResult.Exception(Exception(exceptionMsg)))
                })

        // Execute
        medicationListViewModel.getMedicationList()

        // Verify
        Mockito.verify(mockMedicationRepository).getMedicationList()

        assertEquals(
            medicationListViewModel.uiState.value.error,
            exceptionMsg
        )

    }
}