package com.stringconcat.people.persistance

import liquibase.integration.spring.SpringLiquibase
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import javax.sql.DataSource
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.core.io.ClassPathResource

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(basePackages = ["com.stringconcat.people.persistance"])
@EnableConfigurationProperties(LiquibaseProperties::class) // To use Liquibase properties in our beans
class TestConfig {

    // Define a datasource that connects to your Dockerized PostgreSQL instance

    @Value("\${testcontainer.datasource.url}")
    private lateinit var jdbcUrl: String

    @Value("\${testcontainer.datasource.username}")
    private lateinit var username: String

    @Value("\${testcontainer.datasource.password}")
    private lateinit var password: String

    @Bean
    fun dataSource(): DataSource {
        return DataSourceBuilder.create()
            .driverClassName("org.postgresql.Driver")
            .url(jdbcUrl)
            .username(username)
            .password(password)
            .build()
    }
    // Setup Liquibase to apply your changes on this data source
    @Bean
    fun liquibase(dataSource: DataSource, properties: LiquibaseProperties): SpringLiquibase {
        val liquibase = SpringLiquibase()
        liquibase.dataSource = dataSource
        liquibase.changeLog = "classpath:/com/stringconcat/people/persistence/postgresql/changelogs/main.xml"
        liquibase.contexts = properties.contexts
        liquibase.defaultSchema = properties.defaultSchema
        liquibase.isDropFirst = properties.isDropFirst
        liquibase.setShouldRun(properties.isEnabled)
        liquibase.liquibaseSchema = properties.liquibaseSchema
        liquibase.liquibaseTablespace = properties.liquibaseTablespace
        liquibase.databaseChangeLogTable = properties.databaseChangeLogTable
        liquibase.databaseChangeLogLockTable = properties.databaseChangeLogLockTable
        liquibase.isTestRollbackOnUpdate = properties.isTestRollbackOnUpdate
        return liquibase
    }
}
