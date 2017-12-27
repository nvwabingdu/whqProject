package modulefour.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangqi on 2017/12/11.
 */

public class SharedPreferencesUtils {
    //1、通过上下文对象获得共享参数的对象
    private static SharedPreferences sharedPreferences;
    //2、获得共享参数的编辑对象
    private static SharedPreferences.Editor editor;

    /**
     * 初始化操作 一般在自定义的application中执行
     */
    public static void init(Context context) {
        sharedPreferences = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static void putString(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public static String getString(String key) {
        return sharedPreferences.getString(key, null);
    }

    public static void putInt(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

    public static int getInt(String key) {
        return sharedPreferences.getInt(key, -1);
    }

    public static void putBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    public static void putFloat(String key, float value) {
        editor.putFloat(key, value);
        editor.commit();
    }

    public static float getFloat(String key) {
        return sharedPreferences.getFloat(key, -1.0f);
    }

    public static void putLong(String key, long value) {
        editor.putLong(key, value);
        editor.commit();
    }

    public static long getLong(String key) {
        return sharedPreferences.getLong(key, -1);
    }


    //+++++++++++++++++++++++++++++++++++++++++++++方法二+++++++++++++++++++++++++++++++++++++++++++++++++\\
    //1 使用SharedPreferences存储数据
    //2 文件存储数据
    //3 SQLite数据库存储数据
    //4 使用ContentProvider存储数据
    //5 网络存储数据

    //实现SharedPreferences存储的步骤如下： 　　
    //一、根据Context获取SharedPreferences对象 　　
    //二、利用edit()方法获取Editor对象。 　　
    //三、通过Editor对象存储key-value键值对数据。 　　
    //四、通过commit()方法提交数据。

    public static boolean saveData(String name, int age, Context context) {
        //MODE_PRIVATE:为默认操作模式，代表该文件是私有数据，只能被应用本身访问，在该模式下，写入的内容会覆盖原文件的内容。
        //MODE_WORLD_READABLE:模式会检查文件是否存在，存在就往文件追加内容，否则就创建新文件。
        //MODE_WORLD_WRITEABLE:表示当前文件可以被其他应用读取
        //MODE_MULTI_PROCESS:表示当前文件可以被其他应用写入
        SharedPreferences preferences = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("name", name);
        editor.putInt("age", age);
        return editor.commit();
    }


    public static Map<String, Object> getSharedPerferencesData(Context context) {
        Map<String, Object> map = new HashMap<String, Object>();
        SharedPreferences preferences = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String name = preferences.getString("name", "");
        int age = preferences.getInt("age", 0);
        map.put("name", name);
        map.put("age", age);
        return map;
    }



}
