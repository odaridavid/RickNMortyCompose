package com.github.odaridavid.ricknmorty.features.allcharacters.data

import com.github.odaridavid.ricknmorty.common.ExceptionHandler
import com.github.odaridavid.ricknmorty.common.State
import com.github.odaridavid.ricknmorty.models.Character
import com.github.odaridavid.ricknmorty.remote.RickNMortyRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AllCharactersRepository @Inject constructor() {

    suspend fun getAllCharacters(): Flow<State<List<Character>>> =
        RickNMortyRemoteDataSource.getCharacters()
            .distinctUntilChanged()
            .map { remoteCharacters ->
                val characters = remoteCharacters?.toDomain()
                State.Complete(data = characters)
            }
            .catch { throwable ->
                val msg = ExceptionHandler.parse(throwable = throwable)
                emit(State.Complete(error = msg))
            }
}
