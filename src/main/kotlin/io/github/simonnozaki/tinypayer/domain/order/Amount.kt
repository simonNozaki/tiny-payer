package io.github.simonnozaki.tinypayer.domain.order

data class Amount(
    val value: Int
) {
    init {
        if (this.value < 0) {
            // 必要に応じて実行時例外に
            throw RuntimeException()
        }
    }
}
