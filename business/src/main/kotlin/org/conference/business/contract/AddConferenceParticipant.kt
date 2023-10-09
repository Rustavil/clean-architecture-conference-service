package org.conference.business.contract

import org.conference.business.entities.ConferenceRegistration

interface AddConferenceParticipant {
    operator fun invoke(email: String, conferenceId: String): ConferenceRegistration
}
