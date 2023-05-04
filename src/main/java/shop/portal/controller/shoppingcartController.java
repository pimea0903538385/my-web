package shop.portal.controller;




import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import shop.portal.Vo.R;
import shop.portal.Vo.token;
import shop.portal.entity.commodity;
import shop.portal.entity.shoppingcart;
import shop.portal.mapper.commodityMapper;
import shop.portal.mapper.shoppingcartMapper;
import shop.portal.mapper.userMapper;
import shop.portal.service.shoppingcartService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.apache.ibatis.ognl.DynamicSubscript.all;


@RestController
@RequestMapping("")
@Slf4j
public class shoppingcartController {
    @Autowired
    token token;
    @Autowired
    userMapper userMapper;
    @Autowired
    shoppingcartMapper shoppingcartMapper;
    @Autowired
    shoppingcartService shoppingcartService;
    @Autowired
     commodityMapper commodityMapper;
    @PostMapping("/checkout")
    public   String checkout (HttpServletRequest request ,@RequestParam("product") Integer[] productId,@RequestParam("productAmount") Integer[]productAmount
        ,@RequestParam("productPrice") Integer[] productPrice)throws  Exception{
         shoppingcartService.CheckOrder(request,productId,productAmount,productPrice);
         String  sum=request.getParameter("totalPrice");
         Random random = new Random();
         int randomNumber = random.nextInt(10000); // 生成 [0, 10000) 區間內的整數
         String randomString = String.format("%04d", randomNumber); // 補齊為 4 位數字，例如 "0001"
         AioCheckOutALL obj=new AioCheckOutALL();
         obj.setMerchantTradeNo("testorder"+sum+randomString);
         obj.setMerchantTradeDate("2017/10/12 00:00:00");
         obj.setTotalAmount(sum);
         obj.setTradeDesc("test Description");
         obj.setItemName("TestItem");
         obj.setClientBackURL("http://localhost:8080/index.html");
         obj.setReturnURL("http://localhost:8080/index.html");
         obj.setNeedExtraPaidInfo("N");
         AllInOne all=new AllInOne("");
         String form=all.aioCheckOut(obj,null);
         return form;

}
@PostMapping("/OrderCreated")
    public R<shoppingcart> OrderCreated(String jwt){
          List<shoppingcart> order= shoppingcartService.OrderCreated(jwt);
        return R.ok(order);
}

}

