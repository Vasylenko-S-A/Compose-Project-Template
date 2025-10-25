package es.mobiledev.domain.usecase.preferences

import es.mobiledev.domain.gateway.preferences.PreferencesGateway
import kotlinx.coroutines.flow.Flow

interface SaveLastOpenTimeUseCase {
    suspend operator fun invoke(timeInMillis: Long): Flow<Boolean>
}

class SaveLastOpenTimeUseCaseImpl(
    private val preferencesGateway: PreferencesGateway
) : SaveLastOpenTimeUseCase {
    override suspend fun invoke(
        timeInMillis: Long
    ): Flow<Boolean> = preferencesGateway.saveLastOpenTime(time = timeInMillis)
}
