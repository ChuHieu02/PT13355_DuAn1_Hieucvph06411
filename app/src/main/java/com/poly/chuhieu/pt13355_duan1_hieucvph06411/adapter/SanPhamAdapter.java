package com.poly.chuhieu.pt13355_duan1_hieucvph06411.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.poly.chuhieu.pt13355_duan1_hieucvph06411.R;
import com.poly.chuhieu.pt13355_duan1_hieucvph06411.model.SanPham;
import com.poly.chuhieu.pt13355_duan1_hieucvph06411.sqlitedao.SanPhamDAO;

import java.util.List;

public class SanPhamAdapter extends BaseAdapter {
    List<SanPham> arrTypeBook;
    public Activity context;
    public LayoutInflater inflater;
    SanPhamDAO typeBookDAO;

    public SanPhamAdapter(Activity context, List<SanPham> arrTypeBook) {
        super();
        this.arrTypeBook = arrTypeBook;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        typeBookDAO = new SanPhamDAO(context);
    }

    @Override
    public int getCount() {
        return arrTypeBook.size();
    }

    @Override
    public Object getItem(int position) {
        return arrTypeBook.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_lv, null);
            holder.img = (ImageView) convertView.findViewById(R.id.img);
            holder.tvIDTypeBook = (TextView) convertView.findViewById(R.id.title);
            holder.tvTypeName = (TextView) convertView.findViewById(R.id.subTitle);
            holder.imgDelete = (ImageView) convertView.findViewById(R.id.clear);
            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    typeBookDAO.deleteTypeBookByID(arrTypeBook.get(position).getIdTypeBook());
                    arrTypeBook.remove(position);
                    notifyDataSetChanged();
                }
            });
            convertView.setTag(holder);

        } else
            holder = (ViewHolder) convertView.getTag();
        SanPham _entry = (SanPham) arrTypeBook.get(position);
        holder.img.setImageResource(R.drawable.cacke);
        holder.tvIDTypeBook.setText(_entry.getIdTypeBook());
        holder.tvTypeName.setText(_entry.getTypeName());
        return convertView;

    }

    public static class ViewHolder {
        ImageView img;
        TextView tvIDTypeBook;
        TextView tvTypeName;
        ImageView imgDelete;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void changeDataset(List<SanPham> items){
        this.arrTypeBook = items;
        notifyDataSetChanged();
    }
}
