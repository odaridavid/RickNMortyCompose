package com.github.odaridavid.ricknmorty.features.allcharacters.domain

import com.github.odaridavid.ricknmorty.common.State
import com.github.odaridavid.ricknmorty.features.allcharacters.data.AllCharactersRepository
import com.github.odaridavid.ricknmorty.models.Character
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCharactersUseCase @Inject constructor(
    private val allCharactersRepository: AllCharactersRepository
) {

    suspend operator fun invoke(): Flow<State<List<Character>>> =
        allCharactersRepository.getAllCharacters()
}
