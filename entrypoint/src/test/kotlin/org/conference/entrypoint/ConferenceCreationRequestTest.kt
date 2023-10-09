package org.conference.entrypoint

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import io.kotest.matchers.equals.shouldBeEqual
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.time.Instant


class ConferenceCreationRequestTest {

    private val objectMapper = ObjectMapper()
        .registerModule(JavaTimeModule())
        .registerModule(KotlinModule.Builder().build())

    @Test
    fun `if json has date in right format then should successfully deserialize`() {
        val json = """
        {
            "name":"Sample Conference",
            "venue":"Sample Venue",
            "date":"2023-01-01 00:00:00",
            "price":100.50,
            "maxParticipants":200,
            "description":"Sample conference description"
        }
        """.trimIndent()

        val request = ConferenceCreationRequest(
            name = "Sample Conference",
            venue = "Sample Venue",
            date = Instant.parse("2023-01-01T00:00:00Z"),
            price = BigDecimal("100.50"),
            maxParticipants = 200,
            description = "Sample conference description"
        )

        objectMapper.readValue<ConferenceCreationRequest>(json)
            .shouldBeEqual(request)
    }
}
