package org.conference.business.usecases

import jakarta.inject.Named
import org.conference.business.contract.CreateEvent
import org.conference.business.contract.GetCurrentUserProfile
import java.math.BigDecimal
import java.time.Instant

interface CreateConferenceEventUseCase {
    operator fun invoke(
        name: String,
        venue: String,
        date: Instant,
        maxParticipants: Int,
        description: String,
        price: BigDecimal,
    ): CreateConferenceEventResponse
}

sealed class CreateConferenceEventResponse {
    data class Success(
        val eventId: String,
    ) : CreateConferenceEventResponse()
}

@Named
class CreateConferenceEventUseCaseImpl(
    private val getCurrentUserProfile: GetCurrentUserProfile,
    private val createEvent: CreateEvent,
) : CreateConferenceEventUseCase {

    override fun invoke(
        name: String,
        venue: String,
        date: Instant,
        maxParticipants: Int,
        description: String,
        price: BigDecimal,
    ): CreateConferenceEventResponse {
        val currentUserProfile = getCurrentUserProfile()
        val event = createEvent(
            name = name,
            venue = venue,
            date = date,
            owner = currentUserProfile.id,
            maxParticipants = maxParticipants,
            description = description,
            price = price,
        )
        return CreateConferenceEventResponse.Success(event.id)
    }
}
