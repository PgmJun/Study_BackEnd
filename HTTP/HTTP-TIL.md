# HTTP-TIL

---
# #IP(Internet Protocol)
- 지정한 IP주소에 데이터 전달    
- 패킷이라는 통신 단위로 데이터 전달  
- IP 패킷 정보: 출발지IP, 목적지IP, etc...를 포함한 전송데이터   
- 원리: 클라이언트에서 목적지IP(서버)로 전송데이터를 전달하고 패킷에서 출발지IP를 확인한 서버는 다시 그 IP주소로 응답을 보냄   

## IP프로토콜의 한계

- 비연결성: 패킷을 받을 대상이 없거나 서비스 불능 상태여도 패킷 전송   
- 비신뢰성: 중간에 패킷이 사라진다면? / 패킷이 순서대로 안오면?  
- 프로그램 구분: 같은 IP를 사용하는 서버에서 통신하는 애플리케이션이 둘 이상이면  

---

# #인터넷 프로토콜의 4계층

- 애플리케이션 계층(HTTP, FTP)<br>
- 전송 계층(TCP, UDP)<br>
- 인터넷 계층(IP)<br>
- 네트워크 인터페이스 계층<br>


---

# #TCP(Transmission Control Protocol)

- IP 패킷 정보: 출발지IP, 목적지IP, etc...를 포함한 전송데이터<br>
- TCP/IP 패킷 정보: 출발지IP, 목적지IP, etc... + 출발지PORT, 목적지PORT, 전송제어, 순서, 검증 정보 etc..를 포함한 전송데이터<br>

<h2>TCP 특징</h2>
- 연결지향 - TCP 3 way handshake (가상 연결)<br>
- 데이터 전달 보증<br>
- 순서 보장<br>
- 신뢰할 수 있는 프로토콜 / 현재는 대부분 TCP사용<br>

<h2>TCP 3 way handshake</h2>
1. 클라이언트 -> 서버: SYN<br>

2. 서버 -> 클라이언트: SYN + ACK<br>

3. 클라이언트 -> 서버: ACK<br>



- SYN: 접속 요청  
- ACK: 요청 수락  

---

# #UDP(User Datagram Protocol)

<h2>UDP 특징</h2>
- 하얀 도화지에 비유(기능이 거의 없음:PORT기능이 끝)<br>
- 연결지향 - TCP 3way handshake X<br>
- 데이터 전달 보증 X<br>
- 순서 보장 X<br>
- 데이터 전달 및 순서가 보장되진 않지만, 단순하고 빠름<br>
- 정리: IP와 거의 같다 + PORT -> 애플리케이션에서 추가 작업 필요<br>

---

# #PORT

한 IP로 한번에 둘 이상 연결해야 한다면? -> PORT가 이 문제를 해결<br>

- 0~65535할당 가능<br>
- 0~1023: 잘 알려진 포트, 사용하지 않는 것이 좋음<br>
- FTP:20,21 / TELNET:23 / HTTP:80 / HTTPS:443<br>

<h2>PORT의 역할</h2>
- 같은 IP내에서 프로세스 구분<br>
- 게임=PORT9080 / 화상통화=PORT21000 / 웹브라우저=PORT10010  

---

# #DNS(Domain Name System)

IP주소는 기억하기 어렵다 / IP주소는 변경 될 수 있다 -> 이를 해결해 주는 것이 DNS  

- 전화번호부에 비유  
- 도메인 명을 IP주소로 변환시켜줌  

<h2>DNS 원리</h2>
1. 클라이언트에서 도메인 명 입력
2. 도메인의 실제 IP주소를 반환받음
3. 서버로 IP주소 전달해서 응답받음

---

# #URI(Uniform Resource Identifier)

URI = URL(Locator) + URN(Name)  

<h2>문법</h2>
- scheme://[userinfo@]host[:port][/path][?query][#fragment]]<br>
- https://www.google.com:443/search?q=hello&hl=ko

<br>

- 프로토콜(https)
- 호스트명(www.google.com)
- 포트 번호(443)
- 패스(/search)
- 쿼리 파라미터(q=hello&hl=ko)

---
# #HTTP의 특징

- 클라이언트/서버 구조<br>
- 무상태 프로토콜(StateLess), 비연결성<br>
- HTTP 메시지<br>
- 단순함 확장 가능  

<hr>

<h2>클라이언트 서버 구조</h2>
- Request / Response 구조<br>
- 클라리언트는 서버에 요청을 보내고, 응답을 대기<br>
- 서버가 요청에 대한 결과를 만들어서 응답<br>

<hr>

<h2>무상태 프로토콜(Stateless)</h2>
- 서버가 클라이언트의 상태를 보존X<br>
- 장점: 서버 확장성 높음(스케일 아웃)<br>
- 단점: 클라리언트가 추가 데이터 전송<br>

<h3>Stateful, Stateless 차이</h3>
상태 유지 - Stateful<br>
• 고객: 이 **노트북** 얼마인가요?<br>
• 점원: 100만원 입니다. **(노트북 상태 유지)**<br>
• 고객: 2개 구매하겠습니다.<br>
• 점원: 200만원 입니다. 신용카드, 현금중에 어떤 걸로 구매 하시겠어요?**(노트북, 2개 상태 유지)**<br>
• 고객: 신용카드로 구매하겠습니다.<br>
• 점원: 200만원 결제 완료되었습니다. **(노트북, 2개, 신용카드 상태 유지)** <br>

<br>무상태 - Stateless<br>
• 고객: 이 <strong>노트북</strong> 얼마인가요?<br>
• 점원: 100만원 입니다.<br>
• 고객: 노트북 **2개** 구매하겠습니다.<br>• 점원: 노트북 2개는 200만원 입니다. **신용카드, 현금중**에 어떤 걸로 구매 하시겠어요?<br>
• 고객: **노트북 2개를 신용카드**로 구매하겠습니다.<br>
• 점원: 200만원 결제 완료되었습니다<br>
<br>

- 상태 유지: 중간에 다른 점원으로 바뀌면 안된다.(점원 변경시 상태정보를 다른 점원에게 미리 넘겨줘야 한다.)<br>
=> 항상 같은 서버가 유지되어야 한다<br>
- 무상태: 중간에 다른 점원으로 바뀌어도 된다.<br>
"갑자기 고객이 증가해도 점원을 대거 투입할 수 있다" => 갑자기 클라이언트 요청이 증가해도 서버를 대거 투입할 수 있다.<br>
무상태는 응답 서버를 쉽게 바꿀 수 있다. => **무한한 서버 증설 가능**

<hr>

<h3>Stateless의 실무 한계</h3>
• 모든 것을 무상태로 설계 할 수 있는 경우도 있고 없는 경우도 있다. <br> 
- 무상태로 설계 가능 -> 로그인이 필요없는 단순한 서비스 소개 화면  <br>
- 상태유지로 설계 해야하는 것 -> 로그인(로그인한 사용자의 경우 로그인 했다는 상태를 서버에 유지) <br>
• 일반적으로 브라우저 쿠키와 서버 세션등을 사용해서 상태유지 <br>
• 상태유지는 최소한만 사용 <br>

<hr>

<h2>비연결성(connectionless)</h2>
- HTTP는 기본이 연결을 유지하지 않는 모델<br>
- 일반적으로 초 단위의 이하의 빠른 속도로 응답<br>
- 1시간 동안 수천명이 서비스를 사용해도 실제 서버에서 동시에 처리하는 요청은 수십개 이하로 매우 작음<br>

ex) 웹 브라우저에서 계속 연속해서 검색 버튼을 누르지는 않는다.<br>
• 서버 자원을 매우 효율적으로 사용할 수 있음<br>

<h3>비 연결성의 한계와 극복</h3>


- 한계<br>

-TCP/IP 연결을 새로 맺어야 함 - 3 way handshake 시간 추가<br>

-웹 브라우저로 사이트를 요청하면 HTML 뿐만 아니라 자바스크립트, css, 추가 이미지 등 수 많은 자원이 함께 다운로드<br>

<br>

- 극복<br>

-지금은 HTTP 지속 연결(Persistent Connections)로 문제 해결<br>

-HTTP/2, HTTP/3에서 더 많은 최적화<br>

<hr>

<h2>HTTP 메시지</h2>
모든 것을 HTTP로 전달하는 시대<br>
• HTML, TEXT<br>
• IMAGE, 음성, 영상, 파일<br>
• JSON, XML<br>
• 거의 모든 형태의 데이터 전송 가능<br>
• 서버간에 데이터를 주고 받을 떄도 대부분 HTTP사용<br>  

<h3>HTTP 메시지 구조</h3>


- start-line 시작라인  

- header 헤더  

- empty line 공백라인(CRLF)  

- message body  
  • 공식 스펙:   

  ```
  HTTP-message = start-line  
   *( header-field CRLF )  
   CRLF  
   [ message-body ]   
  ```

  


---
# #HTTP 메서드

### 주요 메서드

• GET: 리소스 조회  
• POST: 요청 데이터 처리, 주로 등록에 사용  
• PUT: 리소스를 대체, 해당 리소스가 없으면 생성  
• PATCH: 리소스 부분 변경  
• DELETE: 리소스 삭제  

### 기타 메서드

• HEAD: GET과 동일하지만 메시지 부분을 제외하고, 상태 줄과 헤더만 반환  
• OPTIONS: 대상 리소스에 대한 통신 가능 옵션(메서드)을 설명(주로 CORS에서 사용)  
• CONNECT: 대상 자원으로 식별되는 서버에 대한 터널을 설정  
• TRACE: 대상 리소스에 대한 경로를 따라 메시지 루프백 테스트를 수행  

## GET

ex)

```
GET /search?q=hello&hl=ko HTTP/1.1 
Host: www.google.com • 리소스 조회  
• 서버에 전달하고 싶은 데이터는 query(쿼리 파라미터, 쿼리 스트링)를 통해서 전달  
• 메시지 바디를 사용해서 데이터를 전달할 수 있지만, 지원하지 않는 곳이 많아서 권장하지 않음  
```

### GET - 리소스 조회

1. 메시지 전달:  

```
GET /members/100 HTTP/1.1  
Host: localhost:8080  
```


2. 서버 도착:  

```
members/100
{
"username": "young", 
"age": 20
}
```



3. 응답 데이터 전송 및 도착:  

```
HTTP/1.1 200 OK  
Content-Type: application/json  
Content-Length: 34  
{  
 "username": "young",  
 "age": 20  
}  
```
## POST

ex)

```
POST /members HTTP/1.1
Content-Type: application/json
{
 "username": "hello",
 "age": 20
}
```

-  요청 데이터 처리  
- 메시지 바디를 통해 서버로 요청 데이터 전달  
- 서버는 요청 데이터를 처리  
- 메시지 바디를 통해 들어온 데이터를 처리하는 모든 기능을 수행한다.  
- 주로 전달된 데이터로 신규 리소스 등록, 프로세스 처리에 사용  



### POST - 리소스 등록

1. 메시지 전달  (클라이언트 -> 서버)

```
POST /members HTTP/1.1
Content-Type: application/json
{
 "username": "young",
 "age": 20
}
```



2. 신규 리소스 생성 (서버)

   99개의 데이터가 있던 /members URI에 members/100 생성

```
{
 "username": "young",
 "age": 20
}
```



3. 응답 데이터 (서버 -> 클라이언트)

**HTTP 201 Created** 는 요청이 성공적으로 처리되었으며, 자원이 생성되었음을 나타내는 성공 상태 응답 코드입니다.

```
HTTP/1.1 201 Created
Content-Type: application/json
Content-Length: 34
Location: /members/100
{
 "username": "young",
 "age": 20
}
```



### POST - 기능의 사용 예시

• HTML 양식에 입력 된 필드와 같은 데이터 블록을 데이터 처리 프로세스에 제공  

ex) HTML FORM에 입력한 정보로 회원 가입, 주문 등에서 사용  

<br>

• 게시판, 뉴스 그룹, 메일링 리스트, 블로그 또는 유사한 기사 그룹에 메시지 게시  

ex) 게시판 글쓰기, 댓글 달기  

<br>

• 서버가 아직 식별하지 않은 새 리소스 생성  

ex) 신규 주문 생성  

<br>

• 기존 자원에 데이터 추가  

ex) 한 문서 끝에 내용 추가하기  



## PUT

ex)

```
PUT /members/100 HTTP/1.1
Content-Type: application/json
{
 "username": "hello",
 "age": 20
}
```

- 리소스를 대체  
  • 리소스가 있으면 대체  
  • 리소스가 없으면 생성  
  • 쉽게 이야기해서 덮어버림  

- 중요! 클라이언트가 리소스를 식별  
  • 클라이언트가 리소스 위치를 알고 URI 지정  
  • POST와 차이점  



### PUT - 리소스가 있는 경우

1. /members/100이 이미 있는 서버에 /members/100 URI로 데이터 PUT  

• 클라이언트

```
PUT /members/100 HTTP/1.1
Content-Type: application/json
{
 "username": "old",
 "age": 50
}
```

• 서버(/members/100)

```
{
 "username": "young",
 "age": 20
}
```



2. 리소스 대체

• 서버(/members/100)

```
{
 "username": "old",
 "age": 50
}
```



### PUT - 리소스가 없는 경우

1. /members/100이 아직 없는 서버에 /members/100 URI로 데이터 PUT  

```
PUT /members/100 HTTP/1.1
Content-Type: application/json
{
 "username": "old",
 "age": 50
}
```



2. 신규 리소스 생성  

• 서버(/members/100)  

```

 "username": "old",
 "age": 50
}
```



### PUT - 주의점: 리소스를 완전히 대체한다

1. username 필드가 없는 데이터를 username,age필드를 가지고 있는 데이터에 PUT한다  

• 클라이언트  

```
PUT /members/100 HTTP/1.1
Content-Type: application/json
{
 "age": 50
}
```

• 서버  

```
{
 "username": "young",
 "age": 20
}
```



2. username 필드가 삭제된 상태로 리소스 대체  

• 서버  

```
{
 "age": 50,
}
```





## PATCH

ex)

```
PATCH /members/100 HTTP/1.1
Content-Type: application/json 
{
 "age": 50 
}
```

- 리소스 부분 변경  



1. username 필드가 없는 데이터를 username,age필드를 가지고 있는 데이터에 PATCH한다

• 클라이언트  

```
PATCH /members/100 HTTP/1.1
Content-Type: application/json
{
 "age": 50
}
```

• 서버(/members/100)  

```
{
 "username": "young",
 "age": 20
}
```



2. 리소스에서 age부분만 부분 변경된다

• 서버(/members/100)  

```
{
 "username": "young",
 "age": 50
}
```



## DELETE

ex)

```
DELETE /members/100 HTTP/1.1
Host: localhost:8080
```

- 리소스 제거



1. 클라이언트에서 제거할 내용을 HTTP로 서버에 전송

 • 클라이언트

```
DELETE /members/100 HTTP/1.1
Host: localhost:8080
```

• 서버(/members/100)  

```
{
 "username": "young",
 "age": 20
}
```



2. /members/100 리소스 제거



--------------------------------------------------------------------
# #HTTP 메서드의 속성

- 안전(Safe Methods)
- 멱등(Idempotent Methods)
- 캐시가능(Cacheable Methods)



## 안전(Safe Methods)

- 호출해도 리소스를 변경하지 않는다.  
- Q: 그래도 계속 호출해서, 로그 같은게 쌓여서 장애가 발생하면요?  
- A: 안전은 해당 리소스만 고려한다. 그런 부분까지 고려하지 않는다.  



## 멱등(Idempotent Methods)

- f(f(x)) = f(x)  
- 한 번 호출하든 두 번 호출하든 100번 호출하든 결과가 똑같다.  
- 멱등 메서드  

1. GET: 한 번 조회하든, 두 번 조회하든 같은 결과가 조회된다  
2. PUT: 결과를 대체한다. 따라서 같은 요청을 여러번 해도 최종 결과는 같다(데이터 추가가 아니라 대체라서 멱등 성립)  
3. DELETE: 결과를 삭제한다. 같은 요청을 여러번 해도 삭제된 결과는 똑같다  
4. POST: 멱등이 아니다! 두 번 호출하면 같은 결제가 중복해서 발생할 수 있다.(주문과 같은 데이터를 계속 추가시키는 메서드이기 때문)  



## 캐시가능(Cacheable Methods)

- 응답 결과 리소스를 캐시해서 사용해도 되는가?  
- GET, HEAD, POST, PATCH 캐시가능  
- 실제로는 GET, HEAD 정도만 캐시로 사용  
- POST, PATCH는 본문 내용까지 캐시 키로 고려해야 하는데, 구현이 쉽지 않음  

--------------------------------------------------------------------
# #클라이언트에서 서버로 데이터 전송

- 쿼리 파라미터를 통한 데이터 전송  
  - GET  
  - 주로 정렬 필터(검색어)  
- 메시지 바디를 통한 데이터 전송  
  - PUT, POST, PATCH  
  - 회원 가입, 상품 주문, 리소스 등록, 리소스 변경  



## 데이터 전송의 4가지 상황

- 정적 데이터 조회:   
  - 이미지, 정적 텍스트 문서  
- 동적 데이터 조회:  
  - 주로 검색, 게시판 목록에서 정렬 필터(검색어)  
- HTML Form을 통한 데이터 전송  
  - 회원가입, 상품주문, 데이터 변경  
- HTTP API를 통한 데이터 전송  
  - 회원 가입, 상품 주문, 데이터 변경  
  - 서버 to 서버, 앱 클라이언트, 웹 클라이언트(Ajax)  



<br>



###  정적 데이터 조회

####  정적 데이터 조회 - 쿼리 피라미터 사용

클라이언트 -> 서버  

```
[Client]
GET /static/star.jpg HTTP/1.1
Host: localhost:8080

->

[Server]: RETURN /static/star.jpg 
HTTP/1.1 200 OK
Content-Type: image/jpeg
Content-Length: 34012
lkj123kljoiasudlkjaweioluywlnfdo912u34ljko98udjkla
slkjdfl;qkawj9;o4ruawsldkal;skdjfa;ow9ejkl3123123
```



#### 정적 데이터 조회  - 정리

- 이미지, 정적 텍스트 문서  
- 조회는 GET 사용  
- 정적 데이터는 일반적으로 쿼리 파라미터 없이 리소스 경로로 단순하게 조회 가능  



<br>



### 동적 데이터 조회

#### 동적 데이터 조회 - 쿼리 파라미터 사용

클라이언트 -> 서버  

```
[Client]
GET /search?q=hello&hl=ko HTTP/1.1
Host: www.google.com

->

[Server]: 쿼리 파라미터를 기반으로 정렬해서 결과를 동적으로 생성.
q=hello&hl=ko == http://www.google.com 에서 한국어로 된 hello라는 검색에 대한 결과값 출력
```



#### 동적 데이터 조회 - 정리

- 주로 검색, 게시판 목록에서 정렬 필터(검색어)  
- 조회 조건을 줄여주는 필터, 조회 결과를 정렬하는 정렬 조건에 주로 사용  
- 조회는 GET 사용  
- GET은 쿼리 파라미터 사용해서 데이터 전달  



<br>



### HTML Form 데이터 전송

- GET, POST 메서드만 사용 가능

#### POST 전송 - 저장

클라이언트 -> 서버  

```
[Client]
<form action="/save" method="post">
 <input type="text" name="username" />
 <input type="text" name="age" />
 <button type="submit">전송</button>
</form>

->

웹 브라우저가 생성한 요청 HTTP 메시지
POST /save HTTP/1.1
Host: localhost:8080
Content-Type: application/x-www-form-urlencoded
username=kim&age=20
```



#### GET 전송 - 저장

클라이언트 -> 서버  

```
[Client]
<form action="/save" method="get">
 <input type="text" name="username" />
 <input type="text" name="age" />
 <button type="submit">전송</button>
</form>

->

웹 브라우저가 생성한 요청 HTTP 메시지:
GET /save?username=kim&age=20 HTTP/1.1
Host: localhost:8080
```

**GET은 조회에만 사용! 리소스 변경이 발생하는 곳에 사용하면 안됨!**  

HTML Form에서 GET을 조회가 아닌 저장에도 사용할 수 있지만

GET은 리소스 변경이 발생하는 곳이 아닌 조회하는 데에 사용하도록 하자



#### GET 전송 - 조회

클라이언트 -> 서버  

```
[Client]
<form action="/members" method="get">
 <input type="text" name="username" />
 <input type="text" name="age" />
 <button type="submit">전송</button>
</form>

->

웹 브라우저가 생성한 요청 HTTP 메시지:
GET /members?username=kim&age=20 HTTP/1.1
Host: localhost:8080
```



#### 데이터 전송 - multipart/form-data

클라이언트 -> 서버  

```
[Client]
<form action="/save" method="post" enctype="multipart/form-data">
 <input type="text" name="username" />
 <input type="text" name="age" />
 <input type="file" name="file1" />
 <button type="submit">전송</button>
</form>

->

웹 브라우저가 생성한 요청 HTTP 메시지:
POST /save HTTP/1.1
Host: localhost:8080
Content-Type: multipart/form-data; boundary=-----XXX
Content-Length: 10457
------XXX
Content-Disposition: form-data; name="username"
kim
------XXX
Content-Disposition: form-data; name="age"
20
------XXX
Content-Disposition: form-data; name="file1"; filename="intro.png"
Content-Type: image/png
109238a9o0p3eqwokjasd09ou3oirjwoe9u34ouief...
------XXX-- (끝에는 --붙음)
```



### 정리

- HTML Form submit시 POST 전송  
  - ex) 회원 가입, 상품 주문, 데이터 변경  
-  Content-Type: application/x-www-form-urlencoded 사용  
  - form의 내용을 메시지 바디를 통해서 전송(key=value, 쿼리 파라미터와 거의 동일한 형식)  
  - 전송 데이터를 url encoding 처리  
    - ex) abc김 ->  abc%EA%B9%80  
    - 인코딩: **인코딩**은 동영상이나 문자 **인코딩** 뿐 아니라 사람이 인지할 수 있는 형태의 데이터를 약속된 규칙에 의해 컴퓨터가 사용하는 0과 1로 변환하는 것
- HTML Form은 GET 전송도 가능  
- Content-Type: multipart/form-data  
  - 파일 ㅇ업로드 같은 바이너리 데이터 전송시 사용  
  - 다른 종류의 여러 파일과 폼의 내용 함께 전송 가능(그래서 이름이 multipart)  
- 참고: HTML Form 전송은 **GET, POST만 가능**  



--------------------------------------------------------------------
# #HTTP API 설계 예시

- HTTP API - 컬렉션
  - POST 기반 등록
  - ex) 회원 관리 API 제공
- HTTP API - 스토어
  - PUT 기반 등록
  - ex) 정적 컨텐츠 관리, 원격 파일 관리
- HTML FORM 사용
  - 웹 페이지 회원 관리
  - GET, POST만 지원



## 회원 관리 시스템

### API 설계 - POST 기반 등록

- 회원 목록 /members -> **GET**  
- 회원 등록 /members -> **POST**  
- 회원 조회 /members/{id} -> **GET** 
- 회원 수정 /members/{id} -> **PATCH, PUT, POST**  
- 회원 삭제 /members/{id} ->**DELETE**  



### POST - 신규 자원 등록 특징

- 클라이언트는 등록될 리소스의 URI를 모른다.

  - 회원 등록 /members -> POST  
  - POST /members

- 서버가 새로 등록된 리소스 URI를 생성해준다.

  - HTTP/1.1 201 Created  

    Location: /members/100

- 컬렉션(Collection)

  - 서버가 관리하는 리소스 디렉토리
  - 서버가 리소스의 URI를 생성하고 관리
  - 여기서 컬렉션은 /members



## 파일 관리 시스템

### API 설계 - PUT 기반 등록

- 파일 목록 /files -> **GET**
- 파일 조회 /files/{filename} -> **GET**
- 파일 등록 /files/{filename} -> **PUT**
- 파일 삭제 /files/{filename} -> **DELETE**
- 파일 대량 등록 /files -> **POST**



### PUT - 신규 자원 등록 특징

- 클라이언트가 리소스 URI를 알고 있어야 한다.  
  - 파일 등록 /files/{filename} -> PUT  
  - PUT /files/star.jpg  
- 클라이언트가 직접 리소스의 URI를 지정한다.  
- 스토어(Store)  
  - 클라이언트가 관리하는 리소스 저장소  
  - 클라이언트가 리소스의 URI를 알고 관리  
  - 여기서 스토어는 /files  



## HTML FORM 사용

- HTML FORM은 **GET, POST만 지원**  
- AJAX 같은 기술을 사용해서 해결 가능 -> 회원 API 참고  
- 여기서는 순수 HTML, HTML FORM 이야기  
- GET, POST만 지원하므로 제약이 있음  



### HTML FORM 기반 등록

- 회원 목록 /members -> **GET**  
- 회원 등록 폼 /members/new -> **GET ** 
- 회원 등록 /members/new, /members -> **POST**  
- 회원 조회 /members/{id} -> **GET**  
- 회원 수정 폼 /members/{id}/edit -> **GET ** 
- 회원 수정 /members/{id}/edit, /members/{id} -> **POST**  
- 회원 삭제 /members/{id}/delete -> **POST**  



### HTML FORM 기반 등록 특징

- HTML FORM은 **GET, POST만 지원**  
- 컨트롤 URI  
  - GET, POST만 지원하므로 제약이 있음  
  - 이런 제약을 해결하기 위해 동사로 된 리소스 경로 사용  
  - POST의 /new, edit, delete가 컨트롤 URI  
  - HTTP 메서드로 해결하기 애매한 경우 사용(HTTP API 포함)  



## 정리

- HTTP API - 컬렉션  
  - POST 기반 등록  
  - 서버가 리소스 URI 결정  
- HTTP API - 스토어  
  - PUT 기반 등록  
  - 클라이언트가 리소스 URI 결정  
- HTML FORM 사용  
  - 순수 HTML + HTML form 사용  
  - GET, POST만 지원  
  - GET, POST만 사용할 경우 컨트롤 URI 사용  



#### 참고하면 좋은 URI 설계 개념

- 문서(document)  
  - 단일 개념(파일 하나, 객체 인스턴스, 데이터베이스 row)  
  - 예) /members/100, /files/star.jpg  
- 컬렉션(collection)  
  - 서버가 관리하는 리소스 디렉터리  
  - 서버가 리소스의 URI를 생성하고 관리  
  - 예) /members  
- 스토어(store)  
  - 클라이언트가 관리하는 자원 저장소  
  - 클라이언트가 리소스의 URI를 알고 관리  
  - 예) /files  
- 컨트롤러(controller), 컨트롤 URI  
  - 문서, 컬렉션, 스토어로 해결하기 어려운 추가 프로세스 실행  
  - 동사를 직접 사용  
  - 예) /members/{id}/delete  



--------------------------------------------------------------------
# #HTTP 상태 코드

클라이언트가 보낸 요청의 처리 상태를 응답에서 알려주는 기능  



- 1xx(Informational): 요청이 수신되어 처리중
- 2xx(Successful): 요청 정상 처리
- 3xx(Redirection): 요청을 완료하려면 추가 행동이 필요
- 4xx(Client Error): 클라이언트 오류, 잘못된 문법등으로 서버가 요청을 수행할 수 없음
- 5xx(Server Error): 서버 오류, 서버가 정상 요청을 처리하지 못함



## 만약 모르는 상태코드가 나타났다면?

- 클라이언트가 인식할 수 없는 상태코드를 서버가 반환하면?
- 클라이언트는 상위 상태코드로 해석해서 처리
- 미래에 새로운 상태 코드가 추가되어도 클라이언트를 변경하지 않아도 됨
- ex)
  - 299 ??? -> 2xx(Successful)
  - 451 ??? -> 4xx(Client Error)
  - 599 ??? -> 5xx(Server Error)



<br>



## 1xx(Informational)

요청이 수신되어 처리중

- 거의 사용하지 않아서 생략



<br>



## 2xx(Successful)

클라이언트의 요청을 성공적으로 처리



- 200 OK
- 201 Created
- 202 Accepted
- 204 No Content



### 2xx - 200 OK(요청 성공)

요청  

```
GET /members/100 HTTP/1.1
Host: localhost:8080
```

응답

```
HTTP/1.1 200 OK
Content-Type: application/json
Content-Length: 34
{
 "username": "young",
 "age": 20
}
```



### 2xx - 201 Created(요청 성공해서 새로운 리소스가 생성됨)

요청

```
POST /members HTTP/1.1
Content-Type: application/json
{
 "username": "young",
 "age": 20
}
```

응답(생성된 리소스는 응답의 Location Header Field로 식별)

```
HTTP/1.1 201 Created
Content-Type: application/json
Content-Length: 34
Location: /members/100
{
 "username": "young",
 "age": 20
}
```



### 2xx - 202 Accepted(요청이 접수되었으나 처리가 완료되지 않았음)

- **일괄 처리(batch processing)** 같은 곳에서 사용
- ex) 요청 접수 후 1시간 뒤에 **batch process**가 요청을 처리함



### 2xx - 204 No Content(서버가 요청을 성공적으로 수행했지만, 응답 페이로드 본문에 보낼 데이터가 없음)

- ex) 웹 문서 편집기에서 save버튼
- save 버튼의 결과로 아무 내용이 없어도 된다
- save 버튼을 눌러도 같은 화면을 유지해야 한다
- 결과 내용이 없어도 204 메시지(2xx)만으로 성공을 인식할 수 있다.



<br>



## 3xx - 리다이렉션

요청을 완료하기 위해 유저 에이전트의 추가 조치 필요



- 300 Multiple Choices
- 301 Moved Permanently
- 302 Found
- 303 See Other
- 304 Not Modified
- 307 Temporary Redirect
- 308 Permanent Redirect



### 리다이렉션의 이해

- 웹 브라우저는 3xx 응답의 결과에 Location 헤더가 있으면, Location 위치로 자동 이동(리다이렉트)



#### 리다이렉션의 이해 - 자동 리다이렉트 흐름

1.요청(클라이언트 -> 서버)

```
GET /event HTTP/1.1
Host: localhost:8080
```

2.응답(서버 -> 클라이언트)

```
HTTP/1.1 301 Moved Permanently
Location: /new-event
```

3.Location이 있으므로 자동 리다이렉트

4.요청(클라이언트 -> 서버)

```
GET /new-event HTTP/1.1
Host: localhost:8080
```

5.응답(서버 -> 클라이언트)

```
HTTP/1.1 200 OK
... 
```



#### 리다이렉션의 이해 - 종류

- 영구 리다이렉션 - 특정 리소스의 URI가 영구적으로 이동
  - ex) /members -> /users
  - ex) /event -> /new-event
- 일시 리다이렉션 - 일시적인 변경
  - 주문 완료 후 주문 내역 화면으로 이동
  - **PRG**: Post/Redirect/Get
- 특수 리다이렉션
  - 결과 대신 캐시를 사용



##### 영구 리다이렉션(301,308)

- 리소스의 URI가 영구적으로 이동
- 원래의 URL을 사용X, 검색 엔진 등에서도 변경 인지
- 301 Moved Permanently
  - 리다이렉트시 요청 메서드가 GET으로 변하고, 본문이 제거될 수 있음(MAY)
- 308 Permanent Redierct
  - 301과 기능은 같음
  - 리다이렉트시 요청 메서드와 본문 유지(처음 POST를 보내면 리다이렉트도 POST 유지)



##### 영구 리다이렉션 - 301

1.요청(POST로 요청, 본문 메시지 존재)

```
POST /event HTTP/1.1
Host: localhost:8080

name=hello&age=20
```

2.응답

```
HTTP/1.1 301 Moved Permanently
Location: /new-event 
```

3.자동 리다이렉트

4.요청(GET으로 변경, 본문 메시지 제거)

```
GET /new-event HTTP/1.1
Host: localhost:8080
```

5.응답

```
HTTP/1.1 200 OK
...
```



##### 영구 리다이렉션 - 308

1.요청(POST로 요청, 본문 메시지 존재)

```
POST /event HTTP/1.1
Host: localhost:8080

name=hello&age=20
```

2.응답

```
HTTP/1.1 308 Permanent Redirect
Location: /new-event 
```

3.자동 리다이렉트

4.요청(POST 유지, 본문 메시지 유지)

```
POST /new-event HTTP/1.1
Host: localhost:8080

name=hello&age=20
```

5.응답

```
HTTP/1.1 200 OK
...
```



##### 일시적인 리다이렉션(302, 307, 303)

- 리소스의 URI가 일시적으로 변경
- 따라서 검색 엔진 등에서 URL을 변경하면 안됨
- 302 Found
  - 리다이렉트시 요청 메서드가 GET으로 변하고, 본문이 제거될 수 있음(MAY)
- 307 Temporary Redirect
  - 302와 기능은 같음
  - 리다이렉트 요청 메서드와 본문 유지(요청 메서드를 변경하면 안된다.  MUST NOT)
- 303 See Other
  - 302와 기능은 같음
  - 리다이렉트시 요청 메서드가 GET으로 변경



#### PRG: Post/Redirect/Get

일시적인 리다이렉션 - 예시

- POST로 주문후에 웹 브라우저를 새로고침하면?
- 새로고침은 다시 요청
- 중복 주문이 될 수 있다.



##### PRG 사용 전

1.요청(POST 사용)

```
POST /order HTTP/1.1
Host: localhost:8080

itemId=mouse&count=1
```

2.주문데이터 저장(마우스 1개 주문)

3.응답

```
HTTP/1.1 200 OK

<html>주문완료</html>
```

4.결과 화면에서 새로고침

5.요청

```
POST /order HTTP/1.1
Host: localhost:8080

itemId=mouse&count=1
```

2.주문데이터 저장(마우스 1개 주문)

7.응답

```
HTTP/1.1 200 OK

<html>주문완료</html>
```

**결과적으로 새로고침으로 인해 마우스를 2번 주문하게 되었다**

이런 문제 해결을 위해 PRG를 사용한다.

- POST로 주문후에 새로 고침으로 인한 중복 주문 방지
- POST로 주문후에 주문 결과 화면을 GET 메서드로 리다이렉트
- 새로고침해도 결과 화면을 GET으로 조회
- 중복 주문 대신에 결과 화면만 GET으로 다시 요청



##### PRG 사용

1.요청(POST 사용)

```
POST /order HTTP/1.1
Host: localhost:8080

itemId=mouse&count=1
```

2.주문데이터 저장(마우스 1개 주문)

3.응답

```
HTTP/1.1 302 Found

Location: /order-result/19
```

4.자동 리다이렉트

5.요청(302 Found로 인해 요청방식이 POST에서 GET으로 변경됨)

```
GET /order-result/19 HTTP/1.1
Host: localhost:8080
```

6.주문 데이터 조회 - 19번 주문

7.응답

```
HTTP/1.1 200 OK

<html>주문완료</html>
```

8.결과 화면에서 새로고침

```
GET /order-result/19 HTTP/1.1
Host: localhost:8080
```

**결과적으로 새로고침을 하면 주문 결과화면을 GET방식으로 불러오게 되어 중복 주문 오류를 피할 수 있다.**



#### 그래서 뭘 써야 할까? - 302, 307, 303

- 잠깐 정리 

  - 302 Found -> GET으로 변할 수 있음 

  - 307 Temporary Redirect -> 메서드가 변하면 안됨 

  - 303 See Other -> 메서드가 GET으로 변경

- 역사

  - 처음 302 스펙의 의도는 HTTP 메서드를 유지하는 것
  - 그런데 웹 브라우저들이 대부분 GET으로 바꾸어버림(일부는 다르게 동작)
  - 그래서 모호한 302를 대신하는 명확한 307, 303이 등장함(301 대응으로 308도 등장)

- 현실

  - 307, 303을 권장하지만 현실적으로 이미 많은 애플리케이션 라이브러리들이 302를 기본값으로 사용
  - 자동 리다이렉션시에 GET으로 변해도 되면 그냥 302를 사용해도 큰 문제 없음



#### 기타 리다이렉션  - 300, 304

- 300 Multiple Choices: 안쓴다.
- 304 Not Modified
  - 캐시를 목적으로 사용
  - 클라이언트에게 리소스가 수정되지 않았음을 알려준다. 따라서 클라이언트는 로컬PC에 저장된 캐시를 재사용한다.( 캐시로 리다이렉트 한다.)
  - 304 응답은 응답에 메시지를 바디를 포함하면 안된다. (로컬 캐시를 사용해야 하므로)
  - 조건부 GET, HEAD 요청시 사용



<br>



## 4xx - 클라이언트 오류

- 클라이언트의 요청에 잘못된 문법등으로 서버가 요청을 수행할 수 없음
- **오류의 원인이 클라이언트에 있음**
- 중요! 클라이언트가 이미 잘못된 요청, 데이터를 보내고 있기 때문에, 똑같은 재시도가 실패함



### 400 Bad Request

클라이언트가 잘못된 요청을 해서 서버가 요청을 처리할 수 없음

- 요청 구문, 메시지 등등 오류
- 클라이언트는 요청 내용을 다시 검토하고, 보내야함
- ex) 요청 피라미터가 잘못되거나, API 스펙이 맞지 않을 떄



### 401 Unauthorized

클라이언트가 해당 리소스에 대한 인증이 필요함

- 인증(Authentication) 되지 않음
- 401 오류 발생시 응답에 WWW-Authenticate 헤더와 함꼐 인증 방법을 설명
- 참고
  - 인증(Authentication): 본인이 누구인지 확인, (로그인)
  - 인가(Authorization): 권한부여 (ADMIN 권한처럼 특정 리소스에 접근할 수 있는 권한, 인증이 있어야 인가가 있음)
  - 오류 메시지가 Unauthorized 이지만 인증 되지 않음 (이름이 아쉬움)



### 403 Forbidden

서버가 요청을 이해했지만 승인을 거부함

- 주로 인증 자격 증명은 있지만, 접근 권한이 불충분한 경우
- ex) 어드민 등급이 아닌 사용자가 로그인은 했지만, 어드민 등급의 리소스에 접근하는 경우



### 404 Not Found

요청 리소스를 찾을 수 없음

- 요청 리소스가 서버에 없음
- 또는 클라이언트가 권한이 부족한 리소스에 접근할 때 해당 리소스를 숨기고 싶을 때



<br>



## 5xx- 서버 오류

- 서버 문제로 오류 발생
- 서버에 문제가 있기 때문에 재시도 하면 성공할 수도 있음(복구가 되거나 등등)



### 500 Internal Server Error

서버 문제로 오류 발생, 애매하면 500 오류

- 서버 내부 문제로 오류 발생
- 애매하면 500 오류



### 503 Service Unavailable

서비스 이용 불가

- 서버가 일시적인 과부하 또는 예정된 작업으로 잠시 요청을 처리할 수 없음
- Retry-After 헤더 필드로 얼마 뒤에 복구되는지 보낼 수도 있음



--------------------------------------------------------------------
# #HTTP 헤더

- header-field = field-name ":" OWS field-value OWS (OWS: 띄어쓰기 허용)
- field-name은 대소문자 구문 없음



*header : [ ] 부분

```
GET /search?q=hello&hl=ko HTTP/1.1
[Host: www.google.com]
```

```
HTTP/1.1 200 OK
[Content-Type: text/html;charset=UTF-8]
[Content-Length: 3423]
<html>
 <body>...</body>
</html>
```



<br>



## HTTP 헤더 - 용도

- HTTP 전송에 필요한 모든 부가정보
- ex) 메시지 바디의 내용, 메시지 바디의 크기, 압축, 인증, 요청 클라이언트, 서버 정보, 캐시 관리 정보 etc..
- 표준 헤더가 너무 많음(https://en.wikipedia.org/wiki/List_of_HTTP_header_fields)
- 필요시 임의의 헤더 추가 가능
  - helloworld: hihi





<br>



## HTTP 헤더 - 분류

RFC2616(과거)

- General 헤더: 메시지 전체에 적용되는 정보, ex) Connection: close
- Request 헤더: 요청 정보, ex)User-Agent: Mozilla/5.0
- Response 헤더: 응답 정보, ex) Server: Apache
- Entity 헤더: 엔티티 바디 정보, ex) Content-Type: text/html, Content-Length:3413



<br>



## HTTP BODY

### message body - RFC2616(과거)

```
HTTP/1.1 200 OK
[Content-Type: text/html;charset=UTF-8
Content-Length: 3423] - 엔티티 헤더

[[<html>
 <body>...</body>
</html>]] - 메시지 본문 / 엔티티 본문
```

- 메시지 본문(message body)은 엔티티 본문(entity body)을 전달하는데 사용
- 엔티티 본문은 요청이나 응답에서 전달할 실제 데이터
- 엔티티 헤더는 엔티티 본문의 데이터를 해석할 수 있는 정보 제공
  - 데이터 유형(html, json), 데이터 길이, 압축 정보 등등



### RFC2616의 폐기

2014년 **RFC7230~7235의 등장**으로 **RFC2616이 폐기**



### RFC723x 변화

- 엔티티(Entity) -> 표현(Representation)
- Representation = representation Metadata + Representation Data
- 표현 = 표현 메타데이터 + 표현 데이터



### message body - RFC7230(최신)

```
HTTP/1.1 200 OK
[Content-Type: text/html;charset=UTF-8
Content-Length: 3423] - 표현 헤더

[[<html>
 <body>...</body>
</html>]] - 메시지 본문 / 표현 데이터
```

- 메시지 본문(message body)을 통해 표현 데이터 전달

- 메시지 본문 = 페이로드(payload)

  : 페이로드는 전송의 근본적인 목적이 되는 데이터의 일부분으로 그 데이터와 함께 전송되는 헤더와 메타데이터와 같은 데이터는 제외한다. 

  (https://ko.wikipedia.org/wiki/%ED%8E%98%EC%9D%B4%EB%A1%9C%EB%93%9C_(%EC%BB%B4%ED%93%A8%ED%8C%85))

- 표현은 요청이나 응답에서 전달할 실제 데이터

- 표현 헤더는 표현 데이터를 해석할 수 있는 정보 제공

  - 데이터 유형(html, json), 데이터 길이, 압축 정보 등등

- 참고: 표현 헤더는 표현 메타데이터와, 페이로드 메시지를 구분해야 하지만, 여기서는 생략



<br>



## 표현

```
HTTP/1.1 200 OK
Content-Type: text/html;charset=UTF-8
Content-Length: 3423

<html>
 <body>...</body>
</html>
```

- Content-Type: 표현 데이터의 형식
- Content-Encoding: 표현 데이터의 압축 방식
- Content-Language: 표현 데이터의 자연 언어
- Content-Length: 표현 데이터의 길이

  

- 표현 헤더는 전송, 응답 둘다 사용





### Content-Type

표현 데이터의 형식 설명

- 미디어 타입, 문자 인코딩
- ex)
  - text/html; charset=utf-8
  - application/json
  - image/png

```
HTTP/1.1 200 OK
[Content-Type: text/html;charset=UTF-8]
Content-Length: 3423

<html>
 <body>...</body>
</html>
```

```
HTTP/1.1 200 OK
[Content-Type: application/json]
Content-Length: 16

{"data":"hello"}
```





### Content-Encoding

표현 데이터 인코딩

- 표현 데이터를 압축하기  위해 사용
- 데이터를 전달하는 곳에서 압축 후 인코딩 헤더 추가
- 데이터를 읽는 쪽에서 인코딩 헤더의 정보로 압축 해제
- ex)
  - gzip
  - deflate
  - identity

```
HTTP/1.1 200 OK
Content-Type: text/html;charset=UTF-8
[Content-Encoding: gzip]
Content-Length: 521

lkj123kljoiasudlkjaweioluywlnfdo912u34lj
ko98udjkl
```





### Content-Language

표현 데이터의 자연 언어

- 표현 데이터의 자연 언어를 표현
- ex)
  - ko
  - en
  - en-US

```
HTTP/1.1 200 OK
Content-Type: text/html;charset=UTF-8
[Content-Language: ko]
Content-Length: 521

<html>
안녕하세요.
</html>
```

```
HTTP/1.1 200 OK
Content-Type: text/html;charset=UTF-8
[Content-Language: en]
Content-Length: 521

<html>
hello
</html>
```





### Content-Length

표현 데이터의 길이

- 바이트 단위

- Transfer-Encoding(분할 전송)을 사용하면 Content-Length를 사용하면 안됨

  ex) Transfer-Encoding: chunked사용시  Content-Length가 내부에 정해지기 때문에 Content-Length사용X

  chunk형식: 각 청크의 앞부분에 현재 청크의 길이가 16진수 형태로 오고 그 뒤에는 '\r\n'이 오고 그 다음에 청크 자체가 오며, 그 뒤에는 다시 '\r\n'이 옵니다.

  (https://developer.mozilla.org/ko/docs/Web/HTTP/Headers/Transfer-Encoding)

```
HTTP/1.1 200 OK
Content-Type: text/html;charset=UTF-8
[Content-Length: 5]
hello
```



<br>



## 협상(콘텐츠 네고시에이션)

클라이언트가 선호하는 표현 요청

- Accept: 클라이언트가 선호하는 미디어 타입 전달
- Accept-Charset: 클라이언트가 선호하는 문자 인코딩
- Accept-Encoding: 클라이언트가 선호하는 압축 인코딩
- Accept-Language: 클라이언트가 선호하는 자연 언어



- 협상 헤더는 **요청시**에만 사용



### Accept-Language

**적용 전**

```
한국어 브라우저 사용
GET /event

->

다중 언어 지원 서버
1. 기본 영어(en)
2. 한국어 지원(ko)
Content-Language: en
hello (영어)
```



**적용 후**

```
GET /event
Accept-Language: ko

->

Content-Language: ko
안녕하세요
```



**복잡한 예시**

```
GET /event
Accept-Language: ko

->

다중 언어 지원 서버
1. 기본 독일어(de)
2. 영어도 지원(en)

Content-Language: de
Hallo (독일어)
```

한국어가 아니면 영어로라도 페이지를 보고싶은데 **우선순위**가 없어 기본인 독일어로 페이지가 출력되는 문제가 발생



### 협상과 우선순위1

**Quality Values(q)**

```
GET /event
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
```



- Quality Values(q) 값 사용
- 0~1, 클수록 높은 우선순위
- 생략하면 1
- Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
  - 1.ko-KR;q=1 (q생략)
  - 2.ko;q=0.9
  - 3.en-US;q=0.8
  - 4.en:q=0.7



**복잡한 예시** 해결

```
GET /event
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7

->

다중 언어 지원 서버
1. 기본 독일어(de)
2. 영어도 지원(en)

Content-Language: en
Hello (영어)
```





### 협상과 우선순위2

**Quality Values(q)**

```
GET /event
Accept: text/*, text/plain, text/plain;format=flowed, */*
```



- 구체적인 것이 우선한다.
- Accept: text/*, text/plain, text/plain;format=flowed, *\*/\**
  - 1.text/plain;format=flowed
  - 2.text/plain
  - 3.text/*
  - 4.\*/\*





### 협상과 우선순위3

**Quality Values(q)**



- 구체적인 것을 기준으로 미디어 타입을 맞춘다.
- Accept: text/*;q=0.3, text/html;q=0.7, text/html;level=1, text/html;level=2;q=0.4, \*/\*;q=0.5



<br>



## 전송 방식

- Transfer-Encoding
- Range, Content-Range



### 전송 방식 설명

- 단순 전송
- 압축 전송
- 분할 전송
- 범위 전송





#### 단순 전송

**Content-Length**

```
[클라이언트]->[서버]
GET /event

->

[응답]
HTTP/1.1 200 OK
Content-Type: text/html;charset=UTF-8
*Content-Length: 3423*

<html>
 <body>...</body>
</html>

```



#### 압축 전송

**Content-Encoding**

```
[클라이언트]->[서버]
GET /event



[응답]
HTTP/1.1 200 OK
Content-Type: text/html;charset=UTF-8
*Content-Encoding: gzip*
Content-Length: 521

lkj123kljoiasudlkjaweioluywlnfdo912u34ljko98udjkl

```



#### 분할 전송

**Transfer-Encoding**

```
[클라이언트]->[서버]
GET /event



[응답]
HTTP/1.1 200 OK
Content-Type: text/plain
*Transfer-Encoding: chunked*

5
Hello
5
World
0
\r\n
```

**Transfer-Encoding: chunked**

리소스를 여러 덩어리(chunk)로 나눠서 응답하는 방식으로

**크기, 내용**이 한 덩어리이다.

ex)

```
5 : 5byte
hello : 내용
```



이렇듯 body에 **크기**가 같이 기록 되기 때문에

**Content-Length는 사용이 불가하다**





#### 범위 전송

**Range, Content-Range**

```
[클라이언트]->[서버]
GET /event
Range: bytes=1001-2000


[응답]
HTTP/1.1 200 OK
Content-Type: text/plain
*Content-Range: bytes 1001-2000 / 2000*

qweqwe1l2iu3019u2oehj1987askjh3q98y

```

**Content-Range: bytes 1001-2000 / 2000**

= 총 2000byte의 데이터 중에 1001~2000byte의 데이터만 전송했다는 뜻



클라이언트가 어떤 사이트의 서버에서 총 2000byte 크기의 데이터를 이미 1000까지는 받았다고 가정하자

여기서 이 클라이언트는 사이트 재방문시에 서버로부터 1-1000byte까지는 받을 필요가 없다.

그럴 때에 Content-Range로 데이터의 범위를 지정하여 1001-2000byte만 받게할 수 있는 것이다.



<br>



## 일반 정보

- From: 유저 에이전트의 이메일 정보
- Referer: 이전 웹페이지 주소
- User-Agent: 유저 에이전트 애플리케이션 정보
- Server: 요청을 처리하는 오리진 서버의 소프트웨어 정보
- Date: 메시지가 생성된 날짜



### From

**유저 에이전트의 이메일 정보**

- 일반적으로 잘 사용되지 않음
- 검색 엔진 같은 곳에서, 주로 사용
- 요청에서 사용



### Referer

**이전 웹페이지 주소**

- 현재 요청된 페이지의 이전 웹 페이지 주소
- A -> B로 이동하는 경우 B를 요청할 때 Referer: A 를 포함해서 요청
- Referer를 사용해서 유입 경로 분석 가능
- 요청에서 사용
- 참고: referer는 단어 referrer의 오타



### User-Agent

**유저 에이전트 애플리케이션 정보**

- user-agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/ 537.36 (KHTML, like Gecko) Chrome/86.0.4240.183 Safari/537.36
- 클리이언트의 애플리케이션 정보(웹 브라우저 정보, 등등)
- 통계 정보
- 어떤 종류의 브라우저에서 장애가 발생하는지 파악 가능
- 요청에서 사용



### Server

**요청을 처리하는 ORIGIN 서버의 소프트웨어 정보**

- Server: Apache/2.2.22 (Debian)
- server: nginx
- 응답에서 사용



### Date

**메시지가 발생한 날짜와 시간**

- Date: Tue, 15 Nov 1994 08:12:31 GMT
- 응답에서 사용



<br>



## 특별한 정보

- Host: 요청한 호스트 정보(도메인)
- Location: 페이지 리다이렉션
- Allow: 허용 가능한 HTTP 메서드
- Retry-After: 유저 에이전트가 다음 요청을 하기까지 기다려야 하는 시간



### Host

**요청한 호스트 정보(도메인)**

```
GET /search?q=hello&hl=ko HTTP/1.1
Host: www.google.com
```

- 요청에서 사용
- 필수
- 하나의 서버가 여러 도메인을 처리해야 할 때
- 하나의 IP주소에 여러 도메인이 적용되어 있을 때



가상호스트를 통해 여러 도메인을 한번에 처리할 수 있는 서버**(IP: 200.200.200.2)**에

**aaa.com / bbb.com / ccc.com** 이라는 도메인이 있다고 가정하자



```
GET /hello HTTP/1.1
```

만약 클라이언트가 bbb.com이라는 도메인에 /hello를 요청하기 위해

bbb.com의 IP주소 200.200.200.2에 요청을 보내버리면

200.200.200.2의 IP를 가진 서버에는 3개의 도메인주소가 있어 3개 중 어디에서 /hello에 대한 응답을 줘야하는지 서버는 알 수 없다.



이런 상황이 발생할 수 있기 때문에 Host를 필수 정보로 사용한다

```
GET /hello HTTP/1.1
Host: bbb.com
```





### Location

**페이지 리다이렉션**

- 웹 브라우저는 3xx 응답의 결과에 Location 헤더가 있으면, Location 위치로 자동 이동(리다이렉트)
- 응답코드 3xx에서 설명
- 201(Created)의 Location값은 요청에 의해 생성된 리소스의 URI
- 3xx(Redirection)의 Location 값은 요청을 자동으로 리다이렉션 하기 위한 대상 리소스를 가리킴





### Allow

**허용 가능한 HTTP 메서드**

- 405(Method Not Allowed) 에서 응답에 포함해야함
- Allow: GET, HEAD, PUT





### Retry-After

**유저 에이전트가 다음 요청을 하기까지 기다려야 하는 시간**

- 503(Service Unavailable): 서비시가 언제까지 불능인지 알려줄 수 있음
- Retry-After: Fri, 31 Dec 1999 23:59:59 GMT (날짜 표기)
- Retry-After: 120 (초단위 표기)



<br>



## 인증

- Authorization: 클라이언트 인증 정보를 서버에 전달
- WWW-Authenticate: 리소스 접근시 필요한 인증 방법 정의



### Authorization

**클라이언트 인증 정보를 서버에 전달**

- Authorization: Basic xxxxxxxxxxxxxxxx



### WWW-Authenticate

**리소스 접근시 필요한 인증 방법 정의**

- 리소스 접근시 필요한 인증 방법 정의

- 401 Unauthorized 응답과 함께 사용

- WWW-Authenticate: Newauth realm="apps", type=1, 

  title="Login to \"apps\"", Basic realm="simple"



<br>



## 쿠키

- Set-Cookie: 서버에서 클라이언트로 쿠키 전달(응답)
- Cookie: 클라이언트가 서버에서 받은 쿠키를 저장하고, HTTP 요청시 서버로 전달



### 쿠키 미사용 예시

**처음 welcome 페이지 접근**

```
[브라우저 -> 서버]요청
GET /welcome HTTP/1.1

[서버 -> 브라우저]응답
HTTP/1.1 200 OK

안녕하세요. 손님
```



**로그인**

```
[브라우저 -> 서버]요청
POST /login HTTP/1.1
user=홍길동

[서버 -> 브라우저]응답
HTTP/1.1 200 OK

홍길동님이 로그인했습니다.
```



**로그인 이후 welcome페이지 재접근**

```
[브라우저 -> 서버]요청
GET /welcome HTTP/1.1

[서버 -> 브라우저]응답
HTTP/1.1 200 OK

안녕하세요. 손님
```



#### Stateless

- HTTP는 무상태 프로토콜이다
- 클라이언트와 서버가 요청과 응답을 주고 받으면 연결이 끊어진다
- 클라이언트가 다시 요청하면 서버는 이전 요청을 기억하지 못한다
- 클라이언트와 서버는 서로 상태를 유지하지 않는다.



**대안 - 모든 요청에 사용자 정보 포함**

```
[브라우저 -> 서버]요청
GET /welcome?user=홍길동 HTTP/1.1

[서버 -> 브라우저]응답
HTTP/1.1 200 OK

안녕하세요. 홍길동님
```

**문제점:**

- 모든 요청에 사용자 정보가 포함되도록 개발 해야함
- 브라우저를 완전히 종료하고 다시 열면?



### 쿠키 사용 예시

**로그인**

```
[브라우저 -> 서버]요청
POST /login HTTP/1.1
user=홍길동

[서버 -> 브라우저]응답
HTTP/1.1 200 OK
Set-Cookie: user=홍길동

홍길동님이 로그인했습니다.
```

- 브라우저는 user=홍길동 이라는 쿠키를 쿠키 저장소에 저장



**로그인 이후 welcome 페이지 접근**

```
[브라우저 -> 서버]요청
GET /welcome HTTP/1.1
Cookie: user=홍길동

[서버 -> 브라우저]응답
HTTP/1.1 200 OK

안녕하세요. 홍길동님
```

- 브라우저는 쿠키저장소에서 쿠키를 조회해서 요청시에 같이 보낸다



### 쿠키

- 예) set-cookie: sessionId=abcde1234; expires=Sat, 26-Dec-2020 00:00:00 GMT; path=/; domain=.google.com; Secure
- 사용처
  - 사용자 로그인 세션 관리
  - 광고 정보 트래킹
- 쿠키 정보는 항상 서버에 전송됨
  - 네트워크 트래픽 추가 유발
  - 최소한의 정보만 사용(세션 id, 인증 토큰)
  - 서버에 전송하지 않고, 웹브라우저 내부에 데이터를 저장하고 싶으면 웹 스토리지(localStorage, sessionStroage) 참고
- 주의!
  - 보안에 민감한 데이터는 저장하면 안됌(주민번호, 신용카드 번호 등등)



### 쿠키 - 생명주기

Expires, max-age

- Set-Cookie: expires=Sat, 26-Dec-2020 04:39:21 GMT
  -  만료일이 되면 삭제
- Set-Cookie: max-age:3600 (3600초)
  - 0이나 음수를 지정하면 쿠키 삭제
- 세션 쿠키: 만료 날짜를 생략하면 브라우저 종료시 까지만 유지
- 영속 쿠키: 만료 날짜를 입력하면 해당 날짜까지 유지



### 쿠키 - 도메인

- ex) domain=example.org
- 명시: 명시한 문서 기준 도메인 + 서브 도메인 포함
  - domain=example.org를 지정해서 쿠키 생성
    - example.org는 물론이고
    - dev.example.org도 쿠키 접근
- 생략: 현재 문서 기준 도메인만 적용
  - example.org 에서 쿠키를 생성하고 domain 지정을 생략
    - example.org 에서만 쿠키 접근
    - dev.example.org는 쿠키 미접근



### 쿠키 - 경로

- ex) path=/home
- **이 경로를 포함한 하위 경로 페이지만 쿠키 접근**
- **일반적으로 path=/ 루트로 지정**
- ex)
  - **path=/home 지정**
  - /home -> 가능
  - /home/level1 -> 가능
  - /home/level1/level2 -> 가능
  - /hello -> 불가능



### 쿠키 - 보안

- Secure
  - 쿠키는 http, https를 구분하지 않고 전송
  - Secure을 적용하면 https인 경우에만 전송
- HttpOnly
  - XSS 공격 방지
  - 자바스크립트에서 접근 불가(document.cookie)
  - HTTP 전송에만 사용
- SameSite
  - XSRF 공격 방지
  - 요청 도메인과 쿠키에 설정된 도메인이 같은 경우만 쿠키 전송



<br>



## 캐시 기본동작



### 캐시가 없을 때

**첫 번째 요청**

```
[클라이언트->서버]
GET /star.jpg

[응답]
HTTP/1.1 200 OK
Content-Type: image/jpeg
Content-Length: 34012

lkj123kljoiasudlkjaweioluywlnfdo912u34ljko98udjkla
slkjdfl;qkawj9;o4ruawsldkal;skdjfa;ow9ejkl3123123
```

star.jpg(1.1M) 전송받음

- HTTP 헤더(0.1M)
- HTTP 바디(1.0M)



**두 번째 요청**

```
[클라이언트->서버]
GET /star.jpg

[응답]
HTTP/1.1 200 OK
Content-Type: image/jpeg
Content-Length: 34012

lkj123kljoiasudlkjaweioluywlnfdo912u34ljko98udjkla
slkjdfl;qkawj9;o4ruawsldkal;skdjfa;ow9ejkl3123123
```

star.jpg(1.1M) 또 전송받음

- HTTP 헤더(0.1M)
- HTTP 바디(1.0M)



**정리**

- 데이터가 변경되지 않아도 계속 네트워크를 통해서 데이터를 다운받아야 한다.
- 인터넷 네트워크는 매우 느리고 비싸다.
- 브라우저 로딩 속도가 느리다.
- 느린 사용자 경험.



### 캐시 적용

**첫 번째 요청**

```
[클라이언트->서버]
GET /star.jpg

[응답]
HTTP/1.1 200 OK
Content-Type: image/jpeg
cache-control: max-age=60 
Content-Length: 34012

lkj123kljoiasudlkjaweioluywlnfdo912u34ljko98udjkla
slkjdfl;qkawj9;o4ruawsldkal;skdjfa;ow9ejkl3123123
```

- **캐시가 유효한 시간(max-age=60/60초)가 정의된 응답이 돌아옴**
- star.jpg(1.1M) 전송받음
  - HTTP 헤더(0.1M)
  - HTTP 바디(1.0M)
- 응답 결과를 브라우저 캐시에 저장함(60초 유효)



**두 번째 요청**

```
[클라이언트->서버]
GET /star.jpg

[브라우저 캐시->클라이언트]
조회된 것을 전달
```

- GET /star.jpg 요청을 하면 브라우저가 캐시 저장소의 캐시 유효시간을 검증
- 시간이 유효하다면 star.jpg를 캐시에서 조회



**정리**

- 캐시 덕분에 캐시 가능 시간동안 네트워크를 사용하지 않아도 된다.
- 비싼 네트워크 사용량을 줄일 수 있다.
- 브라우저 로딩 속도가 매우 빠르다.
- 빠른 사용자 경험



**세 번째 요청**

```
[클라이언트->서버]
GET /star.jpg

[응답]
HTTP/1.1 200 OK
Content-Type: image/jpeg
cache-control: max-age=60 
Content-Length: 34012

lkj123kljoiasudlkjaweioluywlnfdo912u34ljko98udjkla
slkjdfl;qkawj9;o4ruawsldkal;skdjfa;ow9ejkl3123123
```

- 캐시 적용시간 60초가 지났기 때문에 서버에서 다시 이미지를 받아옴(1.1M)
- 브라우저 캐시에 캐시를 다시 저장



**캐시 시간 초과**

- 캐시 유효 시간이 초과하면, 서버를 통해 데이터를 다시 조회하고, 캐시를 갱신한다.
- 이때 다시 네트워크 다운로드가 발생한다.



## 검증 헤더와 조건부 요청1



### 캐시 시간 초과

- 캐시 유효 시간이 초과해서 서버에 다시 요청하면 다음 두 가지 상황이 나타난다.
  1. 서버에서 기존 데이터를 변경함 (노란별) -> (녹색별)
  2. 서버에서 기존 데이터를 변경하지 않음 (노란별 유지)
     - 캐시 만료 후에도 서버에서 데이터를 변경하지 않음
     - 생각해보면 데이터를 전송하는 대신에 저장해 두었던 캐시를 재사용 할 수 있다.
     - 단 클라이언트는 데이터와 서버의 데이터가 같다는 사실을 확인할 수 있는 방법 필요**(검증 헤더)**



### 검증 헤더 추가

**첫번째 요청**

```
[클라이언트]->[서버]
GET /star.jpg

[응답] -> 캐시에 저장
HTTP/1.1 200 OK
Content-Type: image/jpeg
cache-control: max-age=60
Last-Modified: 2020년 11월 10일 10:00:00
Content-Length: 34012

lkj123kljoiasudlkjaweioluywlnfdo912u34ljko98udjklasl
kjdfl;qkawj9;o4ruawsldkal;skdjfa;ow9ejkl3123123
```

- Last-Modified : 데이터 최종 수정일



**두번째 요청** - 캐시 시간 초과 상황

```
[클라이언트]->[서버]
GET /star.jpg
if-modified-since: 2020년 11월 10일 10:00:00

[검증]
캐시가 가지고 있는 데이터 최종 수정일과 서버의 데이터 최종 수정일이 같다.

[응답]
HTTP/1.1 304 Not Modified
Content-Type: image/jpeg
cache-control: max-age=60
Last-Modified: 2020년 11월 10일 10:00:00
Content-Length: 34012

HTTP BODY없음
```

- 검증 후 캐시가 가지고 있는 데이터 최종 수정일과 서버 데이터의 최종 수정일이 같다면 304 **Not Modified**와 함께 **HTTP헤더만 전송(0.1M)**
- 브라우저 캐시는 헤더 데이터를 갱신
- 캐시 유효시간이 초기화 되어 사용가능 상태이기 때문에 캐시에 저장되어있는 star.jpg를 재사용



**정리**

- 캐시 유효 시간이 초과해도, 서버의 데이터가 갱신되지 않으면
- 304 Not Modified + 헤더 메타 정보만 응답(바디X, 데이터 크기 작음)
- 클라이언트는 서버가 보낸 응답 헤더 정보로 캐시의 메타 정보를 갱신
- 클라이언트는 캐시에 저장되어 있는 데이터 재활용
- 결과적으로 네트워크 다운로드가 발생하지만 용량이 적은 헤더 정보만 다운로드
- 매우 실용적인 해결책



## 검증 헤더와 조건부 요청2

- 검증 헤더
  - 캐시 데이터와 서버 데이터가 같은지 검증하는 데이터
  - Last-Modified, ETag
- 조건부 요청 헤더
  - 검증 헤더로 조건에 따른 분기
  - If-Modified-Since: Last-Modified 사용
  - If-None-Match: ETag 사용
  - 조건이 만족하면 200 OK
  - 조건이 만족하지 않으면 304 Not Modified



  ### 예시

- If-Modified-Since: 이후에 데이터가 수정되었으면?
  - 데이터 미변경 예시
    - 캐시: 2020년 11월 10일 10:00:00 vs 서버: 2020년 11월 10일 10:00:00
    - 304 Not Modified, 헤더 데이터만 전송(BODY 미포함)
    - 전송 용량 0.1M (헤더 0.1M, 바디 1.0M)
  - 데이터 변경 예시
  - 캐시: 2020년 11월 10일 10:00:00 vs 서버: 2020년 11월 10일 **11**:00:00
  - 200 OK, 모든 데이터 전송(BODY 포함)
  - 전송 용량 1.1M (헤더 0.1M, 바디 1.0M)



#### Last-Modified, If-Modified-Since 단점

- 1초 미만(0.1초) 단위로 캐시 조정이 불가능
- 날짜 기반의 로직 사용
- 데이터를 수정해서 날짜가 다르지만, 같은 데이터를 수정해서 데이터 결과가 똑같은 경우(서버에서 A를 다시 A로 수정해놓은 경우)
- 서버에서 별도의 캐시 로직을 관리하고 싶은 경우
  - 예) 스페이스나 주석처럼 크게 영향이 없는 변경에서 캐시를 유지하고 싶은 ㄷ경우

 

### ETag, If-None-Match

- ETag(Entity Tag)
- 캐시용 데이터에 임의의 고유한 버전 이름을 달아둠
  - 예) ETag: "v1.0", ETag: "a2jiodwjekjl3" 
- 데이터가 변경되면 이 이름을 바꾸어서 변경함(Hash를 다시 생성) 
  - 예) ETag: "aaaaa" -> ETag: "bbbbb" 
- 진짜 단순하게 ETag만 보내서 같으면 유지, 다르면 다시 받기!



#### 예시

**첫 번째 요청**

```
[클라이언트]->[서버]
GET /star.jpg

[응답]
HTTP/1.1 200 OK
Content-Type: image/jpeg
cache-control: max-age=60
ETag: "aaaaaaaaaa"
Content-Length: 34012

lkj123kljoiasudlkjaweioluywlnfdo912u34ljko98udjklasl
kjdfl;qkawj9;o4ruawsldkal;skdjfa;ow9ejkl3123123
```

- 서버에서 60초동안 유효하고 ETag가 "aaaaaaaaaa" 인 star.jpg 전송
- 응답결과를 캐시에 저장



**두 번째 요청** - 60초가 초과된 이후

```
[클라이언트]->[서버]
GET /star.jpg

[캐시 저장소]
캐시저장소의 star.jpg의 유효시간이 지남
서버로 요청해야함

[클라이언트]->[서버]
GET /star.jpg
If-None-Match: "aaaaaaaaaa"

[서버]
서버에 있는 star.jpg의 ETag도 "aaaaaaaaaa"
= 데이터가 수정되지 않음

[응답]
HTTP/1.1 304 Not Modified
Content-Type: image/jpeg
cache-control: max-age=60
ETag: "aaaaaaaaaa"
Content-Length: 34012

ETag가 일치하기 때문에 캐시 데이터 갱신을 위한 헤더만 전송

[캐시 저장소]
60초 유효한 star.jpg캐시를 저장, 헤더 데이터 갱신

[클라이언트]
ETag가 "aaaaaaaaaa"인 star.jpg를 캐시에서 조회하여 사용
```



#### 정리

- 진짜 단순하게 ETag만 서버에 보내서 같으면 유지, 다르면 다시 받기!
- 캐시 제어 로직을 서버에서 완전히 관리
- 클라이언트는 단순히 이 값을 서버에 제공(클라이언트는 캐시 메커니즘을 모름)
- ex)
  - 서버는 배타 오픈 기간인 3일 동안 파일이 변경되어도 ETag를 동일하게 유지
  - 애플리케이션 배포 주기에 맞추어 ETag 모두 갱신



## 캐시 제어 헤더

- Cache-Control: 캐시 제어
- Pragma: 캐시 제어(하위 호환)
- Expires: 캐시 유효 기간(하위 호환)



###  Cache-Control

**캐시 지시어(directives)**

- Cache-Control: max-age
  - 캐시 유효 시간, 초 단위
- Cache-Control: no-cache
  - 데이터는 캐시해도 되지만, 항상 원(origin) 서버에 검증하고 사용
- Cache-Control: no-store
  - 데이터에 민감한 정보가 있으므로 저장하면 안됨 (메모리에서 사용하고 최대한 빨리 삭제)



### Pragma

**캐시 제어(하위 호환)**

- Pragma: no-cache
- HTTP 1.0 하위 호환



### Expires

**캐시 만료일 지정(하위 호환)**

- expires: Mon, 01 Jan 1990 00:00:00 GMT



- 캐시 만료일을 정확한 날짜로 지정
- HTTP 1.0 부터 사용
- 지금은 더 유연한 Cache-Control: max-age 권장
- Cache-Control: max-age와 함께 사용하면 Expires는 무시



### 검증 헤더와 조건부 요청 헤더

- 검증 헤더 (Validator)
  - ETag: "v1.0", ETag: "asid93jkrh2l"
  - Last-Modified: Thu, 04 Jun 2020 07:19:24 GMT
- 조건부 요청 헤더
  - If-Match, If-None-Match: ETag 값 사용
  - If-Modified-Since, If-Unmodified-Since: Last-Modified 값 사용



<br>



## 프록시 캐시

