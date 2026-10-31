package com.felipe.agendadecontatos.model

import androidx.room3.ColumnInfo
import androidx.room3.Entity
import androidx.room3.PrimaryKey
import com.felipe.agendadecontatos.constantes.Constantes

@Entity(tableName = Constantes.TABELA_CONTATOS)
data class Contato(
    @ColumnInfo(name = "nome") val nome: String,
    @ColumnInfo(name = "sobrenome") val sobrenome: String,
    @ColumnInfo(name = "idade") val idade: String,
    @ColumnInfo(name = "celular") val celular: String,
){
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}
