package java.com.gta.util;

import com.mindflow.py4j.Converter;
import com.mindflow.py4j.PinyinConverter;
import com.mindflow.py4j.exception.IllegalPinyinException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class HanyuPinyinHelperTest {

    @Test
    public void toHanyuPinyin() throws IllegalPinyinException {

        Converter converter = new PinyinConverter();
        String name = converter.getPinyin("姓单明伟", "upper", true);
        System.out.println(converter.getPinyin("jiangningning"));

    }
}