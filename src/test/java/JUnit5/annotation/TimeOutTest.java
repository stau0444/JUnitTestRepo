package JUnit5.annotation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class TimeOutTest {
    @Test
    @Timeout(5)
    void timeoutTest() throws InterruptedException {
        System.out.println("테스트 실행됨");
        //8초 sleep 시킴  timeout이 5이기 때문에 5초에서 테스트 종료 됨
        TimeUnit.SECONDS.sleep(8);
    }
    //아래와 같이 timeout의 인자를 지정할 수도 있다.
    @Test
    @Timeout(value = 500 ,unit = TimeUnit.SECONDS)
    void timeoutTest2(){

    }
}
