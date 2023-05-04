package shop.portal.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import shop.portal.entity.commodity;

import java.util.List;

@Mapper
public interface commodityMapper extends BaseMapper<commodity> {


@Select("select * from commodity where commodity_id=#{id} ")
    List<commodity>  setProductdetailfromID(Integer id);
    @Select("select commodity_name from commodity where commodity_id=#{id} ")
    List<commodity>  getcommodity(Integer id);
}
