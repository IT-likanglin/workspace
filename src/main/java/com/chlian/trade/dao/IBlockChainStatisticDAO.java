package com.chlian.trade.dao;

import com.chlian.trade.domain.BlockChainStatistic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlockChainStatisticDAO extends JpaRepository<BlockChainStatistic, Integer> {
}
