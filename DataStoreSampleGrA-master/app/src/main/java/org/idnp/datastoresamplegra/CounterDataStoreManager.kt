package org.idnp.datastoresamplegra


import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.currentCoroutineContext
//import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map




class CounterDataStoreManager(public val context: Context) {




    suspend fun storeUser(periodo: String,escuela: String,codigo: Int ,nombre : String, semestre: String, duracion: String  ) {

        context.counterDataStore.edit { preferences ->


            preferences [USER_PERIODO_KEY]=periodo
            preferences [USER_ESCUELA_KEY]=escuela
            preferences [USER_CODIGO_KEY]=codigo
            preferences [USER_NOMBRE_KEY]=nombre
            preferences [USER_SEMESTRE_KEY]= semestre
            preferences [USER_DURACION_KEY]= duracion

        }
    }


    public  val DATASTORE_NAME = "counter_preferences"

    public val COUNTER_KEY = intPreferencesKey("counter_key");

    public val Context.counterDataStore by preferencesDataStore(
      name = DATASTORE_NAME)

    companion object {

        val USER_PERIODO_KEY = stringPreferencesKey("PERIODO")
        val USER_ESCUELA_KEY = stringPreferencesKey("ESCUELA")
        val USER_CODIGO_KEY = intPreferencesKey("CODIGO")
        val USER_NOMBRE_KEY = stringPreferencesKey("NOMBRE")
        val USER_SEMESTRE_KEY = stringPreferencesKey("SEMESTRE")
        val USER_DURACION_KEY = stringPreferencesKey("DURACION")


        //)
    }
    //Create the dataStore


    //get para glujo para leer desde data store
    val userPeriodoFlow: Flow<String>
            get() = context.counterDataStore.data.map{preferences ->
                 preferences[USER_PERIODO_KEY] ?: ""
    }
    val userEscuelaFlow: Flow<String>
        get() = context.counterDataStore.data.map{preferences ->
            preferences[USER_ESCUELA_KEY] ?: ""
        }
    val userCodigoFlow: Flow<Int>
        get() = context.counterDataStore.data.map{preferences ->
            preferences[USER_CODIGO_KEY] ?: 0
        }
    val userNombreFlow: Flow<String>
        get() = context.counterDataStore.data.map{preferences ->
            preferences[USER_NOMBRE_KEY] ?: ""
        }
    val userSemestreFlow: Flow<String>
        get() = context.counterDataStore.data.map{preferences ->
            preferences[USER_SEMESTRE_KEY] ?: ""
        }
    val userDuracionFlow: Flow<String>
        get() = context.counterDataStore.data.map{preferences ->
            preferences[USER_DURACION_KEY] ?: ""
        }

}



