package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.UIUtil;

import java.util.Random;

public class Practice10HistogramView extends View {

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    float width, height;
    private final String[] xTexts = {"Froyo", "GB", "ICS", "JB", "KitKat", "L", "M"};
    String title = "直方图";
    Random random = new Random();


    /**
     * 综合练习
     * 练习内容：使用各种 Canvas.drawXXX() 方法画直方图
     */

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        width = getWidth(); //绘制屏幕区域的宽
        height = getHeight();//绘制屏幕区域的高
        mPaint.setColor(Color.WHITE);
        float marginLeftOrRight = UIUtil.dp2px(getContext(), 40);
        float space = UIUtil.dp2px(getContext(), 7);
        float histogramWidth = (width - 2 * marginLeftOrRight - 8 * space) / 7;

        float originX = marginLeftOrRight;
        float originY = height - UIUtil.dp2px(getContext(),60);

        /** 绘制横纵坐标 */
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(UIUtil.dp2px(getContext(), 1));
        canvas.drawLine(marginLeftOrRight, space, originX, originY, mPaint);
        canvas.drawLine(originX, originY, width - marginLeftOrRight, originY, mPaint);

        /** 绘制文字说明 */
        mPaint.setTextSize(30);
        for (int i = 0; i < 7; i++){
            float histogramCenter = originX + space * (i + 1) + histogramWidth * (i + 0.5f);
            float textWidth = mPaint.measureText(xTexts[i]);
            float textBaseLine = originY + (mPaint.descent() - mPaint.ascent()) / 2 + 10;
            canvas.drawText(xTexts[i], histogramCenter - textWidth / 2, textBaseLine, mPaint);
        }
        mPaint.setTextSize(45);
        float tw = mPaint.measureText(title);
        canvas.drawText(title, width / 2 - tw / 2, height - UIUtil.dp2px(getContext(), 20), mPaint);

        /** 绘制直方图矩形 随机绘制高度 */
        mPaint.setColor(Color.parseColor("#6bca62"));
        for (int i = 0; i < 7; i++){
            float histogramLeft = originX + space * (i + 1) + histogramWidth * i;
            float histogramRight = histogramLeft + histogramWidth;
            float randomTop = random.nextFloat()  * (originY - space);
            canvas.drawRect(new RectF(histogramLeft, space + originY - randomTop, histogramRight, originY), mPaint);
         }
    }
}
