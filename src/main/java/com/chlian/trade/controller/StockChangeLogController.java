package com.chlian.trade.controller;


import com.chlian.trade.domain.RestResult;
import com.chlian.trade.domain.StockChangeLog;
import com.chlian.trade.service.impl.StockChangeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * 库存更改日志
 */
@RequestMapping(value = "/log/stock")
@RestController
public class StockChangeLogController extends BaseController {

   @Autowired
    private StockChangeLogService stockChangeLogService;

    /**
     * 库存详情新增
     * @param stockChangeLog 库存详情数据
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public RestResult<?> addOrderItem(StockChangeLog stockChangeLog) {
        try {
            stockChangeLogService.addStockChangeLog(stockChangeLog);
            return new RestResult<>().success("新增成功");
        } catch (Exception e) {
            logger.error("数据新增失败，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据新增出错");
    }

    /**
     * 根据ID进行库存详情删除
     * @param id 库存ID
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public RestResult<?> deleteStockChangeLogById(@PathVariable(value = "id") String id) {
        try {
            stockChangeLogService.deleteById(Long.parseLong(id));
            return new RestResult<>().success("删除成功");
        } catch (Exception e) {
            logger.error("数据删除失败，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据删除出错");
    }

    /**
     * 库存详情更新
     * @param id 库存详情ID
     * @param stockChangeLog 需要更新的库存详情数据
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public RestResult<?> updateOrderItem(@PathVariable(value = "id") String id, StockChangeLog stockChangeLog) {
        try {
            stockChangeLogService.updateStockChangeLog(Long.parseLong(id), stockChangeLog);
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
            List<StockChangeLog> list = stockChangeLogService.findAll();
            return new RestResult<>().success(list);
        } catch (Exception e) {
            logger.error("数据查询出错，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据查询出错");
    }


    /**
     * 根据ID查询库存详情
     * @return
     */
    @RequestMapping(value = "/{id}")
    public RestResult<?> findById(@PathVariable(value = "id") String id) {
        try {
            Optional optional = stockChangeLogService.findById(Long.parseLong(id));
            return new RestResult<>().success(optional);
        } catch (Exception e) {
            logger.error("数据查询出错，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据查询出错");
    }

    /**
     * 库存详细列表分页查询
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
            List<StockChangeLog> list = stockChangeLogService.findAllByPage(Integer.parseInt(page), Integer.parseInt(size));
            return new RestResult<>().success(list);
        } catch (Exception e) {
            logger.error("数据查询出错，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据查询出错");
    }


}
