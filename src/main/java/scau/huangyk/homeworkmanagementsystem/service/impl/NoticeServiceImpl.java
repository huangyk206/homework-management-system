package scau.huangyk.homeworkmanagementsystem.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import scau.huangyk.homeworkmanagementsystem.dto.LayuiDataGridResult;
import scau.huangyk.homeworkmanagementsystem.entity.Notice;
import scau.huangyk.homeworkmanagementsystem.mapper.NoticeMapper;
import scau.huangyk.homeworkmanagementsystem.service.NoticeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import scau.huangyk.homeworkmanagementsystem.vo.NoticeVo;

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
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

    @Override
    public LayuiDataGridResult getNoticeListByStuId(Page<NoticeVo> page,Long stuId) {
        LayuiDataGridResult result=new LayuiDataGridResult();
        List<NoticeVo> list=baseMapper.selectListByStuId(page,stuId);
        result.setData(list);
        result.setCount(page.getTotal());
        return result;
    }

    @Override
    public LayuiDataGridResult getNoticeListByTeacherId(Page<NoticeVo> page, Long teacherId,String title,Long courseId) {
        LayuiDataGridResult result=new LayuiDataGridResult();
        List<NoticeVo> list=baseMapper.selectListByTeacherId(page,teacherId,title,courseId);
        result.setData(list);
        result.setCount(page.getTotal());
        return result;
    }

    @Override
    public boolean publishNotice(Long noticeId, Integer isPublish) {
        return baseMapper.updatePublishByNoticeId(noticeId,isPublish)>0;
    }

//    @Override
//    public boolean deleteByNoticeId(Long noticeId) {
//        return baseMapper.deleteById(noticeId)>0;
//    }
//
//    @Override
//    public boolean updateByNoticeId(Notice notice) {
//        return baseMapper.updateById(notice)>0;
//    }


}
