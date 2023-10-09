package org.conference.business.usecases

import org.conference.business.entities.Event
import org.conference.business.entities.UserProfile
import org.conference.business.contract.CreateEvent
import org.conference.business.contract.GetCurrentUserProfile
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.atLeastOnce
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import java.math.BigDecimal
import java.time.Instant
import java.time.temporal.ChronoUnit

class CreateConferenceEventUseCaseImplTest {

    private val getCurrentUserProfileMock: GetCurrentUserProfile = mock {
        on(it.invoke()).thenReturn(
            UserProfile(
                id = "id",
                name = "name",
                email = "name@email.com",
            )
        )
    }
    private val createEventMock: CreateEvent = mock {
        on(it.invoke(any(), any(), any(), any(), any(), any(), any()))
            .thenReturn(
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

    private val createConferenceEventUseCseImpl = CreateConferenceEventUseCaseImpl(
        getCurrentUserProfile = getCurrentUserProfileMock,
        createEvent = createEventMock,
    )

    @Test
    fun `when use case called then current use profile should be invoked`() {
        createConferenceEventUseCseImpl(
            name = "name",
            venue = "venue",
            date = Instant.now().plus(1, ChronoUnit.DAYS),
            maxParticipants = 100,
            description = "description",
            price = BigDecimal.valueOf(100),
        )

        verify(getCurrentUserProfileMock, atLeastOnce()).invoke()
    }
}
