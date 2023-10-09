package org.conference.business.contract

import org.conference.business.entities.UserProfile

interface GetCurrentUserProfile {
    operator fun invoke(): UserProfile
}
