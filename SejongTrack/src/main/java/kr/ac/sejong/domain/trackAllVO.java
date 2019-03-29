package kr.ac.sejong.domain;

public class trackAllVO {
    private Integer trackNo;
    private String trackTitle;
    private String trackBasic;
    private String trackApplied;
    private String trackIndustry;

    public Integer getTrackNo() {
        return trackNo;
    }

    public void setTrackNo(Integer trackNo) {
        this.trackNo = trackNo;
    }

    public String getTrackTitle() {
        return trackTitle;
    }

    public void setTrackTitle(String trackTitle) {
        this.trackTitle = trackTitle;
    }

    public String getTrackBasic() {
        return trackBasic;
    }

    public void setTrackBasic(String trackBasic) {
        this.trackBasic = trackBasic;
    }

    public String getTrackApplied() {
        return trackApplied;
    }

    public void setTrackApplied(String trackApplied) {
        this.trackApplied = trackApplied;
    }

    public String getTrackIndustry() {
        return trackIndustry;
    }

    public void setTrackIndustry(String trackIndustry) {
        this.trackIndustry = trackIndustry;
    }

    @Override
    public String toString() {
        return "trackAllVO{" +
                "trackNo=" + trackNo +
                ", trackTitle='" + trackTitle + '\'' +
                ", trackBasic='" + trackBasic + '\'' +
                ", trackApplied='" + trackApplied + '\'' +
                ", trackIndustry='" + trackIndustry + '\'' +
                '}';
    }
}
