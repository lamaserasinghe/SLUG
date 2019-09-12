package lk.uordcs.SLUG;

import lk.uordcs.SLUG.REST_Classes.BadmintonResults;
import lk.uordcs.SLUG.REST_Classes.BaseballResults;
import lk.uordcs.SLUG.REST_Classes.BasketballResults;
import lk.uordcs.SLUG.REST_Classes.CarromResults;
import lk.uordcs.SLUG.REST_Classes.CricketResults;
import lk.uordcs.SLUG.REST_Classes.ElleResults;
import lk.uordcs.SLUG.REST_Classes.EventSchedule;
import lk.uordcs.SLUG.REST_Classes.FootballResults;
import lk.uordcs.SLUG.REST_Classes.HockeyResults;
import lk.uordcs.SLUG.REST_Classes.IndividualPoomsaeResults;
import lk.uordcs.SLUG.REST_Classes.JumpingResults;
import lk.uordcs.SLUG.REST_Classes.KataResults;
import lk.uordcs.SLUG.REST_Classes.KumiteResults;
import lk.uordcs.SLUG.REST_Classes.LoginApi;
import lk.uordcs.SLUG.REST_Classes.NetballResults;
import lk.uordcs.SLUG.REST_Classes.Notice_;
import lk.uordcs.SLUG.REST_Classes.Points;
import lk.uordcs.SLUG.REST_Classes.RoadRace;
import lk.uordcs.SLUG.REST_Classes.RowingResults;
import lk.uordcs.SLUG.REST_Classes.RugbyFootballResults;
import lk.uordcs.SLUG.REST_Classes.RunningResults;
import lk.uordcs.SLUG.REST_Classes.SingleNotice;

import java.util.List;

import lk.uordcs.SLUG.REST_Classes.SparringResults;
import lk.uordcs.SLUG.REST_Classes.SwimmingIndividualResults;
import lk.uordcs.SLUG.REST_Classes.SwimmingTeamResults;
import lk.uordcs.SLUG.REST_Classes.TTennisResults;
import lk.uordcs.SLUG.REST_Classes.TaekwondoResults;
import lk.uordcs.SLUG.REST_Classes.TeamPoomsaeResults;
import lk.uordcs.SLUG.REST_Classes.TennisResults;
import lk.uordcs.SLUG.REST_Classes.ThrowingResults;
import lk.uordcs.SLUG.REST_Classes.VolleyballResults;
import lk.uordcs.SLUG.REST_Classes.WeightLiftingResults;
import lk.uordcs.SLUG.REST_Classes.WrestlingResults;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ApiInterface {

    @POST("login")
    Call<LoginApi> Login(@Query("NIC") String nic);

    @GET("Notices")
    Call<List<Notice_>> getNotices();

    @GET("RoadRaceResult")
    Call<List<RoadRace>> getRoadRaceResults();

    @GET("Notice/{id}")
    Call<SingleNotice> getSingleNotice(@Query("NoticeID") String noticeID);

    @GET("BadmintonResults")
    Call<List<BadmintonResults>> getBadmintonResults();

    @GET("VolleyballResults")
    Call<List<VolleyballResults>> getVolleyballResults();

    @GET("NetballResults")
    Call<List<NetballResults>> getNetballResults();

    @GET("TTennisResults")
    Call<List<TTennisResults>> getTTennisResults();

    @GET("BaseballResults")
    Call<List<BaseballResults>> getBaseballResults();

    @GET("BasketballResults")
    Call<List<BasketballResults>> getBasketballResults();

    @GET("CricketResults")
    Call<List<CricketResults>> getCricketResults();

    @GET("FootballResults")
    Call<List<FootballResults>> getFootballResults();

    @GET("RugbyFootball")
    Call<List<RugbyFootballResults>> getRugbyFootballResults();

    @GET("RunningHundred")
    Call<List<RunningResults>> getRunningResults();

    @GET("TripleJump")
    Call<List<JumpingResults>> getJumpingResults();

    @GET("JavelinThrow")
    Call<List<ThrowingResults>> getThrowingResults();

    @GET("Schedule")
    Call<List<EventSchedule>> getEventSchedule();

    @GET("Points")
    Call<List<Points>> getPoints();

    @GET("carrom")
    Call<List<CarromResults>> getCarromResults();

    @GET("hockey")
    Call<List<HockeyResults>> getHockeyResults();

    @GET("elle")
    Call<List<ElleResults>> getElleResults();

    @GET("kata")
    Call<List<KataResults>> getKataResults();

    @GET("kumite")
    Call<List<KumiteResults>> getKumiteResults();

    @GET("rowing")
    Call<List<RowingResults>> getRowingResults();

    @GET("taekwondo")
    Call<List<TaekwondoResults>> getTaekwondoResults();

    @GET("wrestling")
    Call<List<WrestlingResults>> getWrestlingResults();

    @GET("HighJump")
    Call<List<JumpingResults>> getHighJumpResults();


    @GET("weightLifting")
    Call<List<WeightLiftingResults>> getWeightLiftingResults();

    @GET("tennisResults")
    Call<List<TennisResults>> getTennisResults();

    @GET("swimmingIndividual")
    Call<List<SwimmingIndividualResults>> getSwimmingIndividual();

    @GET("swimmingTeam")
    Call<List<SwimmingTeamResults>> getSwimmingTeam();

    @GET("sparring")
    Call<List<SparringResults>> getSparringResults();

    @GET("individualPoomsae")
    Call<List<IndividualPoomsaeResults>> getIndividualPoomsaeResults();

    @GET("teamPoomsae")
    Call<List<TeamPoomsaeResults>> getTeamPoomsaeResults();


    @GET("LongJump")
    Call<List<JumpingResults>> getLongJumpResults();

    @GET("TripleJump")
    Call<List<JumpingResults>> getTripleJumpResults();

    @GET("PoleVault")
    Call<List<JumpingResults>> getPoleVaultResults();

    @GET("JavelinThrow")
    Call<List<ThrowingResults>> getJavelinThrowResults();

    @GET("DiscusThrow")
    Call<List<ThrowingResults>> getDiscusThrowResults();

    @GET("ShotPut")
    Call<List<ThrowingResults>> getShotPutResults();

    @GET("hurdles")
    Call<List<RunningResults>> getHurdles();

    @GET("relay")
    Call<List<RunningResults>> getRelay();


}