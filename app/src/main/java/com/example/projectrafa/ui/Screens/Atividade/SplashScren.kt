package com.example.projectrafa.ui.Screens.Atividade

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.projectrafa.Presenter.Atividade.SplashScrenPresenter
import com.example.projectrafa.R
import com.example.projectrafa.ui.theme.CoresProjeto

@Composable
fun SplashScren(context: Context= LocalContext.current){
    val hasStarted = remember { mutableStateOf(false) }
    Box (modifier = Modifier
        .fillMaxSize()
        .background(CoresProjeto.azulPrincipal)){
        Image(painter = painterResource(id = R.drawable.logoprincipal),
            contentDescription = "logo Principal",
            modifier =  Modifier.align(Alignment.Center)
        )
    }
    
    if (!hasStarted.value){
        val splashScrenPresenter = SplashScrenPresenter()
        splashScrenPresenter.iniciaProximaTela(context)
        hasStarted.value = true

    }
}

@Preview (showSystemUi = true, showBackground = true)
@Composable
fun previewSplashScren(){

    SplashScren()
}