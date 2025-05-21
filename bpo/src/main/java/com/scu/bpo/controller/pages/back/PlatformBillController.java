package com.scu.bpo.controller.pages.back;

import com.scu.bpo.pojo.entity.Cashflowdetail;
import com.scu.bpo.service.impl.CashFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/pages/back")
public class PlatformBillController {

    @Autowired
    CashFlowService cashFlowService;

    @RequestMapping("/ShowPlatformBill")
    public String ShowPlatformBill(Model model){
        List<Cashflowdetail> list = cashFlowService.SelectAll();
        model.addAttribute("Bills",list);
        return "/pages/back/PlatformBill";
    }

}
