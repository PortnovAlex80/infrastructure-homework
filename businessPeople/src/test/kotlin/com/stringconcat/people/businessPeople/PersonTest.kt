package com.stringconcat.people.businessPeople

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.time.LocalDate

class PersonTest {

    @Test
    fun `should return true if person is mature`() {
        val birthDate = LocalDate.now().minusYears(45)
        val person = Person(firstName = "John", secondName = "Doe", birthDate = birthDate, sex = Person.Sex.MAN, favoriteQuote = "Test Quote")
        assertTrue(person.mature())
    }

    @Test
    fun `should return false if person is not mature`() {
        val birthDate = LocalDate.now().minusYears(30)
        val person = Person(firstName = "John", secondName = "Doe", birthDate = birthDate, sex = Person.Sex.MAN, favoriteQuote = "Test Quote")
        assertFalse(person.mature())
    }

    @Test
    fun `should return correct age for person`() {
        val birthDate = LocalDate.now().minusYears(30)
        val person = Person(firstName = "John", secondName = "Doe", birthDate = birthDate, sex = Person.Sex.MAN, favoriteQuote = "Test Quote")
        assertEquals(30, person.age())
    }

    @Test
    fun `should change avatar URL for person`() {
        val person = Person(firstName = "John", secondName = "Doe", birthDate = LocalDate.now(), sex = Person.Sex.MAN, favoriteQuote = "Test Quote")
        val newAvatar = "https://new.avatar.url"
        person.changeAvatar(newAvatar)
        assertEquals(newAvatar, person.avatartUrl)
    }
}