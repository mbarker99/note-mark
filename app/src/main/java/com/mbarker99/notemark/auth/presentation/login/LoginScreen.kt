package com.mbarker99.notemark.auth.presentation.login

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.window.core.layout.WindowWidthSizeClass
import com.mbarker99.notemark.R
import com.mbarker99.notemark.auth.presentation.welcome.AuthAction
import com.mbarker99.notemark.core.domain.util.DeviceConfiguration
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
    val rootModifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.primary)
        .padding(top = 40.dp)
        .clip(
            RoundedCornerShape(
                topStart = 15.dp,
                topEnd = 15.dp
            )
        )
        .background(MaterialTheme.colorScheme.surfaceContainerLowest)
        .padding(
            horizontal = 16.dp,
            vertical = 24.dp
        )
        .consumeWindowInsets(WindowInsets.navigationBars)

    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
    val deviceConfiguration = DeviceConfiguration.fromWindowSizeClass(windowSizeClass)
    when (deviceConfiguration) {
        DeviceConfiguration.MOBILE_PORTRAIT -> {
            Column(
                modifier = rootModifier,
                verticalArrangement = Arrangement.spacedBy(40.dp)
            ) {
                LoginHeaderSection()
                LoginFormSection(state, onAction)
            }
        }
        DeviceConfiguration.MOBILE_LANDSCAPE -> {
            Row(
                modifier = rootModifier
                    .windowInsetsPadding(WindowInsets.displayCutout)
                    .padding(horizontal = 32.dp),
                horizontalArrangement = Arrangement.spacedBy(64.dp)
            ) {
                LoginHeaderSection()
                LoginFormSection(state, onAction)
            }
        }
        DeviceConfiguration.TABLET_LANDSCAPE,
        DeviceConfiguration.TABLET_PORTRAIT,
        DeviceConfiguration.DESKTOP -> {
            Column(
                modifier = rootModifier
                    .verticalScroll(rememberScrollState())
                    .padding(top = 48.dp),
                verticalArrangement = Arrangement.spacedBy(40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LoginHeaderSection(alignment = Alignment.CenterHorizontally)
                LoginFormSection(
                    state,
                    onAction,
                    modifier = Modifier
                        .widthIn(max = 540.dp)
                )
            }
        }
    }
}

@Composable
fun LoginHeaderSection(
    modifier: Modifier = Modifier,
    alignment: Alignment.Horizontal = Alignment.Start

) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(6.dp),
        horizontalAlignment = alignment
    ) {
        Text(
            text = stringResource(R.string.log_in),
            style = MaterialTheme.typography.titleMedium
        )

        Text(
            text = stringResource(R.string.log_in_subtitle),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun LoginFormSection(
    state: LoginState,
    onAction: (LoginAction) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
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

@Preview
@Composable
private fun LoginScreenPreview() {
    NoteMarkTheme {
        LoginScreen(
            state = LoginState(
                email = "",
                password = "",
            ),
            onAction = {}
        )
    }

}