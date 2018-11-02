package com.chlian.trade.controller;

import com.chlian.trade.domain.RestResult;
import com.chlian.trade.domain.StockItem;
import com.chlian.trade.service.IStockItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * 库存
 */
@RestController
@RequestMapping(value = "/stock")
public class StockItemController extends BaseController{

    //

    @Autowired
    private IStockItemService iStockItemService;


    /**
     * 库存详情新增
     * @param stockItem 库存详情数据
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public RestResult<?> addOrderItem(StockItem stockItem) {
        try {
            iStockItemService.addStockItem(stockItem);
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
    public RestResult<?> deleteOrderItemById(@PathVariable(value = "id") Integer id) {
        try {
            iStockItemService.deleteById(id);
            return new RestResult<>().success("删除成功");
        } catch (Exception e) {
            logger.error("数据删除失败，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据删除出错");
    }

    /**
     * 库存详情更新
     * @param id 库存详情ID
     * @param stockItem 需要更新的库存详情数据
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public RestResult<?> updateOrderItem(@PathVariable(value = "id") Integer id, StockItem stockItem) {
        try {
            iStockItemService.updateStockItem(id, stockItem);
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
            List<StockItem> list = iStockItemService.findAll();
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
    public RestResult<?> findById(@PathVariable(value = "id") Integer id) {
        try {
            Optional optional = iStockItemService.findById(id);
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
            List<StockItem> list = iStockItemService.findAllByPage(Integer.parseInt(page), Integer.parseInt(size));
            return new RestResult<>().success(list);
        } catch (Exception e) {
            logger.error("数据查询出错，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据查询出错");
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public RestResult<?> get(String stock) {
        List<StockItem> createdAt = iStockItemService.findByCreated_at(Long.parseLong(stock));
        return new RestResult<>().success(createdAt);
    }

}
