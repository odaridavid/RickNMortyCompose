package com.github.odaridavid.ricknmorty

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import com.github.odaridavid.ricknmorty.features.allcharacters.ui.AllCharactersScreen
import com.github.odaridavid.ricknmorty.features.allcharacters.ui.AllCharactersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val allCharactersViewModel: AllCharactersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AllCharactersScreen()
        }
        allCharactersViewModel.error.observe(this) { errorMessage ->
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
        }
    }
}
