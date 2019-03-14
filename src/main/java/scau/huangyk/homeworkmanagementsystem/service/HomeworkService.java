package scau.huangyk.homeworkmanagementsystem.service;

import com.baomidou.mybatisplus.plugins.Page;
import scau.huangyk.homeworkmanagementsystem.dto.LayuiDataGridResult;
import scau.huangyk.homeworkmanagementsystem.entity.Homework;
import com.baomidou.mybatisplus.service.IService;
import scau.huangyk.homeworkmanagementsystem.vo.HomeworkVo;
import scau.huangyk.homeworkmanagementsystem.vo.SubmitHomeworkVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huangyk
 * @since 2019-02-27
 */
public interface HomeworkService extends IService<Homework> {
    LayuiDataGridResult getListByStuId(Page<HomeworkVo> page, Long stuId,Long courseId,Integer status);

    HomeworkVo getByHomeworkId(Long homeworkId);

    LayuiDataGridResult getSubmitListByStuId(Page<HomeworkVo> page, Long stuId,Integer status);

    boolean submitHomework(Long stuId,Long homeworkId,String remark,String srcPath);

    LayuiDataGridResult getListByTeacherId(Page<HomeworkVo> page, Long stuId,Long courseId,Integer status,String subject);

    LayuiDataGridResult getSubmitList(Page<SubmitHomeworkVo> page,Long teacherId, Long courseId, Long homeworkId, Integer isSubmit, Integer isRevise, String keyword);

    SubmitHomeworkVo getSubmitHomework(Long homeworkId,Long stuId);

    boolean reviseHomework(SubmitHomeworkVo homework);

//    boolean deleteBatchsByHomeworkId(List<Long> homeworkIdList);
}
