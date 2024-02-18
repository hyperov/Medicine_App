package com.hyper.medicineapp.feature_login.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hyper.medicineapp.R
import com.hyper.medicineapp.feature_login.presentation.viewmodel.LoginViewModel

@Composable
fun LoginScreen(onNavigateToHome: () -> Unit, loginViewModel: LoginViewModel = hiltViewModel()) {


    var passwordVisible by rememberSaveable { mutableStateOf(false) }


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Medication", style = MaterialTheme.typography.h3,
            color = Color.Magenta,
            modifier = Modifier.padding(top = 80.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.login2),
            contentDescription = null,
            modifier = Modifier.weight(1f)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(48.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutlinedTextField(
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Face,
                        tint = Color.Magenta,
                        contentDescription = null
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color.DarkGray,
                    textColor = MaterialTheme.colors.primary,
                    backgroundColor = Color.Transparent,
                    unfocusedLabelColor = Color.Black
                ),
                placeholder = {
                    Text(stringResource(R.string.placeholder_username))
                },
                value = loginViewModel.userName,
                onValueChange = { loginViewModel.userName = it },
                label = { Text(text = stringResource(R.string.username_label)) },
                shape = RoundedCornerShape(16.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),

                )

            OutlinedTextField(
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color.DarkGray,
                    textColor = MaterialTheme.colors.primary,
                    backgroundColor = Color.Transparent,
                    unfocusedLabelColor = Color.Black
                ), trailingIcon = {
                    if (passwordVisible) {
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                imageVector = Icons.Filled.Visibility,
                                tint = Color.Magenta,
                                contentDescription = null
                            )
                        }
                    } else {
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                imageVector = Icons.Filled.VisibilityOff,
                                tint = Color.Magenta,
                                contentDescription = null
                            )
                        }
                    }
                },
                placeholder = {
                    Text(stringResource(R.string.placeholder_password))
                },
                value = loginViewModel.pass,
                onValueChange = { loginViewModel.pass = it },
                label = { Text(text = stringResource(R.string.password_label)) },
                shape = RoundedCornerShape(16.dp),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            Button(onClick = {
                if (loginViewModel.userName.isNotEmpty() && loginViewModel.pass.isNotEmpty()) {
                    onNavigateToHome()
                }
            }, shape = RoundedCornerShape(8.dp)) {
                Text(
                    text = stringResource(R.string.login_label),
                    modifier = Modifier.padding(horizontal = 64.dp)
                )
            }

        }
    }
}