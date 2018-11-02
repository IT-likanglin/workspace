package com.chlian.trade.controller;

import com.chlian.trade.domain.BalanceFundChangeLog;
import com.chlian.trade.domain.RestResult;
import com.chlian.trade.service.IBalanceFundChangeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/balancelog")
@RestController
public class BalanceFundChangeLogController extends BaseController{

    @Autowired
    private IBalanceFundChangeLogService iBalanceFundChangeLogService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public RestResult<?> findAll () {
        try {
            List<BalanceFundChangeLog> list = iBalanceFundChangeLogService.findAll();
            return new RestResult<>().success(list);
        } catch (Exception e) {
            logger.error("查询出错，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据查询出错");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RestResult<?> findById(@PathVariable(value = "id") String id) {
        try {
            BalanceFundChangeLog balanceFundChangeLog = iBalanceFundChangeLogService.findById(Long.parseLong(id));
            return new RestResult<>().success(balanceFundChangeLog);
        } catch (Exception e) {
            logger.error("数据查询失败，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据查询失败");
    }

    @RequestMapping(value = "/page/{page}/{size}", method = RequestMethod.GET)
    public RestResult findAllByPage(@PathVariable(value = "page") String  page, @PathVariable(value = "size") String size) {
        if (StringUtils.isEmpty(page)) {
            page = "1";
        }
        if (StringUtils.isEmpty(size)) {
            size = "10";
        }
        try {
            List<BalanceFundChangeLog> list = iBalanceFundChangeLogService.findAllByPage(Integer.parseInt(page), Integer.parseInt(size));
            return new RestResult<>().success(list);
        } catch (Exception e) {
            logger.error("数据查询失败，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据查询失败");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public RestResult<?> deleteById(@PathVariable(value = "id") String id) {
        try {
            iBalanceFundChangeLogService.deleteById(Long.parseLong(id));
            return new RestResult<>().success("删除成功");
        } catch (Exception e) {
            logger.error("删除失败，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("删除失败");
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public RestResult<?> addiBalanceFundChangeLogService(BalanceFundChangeLog balanceFundChangeLog) {
        try {
            iBalanceFundChangeLogService.addBalanceFundChangeLog(balanceFundChangeLog);
            return new RestResult<>().success("新增成功");
        } catch (Exception e) {
            logger.error("新增失败，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("新增失败");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public RestResult updateiBalanceFundChangeLogService(@PathVariable(value = "id") String  id, BalanceFundChangeLog balanceFundChangeLog) {
        try {
            iBalanceFundChangeLogService.updateBalanceFundChangeLog(Long.parseLong(id), balanceFundChangeLog);
            return new RestResult<>().success("修改成功");
        } catch (Exception e) {
            logger.error("修改失败，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("修改失败");
    }
}
