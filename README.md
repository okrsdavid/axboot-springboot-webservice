# AxBoot 스프링부트 웹서비스 만들기

예제 코드

## 프로젝트 환경 점검

이 예제는 다음의 환경에서 진행됩니다.

* Java 8
* Maven 3.x
* Spring Boot 1.5.x

### Maven 버전 체크

먼저 현재 프로젝트의 그레이들 버전을 체크해봅니다.

```bash
mvn -v
```

### Spring Boot 버전 체크

Spring Boot 버전은 다음과 같이 되어있어야 합니다.  

**pom.xml**  

```xml
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.5.4.RELEASE</version>
    </parent>
```

### 실행
```bash
mvn spring-boot:run
// => http://localhost:8080

* 처음 시작시 `http://localhost:8080/setup`에서 스키마 및 데이터베이스 생성
```