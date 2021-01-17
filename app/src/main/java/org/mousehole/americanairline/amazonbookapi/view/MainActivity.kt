package org.mousehole.americanairline.amazonbookapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import org.mousehole.americanairline.amazonbookapi.R
import org.mousehole.americanairline.amazonbookapi.model.BookResult
import org.mousehole.americanairline.amazonbookapi.util.DebugLogger.debugLogger
import org.mousehole.americanairline.amazonbookapi.viewmodel.EbayBookViewModel

class MainActivity : AppCompatActivity() {

    private val liveData : LiveData<List<BookResult>> = EbayBookViewModel.getBookResult()

    private var frameLayout : FrameLayout? = null

    private var bookFragment : BookFragment = BookFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        frameLayout = findViewById(R.id.main_framelayout)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.main_framelayout, bookFragment)
            .commit()

        liveData.observe(this, {
            runOnUiThread {
                bookFragment.updateList(it)
                debugLogger("Output: ${it.size}")
            }
//            it.forEach{debugLogger("""${it.title} by ${if(it.author != null) it.author else "unknown"} with image url length ${it.imageURL.length}""")}})

        })
    }
}