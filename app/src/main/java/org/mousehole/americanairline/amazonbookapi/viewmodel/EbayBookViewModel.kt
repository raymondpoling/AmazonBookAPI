package org.mousehole.americanairline.amazonbookapi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.mousehole.americanairline.amazonbookapi.model.BookResult
import org.mousehole.americanairline.amazonbookapi.network.EbayBookNetworkService
import org.mousehole.americanairline.amazonbookapi.util.DebugLogger.debugLogger
import org.mousehole.americanairline.amazonbookapi.util.DebugLogger.errorLogger
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

object EbayBookViewModel : ViewModel() {

    private val executor : ExecutorService = Executors.newCachedThreadPool()

    fun getBookResult() : LiveData<List<BookResult>> {
        val results : MutableLiveData<List<BookResult>> = MutableLiveData()
        executor.execute{
            EbayBookNetworkService.getEbayNetworkService().enqueue( object : Callback<List<BookResult>> {
                override fun onResponse(call: Call<List<BookResult>>, response: Response<List<BookResult>>) {
                    debugLogger("Success!")
                    debugLogger("got: ${response.body()?.size}")
                    results.postValue(response.body())
                }

                override fun onFailure(call: Call<List<BookResult>>, t: Throwable) {
                    errorLogger("Failure!", t)
                }
            })
        }
        return results
    }
}

