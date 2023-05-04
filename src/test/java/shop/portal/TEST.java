package shop.portal;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.apache.ibatis.annotations.Update;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import shop.portal.entity.commodity;
import shop.portal.mapper.commodityMapper;
import shop.portal.mapper.shoppingcartMapper;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TEST {

    @Autowired
    shoppingcartMapper  shoppingcartMapper;
    @Autowired
    commodityMapper  commodityMapper;
    @Test
    public void test(){
        List list=shoppingcartMapper.selectOrder(8);
            }
        }



