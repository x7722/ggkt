package com.xu.ggkt.vod.controller;


import com.xu.ggkt.model.vod.Teacher;
import com.xu.ggkt.vod.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author xu
 * @since 2022-08-14
 */
@RestController
@RequestMapping("/admin/vod/teacher")
public class TeacherController {


    @Autowired
    private TeacherService teacherService;

    //查询所有讲师列表
    @GetMapping("findAll")
    public List<Teacher> findAll(){
        List<Teacher> list = teacherService.list();
        return list;
    }

}
