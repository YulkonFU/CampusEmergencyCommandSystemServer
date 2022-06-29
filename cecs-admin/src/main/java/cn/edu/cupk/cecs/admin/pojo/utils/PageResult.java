package cn.edu.cupk.cecs.admin.pojo.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/06/29/16:17
 * @Description:
 */
@Data
public class PageResult<T> implements Serializable {

    private Integer code;

    private Data data;

    private String msg;

    public static <T> PageResult<T> success(IPage<T> page) {
        PageResult<T> result = new PageResult<>();
        result.setCode(HttpStatus.OK.value());
        result.setMsg(HttpStatus.OK.getReasonPhrase());

        Data data = new Data<T>();
        data.setList(page.getRecords());
        data.setTotal(page.getTotal());

        result.setData(data);
//        result.setMsg(ResultCode.SUCCESS.getMsg());
        return result;
    }

    @lombok.Data
    public static class Data<T> {

        private List<T> list;

        private long total;

    }

}
