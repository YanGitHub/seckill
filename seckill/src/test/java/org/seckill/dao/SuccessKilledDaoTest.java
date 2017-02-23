package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Yan on 2017/2/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring 配置文件
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SuccessKilledDaoTest {
    @Resource
    private SuccessKilledDao successKilledDao;

    @Test
    public void insertSuccessKilled() throws Exception {
        int n = successKilledDao.insertSuccessKilled(1000,15316021669L);
        System.out.println("插入条数为：" + n);
    }

    /**  第一次执行
     *   ==>  Preparing: INSERT ignore into success_killed(seckill_id,user_phone) VALUES (?,?)
         ==> Parameters: 1000(Long), 15316021669(Long)
         <==    Updates: 1
     插入条数为：1
     */
    /**
     *  联合主键起作用 PRIMARY KEY (`seckill_id`,`user_phone`) 起作用他俩必须唯一
     *  ==>  Preparing: INSERT ignore into success_killed(seckill_id,user_phone) VALUES (?,?)
        ==> Parameters: 1000(Long), 15316021669(Long)
        <==    Updates: 0
     插入条数为：0
     */

    @Test
    public void queryByIdWithSeckill() throws Exception {
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(1000L,15316021669L);
        System.out.println(successKilled);
    }
    /**
     ==>  Preparing: SELECT sk.seckill_id, sk.user_phone, sk.create_time, sk.state, s.seckill_id "seckill.seckill_id", s.name "seckill.name", s.number "seckill.number", s.start_time "seckill.start_time", s.end_time "seckill.end_time", s.create_time "seckill.create_time" from success_killed sk INNER join seckill s on sk.seckill_id = s.seckill_id where sk.seckill_id = ? and sk.user_phone = ?
     ==> Parameters: 1000(Long), 15316021669(Long)
     <==      Total: 1
     SuccessKilled{seckillId=1000, userPhone=15316021669, state=-1, createTime=Fri Feb 17 10:35:00 CST 2017, seckill=Seckill{seckillId=1000, name='1000元秒杀iphone7', number=99, startTime=Fri Feb 17 10:28:01 CST 2017, endTime=Sat Feb 18 00:00:00 CST 2017, createTime=Thu Feb 16 14:15:04 CST 2017}}
     */

}