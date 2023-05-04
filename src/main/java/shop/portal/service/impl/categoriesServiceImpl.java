package shop.portal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import shop.portal.entity.categories;
import shop.portal.mapper.categoriesMapper;
import shop.portal.service.categoriesService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;


@Service
@Slf4j
public class categoriesServiceImpl extends ServiceImpl<categoriesMapper, categories> implements categoriesService {

    private  final List<categories> category=new CopyOnWriteArrayList<>();
    private  final Map<String,categories> categoriesMap=new ConcurrentHashMap<>();

    @Override
    public List<categories> getcategories() {
        if(category.isEmpty()) {
            synchronized (category) {
                if(category.isEmpty()){
                    category.addAll(list());
                    category.forEach(category -> categoriesMap.put(category.getName(), category));
                    log.debug("{}" ,category);
                }
            }
        }
        return category;
    }


    public Map<String,categories> getCategoriesMap(){
        if(categoriesMap.isEmpty()){
            getcategories();
        }
        return categoriesMap;
    }
}
