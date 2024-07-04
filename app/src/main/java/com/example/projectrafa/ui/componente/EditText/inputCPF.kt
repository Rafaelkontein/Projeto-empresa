package com.example.projectrafa.ui.componente.EditText

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projectrafa.ui.componente.Text.textoTituloInput
import com.example.projectrafa.ui.theme.CoresProjeto
import com.example.projectrafa.utis.ValidaNumeros

@Composable
fun inputCPF(textCPF: String,onTextNomeChange: (String) -> Unit){
    Column {
        textoTituloInput(descrisicao = "CPF")
        Box (modifier = Modifier.fillMaxWidth()){
            BasicTextField(
                value = textCPF,
                onValueChange =  { onTextNomeChange(it)},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
                    .height(56.dp)
                    .background(color = CoresProjeto.azulInput, shape =  MaterialTheme.shapes.medium)
                    .border(width = 1.dp,
                        color = if(textCPF.length == 14
                            &&
                            ValidaNumeros.isCpfValid(textCPF.replace(".", "").replace("-", ""))){
                                      CoresProjeto.vermelho
                                    }else{
                                      CoresProjeto.azulInput
                                    },
                        shape =  MaterialTheme.shapes.medium).
                        padding(top = 17.dp,start = 25.dp),
                keyboardOptions  = KeyboardOptions(keyboardType = KeyboardType.Number),
                visualTransformation = CpfVisualTransformation()
            )

        }
    }
}

@Preview
@Composable
private fun previewInputCPF() {
    inputCPF("43327948852",{})
}

class CpfVisualTransformation : VisualTransformation {
    @SuppressLint("SuspiciousIndentation")
    override fun filter(text: AnnotatedString): TransformedText {
        val phone = text.text.mapIndexed{index,c ->
            when(index){
                2-> "$c."
                5 -> "$c."
                8 -> "$c-"
                else -> c
            }
        }.joinToString(separator = "")
        return TransformedText(AnnotatedString(phone), CpfOffsetMapping)
    }

    object CpfOffsetMapping: OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            return when{
                offset > 8 -> offset + 2
                offset > 5 -> offset + 1
                offset > 2 -> offset + 1
                else -> offset
            }
        }

        override fun transformedToOriginal(offset: Int): Int {
            return when{
                offset > 10 -> offset - 2
                offset > 6 -> offset - 1
                offset > 3 -> offset - 1
                else -> offset
            }
        }

    }

}