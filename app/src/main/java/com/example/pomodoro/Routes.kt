package com.example.pomodoro


//gidebileceğimiz iki ekranı tanımladık
sealed class Routes(val route: String) {
    object Home : Routes("home")
    object Settings : Routes("setting")
}