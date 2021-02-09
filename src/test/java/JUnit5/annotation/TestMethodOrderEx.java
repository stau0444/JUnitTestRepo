package JUnit5.annotation;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestMethodOrderEx{
    @Order(3)
    @Test
    void test1(){
        System.out.println("test1");
    }
    @Order(1)
    @Test
    void test3(){
        System.out.println("test3");
    }

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class NestedTest{
        @Order(4)
        @Test
        void test2(){
            System.out.println("test2");
        }

        @Order(2)
        @Test
        void test4(){
            System.out.println("test4");
        }
    }
}
