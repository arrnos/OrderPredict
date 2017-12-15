package com.arrnos.controller;

import com.arrnos.model.User;
import com.arrnos.service.OnlineFeatureProcessService;
import com.arrnos.service.XgbPredict;
import ml.dmlc.xgboost4j.java.XGBoostError;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreditPredict {
    private static final Log logger =
            LogFactory.getLog(CreditPredict.class);

    @Autowired
    private OnlineFeatureProcessService online;

    @Autowired
    private XgbPredict xgbPre;

    @GetMapping("/credit")
    public String creditForm(Model model) {
        model.addAttribute("user", new User());
        return "creditForm";
    }

    @PostMapping("/credit")
    public String result(@ModelAttribute User user) throws XGBoostError {
        online.featureProcess(user);
        logger.info("feature process completeed");
        int predictResult = 0;
        predictResult = xgbPre.predict();
        if (predictResult == 1)
            return "passedResult";
        else
            return "failedResult";
    }
}
