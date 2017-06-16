package com.tv.doubuy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.tv.doubuy.adapter.MyFragmentPagerAdapter;
import com.tv.doubuy.base.BaseActivity;
import com.tv.doubuy.ui.home.BlankFragment;
import com.tv.doubuy.ui.store.StoreFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener {


    @BindView(R.id.rb_chat)
    RadioButton rbChat;
    @BindView(R.id.rb_contacts)
    RadioButton rbContacts;
    @BindView(R.id.rb_discovery)
    RadioButton rbDiscovery;
    @BindView(R.id.rb_me)
    RadioButton rbMe;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    private BlankFragment blankFragment;
    private long exitTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        setListener();
    }

    public void setListener() {
        rbChat.setOnCheckedChangeListener(this);
        rbContacts.setOnCheckedChangeListener(this);
        rbDiscovery.setOnCheckedChangeListener(this);
        rbMe.setOnCheckedChangeListener(this);

    }

    private void initView() {
//        final int position = getIntent().getIntExtra("position", 20);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_chat:
                        viewPager.setCurrentItem(0, true);
                        break;
                    case R.id.rb_contacts:
                        viewPager.setCurrentItem(1, true);
                        break;
                    case R.id.rb_discovery:
                        viewPager.setCurrentItem(2, true);
                        break;
                    case R.id.rb_me:
                        viewPager.setCurrentItem(3, true);
                        break;
                }
            }
        });

        List<Fragment> alFragment = new ArrayList<Fragment>();
        StoreFragment storeFragment = new StoreFragment();
        alFragment.add(storeFragment);
        alFragment.add(BlankFragment.newInstance("ITEM1"));
        alFragment.add(BlankFragment.newInstance("ITEM2"));
        alFragment.add(BlankFragment.newInstance("ITEM3"));

        //ViewPager设置适配器
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), alFragment));
        //ViewPager显示第一个Fragment
        viewPager.setCurrentItem(0);


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        radioGroup.check(R.id.rb_chat);
                        break;
                    case 1:
                        radioGroup.check(R.id.rb_contacts);
                        break;
                    case 2:
                        radioGroup.check(R.id.rb_discovery);
                        break;
                    case 3:
                        radioGroup.check(R.id.rb_me);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        switch (buttonView.getId()) {
            case R.id.rb_chat:
                if (isChecked) {
                    viewPager.setCurrentItem(0, true);

                }
                break;
            case R.id.rb_contacts:
                if (isChecked) {
                    viewPager.setCurrentItem(1, true);

                }
                break;
            case R.id.rb_discovery:
                if (isChecked) {
                    viewPager.setCurrentItem(2, true);

                }
                break;
            case R.id.rb_me:
                if (isChecked) {
                    viewPager.setCurrentItem(3, true);
                }

                break;
        }

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {

            if ((System.currentTimeMillis() - exitTime) > 2000)  //System.currentTimeMillis()无论何时调用，肯定大于2000
            {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
