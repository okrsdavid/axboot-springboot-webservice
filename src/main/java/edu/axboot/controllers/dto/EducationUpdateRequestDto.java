package edu.axboot.controllers.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EducationUpdateRequestDto {
    private String tel;
    private String email;

    @Builder
    public EducationUpdateRequestDto(String tel, String email) {
        this.tel = tel;
        this.email = email;
    }
}
