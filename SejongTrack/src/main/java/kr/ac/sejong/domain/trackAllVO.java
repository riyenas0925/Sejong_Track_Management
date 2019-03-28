package kr.ac.sejong.domain;

public class trackAllVO {
    private String trackNo;
    private String trackAll;

    public String getTrackNo() {
        return trackNo;
    }

    public void setTrackNo(String trackNo) {
        this.trackNo = trackNo;
    }

    public String getTrackAll() {
        return trackAll;
    }

    public void setTrackAll(String trackAll) {
        this.trackAll = trackAll;
    }

    @Override
    public String toString() {
        return "trackAllVO{" +
                "trackNo='" + trackNo + '\'' +
                ", trackAll='" + trackAll + '\'' +
                '}';
    }
}
