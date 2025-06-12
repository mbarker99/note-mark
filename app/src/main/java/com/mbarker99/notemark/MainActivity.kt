package com.mbarker99.notemark

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModel
import com.mbarker99.notemark.auth.presentation.welcome.WelcomeScreen
import com.mbarker99.notemark.auth.presentation.welcome.WelcomeViewModel
import com.mbarker99.notemark.core.presentation.designsystem.theme.NoteMarkTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            NoteMarkTheme {
                    WelcomeScreen()
            }
        }
    }
}