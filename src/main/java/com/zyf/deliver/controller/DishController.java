package com.zyf.deliver.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyf.deliver.common.R;
import com.zyf.deliver.dto.DishDto;
import com.zyf.deliver.entity.Category;
import com.zyf.deliver.entity.Dish;
import com.zyf.deliver.service.DishFlavorService;
import com.zyf.deliver.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 菜品管理
 */
@Slf4j
@RestController
@RequestMapping("/dish")
public class DishController {

    @Autowired
    private DishService dishService;

    @Autowired
    private DishFlavorService dishFlavorService;

    @PostMapping
    public R<Page> save(@RequestBody DishDto dishDto){
        log.info(dishDto.toString());

        return null;
    }


    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
//    @GetMapping("/page")
//    public R<Page> page(int page, int pageSize){
//        log.info("page = {}, pageSize = {}",page,pageSize);
//
//        Page<Dish> pageInfo = new Page<>(page, pageSize);
//        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper();
//        queryWrapper.orderByAsc(Dish::getSort);
//
//        dishService.page(pageInfo, queryWrapper);
//
//        return R.success(pageInfo);
//    }
}
