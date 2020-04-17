import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.myapplication.R;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private static final android.graphics.BitmapFactory BitmapFactory = ;
    SurfaceHolder surfaceHolder;
    Bitmap BG, SuperMan;

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        surfaceHolder = getHolder();
        BG = BitmapFactory.decodeResource(getResources(), R.drawable.back);
        SuperMan = BitmapFactory.decodeResource(getResources(), R.drawable.superman);
        surfaceHolder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Canvas canvas = surfaceHolder.lockCanvas(null);
        drawSomething(canvas);
        surfaceHolder.unlockCanvasAndPost(canvas);

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
    protected void drawSomething(Canvas canvas) {
        canvas.drawBitmap(BG, 0, 0, null);
        canvas.drawBitmap(SuperMan, 100, 100, null);
    }

}
