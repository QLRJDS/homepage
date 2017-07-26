package com.example.jinyaliang.homepage;

import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    private RadioGroup rg_tab_bar;
    private RadioButton rb_homepage;//首页

    private homePageFragment fg1;
    private roomFragment fg2;
    private mineFragment fg3;

    private FragmentManager fManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fManager=getFragmentManager();
        rg_tab_bar = (RadioGroup) findViewById(R.id.rg_tab_bar);
        rg_tab_bar.setOnCheckedChangeListener(this);
        //获取第一个单选按钮，并设置其为选中状态，即刚开始显示主页页面
        rb_homepage = (RadioButton)findViewById(R.id.rb_homepage);
        rb_homepage.setChecked(true);
    }
    //页面在“主页”“房间”“个人”的切换
    public void onCheckedChanged(RadioGroup group,int checkedId){
        FragmentTransaction fTransaction = fManager.beginTransaction();
        hideAllFragment(fTransaction);
        switch(checkedId){
            case R.id.rb_homepage:
                if(fg1==null){
                    fg1=new homePageFragment();
                    fTransaction.add(R.id.ly_content,fg1);
                }
                else
                    fTransaction.show(fg1);
                break;
            case R.id.rb_room:
                if(fg2==null){
                    fg2=new roomFragment();
                    fTransaction.add(R.id.ly_content,fg2);
                }
                else
                    fTransaction.show(fg2);
                break;
            case R.id.rb_mine:
                if(fg3==null){
                    fg3=new mineFragment();
                    fTransaction.add(R.id.ly_content,fg3);
                }
                else
                    fTransaction.show(fg3);
                break;
        }
        fTransaction.commit();
    }
    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fTransaction) {
        if (fg1 != null)fTransaction.hide(fg1);
        if (fg2 != null)fTransaction.hide(fg2);
        if (fg3 != null)fTransaction.hide(fg3);
    }
}
