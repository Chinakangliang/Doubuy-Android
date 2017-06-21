package com.tv.doubuy.dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TextView;

import com.tv.doubuy.R;

/**
 * Created by apple on 2017/6/21.
 */

public class PromptDialog extends AlertDialog implements View.OnClickListener {

    private String dialogContent;
    String b1;
    String b2;

    private TextView title;
    private TextView content;
    private TextView btnNo;
    private TextView btnYes;

    private DialogCallBack callback;

    public PromptDialog(@NonNull Context context, String content) {
        super(context, R.style.dialog);
        this.dialogContent = content;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_prompt_dialog);
        initView();
    }

    public void setButtonText(String b1, String b2) {
        this.b1 = b1;
        this.b2 = b2;
    }

    private void initView() {
        title = (TextView) findViewById(R.id.dialog_title);
        content = (TextView) findViewById(R.id.dialog_content);
        btnNo = (TextView) findViewById(R.id.dialog_btnNo);
        btnYes = (TextView) findViewById(R.id.dialog_btnYes);
        btnNo.setOnClickListener(this);
        btnYes.setOnClickListener(this);
        if (dialogContent != null) {
            content.setText(dialogContent);
        }

        btnYes.setText(b1 != null && !b1.equals("") ? b1 : "是");
        btnNo.setText(b2 != null && !b2.equals("") ? b2 : "否");
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.dialog_btnNo:

                if (callback != null) {
                    callback.noCallBack();
                    dismiss();
                }
                break;

            case R.id.dialog_btnYes:
                if (callback != null) {
                    callback.yesCallBack();
                }
                break;
        }

    }

    public void setDiaLogClick(DialogCallBack callback) {
        this.callback = callback;
    }


    public interface DialogCallBack {
        void yesCallBack();

        void noCallBack();
    }
}
