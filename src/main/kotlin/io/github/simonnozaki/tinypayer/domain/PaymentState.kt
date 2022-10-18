package io.github.simonnozaki.tinypayer.domain

import io.github.simonnozaki.tinypayer.domain.order.Amount

/**
 * 支払い状況
 */
sealed class PaymentState {
    abstract fun needToRequest(): Boolean

    /**
     * 支払い状況: 未払い
     */
    object NotPayed : PaymentState() {
        override fun needToRequest() = true
    }

    /**
     * 支払い状況: 支払い金額不足
     */
    data class UnderPayment(
        val payedAmount: Amount
    ) : PaymentState() {
        override fun needToRequest() = true
    }

    /**
     * 支払い状況: 支払い金額過多
     */
    data class OverPayment(
        val payedAmount: Amount
    ) : PaymentState() {
        override fun needToRequest() = false
    }

    /**
     * 支払い状況: 入金完了
     */
    object Done : PaymentState() {
        override fun needToRequest() = false
    }
}
