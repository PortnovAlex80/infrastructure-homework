package com.stringconcat.people.avatarsDiceBear

import com.stringconcat.people.businessPeople.Person
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate

class DiceBearAvatarProviderTest {

    private lateinit var avatarProvider: DiceBearAvatarProvider

    @BeforeEach
    fun setUp() {
        avatarProvider = DiceBearAvatarProvider()
    }

    @Test
    fun `createForPerson should return correct male avatar URL`() {
        // Given
        val person = Person(
            firstName = "John",
            secondName = "Doe",
            birthDate = LocalDate.now(),
            sex = Person.Sex.MAN,
            favoriteQuote = "Test"
        )

        // When
        val result = avatarProvider.createForPerson(person)

        // Then
        assertEquals("https://avatars.dicebear.com/v2/male/JohnDoe.svg", result)
    }

    @Test
    fun `createForPerson should return correct female avatar URL`() {
        // Given
        val person = Person(
            firstName = "Jane",
            secondName = "Doe",
            birthDate = LocalDate.now(),
            sex = Person.Sex.WOMAN,
            favoriteQuote = "Test"
        )

        // When
        val result = avatarProvider.createForPerson(person)

        // Then
        assertEquals("https://avatars.dicebear.com/v2/female/JaneDoe.svg", result)
    }
}
