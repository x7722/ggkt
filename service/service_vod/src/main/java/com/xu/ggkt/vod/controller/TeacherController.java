package com.xu.ggkt.vod.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xu.ggkt.exception.GgktException;
import com.xu.ggkt.model.vod.Teacher;
import com.xu.ggkt.result.Result;
import com.xu.ggkt.vo.vod.TeacherQueryVo;
import com.xu.ggkt.vod.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author xu
 * @since 2022-08-14
 */
@Api(tags = "讲师管理接口")
@RestController
@CrossOrigin //允许跨域访问
@RequestMapping("/admin/vod/teacher")
public class TeacherController {


    @Autowired
    private TeacherService teacherService;

    /**
     * 查询所有讲师列表
     *
     * @return
     */
    @ApiOperation("查询所有讲师列表")
    @GetMapping("/findAll")
    public Result<List<Teacher>> findAll() {

        try {
            int a = 1 / 0;
        } catch (Exception e) {
            throw new GgktException(201,"自定义异常GgktException");
        }

        List<Teacher> list = teacherService.list();
        return Result.ok("哈哈哈哈哈", list);
    }

    /**
     * 根据id逻辑删除老师信息
     *
     * @param id 老师id
     * @return boolean
     */
    @ApiOperation("逻辑删除讲师")
    @DeleteMapping("/remove/{id}")
    public Result<Boolean> removeById(@PathVariable("id") String id) {
        boolean b = teacherService.removeById(id);
        if (b) {
            return Result.ok(b);
        } else {
            return Result.fail(b);
        }
    }


    /**
     * 分页按条件查询
     */
    @ApiOperation("分页按条件查询")
    @GetMapping("/findQueryPage/{currentPage}/{pageSize}")
    public Result<Page<Teacher>> findQueryPage(@PathVariable("currentPage") long currentPage, @PathVariable("pageSize") Long pageSize, TeacherQueryVo teacherQueryVo) {
        return teacherService.findQueryPage(currentPage, pageSize, teacherQueryVo);
    }


    /**
     * 新增讲师
     *
     * @param teacher 讲师
     * @return
     */
    @ApiOperation(value = "新增讲师")
    @PostMapping("save")
    public Result<Boolean> save(@RequestBody Teacher teacher) {
        boolean save = teacherService.save(teacher);
        if (save)
            return Result.ok(save);
        else
            return Result.fail(save);

    }


    /**
     * 根据id查询讲师
     */
    @ApiOperation(value = "根据id查询讲师")
    @GetMapping("queryById/{id}")
    public Result<Teacher> queryById(@PathVariable Long id) {
        Teacher teacher = teacherService.getById(id);
        return Result.ok(teacher);
    }


    /**
     * 根据id编辑讲师
     */
    @ApiOperation(value = "根据id编辑讲师")
    @PutMapping("updateById")
    public Result<Boolean> updateById(@RequestBody Teacher teacher) {
        boolean b = teacherService.updateById(teacher);
        if (b)
            return Result.ok(b);
        else
            return Result.fail(b);
    }


    /**
     * 根据id批量删除讲师
     */
    @ApiOperation(value = "根据id批量删除讲师")
    @PutMapping("deleteByIdList")
    public Result<Boolean> deleteByIdList(@RequestBody List<Long> ids) {
        boolean b = teacherService.removeByIds(ids);
        if (b)
            return Result.ok(b);
        else
            return Result.fail(b);
    }


}
