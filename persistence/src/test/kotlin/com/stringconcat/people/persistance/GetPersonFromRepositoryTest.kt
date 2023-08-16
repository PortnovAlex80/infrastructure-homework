package com.stringconcat.people.persistance.com.stringconcat.people.persistance

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.stringconcat.people.persistance.GetPersonFromRepository
import com.stringconcat.people.persistance.model.PersonEntity
import com.stringconcat.people.persistance.repository.PersonRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.util.*

class GetPersonFromRepositoryTest {

    private lateinit var repository: PersonRepository
    private lateinit var getPersonFromRepository: GetPersonFromRepository

    @BeforeEach
    fun setUp() {
        repository = mock()  // Using mockito-kotlin mock initialization
        getPersonFromRepository = GetPersonFromRepository(repository)
    }

    @Test
    fun `should return person when person with given id exists`() {
        val id = UUID.randomUUID()
        val entity = PersonEntity(
            id = id,
            firstName = "John",
            secondName = "Doe",
            birthDate = LocalDate.of(1990, 1, 1),
            sex = PersonEntity.Sex.MAN,
            avatartUrl = "https://avatar.url",
            favoriteQuote = "Test Quote"
        )
        val expectedPerson = PersonEntity.toBusiness(entity)

        whenever(repository.findById(id)).thenReturn(Optional.of(entity))  // Using mockito-kotlin

        val result = getPersonFromRepository.get(id)

        assertEquals(expectedPerson, result)
    }

    @Test
    fun `should return null when no person with given id exists`() {
        val id = UUID.randomUUID()

        whenever(repository.findById(id)).thenReturn(Optional.empty())  // Using mockito-kotlin

        val result = getPersonFromRepository.get(id)

        assertNull(result)
    }
}
