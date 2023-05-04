package shop.portal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class user implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主鍵
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用戶姓名
     */
    
    private String userName;

    private String userNickname;

    /**
     * 用戶密碼
     */
    private String userPassword;

    /**
     * 用戶手機
     */
    private String userPhone;

    /**
     * 用戶信箱跟帳號
     */
    private String userEmail;

    /**
     * 用戶生日
     */
    private String userBirthday;

    /**
     * 賣家為2買家為3
     */
    private Integer userRoleId;

    /**
     * 帳號註冊時間
     */
    private LocalDateTime createtime;

    /**
     * 帳號是否可使用
     */
    private Integer enable;


}
