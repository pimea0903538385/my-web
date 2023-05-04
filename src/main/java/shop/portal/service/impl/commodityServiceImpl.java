package shop.portal.service.impl;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.devtools.restart.ConditionalOnInitializedRestarter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import shop.portal.entity.commodity;
import shop.portal.mapper.commodityMapper;
import shop.portal.service.commodityService;
import shop.portal.service.ServiceException;
import shop.portal.Vo.R;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;


@Service
@Slf4j
public class commodityServiceImpl extends ServiceImpl<commodityMapper, commodity> implements commodityService {

    @Autowired
    commodityMapper commodityMapper;

    @Override
    public PageInfo<commodity> getCommoditybyID(Integer id,Integer pagenum) {
         Integer PageSize=12;
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("category_id",id);
        PageHelper.startPage(pagenum,PageSize);
         List<commodity> list=commodityMapper.selectList(wrapper);

        return new PageInfo<>(list);
    }

    @Override
    public List<commodity> setCommodityDetailbyID(Integer id) {
        List commodity =commodityMapper.setProductdetailfromID(id);
        log.debug("product {}" , commodity);
        return commodity;
    }

    @Override
    public void UploadProduct( String productName, String productDescription, Integer productPrice, Integer productAmount, MultipartFile[] productImages) throws ServletException, IOException {
        byte[] imageBytes = productImages[0].getBytes();
        commodity commodity=new commodity()
                .setCategoryId(1)
                .setCommodityPrice(productPrice)
                .setCommodityAmount(productAmount)
                .setCommodityName(productName)
                .setCommodityDesciption(productDescription)
                .setCommodityImage(imageBytes);
        commodityMapper.insert(commodity);

    }
}
