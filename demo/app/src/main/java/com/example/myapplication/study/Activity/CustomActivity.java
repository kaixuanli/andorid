package com.example.myapplication.study.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.myapplication.R;
import com.example.myapplication.study.Adapter.AnimalAdapter;
import com.example.myapplication.study.entity.Animal;

import java.util.LinkedList;
import java.util.List;

public class CustomActivity extends AppCompatActivity {

    private List<Animal> mData = null;
    private Context mContext;
    private AnimalAdapter mAdapter = null;
    private ListView list_animal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_demo);
        mContext = CustomActivity.this;
        list_animal = (ListView) findViewById(R.id.list_test);
        mData = new LinkedList<Animal>();
        mData.add(new Animal("狗说", "你是狗么?", R.mipmap.dog));
        mData.add(new Animal("牛说", "你是牛么?", R.mipmap.cow));
        mData.add(new Animal("猫说", "快给我铲屎", R.mipmap.cat));
        mAdapter = new AnimalAdapter((LinkedList<Animal>) mData, mContext);
        list_animal.setAdapter(mAdapter);
    }

}
