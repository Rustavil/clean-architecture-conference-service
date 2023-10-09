package org.conference.business.usecases

import io.kotest.matchers.types.shouldBeTypeOf
import org.conference.business.ConferenceRegistration
import org.conference.business.UserProfile
import org.conference.business.contract.AddConferenceParticipant
import org.conference.business.contract.GetCurrentUserProfile
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.kotlin.mock
import java.util.*

class RegisterConferenceParticipantUseCaseImplTest {

    private val getCurrentUserProfileMock: GetCurrentUserProfile = mock {
        on(it.invoke()).thenReturn(
            UserProfile(
                id = "id",
                name = "name",
                email = "name@email.com",
            )
        )
    }
    private val addConferenceParticipantMock: AddConferenceParticipant = mock {
        on(it.invoke(anyString(), anyString())).thenReturn(
            ConferenceRegistration(
                number = UUID.randomUUID().toString(),
            )
        )
    }
    private val registerConferenceParticipantUseCaseImpl = RegisterConferenceParticipantUseCaseImpl(
        getCurrentUserProfile = getCurrentUserProfileMock,
        addConferenceParticipant = addConferenceParticipantMock,
    )

    @Test
    fun `when current user has been registered to the conference then response should be success`() {
        registerConferenceParticipantUseCaseImpl("conferenceId")
            .shouldBeTypeOf<ConferenceRegistrationResponse.Success>()
    }
}
