package com.github.odaridavid.ricknmorty.features.allcharacters.di

import com.github.odaridavid.ricknmorty.features.allcharacters.data.AllCharactersRepository
import com.github.odaridavid.ricknmorty.features.allcharacters.domain.GetAllCharactersUseCase
import com.github.odaridavid.ricknmorty.remote.RickNMortyRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object AllCharactersModule {

    @Provides
    fun provideAllCharactersRepository(): AllCharactersRepository =
        AllCharactersRepository()

    @Provides
    fun provideGetAllCharactersUseCase(
        allCharactersRepository: AllCharactersRepository
    ): GetAllCharactersUseCase =
        GetAllCharactersUseCase(allCharactersRepository = allCharactersRepository)

}
