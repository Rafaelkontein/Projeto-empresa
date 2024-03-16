package com.example.projectrafa.Presenter.Atividade

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import com.example.projectrafa.ui.Atividade.ActAprenstacao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScrenPresenter {


    fun iniciaProximaTela(context:Context){
        CoroutineScope(Dispatchers.IO).launch {
            delay(3000)
            MainScope().launch {
                context.startActivity(Intent(context,ActAprenstacao::class.java))
            }
        }
    }
}