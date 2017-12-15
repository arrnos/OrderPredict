package com.arrnos.service;

import com.arrnos.controller.CreditPredict;
import ml.dmlc.xgboost4j.java.Booster;
import ml.dmlc.xgboost4j.java.DMatrix;
import ml.dmlc.xgboost4j.java.XGBoost;
import ml.dmlc.xgboost4j.java.XGBoostError;
import org.springframework.stereotype.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Service
public class XgbPredict {
    private static final Log logger =
            LogFactory.getLog(CreditPredict.class);

    public int predict() throws XGBoostError {

        DMatrix userInformationMat = new DMatrix("src/main/resources/data/user_information");
        Booster xgbModel = XGBoost.loadModel("src/main/resources/model/xgb.model");

        logger.info("model has been loaded");

        float[][] predictResult = xgbModel.predict(userInformationMat);
        int result = (int) predictResult[0][0];

        logger.info("result is " + result);
        return result;


    }
}


