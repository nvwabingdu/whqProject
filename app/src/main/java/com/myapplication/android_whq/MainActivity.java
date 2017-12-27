package com.myapplication.android_whq;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import global.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import modulefour.service.MyService;
import utils.Tools;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.tv3)
    TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public int LayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @OnClick(R.id.tv3)
    public void onViewClicked() {
        Toast.makeText(MainActivity.this,"哈哈哈",Toast.LENGTH_LONG).show();


    }




}
