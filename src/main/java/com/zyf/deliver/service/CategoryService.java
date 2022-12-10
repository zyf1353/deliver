package com.zyf.deliver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyf.deliver.entity.Category;

public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
