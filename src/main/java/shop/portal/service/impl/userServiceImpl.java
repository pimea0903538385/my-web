package shop.portal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import shop.portal.Vo.RegisterVo;
import shop.portal.entity.role;
import shop.portal.entity.user;
import shop.portal.mapper.userMapper;
import shop.portal.service.ServiceException;
import shop.portal.service.userService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


@Service
@Slf4j
public class userServiceImpl extends ServiceImpl<userMapper, user> implements userService {


   BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    @Autowired
    userMapper  userMapper;
    @Override
    public void register( RegisterVo registerVo) {
        if(registerVo == null){
            log.error("方法參數為空");
            throw ServiceException.UnprocesableEntity("表單內容無法處理");
        }
        log.debug("方法參數 {}" ,registerVo);

       log.debug("數據 {}",registerVo.getUserBirthday());
       user user=new user()
               .setUserName(registerVo.getUsername())
               .setUserNickname(registerVo.getNickname())
               .setUserEmail(registerVo.getEmail())
               .setUserPhone(registerVo.getPhone())
               .setUserBirthday(registerVo.getUserBirthday())
               .setCreatetime(LocalDateTime.now())
               .setEnable(1)
               .setUserRoleId(3)
               .setUserPassword(passwordEncoder.encode(registerVo.getPassword()));
       int rows=userMapper.insert(user);
       log.debug("保存資料 {}",user);
       if(rows!=1){
            throw  new ServiceException("業務繁忙中 請稍後再試!");
        }

    }





}
