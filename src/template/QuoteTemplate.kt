package nl.kabisa.hackathon.template

import io.ktor.html.Placeholder
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.*

class QuoteTemplate : Template<HTML> {

    val quote = Placeholder<FlowContent>()

    override fun HTML.apply() {
        head {
            title { +"Kabisa Quotes" }
        }
        body {
            h1 { +"Random Quote" }

            p { insert(quote) }
        }
    }
}