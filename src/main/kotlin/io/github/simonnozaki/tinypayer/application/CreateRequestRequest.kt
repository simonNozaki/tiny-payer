package io.github.simonnozaki.tinypayer.application

/**
 * 催促作成リクエスト
 */
data class CreateRequestRequest(
    val orderId: String,
    val tel: String?,
    val email: String?
)
