package cn.edu.cupk.common.result;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author 赵希奥
 * @date 2022/6/29 4:55
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */
@Data
public class Result<T> implements Serializable {

    private Integer code;

    private String msg;

   private T data;


    public static <T> Result<T> success(Integer code, String msg) {
        return result(code, msg, null);
    }

    public static <T> Result<T> success(String msg) {
        return result(HttpStatus.OK.value(), msg, null);
    }
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(HttpStatus.OK.value());
        result.setMsg(HttpStatus.OK.getReasonPhrase());
        result.setData(data);
        return result;
    }


    public static <T> Result<T> success(String msg, T data) {
        return result(HttpStatus.OK.value(), msg, data);
    }

    public static <T> Result<T> failed(Integer code, String msg) {
        return result(code, msg, null);
    }

    private static <T> Result<T> failed(Integer code, String msg, T data) {
        return result(code, msg, data);
    }

    private static <T> Result<T> result(Integer code, String msg, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }

    public static boolean isSuccess(Result<?> result) {
        return result != null && HttpStatus.OK.value() == result.getCode();
    }
}