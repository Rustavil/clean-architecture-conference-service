package org.conference.gateway.db

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.Instant

@Entity
@Table(name = "events")
data class EventEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val venue: String,
    val date: Instant,
    val price: BigDecimal,
    val maxParticipants: Int,
    val description: String,
    @OneToMany(mappedBy = "event", cascade = [CascadeType.ALL], orphanRemoval = true)
    val participants: MutableList<ParticipantEntity> = mutableListOf(),
)
