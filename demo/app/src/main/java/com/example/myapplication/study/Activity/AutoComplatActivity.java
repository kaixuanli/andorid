package com.example.myapplication.study.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import com.example.myapplication.R;

//自动提示框,输入一个字母就能提示剩下的内容
public class AutoComplatActivity extends AppCompatActivity {
    /*MultiAutoCompleteTextView与AutoCompleteTextView区别在于AutoCompleteTextView只能匹配一次
    *MultiAutoCompleteTextView选中一个后自动加逗号，后面的可以继续匹配
    */
    private AutoCompleteTextView atv_content;
    private MultiAutoCompleteTextView matv_content;

    private static final String[] data = new String[]{
            "pig", "dog", "chick", "cat"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        atv_content = (AutoCompleteTextView) findViewById(R.id.atv_content);
        matv_content = (MultiAutoCompleteTextView) findViewById(R.id.matv_content);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(AutoComplatActivity.
                this, android.R.layout.simple_dropdown_item_1line, data);
        atv_content.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line, data);
        matv_content.setAdapter(adapter);
//        setTokenizer是为其设置分隔符
        matv_content.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
