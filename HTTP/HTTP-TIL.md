



# HTTP-TIL

---
# IP(Internet Protocol)
- 지정한 IP주소에 데이터 전달    
- 패킷이라는 통신 단위로 데이터 전달  
- IP 패킷 정보: 출발지IP, 목적지IP, etc...를 포함한 전송데이터   
- 원리: 클라이언트에서 목적지IP(서버)로 전송데이터를 전달하고 패킷에서 출발지IP를 확인한 서버는 다시 그 IP주소로 응답을 보냄   

## IP프로토콜의 한계

- 비연결성: 패킷을 받을 대상이 없거나 서비스 불능 상태여도 패킷 전송   
- 비신뢰성: 중간에 패킷이 사라진다면? / 패킷이 순서대로 안오면?  
- 프로그램 구분: 같은 IP를 사용하는 서버에서 통신하는 애플리케이션이 둘 이상이면  

---

<h1>인터넷 프로토콜의 4계층</h1>
- 애플리케이션 계층(HTTP, FTP)   
- 전송 계층(TCP, UDP)  
- 인터넷 계층(IP)  
- 네트워크 인터페이스 계층    


---

<h1>TCP(Transmission Control Protocol)</h1>
- IP 패킷 정보: 출발지IP, 목적지IP, etc...를 포함한 전송데이터  
- TCP/IP 패킷 정보: 출발지IP, 목적지IP, etc... + 출발지PORT, 목적지PORT, 전송제어, 순서, 검증 정보 etc..를 포함한 전송데이터  

<h2>TCP 특징</h2>
- 연결지향 - TCP 3 way handshake (가상 연결)    
- 데이터 전달 보증  
- 순서 보장  
- 신뢰할 수 있는 프로토콜 / 현재는 대부분 TCP사용  

<h2>TCP 3 way handshake</h2>
1. 클라이언트 -> 서버: SYN  

2. 서버 -> 클라이언트: SYN + ACK  

3. 클라이언트 -> 서버: ACK  

- SYN: 접속 요청  
- ACK: 요청 수락  

---

<h1>UDP(User Datagram Protocol)</h1>

<h2>UDP 특징</h2>
- 하얀 도화지에 비유(기능이 거의 없음:PORT기능이 끝)  
- 연결지향 - TCP 3way handshake X  
- 데이터 전달 보증 X  
- 순서 보장 X  
- 데이터 전달 및 순서가 보장되진 않지만, 단순하고 빠름  
- 정리: IP와 거의 같다 + PORT -> 애플리케이션에서 추가 작업 필요  
---

<h1>PORT</h1>
한 IP로 한번에 둘 이상 연결해야 한다면? -> PORT가 이 문제를 해결  
- 0~65535할당 가능  
- 0~1023: 잘 알려진 포트, 사용하지 않는 것이 좋음  
- FTP:20,21 / TELNET:23 / HTTP:80 / HTTPS:443  

<h2>PORT의 역할</h2>
- 같은 IP내에서 프로세스 구분<br>
- 게임=PORT9080 / 화상통화=PORT21000 / 웹브라우저=PORT10010  

---

<h1>DNS(Domain Name System)</h1>
IP주소는 기억하기 어렵다 / IP주소는 변경 될 수 있다 -> 이를 해결해 주는 것이 DNS  

- 전화번호부에 비유  
- 도메인 명을 IP주소로 변환시켜줌  

<h2>DNS 원리</h2>
1. 클라이언트에서 도메인 명 입력
2. 도메인의 실제 IP주소를 반환받음
3. 서버로 IP주소 전달해서 응답받음

---

<h1>URI(Uniform Resource Identifier)</h1>
URI = URL(Locator) + URN(Name)  

<h2>문법</h2>
- scheme://[userinfo@]host[:port][/path][?query][#fragment]]  
- https://www.google.com:443/search?q=hello&hl=ko

<br>

- 프로토콜(https)
- 호스트명(www.google.com)
- 포트 번호(443)
- 패스(/search)
- 쿼리 파라미터(q=hello&hl=ko)

---
<h1>HTTP의 특징</h1>
- 클라이언트/서버 구조<br>
- 무상태 프로토콜(StateLess), 비연결성<br>
- HTTP 메시지<br>
- 단순함 확장 가능  

<hr>

<h2>클라이언트 서버 구조</h2>
- Request / Response 구조  
- 클라리언트는 서버에 요청을 보내고, 응답을 대기  
- 서버가 요청에 대한 결과를 만들어서 응답  

<hr>

<h2>무상태 프로토콜(Stateless)</h2>
- 서버가 클라이언트의 상태를 보존X  
- 장점: 서버 확장성 높음(스케일 아웃)  
- 단점: 클라리언트가 추가 데이터 전송  

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
# HTTP 메서드

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
<h1>HTTP 메서드의 속성</h1>

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
<h1></h1>
--------------------------------------------------------------------
<h1></h1>
--------------------------------------------------------------------
<h1></h1>
--------------------------------------------------------------------
<h1></h1>
--------------------------------------------------------------------
<h1></h1>
--------------------------------------------------------------------
<h1></h1>
--------------------------------------------------------------------
<h1></h1>
--------------------------------------------------------------------
<h1></h1>
--------------------------------------------------------------------
<h1></h1>
