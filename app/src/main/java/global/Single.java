package global;

/**
 * Created by wangqi on 2017/12/9.
 */

public class Single {
    //简单单例
    private static Single single = null;
    private Single() {}
    public static Single getInstance() {
        if (single == null) {
            synchronized (Single.class) {
                if (single == null) {
                    single = new Single();
                }
            }
        }
        return single;
    }
    //常用变量
    public  String wq="wq";


}
