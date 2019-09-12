
package lk.uordcs.SLUG.REST_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CricketResults {

    @SerializedName("Date")
    @Expose
    private String date;
    @SerializedName("Round")
    @Expose
    private String round;
    @SerializedName("Uni1")
    @Expose
    private String uni1;
    @SerializedName("Uni1_Score")
    @Expose
    private Integer uni1Score;
    @SerializedName("Uni1_Wickets")
    @Expose
    private Integer uni1Wickets;
    @SerializedName("Uni1_Overs")
    @Expose
    private String uni1Overs;
    @SerializedName("Uni2")
    @Expose
    private String uni2;
    @SerializedName("Uni2_Score")
    @Expose
    private Integer uni2Score;
    @SerializedName("Uni2_Wickets")
    @Expose
    private Integer uni2Wickets;
    @SerializedName("Uni2_Overs")
    @Expose
    private String uni2Overs;
    @SerializedName("Winner")
    @Expose
    private String winner;
    @SerializedName("MatchNo")
    @Expose
    private Integer matchNo;
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

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public Integer getMatchNo() {
        return matchNo;
    }

    public void setMatchNo(Integer matchNo) {
        this.matchNo = matchNo;
    }


    public String getUni1() {
        return uni1;
    }

    public void setUni1(String uni1) {
        this.uni1 = uni1;
    }

    public Integer getUni1Score() {
        return uni1Score;
    }

    public void setUni1Score(Integer uni1Score) {
        this.uni1Score = uni1Score;
    }

    public Integer getUni1Wickets() {
        return uni1Wickets;
    }

    public void setUni1Wickets(Integer uni1Wickets) {
        this.uni1Wickets = uni1Wickets;
    }

    public String getUni1Overs() {
        return uni1Overs;
    }

    public void setUni1Overs(String uni1Overs) {
        this.uni1Overs = uni1Overs;
    }

    public String getUni2() {
        return uni2;
    }

    public void setUni2(String uni2) {
        this.uni2 = uni2;
    }

    public Integer getUni2Score() {
        return uni2Score;
    }

    public void setUni2Score(Integer uni2Score) {
        this.uni2Score = uni2Score;
    }

    public Integer getUni2Wickets() {
        return uni2Wickets;
    }

    public void setUni2Wickets(Integer uni2Wickets) {
        this.uni2Wickets = uni2Wickets;
    }

    public String getUni2Overs() {
        return uni2Overs;
    }

    public void setUni2Overs(String uni2Overs) {
        this.uni2Overs = uni2Overs;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

}