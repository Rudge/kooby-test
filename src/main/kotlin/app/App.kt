package app

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.jooby.Kooby
import io.jooby.MediaType
import io.jooby.runApp

class App: Kooby({

  encoder(MediaType.json) { ctx, result ->

    val json = jacksonObjectMapper().writeValueAsBytes(result)

    ctx.setDefaultResponseType(MediaType.json)

    json
  }

  get("/") {
    Token(accessToken="access", tokenType="token")
  }
})

fun main(args: Array<String>) {
  runApp(args, App::class)
}

data class Token(val accessToken:String, val tokenType:String)
