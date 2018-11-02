package com.chlian.trade.controller;

import com.chlian.trade.domain.InviteCodePurchaseRecord;
import com.chlian.trade.domain.RestResult;
import com.chlian.trade.service.IInviteCodePurchaseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/inviteCodePurchase")
public class InviteCodePurchaseRecordConrtoller extends BaseController{

    @Autowired
    private IInviteCodePurchaseRecordService iInviteCodePurchaseRecordService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public RestResult<?> findAll () {
        try {
            List<InviteCodePurchaseRecord> list = iInviteCodePurchaseRecordService.findAll();
            return new RestResult<>().success(list);
        } catch (Exception e) {
            logger.error("查询出错，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据查询出错");
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public RestResult<?> findByCode(@PathVariable(value = "code") String code) {
        try {
            InviteCodePurchaseRecord inviteCodePurchaseRecord = iInviteCodePurchaseRecordService.findByCode(code);
            return new RestResult<>().success(inviteCodePurchaseRecord);
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
            List<InviteCodePurchaseRecord> list = iInviteCodePurchaseRecordService.findAllByPage(Integer.parseInt(page), Integer.parseInt(size));
            return new RestResult<>().success(list);
        } catch (Exception e) {
            logger.error("数据查询失败，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("数据查询失败");
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.DELETE)
    public RestResult<?> deleteByCode(@PathVariable(value = "code") String code) {
        try {
            iInviteCodePurchaseRecordService.deleteByCode(code);
            return new RestResult<>().success("删除成功");
        } catch (Exception e) {
            logger.error("删除失败，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("删除失败");
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public RestResult<?> addInviteCodePurchaseRecord(InviteCodePurchaseRecord inviteCodePurchaseRecord) {
        try {
            iInviteCodePurchaseRecordService.addRefund(inviteCodePurchaseRecord);
            return new RestResult<>().success("新增成功");
        } catch (Exception e) {
            logger.error("新增失败，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("新增失败");
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.PUT)
    public RestResult updateInviteCodePurchaseRecord(@PathVariable(value = "code") String code, InviteCodePurchaseRecord inviteCodePurchaseRecord) {
        try {
            iInviteCodePurchaseRecordService.updateRefund(code, inviteCodePurchaseRecord);
            return new RestResult<>().success("修改成功");
        } catch (Exception e) {
            logger.error("修改失败，详细信息：" + e.getMessage());
        }
        return new RestResult<>().error("修改失败");
    }

}
