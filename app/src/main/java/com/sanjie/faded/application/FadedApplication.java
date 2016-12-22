package com.sanjie.faded.application;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LangSanJie on 2016/12/7.
 */

public class FadedApplication extends Application {

    public static final String TAG = "FadedApplication";

    private List<Activity> mActivityList;

    @Override
    public void onCreate() {
        super.onCreate();
        mActivityList = new ArrayList<>();
    }

    //添加Activity到容器中
    public void addActivity(Activity activity){
        try {
            mActivityList.add(activity);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //将activity从容器中移除
    public void removeActivity(Activity activity){
        try {
            mActivityList.remove(activity);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //完全退出系统
    public void exit() {
        try {
            for(Activity activity: mActivityList) {
                activity.finish();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    public void finishOtherActivity(){
        try {
            for(Activity activity: mActivityList) {
                activity.finish();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
