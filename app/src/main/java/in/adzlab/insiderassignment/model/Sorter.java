package in.adzlab.insiderassignment.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by adityagohad on 26/12/17.
 */

public class Sorter implements Parcelable {
    String display;
    String key;
    String type;

    protected Sorter(Parcel in) {
        display = in.readString();
        key = in.readString();
        type = in.readString();
    }

    public static final Creator<Sorter> CREATOR = new Creator<Sorter>() {
        @Override
        public Sorter createFromParcel(Parcel in) {
            return new Sorter(in);
        }

        @Override
        public Sorter[] newArray(int size) {
            return new Sorter[size];
        }
    };

    public String getDisplay() {
        return display;
    }

    public String getKey() {
        return key;
    }

    public String getType() {
        return type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(display);
        dest.writeString(key);
        dest.writeString(type);
    }
}
