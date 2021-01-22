package com.hr190026.mirac_kaan_kakci_final.netwok;

import com.hr190026.mirac_kaan_kakci_final.model.GezegenModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {

    //base url
    //https://raw.githubusercontent.com/kaankakcii/mobil/main/
    @GET("gezegenlerJson.json")
    Observable<List<GezegenModel>> gezegenleriGetir();

}
