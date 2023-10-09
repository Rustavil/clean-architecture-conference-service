package org.conference.business.usecases

import io.kotest.matchers.comparables.shouldBeGreaterThan
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe
import org.conference.business.entities.Event
import org.conference.business.entities.Participant
import org.conference.business.contract.GetAttendedParticipants
import org.conference.business.contract.GetConferenceEvent
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.math.BigDecimal
import java.time.Instant

class GetConferenceDetailsUseCaseImplTest {

    private val getConferenceEventMock: GetConferenceEvent = mock {
        on(it.invoke(anyString())).thenReturn(
            Event(
                id = "id",
                name = "name",
                venue = "venue",
                date = Instant.now(),
                price = BigDecimal(100),
                maxParticipants = 100,
                description = "description",
            )
        )
    }
    private val getAttendedParticipantsMock: GetAttendedParticipants = mock()
    private val getConferenceDetailsUseCaseImpl = GetConferenceDetailsUseCaseImpl(
        getConferenceEvent = getConferenceEventMock,
        getAttendedParticipants = getAttendedParticipantsMock,
    )

    @Test
    fun `if conference doesn't exist then result should be null`() {
        whenever(getConferenceEventMock.invoke(anyString())).doReturn(null)
        getConferenceDetailsUseCaseImpl("conferenceId").shouldBeNull()
    }

    @Test
    fun `if conference exists then result should not be null`() {
        whenever(getAttendedParticipantsMock.invoke(anyString())).thenReturn(emptyList())
        whenever(getConferenceEventMock.invoke(anyString()))
            .doReturn(
                Event(
                    id = "id",
                    name = "name",
                    venue = "venue",
                    date = Instant.MIN,
                    price = BigDecimal(100),
                    maxParticipants = 100,
                    description = "description",
                )
            )
        getConferenceDetailsUseCaseImpl("conferenceId")
            .shouldBe(
                ConferenceDetails(
                    id = "id",
                    name = "name",
                    venue = "venue",
                    date = Instant.MIN,
                    price = BigDecimal(100),
                    maxParticipants = 100,
                    description = "description",
                    attendedParticipantsCount = 0,
                )
            )
    }

    @Test
    fun `if conference has attenders then attended participants count should greater than zero`() {
        whenever(getAttendedParticipantsMock.invoke(anyString()))
            .thenReturn(listOf(Participant("participant@email.com")))

        getConferenceDetailsUseCaseImpl("conferenceId")!!
            .attendedParticipantsCount.shouldBeGreaterThan(0)
    }

    @Test
    fun `if no body attend conference then attended participants count be zero`() {
        whenever(getAttendedParticipantsMock.invoke(anyString()))
            .thenReturn(emptyList())

        getConferenceDetailsUseCaseImpl("conferenceId")!!
            .attendedParticipantsCount.shouldBe(0)
    }
}
