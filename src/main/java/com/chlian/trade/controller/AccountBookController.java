package com.chlian.trade.controller;

import com.chlian.trade.domain.AccountBook;
import com.chlian.trade.domain.RestResult;
import com.chlian.trade.domain.vo.AccountBookVo;
import com.chlian.trade.service.IAccountBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.sun.xml.internal.ws.api.model.wsdl.WSDLBoundOperation.ANONYMOUS.optional;

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
     * 账本记录新增，需要传送账本记录，以及账本更新日志
     * @param accountBookVo
     * @Return
     * */
    @RequestMapping(value = "",method = RequestMethod.POST)
    public RestResult<?>  addAccountBook(@RequestBody AccountBookVo accountBookVo){

        try {
            accountBookService.addAccountBook(accountBookVo);
            return new RestResult<>().success("增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResult<>().error(e.getMessage());
        }

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
            AccountBookVo accountBookVo = accountBookService.findById(Integer.parseInt(id));
            return new RestResult<>().success(accountBookVo);
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


    /**
     * 账本记录列表多条件查询
     * @param searchMap 查询条件
     * */
    @RequestMapping(value = "/findBySpec",method=RequestMethod.POST)
    public RestResult<?> findBySpec(@RequestBody Map<String,String> searchMap){
        try {
            List<AccountBookVo> accountBookVos = accountBookService.findBySpec(searchMap);
            return new RestResult<>().success(accountBookVos);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResult<>().error("数据查询出错");
        }
    }

    /**
     *账本记录查询，根据订单号查询
     * @param out_biz_code 订单号
     * */
    @RequestMapping(value = "/out_biz_code/{out_biz_code}",method = RequestMethod.GET)
    public RestResult<?> findByOut_biz_code(@PathVariable(value = "out_biz_code") String out_biz_code){
        try {
            if(out_biz_code == null || "".equals(out_biz_code.trim())){
                return new RestResult<>().error("订单号不能为空");
            }
            List<AccountBookVo> accountBookVos = accountBookService.findByOut_biz_code(out_biz_code.trim());
            return new RestResult<>().success(accountBookVos);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResult<>().error("数据查询出错");
        }
    }

    /**
     *账本记录查询，根据业务序号查询
     * */
    @RequestMapping(value = "/serial_code/{serial_code}",method = RequestMethod.GET)
    public RestResult<?> findByserial_code(@PathVariable(value = "serial_code") String serial_code){
        try {
            if(serial_code == null || "".equals(serial_code.trim())){
                return new RestResult<>().error("业务序列号不能为空");
            }
            List<AccountBookVo> accountBookVos = accountBookService.findBySerial_code(serial_code.trim());
            return new RestResult<>().success(accountBookVos);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResult<>().error("数据查询出错");
        }
    }

}
