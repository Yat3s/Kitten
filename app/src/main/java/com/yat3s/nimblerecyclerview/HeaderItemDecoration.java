package com.yat3s.nimblerecyclerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;


/**
 * Created by Yat3s on 24/05/2017.
 * Email: hawkoyates@gmail.com
 * GitHub: https://github.com/yat3s
 */
public class HeaderItemDecoration extends RecyclerView.ItemDecoration {
    private static final String TAG = "HeaderItemDecoration";
    private Paint mPaint;
    private View mView;
    private Drawable mDrawable;
    Rect mBounds = new Rect();

    public HeaderItemDecoration(Context context, View view) {
        mPaint = new Paint();
        mView = view;
        mPaint.setColor(Color.BLUE);
        mBounds.set(0, 0, 1200, 100);
        //Measure the view at the exact dimensions (otherwise the text won't center correctly)
        int widthSpec = View.MeasureSpec.makeMeasureSpec(mBounds.width(), View.MeasureSpec.EXACTLY);
        int heightSpec = View.MeasureSpec.makeMeasureSpec(mBounds.height(), View.MeasureSpec.EXACTLY);
        mView.measure(widthSpec, heightSpec);

        //Lay the view out at the mBounds width and height
        mView.layout(0, 0, mBounds.width(), mBounds.height());

        mDrawable = context.getResources().getDrawable(R.drawable.divider);
    }

    @Override
    public void onDraw(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        final int childCount = parent.getChildCount();
        if (childCount <= 0) {
            return;
        }
        int left = 0;
        for (int idx = 0; idx < childCount; idx++) {
            View itemView = parent.getChildAt(idx);
            parent.getDecoratedBoundsWithMargins(itemView, mBounds);
            final int top = mBounds.top;
            final int position = parent.getChildAdapterPosition(itemView);
            if (hasHeader(position)) {
                drawHeader(left, top, canvas);
            }
        }
    }

    @Override
    public void onDrawOver(Canvas canvas, RecyclerView parent, RecyclerView.State state) {

    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        final int position = parent.getChildAdapterPosition(view);
        if (hasHeader(position)) {
            outRect.set(0, mView.getHeight(), 0, 0);
        } else {
            outRect.set(0, 0, 0, 0);
        }
    }

    private void drawHeader(int left, int top, Canvas canvas) {
        canvas.save();
        canvas.translate(left, top);
        mView.draw(canvas);
        canvas.restore();
    }

    private boolean hasHeader(int position) {
        return position % 2 == 0;
    }
}
