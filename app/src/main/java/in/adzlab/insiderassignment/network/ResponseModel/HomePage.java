package in.adzlab.insiderassignment.network.ResponseModel;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.List;

import in.adzlab.insiderassignment.model.FilterCollection;
import in.adzlab.insiderassignment.model.Lists;
import in.adzlab.insiderassignment.model.Sorter;

/**
 * Created by adityagohad on 25/12/17.
 */

public class HomePage implements Parcelable {
    Lists list;
    List<String> groups;
    HashMap<String, FilterCollection> filters;
    HashMap<String, List<Sorter>> sorters;

    protected HomePage(Parcel in) {
        list = in.readParcelable(Lists.class.getClassLoader());
        groups = in.createStringArrayList();
        filters = in.readHashMap(FilterCollection.class.getClassLoader());
        sorters = in.readHashMap(Sorter.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(list, flags);
        dest.writeStringList(groups);
        dest.writeMap(filters);
        dest.writeMap(sorters);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<HomePage> CREATOR = new Creator<HomePage>() {
        @Override
        public HomePage createFromParcel(Parcel in) {
            return new HomePage(in);
        }

        @Override
        public HomePage[] newArray(int size) {
            return new HomePage[size];
        }
    };

    public Lists getList() {
        return list;
    }

    public List<String> getGroups() {
        return groups;
    }

    public HashMap<String, FilterCollection> getFilters() {
        return filters;
    }
}
