package es.mobiledev.domain.usecase.preferences

import es.mobiledev.domain.gateway.preferences.PreferencesGateway
import kotlinx.coroutines.flow.Flow

interface GetLastOpenTimeUseCase {
    suspend operator fun invoke(): Flow<Long>
}

class GetLastOpenTimeUseCaseImpl(
    private val preferencesGateway: PreferencesGateway
) : GetLastOpenTimeUseCase {
    override suspend fun invoke(): Flow<Long> = preferencesGateway.getLastOpenTime()
}
