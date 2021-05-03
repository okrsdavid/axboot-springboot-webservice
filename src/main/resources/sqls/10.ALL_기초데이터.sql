-- 최초 실습용 그리드 추가 ########################################
-- 메뉴 그룹 - 교육 실습용
INSERT INTO MENU_M (MENU_ID, MENU_GRP_CD, MENU_NM, MULTI_LANGUAGE, PARENT_ID, LEVEL, SORT, PROG_CD, CREATED_AT, CREATED_BY, UPDATED_AT, UPDATED_BY )
VALUES (200, 'SYSTEM_MANAGER', '교육용 셈플', '{"ko":"교육용 셈플","en":"교육용 셈플"}',  null, 0, 99, null, sysdate(), 'system', sysdate(), 'system');

-- 실습용 그리드 추가
-- 프로그램 생성
INSERT INTO PROG_M (PROG_CD, PROG_NM, PROG_PH, TARGET, AUTH_CHECK, SCH_AH, SAV_AH )
VALUES ('teach-grid', '실습용 그리드', '/jsp/_education/teach-grid.jsp', '_self', 'Y', 'Y', 'Y');
-- 메뉴 생성
INSERT INTO MENU_M (MENU_ID, MENU_GRP_CD, MENU_NM, MULTI_LANGUAGE, PARENT_ID, LEVEL, SORT, PROG_CD, CREATED_AT, CREATED_BY, UPDATED_AT, UPDATED_BY )
VALUES (201, 'SYSTEM_MANAGER', '실습용 그리드', '{"ko":"실습용 그리드","en":"실습용 그리드"}',  200, 1, 1, 'teach-grid', sysdate(), 'system', sysdate(), 'system');
-- 메뉴 권한
INSERT INTO AUTH_GROUP_MAP_M (GRP_AUTH_CD , MENU_ID, SCH_AH, SAV_AH, CREATED_AT, CREATED_BY, UPDATED_AT, UPDATED_BY )
VALUES ('S0001', '201',  'Y', 'Y', sysdate(), 'system', sysdate(), 'system');


-- 실습용 그리드 폼 추가 ########################################
-- 프로그램 생성
INSERT INTO PROG_M (PROG_CD, PROG_NM, PROG_PH, TARGET, AUTH_CHECK, SCH_AH, SAV_AH, DEL_AH )
VALUES ('teach-grid-form', '실습용 그리드 폼', '/jsp/_education/teach-grid-form.jsp', '_self', 'Y', 'Y', 'Y', 'Y');
INSERT INTO PROG_M (PROG_CD, PROG_NM, PROG_PH, TARGET, AUTH_CHECK, SCH_AH, SAV_AH, DEL_AH )
VALUES ('teach-grid-form-without-tags', '실습용 그리드 폼(tag 사용안함)', '/jsp/_education/teach-grid-form-without-tags.jsp', '_self', 'Y', 'Y', 'Y', 'Y');
-- 메뉴 생성
INSERT INTO MENU_M (MENU_ID, MENU_GRP_CD, MENU_NM, MULTI_LANGUAGE, PARENT_ID, LEVEL, SORT, PROG_CD, CREATED_AT, CREATED_BY, UPDATED_AT, UPDATED_BY )
VALUES (202, 'SYSTEM_MANAGER', '실습용 그리드 폼', '{"ko":"실습용 그리드 폼","en":"실습용 그리드 폼"}',  200, 1, 2, 'teach-grid-form', sysdate(), 'system', sysdate(), 'system');
INSERT INTO MENU_M (MENU_ID, MENU_GRP_CD, MENU_NM, MULTI_LANGUAGE, PARENT_ID, LEVEL, SORT, PROG_CD, CREATED_AT, CREATED_BY, UPDATED_AT, UPDATED_BY )
VALUES (203, 'SYSTEM_MANAGER', '실습용 그리드 폼(tag 사용안함)', '{"ko":"실습용 그리드 폼(tag 사용안함)","en":"실습용 그리드 폼(tag 사용안함)"}',  200, 1, 3, 'teach-grid-form-without-tags', sysdate(), 'system', sysdate(), 'system');
-- 메뉴 권한
INSERT INTO AUTH_GROUP_MAP_M (GRP_AUTH_CD , MENU_ID, SCH_AH, SAV_AH, DEL_AH, CREATED_AT, CREATED_BY, UPDATED_AT, UPDATED_BY )
VALUES ('S0001', '202',  'Y', 'Y', 'Y', sysdate(), 'system', sysdate(), 'system');
INSERT INTO AUTH_GROUP_MAP_M (GRP_AUTH_CD , MENU_ID, SCH_AH, SAV_AH, DEL_AH, CREATED_AT, CREATED_BY, UPDATED_AT, UPDATED_BY )
VALUES ('S0001', '203',  'Y', 'Y', 'Y', sysdate(), 'system', sysdate(), 'system');


-- 실습용 그리드 모달, 엑셀 추가 ########################################
-- 프로그램 생성
INSERT INTO PROG_M (PROG_CD, PROG_NM, PROG_PH, TARGET, AUTH_CHECK, SCH_AH, SAV_AH)
VALUES ('teach-grid-modal', '실습용 그리드 모달', '/jsp/_education/teach-grid-modal.jsp', '_self', 'Y', 'Y', 'N');
INSERT INTO PROG_M (PROG_CD, PROG_NM, PROG_PH, TARGET, AUTH_CHECK, SCH_AH, SAV_AH)
VALUES ('teach-excel', '실습용 엑셀', '/jsp/_education/teach-excel.jsp', '_self', 'Y', 'Y', 'Y');
-- 메뉴 생성
INSERT INTO MENU_M (MENU_ID, MENU_GRP_CD, MENU_NM, MULTI_LANGUAGE, PARENT_ID, LEVEL, SORT, PROG_CD, CREATED_AT, CREATED_BY, UPDATED_AT, UPDATED_BY )
VALUES (204, 'SYSTEM_MANAGER', '실습용 그리드 모달', '{"ko":"실습용 그리드 모달","en":"실습용 그리드 모달"}',  200, 1, 4, 'teach-grid-modal', sysdate(), 'system', sysdate(), 'system');
INSERT INTO MENU_M (MENU_ID, MENU_GRP_CD, MENU_NM, MULTI_LANGUAGE, PARENT_ID, LEVEL, SORT, PROG_CD, CREATED_AT, CREATED_BY, UPDATED_AT, UPDATED_BY )
VALUES (210, 'SYSTEM_MANAGER', '실습용 엑셀', '{"ko":"실습용 엑셀","en":"실습용 엑셀"}',  200, 1, 10, 'teach-excel', sysdate(), 'system', sysdate(), 'system');
-- 메뉴 권한
INSERT INTO AUTH_GROUP_MAP_M (GRP_AUTH_CD , MENU_ID, SCH_AH, SAV_AH, CREATED_AT, CREATED_BY, UPDATED_AT, UPDATED_BY )
VALUES ('S0001', '204',  'Y', 'N', sysdate(), 'system', sysdate(), 'system');
INSERT INTO AUTH_GROUP_MAP_M (GRP_AUTH_CD , MENU_ID, SCH_AH, SAV_AH, CREATED_AT, CREATED_BY, UPDATED_AT, UPDATED_BY )
VALUES ('S0001', '210',  'Y', 'Y', sysdate(), 'system', sysdate(), 'system');