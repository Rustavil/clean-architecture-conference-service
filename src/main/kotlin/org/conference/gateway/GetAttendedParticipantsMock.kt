package org.conference.gateway

import jakarta.inject.Named
import org.conference.business.Participant
import org.conference.business.contract.GetAttendedParticipants

@Named
class GetAttendedParticipantsMock : GetAttendedParticipants {
    override fun invoke(conferenceId: String): List<Participant> = emptyList()
}
