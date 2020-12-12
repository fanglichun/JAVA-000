package com.flc.ssxa.mapper;

import com.flc.ssxa.domain.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GoodsMapper {

    /**
     * save goods.
     *
     * @param goods goods
     */
    void save(@Param("goods") Goods goods);

    /**
     * select goods by id.
     *
     * @param id goods id
     * @return goods
     */
    Goods selectById(long id);

    /**
     * lock stock.
     *
     * @param id       goods id
     * @param quantity quantity
     */
    void reduceStock(long id, int quantity);

}
