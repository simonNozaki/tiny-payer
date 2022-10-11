package io.github.simonnozaki.tinypayer.application.service

import io.github.simonnozaki.tinypayer.application.CreateRequestRequest
import io.github.simonnozaki.tinypayer.domain.order.OrderRepository
import io.github.simonnozaki.tinypayer.domain.request.Request
import io.github.simonnozaki.tinypayer.domain.request.RequestRepository

/**
 * 催促作成 ユースケース
 */
class CreateRequest(
    private val orderRepository: OrderRepository,
    private val requestRepository: RequestRepository
) {
    fun execute(req: CreateRequestRequest) {
        val order = orderRepository.findById(req.orderId)

        // elseの条件ないのがちょっと気持ち悪いけど... 条件逆にして適当にロギングでもOK
        if (order.needToRequest()) {
            val requestMethod = Request.fromTelOrEmail(req.tel, req.email)
            val remainedAmount = order.getRemainedAmount()
            val request = Request.of(requestMethod, remainedAmount)

            requestRepository.save(request)
        }
    }
}
