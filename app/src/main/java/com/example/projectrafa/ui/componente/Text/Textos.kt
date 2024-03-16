package com.example.projectrafa.ui.componente.Text

import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectrafa.R
import com.example.projectrafa.ui.theme.CoresProjeto


@Composable
fun TituloText(descrisicao:String,
               corestexto: androidx.compose.ui.graphics.Color = CoresProjeto.branco,
               modiferText:Modifier = Modifier.padding(top = 30.dp) ){

    Text(text = descrisicao,
        modifier = modiferText,
        style = TextStyle(
            color = corestexto,
            fontWeight = FontWeight(700),
            fontSize = 30.sp,
            lineHeight = 49.sp,
            fontFamily = FontFamily(Font(R.font.opensansmedium))
        ))
}

@Composable
fun textHint(descrisicao:String){
    Text(text = descrisicao,
        modifier = Modifier.offset(23.dp,30.dp),
        style = TextStyle(
            color = CoresProjeto.azul200,
            fontWeight = FontWeight(400),
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.opensansmedium))
        ))
}

@Composable
fun textoTituloInput(descrisicao: String){
    Text(text = descrisicao,
        style = TextStyle(
            color = CoresProjeto.cinza600,
            fontWeight = FontWeight(400),
            fontSize = 14.sp,
            lineHeight = 49.sp,
            fontFamily = FontFamily(Font(R.font.opensansmedium))
        ))
}

@Preview
@Composable
fun prevTituloText() {
    TituloText(descrisicao = "Teste Preview")
    textHint("Teste")
}