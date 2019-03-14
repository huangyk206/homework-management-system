package scau.huangyk.homeworkmanagementsystem.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;
import scau.huangyk.homeworkmanagementsystem.entity.Homework;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import scau.huangyk.homeworkmanagementsystem.vo.HomeworkVo;
import scau.huangyk.homeworkmanagementsystem.vo.SubmitHomeworkVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huangyk
 * @since 2019-02-27
 */
public interface HomeworkMapper extends BaseMapper<Homework> {

    List<HomeworkVo> selectListByStuId(Page<HomeworkVo> page,@Param("stuId") Long stuId, @Param("courseId") Long courseId,@Param("status")Integer status);

    HomeworkVo selectByHomeworkId(Long homeworkId);

    List<HomeworkVo> selectSubmitListByStuId(Page<HomeworkVo> page,@Param("stuId") Long stuId,@Param("status")Integer status);

    Integer insertStudentHomework(@Param("stuId")Long stuId,@Param("homeworkId")Long homeworkId,@Param("remark")String remark,@Param("srcPath")String srcPath);

    Integer selectCountByStuIdAndHomeworkId(@Param("stuId")Long stuId,@Param("homeworkId")Long homeworkId);

    Integer updateByStuIdAndHomeworkId(@Param("stuId")Long stuId,@Param("homeworkId")Long homeworkId,@Param("remark")String remark,@Param("srcPath")String srcPath);

    List<HomeworkVo> selectListByTeacherId(Page<HomeworkVo> page,@Param("teacherId") Long teacherId, @Param("courseId") Long courseId,@Param("status")Integer status,@Param("subject") String subject);

//    Integer deleteBatchsByHomeworkId(@Param("homeworkIdList") List<Long> homeworkIdList);
    List<SubmitHomeworkVo> selectSubmitList(Page<SubmitHomeworkVo> page,@Param("teacherId")Long teacherId,@Param("courseId")Long courseId,@Param("homeworkId")Long homeworkId,@Param("isSubmit")Integer isSubmit,@Param("isRevise")Integer isRevise,@Param("keyword")String keyword);

    SubmitHomeworkVo selectSubmitHomework(@Param("homeworkId")Long homeworkId,@Param("stuId")Long stuId);

    Integer updateStudentHomework(SubmitHomeworkVo homework);
}
