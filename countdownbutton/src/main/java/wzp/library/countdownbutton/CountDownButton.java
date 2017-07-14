package wzp.library.countdownbutton;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by wzp on 2017/7/13.
 */

public class CountDownButton extends Button {

    private int countDown = 60; // 默认倒计时时间
    private Timer timer;
    private Handler handler = new Handler();

    private static final String DEF_TEXT = "获取验证码";
    private static final String LOG_TAG = "CountDownButton";


    public CountDownButton(Context context) {
        super(context);
        init(context);
    }

    public CountDownButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CountDownButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setText(DEF_TEXT);
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        if (visibility == GONE) {
            if (timer != null) {
                timer.cancel();
                timer = null;

                setText(DEF_TEXT);
                setEnabled(true);
            }
        }
    }

    /**
     * 启动倒计时
     *
     * @param countDown
     */
    public void startCountDown(final int countDown) {
        if (countDown >= 1) {
            this.countDown = countDown;
        }
        setEnabled(false);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        setText(CountDownButton.this.countDown-- + "s后重新获取");
                        if (CountDownButton.this.countDown < 0) {
                            timer.cancel();
                            timer = null;

                            setText(DEF_TEXT);
                            setEnabled(true);
                        }
                    }
                });
            }
        }, 0, 1000);
    }
}
