package edu.axboot.domain.education;

import com.chequer.axboot.core.mybatis.MyBatisMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface EducationTeachMapper extends MyBatisMapper {
    List<EducationTeach> selectList(HashMap<String, Object> params);
    EducationTeach selectOne(Long id);
    List<EducationTeach> selectPage(Map<String, Object> map);
    int selectCount(Map<String, Object> map);

    int insert(EducationTeach educationTeach);
    int update(EducationTeach educationTeach);
    int delete(Long id);
}
