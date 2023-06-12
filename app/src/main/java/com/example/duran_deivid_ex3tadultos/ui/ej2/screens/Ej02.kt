package com.example.duran_deivid_ex3tadultos.ui.ej2.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.duran_deivid_ex3tadultos.R
import com.example.duran_deivid_ex3tadultos.ui.ej2.state.DialogError
import com.example.duran_deivid_ex3tadultos.ui.ej2.state.LoginViewModel


@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showSystemUi = true)
@Composable
fun Ej02() {
    val vm: LoginViewModel = viewModel()
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.login)) }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(space = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = email, onValueChange = { email = it.trim(); vm.clearEmailNotExists() },
                label = { Text(text = stringResource(R.string.email)) },
                isError = vm.emailNotExists
            )
            OutlinedTextField(
                value = password, onValueChange = { password = it.trim(); vm.clearPasswordNotCorrect() },
                label = { Text(text = stringResource(R.string.password)) },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                isError = vm.passwordNotCorrect
            )
            Button(onClick = { vm.signIn(email, password); }) {
                Text(text = "Log In")
            }
        }

        vm.dialogError?.let {
            AlertDialog(
                onDismissRequest = { vm.clearDialogError() },
                confirmButton = { Button(onClick = {vm.clearDialogError()}) { Text(text = "ok")} },
                text = { Text(text = when (it) {
                    DialogError.CORRECT -> "Log in correcto"
                    DialogError.ERROR_PASSWORD -> "Error en la contraseña"
                    DialogError.ERROR_EMAIL -> "Email no encontrado"
                })}
            )
        }
    }
}