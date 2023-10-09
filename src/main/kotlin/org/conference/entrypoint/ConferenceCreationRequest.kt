package org.conference.entrypoint

import com.fasterxml.jackson.annotation.JsonFormat
import java.math.BigDecimal
import java.time.Instant

data class ConferenceCreationRequest(
    val name: String,
    val venue: String,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    val date: Instant,
    val price: BigDecimal = BigDecimal.ZERO,
    val maxParticipants: Int,
    val description: String,
)
