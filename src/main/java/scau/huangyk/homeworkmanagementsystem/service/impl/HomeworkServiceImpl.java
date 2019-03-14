package scau.huangyk.homeworkmanagementsystem.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import scau.huangyk.homeworkmanagementsystem.dto.LayuiDataGridResult;
import scau.huangyk.homeworkmanagementsystem.entity.Homework;
import scau.huangyk.homeworkmanagementsystem.mapper.HomeworkMapper;
import scau.huangyk.homeworkmanagementsystem.service.HomeworkService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import scau.huangyk.homeworkmanagementsystem.vo.HomeworkVo;
import scau.huangyk.homeworkmanagementsystem.vo.SubmitHomeworkVo;

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
public class HomeworkServiceImpl extends ServiceImpl<HomeworkMapper, Homework> implements HomeworkService {

    @Override
    public LayuiDataGridResult getListByStuId(Page<HomeworkVo> page, Long stuId,Long courseId,Integer status) {
        LayuiDataGridResult result=new LayuiDataGridResult();
        List<HomeworkVo> list=baseMapper.selectListByStuId(page,stuId,courseId,status);
        result.setCount(page.getTotal());
        result.setData(list);
        return result;
    }

    @Override
    public HomeworkVo getByHomeworkId(Long homeworkId) {
        return baseMapper.selectByHomeworkId(homeworkId);
    }

    @Override
    public LayuiDataGridResult getSubmitListByStuId(Page<HomeworkVo> page, Long stuId, Integer status) {
        LayuiDataGridResult result=new LayuiDataGridResult();
        List<HomeworkVo> list=baseMapper.selectListByStuId(page,stuId,null,status);
        result.setCount(page.getTotal());
        result.setData(list);
        return result;
    }

    @Override
    public boolean submitHomework(Long stuId, Long homeworkId, String remark, String srcPath) {
        if(baseMapper.selectCountByStuIdAndHomeworkId(stuId,homeworkId)>0){
            return baseMapper.updateByStuIdAndHomeworkId(stuId, homeworkId, remark, srcPath)>0;
        }
        return baseMapper.insertStudentHomework(stuId,homeworkId,remark,srcPath)>0;
    }

    @Override
    public LayuiDataGridResult getListByTeacherId(Page<HomeworkVo> page, Long teacherId, Long courseId, Integer status, String subject) {
        LayuiDataGridResult result=new LayuiDataGridResult();
        List<HomeworkVo> list=baseMapper.selectListByTeacherId(page,teacherId,courseId,status,subject);
        result.setCount(page.getTotal());
        result.setData(list);
        return result;
    }

    @Override
    public LayuiDataGridResult getSubmitList(Page<SubmitHomeworkVo> page,Long teacherId, Long courseId, Long homeworkId, Integer isSubmit, Integer isRevise, String keyword) {
        LayuiDataGridResult result=new LayuiDataGridResult();
        List<SubmitHomeworkVo> list=baseMapper.selectSubmitList(page,teacherId, courseId, homeworkId, isSubmit, isRevise, keyword);
        result.setCount(page.getTotal());
        result.setData(list);
        return result;
    }

    @Override
    public SubmitHomeworkVo getSubmitHomework(Long homeworkId, Long stuId) {
        return baseMapper.selectSubmitHomework(homeworkId,stuId);
    }

    @Override
    public boolean reviseHomework(SubmitHomeworkVo homework) {
        return baseMapper.updateStudentHomework(homework)>0;
    }

//    @Override
//    public boolean deleteBatchsByHomeworkId(List<Long> homeworkIdList) {
//        return baseMapper.deleteBatchsByHomeworkId(homeworkIdList)>0;
//    }
}
