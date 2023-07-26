package com.andresmartinez.myapplication.Retos

class Nequi {
    private var saldoDisponible: Double = 6500.0

    fun acceder(celular: String, clave: String) {
        var intentos = 3

        while (intentos > 0) {
            println("Ingrese su número de celular:")
            val inputCelular: String = readLine()!!
            println("Ingrese su clave de 4 dígitos:")
            val inputClave: String = readLine()!!

            if (inputCelular == celular && inputClave == clave) {
                println("¡Bienvenido a Nequi!")
                return // Sale de la función si el acceso es exitoso
            } else {
                intentos--
                if (intentos > 0) {
                    println("Los datos no son correctos. Cuenta con $intentos intentos más.")
                } else {
                    println("Los datos ingresados no son correctos. Ya no tienes intentos")
                }
            }
        }
    }

    fun mostrarSaldo() {
        println("Su saldo es: $saldoDisponible")
    }

    fun sacar() {
        println("Elige una opción para sacar dinero:")
        println("1. Cajero")
        println("2. Punto físico")

        var opcion: Int? = null

        while (opcion == null) {
            val input: String = readLine()!!
            opcion = input.toIntOrNull()

            if (opcion == null || opcion !in 1..2) {
                println("Opción inválida. Intente de nuevo.")
                opcion = null
            }
        }

        if (saldoDisponible < 2000) {
            println("No te alcanza para hacer el retiro.")
        } else {
            println("Ingrese el monto a retirar:")
            var monto: Double? = null

            while (monto == null || monto <= 0 || monto > saldoDisponible) {
                val input: String = readLine()!!
                monto = input.toDoubleOrNull()

                if (monto == null || monto <= 0 || monto > saldoDisponible) {
                    println("Monto inválido. Intente de nuevo.")
                } else if ((opcion == 1 || opcion == 2) && monto < 3000) {
                    println("El monto a retirar debe ser mayor a 3000.")
                    monto = null
                }
            }

            println("Confirmar retiro de $monto:")
            var confirmacion: Int? = null

            while (confirmacion == null || confirmacion !in 1..2) {
                val input: String = readLine()!!
                confirmacion = input.toIntOrNull()

                if (confirmacion == null || confirmacion !in 1..2) {
                    println("Opción inválida. Intente de nuevo.")
                }
            }

            if (confirmacion == 1) {
                saldoDisponible -= monto
                val codigoRetiro = (100000..999999).random()
                println("Retiro exitoso. Código de retiro: $codigoRetiro")
            } else {
                println("Retiro cancelado.")
            }
        }
    }


    fun enviar() {
        val celularPattern = Regex("^3\\d{9}$")

        println("Ingrese el número de teléfono al que desea enviar dinero:")
        var numeroTelefono: String? = null

        while (numeroTelefono == null || !celularPattern.matches(numeroTelefono)) {
            val input: String = readLine()!!
            numeroTelefono = input.trim()

            if (numeroTelefono.length != 10 || !celularPattern.matches(numeroTelefono)) {
                println("Número de teléfono inválido. Debe tener 10 dígitos y comenzar con el prefijo '3'. Intente de nuevo.")
            }
        }

        println("Ingrese el valor a enviar:")
        var valorEnviar: Double? = null

        while (valorEnviar == null || valorEnviar <= 0 || valorEnviar > saldoDisponible) {
            val input: String = readLine()!!
            valorEnviar = input.toDoubleOrNull()

            if (valorEnviar == null || valorEnviar <= 0 || valorEnviar > saldoDisponible) {
                println("Valor inválido. Intente de nuevo.")
            }
        }

        if (valorEnviar <= saldoDisponible) {
            saldoDisponible -= valorEnviar
            println("Envío de dinero exitoso a $numeroTelefono por valor de $valorEnviar")
        } else {
            println("No es posible enviar el dinero. Saldo insuficiente.")
        }
    }


    fun recargar() {
        println("Ingrese el valor a recargar:")
        var valorRecarga: Double? = null

        while (valorRecarga == null || valorRecarga <= 0) {
            val input: String = readLine()!!
            valorRecarga = input.toDoubleOrNull()

            if (valorRecarga == null || valorRecarga <= 0) {
                println("Valor inválido. Intente de nuevo.")
            }
        }

        println("¿Desea realizar la recarga por valor de $valorRecarga? \n1 Si \n" +
                "2 No")
        var confirmacion: Int? = null

        while (confirmacion == null || confirmacion !in 1..2) {
            val input: String = readLine()!!
            confirmacion = input.toIntOrNull()

            if (confirmacion == null || confirmacion !in 1..2) {
                println("Opción inválida. Intente de nuevo.")
            }
        }

        if (confirmacion == 1) {
            saldoDisponible += valorRecarga
            println("Recarga exitosa. Nuevo saldo: $saldoDisponible")
        } else {
            println("Recarga cancelada.")
        }
    }
}

fun main() {
    val celular = "3052823381"
    val clave = "9876"
    val nequi = Nequi()
    nequi.acceder(celular, clave)

    var continuar = true

    while (continuar) {
        println("¿Qué acción desea realizar?")
        println("1. Mostrar saldo")
        println("2. Sacar dinero")
        println("3. Enviar dinero")
        println("4. Recargar")
        println("5. Salir")

        val opcion: Int = readLine()!!.toInt()

        when (opcion) {
            1 -> nequi.mostrarSaldo()
            2 -> nequi.sacar()
            3 -> nequi.enviar()
            4 -> nequi.recargar()
            5 -> {
                println("Saliendo de Nequi...")
                continuar = false
            }
            else -> println("Opción inválida. Intente de nuevo.")
        }
    }
}
