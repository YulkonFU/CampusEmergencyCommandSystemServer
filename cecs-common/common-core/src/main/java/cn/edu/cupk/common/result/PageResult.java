package cn.edu.cupk.common.result;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;

/**
 * @author 赵希奥
 * @date 2022/6/29 4:46
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */
@Data
public class PageResult<T> implements Serializable {

    private Integer code;

    private Data data;

    private String msg;

    public static <T> PageResult<T> success(IPage<T> page) {
        PageResult<T> result = new PageResult<>();
        result.setCode(HttpStatus.OK.value());

        Data data = new Data<T>();
        data.setList(page.getRecords());
        data.setTotal(page.getTotal());

        result.setData(data);
        result.setMsg(HttpStatus.OK.getReasonPhrase());
        return result;
    }

    @lombok.Data
    public static class Data<T> {

        private long total;

        private List<T> list;

    }

}