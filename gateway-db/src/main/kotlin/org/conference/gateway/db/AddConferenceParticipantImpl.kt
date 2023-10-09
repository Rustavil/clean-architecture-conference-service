package org.conference.gateway.db

import jakarta.inject.Named
import org.conference.business.contract.AddConferenceParticipant
import org.conference.business.entities.ConferenceRegistration

@Named
class AddConferenceParticipantImpl(
    private val participantRepository: ParticipantRepository,
    private val eventRepository: EventRepository,
) : AddConferenceParticipant {
    override fun invoke(email: String, conferenceId: String): ConferenceRegistration {
        val event = eventRepository.getReferenceById(conferenceId.toLong())
        val result = participantRepository.save(
            ParticipantEntity(
                email = email,
                event = event,
            )
        )
        return ConferenceRegistration(
            number = result.id.toString(),
        )
    }
}
