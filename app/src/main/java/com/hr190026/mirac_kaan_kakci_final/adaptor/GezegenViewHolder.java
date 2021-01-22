package com.hr190026.mirac_kaan_kakci_final.adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hr190026.mirac_kaan_kakci_final.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class GezegenViewHolder extends RecyclerView.ViewHolder {

    ImageView imgGezegenLogo;
    TextView txtGezegenAdi;
    TextView txtGezegenGunUzunlugu;
    TextView txtGezegenCapi;

    public GezegenViewHolder(@NonNull View itemView, GezegenAdaptor.OnItemClickListener listener) {
        super(itemView);

        imgGezegenLogo=itemView.findViewById(R.id.imgGezegenLogo);
        txtGezegenAdi =itemView.findViewById(R.id.txtGezegenAdi);
        txtGezegenGunUzunlugu =itemView.findViewById(R.id.txtGezegenGunUzunlugu);
        txtGezegenCapi =itemView.findViewById(R.id.txtGezegenCapi);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClik(getAdapterPosition());
            }
        });
    }
}
