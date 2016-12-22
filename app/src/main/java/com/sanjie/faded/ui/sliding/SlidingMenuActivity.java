package com.sanjie.faded.ui.sliding;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.sanjie.faded.R;
import com.sanjie.faded.ui.fragment.HomeFragment;
import com.sanjie.faded.view.CircleImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LangSanJie on 2016/12/7.
 */

public class SlidingMenuActivity extends SlidingFragmentActivity {

    public static final String TAG = "SlidingMenuActivity";
    @BindView(R.id.iconMenu)
    CircleImageView iconMenu;
    @BindView(R.id.titleTextView)
    TextView titleTextView;

    private Fragment mContent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_menu);
        ButterKnife.bind(this);
        initSlidingMenu(savedInstanceState);
        initView();
    }

    private void initView(){
        iconMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle();
            }
        });
    }

    private void initSlidingMenu(Bundle savedInstanceState){
        if(savedInstanceState != null){
            mContent = getSupportFragmentManager().getFragment(savedInstanceState,"mContent");
        }
        if(mContent == null){
            mContent = new HomeFragment();
        }
        switchFragmentContent(mContent,"姿谊");
        //设置左侧侧滑菜单
        setBehindContentView(R.layout.menu_frame_left);
        getSupportFragmentManager().beginTransaction().replace(R.id.menu_frame,new LeftMenuFragment()).commit();

        //实例化侧滑菜单
        SlidingMenu menu = getSlidingMenu();
        //设置滑动方向
        menu.setMode(SlidingMenu.LEFT);
        //设置滑动阴影的宽度
        menu.setShadowWidthRes(R.dimen.shadow_width);
        //设置滑动菜单阴影的图片资源
        menu.setShadowDrawable(null);
        //设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        //设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        //设置触摸屏幕的模式,这里设置为全屏
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        //设置下方视图的在滚动时的缩放比例
        menu.setBehindScrollScale(0.3f);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, "mContent", mContent);
    }

    public void switchFragmentContent(Fragment fragment, String title){
        mContent = fragment;
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, fragment).commit();
        getSlidingMenu().showContent();
        titleTextView.setText(title);
    }
}
