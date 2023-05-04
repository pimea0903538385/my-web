package shop.portal.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import shop.portal.Vo.R;
import shop.portal.Vo.token;
import shop.portal.entity.commodity;
import shop.portal.entity.shoppingcart;
import shop.portal.mapper.commodityMapper;
import shop.portal.mapper.shoppingcartMapper;
import shop.portal.mapper.userMapper;

import java.util.List;


@RestController
@Slf4j
@RequestMapping("")
public class HomeController {

  @Autowired
  token tokens;
  @Autowired
 shoppingcartMapper shoppingcartmapper;
  @Autowired
  userMapper usermapper;
  @Autowired
    commodityMapper commodityMapper;

    @GetMapping("/index.html")
    public ModelAndView home(){
        return new ModelAndView("index");
    }
    @GetMapping("/productlist.html")
    public ModelAndView productlist(){return  new ModelAndView("productlist");}
    @GetMapping("/product.html")
    public ModelAndView product(){return  new ModelAndView("product");}
    @GetMapping("/checkout.html")
    public ModelAndView checkout(){return  new ModelAndView("checkout");}
    @GetMapping("/UploadProduct.html")
    public ModelAndView UploadProduct(){
        return new ModelAndView("UploadProduct");
    }
    @GetMapping("/OrderCreated.html")
    public ModelAndView OrderCreated(){ return  new ModelAndView("OrderCreated");}
    @PostMapping ("/shoppingcart")
    public R shoppingcart(String str){

          if(str.equals("")){
         return R.Unprocesable_Entity("請先登入後再使用購物車功能");
          }
        else {
            String name=tokens.gettokenname(str);

              return R.ok("ok");
              }

    }
    @GetMapping("/shoppingcart.html")
    public ModelAndView shoppingcart() {
        return new ModelAndView("shoppingcart");
    }
}


