package edu.pku.springbootseed.common.handler;

import edu.pku.springbootseed.common.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 处理filter中的异常
 *
 * @author wangyc
 * @since 2019/11/10
 */
@Slf4j
@RestController
public class GlobalExceptionHandler implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping(value = "/error")
    public Result<Object> error(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        log.error(" error code: {}, url: {}, exception: {}", statusCode, request.getRequestURI(), exception == null ? "" : exception.getMessage());
        return Result.failure("");
    }
}