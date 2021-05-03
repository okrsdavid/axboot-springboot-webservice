var fnObj = {};
var ACTIONS = axboot.actionExtend(fnObj, {
    PAGE_SEARCH: function (caller, act, data) {
        var paramObj = $.extend(caller.searchView.getData(), data);

        axboot.ajax({
            type: 'GET',
            url: '/api/v1/education/teachgrid',
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
    MODAL_OPEN: function (caller, act, data) {
        if (!data) data = {};

        axboot.modal.open({
            width: 780,
            height: 450,
            iframe: {
                param: 'id=' + (data.id || ''),
                url: 'teach-grid-modal-content.jsp',
            },
            header: { title: '모달등록' },
            callback: function (data) {
                if (data && data.dirty) {
                    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                }
                this.close();
            },
        });
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
    initView: function () {
        this.target = $(document['searchView0']);
        this.target.attr('onsubmit', 'return ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);');
        this.target.on('keydown.search', 'input, .form-control', function (e) {
            if (e.keyCode === 13) {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            }
        });

        this.companyNm = $('.js-companyNm');
        this.ceo = $('.js-ceo');
        this.bizno = $('.js-bizno');
        this.useYn = $('.js-useYn').on('change', function () {
            ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
        });
    },
    getData: function () {
        return {
            pageNumber: this.pageNumber || 0,
            pageSize: this.pageSize || 50,
            companyNm: this.companyNm.val(),
            ceo: this.ceo.val(),
            bizno: this.bizno.val(),
            useYn: this.useYn.val(),
        };
    },
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
            showRowSelector: false,
            frozenColumnIndex: 0,
            multipleSelect: true,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                { key: 'companyNm', label: COL('company.name'), width: 250, align: 'left' },
                { key: 'ceo', label: COL('company.ceo'), width: 100, align: 'center' },
                { key: 'bizno', label: COL('company.bizno'), width: 100, align: 'center', formatter: 'bizno' },
                { key: 'tel', label: COL('company.tel'), width: 100, align: 'center' },
                { key: 'email', label: COL('company.email'), width: 100, align: 'center' },
                { key: 'useYn', label: COL('use.or.not'), width: 100, align: 'center' },
                { key: 'remark', label: '비고', width: 300, align: 'left' },
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex, { selectedClear: true });
                },
                onDBLClick: function () {
                    ACTIONS.dispatch(ACTIONS.MODAL_OPEN, this.item);
                },
            },
        });

        axboot.buttonClick(this, 'data-grid-view-01-btn', {
            create: function () {
                ACTIONS.dispatch(ACTIONS.MODAL_OPEN);
            },
        });
    },
});
