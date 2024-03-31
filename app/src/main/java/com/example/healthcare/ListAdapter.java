package com.example.healthcare;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListAdapter extends ArrayAdapter {

    private Activity mContext;
   List<LabTestDetailDataBase> CartList;


    public ListAdapter(Activity mContext,List<LabTestDetailDataBase> CartList){
        super(mContext,R.layout.list_item,CartList);
        this.mContext=mContext;
        this.CartList=CartList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=mContext.getLayoutInflater();
        View listItemView=inflater.inflate(R.layout.list_item,null,true);
        TextView tvUsername=listItemView.findViewById(R.id.textViewUsername);
        TextView tvProduct=listItemView.findViewById(R.id.textViewProduct);
        TextView tvPrice=listItemView.findViewById(R.id.textViewPrice);

        LabTestDetailDataBase labTestDetailDataBase=CartList.get(position);

        tvUsername.setText(labTestDetailDataBase.getUerName());
        tvProduct.setText(labTestDetailDataBase.getProduct());
        tvPrice.setText(labTestDetailDataBase.getPrice());

        return  listItemView;

    }
}
