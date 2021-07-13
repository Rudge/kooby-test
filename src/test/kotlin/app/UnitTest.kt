package app

import io.jooby.MockRouter
import io.jooby.StatusCode
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.assertEquals

class UnitTest {
  @Test
  fun welcome() {
    val router = MockRouter(App())
    router.get("/") { rsp ->
      assertEquals(Token(accessToken="access", tokenType="token"), rsp.value())
      assertEquals(StatusCode.OK, rsp.statusCode)
    }
  }
}
