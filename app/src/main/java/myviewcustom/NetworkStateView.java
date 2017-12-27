package myviewcustom;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by wangqi on 2017/12/11.
 */

public class NetworkStateView extends FrameLayout{
    public NetworkStateView(@NonNull Context context) {
        super(context);
    }

    public NetworkStateView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NetworkStateView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public NetworkStateView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }



}
