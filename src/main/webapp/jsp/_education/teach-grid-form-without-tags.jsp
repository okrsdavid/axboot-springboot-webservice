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
        <script type="text/javascript" src="<c:url value='/assets/js/view/_education/teach-grid-form-without-tags.js' />"></script>
    </jsp:attribute>
    <jsp:body>

        <ax:page-buttons></ax:page-buttons>

        <div role="page-header">
            <form name="searchView0">
                <div data-ax-tbl class="ax-search-tbl">
                    <div data-ax-tr>
                        <div data-ax-td style="width:200px">
                            <div data-ax-td-label>사용여부</div>
                            <div data-ax-td-wrap>
                                <select class="js-useYn form-control">
                                    <option value="">전체</option>
                                    <option value="Y">사용</option>
                                    <option value="N">미사용</option>
                                </select>
                            </div>
                        </div>
                        <div data-ax-td style="width:300px">
                            <div data-ax-td-label>검색</div>
                            <div data-ax-td-wrap>
                                <input type="text" name="filter" class="js-filter form-control" placeholder="회사명 / 대표자 / 사업자번호" />
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <div class="H10"></div>
        </div>

        <div data-ax5layout="ax1" role="page-content" data-config="{layout:'split-panel', orientation: 'vertical', splitter: {size: 7}}">
            <div data-split-panel="{width: '350'}">
                <div style="padding-right: 10px;" class="" data-split-panel-wrap="">
                    <!-- 목록 -->
                    <div class="ax-button-group" data-fit-height-aside="grid-view-01">
                        <div class="left">
                            <h2><i class="cqc-list"></i> 목록(MyBatis 사용) </h2>
                        </div>
                        <div class="right">
                        </div>
                    </div>
                    <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 300px;"></div>
                </div>
            </div>
            <div data-splitter="{}" class="split-panel-vertical" ></div>
            <div data-split-panel="{width: '*'}">
                <div style="padding-left: 10px;" class="" data-split-panel-wrap="">
                    <div data-fit-height-aside="form-view-01">
                        <div class="ax-button-group">
                            <div class="left">
                                <h2><i class="cqc-news"></i> 상세 정보(MyBatis 사용) </h2>
                            </div>
                            <div class="right">
                                <button type="button" class="btn btn-default" data-form-view-01-btn="form-clear">
                                    <i class="cqc-erase"></i> 신규
                                </button>
                            </div>
                        </div>
                    </div>

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
                                        <input type="text" name="email" data-ax-path="email" class="form-control" placeholder="x@x.xx" />
                                    </div>
                                </div>
                                <div data-ax-td style="width:50%">
                                    <div data-ax-td-label style="width:120px;">우편번호</div>
                                    <div data-ax-td-wrap>
                                        <input type="text" name="zip" data-ax-path="zip" class="form-control" />
                                    </div>
                                </div>
                            </div>

                            <div data-ax-tr>
                                <div data-ax-td style="width:100%">
                                    <div data-ax-td-label style="width:120px;">주소</div>
                                    <div data-ax-td-wrap>
                                        <input type="text" name="address" data-ax-path="address" class="form-control" />
                                    </div>
                                </div>
                            </div>

                            <div data-ax-tr>
                                <div data-ax-td style="width:100%">
                                    <div data-ax-td-label style="width:120px;">상세 주소</div>
                                    <div data-ax-td-wrap>
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
                </div>
            </div>
        </div>

    </jsp:body>
</ax:layout>