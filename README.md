# busService
공공 데이터 포털을 이용한 서울시 버스 위치 정보 조회 OpenAPI 연동

## 📄 OpenAPI 정보

- 출처 : 공공 데이터 포털
- 인증 : 서비스 Key
- 메시지 레벨 암호화 : 없음
- 전송 레벨 암호화 : 없음
- 인터페이스 표준 : REST(GET)
- 교환 데이터 표준 : JSON, XML (JSON 선택)
- 메시지 교환 유형 : Request-Response
- 이용 가이드

  [서울특별시_버스위치정보조회_서비스_활용가이드_20220725.pdf](https://prod-files-secure.s3.us-west-2.amazonaws.com/e6b1a268-9d6c-4daf-91bf-66e9a3f77dff/02a19088-0948-4ac7-bbea-01a528a9a376/%E1%84%89%E1%85%A5%E1%84%8B%E1%85%AE%E1%86%AF%E1%84%90%E1%85%B3%E1%86%A8%E1%84%87%E1%85%A7%E1%86%AF%E1%84%89%E1%85%B5_%E1%84%87%E1%85%A5%E1%84%89%E1%85%B3%E1%84%8B%E1%85%B1%E1%84%8E%E1%85%B5%E1%84%8C%E1%85%A5%E1%86%BC%E1%84%87%E1%85%A9%E1%84%8C%E1%85%A9%E1%84%92%E1%85%AC_%E1%84%89%E1%85%A5%E1%84%87%E1%85%B5%E1%84%89%E1%85%B3_%E1%84%92%E1%85%AA%E1%86%AF%E1%84%8B%E1%85%AD%E1%86%BC%E1%84%80%E1%85%A1%E1%84%8B%E1%85%B5%E1%84%83%E1%85%B3_20220725.pdf)


## 🔗 [연동 API 목록](https://github.com/hongkikii/busService/blob/main/src/main/java/com/study/busService/controller/BusLocationController.java)

| 일련번호 | API명(국문) | 상세기능명(영문) | 상세기능명(국문) | 상세 기능 설명 |
| --- | --- | --- | --- | --- |
| 1 | 버스위치정보조회 서비스 | getBusPosByRouteStList | 노선별특정정류소접근버스위치정보목록조회 | 노선ID와 구간정보로 차량들의 위치정보를 조회한다 |
| 2 | 버스위치정보조회 서비스 | getBusPosByRtidList | 노선버스위치정보목록조회 | 노선ID로 차량들의 위치정보를 조회한다 |
| 3 | 버스위치정보조회 서비스 | getBusPosByVehIdItem | 특정차량위치정보항목조회 | 차량ID로 위치정보를 조회한다 |
| 4 | 버스위치정보조회 서비스 | getLowBusPosByRouteStList | 교통약자전용노선별특정정류소접근버스위치정보목록조회 | 노선ID와 구간정보로 저상차량들의 위치정보를 조회한다 |
| 5 | 버스위치정보조회 서비스 | getLowBusPosByRtidList | 교통약자전용노선버스위치정보목록조회 | 노선ID로 저상버스들의 위치정보를 조회한다 |
