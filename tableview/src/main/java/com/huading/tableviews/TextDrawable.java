package com.huading.tableviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class TextDrawable extends AppCompatTextView {

    private Drawable drawableLeft;

    private Drawable drawableRight;

    private Drawable drawableTop;

    private int leftWidth;

    private int rightWidth;

    private int topWidth;

    private int leftHeight;

    private int rightHeight;

    private int topHeight;

    private Context mContext;

    public TextDrawable(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    public TextDrawable(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init(context, attrs);
    }

    public TextDrawable(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TextDrawable);
        drawableLeft = typedArray.getDrawable(R.styleable.TextDrawable_leftDrawable);
        drawableRight = typedArray.getDrawable(R.styleable.TextDrawable_rightDrawable);
        drawableTop = typedArray.getDrawable(R.styleable.TextDrawable_topDrawable);
        if (drawableLeft != null) {
            leftWidth = typedArray.getDimensionPixelOffset(R.styleable.TextDrawable_leftDrawableWidth, dip2px(context, 20));
            leftHeight = typedArray.getDimensionPixelOffset(R.styleable.TextDrawable_leftDrawableHeight, dip2px(context, 20));
        }

        if (drawableRight != null) {
            rightWidth = typedArray.getDimensionPixelOffset(R.styleable.TextDrawable_rightDrawableWidth, dip2px(context, 20));
            rightHeight = typedArray.getDimensionPixelOffset(R.styleable.TextDrawable_rightDrawableHeight, dip2px(context, 20));
        }

        if (drawableTop != null) {
            topWidth = typedArray.getDimensionPixelOffset(R.styleable.TextDrawable_topDrawableWidth, dip2px(context, 20));
            topHeight = typedArray.getDimensionPixelOffset(R.styleable.TextDrawable_topDrawableHeight, dip2px(context, 20));
        }
    }

    public int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    @Override

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (drawableLeft != null) {
            drawableLeft.setBounds(0, 0, leftWidth, leftHeight);
        }

        if (drawableRight != null) {
            drawableRight.setBounds(0, 0, rightWidth, rightHeight);
        }

        if (drawableTop != null) {
            drawableTop.setBounds(0, 0, topWidth, topHeight);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.setCompoundDrawables(drawableLeft, drawableTop, drawableRight, null);
    }

    /**
     * ???????????????????????????
     */

    public void setDrawableLeft(Drawable drawableLeft) {
        this.drawableLeft = drawableLeft;
        invalidate();
    }

    /**
     * ???????????????????????????
     */
    public void setDrawableLeft(int drawableLeftRes) {
        this.drawableLeft = mContext.getResources().getDrawable(drawableLeftRes);
        invalidate();
    }

    /**
     * ???????????????????????????
     */
    public void setDrawableRight(Drawable drawableRight) {
        this.drawableRight = drawableLeft;
        invalidate();
    }

    /**
     * ???????????????????????????
     */
    public void setDrawableRight(int drawableRightRes) {
        this.drawableRight = mContext.getResources().getDrawable(drawableRightRes);
        invalidate();
    }

    public void setDrawableRightSize(int width, int height) {
        this.rightWidth = width;
        this.rightHeight = height;
        invalidate();
    }

    /**
     * ???????????????????????????
     */
    public void setDrawable(Drawable drawableTop) {
        this.drawableTop = drawableTop;
        invalidate();
    }

    /**
     * ???????????????????????????
     */
    public void setDrawableTop(int drawableTopRes) {
        this.drawableTop = mContext.getResources().getDrawable(drawableTopRes);
        invalidate();
    }
}