package shop.portal.controller;


import shop.portal.Vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import shop.portal.entity.categories;
import shop.portal.service.categoriesService;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class categoriesController {

   @Autowired
   categoriesService categoriesService;

   @GetMapping()
    public R<List<categories>> sercategories(){
       List list=categoriesService.getcategories();
       return R.ok(list);


   }
}

