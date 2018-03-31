package com.lmmnb.guangzhouculturehelper.app.view.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lmmnb.guangzhouculturehelper.R;

import java.util.List;

/**
 * Created by Hawk Duke on 2018/3/28.
 */
public class TextAdapter extends ArrayAdapter {

    private int id;

    public TextAdapter(Context context, int textViewResourceId, List<MyText> object)
    {
        super(context,textViewResourceId,object);
        id=textViewResourceId;

    }

    public View getView(int position, View view, ViewGroup viewGroup)
    {
        MyText text = (MyText) getItem(position);
        View view1 = LayoutInflater.from(getContext()).inflate(id,null);
        ImageView timeImg = (ImageView) view1.findViewById(R.id.time);
        TextView textview1 = (TextView) view1.findViewById(R.id.textitem);
        TextView textview2 = (TextView) view1.findViewById(R.id.myanswer);
        textview1.setText(text.getT1());
        textview2.setText(text.getT2());
        return view1;
    }
}
