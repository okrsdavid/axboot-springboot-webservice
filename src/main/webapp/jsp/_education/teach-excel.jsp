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
        <script type="text/javascript" src="<c:url value='/assets/js/view/_education/teach-excel.js' />"></script>
    </jsp:attribute>
    <jsp:body>

        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <form name="excelForm" class="js-form" method="post">
                    <div class="ax-button-group">
                        <div class="left">
                            <input style="display: inline-block;" type="file" name="files[]" id="uploadFiles" accept=".csv, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel" size="40" />
                        </div>
                        <div class="right">
                            <a href="/static/excel-import-test.xlsx" style="text-decoration-line:underline;padding-right: 10px;">테스트할 엑셀파일 다운로드</a>
                            <button type="button" class="btn btn-default" data-grid-view-01-btn="excelUpload"><i class="cqc-circle-with-excel"></i> 엑셀업로드</button>
                            <button type="button" class="btn btn-default" data-grid-view-01-btn="excelDownload"><i class="cqc-circle-with-excel"></i> 엑셀다운</button>
                        </div>
                    </div>
                    </form>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div data-ax5grid="grid-view-01" data-fit-height-content="grid-view-01" style="height: 300px;"></div>
                </div>
            </div>
        </div>
    </jsp:body>
</ax:layout>