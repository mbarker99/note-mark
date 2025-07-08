package com.mbarker99.notemark.auth.presentation.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mbarker99.notemark.R
import com.mbarker99.notemark.auth.presentation.welcome.components.WelcomeBottomSheet
import com.mbarker99.notemark.core.presentation.designsystem.theme.NoteMarkTheme
import org.koin.androidx.compose.koinViewModel


@Composable
fun WelcomeScreenRoot(
    onNavigateToLogin: () -> Unit,
    onNavigateToRegister: () -> Unit,
) {

    WelcomeScreen(
        onAction = { action ->
            when (action) {
                AuthAction.OnLogInClick -> onNavigateToLogin()
                AuthAction.OnGetStartedClick -> onNavigateToRegister()
                else -> Unit
            }
        }
    )
}


@Composable
fun WelcomeScreen(
    onAction: (AuthAction) -> Unit
) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color(0xFFE0EAFF)
                )
                .padding(innerPadding)
        ) {
            Image(
                painter = painterResource(R.drawable.welcome_doodles),
                contentDescription = null,
                modifier = Modifier.weight(1f).fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )

            Surface(
                modifier = Modifier.clip(RoundedCornerShape(20.dp))
            ) {
                WelcomeBottomSheet(
                    onGetStartedClicked = { onAction(AuthAction.OnGetStartedClick) },
                    onLogInClicked = { onAction(AuthAction.OnLogInClick) }
                )
            }
        }
    }
}

@Preview
@Composable
private fun WelcomeScreenPreview() {
    NoteMarkTheme {
        WelcomeScreen(
            onAction = { }
        )
    }

}