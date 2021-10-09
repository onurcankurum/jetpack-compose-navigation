package com.example.pomodoro

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun Settings(counter: String?,navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White), contentAlignment = Alignment.Center
    ) {
        Column {

            Text(text = "argümanla geldiniz", Modifier.padding(10.dp), color = Color.Black)

            //Display the counter
            Text(
                text = "argümanınız $counter",
                Modifier.padding(10.dp),
                color = Color.Black
            )
            Button(onClick = { 
                navController.popBackStack()
            }) {
                Text(text = "geri dönüş butonu")                
            }

        }
    }
    DisposableEffect(Unit) {
        println("---------------------DisposableEffect: entered main")
        onDispose {
            println("-------------------------DisposableEffect: exited main")
        }
    }
}