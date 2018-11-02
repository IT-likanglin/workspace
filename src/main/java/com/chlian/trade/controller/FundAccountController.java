package com.chlian.trade.controller;

import com.chlian.trade.domain.FundAccount;
import com.chlian.trade.domain.RestResult;
import com.chlian.trade.service.IFundAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "fundAccount")
@RestController
public class FundAccountController extends BaseController {

    @Autowired
    private IFundAccountService iFundAccountService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public RestResult<?> findAll () {
        try {
            List<FundAccount> list = iFundAccountService.findAll();
            return new RestResult<>().success(list);
        } catch (Exception e) {
            logger.error("查询出错，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据查询出错");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RestResult<?> findById(@PathVariable(value = "id") Integer id) {
        try {
            Optional<FundAccount> fundAccount = iFundAccountService.findById(id);
            return new RestResult<>().success(fundAccount);
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
            List<FundAccount> list = iFundAccountService.findAllByPage(Integer.parseInt(page), Integer.parseInt(size));
            return new RestResult<>().success(list);
        } catch (Exception e) {
            logger.error("数据查询失败，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据查询失败");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public RestResult<?> deleteByCode(@PathVariable(value = "id") Integer id) {
        try {
            iFundAccountService.deleteById(id);
            return new RestResult<>().success("删除成功");
        } catch (Exception e) {
            logger.error("删除失败，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("删除失败");
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public RestResult<?> addRefund(FundAccount fundAccount) {
        try {
            iFundAccountService.addFundAccount(fundAccount);
            return new RestResult<>().success("新增成功");
        } catch (Exception e) {
            logger.error("新增失败，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("新增失败");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public RestResult updateFundAccount(@PathVariable(value = "id") Integer id, FundAccount fndAccount) {
        try {
            iFundAccountService.updateFundAccount(id, fndAccount);
            return new RestResult<>().success("修改成功");
        } catch (Exception e) {
            logger.error("修改失败，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("修改失败");
    }
}
