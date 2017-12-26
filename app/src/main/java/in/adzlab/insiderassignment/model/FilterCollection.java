package in.adzlab.insiderassignment.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by adityagohad on 26/12/17.
 */

public class FilterCollection implements Parcelable{
    List<Filter> show;

    protected FilterCollection(Parcel ini) {
        show = ini.createTypedArrayList(Filter.CREATOR);
    }

    public static final Creator<FilterCollection> CREATOR = new Creator<FilterCollection>() {
        @Override
        public FilterCollection createFromParcel(Parcel in) {
            return new FilterCollection(in);
        }

        @Override
        public FilterCollection[] newArray(int size) {
            return new FilterCollection[size];
        }
    };

    public List<Filter> getShow() {
        return show;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(show);
    }
}
