package com.example.pomodoro

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


    @Composable
    fun Homes(navController: NavHostController) {


    //Create a basic counter to display on screen
    var counter by remember {
        mutableStateOf(0)
    }
Scaffold(

    floatingActionButton = {
        FloatingActionButton(onClick = {
            counter++
        }){
            var a:Float =1.0f
           Box(modifier = Modifier.padding(0.dp).height(100.dp).aspectRatio(a,true)) {Text(text = "bir arttır",modifier = Modifier.align(
               Alignment.Center))}

        }
    }
) {
    //Box composable to center Items
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray), contentAlignment = Alignment.Center
    ) {

        //A Column composable
        Column {

            //A Text Composable to show counter on Screen
            Text(text = "sayaç değeri $counter", color = Color.Black)

            Spacer(modifier = Modifier.height(20.dp))

            //A button Composable which when clicked will increase the counter


            Spacer(modifier = Modifier.height(20.dp))
            //A button composable to navigate to Profile Screen


            Spacer(modifier = Modifier.height(20.dp))
            //A Button Composable to navigate to Settings Screen when clicked
            Button(onClick = {

                navController.navigate(Routes.Settings.route + "/$counter")

            }) {
                Text(text = "Settings adlı sayfaya gider", color = Color.White)
            }


        }}

}
 }

