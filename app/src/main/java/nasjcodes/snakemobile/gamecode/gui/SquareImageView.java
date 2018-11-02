package nasjcodes.snakemobile.gamecode.gui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

//Simple class that overrides the standard onMeasure method of Views to ensure a square
public class SquareImageView extends android.support.v7.widget.AppCompatImageView {
    private ArrayList<View> otherViews;

    public SquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        otherViews = new ArrayList<View>();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int restrictedHeight = getMeasuredHeight();

        //Subtract the heights of all other elements to restrict the maximum height of gameView
        for(View view : otherViews) {
            view.requestLayout();
            restrictedHeight -= view.getMeasuredHeight();
        }

        //Find the smaller of the two so that a square can be displayed
        int sideLength;
        if(getMeasuredWidth() < restrictedHeight) {
            sideLength = getMeasuredWidth();
        } else {
            sideLength = restrictedHeight;
        }

        setMeasuredDimension(sideLength, sideLength);

    }

    public void addView(View view) {
        otherViews.add(view);
    }
}
