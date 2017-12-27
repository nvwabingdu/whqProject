package global;

import android.app.Activity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wangqi on 2017/12/9.管理activity的manage
 */

public class ActivityManage {
    private static ActivityManage instance;
    private static Set<Activity> activitys;

    private ActivityManage() {
    }

    public static ActivityManage getInstance() {
        if (instance == null)
            instance = new ActivityManage();
        if (activitys == null)
            activitys = new HashSet<Activity>();
        return instance;
    }

    public void addActivity(Activity activity) {
        activitys.add(activity);
    }

    public void delectActivity(Activity activity) {
        activitys.remove(activity);
    }

    public void finishActivity() {
        for (Activity activity : activitys) {
            if (activity != null)
                activity.finish();
        }

    }

}

