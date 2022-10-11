package io.github.simonnozaki.tinypayer.domain.request

import io.github.simonnozaki.tinypayer.domain.Amount
import java.time.LocalDateTime
import java.util.UUID

/**
 * 催促 エンティティ
 */
data class Request(
    val id: String,
    val scheduledAt: LocalDateTime,
    val requestMethod: RequestMethod,
    val requestAmount: Amount
) {
    // staticメソッドばっかだけど、要件次第でぎちっと詰めるようにする
    companion object {
        /**
         * 簡易ファクトリメソッド
         * @param requestMethod
         * @param requestAmount
         */
        fun of(requestMethod: RequestMethod, requestAmount: Amount) = Request(
            UUID.randomUUID().toString(),
            LocalDateTime.now(),
            requestMethod,
            requestAmount
        )

        /**
         * 催促の手段を電話番号、メアドから決定する
         * @param tel
         * @param email
         */
        fun fromTelOrEmail(tel: String?, email: String?) = if (tel != null) {
            RequestMethod.Sms(tel)
        } else if (email != null) {
            RequestMethod.Email(email)
        } else {
            RequestMethod.NotFound
        }
    }
}
