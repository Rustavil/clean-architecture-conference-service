package org.conference.entrypoint

import org.conference.business.usecases.ConferenceDetails
import org.conference.business.usecases.CreateConferenceEventUseCase
import org.conference.business.usecases.GetConferenceDetailsUseCase
import org.conference.business.usecases.RegisterConferenceParticipantUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.time.ZoneId

@RestController("/conference")
class ConferenceController(
    private val createConferenceEvent: CreateConferenceEventUseCase,
    private val registerConferenceParticipant: RegisterConferenceParticipantUseCase,
    private val getConferenceDetails: GetConferenceDetailsUseCase,
) {

    @PostMapping
    fun create(
        request: ConferenceCreationRequest,
    ) = createConferenceEvent(
        name = request.name,
        venue = request.venue,
        date = request.date.atZone(ZoneId.systemDefault()).toInstant(),
        maxParticipants = request.maxParticipants,
        description = request.description,
        price = request.price,
    )

    @PostMapping("/{conferenceId}")
    fun registerParticipant(
        @PathVariable conferenceId: String,
    ) = registerConferenceParticipant(conferenceId)

    @GetMapping("/{conferenceId}")
    fun conferenceDetails(
        @PathVariable conferenceId: String,
    ): ResponseEntity<ConferenceDetails> = getConferenceDetails(conferenceId)
        ?.let { ResponseEntity.ok(it) }
        ?: ResponseEntity.status(HttpStatus.NOT_FOUND).build()
}
