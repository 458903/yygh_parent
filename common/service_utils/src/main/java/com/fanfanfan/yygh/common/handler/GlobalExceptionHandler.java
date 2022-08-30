package com.fanfanfan.yygh.common.handler;

import com.fanfanfan.yygh.common.exception.YyghException;
import com.fanfanfan.yygh.common.result.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

/**
 * 统一异常处理类
 */
@ControllerAdvice//凡是有该注解的，都是全局异常处理类
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        e.printStackTrace();
        log.error(e.getMessage());
        return R.error();
    }
//特定异常处理方法：会先走细粒度异常
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R error(ArithmeticException e){
        e.printStackTrace();
        log.error(e.getMessage());
        return R.error().message("执行了特定异常");
    }
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public R error(RuntimeException e){
        e.printStackTrace();
        log.error(e.getMessage());
        return R.error().message("执行了运行时异常");
    }
    @ExceptionHandler(SQLException.class)
    @ResponseBody
    public R error(SQLException e){
        e.printStackTrace();
        log.error(e.getMessage());
        return R.error().message("sql异常");
    }
   @ExceptionHandler(YyghException.class)
    @ResponseBody
    public R error(YyghException e){
        e.printStackTrace();
       log.error(e.getMessage());
        return R.error().message(e.getMsg()).code(e.getCode());
    }
}
