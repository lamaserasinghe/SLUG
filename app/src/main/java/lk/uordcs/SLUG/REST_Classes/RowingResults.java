package lk.uordcs.SLUG.REST_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RowingResults {

    @SerializedName("Date")
    @Expose
    private String date;
    @SerializedName("Time")
    @Expose
    private String time;
    @SerializedName("MatchNo")
    @Expose
    private Integer matchNo;
    @SerializedName("Gender")
    @Expose
    private String gender;
    @SerializedName("MatchCategory")
    @Expose
    private String matchCategory;
    @SerializedName("Uni")
    @Expose
    private String uni;
    @SerializedName("Player1")
    @Expose
    private String player1;
    @SerializedName("Player2")
    @Expose
    private String player2;
    @SerializedName("Player3")
    @Expose
    private String player3;
    @SerializedName("Player4")
    @Expose
    private String player4;
    @SerializedName("FinishTime")
    @Expose
    private String finishTime;
    @SerializedName("Rank")
    @Expose
    private Integer rank;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMatchCategory() {
        return matchCategory;
    }

    public void setMatchCategory(String matchCategory) {
        this.matchCategory = matchCategory;
    }

    public String getUni() {
        return uni;
    }

    public void setUni(String uni) {
        this.uni = uni;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getPlayer3() {
        return player3;
    }

    public void setPlayer3(String player3) {
        this.player3 = player3;
    }

    public String getPlayer4() {
        return player4;
    }

    public void setPlayer4(String player4) {
        this.player4 = player4;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

}