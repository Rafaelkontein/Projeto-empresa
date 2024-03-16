package com.example.projectrafa.ui.componente.PartesScren

import android.app.Activity
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projectrafa.R
import com.example.projectrafa.ui.componente.Text.TituloText
import com.example.projectrafa.ui.theme.CoresProjeto


@Composable
fun topoCadastro(descricaoTopo:String, context: Activity = Activity()){
    Column {
        Image(painter = painterResource(id = R.drawable.seta_voltar),
            contentDescription = "Voltar",
            Modifier.clickable {
                context.finish()
            })

        TituloText(descricaoTopo, CoresProjeto.preto, Modifier.padding(top = 30.dp))
    }
}
@Preview
@Composable
fun topoCadastroPreview() {
    topoCadastro("Teste")
}