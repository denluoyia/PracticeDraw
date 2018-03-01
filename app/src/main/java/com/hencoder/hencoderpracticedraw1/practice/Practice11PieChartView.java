package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.UIUtil;

public class Practice11PieChartView extends View {

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path mPath = new Path();
    final String[] TitleNames = {"Lollipop", "Marshmallow", "Froyo", "Gingerbread", "Ice Cream Sandwich",
                                    "Jelly Bean", "KitKat"};

    /**
     * 综合练习
     * 练习内容：使用各种 Canvas.drawXXX() 方法画饼图
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //假设分为 120 55 0 8 7 60 110 要围城一个圆 那么空隙为2
        float radius = UIUtil.dp2px(getContext(), 90);
        float width = radius * 2;
        mPaint.setColor(Color.RED);
        new RectF(150, 0, 150 + width, width);
        canvas.drawArc(new RectF(150, 0, 150 + width, width), 181, 118, true, mPaint);
        mPaint.setColor(Color.YELLOW);
        canvas.drawArc(new RectF(170, 20, 170 + width, 20 + width), 301, 53, true, mPaint);
        mPaint.setColor(Color.GREEN);
        canvas.drawArc(new RectF(173, 23, 173 + width, 23 + width), 356, 6, true, mPaint);
        mPaint.setColor(Color.GRAY);
        canvas.drawArc(new RectF(172, 24, 172 + width, 24 + width), 4, 5, true, mPaint);
        mPaint.setColor(Color.BLUE);
        canvas.drawArc(new RectF(172, 25, 172 + width, 25 + width), 11, 58, true, mPaint);
        mPaint.setColor(Color.BLACK);
        canvas.drawArc(new RectF(170, 27, 170 + width, 27 + width), 71, 108, true, mPaint);

        //绘制指示(cx + r*cos, cy + r.sin)
        //在圆上的点 圆心坐标 半径 中心角度
        mPaint.setStrokeWidth(UIUtil.dp2px(getContext(), 1));
        float c1x = 150 + radius, c1y = radius; //中心角度 240


        //绘制文字
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(40);
        canvas.drawText("饼图", 400, getHeight() - 50, mPaint);

    }
}
