package com.felipe.agendadecontatos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
                    ListaContatos(navController = navController)
                }
                composable("salvarContato"){
                    SalvarContato()
                }
                composable("atualizarContato/{uid}/{nome}/{sobrenome}/{idade}/{celular}",
                    arguments = listOf(
                        navArgument(name = "uid"){},
                        navArgument(name = "nome"){},
                        navArgument(name = "sobrenome"){},
                        navArgument(name = "idade"){},
                        navArgument(name = "celular"){}

                    )
                ){
                    AtualizarContato(
                        navController,
                        uid= it.arguments?.getString("uid").toString(),
                        nome= it.arguments?.getString("nome").toString(),
                        sobrenome = it.arguments?.getString("sobrenome").toString(),
                        idade = it.arguments?.getString("idade").toString(),
                        celular = it.arguments?.getString("celular").toString()
                    )
                }
            }

        }
    }
}

