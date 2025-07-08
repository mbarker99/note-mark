package com.mbarker99.notemark.auth.presentation.login

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mbarker99.notemark.R
import com.mbarker99.notemark.auth.presentation.welcome.AuthAction
import com.mbarker99.notemark.core.presentation.designsystem.BaseHyperLink
import com.mbarker99.notemark.core.presentation.designsystem.buttons.FilledButton
import com.mbarker99.notemark.core.presentation.designsystem.textfields.BaseTextField
import com.mbarker99.notemark.core.presentation.designsystem.textfields.model.TextFieldType
import com.mbarker99.notemark.core.presentation.designsystem.theme.NoteMarkTheme
import com.mbarker99.notemark.core.presentation.util.ObserveAsEvents
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreenRoot(
    onNavigateToRegister: () -> Unit,
    viewModel: LoginViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    val context = LocalContext.current
    ObserveAsEvents(viewModel.events) { event ->
        when (event) {
            LoginEvent.OnLoginSuccessful -> {
                Toast.makeText(context, "Login successful.", Toast.LENGTH_LONG).show()
            }
            LoginEvent.OnLoginFailed -> {
                Toast.makeText(context, "Login successful.", Toast.LENGTH_LONG).show()
            }
        }
    }

    LoginScreen(
        state = state,
        onAction = { action ->
            when (action) {
                LoginAction.OnDontHaveAnAccountClicked -> onNavigateToRegister()
                else -> Unit
            }
            viewModel.onAction(action)
        }
    )
}

@Composable
fun LoginScreen(
    state: LoginState,
    onAction: (LoginAction) -> Unit
) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surfaceContainerLowest)
                .padding(horizontal = 16.dp)
                .padding(top = 32.dp)
                .padding(bottom = 16.dp)
                .padding(innerPadding),
            verticalArrangement = Arrangement.Top,
        ) {
            Text(
                text = stringResource(R.string.log_in),
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = stringResource(R.string.log_in_subtitle),
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(40.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                BaseTextField(
                    text = state.email,
                    onValueChange = { onAction(LoginAction.OnEmailChanged(it)) },
                    modifier = Modifier.fillMaxWidth(),
                    hintText = stringResource(R.string.email_hint),
                    labelText = stringResource(R.string.email_label),
                    type = TextFieldType.EMAIL
                )

                Spacer(Modifier.height(16.dp))

                BaseTextField(
                    text = state.password,
                    onValueChange = { onAction(LoginAction.OnPasswordChanged(it)) },
                    modifier = Modifier.fillMaxWidth(),
                    hintText = stringResource(R.string.password),
                    labelText = stringResource(R.string.password),
                    isPassword = true,
                    type = TextFieldType.PASSWORD
                )

                Spacer(Modifier.height(24.dp))

                FilledButton(
                    text = stringResource(R.string.log_in),
                    onClick = { onAction(LoginAction.OnLogInClicked) },
                    enabled = state.isConfirmButtonEnabled,
                    modifier = Modifier.fillMaxWidth(),
                )

                Spacer(modifier = Modifier.height(12.dp))

                BaseHyperLink(
                    text = stringResource(R.string.dont_have_an_account),
                    onClick = { onAction(LoginAction.OnDontHaveAnAccountClicked) },
                    modifier = Modifier.padding(16.dp)
                )
            }


        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    NoteMarkTheme {
        LoginScreen(
            state = LoginState(
                email = "michael.barker@email.com",
                password = "",
            ),
            onAction = {}
        )
    }

}