package com.flc.ssxa.service;


import com.flc.ssxa.domain.Goods;
import com.flc.ssxa.dto.GoodsStockDTO;

public interface IGoodsService {

    /**
     * save goods.
     *
     * @param goods goods
     */
    void save(Goods goods);

    /**
     * select goods by id.
     *
     * @param id goods id
     * @return goods
     */
    Goods selectById(long id);

    /**
     * buy goods.
     *
     * @param goodsStockDTO {@linkplain GoodsStockDTO}
     */
    void buy(GoodsStockDTO goodsStockDTO);

    /**
     * buy goods.
     *
     * @param goodsStockDTO {@linkplain GoodsStockDTO}
     */
    void buyException(GoodsStockDTO goodsStockDTO);

}
