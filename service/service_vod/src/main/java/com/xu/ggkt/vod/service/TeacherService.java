package com.xu.ggkt.vod.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xu.ggkt.model.vod.Teacher;
import com.xu.ggkt.result.Result;
import com.xu.ggkt.vo.vod.TeacherQueryVo;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author xu
 * @since 2022-08-14
 */
public interface TeacherService extends IService<Teacher> {

    /**
     * 分页查询
     * @param currentPage 当前页
     * @param pageSize 页面大小
     * @param teacherQueryVo 查询条件
     * @return
     */
    Result findQueryPage(long currentPage, Long pageSize, TeacherQueryVo teacherQueryVo);
}
