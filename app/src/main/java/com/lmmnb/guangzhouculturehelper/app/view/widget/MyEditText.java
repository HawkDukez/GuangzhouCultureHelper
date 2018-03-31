package com.lmmnb.guangzhouculturehelper.app.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lmmnb.guangzhouculturehelper.R;

import java.util.PriorityQueue;
import java.util.jar.Attributes;

/**
 * Created by Hawk Duke on 2018/3/31.
 */

public class MyEditText extends RelativeLayout{
    public EditText et2;

    public MyEditText(Context context)
    {
        super(context);
    }

    public MyEditText(Context context, AttributeSet attributeSet)
    {
        super(context,attributeSet);
        View view = LayoutInflater.from(context).inflate(R.layout.myet,this);
        init(context);
    }

    private void init(Context context)
    {
        et2 = (EditText)findViewById(R.id.et2);
        et2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i == EditorInfo.IME_ACTION_SEND
                        || i == EditorInfo.IME_ACTION_DONE
                        || (keyEvent != null
                        && KeyEvent.KEYCODE_ENTER == keyEvent.getKeyCode()
                        && KeyEvent.ACTION_DOWN == keyEvent.getAction()))
                {

                }
                return false;
            }
        });
    }
}
