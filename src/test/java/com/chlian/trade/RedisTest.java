package com.chlian.trade;

import com.chlian.trade.dao.IAccountBookDAO;
import com.chlian.trade.dao.IAccountBookLogDAO;
import com.chlian.trade.domain.AccountBook;
import com.chlian.trade.domain.AccountBookLog;
import com.chlian.trade.domain.vo.AccountBookVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import javax.persistence.criteria.*;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TradeApplication.class})
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private IAccountBookDAO iAccountBookDAO;

    @Autowired
    IAccountBookLogDAO iAccountBookLogDAO;

    @Test
    public void test(){
        redisTemplate.boundHashOps("String").get("sss");
    }

    @Test
    public void testJson(){
        AccountBookVo accountBookVo = new AccountBookVo();
        Specification<AccountBook> spec = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder cb) {
                Path serial_code = root.get("serial_code");
                Predicate pre = cb.equal(serial_code, "ssss");
                return pre;
            }
        };
        List<AccountBook> all = iAccountBookDAO.findAll(spec);
        AccountBookLog accountBookLog = iAccountBookLogDAO.findById("ssss").get();
        accountBookVo.setAccountBooks(all);
        accountBookVo.setAccountBookLog(accountBookLog);
        ObjectMapper om = new ObjectMapper();
        try {
            String s = om.writeValueAsString(accountBookVo);
            System.out.println(s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1(){
        AccountBookVo accountBookVo = new AccountBookVo();
        Specification<AccountBook> spec = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder cb) {
                Path serial_code = root.get("created_at");
                Predicate pre = cb.greaterThanOrEqualTo(serial_code, "2018-11-05 03:16:38");
                return pre;
            }
        };
        List<AccountBook> all = iAccountBookDAO.findAll(spec);
    }
}
