package com.log;

import java.util.logging.Logger;

/**
 * @Description 日志测试
 * @Author
 * @Date 2019-09-27 14:23
 * @Version 1.0
 */
public class Log {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("JDKLog");
        logger.info("Hello World.");
    }
}
