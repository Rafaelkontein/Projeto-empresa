package com.example.projectrafa.ui.Atividade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.projectrafa.ui.Atividade.ui.theme.ProjectRafaTheme
import com.example.projectrafa.ui.Screens.Atividade.ScrenDadosPessoais

class ActDadosPessoais : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectRafaTheme {
                ScrenDadosPessoais(this)

            }
        }
    }
}

