package io.github.simonnozaki.tinypayer.infrastructure

import io.github.simonnozaki.tinypayer.domain.Amount
import io.github.simonnozaki.tinypayer.domain.PaymentState
import io.github.simonnozaki.tinypayer.domain.order.Order
import io.github.simonnozaki.tinypayer.domain.order.OrderRepository
import java.time.LocalDateTime
import java.util.UUID

/**
 * OrderRepository モック実装クラス
 */
class MockOrderRepository : OrderRepository {
    override fun findById(id: String) = Order(
        UUID.randomUUID().toString(),
        PaymentState.UnderPayment(Amount(2500)),
        Amount(4000),
        LocalDateTime.now()
    )
}