package br.com.designa.www.statusview;

import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import br.com.designa.www.libstatusview.StatusView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout rootView;
    private StatusView statusView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootView = findViewById(R.id.activity_main_root);
        statusView = new StatusView(this).setRecipientLayout(rootView);

        //Set Loading Default
        statusView.showLoadingLayout(Gravity.CENTER);

//        Set Loading Custom
//        statusView.setLoadingLayout(R.layout.layout_loading);
//        statusView.showLoadingLayout(Gravity.CENTER);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Call Your Layout
                statusView.showDefaultLayout();
            }
        }, 2000);
    }

    private void showError() {
        statusView.getDefaultDefaultErrorView().getButtonError().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("Log", "Action Error");
            }
        });
        statusView.showErrorLayout(Gravity.CENTER);
    }
}
