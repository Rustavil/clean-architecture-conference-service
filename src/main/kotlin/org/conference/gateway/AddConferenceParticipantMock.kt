package org.conference.gateway

import jakarta.inject.Named
import org.conference.business.contract.AddConferenceParticipant
import org.conference.business.ConferenceRegistration
import java.util.*

@Named
class AddConferenceParticipantMock : AddConferenceParticipant {
    override fun invoke(participantId: String, conferenceId: String) = ConferenceRegistration(
        number = UUID.randomUUID().toString(),
    )
}
