package util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * Desc:
 * User: jiangningning
 * Date: 2017/12/25
 * Time: 13:24
 */
@RunWith(JUnit4.class)
public class ResourceTest {

    @Test
    public void testByteArrayResource() throws IOException {
        Resource resource = new ByteArrayResource("Hello world!".getBytes());
        if (resource.exists()) {
            dumpStream(resource);
        }
    }

    private void dumpStream(Resource resource) throws IOException {

        InputStream is = null;
        is = resource.getInputStream();
        byte[] descBytes = new byte[is.available()];
        is.read(descBytes);
        System.out.println(new String(descBytes));
        is.close();
    }

}