package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Yan on 2017/2/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> seckillList = seckillService.getSeckillList();
        logger.info("list{}",seckillList);
    }

    @Test
    public void getById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill{}",seckill);
    }

    @Test
    public void exportSeckillUrl() throws Exception {
        Exposer exposer = seckillService.exportSeckillUrl(1000);
        logger.info("exposer={}",exposer);
        //Exposer{exposed=true, md5='bb1069fd0bbf00b4f1338b0f24736661', seckillId=1000, now=0, strat=0, end=0}
    }
    @Test
    public void exportSeckillUrlAndExecuteSeckill() throws Exception {
        Exposer exposer = seckillService.exportSeckillUrl(1000);
        if(exposer.isExposed()){
            logger.info("exposer={}",exposer);
            long seckillId = 1000L;
            long userPhone = 15324243234L;
            String md5 = "bb1069fd0bbf00b4f1338b0f24736661";
            try {
                SeckillExecution seckillExecution = seckillService.executeSeckill(seckillId,userPhone,md5);
                logger.info("{}",seckillExecution);
            }catch (SeckillCloseException e){
                logger.warn(e.getMessage());
            }catch (RepeatKillException e){
                logger.warn(e.getMessage());
            }catch (Exception e){
                logger.warn(e.getMessage());
            }
        }else{
            logger.warn("exposer={}",exposer);
        }
    }

    @Test
    public void executeSeckill() throws Exception {
        long seckillId = 1000L;
        long userPhone = 15324243232L;
        String md5 = "bb1069fd0bbf00b4f1338b0f24736661";
//        try {
//            SeckillExecution seckillExecution = seckillService.executeSeckill(seckillId,userPhone,md5);
//            logger.info("{}",seckillExecution);
//        }catch (SeckillCloseException e){
//            logger.warn(e.getMessage());
//        }catch (RepeatKillException e){
//            logger.warn(e.getMessage());
//        }catch (Exception e){
//            logger.warn(e.getMessage());
//        }
    }

}