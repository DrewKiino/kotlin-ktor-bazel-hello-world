package service.app.public.api

import io.ktor.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.locations.KtorExperimentalLocationsAPI


class Main {
  companion object {
    @JvmStatic
    @io.ktor.locations.KtorExperimentalLocationsAPI
    fun main(args: Array<String>) {
      println("starting service...")
      embeddedServer(
          Netty,
          watchPaths = listOf("kotlin"),
          host = "0.0.0.0",
          port = 8080,
          module = Application::client
      ).apply {
        start(wait = true)
      }
    }
  }
}

@KtorExperimentalLocationsAPI
fun Application.client() {
  println("Hello, World!")
}