package lk.uordcs.SLUG.REST_Classes;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SingleNotice {

    @SerializedName("notice")
    @Expose
    private List<String> notice = null;

    public List<String> getNotice() {
        return notice;
    }

    public void setNotice(List<String> notice) {
        this.notice = notice;
    }

}