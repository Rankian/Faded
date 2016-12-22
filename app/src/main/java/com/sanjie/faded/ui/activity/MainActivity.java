package com.sanjie.faded.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;
import com.sanjie.faded.R;
import com.sanjie.faded.view.CircleImageView;
import com.sanjie.faded.view.DragLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.dragLayout)
    DragLayout dragLayout;
    @BindView(R.id.iconMenu)
    CircleImageView iconMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initDragLayout();
        initView();
    }

    private void initDragLayout(){
        dragLayout.setDragListener(new DragLayout.DragListener() {
            @Override
            public void onOpen() {

            }

            @Override
            public void onClose() {

            }

            @Override
            public void onDrag(float percent) {
                ViewHelper.setAlpha(iconMenu, 1 - percent);
            }
        });
    }

    private void initView(){
        iconMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dragLayout.open();
            }
        });
    }
}
