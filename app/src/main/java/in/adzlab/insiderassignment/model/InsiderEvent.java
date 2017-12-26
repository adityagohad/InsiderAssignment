package in.adzlab.insiderassignment.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by adityagohad on 25/12/17.
 */

public class InsiderEvent implements Parcelable {
    long min_show_start_time;
    String horizontal_cover_image;
    String name;
    String city;
    String venue_name;
    String venue_date_string;
    boolean is_rsvp;
    String event_state;
    String price_display_string;
    int min_price;
    List<String> applicable_filters;
    Category category_id;

    protected InsiderEvent(Parcel in) {
        min_show_start_time = in.readLong();
        horizontal_cover_image = in.readString();
        name = in.readString();
        city = in.readString();
        venue_name = in.readString();
        venue_date_string = in.readString();
        is_rsvp = in.readByte() != 0;
        event_state = in.readString();
        price_display_string = in.readString();
        min_price = in.readInt();
        applicable_filters = in.createStringArrayList();
        category_id = in.readParcelable(Category.class.getClassLoader());
    }

    public static final Creator<InsiderEvent> CREATOR = new Creator<InsiderEvent>() {
        @Override
        public InsiderEvent createFromParcel(Parcel in) {
            return new InsiderEvent(in);
        }

        @Override
        public InsiderEvent[] newArray(int size) {
            return new InsiderEvent[size];
        }
    };

    public long getMin_show_start_time() {
        return min_show_start_time;
    }

    public String getHorizontal_cover_image() {
        return horizontal_cover_image;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getVenue_name() {
        return venue_name;
    }

    public String getVenue_date_string() {
        return venue_date_string;
    }

    public boolean is_rsvp() {
        return is_rsvp;
    }

    public String getEvent_state() {
        return event_state;
    }

    public String getPrice_display_string() {
        return price_display_string;
    }

    public int getMin_price() {
        return min_price;
    }

    public List<String> getApplicable_filters() {
        return applicable_filters;
    }

    public Category getCategory_id() {
        return category_id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(min_show_start_time);
        dest.writeString(horizontal_cover_image);
        dest.writeString(name);
        dest.writeString(city);
        dest.writeString(venue_name);
        dest.writeString(venue_date_string);
        dest.writeByte((byte) (is_rsvp ? 1 : 0));
        dest.writeString(event_state);
        dest.writeString(price_display_string);
        dest.writeInt(min_price);
        dest.writeStringList(applicable_filters);
        dest.writeParcelable(category_id, flags);
    }
}
