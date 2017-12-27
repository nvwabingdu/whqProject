package modulefour.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.myapplication.android_whq.R;

import butterknife.BindView;
import butterknife.OnClick;
import global.BaseActivity;

/**
 * Created by wangqi on 2017/12/15.
 */

public class MyServiceActivity extends BaseActivity {
    @BindView(R.id.start_service)
    Button startService;
    @BindView(R.id.bind_service)
    Button bindService;
    @BindView(R.id.unbind_service)
    Button unbindService;
    @BindView(R.id.stop_service)
    Button stopService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int LayoutId() {
        return R.layout.myservice_activity;
    }

    @Override
    public void initView() {

    }


    //用于ACticity和service建立联系？
    private MyService.MyBinder myBinder;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder = (MyService.MyBinder) service;
            myBinder.startDownload();
        }
    };


    @OnClick({R.id.start_service, R.id.bind_service, R.id.unbind_service, R.id.stop_service})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.start_service:
                //开启服务
                Intent startIntent = new Intent(this, MyService.class);
                startService(startIntent);
                break;
            case R.id.bind_service:
                //绑定服务
                Intent bindIntent = new Intent(this, MyService.class);
                bindService(bindIntent, connection, BIND_AUTO_CREATE);//Intent对象，ServiceConnection的实例，第三个参数是一个标志位，这里传入BIND_AUTO_CREATE表示在Activity和Service建立关联后自动创建Service，这会使得MyService中的onCreate()方法得到执行，但onStartCommand()方法不会执行。
                break;
            case R.id.unbind_service:
                //解除绑定
                unbindService(connection);
                break;
            case R.id.stop_service:
                //关闭服务
                Intent stopIntent = new Intent(this, MyService.class);
                stopService(stopIntent);
                break;
        }
    }


    /**
     * 注意：
     * 1.任何一个Service在整个应用程序范围内都是通用的，即MyService不仅可以和MainActivity建立关联，
     * 还可以和任何一个Activity建立关联，而且在建立关联时它们都可以获取到相同的MyBinder实例。
     *
     * 2.当启动一个Service的时候，会调用该Service中的onCreate()和onStartCommand()方法。
     *
     * 3.销毁 开启用关闭   绑定用解绑   既开启又关闭 单点其中一个是不会销毁的  必须点击两个
     *    开启---》绑定--》关闭---》解绑
     * 4.android:process=":remote"  远程服务  不会像普通服务一样阻塞主线程  因为跑到另外的进程中去了   但是不推荐使用
     *   使用远程服务  就不能绑定activity了
     *
     */

    /**
     * AIDL（Android Interface Definition Language）//跨进程通讯
     * 是Android接口定义语言的意思，它可以用于让某个Service与多个应用程序组件之间进行跨进程通信，
     * 从而可以实现多个应用程序共享同一个Service的功能。
     */


}
