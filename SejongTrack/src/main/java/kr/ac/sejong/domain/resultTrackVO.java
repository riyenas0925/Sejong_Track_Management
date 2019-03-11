package kr.ac.sejong.domain;

public class resultTrackVO extends trackVO{
    private Integer percent;

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "resultTrackVO{" +
                "percent=" + percent +
                '}';
    }
}
