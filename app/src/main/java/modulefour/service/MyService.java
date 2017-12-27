package modulefour.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.myapplication.android_whq.MainActivity;
import com.myapplication.android_whq.R;


/**
 * Created by wangqi on 2017/12/15.
 */

public class MyService extends Service {

    public static final String TAG = "MyService";

    @Override
    public void onCreate() {
        super.onCreate();
//        Notification notification = new Notification(R.drawable,
//                "有通知到来", System.currentTimeMillis());
//        Intent notificationIntent = new Intent(this, MainActivity.class);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
//                notificationIntent, 0);
//        notification.setLatestEventInfo(this, "这是通知的标题", "这是通知的内容",
//                pendingIntent);
//        startForeground(1, notification);
        //上面是前台进程的写法
        Log.d(TAG, "onCreate() executed");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand() executed");
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 开始执行后台任务
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() executed");
    }



//这个类用于Activity和service之间的通讯
    private MyBinder mBinder = new MyBinder();
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
    class MyBinder extends Binder {

        public void startDownload() {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // 执行具体的下载任务
                }
            }).start();
        }
    }






}
