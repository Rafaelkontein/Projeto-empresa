package com.example.projectrafa.ui.Screens.Atividade

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.magnifier
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projectrafa.R
import com.example.projectrafa.ui.Atividade.ActDadosPessoais
import com.example.projectrafa.ui.componente.Text.TituloText
import com.example.projectrafa.ui.componente.botao.botaoAzulPadrao
import com.example.projectrafa.ui.componente.botao.botaoBrancoPadrao


@Composable
fun AprentacaoScren(context: Context = LocalContext.current){
    Box (modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.img_fundo),
            contentDescription ="img fundo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column( modifier = Modifier.padding(start = 20.dp, top = 36.dp)) {

            Image(painter = painterResource(id = R.drawable.logo_invertido),
                contentDescription ="logo invertido",
                )

            TituloText("Bem Vindo!")
        }

        Column (modifier = Modifier.align(Alignment.BottomCenter).padding(start = 16.dp, end = 16.dp)){
             botaoAzulPadrao(descricaoButton = "Cadastrar") {
                 context.startActivity(Intent(context,ActDadosPessoais::class.java))
             }

            botaoBrancoPadrao(descricaoButton = "Entrar") {

            }
        }


    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun previewAprensentacao() {
    AprentacaoScren()
}