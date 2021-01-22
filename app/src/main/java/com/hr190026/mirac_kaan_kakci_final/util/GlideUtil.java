package com.hr190026.mirac_kaan_kakci_final.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hr190026.mirac_kaan_kakci_final.R;

public class GlideUtil {

    public static void resmiIndiripGoster(Context context, String url, ImageView img){
        Glide.with(context)
                .load(url)
                .error(R.drawable.logo)
                .fitCenter()
                .into(img);


    }
}
