package edu.axboot.controllers;

import com.chequer.axboot.core.api.response.ApiResponse;
import com.chequer.axboot.core.api.response.Responses;
import com.chequer.axboot.core.controllers.BaseController;
import com.chequer.axboot.core.parameter.RequestParams;
import edu.axboot.domain.education.EducationTeachGrid;
import edu.axboot.domain.education.EducationTeachGridService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping(value = "/api/v1/education/teachGrid")
public class EducationTeachGridController extends BaseController {

    @Inject
    private EducationTeachGridService educationTeachGridService;

    @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse list(RequestParams<EducationTeachGrid> requestParams) {
        List<EducationTeachGrid> list = educationTeachGridService.gets(requestParams);
        return Responses.ListResponse.of(list);
    }

    @RequestMapping(method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse save(@RequestBody List<EducationTeachGrid> request) {
        educationTeachGridService.save(request);
        return ok();
    }

}