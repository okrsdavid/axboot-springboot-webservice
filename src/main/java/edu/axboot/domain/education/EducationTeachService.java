package edu.axboot.domain.education;

import com.chequer.axboot.core.api.ApiException;
import com.chequer.axboot.core.parameter.RequestParams;
import com.querydsl.core.BooleanBuilder;
import edu.axboot.domain.BaseService;
import edu.axboot.domain.file.CommonFile;
import edu.axboot.domain.file.CommonFileService;
import org.apache.commons.io.FileUtils;
import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.ReaderConfig;
import org.jxls.reader.XLSReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.inject.Inject;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EducationTeachService extends BaseService<EducationTeach, Long> {
    private static final Logger logger = LoggerFactory.getLogger(EducationTeachService.class);

    @Value("${axboot.upload.repository}")
    public String uploadRepository;

    private EducationTeachRepository educationTeachRepository;

    @Inject
    private EducationTeachMapper educationTeachMapper;

    @Inject
    private CommonFileService commonFileService;

    @Inject
    public EducationTeachService(EducationTeachRepository educationTeachRepository) {
        super(educationTeachRepository);
        this.educationTeachRepository = educationTeachRepository;
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

    // ---------------------------------------------------------------------------
    // [ region : QueryDsl 사용하는 셈플 ]
    public List<EducationTeach> getListUsingQueryDsl(RequestParams<EducationTeach> requestParams) {
        String companyNm = requestParams.getString("companyNm", "");
        String ceo = requestParams.getString("ceo", "");
        String bizno = requestParams.getString("bizno", "");
        String useYn = requestParams.getString("useYn", "");
        String filter = requestParams.getFilter();

        logger.info("회사명 : " + companyNm);
        logger.info("대표자 : " + ceo);
        logger.info("사업자번호 : " + bizno);
        logger.info("사용여부 : " + useYn);
        logger.info("검색 : " + filter);

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

        if (isNotEmpty(filter)) {
            builder.and(qEducationTeach.companyNm.contains(filter)
                    .or(qEducationTeach.ceo.like("%" + filter + "%"))
                    .or(qEducationTeach.bizno.like(filter + "%"))
            );
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
    public void deleteUsingQueryDsl(List<Long> ids) {
        for (Long id : ids) {
            deleteUsingQueryDsl(id);
        }
    }

    @Transactional
    public void deleteUsingQueryDsl(Long id) {
        delete(qEducationTeach).where(qEducationTeach.id.eq(id)).execute();
    }
    // [ endregion : QueryDsl 사용하는 셈플 ] ---------------------------------------

    // ---------------------------------------------------------------------------
    // [ region : MyBatis 사용하는 셈플 ]
    public Page<EducationTeach> getPageUsingMyBatis(RequestParams<EducationTeach> requestParams) {
        String companyNm = requestParams.getString("companyNm", "");
        String ceo = requestParams.getString("ceo", "");
        String bizno = requestParams.getString("bizno", "");
        String useYn = requestParams.getString("useYn", "");
        String filter = requestParams.getFilter();

        if (!"".equals(useYn) && !"Y".equals(useYn) && !"N".equals(useYn)) {
            throw new RuntimeException("Y 아니면 N 입력하세요~");
        }

        Pageable pageable = requestParams.getPageable();
        HashMap<String, Object> params = new HashMap<>();
        params.put("pageNumber", pageable.getPageNumber());
        params.put("pageSize", pageable.getPageSize());
        params.put("companyNm", companyNm);
        params.put("ceo", ceo);
        params.put("bizno", bizno);
        params.put("useYn", useYn);
        params.put("filter", filter);

        List<EducationTeach> list = educationTeachMapper.selectPage(params);
        int count = educationTeachMapper.selectCount(params);
        Page<EducationTeach> page = new PageImpl<>(list, pageable, count);
        return page;
    }

    public EducationTeach getOneUsingMyBatis(Long id) {
        return educationTeachMapper.selectOne(id);
    }

    @Transactional
    public void saveUsingMyBatis(EducationTeach entity) {
        if (entity.getId() == null || entity.getId() == 0) {
            educationTeachMapper.insert(entity);
        } else if (entity.isDeleted()) {
            educationTeachMapper.delete(entity.getId());
        } else {
            educationTeachMapper.update(entity);
        }
    }

    @Transactional
    public void deleteUsingMybatis(List<Long> ids) {
        for (Long id : ids) {
            deleteUsingMybatis(id);
        }
    }

    @Transactional
    public void deleteUsingMybatis(Long id) {
        educationTeachMapper.delete(id);
    }
    // [ endregion : MyBatis 사용하는 셈플 ] ---------------------------------------

    @Transactional
    public String uploadExcelData(Long fileId){
        String resultMsg = "";

        ReaderConfig.getInstance().setSkipErrors(true);

        try {
            XLSReader mainReader = ReaderBuilder.buildFromXML(new ClassPathResource("/excel/education_upload.xml").getInputStream());

            List<EducationTeach> entities = new ArrayList();
            Map beans = new HashMap();
            beans.put("educationList", entities);

            CommonFile commonFile = commonFileService.findOne(fileId);

            String excelFile = uploadRepository + "/" + commonFile.getSaveNm();

            File file = new File(excelFile);

            mainReader.read(FileUtils.openInputStream(file), beans);

            int rowIndex = 1;

            for (EducationTeach entity : entities) {
                if (StringUtils.isEmpty(entity.getCompanyNm())) {
                    resultMsg = String.format("%d 번째 줄의 회사명이 비어있습니다.", rowIndex);
                    throw new ApiException(String.format("%d 번째 줄의 회사명이 비어있습니다.", rowIndex));
                }

                if (StringUtils.isEmpty(entity.getCeo())) {
                    resultMsg = String.format("%d 번째 줄의 대표자가 비어있습니다.", rowIndex);
                    throw new ApiException(String.format("%d 번째 줄의 대표자가 비어있습니다.", rowIndex));
                }

                if (StringUtils.isEmpty(entity.getBizno())) {
                    resultMsg = String.format("%d 번째 줄의 사업자번호가 비어있습니다.", rowIndex);
                    throw new ApiException(String.format("%d 번째 줄의 사업자번호가 비어있습니다.", rowIndex));
                }

                if (StringUtils.isEmpty(entity.getUseYn())) {
                    resultMsg = String.format("%d 번째 줄의 사용여부가 비어있습니다.", rowIndex);
                    throw new ApiException(String.format("%d 번째 줄의 사용여부가 비어있습니다.", rowIndex));
                }

                save(entity);

                rowIndex++;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return resultMsg;
    }

}