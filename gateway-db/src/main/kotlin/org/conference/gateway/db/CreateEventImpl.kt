package org.conference.gateway.db

import jakarta.inject.Named
import org.conference.business.contract.CreateEvent
import org.conference.business.entities.Event
import java.math.BigDecimal
import java.time.Instant

@Named
class CreateEventImpl(
    private val eventRepository: EventRepository,
) : CreateEvent {
    override fun invoke(
        name: String,
        venue: String,
        date: Instant,
        maxParticipants: Int,
        description: String,
        price: BigDecimal,
        owner: String
    ): Event {
        val result = eventRepository.save(
            EventEntity(
                name = name,
                venue = venue,
                date = date,
                price = price,
                maxParticipants = maxParticipants,
                description = description,
            )
        )
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
