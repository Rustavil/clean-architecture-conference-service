package org.conference.business

import java.math.BigDecimal
import java.time.Instant

data class Event(
    val id: String,
    val name: String,
    val venue: String,
    val date: Instant,
    val price: BigDecimal,
    val maxParticipants: Int,
    val description: String,
)
