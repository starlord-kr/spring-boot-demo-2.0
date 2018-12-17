
# JUnit5
## 3. Writing Tests
### 3.13. Repeated Tests

* JUnit Jupiter는 @RepeatedTest를 메소드에 어노테이션하여 원하는 반복횟수를 지정하여 특정 횟수만큼 테스트를 반복 할 수있는 능력을 제공합니다.
반복 테스트의 각 호출은 동일한 라이프 사이클 콜백 및 확장을 완벽하게 지원하는 일반 @Test 메소드의 실행과 같이 동작합니다.
* 다음 예제에서는 자동으로 10 번 반복되는 repeatedTest ()라는 테스트를 선언하는 방법을 보여줍니다.

```sh
@RepeatedTest(10)
void repeatedTest() {
    // ...
}
```
>반복 횟수를 지정하는 것 외에도 @RepeatedTest 주석의 name 속성을 통해 각 반복에 대해 사용자 정의 표시 이름을 구성 할 수 있습니다.
 또한 표시 이름은 static-text와 dynamic-placeholder의 조합으로 구성된 패턴이 될 수 있습니다. 다음의 placeholder들이 현재 제공됩니다.

- {displayName}: display name of the @RepeatedTest method
- {currentRepetition}: the current repetition count
- {totalRepetitions}: the total number of repetitions

>  주어진 반복에 대한 기본 display-name은 다음과 같은 패턴을 기반으로 생성됩니다.
> "repetition {currentRepetition} of {totalRepetitions}". 
> 따라서 previousTest () 예제의 개별 반복에 대한 display-name 은 다음과 같습니다.
> repetition 1 of 10, repetition 2 of 10, etc.
> 각 반복의 이름에 @RepeatedTest 메소드의 display-name을 포함 시키려면, 
> 사용자 정의 패턴을 정의하거나 미리 정의 된 RepeatedTest.LONG_DISPLAY_NAME 패턴을 사용할 수 있습니다.
> 문자패턴은 다음과 동일하고 "{displayName} :: repetition {currentRepetition} of {totalRepetitions}"
> 각각의 반복에 대한 display-name 의 결과는 repeatedTest() :: repetition 1 of 10, repeatedTest() :: repetition 2 of 10 입니다.

* 현재 반복과 전체 반복 횟수의 정보를 프로그램에따라서 가져오기 위해서는,
  개발자는 RepetitionInfo의 인스턴스를 @RepeatedTest, @BeforeEach 또는 @AfterEach 메서드에 삽입하도록 선택할 수 있습니다.

#### 3.13.1. Repeated Test Examples
이 단원의 끝에있는 RepeatedTestsDemo 클래스는 반복되는 테스트의 몇 가지 예를 보여줍니다.

repeatedTest () 메서드는 이전 섹션의 예제와 동일합니다. 반면에 repeatedTestWithRepetitionInfo ()는
반복 테스트의 총 반복 횟수에 액세스하기 위해 테스트에 RepetitionInfo의 인스턴스를 삽입하는 방법을 보여줍니다.

다음 두 메서드는 각 반복의 표시 이름에 @RepeatedTest 메서드에 대한 사용자 지정 @DisplayName을 포함하는 방법을 보여줍니다.
customDisplayName ()은 사용자 지정 표시 이름을 사용자 지정 패턴과 결합한 다음 TestInfo를 사용하여 생성 된 표시 이름의 형식을 확인합니다.

Repeat! 은 {displayName}인데 @DisplayName 어노테이션 선언에 의한 것이며, 
1/1 은 {currentRepetition}/{totalRepetitions} 로 부터 기인한 것입니다.

대조적으로 customDisplayNameWithLongPattern ()은 앞서 정의 된 RepeatedTest.LONG_DISPLAY_NAME 패턴을 사용합니다.

repeatedTestInGerman ()은 반복 된 테스트의 표시 이름을 외국어 (이 경우 독일어)로 번역하여 다음과 같은 개별 반복의 이름을 얻는 기능을 보여줍니다.
: Wiederholung 1 von 5, Wiederholung 2 von 5, etc.

beforeEach() 메소드는 @BeforeEach로 어노테이션 처리되었으므로 각 반복 테스트가 반복 될 때마다 실행됩니다.
메소드에 TestInfo와 RepetitionInfo를 삽입함으로써, 현재 실행중인 반복 테스트에 대한 정보를 얻을 수 있음을 알 수 있습니다.
INFO 로그 수준이 활성화 된 상태에서 RepeatedTestsDemo를 실행하면 다음과 같은 결과가 출력됩니다.

```sh
INFO: About to execute repetition 1 of 10 for repeatedTest
INFO: About to execute repetition 2 of 10 for repeatedTest
INFO: About to execute repetition 3 of 10 for repeatedTest
INFO: About to execute repetition 4 of 10 for repeatedTest
INFO: About to execute repetition 5 of 10 for repeatedTest
INFO: About to execute repetition 6 of 10 for repeatedTest
INFO: About to execute repetition 7 of 10 for repeatedTest
INFO: About to execute repetition 8 of 10 for repeatedTest
INFO: About to execute repetition 9 of 10 for repeatedTest
INFO: About to execute repetition 10 of 10 for repeatedTest
INFO: About to execute repetition 1 of 5 for repeatedTestWithRepetitionInfo
INFO: About to execute repetition 2 of 5 for repeatedTestWithRepetitionInfo
INFO: About to execute repetition 3 of 5 for repeatedTestWithRepetitionInfo
INFO: About to execute repetition 4 of 5 for repeatedTestWithRepetitionInfo
INFO: About to execute repetition 5 of 5 for repeatedTestWithRepetitionInfo
INFO: About to execute repetition 1 of 1 for customDisplayName
INFO: About to execute repetition 1 of 1 for customDisplayNameWithLongPattern
INFO: About to execute repetition 1 of 5 for repeatedTestInGerman
INFO: About to execute repetition 2 of 5 for repeatedTestInGerman
INFO: About to execute repetition 3 of 5 for repeatedTestInGerman
INFO: About to execute repetition 4 of 5 for repeatedTestInGerman
INFO: About to execute repetition 5 of 5 for repeatedTestInGerman
```

```sh
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

class RepeatedTestsDemo {

    private Logger logger = // ...

    @BeforeEach
    void beforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        int currentRepetition = repetitionInfo.getCurrentRepetition();
        int totalRepetitions = repetitionInfo.getTotalRepetitions();
        String methodName = testInfo.getTestMethod().get().getName();
        logger.info(String.format("About to execute repetition %d of %d for %s", //
            currentRepetition, totalRepetitions, methodName));
    }

    @RepeatedTest(10)
    void repeatedTest() {
        // ...
    }

    @RepeatedTest(5)
    void repeatedTestWithRepetitionInfo(RepetitionInfo repetitionInfo) {
        assertEquals(5, repetitionInfo.getTotalRepetitions());
    }

    @RepeatedTest(value = 1, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Repeat!")
    void customDisplayName(TestInfo testInfo) {
        assertEquals(testInfo.getDisplayName(), "Repeat! 1/1");
    }

    @RepeatedTest(value = 1, name = RepeatedTest.LONG_DISPLAY_NAME)
    @DisplayName("Details...")
    void customDisplayNameWithLongPattern(TestInfo testInfo) {
        assertEquals(testInfo.getDisplayName(), "Details... :: repetition 1 of 1");
    }

    @RepeatedTest(value = 5, name = "Wiederholung {currentRepetition} von {totalRepetitions}")
    void repeatedTestInGerman() {
        // ...
    }

}
```

* 유니 코드 테마가 활성화 된 상태에서 ConsoleLauncher 를 사용하면 RepeatedTestsDemo를 실행하면 콘솔에 다음과 같은 결과가 표시됩니다.

```sh
├─ RepeatedTestsDemo ✔
│  ├─ repeatedTest() ✔
│  │  ├─ repetition 1 of 10 ✔
│  │  ├─ repetition 2 of 10 ✔
│  │  ├─ repetition 3 of 10 ✔
│  │  ├─ repetition 4 of 10 ✔
│  │  ├─ repetition 5 of 10 ✔
│  │  ├─ repetition 6 of 10 ✔
│  │  ├─ repetition 7 of 10 ✔
│  │  ├─ repetition 8 of 10 ✔
│  │  ├─ repetition 9 of 10 ✔
│  │  └─ repetition 10 of 10 ✔
│  ├─ repeatedTestWithRepetitionInfo(RepetitionInfo) ✔
│  │  ├─ repetition 1 of 5 ✔
│  │  ├─ repetition 2 of 5 ✔
│  │  ├─ repetition 3 of 5 ✔
│  │  ├─ repetition 4 of 5 ✔
│  │  └─ repetition 5 of 5 ✔
│  ├─ Repeat! ✔
│  │  └─ Repeat! 1/1 ✔
│  ├─ Details... ✔
│  │  └─ Details... :: repetition 1 of 1 ✔
│  └─ repeatedTestInGerman() ✔
│     ├─ Wiederholung 1 von 5 ✔
│     ├─ Wiederholung 2 von 5 ✔
│     ├─ Wiederholung 3 von 5 ✔
│     ├─ Wiederholung 4 von 5 ✔
│     └─ Wiederholung 5 von 5 ✔
```
