package edu.pku.springbootseed.common.model;

import edu.pku.springbootseed.common.Constant;
import lombok.Data;

import java.io.Serializable;

/**
 * desc
 *
 * @author wangyc
 * @since 2019/11/10
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成功标志
     */
    private boolean success = true;

    /**
     * 返回处理消息
     */
    private String message = "操作成功！";

    /**
     * 返回代码
     */
    private Integer code = 0;

    /**
     * 返回数据对象 data
     */
    private T result;

    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    public static <T> Result<T> success() {
        Result<T> r = new Result<>();
        r.setSuccess(true);
        r.setCode(Constant.ERROR_CODE_SUCCESS);
        r.setMessage("成功");
        return r;
    }

    public static <T> Result<T> success(String msg) {
        Result<T> r = new Result<>();
        r.setSuccess(true);
        r.setCode(Constant.ERROR_CODE_SUCCESS);
        r.setMessage(msg);
        return r;
    }

    public static <T> Result<T> success(String msg, T data) {
        Result<T> r = new Result<>();
        r.setSuccess(true);
        r.setCode(Constant.ERROR_CODE_SUCCESS);
        r.setMessage(msg);
        r.setResult(data);
        return r;
    }

    public static <T> Result<T> success(T data) {
        Result<T> r = new Result<>();
        r.setSuccess(true);
        r.setCode(Constant.ERROR_CODE_SUCCESS);
        r.setResult(data);
        return r;
    }

    public static <T> Result<T> failure() {
        Result<T> r = new Result<>();
        r.setSuccess(false);
        r.setCode(Constant.ERROR_CODE_FAILURE);
        r.setMessage("失败");
        return r;
    }

    public static <T> Result<T> failure(String msg) {
        Result<T> r = new Result<>();
        r.setSuccess(false);
        r.setCode(Constant.ERROR_CODE_FAILURE);
        r.setMessage(msg);
        return r;
    }

    public static <T> Result<T> failure(int code, String msg) {
        Result<T> r = new Result<>();
        r.setSuccess(false);
        r.setCode(code);
        r.setMessage(msg);
        return r;
    }
}
