# 환율 관리

## API 명세서


#### 1. User CRUD

##### 유저 생성
- **URL**: `/api/users`
- **Method**: `POST`
- **상태코드**: '201 Created, 400 Bad Request'
- **요청**



  |이름|타입|설명|필수|
  |:----:|:----:|:-------:|:--:|
  |email|String|사용자 이름|O|
  |name|String|일정 제목|O|

  ```json
  {
    "email": "1234@naver.com",
    "name": "유저1"
  }
- **응답**

  
  |이름|타입|설명|
  |:----:|:----:|:-------:|
  |userId|long|일정 고유 아이디 생성|
  |email|String| 이메일 확인 |
  |name|String| 이름 확인 |
  |createdAt|LocalDateTime| 유저 생성 날짜 저장 |
  |modifiedAt|LocalDate| 유저 정보 수정 날짜 저장 |
  
  ```json
  {
    "userId": "1",
    "email": "1234@naver.com",
    "name": "유저1",
    "createdAt": "2024-10-31",
    "modifiedAt": "2024-11-01"
  }

##### 전체 유저 조회
- **URL**: `/api/users`
- **Method**: `GET`
- **상태코드**: '200 Ok, 404 Not Found'

- **응답**

  
  |이름|타입|설명|
  |:----:|:----:|:-------:|
  |email|String|이메일 확인|
  |name|String|이름 확인|
  |createdAt|LocalDate|일정 생성 날짜 확인|
  |modifiedAt|LocalDate|일정 수정 날짜 확인|
  ```json
  {
    "email": "1234@naver.com", 
    "name": "유저1",
    "createdAt": "2024-10-31",
    "modifiedAt": "2024-11-01"
  },
  {
    "email": "4321@naver.com", 
    "name": "유저2",
    "createdAt": "2024-10-31",
    "modifiedAt": "2024-11-01"
  }



##### 선택 유저 조회
- **URL**: `/api/users/{userId}`
- **Method**: `GET`
- **상태코드**: '200 Ok, 404 Not Found'
- **요청**

  

- **응답**

  
  |이름|타입|설명|
  |:----:|:----:|:-------:|
  |userId|integer|유저 고유 아이디 확인|
  |name|String|이름 확인|
  |createdAt|LocalDate|일정 생성 날짜 확인|
  |modifiedAt|LocalDate|일정 수정 날짜 확인|
  ```json
  {
    "userId": "1", 
    "name": "유저1",
    "createdAt": "2024-10-31",
    "modifiedAt": "2024-11-01"
  }
  
##### 선택 유저 수정
- **URL**: `/api/users/{userId}`
- **Method**: `PUT`
- **상태코드**: '200 Ok, 404 Not Found'
- **요청**

  
  |이름|타입|설명|필수|
  |:----:|:----:|:-------:|
  |name|String|수정 할 이름|
  ```json
  {
    "name": "사용자1"
  }
- **응답**

  
  |이름|타입|설명|
  |:----:|:----:|:-------:|
  |message|String|수정 완료시 알림|
  |name|String|이름 수정|
  |modifiedAt|LocalDate|일정 수정 날짜 갱신|
  ```json
  {
    "message": "수정이 완료 되었습니다",
    "name": "유저1"
    "modifiedAt": "2024-11-02"
  }

  
##### 선택 유저 삭제
- **URL**: `/api/users/{userId}`
- **Method**: `DELETE`
- **상태코드**: '404 Not Found'
- **요청**
- **응답**

  
  |이름|타입|설명|
  |:----:|:----:|:-------:|
  |message|String|삭제 완료시 알림|

  ```json
  {
    "message": "유저가 삭제 완료 되었습니다"
  }

#### 2. Currnecy CRUD

##### 환율 생성
- **URL**: `/api/currency`
- **Method**: `POST`
- **상태코드**: '201 Created, 400 Bad Request'
- **요청**



  |이름|타입|설명|필수|
  |:----:|:----:|:-------:|:--:|
  |exchangeRate|BigDecimal|환율|O|
  |currencyName|String|통화 이름|O|
  |sybmol|String|표시|O|

  ```json
  {
    "exchangeRate": "1430.00",
    "currencyName": "USD",
    "symbol": "$",
  }
- **응답**

  
  |이름|타입|설명|
  |:----:|:----:|:-------:|
  |currencyId|long|통화 고유 식별자 생성|
  |exchangeRate|BigDecimal| 환율 확인 |
  |currencyName|String| 통화 이름 확인 |
  |sybmol|String|표시 확인|
  |createdAt|LocalDateTime| 통화 생성 날짜 저장 |
  |modifiedAt|LocalDate| 통화 정보 수정 날짜 저장 |
  
  ```json
  {
    "currnecyId": "1",
    "exchangeRate": "1430.00",
    "currencyName": "USD",
    "symbol": "$",
    "createdAt": "2024-10-31",
    "modifiedAt": "2024-11-01"
  }

##### 전체 환율 조회
- **URL**: `/api/currency`
- **Method**: `GET`
- **상태코드**: '200 Ok, 404 Not Found'

- **응답**

  
  |이름|타입|설명|
  |:----:|:----:|:-------:|
  |exchangeRate|BigDecimal| 환율 확인 |
  |currencyName|String| 통화 이름 확인 |
  |sybmol|String|표시 확인|
  
  ```json
  {
    "exchangeRate": "1430.00",
    "currencyName": "USD",
    "symbol": "$"
  },
  {
    "exchangeRate": "9.20",
    "currencyName": "JPY",
    "symbol": "￥"
  }



##### 선택 환율 조회
- **URL**: `/api/currency/{currencyId}`
- **Method**: `GET`
- **상태코드**: '200 Ok, 404 Not Found'
- **요청**

  

- **응답**

  
  |이름|타입|설명|
  |:----:|:----:|:-------:|
  |exchangeRate|BigDecimal| 환율 확인 |
  |currencyName|String| 통화 이름 확인 |
  |sybmol|String|표시 확인|
  |createdAt|LocalDateTime| 통화 생성 날짜 저장 |
  |modifiedAt|LocalDate| 통화 정보 수정 날짜 저장 |
  
  ```json
  {
    "exchangeRate": "1430.00",
    "currencyName": "USD",
    "symbol": "$",
    "createdAt": "2024-10-31",
    "modifiedAt": "2024-11-01"
  }
  
##### 선택 환율 수정
- **URL**: `/api/currnecy/{currencyId}`
- **Method**: `PUT`
- **상태코드**: '200 Ok, 404 Not Found'
- **요청**

  
  |이름|타입|설명|필수|
  |:----:|:----:|:-------:|
  |name|String|수정 할 이름|
  ```json
  {
    "exchangeRate": "995.50",
    "currencyName": "CAD",
    "symbol": "CA$"
  }
- **응답**

  
  |이름|타입|설명|
  |:----:|:----:|:-------:|
  |message|String| 수정 확인 메세지 |
  |exchangeRate|BigDecimal| 환율 확인 |
  |currencyName|String| 통화 이름 확인 |
  |sybmol|String|표시 확인|
  |createdAt|LocalDateTime| 통화 생성 날짜 저장 |
  |modifiedAt|LocalDate| 통화 정보 수정 날짜 저장 |
  
  ```json
  {
    "message": "수정이 완료 되었습니다"
    "exchangeRate": "995.50",
    "currencyName": "CAD",
    "symbol": "CA$",
    "createdAt": "2024-10-31",
    "modifiedAt": "2024-11-01"
  }

  
##### 선택 통화 삭제
- **URL**: `/api/currency/{currencyId}`
- **Method**: `DELETE`
- **상태코드**: '404 Not Found'
- **요청**
- **응답**

  
  |이름|타입|설명|
  |:----:|:----:|:-------:|
  |message|String|삭제 완료시 알림|

  ```json
  {
    "message": "통화가 삭제 완료 되었습니다"
  }


#### 3. Exchage Request CRUD

##### 환전 요청 생성
- **URL**: `/api/exchangeRequests`
- **Method**: `POST`
- **상태코드**: '201 Created, 400 Bad Request'
- **요청**



  |이름|타입|설명|필수|
  |:----:|:----:|:-------:|:--:|
  |userId|long|환전 요청한 유저 아이디|O|
  |currencyId|long|환전 대상 통화 아이디|O|
  |amountInKrw|int|환전 전 금액|O|
  

  ```json
  {
    "userId": "1",
    "currencyId": "1",
    "amountInKrw": "10000",
  }
- **응답**

  
  |이름|타입|설명|
  |:----:|:----:|:-------:|
  |requestId|long|환전 요청 고유 식별자 생성|
  |userId|long|환전 요청한 유저 아이디 확인|
  |currencyId|long|통화 고유 식별자 확인|
  |amountInKrw|int|환전 전 금액 확인|
  |amountAfterExchange|int| 환전 후 금액 확인|
  |status|String| 상태 확인 |
  |createdAt|LocalDateTime| 환전 요청 생성 날짜 저장 |
  |modifiedAt|LocalDate| 환전 요청 수정 날짜 저장 |
  
  ```json
  {
    "requestId": "1",
    "userId": "1",
    "currnecyId": "1",
    "amountInKrw": "10000",
    "amountAfterExchange": "6.99",
    "status": "normal",
    "createdAt": "2024-10-31",
    "modifiedAt": "2024-11-01"
  }



##### 특정 고객의 모든 환전 요청 조회
- **URL**: `/api/exchangeRequests/user/{userId}`
- **Method**: `GET`
- **상태코드**: '200 Ok, 404 Not Found'
- **요청**

  

- **응답**

  |이름|타입|설명|
  |:----:|:----:|:-------:|
  |requestId|long|환전 요청 고유 식별자 생성|
  |userId|long|환전 요청한 유저 아이디 확인|
  |currencyId|long|통화 고유 식별자 확인|
  |amountInKrw|int|환전 전 금액 확인|
  |amountAfterExchange|BigDecimal| 환전 후 금액 확인|
  |status|String| 상태 확인 |
  |createdAt|LocalDateTime| 환전 요청 생성 날짜 저장 |
  |modifiedAt|LocalDate| 환전 요청 수정 날짜 저장 |
  
  ```json
  {
    "requestId": "1",
    "userId": "1",
    "currnecyId": "1",
    "amountInKrw": "10000",
    "amountAfterExchange": "6.99",
    "status": "normal",
    "createdAt": "2024-10-31",
    "modifiedAt": "2024-11-01"
  },
  {
    "requestId": "2",
    "userId": "1",
    "currnecyId": "2",
    "amountInKrw": "10000",
    "amountAfterExchange": "1086.96",
    "status": "normal",
    "createdAt": "2024-10-31",
    "modifiedAt": "2024-11-01"
  }

  
##### 특전 환전 요청 상태 수정
- **URL**: `/api/exchangeRequests/{requestId}/cancel
- **Method**: `PATCH`
- **상태코드**: '200 Ok, 404 Not Found'
- **요청**

- **응답**

  |이름|타입|설명|
  |:----:|:----:|:-------:|
  |requestId|long|환전 요청 고유 식별자 생성|
  |userId|long|환전 요청한 유저 아이디 확인|
  |currencyId|long|통화 고유 식별자 확인|
  |amountInKrw|int|환전 전 금액 확인|
  |amountAfterExchange|BigDecimal| 환전 후 금액 확인|
  |status|String| 상태 확인 |
  |createdAt|LocalDateTime| 환전 요청 생성 날짜 저장 |
  |modifiedAt|LocalDate| 환전 요청 수정 날짜 저장 |
  
  ```json
  {
    "requestId": "1",
    "userId": "1",
    "currnecyId": "1",
    "amountInKrw": "10000",
    "amountAfterExchange": "6.99",
    "status": "cancelled",
    "createdAt": "2024-10-31",
    "modifiedAt": "2024-11-01"
  }


  
##### 고객 삭제 시 관련 환전 요청 삭제
- **URL**: `/api/users/{userId}`
- **Method**: `DELETE`
- **상태코드**: '404 Not Found'
- **요청**
- **응답**

  
  |이름|타입|설명|
  |:----:|:----:|:-------:|
  |message|String|삭제 완료시 알림|

  ```json
  {
    "message": "유저와 관랸 기록이 삭제 완료 되었습니다"
  }


## ERD
![Currency](https://github.com/user-attachments/assets/9d7f5f92-e50c-4746-ba6a-78f879a04997)


