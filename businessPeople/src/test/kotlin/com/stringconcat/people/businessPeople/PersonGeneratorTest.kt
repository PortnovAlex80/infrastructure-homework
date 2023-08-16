package com.stringconcat.people.businessPeople

import com.nhaarman.mockitokotlin2.anyOrNull
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDate
class PersonGeneratorTest() {private val mockQuoteProvider: QuotesProvider = mock()
    private val mockAvatarProvider: AvatarProvider = mock()
    private val generator = PersonGenerator(mockQuoteProvider, mockAvatarProvider)

    @Test
    fun `should generate person with given parameters and retrieve quote and avatar`() {
        val firstName = "John"
        val secondName = "Doe"
        val birthDate = LocalDate.now()
        val sex = Person.Sex.MAN
        val quote = "Test Quote"
        val avatarUrl = "https://test.avatar.url"

        whenever(mockQuoteProvider.randomQuote()).thenReturn(quote)
        whenever(mockAvatarProvider.createForPerson(anyOrNull())).thenReturn(avatarUrl)

        val person = generator.generate(firstName, secondName, birthDate, sex)

        assertEquals(firstName, person.firstName)
        assertEquals(secondName, person.secondName)
        assertEquals(birthDate, person.birthDate)
        assertEquals(sex, person.sex)
        assertEquals(quote, person.favoriteQuote)
        assertEquals(avatarUrl, person.avatartUrl)
    }
}