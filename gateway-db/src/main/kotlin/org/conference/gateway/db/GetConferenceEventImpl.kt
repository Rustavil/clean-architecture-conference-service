package org.conference.gateway.db

import jakarta.inject.Named
import org.conference.business.contract.GetConferenceEvent
import org.conference.business.entities.Event

@Named
class GetConferenceEventImpl(
    private val eventRepository: EventRepository,
) : GetConferenceEvent {
    override fun invoke(id: String): Event? {
        val result = eventRepository.getReferenceById(id.toLong())
        return Event(
            id = result.id.toString(),
            name = result.name,
            venue = result.venue,
            date = result.date,
            price = result.price,
            maxParticipants = result.maxParticipants,
            description = result.description,
        )
    }
}
