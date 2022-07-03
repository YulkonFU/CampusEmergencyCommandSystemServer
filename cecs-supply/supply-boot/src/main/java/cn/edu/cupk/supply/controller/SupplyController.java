package cn.edu.cupk.supply.controller;

import cn.edu.cupk.common.result.PageResult;
import cn.edu.cupk.common.result.Result;
import cn.edu.cupk.supply.entity.Supply;
import cn.edu.cupk.supply.entity.query.SupplyPageQuery;
import cn.edu.cupk.supply.service.SupplyService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.ibatis.annotations.Delete;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 赵希奥
 * @date 2022/7/3 15:59
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@RestController
@RequestMapping("/supply")
public class SupplyController {

    @Resource
    private SupplyService supplyService;

    @GetMapping("/list")
    @ResponseBody
    public PageResult listSupplyPages(SupplyPageQuery queryParams) {
        return supplyService.listEventPages(queryParams);
    }

    @PutMapping("")
    @ResponseBody
    public Result update(@RequestBody Supply supply) {
        Supply byId = supplyService.getById(supply.getId());
        if (byId == null) {
            return Result.failed(HttpStatus.NOT_FOUND.value(), "未找到该记录");
        }
        boolean b = supplyService.updateById(supply);
        return b ? Result.success("更新成功") : Result.failed(HttpStatus.INTERNAL_SERVER_ERROR.value(), "更新失败");
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public Result delete(@PathVariable("id") Long id) {
        // 校验参数
        Supply byId = supplyService.getById(id);
        if (byId == null) {
            return Result.failed(HttpStatus.NOT_FOUND.value(), "已删除, 操作失败");
        }
        boolean b = supplyService.removeById(id);
        return b ? Result.success(HttpStatus.NO_CONTENT.value(), "删除成功") : Result.failed(HttpStatus.INTERNAL_SERVER_ERROR.value(), "删除失败");
    }

    @PostMapping("")
    @ResponseBody
    public Result add(@RequestBody Supply supply) {
        LambdaQueryWrapper<Supply> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Supply::getName, supply.getName());
        Supply one = supplyService.getOne(queryWrapper);
        boolean b;
        if (one != null) {
            // 若已存在, 将库存增加
            one.setInventory(one.getInventory() + supply.getInventory());
            b = supplyService.updateById(one);
        } else {
            b = supplyService.save(supply);
        }
        return b ? Result.success("添加成功") : Result.failed(HttpStatus.INTERNAL_SERVER_ERROR.value(), "添加失败");
    }

    /**
     * 查询物资
     */
    @GetMapping("/{id}")
    @ResponseBody
    public Result get(@PathVariable("id") Long id) {
        Supply byId = supplyService.getById(id);
        return byId == null ? Result.failed(HttpStatus.NOT_FOUND.value(), "未找到该记录") : Result.success(byId);
    }

    @GetMapping("/remaining")
    @ResponseBody
    public Result getRemaining() {
        return Result.success("查询成功", supplyService.getRemaining());
    }
}
