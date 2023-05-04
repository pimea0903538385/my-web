package shop.portal.Vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class loginVo {

    private  String userNickname;

    private  String password;
}
