var fnObj = {};
var ACTIONS = axboot.actionExtend(fnObj, {
    PAGE_SEARCH: function (caller, act, data) {
        var paramObj = $.extend({}, data, { pageSize: 2 });

        axboot.ajax({
            type: 'GET',
            url: '/api/v1/education/teachexcel',
            data: paramObj,
            callback: function (res) {
                caller.gridView01.setData(res);
            },
            options: {
                // axboot.ajax 함수에 2번째 인자는 필수가 아닙니다. ajax의 옵션을 전달하고자 할때 사용합니다.
                onError: function (err) {
                    console.log(err);
                },
            },
        });

        return false;
    },
    EXCEL_DOWN: function (caller, act, data) {
        var frm = $('.js-form').get(0);
        frm.action = '/api/v1/education/teachexcel/exceldown';
        frm.enctype = 'application/x-www-form-urlencoded';
        frm.submit();
    },

    EXCEL_UPLOAD: function (caller, act, data) {
        var upload = $('#uploadFiles');
        var files = upload.get(0).files;
        if (files.length > 0) {
            var data = new FormData();
            data.append('formFile', files[0]);

            $.ajax({
                type: 'POST',
                url: '/api/v1/education/teachexcel/excelupload',
                dataType: 'json',
                contentType: false,
                processData: false,
                data: data,
                success: function (res) {
                    upload.val('');
                    if (res.status == 200) {
                        alert('업로드 완료');
                    } else {
                        alert('업로드 실패');
                    }
                },
                error: function (xhr, status, error) {
                    alert(status);
                },
            });
        } else {
            alert('업로드할 엑셀 파일을 선택하세요.');
        }
    },
    dispatch: function (caller, act, data) {
        var result = ACTIONS.exec(caller, act, data);
        if (result != 'error') {
            return result;
        } else {
            // 직접코딩
            return false;
        }
    },
});

// fnObj 기본 함수 스타트와 리사이즈
fnObj.pageStart = function () {
    this.pageButtonView.initView();
    this.searchView.initView();
    this.gridView01.initView();

    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
};

fnObj.pageResize = function () {};

fnObj.pageButtonView = axboot.viewExtend({
    initView: function () {
        axboot.buttonClick(this, 'data-page-btn', {
            search: function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            },
            save: function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SAVE);
            },
        });
    },
});

//== view 시작
/**
 * searchView
 */
fnObj.searchView = axboot.viewExtend(axboot.searchView, {
    initView: function () {},
});

/**
 * gridView
 */
fnObj.gridView01 = axboot.viewExtend(axboot.gridView, {
    initView: function () {
        var _this = this;

        this.target = axboot.gridBuilder({
            onPageChange: function (pageNumber) {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH, { pageNumber: pageNumber });
            },
            showRowSelector: true,
            frozenColumnIndex: 0,
            multipleSelect: true,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                { key: 'companyNm', label: COL('company.name'), width: 250, align: 'left' },
                { key: 'ceo', label: COL('company.ceo'), width: 100, align: 'center' },
                { key: 'bizno', label: COL('company.bizno'), width: 100, align: 'center', formatter: 'bizno' },
                { key: 'tel', label: COL('company.tel'), width: 100, align: 'center' },
                { key: 'email', label: COL('company.email'), width: 100, align: 'center' },
                { key: 'useYn', label: COL('use.or.not'), align: 'center' },
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex, { selectedClear: true });
                },
            },
        });

        axboot.buttonClick(this, 'data-grid-view-01-btn', {
            excelUpload: function () {
                ACTIONS.dispatch(ACTIONS.EXCEL_UPLOAD);
            },
            excelDownload: function () {
                ACTIONS.dispatch(ACTIONS.EXCEL_DOWN);
            },
        });
    },
});
