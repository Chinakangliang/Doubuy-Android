package com.tv.doubuy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.tv.doubuy.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fl)
    FrameLayout fl;
    @BindView(R.id.rb1)
    RadioButton rb1;
    @BindView(R.id.rb2)
    RadioButton rb2;
    @BindView(R.id.rb3)
    RadioButton rb3;
    @BindView(R.id.rb4)
    RadioButton rb4;
    @BindView(R.id.rg)
    RadioGroup group;

    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        setListener();
    }

    private void initView() {

        HomeFragment homeFragment = new HomeFragment();
        fragments.add(homeFragment);
        fragments.add(homeFragment);
        fragments.add(homeFragment);
        fragments.add(homeFragment);

    }

    private void setListener() {
        // 给group设置监听事件，在监听事件实现fragment之间的切换
        RadioGroup.OnCheckedChangeListener listener = new MyOnCheckedChangeListener();
        group.setOnCheckedChangeListener(listener);

        // 选中首页，否则开始启动的时候画面展示白板
        group.check(R.id.rb1);

    }

    private class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        // 在构造方法中创造fragment
        public MyOnCheckedChangeListener() {
            // 将new出来的fragment放置在集合中，以便后续取用
            fragments.add(new HomeFragment());
            fragments.add(new HomeFragment());
            fragments.add(new HomeFragment());
            fragments.add(new HomeFragment());

        }

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            // 当选中某一个radio的时候，就展现某一个fragment,用到fragment的事务
            FragmentTransaction ft = getSupportFragmentManager()
                    .beginTransaction();
            switch (checkedId) {
                case R.id.rb1:
                    ft.replace(R.id.fl, fragments.get(0));
                    break;
                case R.id.rb2:
                    ft.replace(R.id.fl, fragments.get(1));
                    break;
                case R.id.rb3:
                    ft.replace(R.id.fl, fragments.get(2));
                    break;
                case R.id.rb4:
                    ft.replace(R.id.fl, fragments.get(3));
                    break;
                default:
                    break;
            }
            // 最后事务一定要提交
            ft.commit();
        }

    }
}
