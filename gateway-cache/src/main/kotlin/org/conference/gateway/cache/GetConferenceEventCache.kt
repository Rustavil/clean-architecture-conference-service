package org.conference.gateway.cache

import org.conference.business.entities.Event
import org.conference.business.contract.GetConferenceEvent

class GetConferenceEventCache(
    private val delegate: GetConferenceEvent,
) : GetConferenceEvent by delegate {

    private val cache = HashMap<String, Event>()

    override fun invoke(id: String) = cache[id]
        ?: (delegate(id)?.let { event -> cache.put(id, event) })
}
