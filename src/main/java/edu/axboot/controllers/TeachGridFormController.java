package edu.axboot.controllers;

import com.chequer.axboot.core.api.response.ApiResponse;
import com.chequer.axboot.core.api.response.Responses;
import com.chequer.axboot.core.controllers.BaseController;
import com.chequer.axboot.core.parameter.RequestParams;
import edu.axboot.domain.education.EducationTeach;
import edu.axboot.domain.education.EducationTeachService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping(value = "/api/v1/education/teachGridForm")
public class TeachGridFormController extends BaseController {

    @Inject
    private EducationTeachService educationTeachService;

    @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse list(@RequestParam(value = "companyNm", required = false) String companyNm,
                                       @RequestParam(value = "ceo", required = false) String ceo,
                                       @RequestParam(value = "bizno", required = false) String bizno,
                                       @RequestParam(value = "useYn", required = false) String useYn) {

        RequestParams<EducationTeach> requestParams = new RequestParams<>();
        requestParams.put("companyNm", companyNm);
        requestParams.put("ceo", ceo);
        requestParams.put("bizno", bizno);
        requestParams.put("useYn", useYn);

        List<EducationTeach> list = educationTeachService.getListUsingQueryDsl(requestParams);
        return Responses.ListResponse.of(list);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public EducationTeach view(@PathVariable Long id) {
        EducationTeach entity = educationTeachService.getOneUsingQueryDsl(id);

        return entity;
    }

    @RequestMapping(method = {RequestMethod.POST}, produces = APPLICATION_JSON)
    public ApiResponse save(@RequestBody EducationTeach request) {
        educationTeachService.saveUsingQueryDsl(request);
        return ok();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = APPLICATION_JSON)
    public ApiResponse remove(@PathVariable Long id) {
        educationTeachService.deleteUsingQueryDsl(id);
        return ok();
    }
}
