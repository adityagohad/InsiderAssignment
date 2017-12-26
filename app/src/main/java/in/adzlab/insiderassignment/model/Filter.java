package in.adzlab.insiderassignment.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by adityagohad on 26/12/17.
 */

public class Filter implements Parcelable {
    String display;
    String key;
    boolean applied = false;

    protected Filter(Parcel in) {
        display = in.readString();
        key = in.readString();
        applied = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(display);
        dest.writeString(key);
        dest.writeByte((byte) (applied ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Filter> CREATOR = new Creator<Filter>() {
        @Override
        public Filter createFromParcel(Parcel in) {
            return new Filter(in);
        }

        @Override
        public Filter[] newArray(int size) {
            return new Filter[size];
        }
    };

    public Filter(String display, String key, boolean applied) {
        this.display = display;
        this.key = key;
        this.applied = applied;
    }

    public String getDisplay() {
        return display;
    }

    public String getKey() {
        return key;
    }

    public boolean isApplied() {
        return applied;
    }

    public void setApplied(boolean applied) {
        this.applied = applied;
    }
}
