package com.chlian.trade.controller;

import com.chlian.trade.domain.Order;
import com.chlian.trade.domain.RestResult;
import com.chlian.trade.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController extends BaseController {

    @Autowired
    IOrderService iOrderService;

    /**
     * 订单新增
     * 如果没有code值，则自动生成一个code字段
     *
     * @param order 新增订单
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public RestResult<?> addOrder(Order order) {
        try {
            iOrderService.addOrder(order);
            return new RestResult<>().success("新增成功");
        } catch (Exception e) {
            logger.error("数据新增失败，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据新增出错");
    }

    /**
     * 根据ID进行订单删除
     *
     * @param id 订单ID
     * @return
     */

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public RestResult<?> deleteOrderById(@PathVariable(value = "id") String id) {
        try {
            iOrderService.deleteByCode(id);
            //iOrderDAO.deleteById(id);
            return new RestResult<>().success("删除成功");
        } catch (Exception e) {
            logger.error("数据删除失败，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据删除出错");
    }


    /**
     * 订单更新
     *
     * @param code    订单ID
     * @param order 需要更新的订单数据
     * @return
     */
    @RequestMapping(value = "/{code}", method = RequestMethod.PUT)
    public RestResult<?> updateOrder(@PathVariable(value = "code") String code, Order order) {
        try {
            iOrderService.updateOrder(code, order);
            return new RestResult<>().success("更新成功");
        } catch (Exception e) {
            logger.error("数据更新失败，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据更新出错");
    }

    /**
     * 订单列表查询
     *
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public RestResult<?> listOrders() {
        try {
            List<Order> list = iOrderService.findAll();
            return new RestResult<>().success(list);
        } catch (Exception e) {
            logger.error("数据查询出错，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据查询出错");
    }


    /**
     * 根据ID查询订单
     *
     * @return
     */
    @RequestMapping(value = "/{id}")
    public RestResult<?> findById(@PathVariable(value = "id") String id) {
        try {
            Order order = iOrderService.findById(id);
            return new RestResult<>().success(order);
        } catch (Exception e) {
            logger.error("数据查询出错，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据查询出错");
    }

    /**
     * 订单列表分页查询
     *
     * @param page 请求页
     * @param size 页大小
     * @return
     */
    @RequestMapping(value = "/page/{page}/{size}", method = RequestMethod.GET)
    public RestResult<?> listPageOrders(@PathVariable(value = "page", required = false) String page,
                                        @PathVariable(value = "size", required = false) String size) {
        if (StringUtils.isEmpty(page)) {
            page = "1";
        }
        if (StringUtils.isEmpty(size)) {
            size = "10";
        }

        try {
            Page<Order> orderPage = iOrderService.findAllByPage(Integer.parseInt(page), Integer.parseInt(size));
            List<Order> list = orderPage.getContent();
            return new RestResult<>().success(list);
        } catch (Exception e) {
            logger.error("数据查询出错，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据查询出错");
    }


}
