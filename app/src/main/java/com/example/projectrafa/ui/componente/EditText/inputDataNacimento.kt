package com.example.projectrafa.ui.componente.EditText

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projectrafa.Recursos.TextoAndroid
import com.example.projectrafa.ui.componente.Text.textoTituloInput
import com.example.projectrafa.ui.theme.CoresProjeto

@Composable
fun inputTextDataNacimento(textDataNacimento: String, onChangTextData:(String) -> Unit){
    Column {
        textoTituloInput(descrisicao = TextoAndroid.dataDeNacimento)
        BasicTextField(
            value = textDataNacimento,
            onValueChange = onChangTextData,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
                .height(56.dp)
                .background(color = CoresProjeto.azulInput, shape = MaterialTheme.shapes.medium)
                .border(
                    width = 1.dp,
                    color = if (textDataNacimento.length >= 10) {
                        CoresProjeto.vermelho
                    } else {
                        CoresProjeto.azulInput
                    }, shape = RoundedCornerShape(8.dp)
                )
                .padding(top = 17.dp, start = 25.dp),
            keyboardOptions  = KeyboardOptions(keyboardType = KeyboardType.Number),
            visualTransformation = DateVisualTransformation()

            )
    }

}

@Preview
@Composable
private fun previewInputDataNacimento( ) {
    inputTextDataNacimento(textDataNacimento = "23082000", onChangTextData = {})

}

class DateVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val date = text.text.mapIndexed { index, c ->
            when (index) {
                1 -> "$c/"
                3 -> "$c/"
                else -> c
            }
        }.joinToString(separator = "")
        return TransformedText(AnnotatedString(date), DateOffsetMapping)
    }

    object DateOffsetMapping : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            return when {
                offset > 3 -> offset + 2
                offset > 1 -> offset + 1
                else -> offset
            }
        }

        override fun transformedToOriginal(offset: Int): Int {
            return when {
                offset > 4 -> offset - 2
                offset > 2 -> offset - 1
                else -> offset
            }
        }
    }
}