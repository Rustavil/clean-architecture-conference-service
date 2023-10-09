package org.conference.business.usecases

import jakarta.inject.Named
import org.conference.business.contract.GetAttendedParticipants
import org.conference.business.contract.GetConferenceEvent
import java.math.BigDecimal
import java.time.Instant

interface GetConferenceDetailsUseCase {
    operator fun invoke(conferenceId: String): ConferenceDetails?
}

data class ConferenceDetails(
    val id: String,
    val name: String,
    val venue: String,
    val date: Instant,
    val price: BigDecimal,
    val maxParticipants: Int,
    val description: String,
    val attendedParticipantsCount: Int,
)

@Named
class GetConferenceDetailsUseCaseImpl(
    private val getConferenceEvent: GetConferenceEvent,
    private val getAttendedParticipants: GetAttendedParticipants,
) : GetConferenceDetailsUseCase {
    override fun invoke(
        conferenceId: String,
    ): ConferenceDetails? = getConferenceEvent(conferenceId)
        ?.let { conferenceEvent ->
            val attendedParticipants = getAttendedParticipants(conferenceEvent.id)
            ConferenceDetails(
                id = conferenceEvent.id,
                name = conferenceEvent.name,
                venue = conferenceEvent.venue,
                date = conferenceEvent.date,
                price = conferenceEvent.price,
                maxParticipants = conferenceEvent.maxParticipants,
                description = conferenceEvent.description,
                attendedParticipantsCount = attendedParticipants.count(),
            )
        }

}
