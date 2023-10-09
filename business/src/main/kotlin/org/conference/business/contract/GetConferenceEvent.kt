package org.conference.business.contract

import org.conference.business.entities.Event

interface GetConferenceEvent {
    operator fun invoke(id: String): Event?
}
