package scau.huangyk.homeworkmanagementsystem.service;

import com.baomidou.mybatisplus.plugins.Page;
import scau.huangyk.homeworkmanagementsystem.dto.LayuiDataGridResult;
import scau.huangyk.homeworkmanagementsystem.entity.Course;
import com.baomidou.mybatisplus.service.IService;
import scau.huangyk.homeworkmanagementsystem.vo.StudentVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huangyk
 * @since 2019-02-27
 */
public interface CourseService extends IService<Course> {
    List<Course> getByStuId(Long stuId);

    List<Course> getByTeacherId(Long teacherId);
    
    LayuiDataGridResult getListByTeacherId(Page<Course> page, Long teacherId, Integer status, String courseName);

    boolean updateByCourseId(Course course);

    //boolean deleteBatchsByCourseId( List<Long> courseIdList);

    LayuiDataGridResult getStudentListById(Page<StudentVo> page,Long courseId,String keyword);

    Integer getCountByStuId(Long stuId);

    boolean addStudent(Long courseId,Long stuId);

    boolean deleteStudent(Long courseId,List<Long> stuIdList);
}
