package org.conference.business.contract

import org.conference.business.ConferenceRegistration

interface AddConferenceParticipant {
    operator fun invoke(participantId: String, conferenceId: String): ConferenceRegistration
}
