package com.gta;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Desc:
 * User: jiangningning
 * Date: 2017/9/21
 * Time: 14:09
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public abstract class BaseTest {

    final static Logger LOGGER = Logger.getLogger(BaseTest.class);

}
