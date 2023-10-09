package org.conference.gateway

import jakarta.inject.Named
import org.conference.business.contract.CreateEvent
import org.conference.business.entities.Event
import java.math.BigDecimal
import java.time.Instant
import java.util.*

@Named
class CreateEventMock : CreateEvent {
    override fun invoke(
        name: String,
        venue: String,
        date: Instant,
        maxParticipants: Int,
        description: String,
        price: BigDecimal,
        owner: String
    ): Event {
        return Event(
            id = UUID.randomUUID().toString(),
            name = name,
            venue = venue,
            date = date,
            price = price,
            maxParticipants = maxParticipants,
            description = description,
        )
    }
}
