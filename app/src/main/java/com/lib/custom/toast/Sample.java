package com.lib.custom.toast;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ib.custom.toast.CustomToast;

/*
 * Sample App on How To Use Library
 */

public class Sample extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        initialiseViews();
    }

    /**
     * initialise views
     */
    private void initialiseViews() {

        Button btnDefault = findViewById(R.id.btnDefault);
        btnDefault.setOnClickListener(this);

        Button btnSuccess = findViewById(R.id.btnSuccess);
        btnSuccess.setOnClickListener(this);

        Button btnError = findViewById(R.id.btnError);
        btnError.setOnClickListener(this);

        Button btnWarning = findViewById(R.id.btnWarning);
        btnWarning.setOnClickListener(this);

        Button btnInfo = findViewById(R.id.btnInfo);
        btnInfo.setOnClickListener(this);

    }

    /**
     *
     * @param view the view which has been clicked
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnDefault:
                CustomToast.makeText(this, Toast.LENGTH_SHORT,CustomToast.DEFAULT, "Toast is working",false).show();
                break;

            case R.id.btnSuccess:
                CustomToast.makeText(this, Toast.LENGTH_SHORT,CustomToast.SUCCESS,"Toast is working",false).show();
                break;

            case R.id.btnError:
                CustomToast.makeText(this, Toast.LENGTH_SHORT,CustomToast.ERROR,"Username is not valid",false).show();
                break;

            case R.id.btnWarning:
                CustomToast.makeText(this, Toast.LENGTH_SHORT,CustomToast.WARNING,"Out Of Memory",false).show();
                break;

            case R.id.btnInfo:
                CustomToast.makeText(this, Toast.LENGTH_SHORT,CustomToast.INFO,"This is a customised Toast",false).show();
                break;
        }
    }
}
