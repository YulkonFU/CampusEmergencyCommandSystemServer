package cn.edu.cupk.plan.controller;

import cn.edu.cupk.common.result.PageResult;
import cn.edu.cupk.common.result.Result;
import cn.edu.cupk.plan.entity.Plan;
import cn.edu.cupk.plan.entity.query.PlanPageQuery;
import cn.edu.cupk.plan.service.PlanService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 赵希奥
 * @date 2022/7/3 21:10
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@RestController
@RequestMapping("/plan")
public class PlanController {

    @Resource
    private PlanService planService;

    @GetMapping("/list")
    @ResponseBody
    public PageResult listSupplyPages(PlanPageQuery queryParams) {

        return planService.listPlanPages(queryParams);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Result getPlanById(@PathVariable("id") Long id) {
        if (id <= 0) {
            return Result.failed(HttpStatus.BAD_REQUEST.value(), "参数错误");
        }
        return Result.success(planService.getById(id));
    }

    @PostMapping("")
    @ResponseBody
    public Result addPlan(@RequestBody Plan event) {
        if (event == null) {
            return Result.failed(HttpStatus.BAD_REQUEST.value(), "参数错误");
        }
        return planService.save(event)?Result.success("添加成功"):Result.failed(HttpStatus.INTERNAL_SERVER_ERROR.value(), "添加失败");
    }

    @PutMapping("")
    @ResponseBody
    public Result update(@RequestBody Plan supply) {
        Plan byId = planService.getById(supply.getId());
        if (byId == null) {
            return Result.failed(HttpStatus.NOT_FOUND.value(), "未找到该记录");
        }
        boolean b = planService.updateById(supply);
        return b ? Result.success("更新成功") : Result.failed(HttpStatus.INTERNAL_SERVER_ERROR.value(), "更新失败");
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public Result delete(@PathVariable("id") Long id) {
        // 校验参数
        Plan byId = planService.getById(id);
        if (byId == null) {
            return Result.failed(HttpStatus.NOT_FOUND.value(), "已删除或不存在, 操作失败");
        }
        boolean b = planService.removeById(id);
        return b ? Result.success(HttpStatus.NO_CONTENT.value(), "删除成功") : Result.failed(HttpStatus.INTERNAL_SERVER_ERROR.value(), "删除失败");
    }
}
