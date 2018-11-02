package com.chlian.trade.controller;

import com.chlian.trade.domain.OrderItem;
import com.chlian.trade.domain.RestResult;
import com.chlian.trade.service.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * 订单详情Rest
 */
@RestController
@RequestMapping("/order/item")
public class OrderItemController extends BaseController{

    //@Autowired
    //private IOrderItemDAO iOrderItemDAO;

    @Autowired
    private IOrderItemService iOrderItemService;

    /**
     * 订单详情新增
     * @param orderItem 订单详情数据
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public RestResult<?> addOrderItem(OrderItem orderItem) {
        try {
            iOrderItemService.save(orderItem);
            return new RestResult<>().success("新增成功");
        } catch (Exception e) {
            logger.error("数据新增失败，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据新增出错");
    }

    /**
     * 根据ID进行订单详情删除
     * @param id 订单ID
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public RestResult<?> deleteOrderItemById(@PathVariable(value = "id") Integer id) {
        try {
            iOrderItemService.deleteById(id);
            return new RestResult<>().success("删除成功");
        } catch (Exception e) {
            logger.error("数据删除失败，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据删除出错");
    }

    /**
     * 订单详情更新
     * @param id 订单详情ID
     * @param orderItem 需要更新的订单详情数据
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public RestResult<?> updateOrderItem(@PathVariable(value = "id") Integer id, OrderItem orderItem) {
        try {
            iOrderItemService.updateById(id, orderItem);
            return new RestResult<>().success("更新成功");
        } catch (Exception e) {
            logger.error("数据更新失败，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据更新出错");
    }

    /**
     * 订单详情列表查询
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public RestResult<?> listOrderItems() {
        try {
            List<OrderItem> list = iOrderItemService.findAll();
            return new RestResult<>().success(list);
        } catch (Exception e) {
            logger.error("数据查询出错，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据查询出错");
    }


    /**
     * 根据ID查询订单详情
     * @return
     */
    @RequestMapping(value = "/{id}")
    public RestResult<?> findById(@PathVariable(value = "id") Integer id) {
        try {
            Optional optional = iOrderItemService.findById(id);
            return new RestResult<>().success(optional);
        } catch (Exception e) {
            logger.error("数据查询出错，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据查询出错");
    }

    /**
     * 订单详细列表分页查询
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
        if(StringUtils.isEmpty(size)) {
            size = "10";
        }

        try {
            List<OrderItem> list = iOrderItemService.findByPage(Integer.parseInt(page), Integer.parseInt(size));
            return new RestResult<>().success(list);
        } catch (Exception e) {
            logger.error("数据查询出错，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据查询出错");
    }


}
