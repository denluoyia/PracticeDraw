package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.UIUtil;

public class Practice2DrawCircleView extends View {

    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice2DrawCircleView(Context context) {
        super(context);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 练习内容：使用 canvas.drawCircle() 方法画圆
     一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /** 实心圆 */
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(350, 150, 150, mPaint);

        /** 蓝色实心圆 */
        mPaint.setColor(0xFF0088FF);
        canvas.drawCircle(350, 500, 150, mPaint);

        /** 空心圆 */
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(UIUtil.dp2px(getContext(), 2));
        canvas.drawCircle(700, 150, 150, mPaint);

        /** 线宽为 50 的空心圆 */
        mPaint.setStrokeWidth(UIUtil.dp2px(getContext(),20));
        canvas.drawCircle(700, 500, 150, mPaint);
    }
}
