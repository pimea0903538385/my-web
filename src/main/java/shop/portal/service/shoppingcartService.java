package shop.portal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestParam;
import shop.portal.Vo.R;
import shop.portal.entity.shoppingcart;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface shoppingcartService extends IService<shoppingcart> {
    void CheckOrder(HttpServletRequest request ,Integer[] productId,Integer[] productAmount,Integer[] productPrice);
    List<shoppingcart> OrderCreated(String jwt);
}
