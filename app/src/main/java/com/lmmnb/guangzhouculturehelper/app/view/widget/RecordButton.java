package com.lmmnb.guangzhouculturehelper.app.view.widget;

import android.content.Context;
import android.os.Environment;
import android.provider.ContactsContract;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.lmmnb.guangzhouculturehelper.R;
import com.lmmnb.guangzhouculturehelper.app.view.MainActivity;

import java.util.zip.CheckedOutputStream;

/**
 * Created by Hawk Duke on 2018/3/29.
 */

public class RecordButton extends RelativeLayout {

    private Ripple ripple;
    private ImageView img;
    //长按说话按钮是否被长按标识
    private boolean isLongClicked=false;

    public RecordButton(Context context) {super(context);}

    public RecordButton(Context context, AttributeSet attributeSet)
    {
        super(context,attributeSet);
        View view = LayoutInflater.from(context).inflate(R.layout.recordbtn,this);
        init(context);
    }

    private void init(final Context context)
    {
        ripple = (Ripple)findViewById(R.id.ripple);
        img = (ImageView)findViewById(R.id.centerImage);
        img.setOnTouchListener(new PressToSpeakListen());
        img.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                isLongClicked = true;
                MainActivity.et1.et2.setHint("说吧，我在听呢~");
                return false;

            }
        });


    }

    class PressToSpeakListen implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    ripple.startRippleAnimation();
                    if (!Environment.getExternalStorageState().equals(
                            android.os.Environment.MEDIA_MOUNTED)) {
                        return false;
                    }

                    return false;
                case MotionEvent.ACTION_UP:

                    ripple.stopRippleAnimation();  //动画效果停止
                    //手指抬起后判断语言转换的情景来设定hint
                    if(MainActivity.getText())
                    {
                        MainActivity.et1.et2.setHint("在此输入要翻译的文本...");
                    }
                    else
                    {
                        MainActivity.et1.et2.setHint("请使用语音进行粤语转换");
                    }

                    if (!isLongClicked ) return false;
                    isLongClicked = false;
                    if (event.getY() < 0) {

                    } else {

                    }
                    return false;
                default:
                    //recording_container.setVisibility(View.GONE);
                    return false;
            }
        }
    }

}



