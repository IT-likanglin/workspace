package com.chlian.trade.controller;

import com.chlian.trade.domain.AccountBook;
import com.chlian.trade.domain.RestResult;
import com.chlian.trade.service.IAccountBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * 账本Controller
 * @author liujiao
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/accountbook")
public class AccountBookController extends BaseController {

    @Autowired
    private IAccountBookService accountBookService;

    /**
     * 账本记录新增
     * @param accountBook  账本记录
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public RestResult<?> addAccountBook(AccountBook accountBook) {
        try {
            accountBookService.addAccountBook(accountBook);
            return new RestResult<>().success("新增成功");
        } catch (Exception e) {
            logger.error("数据新增失败，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据新增出错");
    }

    /**
     * 根据ID删除交易账本记录
     * @param id 账本ID
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public RestResult<?> deleteStockChangeLogById(@PathVariable(value = "id") String id) {
        try {
            accountBookService.deleteById(Integer.parseInt(id));
            return new RestResult<>().success("删除成功");
        } catch (Exception e) {
            logger.error("数据删除失败，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据删除出错");
    }

    /**
     * 账本记录更新
     * @param id 账本记录ID
     * @param accountBook 需要更新的账本记录
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public RestResult<?> updateOrderItem(@PathVariable(value = "id") String id, AccountBook accountBook) {
        try {
            accountBookService.updateAccountBook(Integer.parseInt(id), accountBook);
            return new RestResult<>().success("更新成功");
        } catch (Exception e) {
            logger.error("数据更新失败，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据更新出错");
    }

    /**
     * 账本记录列表查询
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public RestResult<?> listOrderItems() {
        try {
            List<AccountBook> list = accountBookService.findAll();
            return new RestResult<>().success(list);
        } catch (Exception e) {
            logger.error("数据查询出错，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据查询出错");
    }


    /**
     * 根据ID查询账本记录
     * @return
     */
    @RequestMapping(value = "/{id}")
    public RestResult<?> findById(@PathVariable(value = "id") String id) {
        try {
            Optional optional = accountBookService.findById(Integer.parseInt(id));
            return new RestResult<>().success(optional);
        } catch (Exception e) {
            logger.error("数据查询出错，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据查询出错");
    }

    /**
     * 账本记录列表分页查询
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
            List<AccountBook> list = accountBookService.findAllByPage(Integer.parseInt(page), Integer.parseInt(size));
            return new RestResult<>().success(list);
        } catch (Exception e) {
            logger.error("数据查询出错，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据查询出错");
    }

}
