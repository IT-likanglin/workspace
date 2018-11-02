package com.chlian.trade.service.impl;

import com.chlian.trade.dao.IBlockChainStatisticDAO;
import com.chlian.trade.domain.BlockChainStatistic;
import com.chlian.trade.service.IBlockChainStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BlockChainStatisticService implements IBlockChainStatisticService {

    @Autowired
    private IBlockChainStatisticDAO iBlockChainStatisticDAO;

    @Override
    @Cacheable(value = "secondlevels", key = "#blockChainsta1")
    public List<BlockChainStatistic> findAll() {
        return iBlockChainStatisticDAO.findAll();
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#blockChainsta2")
    public BlockChainStatistic findById(Integer id) {
        return iBlockChainStatisticDAO.getOne(id);
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#blockChainsta3")
    public List<BlockChainStatistic> findAllByPage(Integer page, Integer size) {
        Pageable pageable = new PageRequest(page, size);
        Page<BlockChainStatistic> blockChainStatistics = iBlockChainStatisticDAO.findAll(pageable);
        return blockChainStatistics.getContent();
    }

    @Override
    @Transactional
    @Modifying
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void deleteById(Integer id) {
        iBlockChainStatisticDAO.deleteById(id);
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void addBlockChainStatistic(BlockChainStatistic blockChainStatistic) {
        iBlockChainStatisticDAO.save(blockChainStatistic);
    }

    @Override
    @Transactional
    @Modifying
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void updateBlockChainStatistic(Integer id, BlockChainStatistic blockChainStatistic) {
        BlockChainStatistic updateBlockChainStatistic = iBlockChainStatisticDAO.getOne(id);

        if(blockChainStatistic.getCcm_dispatched() != null) {
            updateBlockChainStatistic.setCcm_dispatched(blockChainStatistic.getCcm_dispatched());
        }
        if(blockChainStatistic.getCreated_at() != null) {
            updateBlockChainStatistic.setCreated_at(blockChainStatistic.getCreated_at());
        }
        if(blockChainStatistic.getTurnover() != null) {
            updateBlockChainStatistic.setTurnover(blockChainStatistic.getTurnover());
        }
        if(blockChainStatistic.getUpdated_at() != null) {
            updateBlockChainStatistic.setUpdated_at(blockChainStatistic.getUpdated_at());
        }

    }
}
