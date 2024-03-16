package com.example.projectrafa.ui.Screens.Atividade

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projectrafa.ui.componente.PartesScren.topoCadastro
import com.example.projectrafa.ui.componente.EditText.inputText

@Composable
fun ScrenDadosPessoais(act:Activity = Activity()){

    Column (
        Modifier
            .padding()
            .padding(top = 24.dp, start = 16.dp, end = 16.dp).verticalScroll(rememberScrollState())){

        topoCadastro("Dados Pessoais",act)
        Spacer(modifier = Modifier.height(32.dp))




        var textNome by remember { mutableStateOf("") }
        inputText(textNome,"Nome") { novoValor ->
            if (novoValor.length <12){
                textNome = novoValor
            }
        }
        Spacer(modifier = Modifier.height(32.dp))

        var textDataNascimento by remember { mutableStateOf("") }

        inputText(textDataNascimento,"Data de nacimento") { novoValor ->
            textDataNascimento = novoValor

        }



    }

}
@Preview(showSystemUi = true)
@Composable
fun ScrenDadosPessoaisPreciew() {
    ScrenDadosPessoais()
}

