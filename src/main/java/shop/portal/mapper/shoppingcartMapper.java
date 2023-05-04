package shop.portal.mapper;



import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import shop.portal.entity.commodity;
import shop.portal.entity.shoppingcart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface shoppingcartMapper extends BaseMapper<shoppingcart> {

    @Delete("delete from shoppingcart where user_id=#{userId} and product_id=#{productId} ")
    Integer deleteproduct(Integer userId,Integer productId);
    @Update("UPDATE shoppingcart SET product_status=1 WHERE  user_id=#{userid}")
    Boolean updataStatus(Integer userid);
    @Select("select product_id from shoppingcart WHERE  user_id =#{userid} AND product_status=0")
    List<Integer> getproductID(Integer userid);
    @Select("select product_amount from shoppingcart WHERE  product_id =#{productid} AND product_status=0")
    Integer getproductAmount(Integer productid);
    @Select("SELECT s.* , c.* FROM shoppingcart s LEFT JOIN commodity c ON s.product_id=c.commodity_id WHERE s.user_id=#{userid} ORDER BY s.created desc")
    List<Map<String, Object>> selectOrder(Integer userid);

}
