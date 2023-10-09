package org.conference.business.contract

import org.conference.business.UserProfile

interface GetCurrentUserProfile {
    operator fun invoke(): UserProfile
}
