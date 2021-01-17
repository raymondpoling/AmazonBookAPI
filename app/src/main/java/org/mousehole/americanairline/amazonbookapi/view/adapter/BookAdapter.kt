package org.mousehole.americanairline.amazonbookapi.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.mousehole.americanairline.amazonbookapi.R
import org.mousehole.americanairline.amazonbookapi.model.BookResult
import org.mousehole.americanairline.amazonbookapi.util.DebugLogger.debugLogger

class BookAdapter(var bookList: List<BookResult>) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val authorTextView : TextView = itemView.findViewById(R.id.author_textview)
        val titleTextView : TextView = itemView.findViewById(R.id.title_textview)
        val thumbnailImageView : ImageView = itemView.findViewById(R.id.thumbnail_imageview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate( R.layout.book_item_layout, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val bookResult = bookList[position]
        holder.authorTextView.text = bookResult.author
        holder.titleTextView.text = bookResult.title
        debugLogger("putting text onto ${bookResult.title}")
        Glide.with(holder.itemView).load(bookResult.imageURL).into(holder.thumbnailImageView)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }
}