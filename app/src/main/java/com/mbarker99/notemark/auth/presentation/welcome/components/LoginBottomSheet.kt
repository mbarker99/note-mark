package com.mbarker99.notemark.auth.presentation.welcome.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mbarker99.notemark.core.presentation.designsystem.buttons.FilledButton
import com.mbarker99.notemark.core.presentation.designsystem.textfields.BaseTextField
import com.mbarker99.notemark.core.presentation.designsystem.theme.NoteMarkTheme

@Composable
fun LoginBottomSheet(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
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
                text = "Log In",
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
                    text = email,
                    onValueChange = onEmailChange,
                    modifier = Modifier.fillMaxWidth(),
                    hintText = "john.doe@example.com",
                    labelText = "Email",
                )

                Spacer(Modifier.height(16.dp))

                BaseTextField(
                    text = email,
                    onValueChange = onEmailChange,
                    modifier = Modifier.fillMaxWidth(),
                    hintText = "Password",
                    labelText = "Password",
                    isPassword = true,
                )

                Spacer(Modifier.height(24.dp))

                FilledButton(
                    text = "Log in",
                    onClick = { },
                    enabled = false,
                    modifier = Modifier.fillMaxWidth(),
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Don't have an account?",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(16.dp)
                )
            }


        }

    }

}

@Preview
@Composable
private fun LoginBottomSheetPreview() {
    NoteMarkTheme {
        LoginBottomSheet(
            email = "",
            password = "",
            onEmailChange = {},
            onPasswordChange = {},
        )
    }
    
}