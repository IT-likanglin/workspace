package com.chlian.trade.service.impl;

import com.chlian.trade.dao.IStockItemDAO;
import com.chlian.trade.domain.StockItem;
import com.chlian.trade.service.IStockItemService;
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
import java.util.Optional;

@Service
public class StockItemService implements IStockItemService {


    @Autowired
    private IStockItemDAO iStockItemDAO;


    @Override
    @Cacheable(value = "secondlevels", key = "#stockItem1")
    public List<StockItem> findAll() {
        return iStockItemDAO.findAll();
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#stockItem2")
    public Optional<StockItem> findById(Integer id) {
        return iStockItemDAO.findById(id);
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#stockItem3")
    public List<StockItem> findAllByPage(int page, int size) {
        Pageable pageable = new PageRequest(page, size);
        Page<StockItem> stockItems = iStockItemDAO.findAll(pageable);
        return stockItems.getContent();
    }

    @Override
    @Transactional
    @Modifying
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void deleteById(Integer id) {
        iStockItemDAO.deleteById(id);
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void addStockItem(StockItem stockItem) {
        iStockItemDAO.save(stockItem);
    }

    @Override
    @Transactional
    @Modifying
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void updateStockItem(Integer id, StockItem stockItem) {
        StockItem updateStockItem = iStockItemDAO.getOne(id);

        if(stockItem.getCategory_code() != null) {
            updateStockItem.setCategory_code(stockItem.getCategory_code());
        }
        if(stockItem.getCreated_at() != null) {
            updateStockItem.setCreated_at(stockItem.getCreated_at());
        }
        if(stockItem.getDescription() != null) {
            updateStockItem.setDescription(stockItem.getDescription());
        }
        if(stockItem.getGroup_code() != null) {
            updateStockItem.setGroup_code(stockItem.getGroup_code());
        }
        if(stockItem.getItem_code() != null) {
            updateStockItem.setItem_code(stockItem.getItem_code());
        }
        if(stockItem.getItem_type() != null) {
            updateStockItem.setItem_type(stockItem.getItem_type());
        }
        if(stockItem.getName() != null) {
            updateStockItem.setName(stockItem.getName());
        }
        if(stockItem.getUpdated_at() != null) {
            updateStockItem.setUpdated_at(stockItem.getUpdated_at());
        }
        if(stockItem.getStock() != null) {
            updateStockItem.setStock(stockItem.getStock());
        }
        if(stockItem.getVirtual_item() != null) {
            updateStockItem.setVirtual_item(stockItem.getVirtual_item());
        }
    }

    @Override
    @Transactional
    @Cacheable(value = "secondlevels", key = "#stockItem4")
    public List<StockItem> findByCreated_at(Long stock) {
        return iStockItemDAO.findByStock(stock);
    }
}
