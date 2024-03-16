package com.example.projectrafa.ui.Atividade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.projectrafa.ui.Screens.Atividade.SplashScren
import com.example.projectrafa.ui.theme.ProjectRafaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectRafaTheme {
                    SplashScren(this)
            }
        }
    }
}
