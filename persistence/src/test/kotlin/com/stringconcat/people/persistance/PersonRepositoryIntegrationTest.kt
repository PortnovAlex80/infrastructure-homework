
import com.stringconcat.people.persistance.TestConfig
import com.stringconcat.people.persistance.model.PersonEntity
import com.stringconcat.people.persistance.repository.PersonRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

import java.time.LocalDate
import java.util.*

@DataJpaTest
@Testcontainers
@ContextConfiguration(classes = [TestConfig::class])
// @SpringBootTest(classes = [TestConfig::class])
class PersonRepositoryIntegrationTest {

    @Autowired
    private val personRepository: PersonRepository? = null

    @Test
    fun testFindByUuid() {
        val randomId = UUID.randomUUID()
        val personEntity = PersonEntity(
            id = randomId,
            firstName = "John",
            secondName = "Doe",
            birthDate = LocalDate.of(1990, 1, 1),
            sex = PersonEntity.Sex.MAN,
            avatartUrl = "https://avatar.url",
            favoriteQuote = "Test Quote"
        )

        personRepository?.let { repo ->
            repo.save(personEntity)
            val foundEntity = repo.findById(randomId).orElse(null)

            assertEquals(personEntity, foundEntity)
        } ?: run {
            throw RuntimeException("Repository not initialized")
        }
    }

    companion object {

        @Container
        val postgreSQLContainer: PostgreSQLContainer<Nothing> = PostgreSQLContainer<Nothing>("postgres:latest")
            .apply {
                withDatabaseName("testdb")
                withUsername("testuser")
                withPassword("testpassword")
            }

        @BeforeAll
        @JvmStatic
        fun initialize() {
            postgreSQLContainer.start()
        }
    }
}
