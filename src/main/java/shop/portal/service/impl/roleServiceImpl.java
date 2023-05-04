package shop.portal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import shop.portal.entity.role;
import shop.portal.mapper.roleMapper;
import shop.portal.service.roleService;

@Service
public class roleServiceImpl extends ServiceImpl<roleMapper, role> implements roleService {

}
