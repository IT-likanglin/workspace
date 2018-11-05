package com.chlian.trade.controller;

import com.chlian.trade.domain.AccountBookLog;
import com.chlian.trade.domain.RestResult;
import com.chlian.trade.service.IAccountBookLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * 交易账本变更记录
 */
@RestController
@RequestMapping(value = "/log/accountbook")
public class AccountBookLogController extends BaseController {

    @Autowired
    private IAccountBookLogService accountBookLogService;

    /**
     * 数据新增
     * @param accountBookLog
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public RestResult<?> addAccountBook(AccountBookLog accountBookLog) {
        try {
            accountBookLogService.addAccountBookLog(accountBookLog);
            return new RestResult<>().success("新增成功");
        } catch (Exception e) {
            logger.error("数据新增失败，详细信息：" + e.getMessage());
            e.printStackTrace();
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
            accountBookLogService.deleteById(id);
            return new RestResult<>().success("删除成功");
        } catch (Exception e) {
            logger.error("数据删除失败，详细信息：" + e.getMessage());
            e.printStackTrace();
        }
        return new RestResult<>().error("数据删除出错");
    }

    /**
     * 账本记录更新
     * @param id 账本记录ID
     * @param accountBookLog 需要更新的账本记录
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public RestResult<?> updateOrderItem(@PathVariable(value = "id") String id, AccountBookLog accountBookLog) {
        try {
            accountBookLogService.updateAccountBookLog(id, accountBookLog);
            return new RestResult<>().success("更新成功");
        } catch (Exception e) {
            logger.error("数据更新失败，详细信息：" + e.getMessage());
            e.printStackTrace();
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
            List<AccountBookLog> list = accountBookLogService.findAll();
            return new RestResult<>().success(list);
        } catch (Exception e) {
            logger.error("数据查询出错，详细信息：" + e.getMessage());
            e.printStackTrace();
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
            Optional optional = accountBookLogService.findById(id);
            return new RestResult<>().success(optional);
        } catch (Exception e) {
            logger.error("数据查询出错，详细信息：" + e.getMessage());
            e.printStackTrace();
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
            List<AccountBookLog> list = accountBookLogService.findAllByPage(Integer.parseInt(page), Integer.parseInt(size));
            return new RestResult<>().success(list);
        } catch (Exception e) {
            logger.error("数据查询出错，详细信息：" + e.getMessage());
            e.printStackTrace();
        }
        return new RestResult<>().error("数据查询出错");
    }

    /**
     * 根据id修改日志的审核状态
     * @param status 审核状态
     * @return
     * */
    @RequestMapping(value = "/{id}/{status}",method = RequestMethod.PUT)
    public RestResult<?> updateStatus(@PathVariable(value = "id") String id,@PathVariable(value = "status") Integer status){
        try {
            accountBookLogService.updateStatus(id,status);
            return new RestResult<>().success("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResult<>().error("修改失败");
        }
    }

}
