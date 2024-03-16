package com.example.projectrafa.ui.componente.botao

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectrafa.R
import com.example.projectrafa.ui.theme.CoresProjeto
import java.sql.Wrapper

@Composable
fun botaoAzulPadrao(descricaoButton:String,function:()-> Unit ){

    Button(onClick = function,
        colors = ButtonDefaults.buttonColors( CoresProjeto.azulPrincipal),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .height(45.dp)) {

        Text(text = descricaoButton,
            style = TextStyle(
                fontWeight = FontWeight(700),
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.opensansmedium),)
            )
        )
    }
}

@Composable
fun botaoBrancoPadrao(descricaoButton:String,function:()-> Unit){
    Button(onClick = function,
        colors = ButtonDefaults.buttonColors( CoresProjeto.branco),

        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .height(45.dp)) {

        Text(text = descricaoButton,
            style = TextStyle(
                color = CoresProjeto.azulPrincipal,
                fontWeight = FontWeight(700),
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.opensansmedium),)
            )
        )
    }
}

@Preview
@Composable
fun previewBotaoAzulPadrao() {
    botaoAzulPadrao("Teste Azul"){

    }

}

@Preview
@Composable
fun previewbotaoBrancoPadrao() {
    botaoBrancoPadrao("Teste Branco"){

    }
}