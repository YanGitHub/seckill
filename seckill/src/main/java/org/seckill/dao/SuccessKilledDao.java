package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

/**
 * Created by Yan on 2017/2/16.
 */
public interface SuccessKilledDao {
    /**
     * 插入购买明细，可过滤重复
     * @param seckillId
     * @param userPhone
     * @return 插入的行数
     */
    int insertSuccessKilled(@Param(value = "seckillId") long seckillId,
                            @Param(value = "userPhone") long userPhone);

    /**
     * 根据id查询SuccessKilled 并携带秒杀产品对象实体
     * @param seckillId
     * @return
     */
    SuccessKilled queryByIdWithSeckill(@Param(value = "seckillId") long seckillId,
                                       @Param(value = "userPhone") long userPhone);

}
