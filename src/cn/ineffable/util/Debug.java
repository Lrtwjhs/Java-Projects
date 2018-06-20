package cn.ineffable.util;

/**
 * Created by lrtwjhs on 2017/12/6.
 */

public class Debug {

    private static boolean DEBUG = true;

    public static void debug(String msg) {
        if (DEBUG) {
            System.out.println(msg);
        }
    }
}
