package org.conference.business.contract

import org.conference.business.Event
import java.math.BigDecimal
import java.time.Instant

interface CreateEvent {
    operator fun invoke(
        name: String,
        venue: String,
        date: Instant,
        maxParticipants: Int,
        description: String,
        price: BigDecimal,
        owner: String,
    ): Event
}
