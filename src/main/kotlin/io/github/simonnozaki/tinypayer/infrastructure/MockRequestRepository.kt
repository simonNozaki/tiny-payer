package io.github.simonnozaki.tinypayer.infrastructure

import io.github.simonnozaki.tinypayer.domain.request.Request
import io.github.simonnozaki.tinypayer.domain.request.RequestRepository

/**
 * 催促リポジトリ モック実装クラス
 */
class MockRequestRepository : RequestRepository {
    override fun save(request: Request) {
        // なんらかDBに残すならしっかりしたコードにする(今回は本題じゃないので適当でOK)
        println("モックリポジトリの登録対象 => $request")
    }
}
