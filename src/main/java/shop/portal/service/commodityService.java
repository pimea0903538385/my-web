package shop.portal.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import shop.portal.entity.commodity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;



public interface commodityService extends IService<commodity> {

   PageInfo<commodity> getCommoditybyID(Integer id,Integer pagenum);

    List<commodity> setCommodityDetailbyID(Integer id);

    void UploadProduct(String productName, String productDescription, Integer productPrice, Integer productAmount, MultipartFile[] productImages) throws ServletException, IOException;
}
