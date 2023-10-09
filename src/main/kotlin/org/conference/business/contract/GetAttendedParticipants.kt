package org.conference.business.contract

import org.conference.business.Participant

interface GetAttendedParticipants {
    operator fun invoke(conferenceId: String): List<Participant>
}
