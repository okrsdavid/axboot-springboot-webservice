package edu.axboot.controllers;

import com.chequer.axboot.core.api.response.ApiResponse;
import com.chequer.axboot.core.api.response.Responses;
import com.chequer.axboot.core.controllers.BaseController;
import com.chequer.axboot.core.parameter.RequestParams;
import edu.axboot.domain.education.EducationTeach;
import edu.axboot.domain.education.EducationTeachService;
import edu.axboot.utils.MiscUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping(value = "/api/v1/education/teachgridform")
public class TeachGridFormController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(TeachGridFormController.class);

    @Inject
    private EducationTeachService educationTeachService;

    // ---------------------------------------------------------------------------
    // [ region : QueryDsl 사용하는 셈플 ]
    @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.PageResponse listUsingQueryDsl(RequestParams<EducationTeach> requestParams) {
        List<EducationTeach> list = educationTeachService.getListUsingQueryDsl(requestParams);
        Page<EducationTeach> page = MiscUtils.toPage(list, requestParams.getPageable());
        return Responses.PageResponse.of(page);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public EducationTeach viewUsingQueryDsl(@PathVariable Long id) {
        EducationTeach entity = educationTeachService.getOneUsingQueryDsl(id);
        return entity;
    }

    @RequestMapping(method = {RequestMethod.POST}, produces = APPLICATION_JSON)
    public ApiResponse saveUsingQueryDsl(@RequestBody EducationTeach request) {
        educationTeachService.saveUsingQueryDsl(request);
        return ok();
    }

    @RequestMapping(method = RequestMethod.DELETE, produces = APPLICATION_JSON)
    public ApiResponse deleteUsingQueryDsl(@RequestParam List<Long> ids) {
        educationTeachService.deleteUsingQueryDsl(ids);
        return ok();
    }
    // [ endregion : QueryDsl 사용하는 셈플 ] ---------------------------------------

    // ---------------------------------------------------------------------------
    // [ region : MyBatis 사용하는 셈플 ]
    @RequestMapping(value = "/mybatis", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.PageResponse listUsingMyBatis(RequestParams<EducationTeach> requestParams) {
        Page<EducationTeach> page = educationTeachService.getPageUsingMyBatis(requestParams);
        return Responses.PageResponse.of(page);
    }

    @RequestMapping(value = "/mybatis/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public EducationTeach viewUsingMyBatis(@PathVariable Long id) {
        EducationTeach entity = educationTeachService.getOneUsingMyBatis(id);
        return entity;
    }

    @RequestMapping(value = "/mybatis", method = {RequestMethod.POST}, produces = APPLICATION_JSON)
    public ApiResponse saveUsingMyBatis(@RequestBody EducationTeach request) {
        educationTeachService.saveUsingMyBatis(request);
        return ok();
    }

    @RequestMapping(value = "/mybatis", method = RequestMethod.DELETE, produces = APPLICATION_JSON)
    public ApiResponse deleteeUsingMyBatis(@RequestParam List<Long> ids) {
        educationTeachService.deleteUsingMybatis(ids);
        return ok();
    }
    // [ endregion : MyBatis 사용하는 셈플 ] ---------------------------------------
}
