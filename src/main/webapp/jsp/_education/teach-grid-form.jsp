<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ax" tagdir="/WEB-INF/tags" %>

<ax:set key="title" value="${pageName}"/>
<ax:set key="page_desc" value="${PAGE_REMARK}"/>
<ax:set key="page_auto_height" value="true"/>

<ax:layout name="base">
    <jsp:attribute name="script">
        <ax:script-lang key="ax.script" var="LANG" />
        <ax:script-lang key="ax.base" var="COL" />
        <script type="text/javascript" src="<c:url value='/assets/js/view/_education/teach-grid-form.js' />"></script>
    </jsp:attribute>
    <jsp:body>

        <ax:page-buttons></ax:page-buttons>

        <div role="page-header">
            <ax:form name="searchView0">
                <ax:tbl clazz="ax-search-tbl" minWidth="500px">
                    <ax:tr>
                        <ax:td label='사용여부' width="200px">
                            <ax:common-code groupCd="USE_YN" clazz="js-useYn" emptyText="전체" />
                        </ax:td>
                        <ax:td label='ax.admin.search' width="300px">
                            <input type="text" name="filter" class="js-filter form-control" placeholder="회사명 / 대표자 / 사업자번호" />
                        </ax:td>
                    </ax:tr>
                </ax:tbl>
            </ax:form>
            <div class="H10"></div>
        </div>

        <ax:split-layout name="ax1" orientation="vertical">
            <ax:split-panel width="350" style="padding-right: 10px;">
                <!-- 목록 -->
                <div class="ax-button-group" data-fit-height-aside="grid-view-01">
                    <div class="left">
                        <h2><i class="cqc-list"></i> 목록(QueryDsl 사용) </h2>
                    </div>
                    <div class="right">
                    </div>
                </div>
                <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 300px;"></div>
            </ax:split-panel>
            <ax:splitter></ax:splitter>
            <ax:split-panel width="*" style="padding-left: 10px;">
                <div data-fit-height-aside="form-view-01">
                    <div class="ax-button-group">
                        <div class="left">
                            <h2><i class="cqc-news"></i> 상세 정보(QueryDsl 사용) </h2>
                        </div>
                        <div class="right">
                            <button type="button" class="btn btn-default" data-form-view-01-btn="form-clear">
                                <i class="cqc-erase"></i> <ax:lang id="ax.admin.clear"/>
                            </button>
                        </div>
                    </div>

                    <form name="form" class="js-form">
                        <ax:tbl clazz="ax-form-tbl" minWidth="500px">
                            <ax:tr labelWidth="120px">
                                <ax:td label="ID" width="50%">
                                    <input type="text" name="id" data-ax-path="id" class="form-control" readonly="readonly">
                                </ax:td>
                                <ax:td label="ax.base.use.or.not" width="50%">
                                    <ax:common-code groupCd="USE_YN" dataPath="useYn" />
                                </ax:td>
                            </ax:tr>

                            <ax:tr labelWidth="120px">
                                <ax:td label="회사명" width="50%">
                                    <input type="text" name="companyNm" data-ax-path="companyNm" title="회사명" class="form-control" data-ax-validate="required" />
                                </ax:td>
                                <ax:td label="대표자" width="50%">
                                    <input type="text" name="ceo" data-ax-path="ceo" class="form-control"  />
                                </ax:td>
                            </ax:tr>

                            <ax:tr labelWidth="120px">
                                <ax:td label="사업자번호" width="50%">
                                    <input type="text" name="bizno" data-ax-path="bizno" title="사업자번호" data-ax5formatter="bizno" class="form-control" placeholder="000-00-00000" />
                                </ax:td>
                                <ax:td label="전화번호" width="50%">
                                    <input type="text" name="tel" data-ax-path="tel" class="form-control" />
                                </ax:td>
                            </ax:tr>

                            <ax:tr labelWidth="120px">
                                <ax:td label="이메일" width="50%">
                                    <input type="text" name="email" data-ax-path="email" title="이메일" class="form-control" placeholder="x@x.xx" />
                                </ax:td>
                                <ax:td label="우편번호" width="50%">
                                    <input type="text" name="zip" data-ax-path="zip" class="form-control" />
                                </ax:td>
                            </ax:tr>
                            <ax:tr labelWidth="120px">
                                <ax:td label="주소" width="100%">
                                    <input type="text" name="address" data-ax-path="address" class="form-control" />
                                </ax:td>
                            </ax:tr>

                            <ax:tr labelWidth="120px">
                                <ax:td label="상세 주소" width="100%">
                                    <input type="text" name="addressDetail" data-ax-path="addressDetail" class="form-control" />
                                </ax:td>
                            </ax:tr>

                            <ax:tr labelWidth="120px">
                                <ax:td label="비고" width="100%">
                                    <textarea name="remark" data-ax-path="remark" rows="5" class="form-control"></textarea>
                                </ax:td>
                            </ax:tr>

                        </ax:tbl>
                    </form>
                </div>
            </ax:split-panel>
        </ax:split-layout>

    </jsp:body>
</ax:layout>