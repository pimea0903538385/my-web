package shop.portal.Vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Date;

@Data
public class RegisterVo {
    @NotBlank(message = "姓名不能為空!")
    private  String username;
    @NotBlank(message = "手機不能為空!")
    @Pattern(regexp = "^.{10}$",message = "手機號碼格式錯誤!")
    private  String phone;
    @NotBlank(message = "暱稱不能為空!")
    @Pattern(regexp = "^.{2,20}$",message = "暱稱只能2~20個字母")
    private  String nickname;
    @NotBlank(message = "密碼不能為空!")
    @Pattern(regexp = "^.{6,20}$" ,message = "密碼需要6~20個字母,數字")
    private  String password;
    @NotBlank(message = "不能為空!")
    private  String confirm;
    @NotBlank(message = "不能為空!")
    private  String email;
    @NotNull(message = "不能為空!")
    private String userBirthday;

}