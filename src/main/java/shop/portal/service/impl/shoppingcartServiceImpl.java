package shop.portal.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import shop.portal.Vo.R;
import shop.portal.Vo.token;
import shop.portal.entity.commodity;
import shop.portal.entity.shoppingcart;
import shop.portal.mapper.commodityMapper;
import shop.portal.mapper.shoppingcartMapper;
import shop.portal.mapper.userMapper;
import shop.portal.service.shoppingcartService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


@Service
public class shoppingcartServiceImpl extends ServiceImpl<shoppingcartMapper, shoppingcart> implements shoppingcartService {


    @Autowired
    token token;
    @Autowired
    commodityMapper commodityMapper;
    @Autowired
    userMapper userMapper;
    @Autowired
    shoppingcartMapper shoppingcartMapper;
    @Override
    public void CheckOrder(HttpServletRequest request , Integer[] productId,Integer[] productAmount,Integer[] productPrice) {

       String username=token.gettokenname(request.getParameter("userid"));
       Integer userId=userMapper.selectUserid(username);
       for (int i=0;i<productId.length;i++) {
           Integer id=productId[i];
           Integer amount=productAmount[i];
           Integer Price=productPrice[i];
           shoppingcart order = new shoppingcart().setProductAmount(amount).setProductId(id).setStatus(1).setTotalprice(Price).setUserId(userId);
           shoppingcartMapper.insert(order);
       }

    }

    @Override
    public List<shoppingcart> OrderCreated(String jwt) {
          String username=token.gettokenname(jwt);
          Integer userId=userMapper.selectUserid(username);
          List  order=  shoppingcartMapper.selectOrder(userId);
        return order;
    }


}
