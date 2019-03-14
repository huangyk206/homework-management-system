package scau.huangyk.homeworkmanagementsystem.service.impl;

import scau.huangyk.homeworkmanagementsystem.entity.SysInfo;
import scau.huangyk.homeworkmanagementsystem.mapper.SysInfoMapper;
import scau.huangyk.homeworkmanagementsystem.service.SysInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huangyk
 * @since 2019-03-10
 */
@Service
public class SysInfoServiceImpl extends ServiceImpl<SysInfoMapper, SysInfo> implements SysInfoService {

    @Override
    public String getFileType() {
        return baseMapper.selectFileType();
    }

    @Override
    public String getByKeyCode(String keyCode) {
        return baseMapper.selectByKeyCode(keyCode);
    }

    @Override
    public List<SysInfo> getListByKeyCode(String keyCode) {
        return baseMapper.selectListByKeyCode(keyCode);
    }
}
