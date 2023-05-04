package shop.portal.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import shop.portal.entity.commodity;
import shop.portal.Vo.R;
import shop.portal.service.commodityService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("")
public class commodityController {

    @Autowired
    commodityService commodityService;


    @GetMapping("/commodity/{id}")
    public R<PageInfo<commodity>> setCommodity(@PathVariable Integer id,Integer pagenum){
         PageInfo<commodity> pageinfo=commodityService.getCommoditybyID(id,pagenum);
        return  R.ok(pageinfo);
    }
    @GetMapping("/commodity/detail/{id}")
    public  R<commodity> setCommodityDetail(@PathVariable Integer id){

        List<commodity> commodityDetail=commodityService.setCommodityDetailbyID(id);
        return R.ok(commodityDetail);
    }
    @PostMapping("/UploadProduct")
    public R UploadProduct(@RequestParam("ProductName") String productName,
                             @RequestParam("ProductDescription") String productDescription,
                             @RequestParam("ProductPrice") int productPrice,
                             @RequestParam("ProductAmount") int productAmount,
                             @RequestParam("ProductImages") MultipartFile[] productImages, HttpServletResponse response) throws ServletException, SQLException, IOException {
        commodityService.UploadProduct(productName,productDescription,productPrice,productAmount,productImages);
        return R.ok("OK");
    }

}

