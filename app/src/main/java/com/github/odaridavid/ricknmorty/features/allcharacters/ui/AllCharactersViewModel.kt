package com.github.odaridavid.ricknmorty.features.allcharacters.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.odaridavid.ricknmorty.common.State
import com.github.odaridavid.ricknmorty.features.allcharacters.domain.GetAllCharactersUseCase
import com.github.odaridavid.ricknmorty.models.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class AllCharactersViewModel @ViewModelInject constructor(
    private val getAllCharactersUseCase: GetAllCharactersUseCase
) : ViewModel() {

    private val _characters = MutableLiveData<List<Character>>()
    val characters: LiveData<List<Character>>
        get() = _characters
    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    init {
        viewModelScope.launch {
            getAllCharactersUseCase()
                .flowOn(Dispatchers.IO)
                .collect { result ->
                    when (result) {
                        is State.Success -> {
                            _characters.value = result.data
                        }
                        is State.Error -> {
                            _error.value = result.throwable?.message
                        }
                    }
                }
        }
    }
}
