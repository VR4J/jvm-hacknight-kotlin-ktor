package nl.kabisa.hackathon

import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import nl.kabisa.hackathon.controller.api
import nl.kabisa.hackathon.service.InMemoryQuoteService
import nl.kabisa.hackathon.service.OnlineQuoteService
import nl.kabisa.hackathon.service.StoredQuoteService


fun main() {
    val service = OnlineQuoteService()

    val server = embeddedServer(Netty, 8080) {
        routing {
            api(service)
        }
    }

    server.start(wait = true)
}
