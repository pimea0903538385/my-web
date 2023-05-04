package shop.portal.service;


import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import shop.portal.entity.categories;

import java.util.List;
import java.util.Map;


@Service
public interface categoriesService extends IService<categories> {

    List<categories> getcategories();

    Map<String,categories> getCategoriesMap();
}
