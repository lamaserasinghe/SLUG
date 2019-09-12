package lk.uordcs.SLUG.REST_Classes;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Notice {

    @SerializedName("notices")
    @Expose
    private List<Notice_> notices = null;

    public List<Notice_> getNotices() {
        return notices;
    }

    public void setNotices(List<Notice_> notices) {
        this.notices = notices;
    }

}