package com.felipe.agendadecontatos.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation.Companion.keyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.felipe.agendadecontatos.componentes.Botao
import com.felipe.agendadecontatos.componentes.OutlinedTextFieldCustom
import com.felipe.agendadecontatos.ui.theme.PURPLE_500
import com.felipe.agendadecontatos.ui.theme.WHITE
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SalvarContato(){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Salvar novo Contato") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = PURPLE_500,
                    titleContentColor = WHITE
                )
            )
        }
    ) { paddingValues ->
        var nome by remember { mutableStateOf(value = "") }
        var sobrenome by remember { mutableStateOf(value = "") }
        var idade by remember { mutableStateOf(value = "") }
        var celular by remember { mutableStateOf(value = "") }
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues).verticalScroll(
                rememberScrollState()
            ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextFieldCustom(
                value = nome,
                onValueChange = {nome = it},
                label = { Text(text = "Nome") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                modifier = Modifier.fillMaxWidth().padding(start = 20.dp, top = 0.dp, end = 20.dp, bottom = 10.dp)
            )
            OutlinedTextFieldCustom(
                value = sobrenome,
                onValueChange = {sobrenome = it},
                label = { Text(text = "Sobrenome") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                modifier = Modifier.fillMaxWidth().padding(start = 20.dp, top = 0.dp, end = 20.dp, bottom = 10.dp)
            )
            OutlinedTextFieldCustom(
                value = idade,
                onValueChange = {idade = it},
                label = { Text(text = "Idade") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier.fillMaxWidth().padding(start = 20.dp, top = 0.dp, end = 20.dp, bottom = 10.dp)
            )
            OutlinedTextFieldCustom(
                value = celular,
                onValueChange = {celular = it},
                label = { Text(text = "Celular") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone
                ),
                modifier = Modifier.fillMaxWidth().padding(start = 20.dp, top = 0.dp, end = 20.dp, bottom = 10.dp)
            )
            Botao(
                onClick = { },
                texto = "Salvar"
            )
        }

    }
}

@Preview
@Composable
private fun SalvarContatoPreview(){
    SalvarContato()
}