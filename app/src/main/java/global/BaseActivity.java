package global;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.myapplication.android_whq.BuildConfig;
import com.myapplication.android_whq.R;

/**
 * Created by wangqi on 2017/12/9.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        //用于保存值
        if (savedInstanceState != null) {
            Single.getInstance().wq = savedInstanceState.getString("wq");
        }

        //加载布局
        setContentView(LayoutId());
        //布局操作
        initView();
        //是否打印log  并没有什么用
//        isPrintLog();
    }


    private void isPrintLog() {
//        方法一：直接赋值 方法一比较直观明了，可以清楚的知道是否允许打印Log
//        public static final boolean DEBUG = true;//false
//        方法二：设置BuildConfig.DEBUG的值 方法二和编译模式绑定，如果是release版的就不会打印Log，如果是debug版的话就会打印Log。
//        public static final boolean DEBUG = BuildConfig.DEBUG;
//        方法三：设置Log.isLoggable的值  方法三通过设置property属性来打印Log
//        public static final boolean DEBUG = Log.isLoggable(TAG, Log.DEBUG)；
    }


    public abstract int LayoutId();//抽象方法加载本页面布局

    public abstract void initView();//初始化控件

    @Override
    protected void onStart() {//创建
        super.onStart();

    }

    @Override
    protected void onRestart() {//开始
        super.onRestart();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {//恢复数据
        super.onRestoreInstanceState(savedInstanceState);

    }

    @Override
    protected void onResume() {//页面可见
        super.onResume();

    }

    @Override
    protected void onPause() {//页面不可见，被遮挡
        super.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {//存储数据
        super.onSaveInstanceState(outState);
        outState.putString("wq", Single.getInstance().wq);
    }

    @Override
    protected void onStop() {//停止
        super.onStop();
    }

    @Override
    protected void onDestroy() {//销毁
        super.onDestroy();
    }


    @Override
    public void onBackPressed() {//按下back键
        super.onBackPressed();
    }


    /**
     * 结束activity
     */
    public void finishActivity() {
        ActivityManage.getInstance().delectActivity(this);
        finish();
        overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
    }

    /*
     * Activity的跳转
     */
    public void setIntentClass(Class<?> cla) {
        Intent intent = new Intent();
        intent.setClass(this, cla);
        startActivity(intent);
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

//    /*
//     * Activity的跳转-带参数
//     */
//    public void setIntentClass(Class<?> cla, Object obj) {
//        Intent intent = new Intent();
//        intent.setClass(this, cla);
//        intent.putExtra(INTENTTAG, (Serializable) obj);
//        startActivity(intent);
//        overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
//    }

//    /**
//     * Activity-webviewactivity的跳转-带参数
//     *
//     * @param cla
//     * @param title
//     * @param link
//     */
//    public void setIntentWebView(String title, String link) {
//        Intent intent = new Intent();
//        intent.setClass(this, WebviewActivity.class);
//        intent.putExtra(INTENTTAG, title);
//        intent.putExtra(INTENTTAG2, link);
//        startActivity(intent);
//        overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
//    }


    /**
     * 收起键盘
     */
    public void closeInputMethod() {
        // 收起键盘
        View view = getWindow().peekDecorView();// 用于判断虚拟软键盘是否是显示的
        if (view != null) {
            InputMethodManager inputmanger = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputmanger.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }


    /**
     * 连续点击两次退出App
     */
    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            // 判断是否在两秒之内连续点击返回键，是则退出，否则不退出
            if (System.currentTimeMillis() - exitTime > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                // 将系统当前的时间赋值给exitTime
                exitTime = System.currentTimeMillis();
            } else {
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    /*
     * ************Fragement相关方法************************************************
     *
     */
    private Fragment currentFragment;

    /**
     * Fragment替换(当前destrory,新的create)
     */
    public void fragmentReplace(int target, Fragment toFragment, boolean backStack) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        String toClassName = toFragment.getClass().getSimpleName();
        if (manager.findFragmentByTag(toClassName) == null) {
            transaction.replace(target, toFragment, toClassName);
            if (backStack) {
                transaction.addToBackStack(toClassName);
            }
            transaction.commit();
        }
    }


    /**
     * Fragment替换(核心为隐藏当前的,显示现在的,用过的将不会destrory与create)
     */
    public void smartFragmentReplace(int target, Fragment toFragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        // 如有当前在使用的->隐藏当前的
        if (currentFragment != null) {
            transaction.hide(currentFragment);
        }
        String toClassName = toFragment.getClass().getSimpleName();
        // toFragment之前添加使用过->显示出来
        if (manager.findFragmentByTag(toClassName) != null) {
            transaction.show(toFragment);
        } else {// toFragment还没添加使用过->添加上去
            transaction.add(target, toFragment, toClassName);
        }
        transaction.commit();
        // toFragment更新为当前的
        currentFragment = toFragment;
    }


}
