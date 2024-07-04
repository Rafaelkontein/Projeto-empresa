package com.example.projectrafa.utis

class ValidaNumeros {
    companion object {
        fun isCpfValid(cpf: String): Boolean {
            val cpfClean = cpf.replace(".", "").replace("-", "")

            if (cpfClean.length != 11 || cpfClean.any { !it.isDigit() }) {
                return false
            }

            // Verificar se todos os dígitos são iguais
            if (cpfClean.toSet().size == 1) {
                return false
            }

            // Calcular o primeiro dígito verificador
            val digit1 = cpfClean.substring(9, 10).toInt()
            val sum1 = (0..8).sumBy { cpfClean[it].toString().toInt() * (10 - it) }
            val remainder1 = (sum1 % 11) % 10

            // Calcular o segundo dígito verificador
            val digit2 = cpfClean.substring(10, 11).toInt()
            val sum2 = (0..9).sumBy { cpfClean[it].toString().toInt() * (11 - it) }
            val remainder2 = (sum2 % 11) % 10

            return digit1 == remainder1 && digit2 == remainder2
        }

    }
}
