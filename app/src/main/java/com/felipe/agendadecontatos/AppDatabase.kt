package com.felipe.agendadecontatos

import android.content.Context
import androidx.room3.Database
import androidx.room3.Room
import androidx.room3.RoomDatabase
import com.felipe.agendadecontatos.constantes.Constantes
import com.felipe.agendadecontatos.dao.ContatoDao
import com.felipe.agendadecontatos.model.Contato

@Database(entities = [Contato::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun contatoDao(): ContatoDao
    companion object{
        @Volatile
        private  var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase{
            return INSTANCE ?: synchronized(this ){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    klass = AppDatabase::class.java,
                    name= Constantes.DB_CONTATOS
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}