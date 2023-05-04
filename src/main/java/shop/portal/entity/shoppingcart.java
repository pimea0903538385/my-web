package shop.portal.entity;


import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class shoppingcart implements Serializable {

    private static final long serialVersionUID=1L;

     private  Integer status;
    private Integer userId;
    private Integer productId;
   private  Integer productAmount;
   private  Integer totalprice;
   private Date created;

}
