package kr.ac.sejong.domain.trackJudge;


import java.util.Arrays;

public enum PercentColorEnum {
    GREEN("#2dce89", "80~100%", 80L, 100L),
    BLUE("#11cdef", "50~79%", 50L, 79L),
    ORANGE("#fb6340", "30~49%", 30L, 49L),
    RED("#f5365c", "0~29%", 0L, 29L);

    private String hex;
    private String text;
    private Long min;
    private Long max;

    PercentColorEnum(String hex, String text, Long min, Long max){
        this.hex = hex;
        this.text = text;
        this.min = min;
        this.max = max;
    }

    public String getText() {
        return text;
    }

    public String getHex() {
        return hex;
    }

    public static PercentColorEnum percentToColor(Double percent){
        return Arrays.stream(PercentColorEnum.values())
                .filter(percentColor -> percentColor.min < Long.valueOf(percent.longValue()))
                .filter(percentColor -> percentColor.max > Long.valueOf(percent.longValue()))
                .findAny()
                .orElse(RED);
    }
}
