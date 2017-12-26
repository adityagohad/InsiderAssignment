package in.adzlab.insiderassignment.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by adityagohad on 26/12/17.
 */

public class Category implements Parcelable{
    String name;

    protected Category(Parcel in) {
        name = in.readString();
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };

    public String getName() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }
}
