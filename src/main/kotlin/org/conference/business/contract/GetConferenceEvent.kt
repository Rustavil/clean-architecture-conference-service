package org.conference.business.contract

import org.conference.business.Event

interface GetConferenceEvent {
    operator fun invoke(id: String): Event?
}
