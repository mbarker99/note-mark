package com.mbarker99.notemark.auth.presentation.welcome.components

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mbarker99.notemark.core.presentation.designsystem.buttons.FilledButton
import com.mbarker99.notemark.core.presentation.designsystem.buttons.OutlinedButton
import com.mbarker99.notemark.core.presentation.designsystem.textfields.BaseTextField
import com.mbarker99.notemark.core.presentation.designsystem.theme.NoteMarkTheme

@Composable
fun RegisterBottomSheet(
    username: String,
    email: String,
    password: String,
    confirmPassword: String,
    onUsernameChanged: (String) -> Unit,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onConfirmPasswordChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        Modifier
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.surfaceContainerLowest)
            .padding(horizontal = 16.dp)
            .padding(top = 32.dp)
            .padding(bottom = 16.dp)
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
                    text = username,
                    onValueChange = onUsernameChanged,
                    modifier = Modifier.fillMaxWidth(),
                    hintText = "john.doe",
                    labelText = "Username",
                )
                Spacer(modifier = Modifier.height(16.dp))

                BaseTextField(
                    text = email,
                    onValueChange = onEmailChanged,
                    modifier = Modifier.fillMaxWidth(),
                    hintText = "john.doe@example.com",
                    labelText = "Email",
                )
                Spacer(modifier = Modifier.height(16.dp))

                BaseTextField(
                    text = password,
                    onValueChange = onPasswordChanged,
                    modifier = Modifier.fillMaxWidth(),
                    hintText = "Password",
                    labelText = "Password",
                )
                Spacer(modifier = Modifier.height(16.dp))

                BaseTextField(
                    text = confirmPassword,
                    onValueChange = onConfirmPasswordChanged,
                    modifier = Modifier.fillMaxWidth(),
                    hintText = "Password",
                    labelText = "Repeat password",
                )

                Spacer(modifier = Modifier.height(24.dp))


                FilledButton(
                    text = "Create account",
                    onClick = { },
                    enabled = false,
                    modifier = Modifier.fillMaxWidth(),
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Already have an account?",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }


        }

    }

}

@Preview
@Composable
private fun RegisterBottomSheetPreview() {
    NoteMarkTheme {
        RegisterBottomSheet(
            username = "",
            email = "",
            password = "",
            confirmPassword = "",
            onUsernameChanged = { },
            onEmailChanged = { },
            onPasswordChanged = { },
            onConfirmPasswordChanged = { }
        )
    }

}