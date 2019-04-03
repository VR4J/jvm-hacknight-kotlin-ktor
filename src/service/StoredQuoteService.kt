package nl.kabisa.hackathon.service

import com.mongodb.ConnectionString
import nl.kabisa.hackathon.model.OnlineQuote
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection
import java.util.*

class StoredQuoteService : QuoteService {

    private val client = KMongo.createClient()
    private val database = client.getDatabase("quotes")
    private val collection = database.getCollection<OnlineQuote>("quotes")

    override suspend fun getRandomQuote(): String {
        val quotes = collection.find().toList()
        val random = Random().nextInt(quotes.size)

        return quotes[random].quote
    }
}