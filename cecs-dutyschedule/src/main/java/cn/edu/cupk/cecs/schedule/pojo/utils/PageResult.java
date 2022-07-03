package cn.edu.cupk.cecs.schedule.pojo.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/03/22:22
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
