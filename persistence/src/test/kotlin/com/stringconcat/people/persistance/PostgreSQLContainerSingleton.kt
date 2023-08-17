package com.stringconcat.people.persistance

import org.testcontainers.containers.PostgreSQLContainer

object PostgreSQLContainerSingleton {
    val instance = PostgreSQLContainer<Nothing>("postgres:latest")
        .apply {
            withDatabaseName("testdb")
            withUsername("testuser")
            withPassword("testpassword")
            start()
        }
}
