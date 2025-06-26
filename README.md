# 간단한 주문-결제 프로젝트

## 프로젝트 목적

이 프로젝트는 마이크로서비스 아키텍처(MSA) 기반에서 각 도메인을 독립된 서비스로 분리하고, 이를 통해 다음의 기술 역량을 심화 학습하는 것을 목표로 합니다.

---

## 학습 목표

1. **코프링 (Kotlin + Spring)**
    - 순수 Kotlin 기반의 Spring 프로젝트 개발
    - Kotlin DSL 및 JPA, DI 등 Kotlin 스타일의 Spring 개발 방식 학습

2. **Spring Cloud**
    - 서비스 디스커버리(Eureka)와 Gateway 설정
    - 마이크로서비스 간 통신 구조 학습 (FeignClient, Kafka 등)

3. **헥사고날 아키텍처 (Hexagonal Architecture)**
    - 도메인 중심 개발
    - 외부 시스템과의 의존 분리 (inbound/outbound adapter 구조 학습)

---

## 기술 스택

- Kotlin
- Spring Boot 3.5.3
- Java 21
- Gradle (Kotlin DSL)
- Spring Cloud (Eureka, Gateway)
- H2 Database
- Docker (예정)
- Kafka (예정)

---

## 서비스 구성

### 1. user-service
- 사용자 도메인 서비스
- H2 데이터베이스를 통해 사용자 정보 관리
- Hexagonal 구조 기반으로 REST API 제공
- 등록된 유저 정보를 기반으로 주문 서비스와 연동
- 실행 포트: `8081`

### 2. order-service
- 주문 도메인 서비스
- 주문 생성 시 FeignClient로 유저 정보 검증
- Kafka 이벤트 발행 및 수신 예정
- 실행 포트: `8082`

### 3. discovery-server
- Spring Cloud Eureka 기반 서비스 디스커버리 서버
- 각 마이크로서비스를 Eureka Client로 등록하여 서비스 간 위치 식별 수행
- 실행 포트: `8761`

### 4. gateway-service
- Spring Cloud Gateway 기반 API Gateway
- 외부에서의 진입점을 통합적으로 관리
- 요청 라우팅 및 인증 로직 위치
- 실행 포트: `8000`

---

## 실행 방법

각 서비스는 독립적으로 실행 가능하며, 향후 `docker-compose`로 통합 컨테이너화 예정입니다.

```bash
# 예: user-service 실행
cd user-service
./gradlew bootRun
