package com.tv.doubuy;

import android.content.Intent;
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
import com.tv.doubuy.ui.mine.MindeFragment;
import com.tv.doubuy.ui.notice.NoticeFragment;
import com.tv.doubuy.ui.order.OrderFragment;
import com.tv.doubuy.ui.store.StoreFragment;
import com.tv.doubuy.ui.video.VideoFragment;

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
    private long exitTime;
    public static final String TAG_EXIT = "exit";

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
                    case R.id.rb_notice:
                        viewPager.setCurrentItem(3, true);
                        break;
                    case R.id.rb_me:
                        viewPager.setCurrentItem(4, true);
                        break;
                }
            }
        });

        List<Fragment> alFragment = new ArrayList<Fragment>();
        StoreFragment storeFragment = new StoreFragment();
        VideoFragment videoFragment = new VideoFragment();
        alFragment.add(new StoreFragment().newInstance(""));
        alFragment.add(new OrderFragment().newInstance("我是第二个页面"));
        alFragment.add(new VideoFragment().newInstance("我是第三个"));
        alFragment.add(new NoticeFragment().newInstance("我是第四个页面"));
        alFragment.add(new MindeFragment().newInstance("我是第五个页面"));

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
                        radioGroup.check(R.id.rb_notice);
                        break;
                    case 4:
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
            case R.id.rb_notice:
                if (isChecked) {
                    viewPager.setCurrentItem(3, true);
                }

                break;

            case R.id.rb_me:
                if (isChecked) {
                    viewPager.setCurrentItem(4, true);
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

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            boolean isExit = intent.getBooleanExtra(TAG_EXIT, false);
            if (isExit) {
                this.finish();
            }
        }
    }


}
