--EXSISTS (데이터가 존재한다)
--사원이 있는 부서를 조회한다
SELECT *
  FROM DEPARTMENTS DEP
 WHERE NOT EXISTS (SELECT 1
                 FROM EMPLOYEES EMP
                WHERE EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID)
;
SELECT 1
  FROM EMPLOYEES 
 WHERE DEPARTMENT_ID = 120
;

-- 사원이 있는 도시를 조회한다.
SELECT *
  FROM LOCATIONS LOC
 WHERE EXISTS (SELECT 1
                 FROM DEPARTMENTS DEP
                WHERE LOC.LOCATION_ID = DEP.LOCATION_ID 
                  AND EXISTS (SELECT 1
                    		    FROM EMPLOYEES EMP
                       		   WHERE EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID))
;

-- 사원이 없는 부서의 도시를 조회한다.
SELECT *
  FROM LOCATIONS LOC
 WHERE NOT EXISTS (SELECT 1
	                 FROM DEPARTMENTS DEP
	                WHERE LOC.LOCATION_ID = DEP.LOCATION_ID 
	                  AND EXISTS (SELECT 1
			                        FROM EMPLOYEES EMP
			                       WHERE EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID))
;
-- 부서가 없는 국가를 조회

-- 1. 부서가 있는 지역 조회
SELECT *
  FROM LOCATIONS LOC
 WHERE EXISTS (SELECT 1
                 FROM DEPARTMENTS DEP
                WHERE LOC.LOCATION_ID = DEP.LOCATION_ID)
;

--2. 부서가 없는 국가 조회
SELECT *
  FROM COUNTRIES COU
 WHERE NOT EXISTS (SELECT 1
                     FROM LOCATIONS LOC
                    WHERE COU.COUNTRY_ID = LOC.COUNTRY_ID  
                      AND EXISTS (SELECT 1
                 			        FROM DEPARTMENTS DEP
                			       WHERE LOC.LOCATION_ID = DEP.LOCATION_ID))
;

--IN (관련된 데이터가 있다)
--부서 번호가 10, 20, 30인 사원의 모든 정보를 조회한다
SELECT *
  FROM EMPLOYEES 
  WHERE DEPARTMENT_ID IN (10, 20, 30)
;

--사원이 있는 부서를 조회한다
SELECT *
  FROM DEPARTMENTS DEP
 WHERE DEP.DEPARTMENT_ID IN (SELECT DISTINCT EMP.DEPARTMENT_ID 
 							   FROM EMPLOYEES EMP)
;

--사원이 있는 도시를 조회한다.
SELECT *
  FROM LOCATIONS LOC
 WHERE LOC.LOCATION_ID IN (SELECT DISTINCT DEP.LOCATION_ID 
                             FROM DEPARTMENTS DEP
							WHERE DEP.DEPARTMENT_ID IN (SELECT DISTINCT EMP.DEPARTMENT_ID 
                                     	                  FROM EMPLOYEES EMP))                                     	                 
;

--사원이 없는 부서를 조회한다.
SELECT *
  FROM DEPARTMENTS DEP
 WHERE DEP.DEPARTMENT_ID NOT IN (SELECT DISTINCT EMP.DEPARTMENT_ID 
                                   FROM EMPLOYEES EMP
                                  WHERE EMP.DEPARTMENT_ID IS NOT NULL)
;

--사원이 없는 도시를 조회한다.
SELECT *
  FROM LOCATIONS LOC
 WHERE LOC.LOCATION_ID NOT IN (SELECT DISTINCT DEP.LOCATION_ID 
                                 FROM DEPARTMENTS DEP
                                WHERE DEP.DEPARTMENT_ID IN (SELECT DISTINCT EMP.DEPARTMENT_ID 
                                							  FROM EMPLOYEES EMP))
;                                							 

--1. 현재 시간을 조회한다.
SELECT TO_CHAR(SYSDATE, 'HH:MI:SS') "현재시간"
  FROM DUAL
;
--2. 현재 시간을 "연-월-일" 포멧으로 조회한다.
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD') "현재시간"
  FROM DUAL
;
--3. 한 시간 전 시간을 "시:분:초" 포멧으로 조회한다.
SELECT TO_CHAR(SYSDATE - (1/24), 'HH:MI:SS') "한 시간 전"
  FROM DUAL 
;
--4. EMPLOYEES 테이블의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
;
--5. DEPARTMENTS 테이블의 모든 정보를 조회한다.
SELECT *
  FROM DEPARTMENTS 
;
--6. JOBS 테이블의 모든 정보를 조회한다.
SELECT *
  FROM JOBS 
;
--7. LOCATIONS 테이블의 모든 정보를 조회한다.
SELECT *
  FROM LOCATIONS
;
--8. COUNTRIES 테이블의 모든 정보를 조회한다.
SELECT *
  FROM COUNTRIES
;
--9. REGIONS 테이블의 모든 정보를 조회한다.
SELECT *
  FROM REGIONS 
;
--10. JOB_HISTORY 테이블의 모든 정보를 조회한다.
SELECT *
  FROM JOB_HISTORY 
;
--11. 90번 부서에서 근무하는 사원들의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES 
 WHERE DEPARTMENT_ID = 90
;
--12. 90번, 100번 부서에서 근무하는 사원들의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES 
 WHERE DEPARTMENT_ID IN (90, 100)
;
--13. 100번 상사의 직속 부하직원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES 
 WHERE MANAGER_ID = 100
;
--14. 직무 아이디가 AD_VP 인 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES 
 WHERE JOB_ID = 'AD_VP'
;
--15. 연봉이 7000 이상인 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES 
 WHERE SALARY >= 7000
;
--16. 2005년 09월에 입사한 사원들의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES 
 WHERE HIRE_DATE BETWEEN TO_DATE('2005-09-01', 'YYYY-MM-DD') AND TO_DATE('2005-09-30', 'YYYY-MM-DD')
;
--17. 111번 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES 
 WHERE EMPLOYEE_ID = 111
;
--18. 인센티브를 안받는 사원들의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES 
 WHERE COMMISSION_PCT IS NULL 
;
--19. 인센티브를 받는 사원들의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES 
 WHERE COMMISSION_PCT IS NOT NULL 
;
--20. 이름의 첫 글자가 'D' 인 사원들의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES 
 WHERE FIRST_NAME LIKE 'D%'
;
--21. 성의 마지막 글자가 'a' 인 사원들의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES 
 WHERE LAST_NAME LIKE '%a'
;
--22. 전화번호에 '.124.'이 포함된 사원들의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES 
 WHERE PHONE_NUMBER LIKE '%.124.%'
;
--23. 직무 아이디가 'PU_CLERK'인 사원 중 연봉이 3000 이상인 사원들의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES 
 WHERE JOB_ID = 'PU_CLERK'
   AND SALARY >= 3000
;
--24. 평균 연봉보다 많이 받는 사원들의 사원번호, 이름, 성, 연봉을 조회한다.
SELECT EMPLOYEE_ID 
	 , FIRST_NAME 
	 , LAST_NAME 
	 , SALARY 
  FROM EMPLOYEES 
 WHERE SALARY > (SELECT AVG(SALARY)
                   FROM EMPLOYEES)
;
--25. 평균 연봉보다 적게 받는 사원들의 사원번호, 연봉, 부서번호를 조회한다.
SELECT EMPLOYEE_ID 
     , SALARY 
     , DEPARTMENT_ID 
  FROM EMPLOYEES 
 WHERE SALARY < (SELECT AVG(SALARY)
 	               FROM EMPLOYEES)
;
--26. 가장 많은 연봉을 받는 사원의 사원번호, 이름, 연봉을 조회한다.
SELECT EMPLOYEE_ID 
     , FIRST_NAME 
     , SALARY 
  FROM EMPLOYEES 
 WHERE SALARY = (SELECT MAX(SALARY)
 	               FROM EMPLOYEES)
;
--27. 이름이 4글자인 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES 
 WHERE FIRST_NAME LIKE '____'
;
--28. 'SA_REP' 직무인 직원 중 가장 높은 연봉과 가장 낮은 연봉을 조회한다.
SELECT MAX(SALARY)
	 , MIN(SALARY)
  FROM EMPLOYEES 
 WHERE JOB_ID = 'SA_REP'
;
--29. 직원의 입사일자를 '연-월-일' 형태로 조회한다.
SELECT TO_CHAR(HIRE_DATE, 'YYYY-MM-DD') "입사일자"
  FROM EMPLOYEES
;
--30. 가장 늦게 입사한 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE HIRE_DATE = (SELECT MAX(HIRE_DATE)
 				      FROM EMPLOYEES)
;
--31. 가장 일찍 입사한 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE HIRE_DATE = (SELECT MIN(HIRE_DATE)
 				      FROM EMPLOYEES)
;

--32. 자신의 상사보다 더 많은 연봉을 받는 사원의 모든 정보를 조회한다.

SELECT *
  FROM EMPLOYEES E1
 WHERE SALARY > (SELECT SALARY
                   FROM EMPLOYEES E2
                  WHERE E1.MANAGER_ID = E2.EMPLOYEE_ID)
;

SELECT *
  FROM EMPLOYEES EMP
 INNER JOIN EMPLOYEES MAN 
    ON EMP.MANAGER_ID = MAN.EMPLOYEE_ID 
 WHERE EMP.SALARY > MAN.SALARY 
;

--33. 자신의 상사보다 더 일찍 입사한 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES E1
 WHERE HIRE_DATE  > (SELECT HIRE_DATE 
                   FROM EMPLOYEES E2
                  WHERE E1.MANAGER_ID = E2.EMPLOYEE_ID)
;
--34. 부서아이디별 평균 연봉을 조회한다.
SELECT DEPARTMENT_ID 
	 , AVG(SALARY)
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID 
;
--35. 직무아이디별 평균 연봉, 최고연봉, 최저연봉을 조회한다.
SELECT JOB_ID 
     , AVG(SALARY)
     , MAX(SALARY)
     , MIN(SALARY)
  FROM EMPLOYEES
 GROUP BY JOB_ID 
;
--36. 가장 많은 인센티브를 받는 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES 
 WHERE COMMISSION_PCT = (SELECT MAX(COMMISSION_PCT)
 						   FROM EMPLOYEES)
;
--37. 가장 적은 인센티브를 받는 사원의 연봉과 인센티브를 조회한다.
SELECT SALARY
	 , COMMISSION_PCT
  FROM EMPLOYEES 
 WHERE COMMISSION_PCT = (SELECT MIN(COMMISSION_PCT)
 						   FROM EMPLOYEES)
;
--38. 직무아이디별 사원의 수를 조회한다.
SELECT JOB_ID 
	 , COUNT(1)
  FROM EMPLOYEES 
 GROUP BY JOB_ID
;
--39. 상사아이디별 부하직원의 수를 조회한다. 단, 부하직원이 2명 이하인 경우는 제외한다.
SELECT MANAGER_ID 
     , COUNT(1)
  FROM EMPLOYEES
 GROUP BY MANAGER_ID
HAVING COUNT(1) > 2
;
--40. 사원이 속한 부서의 평균연봉보다 적게 받는 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES E1
 WHERE SALARY < (SELECT AVG(SALARY)
                   FROM EMPLOYEES E2
                  WHERE E1.DEPARTMENT_ID = E2.DEPARTMENT_ID)
;
--41. 사원이 근무하는 부서명, 이름, 성을 조회한다.
SELECT DEP.DEPARTMENT_NAME 
     , EMP.FIRST_NAME 
     , EMP.LAST_NAME 
  FROM EMPLOYEES EMP 
 INNER JOIN DEPARTMENTS DEP
    ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID 
;
--42. 가장 적은 연봉을 받는 사원의 부서명, 이름, 성, 연봉, 부서장사원번호를 조회한다.
SELECT DEP.DEPARTMENT_NAME 
	 , EMP.FIRST_NAME
	 , EMP.LAST_NAME
	 , EMP.SALARY
	 , EMP.MANAGER_ID
  FROM EMPLOYEES EMP
 INNER JOIN DEPARTMENTS DEP
    ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID 
 WHERE SALARY = (SELECT MIN(SALARY)
                   FROM EMPLOYEES)
;
--43. 상사사원번호를 중복없이 조회한다.
SELECT DISTINCT MANAGER_ID
  FROM EMPLOYEES 
;
--44. 50번 부서의 부서장의 이름, 성, 연봉을 조회한다.
SELECT FIRST_NAME 
     , LAST_NAME 
     , SALARY 
  FROM EMPLOYEES 
 WHERE EMPLOYEE_ID = (SELECT MANAGER_ID
 					    FROM DEPARTMENTS 
 					   WHERE DEPARTMENT_ID = 50)
; 					   
--45. 부서명별 사원의 수를 조회한다.
SELECT DEP.DEPARTMENT_NAME 
	 , EMP.CNT
  FROM (SELECT DEPARTMENT_ID
		     , COUNT(1) CNT
		  FROM EMPLOYEES 
		 GROUP BY DEPARTMENT_ID) EMP
 INNER JOIN DEPARTMENTS DEP
    ON DEP.DEPARTMENT_ID = EMP.DEPARTMENT_ID
;

--**서브쿼리 사용하지 않고 풀기
SELECT DEP.DEPARTMENT_NAME 
     , COUNT(EMP.EMPLOYEE_ID)
  FROM EMPLOYEES EMP
 INNER JOIN DEPARTMENTS DEP
    ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID 
 GROUP BY DEP.DEPARTMENT_NAME
;
--46. 사원의 수가 가장 많은 부서명, 사원의 수를 조회한다.
SELECT DEP.DEPARTMENT_NAME 
     , EMP.CNT
  FROM (SELECT DEPARTMENT_ID
  			 , COUNT(1) CNT
          FROM EMPLOYEES
         GROUP BY DEPARTMENT_ID
         ORDER BY CNT DESC) EMP
  INNER JOIN DEPARTMENTS DEP
     ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID 
  WHERE ROWNUM  = 1
;

--한 쿼리 내에서 집계함수로 ORDER BY 금지 (성능저하)
SELECT DEP.DEPARTMENT_NAME 
     , EMP.CNT
  FROM DEPARTMENTS DEP
 INNER JOIN (SELECT DEPARTMENT_ID
				  , CNT
	 		   FROM (SELECT DEPARTMENT_ID
	 		               , CNT
	  	     		   FROM (SELECT DEPARTMENT_ID 
					              , COUNT(1) CNT
					           FROM EMPLOYEES
				 	          GROUP BY DEPARTMENT_ID)
					  ORDER BY CNT DESC)
			  WHERE ROWNUM = 1) EMP
    ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID 
;    

--47. 사원이 없는 부서명을 조회한다.
SELECT DEPARTMENT_NAME 
  FROM DEPARTMENTS
 WHERE DEPARTMENT_ID NOT IN (SELECT DISTINCT DEPARTMENT_ID 
                               FROM EMPLOYEES
                              WHERE DEPARTMENT_ID IS NOT NULL)
;
--48. 직무가 변경된 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE EMPLOYEE_ID IN (SELECT EMPLOYEE_ID
                         FROM JOB_HISTORY)
;
--49. 직무가 변경된적 없는 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE EMPLOYEE_ID NOT IN (SELECT EMPLOYEE_ID
                       	     FROM JOB_HISTORY)
;
--50. 직무가 변경된 사원의 과거 직무명과 현재 직무명을 조회한다.
SELECT EMP.EMPLOYEE_ID
     , JH_JOB.JOB_TITLE "과거 직무명"
     , EMP_JOB.JOB_TITLE "현재 직무명"
  FROM EMPLOYEES EMP
 INNER JOIN JOB_HISTORY JH 
    ON EMP.EMPLOYEE_ID = JH.EMPLOYEE_ID 
 INNER JOIN JOBS EMP_JOB
    ON EMP.JOB_ID = EMP_JOB.JOB_ID
 INNER JOIN JOBS JH_JOB
    ON JH.JOB_ID = JH_JOB.JOB_ID
;

--51. 직무가 가장 많이 변경된 부서의 이름을 조회한다.
SELECT DEPARTMENT_NAME
  FROM (SELECT DEPARTMENT_ID 
		  FROM (SELECT DEPARTMENT_ID 
				  FROM (SELECT DEPARTMENT_ID 
							 , COUNT(1) CNT
						  FROM JOB_HISTORY 
						 GROUP BY DEPARTMENT_ID)
				  ORDER BY CNT)
		 WHERE ROWNUM = 1) JH
 INNER JOIN DEPARTMENTS DEP 
    ON DEP.DEPARTMENT_ID = JH.DEPARTMENT_ID
;

--52. 'Seattle' 에서 근무중인 사원의 이름, 성, 연봉, 부서명 을 조회한다.
SELECT EMP.FIRST_NAME
     , EMP.LAST_NAME 
     , EMP.SALARY 
     , DEP.DEPARTMENT_NAME
  FROM EMPLOYEES EMP
 INNER JOIN DEPARTMENTS DEP
    ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID
 INNER JOIN LOCATIONS LOC
    ON DEP.LOCATION_ID = LOC.LOCATION_ID
 WHERE LOC.CITY = 'Seattle'
;
--53. 'Seattle' 에서 근무하지 않는 모든 사원의 이름, 성, 연봉, 부서명, 도시를 조회한다.
SELECT EMP.FIRST_NAME
     , EMP.LAST_NAME 
     , EMP.SALARY 
     , DEP.DEPARTMENT_NAME
  FROM EMPLOYEES EMP
 INNER JOIN DEPARTMENTS DEP
    ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID
 INNER JOIN LOCATIONS LOC
    ON DEP.LOCATION_ID = LOC.LOCATION_ID
 WHERE LOC.CITY != 'Seattle'
;
--54. 근무중인 사원이 가장 많은 도시와 사원의 수를 조회한다.
SELECT CITY
     , CNT
  FROM (SELECT CITY
  			 , CNT
		  FROM (SELECT LOC.CITY
				     , COUNT(1) CNT
				  FROM EMPLOYEES EMP
				 INNER JOIN DEPARTMENTS DEP
				    ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID
				 INNER JOIN LOCATIONS LOC
				    ON DEP.LOCATION_ID = LOC.LOCATION_ID
				  GROUP BY CITY)
		 ORDER BY CNT DESC)
 WHERE ROWNUM = 1
;
-- 55. 근무중인 사원이 없는 도시를 조회한다.
SELECT CITY
  FROM LOCATIONS 
 WHERE LOCATION_ID NOT IN (SELECT DEP.LOCATION_ID 
 							 FROM DEPARTMENTS DEP 
							INNER JOIN EMPLOYEES EMP
					    	   ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID)
;					 

-- 56. 연봉이 7000 에서 12000 사이인 사원이 근무중인 도시를 조회한다.
SELECT DISTINCT LOC.CITY
  FROM LOCATIONS LOC
 INNER JOIN DEPARTMENTS DEP
    ON LOC.LOCATION_ID = DEP.LOCATION_ID 
 INNER JOIN EMPLOYEES EMP
    ON DEP.DEPARTMENT_ID = EMP.DEPARTMENT_ID
 WHERE EMP.SALARY BETWEEN 7000 AND 12000
;

-- **조회하려는 컬럼이 한 테이블에 있으면 JOIN 보다 서브쿼리 사용
SELECT CITY
  FROM LOCATIONS
 WHERE LOCATION_ID IN (SELECT LOCATION_ID 
 					    FROM DEPARTMENTS
					   WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID 
											    FROM EMPLOYEES 
											   WHERE SALARY BETWEEN 7000 AND 12000))
;
-- 57. 'Seattle' 에서 근무중인 사원의 직무명을 중복없이 조회한다.
SELECT DISTINCT JOB.JOB_TITLE 
  FROM JOBS JOB
 INNER JOIN EMPLOYEES EMP
    ON JOB.JOB_ID = EMP.JOB_ID 
 INNER JOIN DEPARTMENTS DEP
    ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID 
 INNER JOIN LOCATIONS LOC
    ON DEP.LOCATION_ID = LOC.LOCATION_ID 
 WHERE CITY = 'Seattle'
;

-- **조회하려는 컬럼이 한 테이블에 있으면 JOIN 보다 서브쿼리 사용
SELECT DISTINCT JOB_TITLE
  FROM JOBS 
 WHERE JOB_ID IN (SELECT JOB_ID
					FROM EMPLOYEES 
				   WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID
											 FROM DEPARTMENTS 
											WHERE LOCATION_ID IN (SELECT LOCATION_ID
																	FROM LOCATIONS 
																   WHERE CITY = 'Seattle')))
;
-- 58. 사내의 최고연봉과 최저연봉의 차이를 조회한다.
SELECT MAX(SALARY) - MIN(SALARY)
  FROM EMPLOYEES 
;
-- 59. 이름이 'Renske' 인 사원의 연봉과 같은 연봉을 받는 사원의 모든 정보를 조회한다. 단, 'Renske' 사원은 조회에서 제외한다.
SELECT *
  FROM EMPLOYEES 
 WHERE SALARY = (SELECT SALARY 
				   FROM EMPLOYEES
				  WHERE FIRST_NAME = 'Renske')
   AND FIRST_NAME != 'Renske'
;
-- 60. 회사 전체의 평균 연봉보다 많이 받는 사원들 중 이름에 'u' 가 포함된 사원과 동일한 부서에서 근무중인 사원들의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES 
 WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID 
 						   FROM EMPLOYEES 
						  WHERE SALARY > (SELECT AVG(SALARY)
						 				    FROM EMPLOYEES)
						    AND FIRST_NAME  LIKE '%u%')
;
-- 61. 부서가 없는 국가명을 조회한다.
SELECT COU.COUNTRY_NAME 
  FROM COUNTRIES COU
  LEFT OUTER JOIN (SELECT LOC.COUNTRY_ID
                     FROM LOCATIONS LOC
                    INNER JOIN DEPARTMENTS DEP
                       ON LOC.LOCATION_ID = DEP.LOCATION_ID) LOC
    ON COU.COUNTRY_ID = LOC.COUNTRY_ID
 WHERE LOC.COUNTRY_ID IS NULL
 ORDER BY COU.COUNTRY_ID 
;

-- **조회하려는 컬럼이 한 테이블에 있으면 JOIN 보다 서브쿼리 사용
SELECT COUNTRY_NAME
  FROM COUNTRIES 
 WHERE COUNTRY_ID NOT IN (SELECT COUNTRY_ID 
						    FROM LOCATIONS 
						   WHERE LOCATION_ID IN (SELECT LOCATION_ID
						 						   FROM DEPARTMENTS))
;

-- 62. 'Europe' 에서 근무중인 사원들의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES 
 WHERE EMPLOYEE_ID IN (SELECT EMPLOYEE_ID
 						 FROM EMPLOYEES EMP
 						INNER JOIN DEPARTMENTS DEP
 						   ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID
 						INNER JOIN LOCATIONS LOC
 						   ON DEP.LOCATION_ID = LOC.LOCATION_ID
 						INNER JOIN COUNTRIES COU
 						   ON LOC.COUNTRY_ID = COU.COUNTRY_ID
 						INNER JOIN REGIONS REG
 						   ON COU.REGION_ID = REG.REGION_ID
 						WHERE REG.REGION_NAME = 'Europe')
;

-- **조회하려는 컬럼이 한 테이블에 있으면 JOIN 보다 서브쿼리 사용
SELECT *
  FROM EMPLOYEES 
 WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID 
						   FROM DEPARTMENTS 
						  WHERE LOCATION_ID IN (SELECT LOCATION_ID 
												  FROM LOCATIONS 
												 WHERE COUNTRY_ID IN (SELECT COUNTRY_ID 
																	    FROM COUNTRIES 
																	   WHERE REGION_ID IN (SELECT REGION_ID
																					  	     FROM REGIONS 
																						    WHERE REGION_NAME = 'Europe'))))
;
-- 63. 'Europe' 에서 가장 많은 사원들이 있는 부서명을 조회한다.
SELECT CNT_ORDER.DEPARTMENT_NAME
     , CNT_ORDER.CNT
  FROM (SELECT DEP_CNT.DEPARTMENT_NAME 
		     , DEP_CNT.CNT
		  FROM (SELECT DEP.DEPARTMENT_NAME 
				     , COUNT(EMP.EMPLOYEE_ID) CNT
				  FROM EMPLOYEES EMP
				 INNER JOIN DEPARTMENTS DEP
				    ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID 
				  WHERE DEP.LOCATION_ID IN (SELECT LOCATION_ID 
											  FROM LOCATIONS 
											 WHERE COUNTRY_ID IN (SELECT COUNTRY_ID 
																    FROM COUNTRIES 
																   WHERE REGION_ID IN (SELECT REGION_ID
																				  	     FROM REGIONS 
																					    WHERE REGION_NAME = 'Europe')))
				 GROUP BY DEPARTMENT_NAME) DEP_CNT
		 ORDER BY DEP_CNT.CNT DESC) CNT_ORDER
 WHERE ROWNUM = 1
;
-- 64. 대륙 별 사원의 수를 조회한다.
SELECT REG.REGION_NAME
     , COUNT(1) CNT
  FROM REGIONS REG
  LEFT JOIN COUNTRIES COU
    ON REG.REGION_ID = COU.REGION_ID 
  LEFT JOIN LOCATIONS LOC
    ON COU.COUNTRY_ID = LOC.COUNTRY_ID 
  LEFT JOIN DEPARTMENTS DEP
    ON LOC.LOCATION_ID = DEP.LOCATION_ID 
  LEFT JOIN EMPLOYEES EMP
    ON DEP.DEPARTMENT_ID = EMP.DEPARTMENT_ID 
 GROUP BY REG.REGION_NAME
;

-- 65. 연봉이 2500, 3500, 7000 이 아니며 직업이 SA_REP 이나 ST_CLERK 인 사람들을 조회한다.
SELECT *
  FROM EMPLOYEES 
 WHERE SALARY NOT IN (2500, 3500 ,7000)
   AND JOB_ID IN ('SA_REP', 'ST_CLERK')
; 
-- 66. 사원의 사원번호, 이름, 성, 상사의 사원번호, 상사의 이름, 상사의 성을 조회한다.
SELECT EMP.EMPLOYEE_ID 
	 , EMP.FIRST_NAME 
	 , EMP.LAST_NAME 
	 , MAN.EMPLOYEE_ID MAN_EMPLOYEE_ID
	 , MAN.FIRST_NAME MAN_FIRST_NAME
	 , MAN.LAST_NAME MAN_LAST_NAME
  FROM EMPLOYEES EMP
  INNER JOIN EMPLOYEES MAN
    ON EMP.MANAGER_ID = MAN.EMPLOYEE_ID 
;
-- 67. 101번 사원의 모든 부하직원 들의 이름, 성, 상사사원번호, 상사사원명를 조회한다.
SELECT EMP.FIRST_NAME 
     , EMP.LAST_NAME 
     , MAN.EMPLOYEE_ID 
     , MAN.FIRST_NAME 
     , MAN.LAST_NAME 
  FROM EMPLOYEES EMP
 INNER JOIN EMPLOYEES MAN
    ON EMP.MANAGER_ID = MAN.EMPLOYEE_ID
 WHERE EMP.MANAGER_ID = 101
;

-- ** 계층 쿼리로 풀어야 함
 SELECT EMPLOYEE_ID 
      , FIRST_NAME 
      , LAST_NAME 
      , MANAGER_ID 
   FROM EMPLOYEES
  WHERE EMPLOYEE_ID != 101  
  START WITH EMPLOYEE_ID = 101
CONNECT BY PRIOR EMPLOYEE_ID = MANAGER_ID  
;

-- ** 상사사원명 조회
SELECT EMP.EMPLOYEE_ID 
     , EMP.FIRST_NAME 
     , EMP.LAST_NAME 
     , EMP.MANAGER_ID 
	 , MAN.FIRST_NAME 
     , MAN.LAST_NAME 
  FROM ( SELECT EMPLOYEE_ID 
		      , FIRST_NAME 
		      , LAST_NAME 
		      , MANAGER_ID 
		   FROM EMPLOYEES
		  WHERE EMPLOYEE_ID != 101  
		  START WITH EMPLOYEE_ID = 101
		CONNECT BY PRIOR EMPLOYEE_ID = MANAGER_ID) EMP
  LEFT JOIN EMPLOYEES MAN
   ON EMP.MANAGER_ID = MAN.EMPLOYEE_ID 
;
-- 68. 114번 직원의 모든 상사들의 이름, 성, 상사사원번호, 상사사원명을 조회한다.
 SELECT FIRST_NAME 
      , LAST_NAME 
      , MANAGER_ID 
   FROM EMPLOYEES 
  WHERE EMPLOYEE_ID != 114
  START WITH EMPLOYEE_ID = 114
CONNECT BY PRIOR MANAGER_ID = EMPLOYEE_ID  
;
-- ** 상사사원명 조회
SELECT EMP.EMPLOYEE_ID 
     , EMP.FIRST_NAME 
     , EMP.LAST_NAME 
     , EMP.MANAGER_ID 
	 , MAN.FIRST_NAME 
     , MAN.LAST_NAME 
  FROM ( SELECT EMPLOYEE_ID
  			  , FIRST_NAME 
		      , LAST_NAME 
		      , MANAGER_ID 
		   FROM EMPLOYEES 
		  WHERE EMPLOYEE_ID != 144
		  START WITH EMPLOYEE_ID = 144
		CONNECT BY PRIOR MANAGER_ID = EMPLOYEE_ID) EMP
  LEFT JOIN EMPLOYEES MAN
   ON EMP.MANAGER_ID = MAN.EMPLOYEE_ID 
;
-- 69. 114번 직원의 모든 상사들의 이름, 성, 상사사원번호, 상사사원명을 조회한다. 단, 역순으로 조회한다.
 SELECT LEVEL
      , FIRST_NAME 
      , LAST_NAME 
      , MANAGER_ID 
   FROM EMPLOYEES 
  WHERE EMPLOYEE_ID != 113
  START WITH EMPLOYEE_ID = 113
CONNECT BY PRIOR MANAGER_ID = EMPLOYEE_ID  
  ORDER BY LEVEL DESC
;

-- ** 상사사원명 조회
SELECT EMP.LV
	 , EMP.EMPLOYEE_ID 
     , EMP.FIRST_NAME 
     , EMP.LAST_NAME 
     , EMP.MANAGER_ID 
	 , MAN.FIRST_NAME 
     , MAN.LAST_NAME 
  FROM ( SELECT LEVEL LV
              , EMPLOYEE_ID
		      , FIRST_NAME 
		      , LAST_NAME 
		      , MANAGER_ID 
		   FROM EMPLOYEES 
		  WHERE EMPLOYEE_ID != 113
		  START WITH EMPLOYEE_ID = 113
		CONNECT BY PRIOR MANAGER_ID = EMPLOYEE_ID  
		  ORDER BY LV DESC) EMP
  LEFT JOIN EMPLOYEES MAN
   ON EMP.MANAGER_ID = MAN.EMPLOYEE_ID 
;
-- 70. 모든 사원들을 연봉 오름차순 정렬하여 조회한다.
SELECT *
  FROM EMPLOYEES 
 ORDER BY SALARY
;
-- 71. 모든 사원들을 이름 내림차순 정렬하여 조회한다.
SELECT *
  FROM EMPLOYEES 
 ORDER BY FIRST_NAME DESC
;
-- 72. 모든 사원들의 이름, 성, 연봉, 부서명을 부서번호로 내림차순 정렬하여 조회한다.
SELECT EMP.FIRST_NAME 
     , EMP.LAST_NAME 
     , EMP.SALARY 
     , DEP.DEPARTMENT_NAME 
  FROM EMPLOYEES EMP
  LEFT JOIN DEPARTMENTS DEP
    ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID
 ORDER BY EMP.DEPARTMENT_ID DESC
;
-- 73. 부서별 연봉의 합을 내림차순 정렬하여 조회한다.
SELECT DEPARTMENT_ID 
     , SALARY_SUM
  FROM (SELECT DEPARTMENT_ID 
		     , SUM(SALARY) SALARY_SUM
		  FROM EMPLOYEES
		 GROUP BY DEPARTMENT_ID)
 ORDER BY SALARY_SUM DESC
;

-- 74. 직무별 사원의 수를 오름차순 정렬하여 조회한다.
SELECT JOB_ID 
     , CNT
  FROM (SELECT JOB_ID
			 , COUNT(1) CNT
		  FROM EMPLOYEES 
		 GROUP BY JOB_ID)
 ORDER BY CNT
;
-- 75. 모든 사원들의 모든 정보를 조회한다. 단, 인센티브를 받는 사원은 "인센티브여부" 컬럼에 "Y"를, 아닌 경우 "N"으로 조회한다.
SELECT EMP.*
     , CASE
     	 WHEN COMMISSION_PCT IS NULL THEN
     	   'N'
     	 ELSE 
     	   'Y'
     	 END COMMISION_TYPE
  FROM EMPLOYEES EMP 
;
-- 76. 모든 사원들의 이름을 10자리로 맞추어 조회한다.
SELECT LPAD(FIRST_NAME, 10, '_')
  FROM EMPLOYEES 
;

-- 77. 2007년에 직무가 변경된 사원들의 현재 직무명, 부서명,  사원번호, 이름, 성을 조회한다.
SELECT JOB.JOB_TITLE 
     , DEP.DEPARTMENT_NAME 
     , EMP.EMPLOYEE_ID 
     , EMP.FIRST_NAME 
     , EMP.LAST_NAME 
  FROM EMPLOYEES EMP
 INNER JOIN DEPARTMENTS DEP
    ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID 
 INNER JOIN JOBS JOB
    ON EMP.JOB_ID = JOB.JOB_ID 
 WHERE EMP.EMPLOYEE_ID IN (SELECT EMPLOYEE_ID
 			                 FROM JOB_HISTORY
 			                WHERE START_DATE BETWEEN TO_DATE('2007-01-01', 'YYYY-MM-DD') AND TO_DATE('2007-12-31', 'YYYY-MM-DD'))
;

-- ** 전부 INNER JOIN 하는 것이 더 빠름
SELECT JOB.JOB_TITLE
     , DEP.DEPARTMENT_NAME
     , EMP.EMPLOYEE_ID
     , EMP.FIRST_NAME
     , EMP.LAST_NAME
  FROM JOB_HISTORY JHT
 INNER JOIN EMPLOYEES EMP
    ON JHT.EMPLOYEE_ID = EMP.EMPLOYEE_ID
 INNER JOIN DEPARTMENTS DEP
    ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID
 INNER JOIN JOBS JOB
    ON EMP.JOB_ID = JOB.JOB_ID
 WHERE JHT.START_DATE BETWEEN TO_DATE('2007-01-01', 'YYYY-MM-DD') AND TO_DATE('2007-12-31', 'YYYY-MM-DD')
;


-- ** 다른 방법
SELECT *
  FROM (SELECT JH.JOB_ID
		     , TO_NUMBER(TO_CHAR(JH.START_DATE, 'YYYY')) START_YEAR
		  FROM JOB_HISTORY JH) JH_2007
 WHERE JH_2007.START_YEAR = 2007
;
-- 78. 직무별 최대 연봉보다 더 많은 연봉을 받는 사원의 모든 정보를 조회한다.
SELECT *
  FROM JOBS JOB
 INNER JOIN EMPLOYEES EMP 
   ON JOB.JOB_ID = EMP.JOB_ID 
 WHERE JOB.MAX_SALARY < EMP.SALARY 
;
-- 79. 사원들의 입사일자 중 이름, 성, 연도만 조회한다.
SELECT FIRST_NAME 
     , LAST_NAME 
     , TO_CHAR(HIRE_DATE, 'YYYY') HIRE_YEAR
  FROM EMPLOYEES 
;
-- 80. 사원들의 입사일자 중 이름, 성, 연도, 월 만 조회한다.
SELECT FIRST_NAME
     , LAST_NAME
     , TO_CHAR(HIRE_DATE, 'YYYY') HIRE_YEAR
     , TO_CHAR(HIRE_DATE, 'MM') HIRE_MONTH
  FROM EMPLOYEES 
;
-- 81. 100번 사원의 모든 부하직원을 계층조회한다. 단, LEVEL이 4인 사원은 제외한다.
 SELECT LEVEL
      , EMPLOYEE_ID 
      , FIRST_NAME 
      , LAST_NAME 
      , MANAGER_ID 
   FROM EMPLOYEES
  WHERE LEVEL != 4
  START WITH MANAGER_ID = 100
CONNECT BY PRIOR EMPLOYEE_ID = MANAGER_ID
;
-- 82. 많은 연봉을 받는 10명을 조회한다.
SELECT *
  FROM (SELECT *
		  FROM EMPLOYEES 
		 ORDER BY SALARY DESC)
 WHERE ROWNUM <= 10
;
-- 83. 가장 적은 연봉을 받는 사원의 상사명, 부서명을 조회한다.
SELECT MAN.FIRST_NAME 
     , DEP.DEPARTMENT_NAME
  FROM EMPLOYEES EMP
 INNER JOIN DEPARTMENTS DEP
    ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID 
 INNER JOIN EMPLOYEES MAN
    ON EMP.MANAGER_ID = MAN.EMPLOYEE_ID 
 WHERE EMP.SALARY = (SELECT MIN(SALARY)
                       FROM EMPLOYEES)
;

-- ** 더 빠른 방법
SELECT EMP.FIRST_NAME 
     , DEP.DEPARTMENT_NAME
  FROM EMPLOYEES EMP
 INNER JOIN DEPARTMENTS DEP
    ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID                      
 WHERE EMP.EMPLOYEE_ID  = (SELECT MANAGER_ID 
						     FROM (SELECT MANAGER_ID 
								     FROM EMPLOYEES 
								    ORDER BY SALARY)
					   		 WHERE ROWNUM = 1)
;
-- 84. 많은 연봉을 받는 사원 중 11번 째 부터 20번째를 조회한다.
SELECT *
  FROM (SELECT ROWNUM RNUM
			 , E.*
		  FROM (SELECT *
				  FROM EMPLOYEES 
				 ORDER BY SALARY DESC) E
		 WHERE ROWNUM <= 20)
 WHERE RNUM >= 11

-- 85. 가장 적은 연봉을 받는 중 90번 째 부터 100번째를 조회한다.
SELECT *
  FROM (SELECT ROWNUM RNUM
		     , E.*
		  FROM (SELECT *
				  FROM EMPLOYEES 
				 ORDER BY SALARY ) E
		 WHERE ROWNUM <= 100)
 WHERE RNUM >= 90
;
-- 86. 'PU_CLERK' 직무인 2번째 부터 5번째 사원의 부서명, 직무명을 조회한다.
SELECT *
  FROM (SELECT ROWNUM RNUM
		     , E.*
		  FROM (SELECT DEP.DEPARTMENT_NAME 
				     , JOB.JOB_TITLE 
				  FROM EMPLOYEES EMP 
				 INNER JOIN DEPARTMENTS DEP
				    ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID 
				 INNER JOIN JOBS JOB
				    ON EMP.JOB_ID = JOB.JOB_ID
				 WHERE EMP.JOB_ID = 'PU_CLERK') E
		 WHERE ROWNUM <= 5)
 WHERE RNUM >= 2
;
-- 87. 모든 사원의 정보를 직무 오름차순, 연봉 내림차순으로 조회한다.
SELECT *
  FROM EMPLOYEES 
 ORDER BY JOB_ID, SALARY DESC
;
-- 88. 직무별 평균연봉을 평균연봉순으로 오름차순 정렬하여 조회한다.
SELECT JOB_ID 
     , AVG_SALARY
  FROM (SELECT JOB_ID 
		     , AVG(SALARY) AVG_SALARY
		  FROM EMPLOYEES
		 GROUP BY JOB_ID)
 ORDER BY AVG_SALARY
;
-- 89. 부서별 평균연봉을 최대연봉순으로 내림차순 정렬하여 조회한다.
SELECT DEPARTMENT_ID
     , AVG_SALARY 
  FROM (SELECT DEPARTMENT_ID
             , AVG(SALARY) AVG_SALARY
             , MAX(SALARY) MAX_SALARY
          FROM EMPLOYEES 
         GROUP BY DEPARTMENT_ID)
 ORDER BY MAX_SALARY DESC 
;
-- 90. 이름의 첫 번째 글자별 평균연봉을 조회한다.
SELECT FIRST_ALPH
     , AVG(SALARY)
  FROM (SELECT SUBSTR(FIRST_NAME, 1, 1) FIRST_ALPH
		     , SALARY 
		  FROM EMPLOYEES)
 GROUP BY FIRST_ALPH
;
-- 91. 연도별 최소연봉을 조회한다.
SELECT HIRE_YEAR
     , MIN(SALARY)
  FROM (SELECT TO_CHAR(HIRE_DATE, 'YYYY') HIRE_YEAR
		     , SALARY
		  FROM EMPLOYEES)
 GROUP BY HIRE_YEAR
;
-- 92. 월별 최대연봉 중 2번째 4번째 데이터만 조회한다.
SELECT RNUM
     , HIRE_MONTH
     , MAX_SALARY
  FROM (SELECT ROWNUM RNUM
		     , HIRE_MONTH
		     , MAX_SALARY
		  FROM (SELECT HIRE_MONTH
				     , MAX_SALARY
				  FROM (SELECT HIRE_MONTH
				             , MAX(SALARY) MAX_SALARY
						  FROM (SELECT TO_CHAR(HIRE_DATE, 'MM') HIRE_MONTH
								     , SALARY 
								  FROM EMPLOYEES)
						 GROUP BY HIRE_MONTH)
				 ORDER BY MAX_SALARY DESC)
		 WHERE ROWNUM <= 4)
 WHERE RNUM IN (2, 4)
;
-- 93. 직무명별 최소연봉을 조회한다.
SELECT JOB.JOB_TITLE
     , EMP.MIN_SALARY
  FROM (SELECT JOB_ID 
		     , MIN(SALARY) MIN_SALARY 
		  FROM EMPLOYEES  
		 GROUP BY JOB_ID) EMP
 INNER JOIN JOBS JOB
    ON JOB.JOB_ID = EMP.JOB_ID
;

-- ** JOIN으로 풀기
SELECT JOB.JOB_TITLE 
     , MIN(EMP.SALARY)
  FROM JOBS JOB
 INNER JOIN EMPLOYEES EMP
    ON JOB.JOB_ID = EMP.JOB_ID 
 GROUP BY JOB.JOB_TITLE 
;
-- 94. 부서명별 최대연봉을 조회한다.
SELECT DEP.DEPARTMENT_NAME
     , MAX_SALARY
  FROM (SELECT DEPARTMENT_ID
             , MAX(SALARY) MAX_SALARY
          FROM EMPLOYEES 
         GROUP BY DEPARTMENT_ID) EMP
 INNER JOIN DEPARTMENTS DEP
    ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID
;

--** JOIN으로 풀기
SELECT DEP.DEPARTMENT_NAME 
     , MAX(EMP.SALARY)
  FROM DEPARTMENTS DEP
  LEFT JOIN EMPLOYEES EMP
    ON DEP.DEPARTMENT_ID = EMP.DEPARTMENT_ID 
 GROUP BY DEP.DEPARTMENT_NAME 
;
-- 95. 직무명, 부서명 별 사원 수, 평균연봉을 조회한다.
SELECT JOB.JOB_TITLE 
     , DEP.DEPARTMENT_NAME 
     , EMP.CNT
     , EMP.AVG_SALARY 
  FROM (SELECT JOB_ID 
		     , DEPARTMENT_ID 
		     , COUNT(1) CNT
		     , AVG(SALARY) AVG_SALARY
		  FROM EMPLOYEES 
		 GROUP BY JOB_ID, DEPARTMENT_ID ) EMP
  LEFT JOIN JOBS JOB
    ON EMP.JOB_ID = JOB.JOB_ID 
  LEFT JOIN DEPARTMENTS DEP
    ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID 
;

-- **JOIN으로 풀기
SELECT JOB.JOB_TITLE 
     , DEP.DEPARTMENT_NAME 
     , COUNT(EMP.EMPLOYEE_ID)
     , AVG(EMP.SALARY)
  FROM JOBS JOB
  LEFT JOIN EMPLOYEES EMP
    ON JOB.JOB_ID = EMP.JOB_ID 
  LEFT JOIN DEPARTMENTS DEP
    ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID 
 GROUP BY JOB.JOB_TITLE, DEP.DEPARTMENT_NAME
;
-- 96. 도시별 사원 수를 조회한다.
SELECT LOC.CITY 
     , COUNT(EMP.EMPLOYEE_ID)
  FROM LOCATIONS LOC
  LEFT JOIN DEPARTMENTS DEP
    ON LOC.LOCATION_ID = DEP.LOCATION_ID 
  LEFT JOIN EMPLOYEES EMP
    ON DEP.DEPARTMENT_ID = EMP.DEPARTMENT_ID
 GROUP BY LOC.CITY
;
-- 97. 국가별 사원 수, 최대연봉, 최소연봉을 조회한다.
SELECT COU.COUNTRY_NAME 
     , COUNT(EMP.EMPLOYEE_ID)
     , MAX(EMP.SALARY)
     , MIN(EMP.SALARY)
  FROM COUNTRIES COU
  LEFT JOIN LOCATIONS LOC
    ON COU.COUNTRY_ID = LOC.COUNTRY_ID 
  LEFT JOIN DEPARTMENTS DEP
    ON LOC.LOCATION_ID = DEP.LOCATION_ID 
  LEFT JOIN EMPLOYEES EMP
    ON DEP.DEPARTMENT_ID = EMP.DEPARTMENT_ID 
 GROUP BY COU.COUNTRY_NAME
;

-- ** 서브쿼리로 풀기
SELECT COU.COUNTRY_NAME
     , COUNT(1)
     , MAX(EMP.SALARY)
     , MIN(EMP.SALARY)
  FROM EMPLOYEES EMP
 INNER JOIN COUNTRIES COU
    ON COU.COUNTRY_ID  IN (SELECT COUNTRY_ID
                             FROM LOCATIONS
                            WHERE LOCATION_ID IN (SELECT LOCATION_ID
                                                    FROM DEPARTMENTS
                                                   WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID
                                                                             FROM EMPLOYEES)))
 GROUP BY COU.COUNTRY_NAME
                                                                            
-- 98. 대륙별 사원 수를 대륙명으로 오름차순 정렬하여 조회한다.
SELECT REG_CNT.REGION_NAME
     , REG_CNT.CNT
  FROM (SELECT REG.REGION_NAME
		     , COUNT(1) CNT
		  FROM REGIONS REG
		  LEFT JOIN COUNTRIES COU
		    ON REG.REGION_ID = COU.REGION_ID 
		  LEFT JOIN LOCATIONS LOC
		    ON COU.COUNTRY_ID = LOC.COUNTRY_ID 
		  LEFT JOIN DEPARTMENTS DEP
		    ON LOC.LOCATION_ID = DEP.LOCATION_ID 
		  LEFT JOIN EMPLOYEES EMP
		    ON DEP.DEPARTMENT_ID = EMP.DEPARTMENT_ID 
		 GROUP BY REG.REGION_NAME) REG_CNT
 ORDER BY REG_CNT.REGION_NAME
;

-- ** 서브쿼리로 풀기
SELECT REG.REGION_NAME 
     , COUNT(EMP.EMPLOYEE_ID)
  FROM EMPLOYEES EMP
 INNER JOIN REGIONS REG
    ON REG.REGION_ID IN (SELECT REGION_ID
                           FROM COUNTRIES
                          WHERE COUNTRY_ID IN (SELECT COUNTRY_ID
                                                 FROM LOCATIONS
                                                WHERE LOCATION_ID IN (SELECT LOCATION_ID
                                                                        FROM DEPARTMENTS
                                                                       WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID
                                                                                                 FROM EMPLOYEES))))
 GROUP BY REG.REGION_NAME                                                                                                 


-- 99. 이름이나 성에 'A' 혹은 'a' 가 포함된 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES 
 WHERE FIRST_NAME LIKE '%A%'
    OR FIRST_NAME LIKE '%a%'
    OR LAST_NAME LIKE '%A%'
    OR LAST_NAME LIKE '%a%'
;
-- 100. 국가별로 연봉이 5000 이상인 사원의 수를 조회한다.
SELECT COUNTRY_NAME
     , CNT
  FROM (SELECT COU.COUNTRY_NAME
		     , COUNT(1) CNT
		  FROM EMPLOYEES EMP
		  LEFT JOIN DEPARTMENTS DEP
		    ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID 
		  LEFT JOIN LOCATIONS LOC
		    ON DEP.LOCATION_ID = LOC.LOCATION_ID 
		  LEFT JOIN COUNTRIES COU
		    ON LOC.COUNTRY_ID = COU.COUNTRY_ID 
		 WHERE SALARY >= 5000
		 GROUP BY COU.COUNTRY_NAME)
;

-- ** 좀 더 빠른 연산 (SALARY >= 5000 먼저)
SELECT COU.COUNTRY_NAME
     , COUNT(1)
  FROM (SELECT *
		  FROM EMPLOYEES
		 WHERE SALARY >= 5000) EMP
  LEFT JOIN DEPARTMENTS DEP
    ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID 
  LEFT JOIN LOCATIONS LOC
    ON DEP.LOCATION_ID = LOC.LOCATION_ID 
  LEFT JOIN COUNTRIES COU
    ON LOC.COUNTRY_ID = COU.COUNTRY_ID 
 GROUP BY COU.COUNTRY_NAME
;
-- 101. 커미션을 안받는 사원이 근무하는 도시를 조회한다.
SELECT DISTINCT CITY
  FROM LOCATIONS 
 WHERE LOCATION_ID IN (SELECT LOCATION_ID 
          				 FROM DEPARTMENTS
          				WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID
          										  FROM EMPLOYEES
          										 WHERE COMMISSION_PCT IS NULL))
;
-- 102. 커미션을 포함한 연봉이 10000 이상인 사원의 모든 정보를 조회한다.
SELECT EMP.*
     , NVL(TO_NUMBER(COMMISSION_PCT), 0) NUM_COMMISSION
     , NVL((COMMISSION_PCT * SALARY), 0) CMS
  FROM EMPLOYEES EMP
 WHERE SALARY + (SALARY * COMMISSION_PCT) > 10000
;

SELECT *
  FROM (SELECT SALARY + NVL((COMMISSION_PCT * SALARY), 0) CMS
          FROM EMPLOYEES)
 WHERE CMS >= 10000
;
-- 103. 가장 많은 부서가 있는 도시를 조회한다.
SELECT CITY
  FROM LOCATIONS 
 WHERE LOCATION_ID = (SELECT LOCATION_ID 
						FROM (SELECT LOCATION_ID
								FROM (SELECT LOCATION_ID 
							         	   , COUNT(1) CNT
								        FROM DEPARTMENTS 
									   GROUP BY LOCATION_ID)
							   ORDER BY CNT DESC)
					WHERE ROWNUM = 1)
; 
-- 104. 가장 많은 사원이 있는 부서의 국가명을 조회한다.
SELECT CITY
  FROM LOCATIONS 
 WHERE LOCATION_ID = (SELECT LOCATION_ID 
					    FROM DEPARTMENTS 
					   WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID 
											    FROM (SELECT DEPARTMENT_ID 
													    FROM (SELECT DEPARTMENT_ID 
															       , COUNT(1) CNT
															    FROM EMPLOYEES 
															   GROUP BY DEPARTMENT_ID)
													   ORDER BY CNT DESC)
											   WHERE ROWNUM = 1))
;
-- 105. 우편번호가 5자리인 도시에서 근무하는 사원명, 부서명, 도시명, 우편번호를 조회한다.
SELECT EMP.FIRST_NAME 
     , DEP.DEPARTMENT_NAME 
     , LOC.CITY 
     , LOC.POSTAL_CODE 
  FROM EMPLOYEES EMP
 INNER JOIN DEPARTMENTS DEP
    ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID 
 INNER JOIN LOCATIONS LOC
    ON DEP.LOCATION_ID = LOC.LOCATION_ID
 WHERE LOC.POSTAL_CODE LIKE '_____'
;  
-- 106. 우편번호에 공백이 없는 도시에서 근무하는 사원의 이름, 부서명, 우편번호를 조회한다.
SELECT EMP.FIRST_NAME 
     , DEP.DEPARTMENT_ID 
     , LOC.POSTAL_CODE 
  FROM EMPLOYEES EMP
 INNER JOIN DEPARTMENTS DEP
    ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID 
 INNER JOIN LOCATIONS LOC
    ON DEP.LOCATION_ID = LOC.LOCATION_ID 
 WHERE LOC.POSTAL_CODE NOT LIKE '% %'
;
-- 107. "주"가 없는 도시에서 근무하는 사원의 이름, 도시를 조회한다.
SELECT *
  FROM EMPLOYEES EMP
 INNER JOIN DEPARTMENTS DEP
    ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID 
 INNER JOIN LOCATIONS LOC
    ON DEP.LOCATION_ID = LOC.LOCATION_ID 
 WHERE LOC.STATE_PROVINCE IS NULL
;
-- 108. 국가명이 6자리인 국가의 모든 정보를 조회한다.
SELECT *
  FROM COUNTRIES  
 WHERE COUNTRY_NAME LIKE '______'
;
-- 109. 사원의 이름과 성을 이용해 EMAIL과 같은 값으로 만들어 조회한다.
SELECT SUBSTR(FIRST_NAME, 1, 1) || UPPER(LAST_NAME)
     , EMAIL 
  FROM EMPLOYEES
;
-- 110. 모든 사원들의 이름을 10자리로 변환해 조회한다.
--      예> 이름 => "        이름"
SELECT LPAD(FIRST_NAME, 10, ' ')
  FROM EMPLOYEES
;
-- 111. 모든 사원들의 성을 10자리로 변환해 조회한다.
--      예> 성 => "성         "
SELECT RPAD(LAST_NAME, 10, ' ')
  FROM EMPLOYEES 
;
-- 112. 109번 사원의 입사일 부터 1년 내에 입사한 사원의 모든 정보를 조회한다.
-- 카티션 프로젝트로 접근 -> 위험
SELECT *
  FROM EMPLOYEES 
 WHERE (SELECT HIRE_DATE 
		  FROM EMPLOYEES 
		 WHERE EMPLOYEE_ID = 109) BETWEEN ADD_MONTHS(HIRE_DATE, -12) AND HIRE_DATE
   AND EMPLOYEE_ID != 109
;

-- WITH 함수 (별칭이 붙은 임시 뷰 생성)
WITH HIRE_DATE_109 AS (SELECT HIRE_DATE
                         FROM EMPLOYEES
                        WHERE EMPLOYEE_ID = 109)
SELECT *
  FROM EMPLOYEES
 WHERE HIRE_DATE BETWEEN (SELECT HIRE_DATE
                            FROM HIRE_DATE_109)
                     AND (SELECT ADD_MONTHS(HIRE_DATE, 12)
                            FROM HIRE_DATE_109)
;                            
-- 113. 가장 먼저 입사한 사원의 입사일로부터 2년 내에 입사한 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES 
 WHERE (SELECT MIN(HIRE_DATE)
          FROM EMPLOYEES) BETWEEN ADD_MONTHS(HIRE_DATE, -24) AND HIRE_DATE
   AND HIRE_DATE != (SELECT MIN(HIRE_DATE)
        			   FROM EMPLOYEES) 
;

WITH

-- 114. 가장 늦게 입사한 사원의 입사일 보다 1년 앞서 입사한 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES 
 WHERE (SELECT MAX(HIRE_DATE)
          FROM EMPLOYEES) BETWEEN HIRE_DATE AND ADD_MONTHS(HIRE_DATE, 12) 
   AND HIRE_DATE != (SELECT MAX(HIRE_DATE)
          			   FROM EMPLOYEES)
;

;                                                          
-- 115. 도시명에 띄어쓰기 " " 가 포함된 도시에서 근무중인 사원들의 부서명, 도시명, 사원명을 조회한다.
SELECT DEP.DEPARTMENT_NAME 
     , LOC.CITY 
     , EMP.FIRST_NAME 
  FROM EMPLOYEES EMP 
  INNER JOIN DEPARTMENTS DEP
    ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID 
  INNER JOIN LOCATIONS LOC
    ON DEP.LOCATION_ID = LOC.LOCATION_ID 
 WHERE LOC.CITY LIKE '% %'
;
-- 116. MOD 함수를 통해 사원번호가 홀수면 남자, 
--      짝수면 여자 로 구분해 조회한다. MOD(값, 나눌값)
SELECT EMP.*
     , CASE 
         WHEN MOD(EMPLOYEE_ID, 2) = 1 THEN
           'M'
         WHEN MOD(EMPLOYEE_ID, 2) = 0 THEN
           'F'
          END SEX
  FROM EMPLOYEES EMP 
; 

-- ** 올바른 코드
SELECT CASE MOD(EMPLOYEE_ID, 2)
        WHEN 0 THEN
          '여자'
        ELSE 
          '남자'
        END "성별"
  FROM EMPLOYEES 
;

-- ** DECODE 사용
SELECT DECODE(MOD(EMPLOYEE_ID, 2)
            , 0, '여자'
            , '남자')
  FROM EMPLOYEES 
;
-- 117. '20230222' 문자 데이터를 날짜로 변환해 조회한다.
--      (DUAL)
SELECT TO_DATE('20230222', 'YYYY-MM-DD') NEW_DATE
  FROM DUAL
;
-- 118. '20230222' 문자 데이터를 'YYYY-MM' 으로 변환해 조회한다.
--      (DUAL)
SELECT TO_CHAR(TO_DATE('20230222', 'YYYY-MM-DD'), 'YYYY-MM') NEW_DATE
  FROM DUAL
;
-- 119. '20230222130140' 문자 데이터를 
--      'YYYY-MM-DD HH24:MI:SS' 으로 변환해 조회한다. (DUAL)
SELECT TO_DATE('20230222130140', 'YYYY-MM-DD HH24:MI:SS') NEW_DATE
  FROM DUAL
;
-- 120. '20230222' 날짜의 열흘 후의 날짜를 
--      'YYYY-MM-DD' 으로 변환해 조회한다. (DUAL)
SELECT TO_DATE('20230222', 'YYYY-MM-DD') + 10 NEW_DATE
  FROM DUAL
;
-- 121. 사원 이름의 글자수 별 사원의 수를 조회한다.
SELECT LENGTH(FIRST_NAME)
     , COUNT(1)
  FROM EMPLOYEES 
 GROUP BY LENGTH(FIRST_NAME)
;

-- ** SQL 함수는 SELECT에만 사용
SELECT NAME_LEN
     , COUNT(1)
  FROM (SELECT LENGTH(FIRST_NAME) NAME_LEN
          FROM EMPLOYEES)
 GROUP BY NAME_LEN
;
-- 122. 사원 성의 글자수 별 사원의 수를 조회한다.
SELECT LENGTH(LAST_NAME)
     , COUNT(1)
  FROM EMPLOYEES 
 GROUP BY LENGTH(LAST_NAME)
;
-- 123. 사원의 연봉이 5000 이하이면 "사원", 
--      7000 이하이면 "대리", 
--      9000 이하이면 "과장", 그 외에는 임원 으로 조회한다.
SELECT EMP.* 
     , CASE
	     WHEN SALARY <= 9000 AND SALARY > 7000 THEN
	       '과장'
	     WHEN SALARY <= 7000 AND SALARY > 5000 THEN
	       '대리'
	     WHEN SALARY <= 5000 THEN 
	       '사원'
	     ELSE 
	       '임원'
	     END "직급"
  FROM EMPLOYEES EMP
;
-- 124. 부서별 사원의 수를 조인을 이용해 다음과 같이 조회한다.
--      "부서명 (사원의 수)"
SELECT DEP.DEPARTMENT_NAME || '( ' || COUNT(1) || ' )' DEP_CNT
  FROM EMPLOYEES EMP
 RIGHT JOIN DEPARTMENTS DEP
    ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID 
 GROUP BY DEP.DEPARTMENT_NAME
;
-- 125. 부서별 사원의 수를 스칼라쿼리를 이용해 다음과 같이 조회한다. "부서명 (사원의 수)"
SELECT DEP.DEPARTMENT_NAME || ' (' || (SELECT COUNT(1)
									 FROM EMPLOYEES EMP 
									WHERE EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID) || ')' DEP_CNT
  FROM DEPARTMENTS DEP
;
-- 126. 사원의 정보를 다음과 같이 조회한다. 
--      "사원번호 번 사원의 이름은 성이름 입니다."
SELECT EMPLOYEE_ID
     , FIRST_NAME
     , LAST_NAME
     , EMPLOYEE_ID || '번 사원의 이름은 ' || FIRST_NAME || ' ' || LAST_NAME || ' 입니다.' INTRODUCE
  FROM EMPLOYEES 
;
-- 127. 사원의 정보를 스칼라쿼리를 이용해 다음과 같이 조회한다.
--      "사원번호 번 사원의 상사명은 상사명 입니다."
SELECT EMPLOYEE_ID
     , FIRST_NAME 
     , LAST_NAME
     , EMPLOYEE_ID || ' 번의 사원의 상사명은 ' || (SELECT MAN.FIRST_NAME 
                                                   FROM EMPLOYEES MAN
                                                  WHERE EMP.MANAGER_ID = MAN.EMPLOYEE_ID) || ' 입니다.' INTRODUCE_MANAGER
  FROM EMPLOYEES EMP
;
-- 128. 사원의 정보를 조인을 이용해 다음고 같이 조회한다. 
--      "사원명 (직무명)"
SELECT EMP.FIRST_NAME 
     , EMP.LAST_NAME 
     , JOB.JOB_TITLE
     , EMP.FIRST_NAME || ' ' || EMP.LAST_NAME || ' (' || JOB.JOB_TITLE || ')' EMP_JOB
  FROM EMPLOYEES EMP
 INNER JOIN JOBS JOB
    ON JOB.JOB_ID = EMP.JOB_ID
;
-- 129. 사원의 정보를 스칼라쿼리를 이용해 다음과 같이 조회한다. 
--      "사원명 (직무명)"
SELECT FIRST_NAME || ' ' || LAST_NAME || ' (' || (SELECT JOB_TITLE
                                                    FROM JOBS JOB
                                                   WHERE JOB.JOB_ID = EMP.JOB_ID) || ')' EMP_JOB
  FROM EMPLOYEES EMP
;
-- 130. 부서별 연봉 차이(최고연봉 - 최저연봉)가 가장 큰 
--      부서명을 조회한다.
SELECT DEPARTMENT_NAME
     , MAX_MIN
  FROM (SELECT DEPARTMENT_NAME
		     , MAX_MIN
		  FROM (SELECT DEP.DEPARTMENT_NAME 
				     , MAX(SALARY) - MIN(SALARY) MAX_MIN
				  FROM EMPLOYEES EMP 
				 INNER JOIN DEPARTMENTS DEP
				    ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID 
				 GROUP BY DEP.DEPARTMENT_NAME)
		 ORDER BY MAX_MIN DESC)
 WHERE ROWNUM = 1
;
-- 131. 부서별 연봉 차이(최고연봉 - 최저연봉)가 가장 큰 
--      부서에서 근무하는 사원들의 직무명을 중복없이 조회한다.
SELECT DISTINCT JOB_TITLE
  FROM JOBS
 WHERE JOB_ID IN (SELECT JOB_ID
                   FROM EMPLOYEES
                  WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID
										  FROM (SELECT DEPARTMENT_ID
												     , MAX_MIN
												  FROM (SELECT DEPARTMENT_ID
														     , MAX(SALARY) - MIN(SALARY) MAX_MIN
														  FROM EMPLOYEES
														 GROUP BY DEPARTMENT_ID)
												 ORDER BY MAX_MIN DESC)
										 WHERE ROWNUM = 1))
;
-- 132. 부서장이 없는 부서명 중 첫 글자가 'C' 로 시작하는 
--      부서명을 조회한다.
SELECT *
  FROM DEPARTMENTS 
 WHERE MANAGER_ID IS NULL
   AND DEPARTMENT_NAME LIKE 'C%'
;
-- 133. 부서장이 있는 부서명 중 첫 글자가 'S' 로 시작하는 
--      부서에서 근무중인 사원의 이름과 직무명, 부서명을 조회한다.
SELECT EMP.FIRST_NAME 
     , JOB.JOB_TITLE 
     , DEP.DEPARTMENT_NAME 
  FROM EMPLOYEES EMP
 INNER JOIN DEPARTMENTS DEP
    ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID 
 INNER JOIN JOBS JOB
    ON EMP.JOB_ID = JOB.JOB_ID 
 WHERE DEP.DEPARTMENT_NAME LIKE 'S%'
   AND DEP.MANAGER_ID IS NOT NULL
;                                                 
-- 134. 지역변호가 1000 ~ 1999 사이인 지역내 부서의 
--      모든 정보를 조회한다.
SELECT *
  FROM DEPARTMENTS 
 WHERE LOCATION_ID BETWEEN 1000 AND 1999
;
-- 135. 90, 60, 100번 부서에서 근무중인 사원의 
--      이름, 성, 부서명을 조회한다.
SELECT EMP.FIRST_NAME 
     , EMP.LAST_NAME 
     , DEP.DEPARTMENT_NAME 
  FROM EMPLOYEES EMP
 INNER JOIN DEPARTMENTS DEP
    ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID 
 WHERE EMP.DEPARTMENT_ID IN (90, 60, 100)
 ;
-- 136. 부서명이 5글자 미만인 부서에서 근무중인 사원의 
--      이름, 부서명을 조회한다.
SELECT EMP.FIRST_NAME 
     , DEP.DEPARTMENT_NAME 
  FROM EMPLOYEES EMP
 INNER JOIN DEPARTMENTS DEP
    ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID 
 WHERE LENGTH(DEP.DEPARTMENT_NAME) < 5
;

-- **SELECT가 아닌 곳에 함수 쓰지 않기
SELECT EMP.FIRST_NAME
     , DEP.DEPARTMENT_NAME
 FROM (SELECT LENGTH(DEPARTMENT_NAME) LEN
		    , DEPARTMENT_NAME
		    , DEPARTMENT_ID
		 FROM DEPARTMENTS) DEP
INNER JOIN EMPLOYEES EMP
   ON DEP.DEPARTMENT_ID = EMP.DEPARTMENT_ID 
 WHERE LEN < 5


-- 137. 국가 아이디가 'C'로 시작하는 국가의 지역을 모두 조회한다.
SELECT *
  FROM REGIONS 
 WHERE REGION_ID IN (SELECT REGION_ID
                       FROM COUNTRIES
                      WHERE COUNTRY_ID LIKE 'C%')
;                
-- 138. 국가 아이디의 첫 글자와 국가명의 
--      첫 글자가 다른 모든 국가를 조회한다.
SELECT *
  FROM COUNTRIES 
 WHERE SUBSTR(COUNTRY_ID, 1, 1) != SUBSTR(COUNTRY_NAME, 1, 1)
;

SELECT *
  FROM (SELECT SUBSTR(COUNTRY_ID, 1, 1) ID
             , SUBSTR(COUNTRY_NAME, 1, 1) NAME
             , COU.*
          FROM COUNTRIES COU)
 WHERE ID != NAME
;
-- 139. 사원 모든 정보 중 이메일만 모두 소문자로 
--      변경하여 조회한다.
SELECT EMP.*
     , LOWER(EMAIL)
  FROM EMPLOYEES EMP
;
-- 140. 사원의 연봉을 TRUNC(소수점 버림) 함수를 사용해 
--      100 단위는 버린채 다음과 같이 조회한다.  
--      예> 3700 -> 3000, 12700 -> 12000
SELECT TRUNC(SALARY, -3)
  FROM EMPLOYEES 
;
-- 141. 100단위를 버린 사원의 연봉 별 사원의 수를 조회한다.
SELECT SIMPLE_SAL
     , COUNT(1) CNT
  FROM (SELECT TRUNC(SALARY, -3) SIMPLE_SAL
  		  FROM EMPLOYEES)
 GROUP BY SIMPLE_SAL
;
-- 142. 현재 시간으로부터 20년 전 보다 일찍 입사한 사원의 
--      모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES 
 WHERE HIRE_DATE < ADD_MONTHS(SYSDATE, -12 * 20) 
;
-- 143. 부서번호별 현재 시간으로부터 15년 전 보다 일찍 입사한 
--      사원의 수를 조회한다.
SELECT DEPARTMENT_ID
     , COUNT(1)
  FROM EMPLOYEES 
 WHERE HIRE_DATE < ADD_MONTHS(SYSDATE, -12 * 15)
GROUP BY DEPARTMENT_ID 
;
-- 144. 부서명, 직무명 별 평균 연봉을 조회한다.
SELECT DEPARTMENT_ID
     , JOB_TITLE
     , AVG(SALARY)
  FROM (SELECT DEP.DEPARTMENT_ID 
		     , JOB.JOB_TITLE 
		     , EMP.SALARY 
		  FROM EMPLOYEES EMP
		 INNER JOIN DEPARTMENTS DEP
		    ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID 
		 INNER JOIN JOBS JOB
		    ON EMP.JOB_ID = JOB.JOB_ID)
 GROUP BY DEPARTMENT_ID, JOB_TITLE
; 
-- 145. 도시명, 주 별 사원의 수를 조회한다.
SELECT LOC.CITY 
     , LOC.STATE_PROVINCE 
	 , COUNT(EMP.EMPLOYEE_ID) CNT
  FROM LOCATIONS LOC
  LEFT JOIN EMPLOYEES EMP
    ON EMP.DEPARTMENT_ID IN (SELECT DEPARTMENT_ID
    						  FROM DEPARTMENTS DEP
    						 WHERE DEP.LOCATION_ID = LOC.LOCATION_ID)
 GROUP BY CITY, STATE_PROVINCE  
;
-- 146. 부서명, 직무명 별 평균 연봉 중 
--      가장 작은 평균연봉을 받는 부서명, 직무명을 조회한다.
SELECT DEPARTMENT_ID
     , JOB_TITLE
  FROM (SELECT DEPARTMENT_ID
		     , JOB_TITLE
		     , AVG_SAL
		  FROM (SELECT DEPARTMENT_ID
				     , JOB_TITLE
				     , AVG(SALARY) AVG_SAL
				  FROM (SELECT DEP.DEPARTMENT_ID 
						     , JOB.JOB_TITLE 
						     , EMP.SALARY 
						  FROM EMPLOYEES EMP
						 INNER JOIN DEPARTMENTS DEP
						    ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID 
						 INNER JOIN JOBS JOB
						    ON EMP.JOB_ID = JOB.JOB_ID)
				 GROUP BY DEPARTMENT_ID, JOB_TITLE)
		 ORDER BY AVG_SAL)
 WHERE ROWNUM = 1
; 
-- 147. 102번 직원의 모든 부하직원의 수를 조회한다.
SELECT COUNT(*)
  FROM (SELECT 1
		  FROM EMPLOYEES
		 WHERE EMPLOYEE_ID != 102  
		 START WITH EMPLOYEE_ID = 102
	   CONNECT BY PRIOR EMPLOYEE_ID = MANAGER_ID)
;

 SELECT COUNT(1)
   FROM EMPLOYEES EMP 
  WHERE EMPLOYEE_ID != 102
  START WITH EMP.EMPLOYEE_ID = 102
CONNECT BY PRIOR EMP.EMPLOYEE_ID = EMP.MANAGER_ID
;

-- 148. 113번 직원의 모든 부하직원의 수를 조회한다.
SELECT COUNT(*)
  FROM (SELECT 1
		  FROM EMPLOYEES
		 WHERE EMPLOYEE_ID != 113  
		 START WITH EMPLOYEE_ID = 113
	   CONNECT BY PRIOR EMPLOYEE_ID = MANAGER_ID)
;

 SELECT COUNT(1) - 1
   FROM EMPLOYEES 
 START WITH EMPLOYEE_ID = 113
CONNECT BY PRIOR EMPLOYEE_ID = MANAGER_ID
;

-- 149. 부하직원이 없는 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES E1
 WHERE E1.EMPLOYEE_ID NOT IN (SELECT MANAGER_ID
 		    					FROM EMPLOYEES E2
 		    				   WHERE E2.MANAGER_ID = E1.EMPLOYEE_ID)
; 				    
-- 150. 사원번호가 100번인 사원의 사원번호, 이름과 
--      사원번호로 내림차순 정렬된 사원의 사원번호, 이름 조회한다.

/*조회 예
--------------------
100    Steven
206    William
205    Shelley
204    Hermann
203    Susan
202    Pat
201    Michael
200    Jennifer
199    Douglas
198    Donald
197    Kevin
196    Alana
...
*/

SELECT EMPLOYEE_ID
     , FIRST_NAME
  FROM EMPLOYEES
 WHERE EMPLOYEE_ID = 100
UNION ALL
SELECT *
  FROM (SELECT EMPLOYEE_ID
		     , FIRST_NAME
		  FROM EMPLOYEES
		 WHERE EMPLOYEE_ID != 100
		 ORDER BY EMPLOYEE_ID DESC)

SELECT EMPLOYEE_ID 
     , FIRST_NAME 
  FROM EMPLOYEES 
 ORDER BY DECODE(EMPLOYEE_ID, 100, 1), EMPLOYEE_ID DESC 
;

SELECT EMPLOYEE_ID
     , FIRST_NAME
  FROM EMPLOYEES 
 ORDER BY CASE EMPLOYEE_ID 
            WHEN 100 THEN 1
            ELSE 2
            END
          , EMPLOYEE_ID DESC 
;

-- 150. 사원번호가 100번인 사원의 사원번호, 이름과 사원번호로 내림차순 정렬된 사원의 사원번호, 이름 조회한다.
SELECT EMPLOYEE_ID 
	 , FIRST_NAME
  FROM (SELECT EMPLOYEE_ID 
			 , FIRST_NAME
			 , DECODE(EMPLOYEE_ID
			 		, 100, 1
			 		, ROWNUM + 1) RNUM
		  FROM EMPLOYEES
		 ORDER BY EMPLOYEE_ID DESC)
 ORDER BY RNUM
;

SELECT *
  FROM (SELECT EMPLOYEE_ID 
			 , FIRST_NAME
		  FROM EMPLOYEES
		 WHERE EMPLOYEE_ID = 100)
 UNION ALL
SELECT *
  FROM (SELECT EMPLOYEE_ID 
			 , FIRST_NAME
		  FROM EMPLOYEES
		 WHERE EMPLOYEE_ID != 100
		 ORDER BY EMPLOYEE_ID DESC)
;