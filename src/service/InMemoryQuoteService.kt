package nl.kabisa.hackathon.service

import java.util.*

class InMemoryQuoteService : QuoteService {

    private val quotes = arrayOf(
        "Together we can change the world, just one random act of kindness at a time.",
        "Goals transform a random walk into a chase.",
        "Natural selection is anything but random."
    )

    override suspend fun getRandomQuote(): String {
        val random = Random().nextInt(quotes.size)
        return quotes[random]
    }
}