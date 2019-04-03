package nl.kabisa.hackathon.service

interface QuoteService {
    suspend fun getRandomQuote() : String
}