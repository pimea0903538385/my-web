package shop.portal.entity;



import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.sql.Blob;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class commodity implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "commodity_id", type = IdType.AUTO)
    private Integer commodityId;

    private Integer categoryId;

    private String commodityName;

    private String commodityDesciption;

    private Integer commodityPrice;

    private byte[] commodityImage;
    /**
     * 1為最新上架2為熱銷
     */
    private Integer commodityType;

    private  Integer commodityAmount;


}
