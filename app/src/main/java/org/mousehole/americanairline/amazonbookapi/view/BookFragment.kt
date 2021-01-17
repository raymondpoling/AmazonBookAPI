package org.mousehole.americanairline.amazonbookapi.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import org.mousehole.americanairline.amazonbookapi.R
import org.mousehole.americanairline.amazonbookapi.model.BookResult
import org.mousehole.americanairline.amazonbookapi.util.DebugLogger.debugLogger
import org.mousehole.americanairline.amazonbookapi.view.adapter.BookAdapter

class BookFragment : Fragment() {

    private val bookAdapter = BookAdapter(ArrayList())

    private var recyclerView : RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.book_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.book_recycler_view)

        debugLogger("HERE! Setting recycler view")

        recyclerView?.adapter = bookAdapter

    }



    fun updateList(bookList: List<BookResult>) {

        bookAdapter.bookList = bookList.sortedWith(object : Comparator<BookResult> {
            override fun compare(o1: BookResult?, o2: BookResult?): Int {
                val t1 = o1?.title?:""
                val t2 = o2?.title?:""
                if(t1 > t2) {
                    return 1
                } else if(t1 == t2) {
                    return 0
                } else return -1
            }

        })
        bookAdapter.notifyDataSetChanged()
    }
}