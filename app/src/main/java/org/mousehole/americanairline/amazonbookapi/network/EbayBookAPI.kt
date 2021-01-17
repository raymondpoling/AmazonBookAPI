package org.mousehole.americanairline.amazonbookapi.network

import org.mousehole.americanairline.amazonbookapi.model.BookResult
import retrofit2.Call
import retrofit2.http.GET
import org.mousehole.americanairline.amazonbookapi.util.Constants.BOOK_PATH

interface EbayBookAPI {
    @GET(BOOK_PATH)
    fun getBooks() : Call<List<BookResult>>
}