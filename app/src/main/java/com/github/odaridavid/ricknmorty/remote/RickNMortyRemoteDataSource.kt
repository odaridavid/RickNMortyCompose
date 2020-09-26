package com.github.odaridavid.ricknmorty.remote

import AllCharactersQuery
import com.apollographql.apollo.coroutines.await
import com.apollographql.apollo.exception.ApolloException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object RickNMortyRemoteDataSource {

    suspend fun getCharacters(): Flow<AllCharactersQuery.Characters?> {
        val getCharactersResponse = NetworkClient.apollo.query(AllCharactersQuery()).await()
        val responseData: AllCharactersQuery.Data? = getCharactersResponse.data
        return flow {
            responseData?.let { response ->
                emit(response.characters)
            } ?: throw ApolloException(
                message = "${getCharactersResponse.errors?.first()?.message}"
            )
        }
    }
}
