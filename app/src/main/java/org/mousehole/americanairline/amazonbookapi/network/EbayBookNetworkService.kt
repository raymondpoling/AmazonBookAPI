package org.mousehole.americanairline.amazonbookapi.network

import org.mousehole.americanairline.amazonbookapi.model.BookResult
import org.mousehole.americanairline.amazonbookapi.util.Constants.BASE_URL
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

object EbayBookNetworkService {

    private val executor : ExecutorService = Executors.newCachedThreadPool()

    private val retrofit : Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    private val ebayBookAPI : EbayBookAPI = retrofit.create(EbayBookAPI::class.java)

    fun getEbayNetworkService() : Call<List<BookResult>> {
            return ebayBookAPI.getBooks()
    }
}