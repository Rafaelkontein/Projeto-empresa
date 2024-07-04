package com.example.projectrafa.ui.componente.EditText

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projectrafa.ui.componente.Text.textHint
import com.example.projectrafa.ui.componente.Text.textoTituloInput
import com.example.projectrafa.ui.theme.CoresProjeto

@Composable
fun inputTextCelular( textNome: String, placeHolder:String, onTextNomeChange: (String) -> Unit){
    Column {
        textoTituloInput(placeHolder)
        Box (modifier = Modifier.fillMaxWidth()){
            BasicTextField(
                value = textNome ,
                onValueChange = { onTextNomeChange(it)},

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
                    .height(56.dp)
                    .background(color = CoresProjeto.azulInput, shape = MaterialTheme.shapes.medium)
                    .border(
                        width = 1.dp,
                        color = if (textNome.length >= 1 && textNome.length <= 3) {
                            CoresProjeto.vermelho
                        } else {
                            CoresProjeto.transparente
                        }, shape = RoundedCornerShape(8.dp)
                    )
                    .padding(top = 17.dp, start = 25.dp),
                visualTransformation = PhoneVisualTransformation()
            )
            if (textNome.isEmpty()) {
                textHint(descrisicao = placeHolder)
            }

        }
    }

}

@Preview
@Composable
fun previewInpuCelular() {
    inputTextCelular("11943129558", "celular", {})
}

class PhoneVisualTransformation : VisualTransformation {
    @SuppressLint("SuspiciousIndentation")
    override fun filter(text: AnnotatedString): TransformedText {
        val phone = text.text.mapIndexed{index,c ->
            when(index){
                0-> "($c"
                1 -> "$c) "
                6 -> "$c-"
                else -> c
            }
        }.joinToString(separator = "")
        return TransformedText(AnnotatedString(phone), PhoneOffsetMapping)
    }

    object PhoneOffsetMapping: OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            return when{
                offset > 6 -> offset + 4
                offset > 1 -> offset + 3
                offset > 0 -> offset + 1
                else -> offset
            }
        }

        override fun transformedToOriginal(offset: Int): Int {
            return when{
                offset > 6 -> offset - 4
                offset > 1 -> offset - 3
                offset > 0 -> offset - 1
                else -> offset
            }
        }

    }

}


