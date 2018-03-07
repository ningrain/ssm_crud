package java.com.gta.enums;

import com.gta.enums.StatusCode;
import org.junit.Test;

import java.com.gta.BaseTest;

/**
 * StatusCode
 * Created by ningning.jiang on 2017/12/5.
 */
public class StatusCodeTest extends BaseTest {
    private StatusCode statusCode = StatusCode.valueOf("SUCCESS");

    @Test
    public void aa(){
        System.out.println(StatusCode.FAIL.getCode());
    }

}