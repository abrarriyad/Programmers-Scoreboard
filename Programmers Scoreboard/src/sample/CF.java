package sample;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.*;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.JSONParser;



public class CF{
    String rank,maxRank;
    String handle;
    Long rating,maxRating;
    private Image photo;
    String imageUrl;
    String name,name1,name2,org;
    Long onlineStatus;
    String onlineStatusFormatted;
    long onlineSeconds;
    long onlineMinutes;
    long onlineHours ;
    long onlineDays;
    Long friends;
    Long contribution;
    ArrayList<Long> rankData;
   public static ArrayList<Long> contestID;
    ArrayList<Long> cid;

    public ArrayList<String> getContestData() {
        return contestData;
    }

    public void setContestData(ArrayList<String> contestData) {
        this.contestData = contestData;
    }

    ArrayList<String> contestData;


    Long contestId;
    String contestName;
    String contestType;
    String contestDurationString;

    List<String> conName = new ArrayList<>();

    String contestPhase;
    Long contestStartTime;
    String startTimeFormatted;
    String relativeTimeFormatted;
    Long contestDuration;
    Long contestRelativeTime;

    Date startTime;
    Date relativeTime;
    boolean checkPhase;

    public CF(){
        this.rank = "";
        this.handle="";
        this.rating= 0L;
        this.org=" ";
    }

    public CF(String handle) throws Exception{
        this.handle = handle;
        getUserInfo(handle);
    }

    public CF(Boolean b) throws Exception{

    }

    public ArrayList<Long> getRankData() {
        return rankData;
    }

    public void setRankData(ArrayList<Long> rankData) {
        this.rankData = rankData;
    }

    public String getContestDurationString() {
        return contestDurationString;
    }

    public void setContestDurationString(String contestDurationString) {
        this.contestDurationString = contestDurationString;
    }

    public String getContestName() {
        return contestName;
    }

    public String getMaxRank() {
        return maxRank;
    }

    public void setMaxRank(String maxRank) {
        this.maxRank = maxRank;
    }

    public Long getMaxRating() {
        return maxRating;
    }

    public void setMaxRating(Long maxRating) {
        this.maxRating = maxRating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public Long getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(Long onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public Long getContestId() {
        return contestId;
    }

    public void setContestId(Long contestId) {
        this.contestId = contestId;
    }

    public String getContestType() {
        return contestType;
    }

    public void setContestType(String contestType) {
        this.contestType = contestType;
    }

    public String getContestPhase() {
        return contestPhase;
    }

    public void setContestPhase(String contestPhase) {
        this.contestPhase = contestPhase;
    }

    public Long getContestRelativeTime() {
        return contestRelativeTime;
    }

    public void setContestRelativeTime(Long contestRelativeTime) {
        this.contestRelativeTime = contestRelativeTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getRelativeTime() {
        return relativeTime;
    }

    public void setRelativeTime(Date relativeTime) {
        this.relativeTime = relativeTime;
    }

    public void setContestName(String contestName) {
        this.contestName = contestName;
    }

    public Long getContestStartTime() {
        return contestStartTime;
    }

    public void setContestStartTime(Long contestStartTime) {
        this.contestStartTime = contestStartTime;
    }

    public Long getContestDuration() {
        return contestDuration;
    }

    public void setContestDuration(Long contestDuration) {
        this.contestDuration = contestDuration;
    }



    public Image getPhoto() throws Exception {
        getUserInfo(handle);
        photo = new Image(imageUrl);
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    public Long getRating() throws Exception {

       return rating;
    }


    public void setRating(Long rating) {
        this.rating = rating;
    }

    public String getRank() throws Exception {

        return rank;

    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public static ArrayList<Long> getContestID() {
        return contestID;
    }

    public static void setContestID(ArrayList<Long> contestID) {
        CF.contestID = contestID;
    }

    //cf api

    public JSONArray getData(String url) throws Exception
    {
        URL contestUrl = new URL(""+url);
        URLConnection con = contestUrl.openConnection();
        InputStream is = con.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        JSONArray result = null;
        String line=null;
        while((line=br.readLine())!=null) {

            JSONParser parser = new JSONParser();
            JSONObject jsonObject;
            jsonObject = (JSONObject) parser.parse(line);
            result = (JSONArray) jsonObject.get("result");

        }
        return result;
    }




    //get User Data

    public String getOnlineStatusFormatted() {
        return onlineStatusFormatted;
    }

    public void setOnlineStatusFormatted(String onlineStatusFormatted) {
        this.onlineStatusFormatted = onlineStatusFormatted;
    }

    //Get Rank Graph Data

    public ArrayList<Long> getRankGraph(String handle) throws Exception
    {
        JSONArray result = getData(" http://codeforces.com/api/user.rating?handle="+handle);
        rankData = new ArrayList<>();
        cid = new ArrayList<>();
        for(int i=0; i<result.size(); i++){
            JSONObject element = (JSONObject) result.get(i);
            //System.out.println(element.get("rank"));

           rankData.add((Long) element.get("rank"));
//           //contestData.add((String)element.get("contestName"));
           //System.out.println(element.get("rank"));

            cid.add((Long) element.get("contestId"));
        }
        setContestID(cid);
        return rankData;
    }




    public void getUserInfo(String h)throws Exception

    {


        JSONArray result = getData("http://codeforces.com/api/user.info?handles=" + h);

        for (int i = 0; i < result.size(); i++) {
            JSONObject element = (JSONObject) result.get(i);
            rank = (String) element.get("rank");
            maxRank = (String) element.get("maxRank");
            rating = (Long) element.get("rating");
            maxRating = (Long) element.get("maxRating");
            imageUrl = (String) element.get("titlePhoto");
            name1 = (String) element.get("firstName");

            name2 = (String) element.get("lastName");
            name = name1.concat(" ").concat(name2);
            org = (String) element.get("organization");
            onlineStatus = (Long) element.get("lastOnlineTimeSeconds");
            friends = (Long) element.get("friendOfCount");
            contribution = (Long) element.get("contribution");

            long  on = onlineStatus*1000L;
            Date online = new Date(on);
            long now = System.currentTimeMillis();

            Date nowTime = new Date(now);
            SimpleDateFormat sdf = new SimpleDateFormat("MMM-dd-yyyy HH:mm:ss");
            String a  =sdf.format(online);
            String b = sdf.format(nowTime);

            SimpleDateFormat sd = new SimpleDateFormat("MMM-dd-yyyy HH:mm:ss");

            Date d1 =   sd.parse(a);
            Date d2 =   sd.parse(b);
            long diff = d2.getTime()- d1.getTime(); //in milli second

             onlineSeconds = diff / 1000 % 60;
             onlineMinutes = diff / (60 * 1000) % 60;
             onlineHours = diff / (60 * 60 * 1000) % 24;
             onlineDays = diff / (24 * 60 * 60 * 1000);




        }


        //Get Contest Related Data
    }

    public List<String> getConName() {
        return conName;
    }

    public void setConName(List<String> conName) {
        this.conName = conName;
    }

    public void setConName(ArrayList<String> conName) {
        this.conName = conName;
    }

    public ObservableList<contest> getContestInfo(boolean b) throws Exception {
        ObservableList<contest> contestList = FXCollections.observableArrayList();

        JSONArray result = getData("http://codeforces.com/api/contest.list?gym=" + b);

        contest[] contestObj = new contest[result.size()];
        for (int i = 0; i < result.size(); i++) {
            JSONObject element = (JSONObject) result.get(i);
            contestObj = new contest[result.size()];
            contestObj[i] = new contest();

            contestName = (String) element.get("name");
            conName.add(contestName);
            conName.add("\n");

            contestType = (String) element.get("type");
            contestPhase = (String) element.get("phase");
            contestStartTime = (Long) element.get("startTimeSeconds");
            contestId = (Long) element.get("id");
            contestDuration = (Long) element.get("durationSeconds");
            contestDuration = TimeUnit.SECONDS.toHours(contestDuration);
            contestDurationString = contestDuration.toString().concat(" Hours");
            contestRelativeTime = (Long) element.get("relativeTimeSeconds");
            startTime = new Date(contestStartTime*1000L);
            SimpleDateFormat sdf = new SimpleDateFormat("MMM-dd-yyyy HH:mm ");
            sdf.setTimeZone(TimeZone.getTimeZone("UTC+6"));
            startTimeFormatted = sdf.format(startTime);
            relativeTime = new Date((Long) contestRelativeTime * 1000L);
            relativeTimeFormatted = sdf.format(relativeTime);

            //if(contestType.equals("CF") && contestPhase.equals("BEFORE"))
            // System.out.println(contestName);

            contestObj[i].setContestName(contestName);
            //System.out.println(contestObj[].getContestName());
            contestObj[i].setContestDuration(contestDurationString);
            contestObj[i].setContestStartTime(startTimeFormatted);
            if(contestPhase.equals("BEFORE"))
            contestList.add(contestObj[i]);
        }
        return contestList;
    }
}


