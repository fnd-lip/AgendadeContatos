package com.felipe.agendadecontatos.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.felipe.agendadecontatos.ui.theme.PURPLE_500
import com.felipe.agendadecontatos.ui.theme.WHITE
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaContatos( NavController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Agenda de Contatos") },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = PURPLE_500, titleContentColor = WHITE)
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    NavController.navigate("salvarContato")
                },
                containerColor = PURPLE_500,
                contentColor = WHITE,
                modifier = Modifier.clip(CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Ícone de adicionar novo contato",
                )
            }
        }
    ) {paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues)
        ) { }

    }

}

@Preview
@Composable
fun ListaContatosPreview(){
    ListaContatos(NavController = rememberNavController())
}