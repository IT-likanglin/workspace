package com.chlian.trade.service;

import com.chlian.trade.domain.BlockChainStatistic;

import java.util.List;

public interface IBlockChainStatisticService {

    void addBlockChainStatistic(BlockChainStatistic blockChainStatistic);

    void deleteById(Integer idd);

    void updateBlockChainStatistic(Integer id, BlockChainStatistic blockChainStatistic);

    List<BlockChainStatistic> findAll();

    BlockChainStatistic findById(Integer id);

    List<BlockChainStatistic> findAllByPage(Integer page, Integer size);
}
