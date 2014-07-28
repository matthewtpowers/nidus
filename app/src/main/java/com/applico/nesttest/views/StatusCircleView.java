package com.applico.nesttest.views;

import android.content.Context;
import android.view.View;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.content.res.TypedArray;
import android.view.ViewAnimationUtils;

import com.applico.nesttest.R;

/**
 * Created by matthewpowers on 7/26/14.
 * This view is intended to represent the health of the NEST device
 */
public class StatusCircleView extends View {

    private static String LOG_TAG = StatusCircleView.class.getSimpleName();

    //Initailize the object variables
    private Paint mCirclePaint;
    private Paint mStrokePaint;
    private RectF mCircleArc;
    private int mCircleRadius;
    private int mStartAngle;
    private int mEndAngle;
    private int mCircleFillColor;
    private int mCircleStrokeColor;
    private int mCircleStrokeWidth;

    //Default values
    private static final int DEFAULT_RADIUS = 0;
    private static final int DEFAULT_FILL_COLOR = R.color.good_green;
    private static final int DEFAULT_STROKE_COLOR = R.color.good_green_stroke;
    private static final int DEFAULT_START_ANGLE = 0;
    private static final int DEFAULT_END_ANGLE = 360;
    private static final int DEFAULT_STROKE_WIDTH = 2;

    public StatusCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //Read all the attributes
        init(attrs);

        //Initialize the stroke and paint objects
        mCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCirclePaint.setStyle(Paint.Style.FILL);
        mStrokePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mStrokePaint.setStyle(Paint.Style.STROKE);
        mStrokePaint.setStrokeWidth(mCircleStrokeWidth);
        mStrokePaint.setColor(mCircleStrokeColor);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        canvas.translate(1,1);
        mCirclePaint.setColor(mCircleFillColor);
        canvas.drawArc(mCircleArc, mStartAngle, mEndAngle, true, mCirclePaint);
        canvas.drawArc(mCircleArc, mStartAngle, mEndAngle, true, mStrokePaint);
    }

    /**
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        int measuredWidth = measureWidth(widthMeasureSpec);

        //We are using this method to provide a default size based on the layout size
        if(mCircleRadius == 0)
        {
           mCircleRadius = measuredWidth/2;
           int tempRadiusHeight = measureHeight(heightMeasureSpec)/2;
            if(tempRadiusHeight < mCircleRadius)
            {
                mCircleRadius = tempRadiusHeight;
            }
        }

        int circleDiameter = mCircleRadius * 2 - mCircleStrokeWidth;
        mCircleArc = new RectF(0, 0, circleDiameter, circleDiameter);
        int measuredHeight = measureHeight(heightMeasureSpec);
        setMeasuredDimension(measuredWidth, measuredHeight);

    }

    /**
     * measure the height of the screen
     * @param measureSpec
     * @return
     */
    private int measureHeight(int measureSpec) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        int result = 0;
        if (specMode == MeasureSpec.AT_MOST) {
            result = mCircleRadius * 2;
        } else if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        }
        return result;
    }

    /**
     * measure the width of the screen
     * @param measureSpec
     * @return
     */
    private int measureWidth(int measureSpec)
    {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        int result = 0;
        if (specMode == MeasureSpec.AT_MOST) {
            result = mCircleRadius * 2;
        } else if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        }
        return result;
    }

    /**
     * initialize all the custom attributes
     * @param attrs
     */
    public void init(AttributeSet attrs)
    {
        TypedArray attrsArray = getContext().obtainStyledAttributes(attrs, R.styleable.circleview);
        mCircleRadius = attrsArray.getInteger(R.styleable.circleview_cRadius, DEFAULT_RADIUS);
        mCircleFillColor = attrsArray.getColor(R.styleable.circleview_cFillColor, DEFAULT_FILL_COLOR);
        mCircleStrokeColor = attrsArray.getColor(R.styleable.circleview_cStrokeColor, DEFAULT_STROKE_COLOR);
        mStartAngle = attrsArray.getInteger(R.styleable.circleview_cAngleStart, DEFAULT_START_ANGLE);
        mEndAngle = attrsArray.getInteger(R.styleable.circleview_cAngleEnd, DEFAULT_END_ANGLE);
        mCircleStrokeWidth = attrsArray.getInteger(R.styleable.circleview_cStrokeWidth, DEFAULT_STROKE_WIDTH);

        attrsArray.recycle();
    }




}
