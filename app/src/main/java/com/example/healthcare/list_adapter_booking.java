package com.example.healthcare;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class list_adapter_booking extends ArrayAdapter {

    private Activity mContext;
    List<BookingDetail_Database> bookingDetailDatabases_list;

    public list_adapter_booking(Activity mContext,List<BookingDetail_Database> bookingDetailDatabases_list){
        super(mContext,R.layout.list_item_book,bookingDetailDatabases_list);
        this.mContext=mContext;
        this.bookingDetailDatabases_list=bookingDetailDatabases_list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=mContext.getLayoutInflater();
        View listItemView=inflater.inflate(R.layout.list_item_book,null,true);
        TextView tvName=listItemView.findViewById(R.id.textViewdoctorname);
        TextView tvAddress=listItemView.findViewById(R.id.textViewAddress);
        TextView tvContact=listItemView.findViewById(R.id.textViewMobile);
        TextView tvPrice=listItemView.findViewById(R.id.textViewPrice);
        TextView tvDate=listItemView.findViewById(R.id.textViewdate);
        TextView tvTime=listItemView.findViewById(R.id.textViewTime);

        BookingDetail_Database bookingDetailDatabase=bookingDetailDatabases_list.get(position);
        tvName.setText(bookingDetailDatabase.getFullname());
        tvAddress.setText(bookingDetailDatabase.getAddress());
        tvContact.setText(bookingDetailDatabase.getContact());
        tvPrice.setText(bookingDetailDatabase.getFess());
        tvDate.setText(bookingDetailDatabase.getDate());
        tvTime.setText(bookingDetailDatabase.getTime());


        return listItemView;
    }
}
