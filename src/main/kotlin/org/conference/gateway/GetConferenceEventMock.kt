package org.conference.gateway

import jakarta.inject.Named
import org.conference.business.Event
import org.conference.business.contract.GetConferenceEvent
import java.math.BigDecimal
import java.time.Instant

@Named
class GetConferenceEventMock : GetConferenceEvent {
    override fun invoke(id: String) = Event(
        id = id,
        name = "Devclub",
        venue = "Estonia, Tallinn",
        date = Instant.now(),
        price = BigDecimal(10),
        maxParticipants = 100,
        description = "Devclub is open for everyone monthly meeting.",
    )
}
