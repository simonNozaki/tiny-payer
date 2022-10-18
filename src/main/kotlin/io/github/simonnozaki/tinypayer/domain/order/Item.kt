package io.github.simonnozaki.tinypayer.domain.order

/**
 * 商品エンティティ
 */
data class Item(
    val id: String,
    val name: String,
    val price: Int
) {
    // TODO 必要に応じてドメイン固有型、振る舞いを設定する
}
