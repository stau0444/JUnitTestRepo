package JUnit5;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class DisplayNameGenrationTest {

    class ReplaceUnderscoreGenerator extends DisplayNameGenerator.Standard{

    }
    @Test
    void Test_Display_Name_Gen(){

    }
}
