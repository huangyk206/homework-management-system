package scau.huangyk.homeworkmanagementsystem.service;

import com.baomidou.mybatisplus.plugins.Page;
import scau.huangyk.homeworkmanagementsystem.dto.LayuiDataGridResult;
import scau.huangyk.homeworkmanagementsystem.entity.Notice;
import com.baomidou.mybatisplus.service.IService;
import scau.huangyk.homeworkmanagementsystem.vo.NoticeVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huangyk
 * @since 2019-02-27
 */
public interface NoticeService extends IService<Notice> {

    LayuiDataGridResult getNoticeListByStuId(Page<NoticeVo>p,Long stuId);

    LayuiDataGridResult getNoticeListByTeacherId(Page<NoticeVo>p,Long teacherId,String title,Long courseId);

    boolean publishNotice(Long noticeId,Integer isPublish);

//    boolean deleteByNoticeId(Long noticeId);
//
//    boolean updateByNoticeId(Notice notice);

}
