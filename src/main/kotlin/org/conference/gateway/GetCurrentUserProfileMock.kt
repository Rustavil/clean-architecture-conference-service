package org.conference.gateway

import jakarta.inject.Named
import org.conference.business.contract.GetCurrentUserProfile
import org.conference.business.UserProfile
import java.util.*

@Named
class GetCurrentUserProfileMock : GetCurrentUserProfile {
    override fun invoke(): UserProfile {
        return UserProfile(
            id = UUID.randomUUID().toString(),
            name = "Test",
            email = "test@email.com",
        )
    }
}
