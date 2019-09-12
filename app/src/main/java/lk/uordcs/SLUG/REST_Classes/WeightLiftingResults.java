package lk.uordcs.SLUG.REST_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeightLiftingResults {

    @SerializedName("Date")
    @Expose
    private String date;
    @SerializedName("Time")
    @Expose
    private String time;
    @SerializedName("MatchNo")
    @Expose
    private Integer matchNo;
    @SerializedName("WeightCategory")
    @Expose
    private String weightCategory;
    @SerializedName("Uni")
    @Expose
    private String uni;
    @SerializedName("PlayerName")
    @Expose
    private String playerName;
    @SerializedName("Snatch")
    @Expose
    private String snatch;
    @SerializedName("Clean_and_Jerk")
    @Expose
    private String cleanAndJerk;
    @SerializedName("Total")
    @Expose
    private String total;
    @SerializedName("Rank")
    @Expose
    private String rank;
    @SerializedName("Gender")
    @Expose
    private String gender;
    @SerializedName("UniName")
    @Expose
    private String uniName;

    @SerializedName("UniID")
    @Expose
    private String uniID;
    @SerializedName("UniName1")
    @Expose
    private String uniName1;

    @SerializedName("UniID1")
    @Expose
    private String uniID1;
    @SerializedName("LogoLink1")
    @Expose
    private String logoLink1;
    @SerializedName("LogoLinks2")
    @Expose
    private String logoLinks2;

    public String getLogoLink1() {
        return logoLink1;
    }

    public void setLogoLink1(String logoLink1) {
        this.logoLink1 = logoLink1;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }



    public String getUniID() {
        return uniID;
    }

    public void setUniID(String uniID) {
        this.uniID = uniID;
    }

    public String getUniName1() {
        return uniName1;
    }

    public void setUniName1(String uniName1) {
        this.uniName1 = uniName1;
    }

    public String getLogoLinks2() {
        return logoLinks2;
    }

    public void setLogoLinks2(String logoLinks2) {
        this.logoLinks2 = logoLinks2;
    }

    public String getUniID1() {
        return uniID1;
    }

    public void setUniID1(String uniID1) {
        this.uniID1 = uniID1;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getMatchNo() {
        return matchNo;
    }

    public void setMatchNo(Integer matchNo) {
        this.matchNo = matchNo;
    }

    public String getWeightCategory() {
        return weightCategory;
    }

    public void setWeightCategory(String weightCategory) {
        this.weightCategory = weightCategory;
    }

    public String getUni() {
        return uni;
    }

    public void setUni(String uni) {
        this.uni = uni;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getSnatch() {
        return snatch;
    }

    public void setSnatch(String snatch) {
        this.snatch = snatch;
    }

    public String getCleanAndJerk() {
        return cleanAndJerk;
    }

    public void setCleanAndJerk(String cleanAndJerk) {
        this.cleanAndJerk = cleanAndJerk;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}