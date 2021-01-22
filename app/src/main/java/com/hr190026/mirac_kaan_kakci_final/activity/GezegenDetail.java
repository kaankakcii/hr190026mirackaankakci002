package com.hr190026.mirac_kaan_kakci_final.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.hr190026.mirac_kaan_kakci_final.util.Constants;
import com.hr190026.mirac_kaan_kakci_final.model.GezegenModel;
import com.hr190026.mirac_kaan_kakci_final.util.GlideUtil;
import com.hr190026.mirac_kaan_kakci_final.util.ObjectUtil;
import com.hr190026.mirac_kaan_kakci_final.R;

import androidx.appcompat.app.AppCompatActivity;

public class GezegenDetail extends AppCompatActivity {

    ImageView imgDetayKapak;
    TextView txtBaslik;
    TextView txtDetay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gezegen_detail);

            init();
    }

    private void init(){
        String tasinanGezegenString=getIntent().getStringExtra(Constants.TIKLANAN_BURC_BASLIGI);
        GezegenModel gezegenModel= ObjectUtil.jsonStringGezegen(tasinanGezegenString);

        imgDetayKapak=findViewById(R.id.imgDetayKapak);
        txtBaslik=findViewById(R.id.txtBaslik);
        txtDetay=findViewById(R.id.txtDetay);

        txtBaslik.setText(gezegenModel.getGezegenAdi());
        txtDetay.setText(gezegenModel.getTanM());

        GlideUtil.resmiIndiripGoster(getApplicationContext(),gezegenModel.getKapakResim(),imgDetayKapak);


    }
}