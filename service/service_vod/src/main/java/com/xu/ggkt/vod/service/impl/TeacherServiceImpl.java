package com.xu.ggkt.vod.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xu.ggkt.model.vod.Teacher;
import com.xu.ggkt.result.Result;
import com.xu.ggkt.vo.vod.TeacherQueryVo;
import com.xu.ggkt.vod.mapper.TeacherMapper;
import com.xu.ggkt.vod.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.Wrapper;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author xu
 * @since 2022-08-14
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    /**
     * 分页查询
     * @param currentPage 当前页
     * @param pageSize 页面大小
     * @param teacherQueryVo 查询条件
     * @return
     */
    @Override
    public Result<Page<Teacher>> findQueryPage(long currentPage, Long pageSize, TeacherQueryVo teacherQueryVo) {
        //创建分页条件，设置页码和当前页
        Page<Teacher> queryPage = new Page<>(currentPage, pageSize);
        //判断是否有条件
        if (teacherQueryVo==null){
            //单纯的分页查询
            Page<Teacher> page = page(queryPage, null);
            return Result.ok(page);
        }
        //创建条件查询对象
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();

        //封装条件查询属性
        if (!StringUtils.isEmpty(teacherQueryVo.getName())){
            wrapper.like("name",teacherQueryVo.getName());
        }
        if (teacherQueryVo.getLevel()!=null){
            wrapper.eq("level",teacherQueryVo.getLevel());
        }
        if (!StringUtils.isEmpty(teacherQueryVo.getJoinDateBegin())){
            wrapper.ge("join_date",teacherQueryVo.getJoinDateBegin());
        }
        if (!StringUtils.isEmpty(teacherQueryVo.getJoinDateEnd())){
            wrapper.le("join_date",teacherQueryVo.getJoinDateEnd());
        }

        //按条件分页查询
        Page<Teacher> page = page(queryPage, wrapper);

        return Result.ok(page);
    }
}
