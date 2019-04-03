package nl.kabisa.hackathon.controller

import io.ktor.application.call
import io.ktor.html.respondHtmlTemplate
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route

import nl.kabisa.hackathon.service.QuoteService
import nl.kabisa.hackathon.template.QuoteTemplate

fun Route.api(service: QuoteService) {
    route("/quotes") {
        get("/random") {
            val quote = service.getRandomQuote()

            call.respondHtmlTemplate(QuoteTemplate()) {
                quote {
                    +quote
                }
            }
        }
    }
}