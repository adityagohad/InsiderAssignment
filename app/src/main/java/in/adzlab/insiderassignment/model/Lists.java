package in.adzlab.insiderassignment.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adityagohad on 25/12/17.
 */

public class Lists implements Parcelable{
    HashMap<String, InsiderEvent> masterList;
    HashMap<String, List<String>> groupwiseList;

    protected Lists(Parcel in) {
        //this.masterList = (HashMap<String, InsiderEvent>) in.readSerializable();
        this.masterList = in.readHashMap(InsiderEvent.class.getClassLoader());
        this.groupwiseList = in.readHashMap(List.class.getClassLoader());
        //this.groupwiseList = (HashMap<String, List<String>>) in.readSerializable();
    }

    public static final Creator<Lists> CREATOR = new Creator<Lists>() {
        @Override
        public Lists createFromParcel(Parcel in) {
            return new Lists(in);
        }

        @Override
        public Lists[] newArray(int size) {
            return new Lists[size];
        }
    };

    public Map<String, InsiderEvent> getMasterList() {
        return masterList;
    }

    public Map<String, List<String>> getGroupwiseList() {
        return groupwiseList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeMap(this.masterList);
        dest.writeMap(this.groupwiseList);
    }
}
