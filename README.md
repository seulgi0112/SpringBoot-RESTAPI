# SpringBoot-RESTAPI

### 프로젝트 환경

✔ Project: Gradle Project

✔ Spring Boot: 2.5.0

✔ Language: Java 11

✔ Packaging: war

✔ Dependencies: Spring Web, Thymeleaf,Lombok, JDBC API, Spring Security, Validation, Spring Batch, Spring Boot Actuator, OAuth2 Client, Spring Configuration Processor, MyBatis Framework

✔ Test: JUnit5

✔ IDE : Eclipse  



-------------------------------

### 👓 Spring MVC 구조

스프링 MVC는 DispatcherServlet, View Resolver, Handler, View 등으로 구성

🎈 **MVC 요청 처리 흐름**

1. 클라이언트 요청 -> DispatcherServlet

2. Handler이름을 처리할 수 있는지 HandlerMapping에게 물어본다. 

3. HandlerMapping에서 요청 URL을 비롯한 정보들로 Handler판단

4. DispatcherServlet은 HandlerMapping 으로 부터 받은 Handler에게 요청을 보낸다.

5. Handler는 요청을 적절히 처리하고 ViewName을 판단해서 DispatcherServlet에게 전송

6. DispatcherServlet은 ViewName을 View Resolver에 전달

7. ViewResolver는 View를 생성해서 DispatcherServlet에 전달

8. DispatcherServlet은 해당하는 View에 Model전달

9. View는 Model을 참조해서 응답 생성

10. DispatcherServlet은 응답을 클라이언트에 반환

    

### 👓 Lombok

Lombok 라이브러리를 사용하면 annotation 설정만으로 추가 코드를 만들 수 있다!!

| Annotation               | 설명                                                         |
| ------------------------ | ------------------------------------------------------------ |
| @Getter / @Setter        | 객체의 Getter, Setter 생성                                   |
| @ToString                | toString() Method 생성                                       |
| @EqualsAndHashCode       | equals(), hashcode() Method 생성                             |
| @RequiredArgsConstructor | @NonNull이 적용된 필드값이나 final로 선언된 필드값만 인자로 받는 생성자 생성 |
| @AllArgsConstructor      | 객체의 모든 필드값을 인자로 받는 생성자 생성                 |
| @Data                    | @ToString, @Getter, @Setter, @EqualsAndHashCode, @RequireArgsConstructor 을 합친것 |
| @Builder                 | 빌더 패턴 사용 가능                                          |



### 👓 REST API

@RestController 

 - @Controller과 @ResponseBody를 합쳐놓은 Annotation

 - 클래스 상단에 @RestController Annotation을 선언하면 메서드마다 붙여주지 않아도 된다.

   

   **🎈HTTP Method에 따른 Annotation**

   | GET        | @GetMapping        |
   | ---------- | ------------------ |
   | **POST**   | **@PostMapping**   |
   | **PUT**    | **@PutMapping**    |
   | **DELETE** | **@DeleteMapping** |



**📢 Swagger 사용**

Swagger는 REST API 문서를 만들어주는 프레임워크

1. build.gradle에 추가

	implementation group: 'io.springfox', name: 'springfox-swagger-ui', version: '2.9.2'
	implementation group: 'io.springfox', name: 'springfox-swagger2', version: '2.9.2'

2. SwaggerConfig.java*(src/main/java/com/demo/config/SwaggerConfig.java)*를 만들어서 Swagger 설정
3. swagger-ui.html 에서 Swgger 문서 생성 확인



### 👓 Controller 요청 처리

✔ @PathVareable : URL에서 변수 값

✔ @RequestParam : 요청 파라미터 값

✔ @RequestHeader : 요청 헤더 값

✔ @RequestBody : 요청 본문 내용 

✔ @CookieValue :  쿠키 값



### 👓 입력 유효성 검증

스프링의 Bean Validation 기능을 이용해 도메인 클래스의 입력값을 검증할 수 있다. 

controller에서 입력값을 검증할 도메인에 @Validated를 지정해서 사용한다.

build.gradle에 아래 dependencies를 추가해준다.

`implementation 'org.springframework.boot:spring-boot-starter-validation'`



**❓ 입력값 검증 Annotation**

@NotBlank : null이 아니고 trim한 길이가 0보다 큰지 검사

@NotNull : 빈 값이 아닌지 검사

@Size(max = 3) : 길이 검사

@Email : 이메일 형식 검사

@Past : 과거 날짜인지 검사

@Future : 미 래날짜인지 검사

**❓ 오류 처리 Annotation**

@hasErrors() : 오류 확인

@hasGlobalErrors() : 객체 레벨의 오류 확인

@hasFieldErrors() : 필드 레벨의 오류 확인

@hasFieldErrors(String) : 인수에 지정한 필드 오류 확인