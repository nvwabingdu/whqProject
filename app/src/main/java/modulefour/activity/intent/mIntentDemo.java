package modulefour.activity.intent;

import android.content.Intent;

/**
 * Created by wangqi on 2017/12/25.
 */

public class mIntentDemo {
    //显式意图 显式intent是指明确指出此intent是启动哪个activity.
    public static void explicitIntent() {
//        Intent intent = new Intent();
//        intent.setClass(Context packageContext, OtherActivity.class);
//        startActivity(intent);
//
//        //1.表示希望启动com.example.test_permission包中的com.example.test_permission.MainActivity
//        Intent intent = new Intent();
//        intent.setClassName("com.example.test_permission", "com.example.test_permission.MainActivity");
//        startActivity(intent);
//
//        //2.
//        Intent intent = new Intent();
//        intent.setClass(Context packageContext, OtherActivity.class);
//        startActivity(intent);
    }

    //隐式意图  隐式intent是指并没有指出要启动哪个activity,而要系统自动去判断并启动匹配的activity.
    public static void implicitExpressionIntent() {
//        Intent intent = new Intent();
//        intent.setAction(Intent.ACTION_NEW);
//        startActivity(intent);
    }


}
