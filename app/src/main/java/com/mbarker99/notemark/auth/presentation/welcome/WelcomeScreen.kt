package com.mbarker99.notemark.auth.presentation.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.mbarker99.notemark.R
import com.mbarker99.notemark.auth.presentation.welcome.components.LoginBottomSheet
import com.mbarker99.notemark.auth.presentation.welcome.components.RegisterBottomSheet
import com.mbarker99.notemark.auth.presentation.welcome.components.WelcomeBottomSheet
import com.mbarker99.notemark.core.presentation.designsystem.theme.NoteMarkTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier
) {
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false,
        confirmValueChange = { newState ->
            newState != SheetValue.Hidden
        }
    )

    val coroutineScope = rememberCoroutineScope()
    var currentScreen by remember { mutableStateOf(BottomSheetContent.Welcome) }

    // Launch the sheet on first display
    LaunchedEffect(Unit) {
        sheetState.partialExpand() // Start partially expanded
    }

    ModalBottomSheet(
        onDismissRequest = {
            coroutineScope.launch {
                currentScreen = BottomSheetContent.Welcome
                sheetState.partialExpand()
            }
        },
        sheetState = sheetState,
        dragHandle = null
    ) {
        when (currentScreen) {
            BottomSheetContent.Welcome -> {
                WelcomeBottomSheet(
                    onGetStartedClicked = {
                        coroutineScope.launch {
                            currentScreen = BottomSheetContent.Register
                            sheetState.expand()
                        }
                    },
                    onLogInClicked = {
                        coroutineScope.launch {
                            currentScreen = BottomSheetContent.Login
                            sheetState.expand()
                        }
                    }
                )
            }

            BottomSheetContent.Login -> LoginBottomSheet(
                email = "",
                password = "",
                onEmailChange = { },
                onPasswordChange = { }
            )

            BottomSheetContent.Register -> RegisterBottomSheet(
                username = "",
                email = "",
                password = "",
                confirmPassword = "",
                onUsernameChanged = { },
                onEmailChanged = { },
                onPasswordChanged = {},
                onConfirmPasswordChanged = { },
            )
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.welcome_doodles),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }


}

@Preview
@Composable
private fun WelcomeScreenPreview() {
    NoteMarkTheme {
        WelcomeScreen()
    }

}