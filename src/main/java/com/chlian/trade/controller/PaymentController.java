package com.chlian.trade.controller;

import com.chlian.trade.domain.Payment;
import com.chlian.trade.domain.RestResult;
import com.chlian.trade.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController extends BaseController {

    @Autowired
    IPaymentService iPaymentService;

    /**
     * payment新增
     * @param payment 新增payment
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public RestResult<?> addPayment(Payment payment) {
        try {
            iPaymentService.addPayment(payment);
            return new RestResult<>().success("新增成功");
        } catch (Exception e) {
            logger.error("数据新增失败，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据新增出错");
    }

    /**
     * 根据code进行payment删除
     * @param code payment code
     * @return
     */

    @RequestMapping(value = "/{code}", method = RequestMethod.DELETE)
    public RestResult<?> deletePaymentById(@PathVariable(value = "code") String code) {
        try {
            iPaymentService.deleteByCode(code);
            return new RestResult<>().success("删除成功");
        } catch (Exception e) {
            logger.error("数据删除失败，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据删除出错");
    }


    /**
     * payment更新
     *
     * @param code    payment code
     * @param payment 需要更新的payment数据
     * @return
     */
    @RequestMapping(value = "/{code}", method = RequestMethod.PUT)
    public RestResult<?> updatePayment(@PathVariable(value = "code") String code, Payment payment) {
        try {
            iPaymentService.updatePayment(code, payment);
            return new RestResult<>().success("更新成功");
        } catch (Exception e) {
            logger.error("数据更新失败，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据更新出错");
    }

    /**
     * payment列表查询
     *
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public RestResult<?> listPayments() {
        try {
            List<Payment> list = iPaymentService.findAll();
            return new RestResult<>().success(list);
        } catch (Exception e) {
            logger.error("数据查询出错，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据查询出错");
    }


    /**
     * 根据code查询payment
     *
     * @return
     */
    @RequestMapping(value = "/{code}")
    public RestResult<?> findByCode(@PathVariable(value = "code") String  code) {
        try {
            Payment payment = iPaymentService.findById(code);
            return new RestResult<>().success(payment);
        } catch (Exception e) {
            logger.error("数据查询出错，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据查询出错");
    }

    /**
     * payment列表分页查询
     *
     * @param page 请求页
     * @param size 页大小
     * @return
     */
    @RequestMapping(value = "/page/{page}/{size}", method = RequestMethod.GET)
    public RestResult<?> listPagePayments(@PathVariable(value = "page", required = false) String page,
                                        @PathVariable(value = "size", required = false) String size) {
        if (StringUtils.isEmpty(page)) {
            page = "1";
        }
        if (StringUtils.isEmpty(size)) {
            size = "10";
        }

        try {
            Page<Payment> paymentPage = iPaymentService.findAllByPage(Integer.parseInt(page), Integer.parseInt(size));
            List<Payment> list = paymentPage.getContent();
            return new RestResult<>().success(list);
        } catch (Exception e) {
            logger.error("数据查询出错，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据查询出错");
    }

}
