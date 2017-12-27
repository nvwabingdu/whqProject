package modulefour.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * Created by wangqi on 2017/12/11.
 */

public class MyBroadcastTool {

    //注册广播-->onCreat
    public static BroadcastReceiver creatBroadcast(Context context, final String ActionStr, final String key, final String value) {
        //创建广播
        class broadcastReceiver extends BroadcastReceiver {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equalsIgnoreCase(ActionStr)) {
                    String str = intent.getStringExtra(key);
                    if (str.equals(value)) {

                    }
                }
            }
        }

        //注册
        broadcastReceiver myReceiver = new broadcastReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(ActionStr);
        context.registerReceiver(myReceiver, filter);

        return myReceiver;
    }

    //发广播-->需要的地方
    public static void sendBroadcast(Context context, String ActionStr, String key, String value) {
        Intent intent = new Intent();
        intent.setAction(ActionStr);
        intent.putExtra(key, value);
        context.sendBroadcast(intent);
    }

    //解绑 --->onDestory
    public static void unRegisterReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        context.unregisterReceiver(broadcastReceiver);
    }

}
