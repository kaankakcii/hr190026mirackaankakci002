package com.hr190026.mirac_kaan_kakci_final.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hr190026.mirac_kaan_kakci_final.model.GezegenModel;
import com.hr190026.mirac_kaan_kakci_final.util.GlideUtil;
import com.hr190026.mirac_kaan_kakci_final.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GezegenAdaptor extends RecyclerView.Adapter<GezegenViewHolder> {


    List<GezegenModel> gezegen;
    Context context;
    OnItemClickListener listener;

    public interface OnItemClickListener {

        void onClik(int position);

    }


    public GezegenAdaptor(List<GezegenModel> gezegen, Context context, OnItemClickListener listener) {
        this.gezegen = gezegen;
        this.context = context;
        this.listener=listener;
    }

    @NonNull
    @Override
    public GezegenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView=LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_gezegen ,parent,false);
        return new GezegenViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull GezegenViewHolder viewHolder, int position) {

        viewHolder.txtGezegenAdi.setText(gezegen.get(position).getGezegenAdi());
        viewHolder.txtGezegenCapi.setText(gezegen.get(position).getCapi());
        viewHolder.txtGezegenGunUzunlugu.setText(gezegen.get(position).getGunUzunlugu());
        GlideUtil.resmiIndiripGoster(context,gezegen.get(position).getResimUrl(),viewHolder.imgGezegenLogo);

    }

    @Override
    public int getItemCount() {

        return gezegen.size();
    }
}
