package com.chlian.trade.controller;

import com.chlian.trade.service.ITradeMasterAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tradeaccount")
public class TradeMasterAccountController {

    @Autowired
    private ITradeMasterAccountService tradeMasterAccountService;


};

