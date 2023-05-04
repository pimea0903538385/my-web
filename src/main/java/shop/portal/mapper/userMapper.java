package shop.portal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import shop.portal.entity.role;
import shop.portal.entity.user;

import java.util.List;

@Mapper
public interface userMapper extends BaseMapper<user> {
    @Select("select * from user where user_phone=#{phone}")
    user finduserbyphone(String phone);
    @Select("select * from user where user_nickname=#{userNickname}")
    user finduserbyusernickname(String userNickname);
    @Select("select * from user where user_nickname=#{userNickname}")
     Integer finduserexist(String userNickname);

    @Select("SELECT r.id,r.name   from user u  left join user_role ur on u.id=ur.user_id  left join role r on r.id=ur.role_id where u.id=#{id}")
    role findrolebyid(int id);
    @Select("select id from user where user_nickname=#{userNickname} ")
     Integer selectUserid(String userNickname);

}
