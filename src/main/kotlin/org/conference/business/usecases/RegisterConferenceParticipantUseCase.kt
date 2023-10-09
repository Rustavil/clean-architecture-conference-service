package org.conference.business.usecases

import jakarta.inject.Named
import org.conference.business.contract.AddConferenceParticipant
import org.conference.business.contract.GetCurrentUserProfile

interface RegisterConferenceParticipantUseCase {
    operator fun invoke(conferenceId: String): ConferenceRegistrationResponse
}

sealed class ConferenceRegistrationResponse {
    data class Success(
        val number: String,
    ) : ConferenceRegistrationResponse()
}

@Named
class RegisterConferenceParticipantUseCaseImpl(
    private val getCurrentUserProfile: GetCurrentUserProfile,
    private val addConferenceParticipant: AddConferenceParticipant,
) : RegisterConferenceParticipantUseCase {
    override fun invoke(conferenceId: String): ConferenceRegistrationResponse {
        val currentUserProfile = getCurrentUserProfile()
        val conferenceRegistration = addConferenceParticipant(
            participantId = currentUserProfile.id,
            conferenceId = conferenceId,
        )
        return ConferenceRegistrationResponse.Success(conferenceRegistration.number)
    }

}
