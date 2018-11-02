package com.chlian.trade.dao;

import com.chlian.trade.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by liuj on 2018/10/17
 */
public interface IOrderDAO extends JpaRepository<Order, Integer> {

    /**
     * 根据code进行查询
     * @param code
     * @return
     */
    //Order findByCode(String code);

    @Query(value = "select * from orders o where o.code=?", nativeQuery = true)
    List<Order> findByCode(String code);


}
