package org.idnp.datastoresamplegra

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity2 : AppCompatActivity() {
    private val Context.dataStore by preferencesDataStore(NotePrefs.PREFS_NAME)
    lateinit var notePrefs: NotePrefs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        lateinit var floatingActionButton: FloatingActionButton
        lateinit var layoutConst: LinearLayout

        notePrefs = NotePrefs(dataStore)

        layoutConst = findViewById(R.id.LayoutConst)
        floatingActionButton = findViewById(R.id.floatingActionButton)

        layoutConst.setBackgroundColor(Color.RED)


        floatingActionButton.setOnClickListener {
            lifecycleScope.launch {
                notePrefs.backgroundColor.collect { mycolor ->
                    layoutConst.setBackgroundColor(Integer.parseInt(mycolor.toString()))
                }
           }
        }
    }
}