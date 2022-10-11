package io.github.simonnozaki.tinypayer

import io.github.simonnozaki.tinypayer.application.CreateRequestRequest
import io.github.simonnozaki.tinypayer.application.service.CreateRequest
import io.github.simonnozaki.tinypayer.infrastructure.MockOrderRepository
import io.github.simonnozaki.tinypayer.infrastructure.MockRequestRepository
import java.util.UUID

internal val orderRepository = MockOrderRepository()
internal val requestRepository = MockRequestRepository()

fun main() {
    val req = CreateRequestRequest(
        UUID.randomUUID().toString(),
        "090-1234-5678",
        null
    )

    // もっと気合いれるならDIコンテナ入れる(今はいらない)
    CreateRequest(orderRepository, requestRepository).execute(req)
}
