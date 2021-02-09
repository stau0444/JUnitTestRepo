package JUnit5.annotation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class DisplayNameGenrationTest {

    //메서드의 displayname에  _이 없어진다.
    @Test
    void Test_Display_Name_Gen(){

    }
    @Test
    //DisplayName이 DisplayNameGeneration보다 우선 순위가 높다.
    @DisplayName("Test_Display_Name")
    void Test(){

    }
}
