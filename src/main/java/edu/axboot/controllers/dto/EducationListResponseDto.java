package edu.axboot.controllers.dto;

import edu.axboot.domain.education.book.EducationBook;
import lombok.Getter;

@Getter
public class EducationListResponseDto {
    private Long id;
    private String companyNm;
    private String ceo;
    private String bizno;
    private String tel;
    private String email;
    private String useYn;

    public EducationListResponseDto(EducationBook entity) {
        this.id = entity.getId();
        this.companyNm = entity.getCompanyNm();
        this.ceo = entity.getCeo();
        this.bizno = entity.getBizno();
        this.tel = entity.getTel();
        this.email = entity.getEmail();
        this.useYn = entity.getUseYn();
    }
}
