package JUnit5.annotation;

import JUnit5.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.extension.TestTemplateInvocationContextProvider;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void addition(){
        Assertions.assertEquals(2,calculator.add(1,1));
    }


    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void isLessThanFive (int a){
        assertTrue(a<5);
    }

    @RepeatedTest(10)
    void minusTest(){
        Assertions.assertEquals(1,calculator.minus(5,4));
    }

    @TestFactory
    Stream<DynamicTest> test(){
        class TestTemplate{
            String name;
            int age;
            String nationality;

            TestTemplate(String name, int age, String nationality){
                this.name = name;
                this.age = age;
                this.nationality = nationality;
            }
        }
        return Stream.of(
                new TestTemplate("감동란",20,"KOREA"),
                new TestTemplate("반숙란",19,"JAPAN")
        ).map(t-> dynamicTest("test"+t.name,()->{
            assertTrue(t.age>18,t.name+"'s age");
            assertEquals("KOREA",t.nationality,t.name + "'s nationality");
        }));
    }
    @DisplayName("디스플레이네임테스트")
    @Test
    void diplayNameTest(){
        System.out.println("displayname 테스트다");
    }

    @BeforeEach
    void BeforeEachTest(){
        System.out.println("before each가 실행됨");
    }
    @Test
    void AfterBeforeEach(){
        System.out.println("befor each 다음 실행되는 테스트");
    }
    @BeforeAll
    static void beforeAllTest(){
        System.out.println("beforeAll 실행됨");
    }
}
