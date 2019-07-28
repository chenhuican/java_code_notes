package com.imooc.handle;

import com.imooc.domain.Result;
import com.imooc.exception.GirlException;
import com.imooc.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 统一异常捕获，并返回统一格式数据
 */
@ControllerAdvice
public class ExceptionHandle {

    // 给异常记录日志
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        // 判断是否是自定义的异常类
        if(e instanceof GirlException) {
           GirlException girlException = (GirlException) e;
           return ResultUtil.error(girlException.getCode(), girlException.getMessage());
        }else{
            logger.error("[系统异常] {}", e);
            return ResultUtil.error(-1, "位置错误");
        }

    }
}
