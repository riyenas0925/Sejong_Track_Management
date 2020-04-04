package kr.ac.sejong.web.dto.uis;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UISLoginResponseDto {
    private String id;
    private String name;

    @Builder
    public UISLoginResponseDto(String id, String name) {
        this.id = id;
        this.name = deleteNamePostfix(name);
    }

    public String deleteNamePostfix(String name) {
        return name.replace(" 님", "");
    }
}
