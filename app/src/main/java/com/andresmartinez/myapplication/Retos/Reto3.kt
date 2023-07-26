package com.andresmartinez.myapplication.Retos

class Reto3 {
}

fun main() {
    println("Bienvenido a la chamba")
    println("¿Quiere ingresar a nuestro sistema? \n 1 Si \n" +
            " 2 No")
    var ap: Int = readLine()!!.toInt()

    val carros = mutableListOf("ROLL ROYCE", "NISSAN GTR34", "BMW AMG CLASE G", "PORSCHE GT3R 911")

    while (ap == 1) {
        println("Elige la opción que deseas: \n 1. Insertar un nuevo auto \n" +
                " 2. Mostrar los automóviles \n" +
                " 3. Buscar un carro en particular \n" +
                " 4. Modificar un automóvil en existencia \n" +
                " 5. Eliminar un vehículo en existencia \n" +
                " 6. Salir")

        val opcion: Int = readLine()!!.toInt()

        when (opcion) {
            1 -> {
                println("Inserte la marca del carro.")
                val nuevo: String = readLine()!!
                if (carros.contains(nuevo)) {
                    println("El automóvil ya está en la lista.")
                } else {
                    carros.add(nuevo)
                    println("Automóvil agregado correctamente.")
                }
            }
            2 -> {
                println("Listado de automóviles:")
                println(carros)
            }
            3 -> {
                println("Ingrese la posición del automóvil a buscar:")
                val Buscar: Int = readLine()!!.toInt()
                if (Buscar in 0 until carros.size) {
                    val marca: String = carros[Buscar]
                    println("La marca del automóvil es: $marca")
                } else {
                    println("Posición inválida.")
                }

            }
            4 -> {
                println("Ingrese la posición del automóvil a modificar:")
                val Modificar: Int = readLine()!!.toInt()
                if (Modificar in 0 .. carros.size) {
                    println("Ingrese la nueva marca del automóvil:")
                    val nuevaMarca: String = readLine()!!
                    carros[Modificar] = nuevaMarca
                    println("Automóvil modificado correctamente.")
                } else {
                    println("Posición inválida.")
                }
            }
            5 -> {
                println("Ingrese la posición del automóvil a eliminar:")
                val Eliminar: Int = readLine()!!.toInt()
                if (Eliminar in 0 .. carros.size) {
                    carros.removeAt(Eliminar)
                    println("Automóvil eliminado correctamente.")
                } else {
                    println("Posición inválida.")
                }
            }
            6 -> {
                println("Gracias por usar la chamba :D")
                ap = 0
            }
            else -> {
                println("Opción inválida.")
            }
        }
    }
}


