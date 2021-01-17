
package org.mousehole.americanairline.amazonbookapi.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookResult implements Parcelable
{

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("imageURL")
    @Expose
    private String imageURL;
    @SerializedName("author")
    @Expose
    private String author;
    public final static Parcelable.Creator<BookResult> CREATOR = new Creator<BookResult>() {


        @SuppressWarnings({
            "unchecked"
        })
        public BookResult createFromParcel(Parcel in) {
            return new BookResult(in);
        }

        public BookResult[] newArray(int size) {
            return (new BookResult[size]);
        }

    }
    ;

    protected BookResult(Parcel in) {
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.imageURL = ((String) in.readValue((String.class.getClassLoader())));
        this.author = ((String) in.readValue((String.class.getClassLoader())));
    }

    public BookResult() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(title);
        dest.writeValue(imageURL);
        dest.writeValue(author);
    }

    public int describeContents() {
        return  0;
    }

}
