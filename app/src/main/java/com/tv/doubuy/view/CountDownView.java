package com.tv.doubuy.view;


import android.os.CountDownTimer;


public class CountDownView {
    private CountDownTimer countDownTimer;
    private int countDownTime = 50000;//倒计时时长
    private CountDownTimerListener listener;

    public CountDownView(int second) {
        this.countDownTime = second * 1000 + 100;
        getTimer();
    }

    private void getTimer() {
        countDownTimer = new CountDownTimer(countDownTime, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (listener != null) {
                    if (millisUntilFinished >= 1000) {
                        listener.onTick(millisUntilFinished / 1000 + "");
                    } else {
                        listener.onTick("0");
                    }
                }
            }

            @Override
            public void onFinish() {
                if (listener != null) {
                    listener.onFinish();
                }
            }
        };
    }

    public void onStart() {
        if (countDownTimer != null) {
            countDownTimer.start();
        }
    }

    public void onStop() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void setCountDownTimerListener(CountDownTimerListener listener) {
        this.listener = listener;
    }

    public interface CountDownTimerListener {
        void onTick(String second);

        void onFinish();
    }
}
