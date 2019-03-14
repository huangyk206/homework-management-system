package scau.huangyk.homeworkmanagementsystem.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;
import scau.huangyk.homeworkmanagementsystem.entity.Course;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import scau.huangyk.homeworkmanagementsystem.vo.StudentVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huangyk
 * @since 2019-02-27
 */
public interface CourseMapper extends BaseMapper<Course> {
    List<Course> selectByStuId(Long stuId);

    List<Course> selectByTeacherId(Long teacherId);

    List<Course> selectListByTeacherId(@Param("page") Page<Course> page, @Param("teacherId") Long teacher, @Param("status") Integer status, @Param("courseName") String courseName);

    Integer updateByCourseId(Course course);

//    Integer deleteBatchsByCourseId(List<Long> courseIdList);

    List<StudentVo> selectStudentListById(@Param("page")Page<StudentVo> page,@Param("courseId")Long courseId,@Param("keyword")String keyword);

    Integer selectCountByStuId(Long stuId);

    Integer insertStudentCourse(@Param("courseId")Long courseId,@Param("stuId")Long stuId);

    Integer deleteStudent(@Param("courseId")Long courseId,@Param("stuIdList")List<Long> stuIdList);
}
