package io.github.simonnozaki.tinypayer.domain.request

/**
 * 催促リポジトリ
 */
interface RequestRepository {
    fun save(request: Request)
}
