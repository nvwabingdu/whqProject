package myviewcustom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by wangqi on 2017/12/11.
 */

public class SimpleView extends View{
    private Paint mPaint;


    public SimpleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
        mPaint.setColor(Color.BLUE);
        mPaint.setTextSize(20);
        String text = "Hello View";
        canvas.drawText(text, 0, getHeight() / 2, mPaint);
    }



//组合控件
//    private Button leftButton;
//
//    private TextView titleText;
//
//    public TitleView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        LayoutInflater.from(context).inflate(R.layout.title, this);
//        titleText = (TextView) findViewById(R.id.title_text);
//        leftButton = (Button) findViewById(R.id.button_left);
//        leftButton.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ((Activity) getContext()).finish();
//            }
//        });
//    }
//
//    public void setTitleText(String text) {
//        titleText.setText(text);
//    }
//
//    public void setLeftButtonText(String text) {
//        leftButton.setText(text);
//    }
//
//    public void setLeftButtonListener(OnClickListener l) {
//        leftButton.setOnClickListener(l);
//    }






}
