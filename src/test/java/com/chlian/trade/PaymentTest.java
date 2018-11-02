package com.chlian.trade;

import com.chlian.trade.dao.IPaymentDAO;
import com.chlian.trade.domain.Payment;
import com.chlian.trade.utils.UUIDUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentTest {

    @Autowired
    private IPaymentDAO iPaymentDAO;

    @Test
    public void contextLoads() {
        Payment payment = new Payment();
        payment.setUuid(UUIDUtils.getUUID());
        payment.setCode("cpde");
        payment.setTrigger("trigger");
        payment.setStatus(1);
        payment.setPlatform_no("1");
        payment.setPlatform(1);
        payment.setPaid_at("paid+at");
        payment.setPaid(1);

        iPaymentDAO.save(payment);
    }

}
