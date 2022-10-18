package io.github.simonnozaki.tinypayer.infrastructure

import io.github.simonnozaki.tinypayer.domain.order.Amount
import io.github.simonnozaki.tinypayer.domain.PaymentState
import io.github.simonnozaki.tinypayer.domain.order.Item
import io.github.simonnozaki.tinypayer.domain.order.Order
import io.github.simonnozaki.tinypayer.domain.order.OrderRepository
import io.github.simonnozaki.tinypayer.domain.order.Quantity
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
        mapOf(
            Item(
                UUID.randomUUID().toString(),
                "高級烏龍茶",
                600
            ) to Quantity(1),
            Item(
                UUID.randomUUID().toString(),
                "高級茉莉花茶",
                700
            ) to Quantity(1)
        ),
        LocalDateTime.now()
    )
}