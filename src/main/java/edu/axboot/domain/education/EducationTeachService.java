package edu.axboot.domain.education;

import com.chequer.axboot.core.parameter.RequestParams;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import edu.axboot.domain.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EducationTeachService extends BaseService<EducationTeach, Long> {
    private EducationTeachRepository educationTeachRepository;

    @Inject
    private EducationTeachMapper educationTeachMapper;

    @Inject
    public EducationTeachService(EducationTeachRepository educationTeachRepository) {
        super(educationTeachRepository);
        this.educationTeachRepository = this.educationTeachRepository;
    }

    // JPA
    public List<EducationTeach> getListUsingJpa(RequestParams<EducationTeach> requestParams) {
        List<EducationTeach> list2 = this.getFilter(findAll(), requestParams.getString("companyNm", ""), 1);
        List<EducationTeach> list3 = this.getFilter(list2, requestParams.getString("ceo", ""), 2);
        List<EducationTeach> list4 = this.getFilter(list3, requestParams.getString("bizno", ""), 3);
        List<EducationTeach> list5 = this.getFilter(list4, requestParams.getString("useYn", ""), 4);

        return list5;
    }

    private List<EducationTeach> getFilter(List<EducationTeach> sources, String filter, int typ) {
        List<EducationTeach> targets = new ArrayList<EducationTeach>();
        for (EducationTeach entity: sources) {
            if ("".equals(filter)) {
                targets.add(entity);
            } else {
                if (typ == 1) {
                    if (entity.getCompanyNm().contains(filter)){
                        targets.add(entity);
                    }
                } else if (typ == 2) {
                    if (entity.getCeo().contains(filter)){
                        targets.add(entity);
                    }
                } else if (typ == 3) {
                    if (entity.getBizno().equals(filter)){
                        targets.add(entity);
                    }
                } else if (typ == 4) {
                    if (entity.getUseYn().equals(filter)){
                        targets.add(entity);
                    }
                }
            }
        }
        return targets;
    }

    // QueryDSL
    public List<EducationTeach> getListUsingQueryDsl(RequestParams<EducationTeach> requestParams) {
        String companyNm = requestParams.getString("companyNm", "");
        String ceo = requestParams.getString("ceo", "");
        String bizno = requestParams.getString("bizno", "");
        String useYn = requestParams.getString("useYn", "");

        BooleanBuilder builder = new BooleanBuilder();

        if (isNotEmpty(companyNm)) {
            builder.and(qEducationTeach.companyNm.contains(companyNm));
        }
        if (isNotEmpty(ceo)) {
            builder.and(qEducationTeach.ceo.like("%" + ceo +"%"));
        }
        if (isNotEmpty(bizno)) {
            builder.and(qEducationTeach.bizno.like(bizno + "%"));
        }
        if (isNotEmpty(useYn)) {
            builder.and(qEducationTeach.useYn.eq(useYn));
        }

        List<EducationTeach> list = select()
                .from(qEducationTeach)
                .where(builder)
                .orderBy(qEducationTeach.companyNm.asc())
                .fetch();

        return list;
    }

    public EducationTeach getOneUsingQueryDsl(Long id) {
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(qEducationTeach.id.eq(id));

        EducationTeach entity = select()
                .from(qEducationTeach)
                .where(builder)
                .fetchOne();

        return entity;
    }

    @Transactional
    public void saveUsingQueryDsl(EducationTeach entity) {
        if (entity.getId() == null || entity.getId() == 0) {
            this.educationTeachRepository.save(entity);
        } else {
            update(qEducationTeach)
                    .set(qEducationTeach.companyNm, entity.getCompanyNm())
                    .set(qEducationTeach.ceo, entity.getCeo())
                    .set(qEducationTeach.bizno, entity.getBizno())
                    .set(qEducationTeach.tel, entity.getTel())
                    .set(qEducationTeach.zip, entity.getZip())
                    .set(qEducationTeach.address, entity.getAddress())
                    .set(qEducationTeach.addressDetail, entity.getAddressDetail())
                    .set(qEducationTeach.email, entity.getEmail())
                    .set(qEducationTeach.remark, entity.getRemark())
                    .set(qEducationTeach.useYn, entity.getUseYn())
                    .where(qEducationTeach.id.eq(entity.getId()))
                    .execute();
        }
    }

    @Transactional
    public void deleteUsingQueryDsl(Long id) {
        delete(qEducationTeach).where(qEducationTeach.id.eq(id)).execute();
    }

    // MyBatis
    public List<EducationTeach> getListUsingMyBatis(RequestParams<EducationTeach> requestParams) {
        String companyNm = requestParams.getString("companyNm", "");
        String ceo = requestParams.getString("ceo", "");
        String bizno = requestParams.getString("bizno", "");
        String useYn = requestParams.getString("useYn", "");

        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("companyNm", companyNm);
        params.put("ceo", ceo);
        params.put("bizno", bizno);
        params.put("useYn", useYn);

        List<EducationTeach> list = educationTeachMapper.selectList(params);

        return list;
    }

    public EducationTeach getOneUsingMyBatis(Long id) {
        return educationTeachMapper.selectOne(id);
    }

    public void saveUsingMyBatis(EducationTeach entity) {
        if (entity.getId() == null || entity.getId() == 0) {
            educationTeachMapper.insert(entity);
        } else if (entity.isModified()) {
            educationTeachMapper.update(entity);
        } else if (entity.isDeleted()) {
            educationTeachMapper.delete(entity.getId());
        }
    }

    public void deleteUsingMybatis(Long id) {
        educationTeachMapper.delete(id);
    }

    public List<EducationTeach> getList(RequestParams<EducationTeach> requestParams) {
        return getListUsingQueryDsl(requestParams);
    }

    public Page<EducationTeach> getPage(RequestParams<EducationTeach> requestParams) {
        List<EducationTeach> list = this.getList(requestParams);
        Pageable pageable = requestParams.getPageable();
        int start = (int)pageable.getOffset();
        int end = (start + pageable.getPageSize() > list.size() ? list.size() : (start + pageable.getPageSize()));
        Page<EducationTeach> pages = new PageImpl<>(list.subList(start, end), pageable, list.size());
        return pages;
    }
}