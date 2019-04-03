package nl.kabisa.hackathon.service

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JacksonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.get
import io.ktor.client.request.url
import nl.kabisa.hackathon.model.OnlineQuote
import org.apache.commons.text.StringEscapeUtils
import java.net.URL
import java.util.*

class OnlineQuoteService : QuoteService {

    private val quoteApi = URL("http://quotes.stormconsultancy.co.uk/quotes.json")

    override suspend fun getRandomQuote(): String {
        val client = HttpClient {
            install(JsonFeature) {
                serializer = JacksonSerializer()
            }
        }

        val quotes = client.get<List<OnlineQuote>> {
            url(quoteApi)
        }

        val random = Random().nextInt(quotes.size)

        return quotes[random].quote
    }
}