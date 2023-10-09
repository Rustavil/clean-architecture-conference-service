package org.conference.gateway.db

import jakarta.persistence.*

@Entity
@Table(name = "participants")
data class ParticipantEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val email: String,
    @ManyToOne
    @JoinColumn(name = "event_id")
    val event: EventEntity
)
