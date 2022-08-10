package com.xu.ggkt.vod.controller;

import com.xu.ggkt.model.vod.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 讲师 前端控制器
 */
@RestController
@RequestMapping(value="/admin/vod/teacher")
public class TeacherController {

//    @Autowired
//    private TeacherService teacherService;

    //查询所有讲师列表
//    @GetMapping("findAll")
//    public List<Teacher> findAll() {
//        List<Teacher> list = teacherService.list();
//        return list;
//    }

    @GetMapping("/hello")
    public String test1(){
        return "123";
    }

}
