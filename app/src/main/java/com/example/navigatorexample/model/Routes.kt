package com.example.navigatorexample.model

sealed class Routes(val route:String ){
    object MainScreen:Routes("Screen1")
    object Pantalla2:Routes("Screen2")
    object Pantalla3:Routes("Screen3")
    object PantallaConArgOblligatorios:Routes("Screen4/{name}"){
        fun createRoute(name:String) = "screen4/$name"
    }
    object PantallaFinal:Routes("PantallaFinal?age={age}"){
        fun createRoute(age:Int) = "PantallaFinal?age=$age"

    }
}