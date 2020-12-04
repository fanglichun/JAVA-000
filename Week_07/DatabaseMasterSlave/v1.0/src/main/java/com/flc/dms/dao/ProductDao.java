package com.flc.dms.dao;

import com.flc.dms.annotation.TargetDataSource;
import com.flc.dms.enums.DataSourceKey;
import com.flc.dms.modal.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductDao {

    Product select(@Param("id") long id);

    Integer update(Product product);

    Integer insert(Product product);

    Integer delete(long productId);

    List<Product> getAllProduct();
}
