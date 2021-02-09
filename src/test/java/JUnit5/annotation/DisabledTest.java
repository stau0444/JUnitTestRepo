package JUnit5.annotation;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


public class DisabledTest {
    @Test
    void test1(){
        System.out.println("test1 실행");
    }
    @Test
    @Disabled
    //실행되지 않는다
    void test2(){
        System.out.println("test2 실행");
    }
}
