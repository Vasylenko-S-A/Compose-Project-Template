package es.mobiledev.domain.usecase.preferences

import es.mobiledev.domain.gateway.preferences.PreferencesGateway

interface SaveLastOpenTimeUseCase {
    suspend operator fun invoke(timeInMillis: Long)
}

class SaveLastOpenTimeUseCaseImpl(
    private val preferencesGateway: PreferencesGateway
) : SaveLastOpenTimeUseCase {
    override suspend fun invoke(
        timeInMillis: Long
    ) = preferencesGateway.saveLastOpenTime(time = timeInMillis)
}
