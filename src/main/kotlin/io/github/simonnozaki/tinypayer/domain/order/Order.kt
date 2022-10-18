package io.github.simonnozaki.tinypayer.domain.order

import io.github.simonnozaki.tinypayer.domain.PaymentState
import java.time.LocalDateTime

/**
 * 注文エンティティ
 */
data class Order (
    val id: String,
    val paymentState: PaymentState,
    val amount: Amount,
    val items: Map<Item, Quantity>,
    val orderedAt: LocalDateTime
) {
    /**
     * 追加の催促が必要であればtrueを返す
     */
    fun needToRequest() = this.paymentState.needToRequest()

    /**
     * 支払いの残額を計算する
     */
    fun getRemainedAmount(): Amount =  when (paymentState) {
        is PaymentState.NotPayed -> amount
        is PaymentState.UnderPayment -> {
            val v = amount.value - paymentState.payedAmount.value
            Amount(v)
        }
        is PaymentState.OverPayment -> Amount(0)
        is PaymentState.Done -> Amount(0)
    }
}
