package com.zyf.deliver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyf.deliver.common.CustomException;
import com.zyf.deliver.entity.Category;
import com.zyf.deliver.entity.Dish;
import com.zyf.deliver.entity.Setmeal;
import com.zyf.deliver.mapper.CategoryMapper;
import com.zyf.deliver.service.CategoryService;
import com.zyf.deliver.service.DishService;
import com.zyf.deliver.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService{

    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;

    /**
     * 根据id删除分类，在删除前判断是否与菜品关联
     * @param id
     */
    @Override
    public void remove(Long id) {
        //关联菜品
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId, id);
        int dishCount = dishService.count(dishLambdaQueryWrapper);
        if(dishCount > 0){
            //异常类
            throw new CustomException("当前分类下关联了菜品，无法删除，请删除对应菜品后再删除");
        }
        //关联套餐
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId, id);
        int setmealCount = setmealService.count(setmealLambdaQueryWrapper);
        if(setmealCount > 0){
            //异常类
            throw new CustomException("当前分类下关联了套餐，无法删除，请删除对应套餐后再删除");
        }

        //无关联
        super.removeById(id);

    }
}
