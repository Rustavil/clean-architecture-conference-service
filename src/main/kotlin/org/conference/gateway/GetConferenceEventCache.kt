package org.conference.gateway

import jakarta.inject.Named
import org.conference.business.Event
import org.conference.business.contract.GetConferenceEvent
import org.springframework.context.annotation.Primary

@Named
@Primary
class GetConferenceEventCache(
    private val delegate: GetConferenceEvent,
) : GetConferenceEvent by delegate {

    private val cache = HashMap<String, Event>()

    override fun invoke(id: String) = cache[id]
        ?: (delegate(id)?.let { event -> cache.put(id, event) })
}
