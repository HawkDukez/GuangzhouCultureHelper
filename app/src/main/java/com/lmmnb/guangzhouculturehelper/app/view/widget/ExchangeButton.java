package com.lmmnb.guangzhouculturehelper.app.view.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lmmnb.guangzhouculturehelper.R;
import com.lmmnb.guangzhouculturehelper.app.view.MainActivity;

import java.io.Reader;

/**
 * Created by Hawk Duke on 2018/3/28.
 */

public class ExchangeButton extends RelativeLayout {


    public static boolean flag = true;
    //语种交换按钮
    private ImageButton changbtn;
    //显示语言的两个TextView，start为左，end为右
    private TextView startTextView,endTextView;
    //startCityTextView和endCityTextView的左上角坐标
    private int startX,endX;

    public ExchangeButton(Context context)
    {
        super(context);
    }

    public ExchangeButton(Context context, AttributeSet attributeSet)
    {
        super(context,attributeSet);
        View view = LayoutInflater.from(context).inflate(R.layout.exchang,this);
        init();
    }


    public boolean onFling(MotionEvent event,MotionEvent event2,float X,float Y)
    {
        return false;
    }


    private void init()
    {
        changbtn = (ImageButton)findViewById(R.id.changeBtn);
        startTextView=(TextView)findViewById(R.id.tv1);
        endTextView=(TextView)findViewById(R.id.tv2);

        changbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changbtn.setEnabled(false);
                getLocation();

                if(flag)
                    flag=false;
                else
                    flag=true;

                final int moveX = endX - startX + endTextView.getWidth() - startTextView.getWidth();

                ValueAnimator startCityAnimation = ValueAnimator.ofInt(0, moveX).setDuration(500);
                startCityAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int value = (int) animation.getAnimatedValue();
                        startTextView.layout(startX + value, startTextView.getTop(), startX + value + startTextView.getWidth(), startTextView.getBottom());
                        if(value==moveX)
                            changbtn.setEnabled(true);
                    }


                });
                startCityAnimation.start();

                int rightMoveX = endX - startX;

                ValueAnimator endCityAnimator = ValueAnimator.ofInt(0, rightMoveX).setDuration(500);
                endCityAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int value = (int) animation.getAnimatedValue();
                        endTextView.layout(endX - value, endTextView.getTop(), endX + endTextView.getWidth() - value, endTextView.getBottom());
                    }
                });
                startCityAnimation.start();
                endCityAnimator.start();

                endCityAnimator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        TextView flagTextView = startTextView;
                        startTextView = endTextView;
                        endTextView = flagTextView;
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                    }
                });

                String temp = startTextView.getText().toString();
                if(flag)
                {
                    MainActivity.et1.setEnabled(true);
                    MainActivity.et1.et2.setHint("在此输入要翻译的文本...");
                }
                else
                {
                    MainActivity.et1.setEnabled(false);
                    MainActivity.et1.et2.setHint("请使用语音进行粤语转换");
                }


            }

        });

    }


    private void getLocation() {
        int[] startLocation = new int[2];
        startTextView.getLocationOnScreen(startLocation);
        int[] endLocation = new int[2];
        endTextView.getLocationOnScreen(endLocation);
        startX = startLocation[0];
        endX = endLocation[0];
    }


    public String getStart()
    {
        return startTextView.getText().toString();
    }


}
