package shop.portal.controller;




import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import shop.portal.Vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import shop.portal.Vo.RegisterVo;
import shop.portal.Vo.loginVo;

import shop.portal.Vo.token;
import shop.portal.entity.user;
import shop.portal.mapper.userMapper;
import shop.portal.service.userService;

import javax.validation.Valid;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

@RestController
@Slf4j
@RequestMapping("")
public class systemController {


     BCryptPasswordEncoder passwordEncoder =new BCryptPasswordEncoder();

     @Autowired
     token tokens;

     @Autowired
     userService userService;
     @Autowired
     userMapper userMapper;


    @GetMapping("/register.html")
    public ModelAndView register() {
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public R register(@Validated RegisterVo registerVo, BindingResult result) {
        log.debug("收到數據 {}", registerVo);
        if (!registerVo.getConfirm().equals(registerVo.getPassword())) {
            return R.Unprocesable_Entity("密碼不一致");
        } if(userMapper.finduserbyphone(registerVo.getPhone())!=null){
           return  R.Unprocesable_Entity("手機號碼已使用過");
        }
        userService.register(registerVo);


        return R.created("成功");
    }

    @GetMapping("/login.html")
    public ModelAndView login() {
        return new ModelAndView("login");

    }
    @PostMapping("/login")
    public R login(@Validated loginVo login) {
        log.debug("{}",login);
        user u = userMapper.finduserbyusernickname(login.getUserNickname());

        if(userMapper.finduserexist(login.getUserNickname())==null){
            return R.Unprocesable_Entity("您的帳號沒有註冊");
        }

        if(u.getUserNickname().equals(login.getUserNickname())){
            if(!passwordEncoder.matches(login.getPassword(),u.getUserPassword())){
                return R.Unprocesable_Entity("密碼錯誤");
            }

        }
        String token=tokens.generateToken(login.getUserNickname());

         log.debug("{}",token);
        return R.created("成功登入!").setData(token);
    }
}