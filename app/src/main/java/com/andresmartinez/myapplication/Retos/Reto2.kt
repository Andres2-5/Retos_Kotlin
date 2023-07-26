package com.andresmartinez.myapplication.Retos

import kotlin.random.Random

class Reto2 {
}

fun main(){
    println("Realice una compra mayor a $50.000 para participar en nuestro sorteo.")
    print("cuantos productos desea ingresar?: ")
    var num: Int = readLine()!!.toInt()

    var random = Random.nextInt(1,5)

    var descuento: Double
    var contador=0
    var contador1=0
    var total=0
    var contador2=0
    var total1=0

    while(num > contador2){
        print("ingrese el precio del producto: ")

        var precio: Int = readLine()!!.toInt()

        if (precio > 50000 ){
            println("has ingresado al sorteo")

            total += precio

        }
        when (random) {
            1 -> {
                println("Ha sacado una bola amarilla. Obtendrá un 50% de descuento.")
                descuento = 0.5
            }
            2 -> {
                println("Ha sacado una bola roja. Obtendrá un 10% de descuento.")
                descuento = 0.1
            }
            3 -> {
                println("Ha sacado una bola azul. Obtendrá un 30% de descuento.")
                descuento = 0.3
            }
            else -> {
                println("Ha sacado una bola blanca. Su compra es GRATIS.")
                descuento = 1.0
            }
        }


        contador2++
    }
    println("el numero de pares es $contador y el numero de impares es $contador1")
    println("el numero sumado de pares es $total y el numero de impares sumado es $total1")

}
