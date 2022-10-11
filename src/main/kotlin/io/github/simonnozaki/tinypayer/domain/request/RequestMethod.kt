package io.github.simonnozaki.tinypayer.domain.request

/**
 * 催促方法
 */
sealed class RequestMethod {

    /**
     * 催促方法: SMS
     */
    data class Sms(
        val tel: String
    ) : RequestMethod()

    /**
     * 催促方法: メール
     */
    data class Email(
        val value: String
    ) : RequestMethod()

    /**
     * 催促方法: なし(通知・連絡する手段を確保できていないケース)
     */
    object NotFound : RequestMethod()
}
