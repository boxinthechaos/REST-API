# REST-API

## REST API란?
REST API란 REST를 기반으로 만들어진 API를 의미합니다.

## REST란?
REST(Representational State Transfer)의 약자로 자원을 이름으로 구분하여 해당 자원의 상태를 주고받는 모든 것을 의미합니다.

다시 말하자면
1. HTTP URI(Uniform Resource Identifier)를 통해 자원(Resource)을 명시하고,
2. HTTP Method(POST, GET, PUT, DELETE, PATCH 등)를 통해
3. 해당 자원(URI)에 대한 CRUD Operation을 적용하는 것을 의미합니다.

> CRUD Operation이란
> CRUD는 대부분의 컴퓨터 소프트웨어가 가지는 기본적인 데이터 처리 기능인 Create(생성), Read(읽기), Update(갱신), Delete(삭제)를 묶어서 일컫는 말로
> REST에서의 CRUD Operation 동작 예시는 다음과 같다.

```
Create : 데이터 생성(POST)
Read : 데이터 조회(GET)
Update : 데이터 수정(PUT, PATCH)
Delete : 데이터 삭제(DELETE)
```

## REST의 구성요소
REST는 다음과 같은 3가지로 구성이 되어있다. 
1. 자원(Resource) : HTTP URI
2. 자원에 대한 행위(Verb) : HTTP Method
3. 자원에 대한 행위의 내용 (Representations) : HTTP Message Pay Load

## REST의 특징
1. Server-Client(서버-클라이언트 구조)
2. Stateless(무상태)
3. Cacheable(캐시 처리 가능)
4. Layered System(계층화)
5. Uniform Interface(인터페이스 일관성)

## REST의 장단점
### 장점 
- 별도로 인프라 구축 할 필요가 없다
- HTTP 프로토콜의 표준을 최대한 활용하여 여러 추가적인 장점을 함께 가져갈 수 있게 해 준다.
- HTTP 표준 프로토콜에 따르는 모든 플랫폼에서 사용이 가능하다.
- Hypermedia API의 기본을 충실히 지키면서 범용성을 보장한다.
- REST API 메시지가 의도하는 바를 명확하게 나타내므로 의도하는 바를 쉽게 파악할 수 있다.
- 여러 가지 서비스 디자인에서 생길 수 있는 문제를 최소화한다.
- 서버와 클라이언트의 역할을 명확하게 분리한다.

## 단점
- 표준이 자체가 존재하지 않아 정의가 필요하다.
- HTTP Method 형태가 제한적이다.
- 브라우저를 통해 테스트할 일이 많은 서비스라면 쉽게 고칠 수 있는 URL보다 Header 정보의 값을 처리해야 하므로 전문성이 요구된다.
- 구형 브라우저에서 호환이 되지 않아 지원해주지 못하는 동작이 많다.(익스폴로어)

## REST API란?
RESPT API란 REST의 원리를 따르는 API를 의미합니다.
하지만 REST API를 올바르게 설계하기 위해서는 지켜야 하는 몇가지 규칙이 있으며 해당 규칙을 알아 보겠습니다.

## REST API 설계 예시
1. URI는 동사보다는 명사를, 대문자보다는 소문자를 사용하여야 한다.
2. 마지막에 슬래시 (/)를 포함하지 않는다.
3. 언더바 대신 하이폰을 사용한다.
4. 파일확장자는 URI에 포함하지 않는다.
5. 행위를 포함하지 않는다.

## RESTFUL이란?
RESTFUL이란 REST의 원리를 따르는 시스템을 의미합니다. 하지만 REST를 사용했다 하여 모두가 RESTful 한 것은 아닙니다.  
REST API의 설계 규칙을 올바르게 지킨 시스템을 RESTful하다 말할 수 있으며
모든 CRUD 기능을 POST로 처리 하는 API 혹은 URI 규칙을 올바르게 지키지 않은 API는 REST API의 설계 규칙을 올바르게 지키지 못한 시스템은 REST API를 사용하였지만 RESTful 하지 못한 시스템이라고 할 수 있습니다.
### 예시
1. 셀러의 정보를 조작하는 경우
   - 셀러 리스트 출력
     `[GET] /sellers`
   - 셀러 계정 생성
     `[POST] /sellers`
   - 1번 셀러 정보 수정
     `[PUT] /sellers/1`
   - 1번 셀러 삭제
     `[DELETE] /sellers/1`
2. 특정 셀러의 특정 자원을 조작하는 경우
   - 1번 셀러의 비밀번호 변경
     `[PUT] /sellers/1/password`
3. 상품 1차, 2차 카테고리 표출
   - 1차 카테고리 표출
     `[GET] /products/categories`
   - 2차 카테고리 표출
     `[GET] /products/categories/1`
     `[GET] /products/categories/2`

## URI, URL, URN이란 무엇일까?
URI와 URL은 혼동하기가 쉬운데 간단하게 말하자면 URL의 상위 개념이 URI이다

## URI란?
- URI는 Uniform Resource Identifier, 통합 자원 식별자의 줄임말이다.
- 즉, URI는 인터넷의 자원을 식별할 수 있는 문자열을 의미한다.
- URI의 하위 개념으로 URL과 URN이 있다.
- URI 중 URL, URN이라는 하위 개념을 만들어서 특별히 어떤 표준을 지켜서 자원을 식별하는 것이다.
- 결론은 URI라는 개념은 어떤 형식이 있다기 보다는 특정 자원을 식별하는 문자열을 의미한다.
- 그래서 URL이 아니고 URN도 아니면 그냥 URI가 되는 것이다.

## URL이란?
- URL은 Uniform Resource Locator의 줄임말이다.
- URL은 네트워크 상에서 리소스(웹 페이지, 이미지, 동영상 등의 파일)를 위치한 정보를 나타낸다.
- URL은 HTTP 프로토콜 뿐만아니라 FTP, SMTP 등 다른 프로토콜에서도 사용할 수 있다.
- URL은 웹 상의 주소를 나타내는 문자열이기 때문에 더 효율적으로 리소스에 접근하기 위해 클린한 URL 작성을 위한 방법론이다.

## URL구조
![image](https://github.com/user-attachments/assets/d30918d6-2a0c-4ede-83a3-1d5085d72555)
`scheme:[//[user[:password]@]host[:port]][/path][?query][#fragment]`
1. scheme : 사용할 프로토콜을 뜻하며 웹에서는 http 또는 https를 사용
2. user와 password : (서버에 있는) 데이터에 접근하기 위한 사용자의 이름과 비밀번호
3. host와 port : 접근할 대상(서버)의 호스트명과 포트번호
4. path : 접근할 대상(서버)의 경로에 대한 상세 정보
5. query : 접근할 대상에 전달하는 추가적인 정보 (파라미터)
6. fragment : 메인 리소스 내에 존재하는 서브 리소스에 접근할 때 이를 식별하기 위한 정보

## URN이란?
- URN은 Uniform Resource Name의 줄임말이다.
- URN은 URI의 표준 포맷 중 하나로, 이름으로 리소스를 특정하는 URI이다.
- http와 같은 프로토콜을 제외하고 리소스의 name을 가리키는데 사용된다.
- URN에는 리소스 접근방법과, 웹 상의 위치가 표기되지 않는다.
- 실제 자원을 찾기 위해서는 URN을 URL로 변환하여 이용한다.

## URL과 URN의 차이점
![image](https://github.com/user-attachments/assets/84c9bb68-2f23-43e8-8813-652f0f4bb736)
- URL은 어떻게 리소스를 얻을 것이고 어디에서 가져와야하는지 명시하는 URI이다.
- URN은 리소스를 어떻게 접근할 것인지 명시하지 않고 경로와 리소스 자체를 특정하는 것을 목표로하는 URI이다.
