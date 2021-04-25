package edu.axboot.domain.education;

import com.chequer.axboot.core.parameter.RequestParams;
import edu.axboot.domain.BaseService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class EducationTeachGridService extends BaseService<EducationTeachGrid, Long> {
    private EducationTeachGridRepository educationTeachGridRepository;

    @Inject
    public EducationTeachGridService(EducationTeachGridRepository educationTeachGridRepository) {
        super(educationTeachGridRepository);
        this.educationTeachGridRepository = this.educationTeachGridRepository;
    }

    public List<EducationTeachGrid> gets(RequestParams<EducationTeachGrid> requestParams) {
        return findAll();
    }

}