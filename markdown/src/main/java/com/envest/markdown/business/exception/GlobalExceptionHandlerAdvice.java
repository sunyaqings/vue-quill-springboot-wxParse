package com.envest.markdown.business.exception;


import com.envest.markdown.business.constant.Code;
import com.envest.markdown.business.response.BaseResult;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {
    private static final Logger logger = Logger.getLogger(GlobalExceptionHandlerAdvice.class);


    //业务异常
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public BaseResult handleBusinessException(BusinessException be) {
        logger.error(be.getMessage());
        System.out.println(be.getMessage());
        return new BaseResult(Code.FAIL, be.getMessage());
    }

    //系统异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResult handleDefaultException(Exception e) {
        logger.error(e);
        e.printStackTrace();
        return new BaseResult(Code.SYSTEM_ERROR, Code.SYSTEM_ERROR.getMsg(), e.getMessage());
    }


}
