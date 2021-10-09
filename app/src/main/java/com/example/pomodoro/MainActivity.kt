package com.example.pomodoro


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.Navigation
import androidx.navigation.Navigator
import com.example.pomodoro.ui.theme.PomodoroTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PomodoroTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ScreenMain()
                }
            }
        }
    }
}

@Composable
@Preview
fun ScreenMain() {


    val navController = rememberNavController()



    /**
     * aşağıdaki composable NavHost fonksiyonu graph dediğimiz ve hareket edebileceğimiz yönleri oluşturur
     * yukarıda tanımladığımız navController değişkeniz ile gitmek istediğimiz yerlere gidebiliriz,
     * bu yüzden yeni composoble fonksiyonlara giderken geri dönmek için bu değişkeni gittiğimiz fonksiyonlara
     * parametre olarak veriyoruz
     */
    NavHost(navController = navController, startDestination = Routes.Home.route) {

        //First route : Home
        composable(Routes.Home.route) {
            println("------------------------- home")

            //Lay down the Home Composable and pass the navController
            Homes(navController = navController)

        }




        //composoble ın aldığı parametrede {id} kısmına argümanı yazıyoruz
        composable(Routes.Settings.route+"/{id}") { navBackStack ->

            //argümanı alıyoruz
            val counter = navBackStack.arguments?.getString("id")

            //ve composable fonskiyona parametre olarak veriyoruz
             Settings(counter,navController)
        }
    }
}