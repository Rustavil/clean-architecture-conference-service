package org.conference.gateway.db

import jakarta.inject.Named
import org.conference.business.contract.GetAttendedParticipants
import org.conference.business.entities.Participant

@Named
class GetAttendedParticipantsImpl(
    private val participantRepository: ParticipantRepository,
) : GetAttendedParticipants {
    override fun invoke(conferenceId: String): List<Participant> =
        participantRepository.findByEventId(conferenceId.toLong())
            .map {
                Participant(
                    email = it.email,
                )
            }
}
