package com.andresmartinez.myapplication.Retos

class Reto1 {
}

fun main(){
    var dadoUno : Int = (1..6).random() // Generación de números aleatorios
    var dadoDos : Int = (1..6).random() // Generación de números aleatorios
    println("Dado #1: $dadoUno , Dado #2: $dadoDos")

    if(dadoUno == 1 && dadoDos == 1){
        println("Usted sacó un par de unos , ganó!")
    }
    else if (dadoUno + dadoDos == 3){
        println("Usted sacó un total de 3 en sus dados , ganó!")
    }
    else if (dadoUno + dadoDos == 1){
        println("Usted sacó un total de 11 en sus dados , ganó!")
    }
    else if (dadoUno + dadoDos == 2 ){
        println("Usted sacó un total de 2 en sus dados , ganó!")
    }
    else if (dadoUno + dadoDos == 12 ){
        println("Usted sacó un total de 12 en sus dados , ganó!")
    }
    else if (dadoUno + dadoDos == 7 ){
        println("Usted sacó un total de 7 en sus dados , ganó!")
    }
    else{
        println("Sus dados no obtuvieron ningun resultado ganador , perdió :( ")
    }
}