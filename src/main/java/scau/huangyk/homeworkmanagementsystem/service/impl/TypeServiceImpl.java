package scau.huangyk.homeworkmanagementsystem.service.impl;

import scau.huangyk.homeworkmanagementsystem.entity.Type;
import scau.huangyk.homeworkmanagementsystem.mapper.TypeMapper;
import scau.huangyk.homeworkmanagementsystem.service.TypeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huangyk
 * @since 2019-03-03
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {

    @Override
    public List<Type> getListByKeyCode(String keyCode) {
        return baseMapper.selectByKeyCode(keyCode);
    }
}
