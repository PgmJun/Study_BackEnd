



# SQL-TIL



### 목차

- 이론
  - [무결성](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#%EB%AC%B4%EA%B2%B0%EC%84%B1)
  - [정규화](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#%EC%A0%95%EA%B7%9C%ED%99%94)
  - [SQL 문장의 종류](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#sql-%EB%AC%B8%EC%9E%A5-%EC%A2%85%EB%A5%98)
  - [식별자의 종류](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#%EC%8B%9D%EB%B3%84%EC%9E%90%EC%9D%98-%EC%A2%85%EB%A5%98)
  - [제약조건](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#%EC%A0%9C%EC%95%BD%EC%A1%B0%EA%B1%B4)
  - 서브쿼리
    - [서브쿼리에 따른 명칭](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#%EC%84%9C%EB%B8%8C%EC%BF%BC%EB%A6%AC%EC%9D%98-%EC%9C%84%EC%B9%98%EC%97%90-%EB%94%B0%EB%A5%B8-%EB%AA%85%EC%B9%AD)
    - [서브쿼리의 반환 값에 따른 서브쿼리 종류](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#%EC%84%9C%EB%B8%8C%EC%BF%BC%EB%A6%AC%EC%9D%98-%EB%B0%98%ED%99%98-%EA%B0%92%EC%97%90-%EB%94%B0%EB%A5%B8-%EC%84%9C%EB%B8%8C%EC%BF%BC%EB%A6%AC-%EC%A2%85%EB%A5%98)
  - [저장 모듈](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#%EC%A0%80%EC%9E%A5-%EB%AA%A8%EB%93%88)
  - [옵티마이저](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#%EC%98%B5%ED%8B%B0%EB%A7%88%EC%9D%B4%EC%A0%80)
  - [순수 관계 연산자](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#%EC%88%9C%EC%88%98-%EA%B4%80%EA%B3%84-%EC%97%B0%EC%82%B0%EC%9E%90)
  - [DB 엔진에 따른 '' NULL처리 여부](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#insert-%EA%B5%AC%EB%AC%B8%EC%97%90%EC%84%9C-%EC%82%BD%EC%9E%85-%EC%8B%9C-null%EC%B2%98%EB%A6%AC)
  - [인덱스](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#%EC%9D%B8%EB%8D%B1%EC%8A%A4)
  - [트랜잭션](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98transaction)



- 문법
  - [CREATE TABLE](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#create-table)
  - [ALTER TABLE](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#create-table)
  - [CHAR / VARCHAR](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#chars-varchars%EC%9D%98-%EC%B0%A8%EC%9D%B4%EC%A0%90)
  - [GROUP BY, HAVING](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#group-by-having%EC%A0%88)
  - [ON DELETE / UPDATE](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#on-deleteupdate)
  - [DELETE / TRUNCATE](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#delete--truncate-table-%EC%B0%A8%EC%9D%B4)
  - [UNION / UNIONALL](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#union--unionall)
  - [JOIN 종류](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#join)
  - [JOIN에서의 (+) 기호](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#leftright-outer-join) 
  - [COALESCE](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#coalesce)
  - [ORACLE 분석함수(RANK)](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#%EC%98%A4%EB%9D%BC%ED%81%B4-%EB%B6%84%EC%84%9D%ED%95%A8%EC%88%98rank-over-row_number-over)
  - [NLJoin / SMJoin / HashJoin](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#nljoin-smjoin-hashjoin)

---





<h1>무결성</h1>

무결성 제약조건의 주요 목적은 데이터베이스에 저장된 데이터의 무결성을 보장하고 데이터베이스의 상태를 일관되게 유지하는 것입니다. 그래서 이를 위해 필요한 세부 규칙도 정의하고 있습니다. 데이트베이스가 삽입, 삭제, 수정, 연산으로 상태가 변하더라도 무결성 제약조건은 반드시 지켜져야 합니다.

무결성 제약조건의 종류와 개념
1. 개체 무결성 : 기본키는 null 값이 될 수 없음 <br>
개체 무결성 제약조건은 기본키를 구성하는 모든 속성은 널 값을 가지면 안된다는 규칙입니다. 관계 데이터 모델에서는 릴레이션에 포함되는 튜플들을 유일하게 구별해주고 각 튜플에 쉽게 접근할 수 있도록 릴레이션마다 기본키를 정의하는 기본키를 구성하는 속성 전체나 일부가 널 값이 되면 튜플의 유일성을 판단할 수 없기 때문에 본래의 목적을 상실하게 됩니다. 

 

2. 참조 무결성 : 외래키는 참조할 수 없는 값을 가질 수 없음 <br>
참조 무결성 제약조건은 외래키는 참조할 수 없는 값을 가질 수 없다는 규칙입니다. 외래키는 다른 릴레이션의 기본키를 참조하는 속성이고 릴레이션 간의 관계를 표현하는 역할을 합니다. 그런데 외래키가 자신이 참조하는 릴레이션의 기본키와 상관없는 값을 가지게 되면 두 릴레이션을 연관시킬 수 없으므로 외래키 본래의 의미가 없어집니다.

 

3. 도메인 무결성 : 특정 속성값은 그 속성이 정의된 도메인에 속한 값이어야 함 <br>
도메인 무결성은 데이터 베이스에 삽입되는 데이터들에 제약조건을 의미합니다. 각각의 속성은 숫자, 문자 등의 도메인을 가지면 해당 도메인에 맞는 데이터를 삽입해야 합니다. 그 뿐만 아니라 삽입되는 데이터를 제한하거나, 삽입되지 않을 경우 기본값, null 제한 등의 기능을 제공합니다. 예를 들어 "성"에 대한 속성의 경우 입력되는 데이터를 "남", "여"로 제한하여 그 외의 데이터가 삽입되는 경우를 제한할 수 있습니다. 

 

4. 키 무결성 : 릴레이션에는 최소한 하나의 키가 존재해야 함


5. null 무결성 : 특정 속성은 null 값을 가질 수 없음 <br>
null 무결성은 특정 속성값에는 null 값을 가질 수 없다는 규칙입니다. 기본적으로 속성값으로 null 값을 가질 수 있는데 만약 "유저 아이디"처럼 중요한 정보에는 스키마를 정의할 때 해당 속성을 null 데이터가 올 수 없음을 미리 정의할 수 있습니다. 

 

6. 고유 무결성 : 특정 속성값은 서로 달라야 함 <br>
고유 무결성은 특정 속성에 삽입되는 데이터는 고유한 값을 가져야 한다는 규칙입니다. 이말은 즉, 각 튜플에서 하나의 속성값은 중복된 값이 없는 각각 서로 다른 값을 가져야 한다는 의미입니다. 예를 들어 이름, 나이, 사는 곳과 같은 속성은 튜프들이 서로 같은 값을 가질 수 있지만 고객 아이디의 경우 각 튜플을 서로 다른 값을 가져야 합니다. 






<h1>정규화</h1>

- 1차 정규화:<br>
같은 성격과 내용의 컬럼이 연속적으로 나타나는 컬럼이 존재할 때, 해당 컬럼을 제거하고 기본테이블의 PK를 추가해 새로운 테이블을 생성하고, 기존의 테이블과 1:N의 관계 형성
- 2차 정규화:<br>
PK가 여러 키로 구성된 복합키(Composite Primary Key)로 구성된 경우가 2차 정규화의 대상이 되며, 복합키 전체에 의존하지 않고 복합키의 일부분에만 종속되는 속성들이 존재할 경우 (즉, 부분적 함수 종속 관계) 이를 분리하는 것이다.
- 3차 정규화<br>
테이블의 키가 아닌 컬럼들은 기본키에 의존해야 하는데 겉으로는 그런 것처럼 보이지만 실제로는 기본키가 아닌 다른 일반 컬럼에 의존하는 컬럼들이 있을 수 있다. 이를 (이전적 함수 종속 관계)라고 한다. 제 3정규화는 PK에 의존하지 않고 일반컬럼에 의존하는 컬럼들을 분리한다.





<h1>SQL 문장 종류</h1>

- DDL(Data Definition Language) 데이터 정의어:<br>
CREATE, DROP, ALTER, RENAME / 테이블 관련 설정

- DML(Data Manipulation Language) 데이터 조작어:<br>
SELECT, INSERT, UPDATE, DELETE / 데이터 관련 설정

- DCL(Data Control Language) 데이터 제어어:<br>
REVOKE, GRANT

- TCL(Transaction Control Language) 트렌젝션 제어어:<br>
COMMIT, ROLLBACK





<h1>식별자의 종류</h1>

- 대표성 여부:<br>
-주식별자: 엔터티 내에서 각 어커런스를 구분할 수 있는 구분자이며, 타 엔터티와 참조관계를 연결할 수 있는 식별자<br>
-보조식별자: 엔터티 내에서 각 어커런스를 구분할 수 있는 구분자이나 대표성을 가지지 못해 참조관계 연결을 못함

- 스스로 생성 여부:<br>
-내부식별자: 엔터티 내부에서 스스로 만들어지는 식별자<br>
-외부식별자: 타 엔터티와의 관계를 통해 타 엔터티로부터 받아오는 식별자

- 속성의 수:<br>
-단일식별자: 하나의 속성으로 구성된 식별자<br>
-복합식별자: 둘 이상의 속성으로 구성된 식별자


- 대체 여부:<br>
-본질식별자: 업무에 의해 만들어지는 식별자<br>
-인조식별자: 업무적으로 만들어지지는 않지만 원조식별자가 복잡한 구성을 가지고 있기 때문에 인위적으로 만든 





<h1>CREATE TABLE</h1>

- 문장 작성법: CREATE TABLE 테이블이름 ( 속성 자료형 설정, ... ); <br>

- 칼럼, 테이블명은 "반드시" 문자로 시작<br>

- A-Z, a-z, 0-9, _, $, # 만 사용가능<br>

- 테이블명, 칼럼명 중복X 





<h1>제약조건</h1>

- Primary key(기본키): 중복X(고유함), NOT NULL
- Unique key(고유키): 중복X(고유함)
- NOT NULL: NULL 금지
- CHECK: 입력 값 범위 제한<br>
사용법EX) CREATE TABLE EXAM(A INT CHECK(A IN(1,2,3))); || SELECT * FROM EXAM WHERE AGE IN(22,23);





<h1>테이블 구조변경(DDL)</h1>

- 컬럼 추가:<br>
ALTER TABLE 테이블명 ADD 컬럼명 자료형;
- 컬럼 제거:<br>
ALTER TABLE 테이블명 DROP COLUMN 컬럼명;
- 컬럼 데이터 유형 조건 등 변경:<br>
ORACLE) ALTER TABLE 테이블명 MODIFY(컬럼명 데이터 유형 DEFAULT식 NOT NULL);<br>
SQL SERVER) ALTER TABLE 테이블명 ALTER(컬럼명 데이터 유형 DEFAULT식 NOT NULL);<br>
- 컬럼명 변경:<br>
ALTER TABLE 테이블명 RENAME COLUMN 컬럼명 TO 뉴컬럼명<br>
- 제약조건 삭제:<br>
ALTER TABLE 테이블명 DROP CONSTRAINT 조건명;





<h1>CHAR(s), VARCHAR(s)의 차이점</h1>

- CHAR(s): 고정길이<br>
ex) CHAR(3) 'aa' = 'aa '<br>

- VARCHAR(s): 가변길이<br>
ex) VARCHAR(3) 'aa' != 'aa '<br>





<h1>GROUP BY, HAVING절</h1>

- GROUP BY: SELECT [GROUP BY로 묶일 칼럼] [GROUP BY로 묶여 집계할 값] FROM 테이블명 GROUP BY [그룹으로 묶을 칼럼]

- HAVING: SELECT [GROUP BY로 묶일 칼럼] [GROUP BY로 묶여 집계할 값] FROM 테이블명 GROUP BY [그룹으로 묶을 칼럼] HAVING [GROUP BY로 묶여 집계된 값에 조건추가]

- ex) SELECT 학급반, SUM(점수) FROM 학생 GROUP BY 학급반 HAVING SUM(점수) > 150;

  = 학생테이블에서 학급반을 GROUP BY로 묶고 반별로 학생들 점수의 합을 150점 이상인 반만 출력



*GROUP BYY절에는 ALIAS사용 불가 

*집계함수는 WHERE절에 올 수 없으므로 HAVING절에 조건을 추가 





<h1>ORDER BY절</h1>

- SQL문으로 조회된 데이터를 다양한 목적에 맞게 특정 칼럼을 기준으로 정렬<br>
- ALIAS사용가능<br>
- DEFAULT값은 ASC(오름차순)<br>
- SQL구문 제일 마지막에 위치<br>
- 사용법: SELECT * FROM 테이블이름 ORDER BY 점수 DESC;<br>





<h1>ON DELETE/UPDATE</h1>

#on DELETE SET NULL
#on UPDATE SET NULL

- 옵션 SET NULL -> 부모테이블에서 primary 값이 수정 또는 삭제될 경우<br> 하위테이블의 reference값은 존재할 수 없습니다. 옵션이 없을 경우는 에러가 발생하고 옵션 SET NULL 로 정의되면 하위테이블의 reference값이  NULL 값으로 변경되면서 참조무결성을 유지합니다.

#on UPDATE CASCADE
- 옵션 CASCADE -> 부모테이블에서 primary 값이 수정될 경우<br> 옵션 CASCADE 로 정의되면 하위테이블의 reference값은 변경된 상위테이블의 수정된 값을 가지면서 참조무결성을 유지합니다.

#on DELETE CASCADE
- 옵션 CASCADE ->부모테이블에서 primary 값이 삭제될 경우<br>옵션 CASCADE 로 정의되면 하위테이블의 reference값은 삭제되면서 참조무결성을 유지합니다.<br>

사용예시:<br>
FOREIGN KEY(A) REFERENCES B(C) ON DELETE CASCADE





<h1>DELETE / TRUNCATE TABLE 차이</h1>
- DELETE: DELETE 문은 행을 한번에 하나씩 제거하고 삭제된 각 행에 대해 트랜잭션 로그에 항목을 기록<br>
- TRUNCATE TABLE: 테이블의 데이터를 저장하는 데 사용되는 데이터 페이지의 할당을 취소하는 방식으로 데이터를 제거하며 페이지 할당 취소만을 트랜잭션 로그에 기록





<h1>UNION / UNIONALL</h1>
- Union과 UnionAll은 두 쿼리문을 하나로 합쳐준다.<br>
-출력: Union) 중복값 제거해서 결과출력 / UnionAll) 중복된 값도 전부 다 출력<br>
-속도: UnionAll > Union (UNION은 중복값제거를 위해 연산을 한번 더 해야하기때문)<br>
-사용법: 쿼리문1 Union/UnionAll 쿼리문2
-주의점: 칼럼명이 서로 같아야 함(다르면 AS사용해서 같게 해줄 수 있음)





<h1>INSERT 구문에서 ''삽입 시 NULL처리</h1>
ORACLE: '' -> NULL
SQL SERVER: '' -> ''





<h1>JOIN</h1>
- JOIN은 관계형 데이터 베이스에서 쪼개져 있는 데이터들을 관련있는 컬럼을 기준으로 행을 합쳐주는 연산자다.<br>
<h3>JOIN의 종류</h3>
- 내부 조인 (INNER JOIN)<br>
- 교차 조인 (CROSS JOIN  <-> <strong>CARTESIAN JOIN</strong>)<br>
- 등가/동등/동일 조인(EQUI JOIN)<br>
- 비등가 조인(NON-EQUI JOIN)<br>
- 자연 조인 (NATURAL JOIN)<br>
- 외부 조인 (OUTER JOIN)<br>
- 완전 외부 조인 (FULL OUTER JOIN)<br>
- 왼쪽 (LEFT OUTER JOIN)<br>
- 오른쪽 (RIGHT OUTER JOIN)<br>
- 셀프 조인 (SELF JOIN)<br>
- 안티 조인 (ANTI JOIN)<br>
- 세미 조인 (SEMI JOIN)<br>
<br>
<br>
  
![httpsdsin wordpress com20130316sql-join-cheat-sheet](https://user-images.githubusercontent.com/84304802/144785067-27070961-1601-446f-b79e-160d87b34e95.png)

[출처](httpsdsin.wordpress.com20130316sql-join-cheat-sheet)





<h1>LEFT/RIGHT OUTER JOIN</h1>
- 조인조건에 성립하는 부분과 지정해준 LEFT/RIGHT의 기준이 되는 테이블의 로우를 출력해주는 JOIN이다<br>
기준이 되는 반대쪽에 (+)를 표시하면 OUTER JOIN을 나타낼 수 있다.<br>
ex) SELECT A.게시판ID,  A.게시판명, COUNT(B.게시글ID) AS CNT<br>
FROM 게시판 A, 게시글 B<br>
WHERE A.게시판ID = B.게시판ID(+)<br>
->  "FROM 게시판 LEFT OUTER JOIN 게시글" 로 처리한 것과 같음





<h1>서브쿼리의 위치에 따른 명칭</h1>
- SELECT문에 있는 서브쿼리: 스칼라 서브쿼리<br>
 -스칼라 서브쿼리는 1행만 반환<br>
- FROM절에 있는 서브쿼리: 인라인 뷰<br>
- WHERE절에 있는 서브쿼리: 서브쿼리





<h1>서브쿼리의 반환 값에 따른 서브쿼리 종류</h1>
- 단일 행 서브쿼리: 서브쿼리 결과가 1행 [비교연산자: =, <, >, <=, >=, <>]<br>
- 다중 행 서브쿼리: 서브쿼리 결과가 여러행 [비교연산자: IN, ALL, ANY, SOME, EXISTS]<br>
- 다중 컬럼 서브쿼리: 서브쿼리 결과가 여러 컬럼





# COALESCE

- 처음으로 NULL값이 아닌 값을 발견하면 그 값을 반환  
- ex) SELECT COALESCE (컬럼1, 컬럼2, ... , 컬럼N) FROM 테이블  
여기서 처음으로 NULL이 아닌 컬럼을 결과값으로 리턴한다.  





# 오라클 분석함수(RANK OVER(), ROW_NUMBER() OVER())

- RANK OVER(): 동일 순위인 경우 1,1,3 형식으로 출력
- ROW_NUMBER OVER(): 동일 순위인 경우 1,2,3 형식으로 출력
- DENSE_RANK(): 동일 순위인 경우 1,1,2 형식으로 출력





# 순수 관계 연산자

- SELECT
- PROJECT
- JOIN
- DIVIDE





# 저장 모듈

- SQL문을 데이터 베이스 서버에 저장하여 사용자와 애플리케이션 사이에서 공유할 수 있도록 만든

  일종의 SQL 컴포넌트 프로그램

- 독립적으로 실행되거나 다른 프로그램으로부터 실행될 수 있는 완전한 실행 프로그램

- Oracle의 저장모듈
  - 프로시져(Procedure)
  - User Defined Fuction
  - 트리거(Trigger)





# 옵티마이저

- 규칙기반 옵티마이저:

  우선순위 규칙에 따라 실행계획 생성, 인덱스가 있으면 반드시 인덱스 사용

- 비용기반 옵티마이저:

  처리 비용이 가장 적은 실행계획 선택, 데이터 딕셔너리(Data Dictionary)의 **통계정보나 DBMS의 차이로 같은 쿼리도 다른 실행계획이 생성될 수 있음**, 실행계획의 예측 및 제어가 어려움





# 인덱스

검색 조건에 부합하는 데이터를 효과적으로 검색할 수 있도록 돕는 기능, 인덱스키로 정렬되어 있어 조회 속도가 빠름, **DML 작업 효율은 저하함**(UPDATE 작업은 부하가 없을 수도 있음)

- 트리기반 인덱스:

  DBMS에서 사용하는 가장 일반적인 인덱스, 1) 루트 블록(Root Block) 2) 브랜치 블록(Branch Block) 3) 리프 블록(Leaf Block)으로 구성됨

- 클러스터형 인덱스:

  인덱스의 리프 페이지가 데이터를 포함함, 리프 페이지의 모든 로우가 인덱스키 칼럼 순서대로 물리적으로 정렬되어 있음**(IOT와 유사함)**

  - IOT(Index-Organized Table): 

    인덱스키가 붙은 칼럼으로 구성된 테이블, 인덱스가 원래 테이블을 참조하지 않음, 클러스터형 인덱스와 유사함





# NLJoin SMJoin HashJoin

- 조인 방식: NL 조인 > 소트 머지 조인 > 해시 조인 순서로 발전됨

  - NL 조인(Nested Loop Join): 선행 테이블의 데이터 하나씩 순차적으로 조인 (중첩 반복문과 유사함), 선행 테이블 처리 범위가 성능을 결정함 (~ 해시 조인, ↔ 소트 머지 조인은 순서에 무관함), 랜덤 액세스 위주이므로 대용량 데이터 처리 시 불리 **유니크 인덱스를 이용하여 소량 테이블 조인할 때 유리함**

  - 조인 결과를 하나씩 바로 출력하여 OLTP 환경에 적합함

  - 절차

    ①   선행 테이블에서 조건을 만족하는 행을 찾음

    ②   후행 테이블에 선행 테이블의 조인키가 존재하는지 확인함

    ③   후행 테이블 인덱스에 선행 테이블의 조인키가 존재하는지 확인함

    ④   인덱스에서 추출한 ROWID로 후행 테이블을 액세스함

    

- 소트 머지 조인(Sort Merge Join): 두 테이블을 개별적으로 스캔한 후 조인 (↔ NL 조인은 선행 테이블을 랜덤 액세스 방식으로 조회하며 조인), 대용량 데이터 처리 시 디스크에서 정렬이 진행되므로 성능상 불리, **인덱스 유무가 성능에 큰 영향을 주지 않음 (↔ NL 조인은 인덱스 구성에 크게 영향을 받음)**

- 해시 조인(Hash Join): 조인 칼럼을 기준으로 동일한 해시 값을 갖는 데이터의 실제 값을 비교하며 조인, **두 테이블의 데이터 차이가 클 때 유리**, 1) NL 조인의 랜덤 액세스와 2) 소트 머지 조인의 정렬 작업 부담 해결, 등가 조인에서만 사용할 수 있음, 해시 메모리에서 해시 테이블을 생성하므로 선행 테이블이 작을 때 유리 

  

  *테이블이 커서 소트 부하가 심할 때 유리함*

  - **인덱스가 존재하지 않아도 사용가능**
  - OLAP 환경에 적합함
  - **EQUI join(=) 조건에서만 동작**





# 트랜잭션(Transaction)이란?

  - 업무처리를 위한 논리적인 작업 단위



### 트랜잭션의 특징

1. #### 원자성(Atomicity) 

트랜잭션은 더이상 분해가 불가능한 업무의 최소 단위이므로, 전부 처리되거나, 아예 하나도 처리되지 않아야 합니다.



2. #### 일관성(Consistency)

일관된 상태의 데이터베이스에서 하나의 트랜잭션이 성공적으로 작업을 완료하고 난 후에도 데이터베이스는 여전히 일관된 상태여야 합니다.



3. #### 격리성,독립성(Isolation)

하나의 트랜잭션이 작업을 하고 있을 때 다른 트랜잭션은 접근할 수

 없습니다.



- 낮은 단계의 격리성 수준에서 발생할 수 있는 현상

   1) **Dirty Read** : 다른 트랜잭션에 의해 수정되었지만 아직 커밋되지 않은데이터를 읽는 것을 의미.

   2) **Non-Repeatable Read** : 한 트랜잭션 내에서 같은 쿼리를 두 번 수행했는데, 그 사이에 다른 트랜잭션이 값을 수정,삭제하여 두 쿼리의 결과가 다르게 나타나는 현상.

   3) **Phantom Read** : 한 트랜잭션 내에서 같은 쿼리를 두 번 수행했는데, 첫 번째 쿼리에서 없던 유령(Phantom) 레코드가 두 번째 쿼리에서 나타나는 현상.

  

4. #### 영속성(Durability)

트랜잭션이 일단 실행을 성공적으로 완료하면, 그 결과는 데이터베이스에 영속적으로 저장되어야 한다.

=======




# SQL-TIL



### 목차

- 이론
  - [무결성](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#%EB%AC%B4%EA%B2%B0%EC%84%B1)
  - [정규화](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#%EC%A0%95%EA%B7%9C%ED%99%94)
  - [SQL 문장의 종류](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#sql-%EB%AC%B8%EC%9E%A5-%EC%A2%85%EB%A5%98)
  - [식별자의 종류](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#%EC%8B%9D%EB%B3%84%EC%9E%90%EC%9D%98-%EC%A2%85%EB%A5%98)
  - [제약조건](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#%EC%A0%9C%EC%95%BD%EC%A1%B0%EA%B1%B4)
  - 서브쿼리
    - [서브쿼리에 따른 명칭](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#%EC%84%9C%EB%B8%8C%EC%BF%BC%EB%A6%AC%EC%9D%98-%EC%9C%84%EC%B9%98%EC%97%90-%EB%94%B0%EB%A5%B8-%EB%AA%85%EC%B9%AD)
    - [서브쿼리의 반환 값에 따른 서브쿼리 종류](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#%EC%84%9C%EB%B8%8C%EC%BF%BC%EB%A6%AC%EC%9D%98-%EB%B0%98%ED%99%98-%EA%B0%92%EC%97%90-%EB%94%B0%EB%A5%B8-%EC%84%9C%EB%B8%8C%EC%BF%BC%EB%A6%AC-%EC%A2%85%EB%A5%98)
  - [저장 모듈](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#%EC%A0%80%EC%9E%A5-%EB%AA%A8%EB%93%88)
  - [옵티마이저](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#%EC%98%B5%ED%8B%B0%EB%A7%88%EC%9D%B4%EC%A0%80)
  - [순수 관계 연산자](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#%EC%88%9C%EC%88%98-%EA%B4%80%EA%B3%84-%EC%97%B0%EC%82%B0%EC%9E%90)
  - [DB 엔진에 따른 '' NULL처리 여부](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#insert-%EA%B5%AC%EB%AC%B8%EC%97%90%EC%84%9C-%EC%82%BD%EC%9E%85-%EC%8B%9C-null%EC%B2%98%EB%A6%AC)
  - [인덱스](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#%EC%9D%B8%EB%8D%B1%EC%8A%A4)
  - [트랜잭션](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98transaction)



- 문법
  - [CREATE TABLE](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#create-table)
  - [ALTER TABLE](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#create-table)
  - [CHAR / VARCHAR](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#chars-varchars%EC%9D%98-%EC%B0%A8%EC%9D%B4%EC%A0%90)
  - [GROUP BY, HAVING](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#group-by-having%EC%A0%88)
  - [ON DELETE / UPDATE](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#on-deleteupdate)
  - [DELETE / TRUNCATE](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#delete--truncate-table-%EC%B0%A8%EC%9D%B4)
  - [UNION / UNIONALL](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#union--unionall)
  - [JOIN 종류](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#join)
  - [JOIN에서의 (+) 기호](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#leftright-outer-join) 
  - [COALESCE](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#coalesce)
  - [ORACLE 분석함수(RANK)](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#%EC%98%A4%EB%9D%BC%ED%81%B4-%EB%B6%84%EC%84%9D%ED%95%A8%EC%88%98rank-over-row_number-over)
  - [NLJoin / SMJoin / HashJoin](https://github.com/PgmJun/Study_BackEnd/blob/main/SQL/SQL-TIL.md#nljoin-smjoin-hashjoin)

---





<h1>무결성</h1>

무결성 제약조건의 주요 목적은 데이터베이스에 저장된 데이터의 무결성을 보장하고 데이터베이스의 상태를 일관되게 유지하는 것입니다. 그래서 이를 위해 필요한 세부 규칙도 정의하고 있습니다. 데이트베이스가 삽입, 삭제, 수정, 연산으로 상태가 변하더라도 무결성 제약조건은 반드시 지켜져야 합니다.

무결성 제약조건의 종류와 개념
1. 개체 무결성 : 기본키는 null 값이 될 수 없음 <br>
개체 무결성 제약조건은 기본키를 구성하는 모든 속성은 널 값을 가지면 안된다는 규칙입니다. 관계 데이터 모델에서는 릴레이션에 포함되는 튜플들을 유일하게 구별해주고 각 튜플에 쉽게 접근할 수 있도록 릴레이션마다 기본키를 정의하는 기본키를 구성하는 속성 전체나 일부가 널 값이 되면 튜플의 유일성을 판단할 수 없기 때문에 본래의 목적을 상실하게 됩니다. 

 

2. 참조 무결성 : 외래키는 참조할 수 없는 값을 가질 수 없음 <br>
참조 무결성 제약조건은 외래키는 참조할 수 없는 값을 가질 수 없다는 규칙입니다. 외래키는 다른 릴레이션의 기본키를 참조하는 속성이고 릴레이션 간의 관계를 표현하는 역할을 합니다. 그런데 외래키가 자신이 참조하는 릴레이션의 기본키와 상관없는 값을 가지게 되면 두 릴레이션을 연관시킬 수 없으므로 외래키 본래의 의미가 없어집니다.

 

3. 도메인 무결성 : 특정 속성값은 그 속성이 정의된 도메인에 속한 값이어야 함 <br>
도메인 무결성은 데이터 베이스에 삽입되는 데이터들에 제약조건을 의미합니다. 각각의 속성은 숫자, 문자 등의 도메인을 가지면 해당 도메인에 맞는 데이터를 삽입해야 합니다. 그 뿐만 아니라 삽입되는 데이터를 제한하거나, 삽입되지 않을 경우 기본값, null 제한 등의 기능을 제공합니다. 예를 들어 "성"에 대한 속성의 경우 입력되는 데이터를 "남", "여"로 제한하여 그 외의 데이터가 삽입되는 경우를 제한할 수 있습니다. 

 

4. 키 무결성 : 릴레이션에는 최소한 하나의 키가 존재해야 함


5. null 무결성 : 특정 속성은 null 값을 가질 수 없음 <br>
null 무결성은 특정 속성값에는 null 값을 가질 수 없다는 규칙입니다. 기본적으로 속성값으로 null 값을 가질 수 있는데 만약 "유저 아이디"처럼 중요한 정보에는 스키마를 정의할 때 해당 속성을 null 데이터가 올 수 없음을 미리 정의할 수 있습니다. 

 

6. 고유 무결성 : 특정 속성값은 서로 달라야 함 <br>
고유 무결성은 특정 속성에 삽입되는 데이터는 고유한 값을 가져야 한다는 규칙입니다. 이말은 즉, 각 튜플에서 하나의 속성값은 중복된 값이 없는 각각 서로 다른 값을 가져야 한다는 의미입니다. 예를 들어 이름, 나이, 사는 곳과 같은 속성은 튜프들이 서로 같은 값을 가질 수 있지만 고객 아이디의 경우 각 튜플을 서로 다른 값을 가져야 합니다. 






<h1>정규화</h1>

- 1차 정규화:<br>
같은 성격과 내용의 컬럼이 연속적으로 나타나는 컬럼이 존재할 때, 해당 컬럼을 제거하고 기본테이블의 PK를 추가해 새로운 테이블을 생성하고, 기존의 테이블과 1:N의 관계 형성
- 2차 정규화:<br>
PK가 여러 키로 구성된 복합키(Composite Primary Key)로 구성된 경우가 2차 정규화의 대상이 되며, 복합키 전체에 의존하지 않고 복합키의 일부분에만 종속되는 속성들이 존재할 경우 (즉, 부분적 함수 종속 관계) 이를 분리하는 것이다.
- 3차 정규화<br>
테이블의 키가 아닌 컬럼들은 기본키에 의존해야 하는데 겉으로는 그런 것처럼 보이지만 실제로는 기본키가 아닌 다른 일반 컬럼에 의존하는 컬럼들이 있을 수 있다. 이를 (이전적 함수 종속 관계)라고 한다. 제 3정규화는 PK에 의존하지 않고 일반컬럼에 의존하는 컬럼들을 분리한다.





<h1>SQL 문장 종류</h1>

- DDL(Data Definition Language) 데이터 정의어:<br>
CREATE, DROP, ALTER, RENAME / 테이블 관련 설정

- DML(Data Manipulation Language) 데이터 조작어:<br>
SELECT, INSERT, UPDATE, DELETE / 데이터 관련 설정

- DCL(Data Control Language) 데이터 제어어:<br>
REVOKE, GRANT

- TCL(Transaction Control Language) 트렌젝션 제어어:<br>
COMMIT, ROLLBACK





<h1>식별자의 종류</h1>

- 대표성 여부:<br>
-주식별자: 엔터티 내에서 각 어커런스를 구분할 수 있는 구분자이며, 타 엔터티와 참조관계를 연결할 수 있는 식별자<br>
-보조식별자: 엔터티 내에서 각 어커런스를 구분할 수 있는 구분자이나 대표성을 가지지 못해 참조관계 연결을 못함

- 스스로 생성 여부:<br>
-내부식별자: 엔터티 내부에서 스스로 만들어지는 식별자<br>
-외부식별자: 타 엔터티와의 관계를 통해 타 엔터티로부터 받아오는 식별자

- 속성의 수:<br>
-단일식별자: 하나의 속성으로 구성된 식별자<br>
-복합식별자: 둘 이상의 속성으로 구성된 식별자


- 대체 여부:<br>
-본질식별자: 업무에 의해 만들어지는 식별자<br>
-인조식별자: 업무적으로 만들어지지는 않지만 원조식별자가 복잡한 구성을 가지고 있기 때문에 인위적으로 만든 





<h1>CREATE TABLE</h1>

- 문장 작성법: CREATE TABLE 테이블이름 ( 속성 자료형 설정, ... ); <br>

- 칼럼, 테이블명은 "반드시" 문자로 시작<br>

- A-Z, a-z, 0-9, _, $, # 만 사용가능<br>

- 테이블명, 칼럼명 중복X 





<h1>제약조건</h1>

- Primary key(기본키): 중복X(고유함), NOT NULL
- Unique key(고유키): 중복X(고유함)
- NOT NULL: NULL 금지
- CHECK: 입력 값 범위 제한<br>
사용법EX) CREATE TABLE EXAM(A INT CHECK(A IN(1,2,3))); || SELECT * FROM EXAM WHERE AGE IN(22,23);





<h1>테이블 구조변경(DDL)</h1>

- 컬럼 추가:<br>
ALTER TABLE 테이블명 ADD 컬럼명 자료형;
- 컬럼 제거:<br>
ALTER TABLE 테이블명 DROP COLUMN 컬럼명;
- 컬럼 데이터 유형 조건 등 변경:<br>
ORACLE) ALTER TABLE 테이블명 MODIFY(컬럼명 데이터 유형 DEFAULT식 NOT NULL);<br>
SQL SERVER) ALTER TABLE 테이블명 ALTER(컬럼명 데이터 유형 DEFAULT식 NOT NULL);<br>
- 컬럼명 변경:<br>
ALTER TABLE 테이블명 RENAME COLUMN 컬럼명 TO 뉴컬럼명<br>
- 제약조건 삭제:<br>
ALTER TABLE 테이블명 DROP CONSTRAINT 조건명;





<h1>CHAR(s), VARCHAR(s)의 차이점</h1>

- CHAR(s): 고정길이<br>
ex) CHAR(3) 'aa' = 'aa '<br>

- VARCHAR(s): 가변길이<br>
ex) VARCHAR(3) 'aa' != 'aa '<br>





<h1>GROUP BY, HAVING절</h1>

- GROUP BY: SELECT [GROUP BY로 묶일 칼럼] [GROUP BY로 묶여 집계할 값] FROM 테이블명 GROUP BY [그룹으로 묶을 칼럼]

- HAVING: SELECT [GROUP BY로 묶일 칼럼] [GROUP BY로 묶여 집계할 값] FROM 테이블명 GROUP BY [그룹으로 묶을 칼럼] HAVING [GROUP BY로 묶여 집계된 값에 조건추가]

- ex) SELECT 학급반, SUM(점수) FROM 학생 GROUP BY 학급반 HAVING SUM(점수) > 150;

  = 학생테이블에서 학급반을 GROUP BY로 묶고 반별로 학생들 점수의 합을 150점 이상인 반만 출력



*GROUP BYY절에는 ALIAS사용 불가 

*집계함수는 WHERE절에 올 수 없으므로 HAVING절에 조건을 추가 





<h1>ORDER BY절</h1>

- SQL문으로 조회된 데이터를 다양한 목적에 맞게 특정 칼럼을 기준으로 정렬<br>
- ALIAS사용가능<br>
- DEFAULT값은 ASC(오름차순)<br>
- SQL구문 제일 마지막에 위치<br>
- 사용법: SELECT * FROM 테이블이름 ORDER BY 점수 DESC;<br>





<h1>ON DELETE/UPDATE</h1>

#on DELETE SET NULL
#on UPDATE SET NULL

- 옵션 SET NULL -> 부모테이블에서 primary 값이 수정 또는 삭제될 경우<br> 하위테이블의 reference값은 존재할 수 없습니다. 옵션이 없을 경우는 에러가 발생하고 옵션 SET NULL 로 정의되면 하위테이블의 reference값이  NULL 값으로 변경되면서 참조무결성을 유지합니다.

#on UPDATE CASCADE
- 옵션 CASCADE -> 부모테이블에서 primary 값이 수정될 경우<br> 옵션 CASCADE 로 정의되면 하위테이블의 reference값은 변경된 상위테이블의 수정된 값을 가지면서 참조무결성을 유지합니다.

#on DELETE CASCADE
- 옵션 CASCADE ->부모테이블에서 primary 값이 삭제될 경우<br>옵션 CASCADE 로 정의되면 하위테이블의 reference값은 삭제되면서 참조무결성을 유지합니다.<br>

사용예시:<br>
FOREIGN KEY(A) REFERENCES B(C) ON DELETE CASCADE





<h1>DELETE / TRUNCATE TABLE 차이</h1>
- DELETE: DELETE 문은 행을 한번에 하나씩 제거하고 삭제된 각 행에 대해 트랜잭션 로그에 항목을 기록<br>
- TRUNCATE TABLE: 테이블의 데이터를 저장하는 데 사용되는 데이터 페이지의 할당을 취소하는 방식으로 데이터를 제거하며 페이지 할당 취소만을 트랜잭션 로그에 기록





<h1>UNION / UNIONALL</h1>
- Union과 UnionAll은 두 쿼리문을 하나로 합쳐준다.<br>
-출력: Union) 중복값 제거해서 결과출력 / UnionAll) 중복된 값도 전부 다 출력<br>
-속도: UnionAll > Union (UNION은 중복값제거를 위해 연산을 한번 더 해야하기때문)<br>
-사용법: 쿼리문1 Union/UnionAll 쿼리문2
-주의점: 칼럼명이 서로 같아야 함(다르면 AS사용해서 같게 해줄 수 있음)





<h1>INSERT 구문에서 ''삽입 시 NULL처리</h1>
ORACLE: '' -> NULL
SQL SERVER: '' -> ''





<h1>JOIN</h1>
- JOIN은 관계형 데이터 베이스에서 쪼개져 있는 데이터들을 관련있는 컬럼을 기준으로 행을 합쳐주는 연산자다.<br>
<h3>JOIN의 종류</h3>
- 내부 조인 (INNER JOIN)<br>
- 교차 조인 (CROSS JOIN  <-> <strong>CARTESIAN JOIN</strong>)<br>
- 등가/동등/동일 조인(EQUI JOIN)<br>
- 비등가 조인(NON-EQUI JOIN)<br>
- 자연 조인 (NATURAL JOIN)<br>
- 외부 조인 (OUTER JOIN)<br>
- 완전 외부 조인 (FULL OUTER JOIN)<br>
- 왼쪽 (LEFT OUTER JOIN)<br>
- 오른쪽 (RIGHT OUTER JOIN)<br>
- 셀프 조인 (SELF JOIN)<br>
- 안티 조인 (ANTI JOIN)<br>
- 세미 조인 (SEMI JOIN)<br>

![httpsdsin.wordpress.com20130316sql-join-cheat-sheet](C:\Users\chltm\OneDrive\바탕 화면\httpsdsin.wordpress.com20130316sql-join-cheat-sheet.png)

[출처](httpsdsin.wordpress.com20130316sql-join-cheat-sheet)





<h1>LEFT/RIGHT OUTER JOIN</h1>
- 조인조건에 성립하는 부분과 지정해준 LEFT/RIGHT의 기준이 되는 테이블의 로우를 출력해주는 JOIN이다<br>
기준이 되는 반대쪽에 (+)를 표시하면 OUTER JOIN을 나타낼 수 있다.<br>
ex) SELECT A.게시판ID,  A.게시판명, COUNT(B.게시글ID) AS CNT<br>
FROM 게시판 A, 게시글 B<br>
WHERE A.게시판ID = B.게시판ID(+)<br>
->  "FROM 게시판 LEFT OUTER JOIN 게시글" 로 처리한 것과 같음





<h1>서브쿼리의 위치에 따른 명칭</h1>
- SELECT문에 있는 서브쿼리: 스칼라 서브쿼리<br>
 -스칼라 서브쿼리는 1행만 반환<br>
- FROM절에 있는 서브쿼리: 인라인 뷰<br>
- WHERE절에 있는 서브쿼리: 서브쿼리





<h1>서브쿼리의 반환 값에 따른 서브쿼리 종류</h1>
- 단일 행 서브쿼리: 서브쿼리 결과가 1행 [비교연산자: =, <, >, <=, >=, <>]<br>
- 다중 행 서브쿼리: 서브쿼리 결과가 여러행 [비교연산자: IN, ALL, ANY, SOME, EXISTS]<br>
- 다중 컬럼 서브쿼리: 서브쿼리 결과가 여러 컬럼





# COALESCE

- 처음으로 NULL값이 아닌 값을 발견하면 그 값을 반환  
- ex) SELECT COALESCE (컬럼1, 컬럼2, ... , 컬럼N) FROM 테이블  
여기서 처음으로 NULL이 아닌 컬럼을 결과값으로 리턴한다.  





# 오라클 분석함수(RANK OVER(), ROW_NUMBER() OVER())

- RANK OVER(): 동일 순위인 경우 1,1,3 형식으로 출력
- ROW_NUMBER OVER(): 동일 순위인 경우 1,2,3 형식으로 출력
- DENSE_RANK(): 동일 순위인 경우 1,1,2 형식으로 출력





# 순수 관계 연산자

- SELECT
- PROJECT
- JOIN
- DIVIDE





# 저장 모듈

- SQL문을 데이터 베이스 서버에 저장하여 사용자와 애플리케이션 사이에서 공유할 수 있도록 만든

  일종의 SQL 컴포넌트 프로그램

- 독립적으로 실행되거나 다른 프로그램으로부터 실행될 수 있는 완전한 실행 프로그램

- Oracle의 저장모듈
  - 프로시져(Procedure)
  - User Defined Fuction
  - 트리거(Trigger)





# 옵티마이저

- 규칙기반 옵티마이저:

  우선순위 규칙에 따라 실행계획 생성, 인덱스가 있으면 반드시 인덱스 사용

- 비용기반 옵티마이저:

  처리 비용이 가장 적은 실행계획 선택, 데이터 딕셔너리(Data Dictionary)의 **통계정보나 DBMS의 차이로 같은 쿼리도 다른 실행계획이 생성될 수 있음**, 실행계획의 예측 및 제어가 어려움





# 인덱스

검색 조건에 부합하는 데이터를 효과적으로 검색할 수 있도록 돕는 기능, 인덱스키로 정렬되어 있어 조회 속도가 빠름, **DML 작업 효율은 저하함**(UPDATE 작업은 부하가 없을 수도 있음)

- 트리기반 인덱스:

  DBMS에서 사용하는 가장 일반적인 인덱스, 1) 루트 블록(Root Block) 2) 브랜치 블록(Branch Block) 3) 리프 블록(Leaf Block)으로 구성됨

- 클러스터형 인덱스:

  인덱스의 리프 페이지가 데이터를 포함함, 리프 페이지의 모든 로우가 인덱스키 칼럼 순서대로 물리적으로 정렬되어 있음**(IOT와 유사함)**

  - IOT(Index-Organized Table): 

    인덱스키가 붙은 칼럼으로 구성된 테이블, 인덱스가 원래 테이블을 참조하지 않음, 클러스터형 인덱스와 유사함





# NLJoin SMJoin HashJoin

- 조인 방식: NL 조인 > 소트 머지 조인 > 해시 조인 순서로 발전됨

  - NL 조인(Nested Loop Join): 선행 테이블의 데이터 하나씩 순차적으로 조인 (중첩 반복문과 유사함), 선행 테이블 처리 범위가 성능을 결정함 (~ 해시 조인, ↔ 소트 머지 조인은 순서에 무관함), 랜덤 액세스 위주이므로 대용량 데이터 처리 시 불리 **유니크 인덱스를 이용하여 소량 테이블 조인할 때 유리함**

  - 조인 결과를 하나씩 바로 출력하여 OLTP 환경에 적합함

  - 절차

    ①   선행 테이블에서 조건을 만족하는 행을 찾음

    ②   후행 테이블에 선행 테이블의 조인키가 존재하는지 확인함

    ③   후행 테이블 인덱스에 선행 테이블의 조인키가 존재하는지 확인함

    ④   인덱스에서 추출한 ROWID로 후행 테이블을 액세스함

    

- 소트 머지 조인(Sort Merge Join): 두 테이블을 개별적으로 스캔한 후 조인 (↔ NL 조인은 선행 테이블을 랜덤 액세스 방식으로 조회하며 조인), 대용량 데이터 처리 시 디스크에서 정렬이 진행되므로 성능상 불리, **인덱스 유무가 성능에 큰 영향을 주지 않음 (↔ NL 조인은 인덱스 구성에 크게 영향을 받음)**

- 해시 조인(Hash Join): 조인 칼럼을 기준으로 동일한 해시 값을 갖는 데이터의 실제 값을 비교하며 조인, **두 테이블의 데이터 차이가 클 때 유리**, 1) NL 조인의 랜덤 액세스와 2) 소트 머지 조인의 정렬 작업 부담 해결, 등가 조인에서만 사용할 수 있음, 해시 메모리에서 해시 테이블을 생성하므로 선행 테이블이 작을 때 유리 

  

  *테이블이 커서 소트 부하가 심할 때 유리함*

  - **인덱스가 존재하지 않아도 사용가능**
  - OLAP 환경에 적합함
  - **EQUI join(=) 조건에서만 동작**

<<<<<<< HEAD
=======
# 트랜잭션(Transaction)

  - 트랜잭션은 업무처리를 위한 논리적인 작업 단위를 말합니다.
>>>>>>> 17284bea7907b49eb11dbb0de8d5003cd1839dc8




# 트랜잭션(Transaction)이란?

  - 업무처리를 위한 논리적인 작업 단위



### 트랜잭션의 특징

1. #### 원자성(Atomicity) 

트랜잭션은 더이상 분해가 불가능한 업무의 최소 단위이므로, 전부 처리되거나, 아예 하나도 처리되지 않아야 합니다.



2. #### 일관성(Consistency)

일관된 상태의 데이터베이스에서 하나의 트랜잭션이 성공적으로 작업을 완료하고 난 후에도 데이터베이스는 여전히 일관된 상태여야 합니다.



3. #### 격리성,독립성(Isolation)

하나의 트랜잭션이 작업을 하고 있을 때 다른 트랜잭션은 접근할 수

 없습니다.



- 낮은 단계의 격리성 수준에서 발생할 수 있는 현상

   1) **Dirty Read** : 다른 트랜잭션에 의해 수정되었지만 아직 커밋되지 않은데이터를 읽는 것을 의미.

   2) **Non-Repeatable Read** : 한 트랜잭션 내에서 같은 쿼리를 두 번 수행했는데, 그 사이에 다른 트랜잭션이 값을 수정,삭제하여 두 쿼리의 결과가 다르게 나타나는 현상.

   3) **Phantom Read** : 한 트랜잭션 내에서 같은 쿼리를 두 번 수행했는데, 첫 번째 쿼리에서 없던 유령(Phantom) 레코드가 두 번째 쿼리에서 나타나는 현상.

  

4. #### 영속성(Durability)

트랜잭션이 일단 실행을 성공적으로 완료하면, 그 결과는 데이터베이스에 영속적으로 저장되어야 한다.
