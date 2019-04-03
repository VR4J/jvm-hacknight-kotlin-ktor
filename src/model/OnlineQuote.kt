package nl.kabisa.hackathon.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown =  true)
data class OnlineQuote(val id: String, val author: String, val quote: String, val permalink: String)
