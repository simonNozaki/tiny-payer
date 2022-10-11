package io.github.simonnozaki.tinypayer.domain.order

interface OrderRepository {
    fun findById(id: String): Order
}
