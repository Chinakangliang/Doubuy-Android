package com.tv.doubuy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.tv.doubuy.adapter.MyFragmentPagerAdapter;
import com.tv.doubuy.base.BaseActivity;
import com.tv.doubuy.ui.home.BlankFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_chat:
                        /**
                         * setCurrentItem第二个参数控制页面切换动画
                         * true:打开/false:关闭
                         */
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


        /**
         * ViewPager部分
         */
        viewPager = (ViewPager) findViewById(R.id.viewPager);
//        ChatFragment weChatFragment = new ChatFragment();
//        ContactsFragment contactsFragment = new ContactsFragment();
//        DiscoveryFragment discoveryFragment = new DiscoveryFragment();
//        MeFragment meFragment = new MeFragment();
        List<Fragment> alFragment = new ArrayList<Fragment>();
//        alFragment.add(weChatFragment);
//        alFragment.add(contactsFragment);
//        alFragment.add(discoveryFragment);
//        alFragment.add(meFragment);
        for (int i = 0; i < 4; i++) {
            blankFragment = BlankFragment.newInstance("item" + i);
            alFragment.add(blankFragment);

        }

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


}
