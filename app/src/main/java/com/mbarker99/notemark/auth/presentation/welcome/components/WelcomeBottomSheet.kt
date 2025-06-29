package com.mbarker99.notemark.auth.presentation.welcome.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mbarker99.notemark.core.presentation.designsystem.buttons.FilledButton
import com.mbarker99.notemark.core.presentation.designsystem.buttons.OutlinedButton
import com.mbarker99.notemark.core.presentation.designsystem.theme.NoteMarkTheme

@Composable
fun WelcomeBottomSheet(
    onGetStartedClicked: () -> Unit,
    onLogInClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        Modifier
            .background(MaterialTheme.colorScheme.surfaceContainerLowest)
            .padding(horizontal = 16.dp)
            .padding(top = 32.dp)
            .padding(bottom = 16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Your Own Collection of Notes",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Capture your thoughts and ideas.",
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(40.dp))

            FilledButton(
                text = "Get Started",
                onClick = onGetStartedClicked,
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedButton(
                text = "Log In",
                onClick = onLogInClicked,
                modifier = Modifier.fillMaxWidth(),
            )

        }

    }
}

@Preview
@Composable
private fun WelcomeBottomSheetPreview() {
    NoteMarkTheme {
        WelcomeBottomSheet(
            onGetStartedClicked = {},
            onLogInClicked = {}
        )
    }
    
}