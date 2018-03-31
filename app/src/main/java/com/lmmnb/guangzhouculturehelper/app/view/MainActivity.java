package com.lmmnb.guangzhouculturehelper.app.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.lmmnb.guangzhouculturehelper.R;
import com.lmmnb.guangzhouculturehelper.api.apis.Language;
import com.lmmnb.guangzhouculturehelper.api.apis.Test;
import com.lmmnb.guangzhouculturehelper.app.view.widget.ExchangeButton;
import com.lmmnb.guangzhouculturehelper.app.view.widget.MyEditText;
import com.lmmnb.guangzhouculturehelper.app.view.widget.MyText;
import com.lmmnb.guangzhouculturehelper.app.view.widget.RecordButton;
import com.lmmnb.guangzhouculturehelper.app.view.widget.Ripple;
import com.lmmnb.guangzhouculturehelper.app.view.widget.TextAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageButton clearbtn;   //清除按钮
    private static ExchangeButton exchangbtn;
    public  static MyEditText et1;
    private RecordButton recordButton;  //录音按钮

    private ListView history;
    //用于储存ListView中的MyText对象
    private List<MyText> textList =new ArrayList<MyText>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ListView部分
        textInput();
        TextAdapter adapter = new TextAdapter(MainActivity.this,R.layout.text_item,textList);
        history = (ListView) findViewById(R.id.lv);
        history.setAdapter(adapter);

        et1=(MyEditText) findViewById(R.id.et1);

        recordButton = (RecordButton)findViewById(R.id.record);
        exchangbtn = (ExchangeButton)findViewById(R.id.ExchangeButton);


        clearbtn=(ImageButton)findViewById(R.id.clearBtn);
        clearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et1.et2.setText("");
            }
        });
    }

    private void textInput()
    {
        MyText a = new MyText("你好啊","雷猴啊");
        textList.add(a);
        MyText b = new MyText("不客气","唔该噻");
        textList.add(b);
        MyText c = new MyText("saonima","woaini");
        textList.add(c);
        MyText d = new MyText("woaini","saonima");
        textList.add(d);
    }

    private void translate()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String ip = Test.getIp();
                Log.i("demo", String.format("getIp: %s", ip));

                String mandarin = "你在哪里呀？";
                String cantonese = Language.translateToCantoneseByText(mandarin).getTgtText();
                Log.i("demo", String.format("translate: %s -> %s", mandarin, cantonese));
            }
        }).start();
    }

    public static boolean getText()
    {
        if(exchangbtn.getStart().equals("普通话"))
            return true;
        else
            return false;
    }


}
