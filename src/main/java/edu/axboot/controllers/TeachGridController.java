package edu.axboot.controllers;

import com.chequer.axboot.core.api.response.ApiResponse;
import com.chequer.axboot.core.api.response.Responses;
import com.chequer.axboot.core.controllers.BaseController;
import com.chequer.axboot.core.parameter.RequestParams;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import edu.axboot.domain.education.EducationTeach;
import edu.axboot.domain.education.EducationTeachService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping(value = "/api/v1/education/teachGrid")
public class TeachGridController extends BaseController {

    @Inject
    private EducationTeachService educationTeachService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyNm", value = "회사명", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ceo", value = "대표자", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "bizno", value = "사업자번호", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "useYn", value = "사용유무", dataType = "String", paramType = "query")
    })
    @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse list(RequestParams<EducationTeach> requestParams) {
        List<EducationTeach> list = educationTeachService.getList(requestParams);
        return Responses.ListResponse.of(list);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNumber", value = "페이지번호(0부터시작)", required = true, dataType = "integer", paramType = "query", defaultValue = "0"),
            @ApiImplicitParam(name = "pageSize", value = "페이지크기", required = true, dataType = "integer", paramType = "query", defaultValue = "50"),
            @ApiImplicitParam(name = "companyNm", value = "회사명", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ceo", value = "대표자", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "bizno", value = "사업자번호", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "useYn", value = "사용유무", dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/pages", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.PageResponse pages(RequestParams<EducationTeach> requestParams) {
        Page<EducationTeach> pages = educationTeachService.getPage(requestParams);
        return Responses.PageResponse.of(pages);
    }

    @RequestMapping(method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse save(@RequestBody List<EducationTeach> request) {
        educationTeachService.save(request);
        return ok();
    }

}