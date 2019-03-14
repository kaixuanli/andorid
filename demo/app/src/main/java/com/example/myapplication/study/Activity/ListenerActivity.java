package com.example.myapplication.study.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.myapplication.R;
public class ListenerActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnshow;
    private Button btnshow1;
    private Button btnshow2;
    private Button btnshow3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnshow = (Button) findViewById(R.id.linsten_button);
        btnshow1 = (Button) findViewById(R.id.linsten_button1);
        btnshow2 = (Button) findViewById(R.id.linsten_button2);
        btnshow3 = (Button) findViewById(R.id.linsten_button3);
        method_1(btnshow);
        btnshow1.setOnClickListener(new BtnClickListener());
        onClick(btnshow2);
    }

    //监听方式一：直接写匿名内部类
    public void method_1(Button btnshow){
        btnshow.setOnClickListener(new View.OnClickListener() {
            //重写点击事件的处理方法onClick()
            @Override
            public void onClick(View v) {
                //显示Toast信息
                Toast.makeText(getApplicationContext(), "第一种监听方式", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //监听方式二：定义一个内部类,实现View.OnClickListener接口,并重写onClick()方法
    class BtnClickListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "第二种监听方式", Toast.LENGTH_SHORT).show();
        }
    }

    //监听方式三：用得较少，新建一个外部类通过构造方法将组件传入使用;这样导致的结果就是代码不够简洁！
    //监听方式四：直接使用Activity作为事件监听器，实现OnClickListener接口
    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), "第四种监听方式", Toast.LENGTH_SHORT).show();
    }

    //监听方式五：直接绑定到标签，像js写法那样android:onClick="myclick"注意传一个组件参数
    public void myclick(View source)
    {
        Toast.makeText(getApplicationContext(), "第五种监听方式", Toast.LENGTH_SHORT).show();
    }

    public void  radioButton(){
        RadioGroup radgroup = findViewById(R.id.radioGroup);
        //第一种获得单选按钮值的方法
        //为radioGroup设置一个监听器:setOnCheckedChanged()
        radgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radbtn = (RadioButton) findViewById(checkedId);
                Toast.makeText(getApplicationContext(), "按钮组值发生改变,你选了" + radbtn.getText(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
