package JUnit5.annotation;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;

@Tag("group1")
public class TagTest {

    @Test
    @Tag("group1")
    void test1(){
        System.out.println("test1-group1");
    }

    @Test
    @Tag("group1")
    void test2(){
        System.out.println("test1-group1");
    }

    @Test
    @Tag("group2")
    void test3(){
        System.out.println("test1-group2");
    }

    @Tag("group2")
    @Test
    void test4(){
        System.out.println("test1-group2");
    }
}
