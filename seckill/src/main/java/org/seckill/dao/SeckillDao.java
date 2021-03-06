package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Yan on 2017/2/16.
 */
public interface SeckillDao {
    /**
     * 减库存
     * @param seckillId
     * @param killTime
     * @return 如查影响行数 > 1,表示更新的记录行数
     */
    int reduceNumber(@Param(value = "seckillId") long seckillId,
                     @Param(value = "killTime") Date killTime);

    /**
     * 根据id查询秒杀的商品
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     * 根据偏移量查询秒杀商品列表
     * @param offset
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param(value = "offset") int offset, @Param(value = "limit")int limit);

    void killByProcedure(Map<String,Object> paramMap);


}
