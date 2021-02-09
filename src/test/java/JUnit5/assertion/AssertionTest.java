package JUnit5.assertion;

import JUnit5.Calculator;
import JUnit5.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Period;

import static java.time.Duration.ofMinutes;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionTest {

    private final Calculator calculator = new Calculator();
    private final Person person = new Person("ugo","hwang");

    @Test
    void standardAssertions(){
        assertEquals(2,calculator.add(1,1));
        //두번째 인자로 실패 메세지를 지정할 수 있다.
        assertEquals(4,calculator.multiple(2,2),"틀렸다");
        assertTrue('a'<'b',()->"틀렸다");
    }
    
    //그룹 Assertion 테스트
    @Test
    void groupedAssertions(){
        //그룹안에 하나만 실패해도 해당 메서드는 실패하게 되고
        //그룹화 된 Assertion에서는 모든 assertion이 실행되며 모든 실패는 함께 보고된다.
        assertAll("person",
                    ()->assertEquals("ugo",person.getFirstname()),
                    ()->assertEquals("hwag",person.getLastname())
                );
    }
    //코드 블록 내에 어설 션이 실패하면 동일한 블록의 후속코드는 건너뛴다.
    @Test
    void dependentAssertions(){
        assertAll("properties",
                () -> {

                    String firstName = person.getFirstname();
                    //null인지 테스트하는 Assertion
                    //여기서 Test가 실패하면 아래의 테스트는 모두 실행되지 않는다.
                    assertNotNull(firstName);
                    //여러개의 테스트를 한번에 구현하며 assertAll 안에 테스트중 하나만 실패해도 모두 실패한다.
                    assertAll("first name",
                            () -> assertTrue(firstName.startsWith("u")),
                            () -> assertTrue(firstName.endsWith("o"))
                    );
                },
                ()-> {
                    String lastName = person.getLastname();
                    assertNotNull(lastName);

                    assertAll("last name",
                            () -> assertTrue(lastName.startsWith("h")),
                            () -> assertTrue(lastName.endsWith("g"))
                    );
                });
    }

    @Test
    void exceptionTesting(){
        //발생할 예외에 대해서 test하고 예상하는 예외가 맞다면 Exceoption 변수에 담긴다
        Exception exception = assertThrows(ArithmeticException.class,
                ()->calculator.division(1,0));
        //위의 exception에서 message를 가져와 비교하였다.
        assertEquals("/ by zero",exception.getMessage());
    }

    @Test
    void timeoutNouExceeded(){
        //테스트 수행 시간을 지정한다 첫번째 인자로는 수행시간이고 , 두번째 인자로는 수행할 테스트이다. 
        assertTimeout(ofSeconds(1),()->{
            //2분안에 실행될 수 있는 것은 통과하고 그렇지 못하다면 테스트에 실패한다.
            Thread.sleep(2000);
        });
    }
    @Test
    void timeoutNotExceededWithResult() {
        //테스트 실행후 리턴값을 넘겨줄 수도 있다.
        //아래의 경우 만약 테스트가 2분아래라면  a result라는 문자열을 넘겨주게 되어있다.
        String actualResult = assertTimeout(ofMinutes(2), () -> {
            System.out.println("테스트");
            return "a result";
        });
        assertEquals("a result", actualResult);
    }
    //클래스 내의 static method를 불러와서 사용할 수도 있다.
    @Test
    void timeoutNotExceededWithMethod() {
        // 2번째 인자의 메서드가 지정한 시간내에 실행 되었을 경우 테스트에 성공하고 해당 메서드의 리턴값을 리턴해준다.
        String actualGreeting = assertTimeout(ofMinutes(2), AssertionTest::greeting);
        assertEquals("Hello, World!", actualGreeting);
    }
    private static String greeting() {
        return "Hello, World!";
    }
}
