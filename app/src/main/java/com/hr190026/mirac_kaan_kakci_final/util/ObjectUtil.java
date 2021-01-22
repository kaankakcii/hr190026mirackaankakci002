package com.hr190026.mirac_kaan_kakci_final.util;

import com.google.gson.Gson;
import com.hr190026.mirac_kaan_kakci_final.model.GezegenModel;

public class ObjectUtil {

    public static String gezegenJsonString(GezegenModel gezegenModel){

        Gson gson=new Gson();
        return gson.toJson(gezegenModel);
    }

    public static GezegenModel jsonStringGezegen(String jsonString){

        Gson gson=new Gson();
        return gson.fromJson(jsonString,GezegenModel.class);
    }

}
