package cn.edu.cupk.cecs.watchkeeper.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/01/10:23
 * @Description:
 */
@Data
@NoArgsConstructor
@TableName("process")
public class Process {

    @TableId(value = "id",type = IdType.AUTO)
    private long id;

    private Integer status;

    private long next;

    @TableLogic(value = "0",delval = "1")
    private Integer deleted;
}
