package com.van.wfs.scan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.van.wfs.scan.zxing.MipcaActivityCapture;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    private Activity mActivity;
    private final static int SCANNIN_GREQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mActivity = this;
        mContext = this;

        Button mBtnScan = findViewById(R.id.btn_scan);
        mBtnScan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_scan){
            Log.e("","sssssssssssssssssssssss");
            Intent intentC = new Intent();
            intentC.setClass(mContext, MipcaActivityCapture.class);
            intentC.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivityForResult(intentC, SCANNIN_GREQUEST_CODE);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode){
                case SCANNIN_GREQUEST_CODE:

                    Bundle bundle = data.getExtras();
                    Toast.makeText(mContext,bundle.getString("result"),Toast.LENGTH_SHORT);
                    break;
            }
        }
    }
}
