package com.example.rahulkumar.mvp;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.v7.app.AlertDialog;

/**
 * Created by rahulkumar on 03/11/16.
 */

public class ErrorDialog extends AlertDialog {

    protected ErrorDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    public void ShowDialog(String title, String message, String button1, String button2) {

        setTitle(title);
        setMessage(message);
        setCancelable(false);
        setButton(DialogInterface.BUTTON_POSITIVE, button1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        setButton(DialogInterface.BUTTON_NEGATIVE, button2, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        show();
    }



}
