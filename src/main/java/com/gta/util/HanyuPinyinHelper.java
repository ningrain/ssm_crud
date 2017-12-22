package com.gta.util;

import com.mindflow.py4j.Converter;
import com.mindflow.py4j.PinyinConverter;
import com.mindflow.py4j.exception.IllegalPinyinException;

/**
 * Desc: 汉语拼音 工具类
 * User: jiangningning
 * Date: 2017/12/21
 * Time: 14:14
 */
public class HanyuPinyinHelper {

    /**
     * 将文字转为汉语拼音
     * @param chineseLanguage 要转成拼音的中文
     */
    public String toHanyuPinyin(String chineseLanguage) throws IllegalPinyinException {
        Converter converter = new PinyinConverter();

        return converter.getPinyin(chineseLanguage, "", true);
    }


}
