package com.felipe.agendadecontatos.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.felipe.agendadecontatos.AppDatabase
import com.felipe.agendadecontatos.dao.ContatoDao
import com.felipe.agendadecontatos.itemlista.ContatoItem
import com.felipe.agendadecontatos.model.Contato
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private lateinit var contatoDao: ContatoDao
@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaContatos( navController: NavController){
    val listaContatos by remember() { mutableStateOf<MutableList<Contato>>(mutableListOf()) }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    scope.launch(Dispatchers.IO){
        contatoDao = AppDatabase.getInstance(context).contatoDao()
        val contato = contatoDao.getContatos()
        for(contatos in contato){
            listaContatos.add(contatos)
        }

    }
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
                    navController.navigate("salvarContato")
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
            modifier = Modifier.fillMaxSize().padding(paddingValues).background(Color.LightGray)
        ) {
            LazyColumn() {
                itemsIndexed(listaContatos){_, contato ->
                    ContatoItem(contato, navController )
                }
            }
        }

    }

}

@Preview
@Composable
fun ListaContatosPreview(){
    ListaContatos(navController = rememberNavController())
}