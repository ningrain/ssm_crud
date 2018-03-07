package com.gta.enums;

import com.gta.BaseTest;
import org.junit.Test;

import static org.junit.Assert.*;

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