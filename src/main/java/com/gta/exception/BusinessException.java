package com.gta.exception;

/**
 * Desc:
 * User: jiangningning
 * Date: 2018/2/26
 * Time: 16:28
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String msg) {
        super(msg);
    }
}
