package com.mbarker99.notemark.auth.presentation.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mbarker99.notemark.auth.presentation.welcome.AuthAction
import com.mbarker99.notemark.core.presentation.designsystem.BaseHyperLink
import com.mbarker99.notemark.core.presentation.designsystem.buttons.FilledButton
import com.mbarker99.notemark.core.presentation.designsystem.textfields.BaseTextField
import com.mbarker99.notemark.core.presentation.designsystem.textfields.model.TextFieldType
import org.koin.androidx.compose.koinViewModel

@Composable
fun RegisterScreenRoot(
    onNavigateToLogin: () -> Unit,
    viewModel: RegisterViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    RegisterScreen(
        state = state,
        onAction = { action ->
            when (action) {
                RegisterAction.OnAlreadyHaveAnAccountClicked -> onNavigateToLogin()
                else -> Unit
            }
            viewModel.onAction(action)
        }
    )
}

@Composable
fun RegisterScreen(
    state: RegisterState,
    onAction: (RegisterAction) -> Unit
) {
    Scaffold { innerPadding ->
        Box(
            Modifier
                .fillMaxHeight()
                .background(MaterialTheme.colorScheme.surfaceContainerLowest)
                .padding(horizontal = 16.dp)
                .padding(top = 32.dp)
                .padding(bottom = 16.dp)
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
            ) {
                Text(
                    text = "Create account",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Capture your thoughts and ideas.",
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(modifier = Modifier.height(40.dp))

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    BaseTextField(
                        text = state.username,
                        onValueChange = { onAction(RegisterAction.OnUsernameChanged(it)) },
                        modifier = Modifier.fillMaxWidth(),
                        hintText = "john.doe",
                        labelText = "Username",
                        type = TextFieldType.USERNAME
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    BaseTextField(
                        text = state.email,
                        onValueChange = { onAction(RegisterAction.OnEmailChanged(it)) },
                        modifier = Modifier.fillMaxWidth(),
                        hintText = "john.doe@example.com",
                        labelText = "Email",
                        type = TextFieldType.EMAIL
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    BaseTextField(
                        text = state.password,
                        onValueChange = { onAction(RegisterAction.OnPasswordChanged(it)) },
                        modifier = Modifier.fillMaxWidth(),
                        hintText = "Password",
                        labelText = "Password",
                        isPassword = true,
                        type = TextFieldType.PASSWORD
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    BaseTextField(
                        text = state.confirmPassword,
                        onValueChange = { onAction(RegisterAction.OnConfirmPasswordChanged(it)) },
                        modifier = Modifier.fillMaxWidth(),
                        hintText = "Password",
                        labelText = "Repeat password",
                        isPassword = true,
                        type = TextFieldType.PASSWORD
                    )

                    Spacer(modifier = Modifier.height(24.dp))


                    FilledButton(
                        text = "Create account",
                        onClick = { },
                        enabled = false,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    BaseHyperLink(
                        text = "Already have an account?",
                        onClick = { onAction(RegisterAction.OnAlreadyHaveAnAccountClicked) },
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}