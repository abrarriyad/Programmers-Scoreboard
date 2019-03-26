package sample;

public class contest {
    Long contestId;
    String contestName;
    String contestType;
    String contestDuration;
    String contestStartTime;
    public contest(){
    contestName=" ";
    contestId = 0L;
    contestDuration = " ";
    };

    public contest(String contestName,String contestDuration,String contestStartTime ){
        this.contestDuration = contestDuration;
        this.contestName = contestName;
        this.contestStartTime = contestStartTime;
    }

    public Long getContestId() {
        return contestId;
    }

    public void setContestId(Long contestId) {
        this.contestId = contestId;
    }

    public String getContestName() {
        return contestName;
    }

    public void setContestName(String contestName) {
        this.contestName = contestName;
    }

    public String getContestType() {
        return contestType;
    }

    public void setContestType(String contestType) {
        this.contestType = contestType;
    }

    public String getContestDuration() {
        return contestDuration;
    }

    public void setContestDuration(String contestDuration) {
        this.contestDuration = contestDuration;
    }

    public String getContestStartTime() {
        return contestStartTime;
    }

    public void setContestStartTime(String contestStartTime) {
        this.contestStartTime = contestStartTime;
    }
}
