package org.conference.gateway

import jakarta.inject.Named
import org.conference.business.contract.AddConferenceParticipant
import org.conference.business.entities.ConferenceRegistration
import java.util.*

@Named
class AddConferenceParticipantMock : AddConferenceParticipant {
    override fun invoke(email: String, conferenceId: String) = ConferenceRegistration(
        number = UUID.randomUUID().toString(),
    )
}
