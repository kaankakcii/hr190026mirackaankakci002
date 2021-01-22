package com.hr190026.mirac_kaan_kakci_final.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.hr190026.mirac_kaan_kakci_final.R;
import com.hr190026.mirac_kaan_kakci_final.adaptor.GezegenAdaptor;
import com.hr190026.mirac_kaan_kakci_final.model.GezegenModel;
import com.hr190026.mirac_kaan_kakci_final.netwok.Service;
import com.hr190026.mirac_kaan_kakci_final.util.Constants;
import com.hr190026.mirac_kaan_kakci_final.util.ObjectUtil;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        init();

    }

    private  void  init()
    {

        gezegenleriGetir();
    }


    void  gezegenleriGetir()
    {

        new Service().getServiceApi().gezegenleriGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<GezegenModel>>() {

                    List<GezegenModel> gezegenler=new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("RETROFIT","onSubscribe : ");
                    }

                    @Override
                    public void onNext(List<GezegenModel> gezegenList) {
                        Log.e("RETROFIT","onNext : ");
                        gezegenler=gezegenList;
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e("RETROFIT","onError : " + e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete()
                    {
                        Log.e("RETROFIT","onComplete : ");

                        if(gezegenler.size()>0) {

                            initRecycleView(gezegenler);
                        }
                    }
                });
    }


    private  void  initRecycleView(List<GezegenModel> gezegenList)
    {
        recyclerView =findViewById(R.id.rcvGezegenler);
        GezegenAdaptor gezegenAdaptor =new GezegenAdaptor(gezegenList, getApplicationContext(), new GezegenAdaptor.OnItemClickListener() {
            @Override
            public void onClik(int position) {

                GezegenModel tiklananGezegen=gezegenList.get(position);
                Toast.makeText(getApplicationContext(),"Tıklanan Adı :"+tiklananGezegen.getGezegenAdi(),Toast.LENGTH_SHORT).show();
                switchScreen(tiklananGezegen);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(gezegenAdaptor);
    }

    private void switchScreen(GezegenModel tiklananGezegen){

        ProgressDialog progressDialog = new ProgressDialog(ListActivity.this);
        progressDialog.setMessage("Lütfen bekleyiniz..");
        progressDialog.show();


        Intent ListActivity = new Intent(getApplicationContext(), GezegenDetail.class);
        String tiklananBurcString= ObjectUtil.gezegenJsonString(tiklananGezegen);
        ListActivity.putExtra(Constants.TIKLANAN_BURC_BASLIGI,tiklananBurcString);
        startActivity(ListActivity);


    }

    public void onBackPressed(){


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.listScreen_alert_title_cıkıs_baslık));
        builder.setMessage(getResources().getString(R.string.listScreen_alert_title_cıkıs_mesaj));
        builder.setPositiveButton(getResources().getString(R.string.listScreen_alert_title_cıkıs_evet), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        builder.setNegativeButton(getResources().getString(R.string.listScreen_alert_title_cıkıs_hayır), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }
}

