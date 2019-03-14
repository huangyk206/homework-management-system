package scau.huangyk.homeworkmanagementsystem.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import scau.huangyk.homeworkmanagementsystem.dto.LayuiDataGridResult;
import scau.huangyk.homeworkmanagementsystem.entity.Course;
import scau.huangyk.homeworkmanagementsystem.mapper.CourseMapper;
import scau.huangyk.homeworkmanagementsystem.service.CourseService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import scau.huangyk.homeworkmanagementsystem.vo.StudentVo;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huangyk
 * @since 2019-02-27
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Override
    public List<Course> getByStuId(Long stuId) {
        return baseMapper.selectByStuId(stuId);
    }

    @Override
    public List<Course> getByTeacherId(Long teacherId) {
        return baseMapper.selectByTeacherId(teacherId);
    }

    @Override
    public LayuiDataGridResult getListByTeacherId(Page<Course> page, Long teacherId, Integer status, String courseName) {
        LayuiDataGridResult result=new LayuiDataGridResult();
        List<Course> list=baseMapper.selectListByTeacherId(page,teacherId,status,courseName);
        result.setData(list);
        result.setCount(page.getTotal());
        return result;
    }

    @Override
    public boolean updateByCourseId(Course course){
        return baseMapper.updateByCourseId(course)>0;
    }

//    @Override
//    public boolean deleteBatchsByCourseId( List<Long> courseIdList) {
//        return baseMapper.deleteBatchsByCourseId(courseIdList)>0;
//    }

    @Override
    public LayuiDataGridResult getStudentListById(Page<StudentVo> page, Long courseId, String keyword) {
        LayuiDataGridResult result=new LayuiDataGridResult();
        List<StudentVo> list=baseMapper.selectStudentListById(page,courseId,keyword);
        result.setCount(page.getTotal());
        result.setData(list);
        return result;
    }

    @Override
    public Integer getCountByStuId(Long stuId) {
        return baseMapper.selectCountByStuId(stuId);
    }

    @Override
    public boolean addStudent(Long courseId, Long stuId) {
        return baseMapper.insertStudentCourse(courseId,stuId)>0;
    }

    @Override
    public boolean deleteStudent(Long courseId, List<Long> stuIdList) {
        return baseMapper.deleteStudent(courseId,stuIdList)>0;
    }


}
