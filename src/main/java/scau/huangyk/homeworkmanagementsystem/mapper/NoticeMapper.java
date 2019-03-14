package scau.huangyk.homeworkmanagementsystem.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;
import scau.huangyk.homeworkmanagementsystem.entity.Notice;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import scau.huangyk.homeworkmanagementsystem.vo.NoticeVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huangyk
 * @since 2019-02-27
 */
public interface NoticeMapper extends BaseMapper<Notice> {
    List<NoticeVo> selectListByStuId(Page<NoticeVo> page,Long stuId);

    List<NoticeVo> selectListByTeacherId(@Param("page") Page<NoticeVo> page, @Param("teacherId") Long teacherId, @Param("title") String title, @Param("courseId")Long courseId);

    Integer updatePublishByNoticeId(@Param("noticeId")Long noticeId,@Param("isPublish")Integer isPublish);
}
