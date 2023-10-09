package org.conference.gateway.db

import jakarta.inject.Named
import org.conference.business.contract.GetCurrentUserProfile
import org.conference.business.entities.UserProfile
import java.util.*

@Named
class GetCurrentUserProfileImpl : GetCurrentUserProfile {
    override fun invoke(): UserProfile {
        return UserProfile(
            id = UUID.randomUUID().toString(),
            name = "Test",
            email = "test@email.com",
        )
    }
}
