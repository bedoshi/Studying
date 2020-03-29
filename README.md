# Studying
This is for my friend's studying SpringBoot. I'm teaching SpringBoot with making sample code.

## Sample list
This Repository has some sample codes like below.
- `@RestController` and the test codes with using MvcMock.
- Getting parameter from url with `@PathVariable`.
- Getting parameter from request parameter with `@RequestParam`
- Mocking a class with `Mockito`.
    - Defining mock's operation.
    - Verifying calls count of component method as repository with using `@Mock` and `@InjectMocks`.
- Testing repository class with `mybatis`
    - insert
    - select
- Testing repository class with `DBUnit`
    - `@DatabaseSetup` for preparing table data.
    - Control for rollback test data with `@Transactional` after test executed. 
## How to run on your local ?
1. Clone this repository.
2. Change directory to cloned one.
3. Run `mvn install`. Run `brew install maven` or install maven if your env doesn't have maven.
4. Run `mvn spring-boot:run`
