package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 配置spring 和 junit 整合，junit 启动时加载springIoc容器
 * spring-test ,junit
 * Created by Yan on 2017/2/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring 配置文件
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SeckillDaoTest {
    @Resource
    private SeckillDao seckillDao;

    @Test
    public void reduceNumber() throws Exception {
        int n = seckillDao.reduceNumber(1000L,new Date());
        System.out.println(n);
    }

    @Test
    public void queryById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill);
    }
    /**
     * Seckill{
         * seckillId=1000,
         * name='1000元秒杀iphone7',
         * number=100,
         * startTime=Thu Feb 16 00:00:00 CST 2017,
         * endTime=Fri Feb 17 00:00:00 CST 2017,
         * createTime=Thu Feb 16 14:15:04 CST 2017
     * }
     */

    @Test
    public void queryAll() throws Exception {
        List<Seckill> seckillList = seckillDao.queryAll(0,10);
        for(Seckill s : seckillList){
            System.out.println(s);
        }
    }
    /**
     *  Seckill{seckillId=1000, name='1000元秒杀iphone7', number=100, startTime=Thu Feb 16 00:00:00 CST 2017, endTime=Fri Feb 17 00:00:00 CST 2017, createTime=Thu Feb 16 14:15:04 CST 2017}
        Seckill{seckillId=1001, name='500元秒杀ipad mini4', number=100, startTime=Thu Feb 16 00:00:00 CST 2017, endTime=Fri Feb 17 00:00:00 CST 2017, createTime=Thu Feb 16 14:15:04 CST 2017}
        Seckill{seckillId=1002, name='300元秒杀ipad mini2', number=100, startTime=Thu Feb 16 00:00:00 CST 2017, endTime=Fri Feb 17 00:00:00 CST 2017, createTime=Thu Feb 16 14:15:04 CST 2017}
        Seckill{seckillId=1003, name='200元秒杀小米4', number=100, startTime=Thu Feb 16 00:00:00 CST 2017, endTime=Fri Feb 17 00:00:00 CST 2017, createTime=Thu Feb 16 14:15:04 CST 2017}
     */

}