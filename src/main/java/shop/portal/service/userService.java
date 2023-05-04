package shop.portal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetails;
import shop.portal.Vo.RegisterVo;
import shop.portal.entity.user;




public interface userService extends IService<user> {
    void register(RegisterVo registerVo);



}
