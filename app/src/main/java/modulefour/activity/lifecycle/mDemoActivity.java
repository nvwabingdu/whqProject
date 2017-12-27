package modulefour.activity.lifecycle;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by wangqi on 2017/12/27.
 */

public class mDemoActivity extends AppCompatActivity{
    @Override//创建
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override//开始
    protected void onStart() {
        super.onStart();
    }

    @Override//重新开始
    protected void onRestart() {
        super.onRestart();
    }

    @Override//恢复数据
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override//页面获取焦点 可见
    protected void onResume() {
        super.onResume();
    }

    @Override//页面失去焦点  不可见
    protected void onPause() {
        super.onPause();
    }

    @Override//获取activity的焦点    该方法会在上面方面之前调用一次
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    @Override//保存数据
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override//停止 不会销毁 存在于栈中
    protected void onStop() {
        super.onStop();
    }

    @Override//销毁 做清理工作
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 关于启动模式的  栈任务 栈关系
     * @param intent
     */
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
            Log.i("WooYun", "*****onNewIntent()方法*****");
            Log.i("WooYun", "onNewIntent：" + getClass().getSimpleName() + " TaskId: " + getTaskId() + " hasCode:" + this.hashCode());
            dumpTaskAffinity();
    }

    protected void dumpTaskAffinity(){
        try {
            ActivityInfo info = this.getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.i("WooYun", "taskAffinity:"+info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        //关于栈任务   TaskAffinity属性
       // http://blog.csdn.net/daipeng123456789/article/details/51175153

//添加自定义任务栈方式1：
//        <activity android:name=".bActivity"
//        android:launchMode="singleTask"
//        android:taskAffinity="taskName"/>
//        简写：
//        <activity android:name=".bActivity"
//        android:taskAffinity="taskName"/>



//添加自定义任务栈方式2：
//        Intent intent = new Intent(aAvtivity.this, bActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);
    }


}

