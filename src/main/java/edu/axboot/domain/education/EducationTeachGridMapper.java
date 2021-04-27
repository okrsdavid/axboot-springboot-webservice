package edu.axboot.domain.education;

import com.chequer.axboot.core.mybatis.MyBatisMapper;

import java.util.List;

public interface EducationTeachGridMapper extends MyBatisMapper {
    List<EducationTeachGrid> selectList(EducationTeachGrid educationTeachGrid);
}
