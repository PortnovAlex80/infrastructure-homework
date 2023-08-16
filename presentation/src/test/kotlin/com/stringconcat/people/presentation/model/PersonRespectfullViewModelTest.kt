package com.stringconcat.people.presentation.model

import com.stringconcat.people.businessPeople.Person
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

import java.time.LocalDate
import java.util.*

class PersonRespectfullViewModelTest {

    @Test
    fun `title should prefix correctly for a mature man`() {
        val person = Person(
            UUID.randomUUID(),
            "John",
            "Doe",
            LocalDate.of(1970, 1, 1),
            Person.Sex.MAN,
            "",
            ""
        )
        val viewModel = PersonRespectfullViewModel(person)
        assertEquals("Mr John Doe", viewModel.title())
    }

    @Test
    fun `title should prefix correctly for a mature woman`() {
        val person = Person(
            UUID.randomUUID(),
            "Jane",
            "Doe",
            LocalDate.of(1970, 1, 1),
            Person.Sex.WOMAN,
            "",
            ""
        )
        val viewModel = PersonRespectfullViewModel(person)
        assertEquals("Mrs Jane Doe", viewModel.title())
    }

    @Test
    fun `title should not prefix for a young person`() {
        val person = Person(
            UUID.randomUUID(),
            "Alice",
            "Smith",
            LocalDate.of(2005, 1, 1),
            Person.Sex.WOMAN,
            "",
            ""
        )
        val viewModel = PersonRespectfullViewModel(person)
        assertEquals("Alice Smith", viewModel.title())
    }

    @Test
    fun `avatarUrl should return correct URL`() {
        val expectedUrl = "https://avatar.example.com/user1"
        val person = Person(UUID.randomUUID(), "", "", LocalDate.now(), Person.Sex.MAN, expectedUrl, "")
        val viewModel = PersonRespectfullViewModel(person)
        assertEquals(expectedUrl, viewModel.avatarUrl())
    }

    @Test
    fun `birthDate should format correctly`() {
        val person = Person(UUID.randomUUID(), "", "", LocalDate.of(2000, 12, 31), Person.Sex.MAN, "", "")
        val viewModel = PersonRespectfullViewModel(person)
        assertEquals("31 DECEMBER 2000", viewModel.birthDate().toUpperCase()) // Convert to upper case to handle potential locale-based differences.
    }

    @Test
    fun `favoriteQuote should return the correct quote`() {
        val expectedQuote = "To be or not to be"
        val person = Person(UUID.randomUUID(), "", "", LocalDate.now(), Person.Sex.MAN, "", expectedQuote)
        val viewModel = PersonRespectfullViewModel(person)
        assertEquals(expectedQuote, viewModel.favoriteQuote())
    }
}
