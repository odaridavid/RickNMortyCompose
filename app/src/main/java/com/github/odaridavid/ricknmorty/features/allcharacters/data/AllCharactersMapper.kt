package com.github.odaridavid.ricknmorty.features.allcharacters.data

import AllCharactersQuery
import com.github.odaridavid.ricknmorty.models.Character

fun AllCharactersQuery.Characters.toDomain(): List<Character> {
    return results?.map { character ->
        Character(
            image = character?.image,
            name = character?.name
        )
    } ?: emptyList()
}

