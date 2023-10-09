package org.conference.gateway.db

import org.springframework.data.jpa.repository.JpaRepository

interface ParticipantRepository : JpaRepository<ParticipantEntity, Long> {
    fun findByEventId(eventId: Long): List<ParticipantEntity>
}
