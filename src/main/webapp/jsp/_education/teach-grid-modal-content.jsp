<%@ page import="com.chequer.axboot.core.utils.RequestUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ax" tagdir="/WEB-INF/tags" %>
<%
    RequestUtils requestUtils = RequestUtils.of(request);
    request.setAttribute("id", requestUtils.getString("id"));
%>
<ax:set key="title" value="${pageName}"/>
<ax:set key="page_desc" value="${PAGE_REMARK}"/>
<ax:set key="page_auto_height" value="true"/>
<ax:set key="axbody_class" value="baseStyle"/>

<ax:layout name="modal">
    <jsp:attribute name="script">
        <ax:script-lang key="ax.script" var="LANG" />
        <script>
            var modalParams = {id: "${id}"};
        </script>
        <script type="text/javascript" src="<c:url value='/assets/js/view/_education/teach-grid-modal-content.js' />"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1 class="title">
            <i class="cqc-browser"></i>
            실습용 모달 등록
        </h1>
    </jsp:attribute>
    <jsp:body>

        <ax:page-buttons>
            <button type="button" class="btn btn-default" data-page-btn="close"> 닫기 </button>
            <button type="button" class="btn btn-info" data-page-btn="save"> 저장 </button>
            <button type="button" class="btn btn-fn1" data-page-btn="delete"> 삭제 </button>
        </ax:page-buttons>

        <ax:split-layout name="ax1" orientation="vertical">
            <ax:split-panel width="*" style="padding-right: 0px;">

                <form name="form" class="js-form" onsubmit="return false;">
                    <div data-ax-tbl class="ax-form-tbl">

                        <div data-ax-tr>
                            <div data-ax-td style="width:50%">
                                <div data-ax-td-label style="width:120px;">ID</div>
                                <div data-ax-td-wrap>
                                    <input type="text" name="id" data-ax-path="id" class="form-control" readonly="readonly">
                                </div>
                            </div>
                            <div data-ax-td style="width:50%">
                                <div data-ax-td-label style="width:120px;">사용여부</div>
                                <div data-ax-td-wrap>
                                    <select name="useYn" data-ax-path="useYn" class="form-control">
                                        <option value="Y">사용</option>
                                        <option value="N">미사용</option>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div data-ax-tr>
                            <div data-ax-td style="width:50%">
                                <div data-ax-td-label style="width:120px;">회사명</div>
                                <div data-ax-td-wrap>
                                    <input type="text" name="companyNm" data-ax-path="companyNm" title="회사명" class="form-control" data-ax-validate="required" />
                                </div>
                            </div>
                            <div data-ax-td style="width:50%">
                                <div data-ax-td-label style="width:120px;">대표자</div>
                                <div data-ax-td-wrap>
                                    <input type="text" name="ceo" data-ax-path="ceo" class="form-control" />
                                </div>
                            </div>
                        </div>

                        <div data-ax-tr>
                            <div data-ax-td style="width:50%">
                                <div data-ax-td-label style="width:120px;">사업자번호</div>
                                <div data-ax-td-wrap>
                                    <input type="text" name="bizno" data-ax-path="bizno" title="사업자번호" data-ax5formatter="bizno" class="form-control" placeholder="000-00-00000" />
                                </div>
                            </div>
                            <div data-ax-td style="width:50%">
                                <div data-ax-td-label style="width:120px;">전화번호</div>
                                <div data-ax-td-wrap>
                                    <input type="text" name="tel" data-ax-path="tel" class="form-control" />
                                </div>
                            </div>
                        </div>

                        <div data-ax-tr>
                            <div data-ax-td style="width:50%">
                                <div data-ax-td-label style="width:120px;">이메일</div>
                                <div data-ax-td-wrap>
                                    <input type="text" name="email" data-ax-path="email" class="form-control inline-block" placeholder="x@x.xx" />
                                </div>
                            </div>
                            <div data-ax-td style="width:50%">
                                <div data-ax-td-label style="width:120px;"></div>
                                <div data-ax-td-wrap></div>
                            </div>
                        </div>

                        <div data-ax-tr>
                            <div data-ax-td style="width:100%">
                                <div data-ax-td-label style="width:120px;">주소</div>
                                <div data-ax-td-wrap>
                                    <input type="text" name="zip" data-ax-path="zip" class="form-control inline-block W100" readonly="readonly" />
                                    <button class="btn btn-default" data-form-view-01-btn="addressFind"><i class="cqc-magnifier"></i> 찾기</button>
                                    <div class="H5"></div>
                                    <input type="text" name="address" data-ax-path="address" class="form-control"  readonly="readonly"/>
                                    <div class="H5"></div>
                                    <input type="text" name="addressDetail" data-ax-path="addressDetail" class="form-control" />
                                </div>
                            </div>
                        </div>

                        <div data-ax-tr>
                            <div data-ax-td style="width:100%">
                                <div data-ax-td-label style="width:120px;">비고</div>
                                <div data-ax-td-wrap>
                                    <textarea name="remark" data-ax-path="remark" rows="5" class="form-control"></textarea>
                                </div>
                            </div>
                        </div>

                    </div>
                </form>

            </ax:split-panel>
        </ax:split-layout>

    </jsp:body>
</ax:layout>