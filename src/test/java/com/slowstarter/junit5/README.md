
# JUnit5
## 3. Writing Tests
### 3.12. Test Interfaces and Default Methods

* JUnit Jupiter는 interface 의 default method에 아래의 어노테이션들을 허용합니다.

> @Test, @RepeatedTest, @ParameterizedTest, @TestFactory, @TestTemplate, @BeforeEach @AfterEach

* @BeforeAll 및 @AfterAll은 테스트 인터페이스 또는 테스트 클래스가 @TestInstance(Lifecycle.PER_CLASS)로 어노테이션이 선언 된 경우 
  테스트 인터페이스의 static-method 나 인터페이스 default-method 에서 선언 할 수 있습니다.

```sh
@TestInstance(Lifecycle.PER_CLASS)
interface TestLifecycleLogger {

    static final Logger LOG = Logger.getLogger(TestLifecycleLogger.class.getName());

    @BeforeAll
    default void beforeAllTests() {
        LOG.info("Before all tests");
    }

    @AfterAll
    default void afterAllTests() {
        LOG.info("After all tests");
    }

    @BeforeEach
    default void beforeEachTest(TestInfo testInfo) {
        LOG.info(() -> String.format("About to execute [%s]",
            testInfo.getDisplayName()));
    }

    @AfterEach
    default void afterEachTest(TestInfo testInfo) {
        LOG.info(() -> String.format("Finished executing [%s]",
            testInfo.getDisplayName()));
    }

}
```

```sh
interface TestInterfaceDynamicTestsDemo {

    @TestFactory
    default Collection<DynamicTest> dynamicTestsFromCollection() {
        return Arrays.asList(
            dynamicTest("1st dynamic test in test interface", () -> assertTrue(true)),
            dynamicTest("2nd dynamic test in test interface", () -> assertEquals(4, 2 * 2))
        );
    }

}
```

* @ExtendWith 와 @Tag 는 테스트-인터페이스에 선언될 수 있는, 인터페이스를 구현한 클래스는 자동으로 인터페이스의 tags와 extentions을 자동으로 상속합니다.

```sh
@Tag("timed")
@ExtendWith(TimingExtension.class)
interface TimeExecutionLogger {
}
```

```sh
class TestInterfaceDemo implements TestLifecycleLogger,
        TimeExecutionLogger, TestInterfaceDynamicTestsDemo {

    @Test
    void isEqualValue() {
        assertEquals(1, 1, "is always equal");
    }

}
```

```sh
```

```sh
```