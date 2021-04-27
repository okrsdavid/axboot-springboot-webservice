package edu.axboot.domain.education;

import com.chequer.axboot.core.parameter.RequestParams;
import com.querydsl.core.BooleanBuilder;
import edu.axboot.domain.BaseService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class EducationTeachGridService extends BaseService<EducationTeachGrid, Long> {
    private EducationTeachGridRepository educationTeachGridRepository;

    @Inject
    private EducationTeachGridMapper educationTeachGridMapper;

    @Inject
    public EducationTeachGridService(EducationTeachGridRepository educationTeachGridRepository) {
        super(educationTeachGridRepository);
        this.educationTeachGridRepository = this.educationTeachGridRepository;
    }

    public List<EducationTeachGrid> gets(RequestParams<EducationTeachGrid> requestParams) {
        String type = requestParams.getString("type", "");

        if (type.equals("myBatis")) {
            return this.getMybatisList(requestParams);
        } else {
            return this.getQueryDslList(requestParams);
        }
    }

    public List<EducationTeachGrid> getQueryDslList(RequestParams<EducationTeachGrid> requestParams) {
        String companyNm = requestParams.getString("companyNm", "");
        String ceo = requestParams.getString("ceo", "");
        String bizno = requestParams.getString("bizno", "");
        String useYn = requestParams.getString("useYn", "");

        BooleanBuilder builder = new BooleanBuilder();
        if (isNotEmpty(companyNm)) {
            builder.and(qEducationTeachGrid.companyNm.contains(companyNm));
        }

        if (isNotEmpty(ceo)) {
            builder.and(qEducationTeachGrid.ceo.contains(ceo));
        }

        if (isNotEmpty(bizno)) {
            builder.and(qEducationTeachGrid.bizno.contains(bizno));
        }

        if (isNotEmpty(useYn)) {
            builder.and(qEducationTeachGrid.useYn.eq(useYn));
        }

        List<EducationTeachGrid> list = select()
                .from(qEducationTeachGrid)
                .where(builder)
                .orderBy(qEducationTeachGrid.companyNm.asc())
                .fetch();

        return list;
    }

    public List<EducationTeachGrid> getMybatisList(RequestParams<EducationTeachGrid> requestParams) {
        String companyNm = requestParams.getString("companyNm", "");
        String ceo = requestParams.getString("ceo", "");
        String bizno = requestParams.getString("bizno", "");
        String useYn = requestParams.getString("useYn", "");

        EducationTeachGrid item = new EducationTeachGrid();
        item.setCompanyNm(companyNm);
        item.setCeo(ceo);
        item.setBizno(bizno);
        item.setUseYn(useYn);

        List<EducationTeachGrid> list = educationTeachGridMapper.selectList(item);
        return list;
    }
}