package com.felipe.agendadecontatos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.felipe.agendadecontatos.views.AtualizarContato
import com.felipe.agendadecontatos.views.ListaContatos
import com.felipe.agendadecontatos.views.SalvarContato

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "listaContatos"
            ){
                composable("listaContatos"){
                    ListaContatos(NavController = navController)
                }
                composable("salvarContato"){
                    SalvarContato()
                }
                composable("atualizarContato"){
                    AtualizarContato()
                }
            }

        }
    }
}

