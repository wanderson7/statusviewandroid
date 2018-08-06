package br.com.designa.www.libstatusview;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

public class DefaultLoadingView {
    private ProgressBar progressBar;
    private LinearLayout containerLoading;

    DefaultLoadingView(Context context) {
        containerLoading = new LinearLayout(context);
        containerLoading.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        containerLoading.setOrientation(LinearLayout.VERTICAL);
        containerLoading.setGravity(Gravity.CENTER_HORIZONTAL);
        containerLoading.setPadding(16, 16, 16, 16);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        progressBar = new ProgressBar(context, null ,android.R.attr.progressBarStyle);
        progressBar.setIndeterminate(true);
        progressBar.setPadding(32, 64, 32, 64);
        progressBar.setLayoutParams(params);
        containerLoading.addView(progressBar);
    }

    public View getView() {
        return containerLoading;
    }

    public ProgressBar getProgressBarView() {
        return progressBar;
    }

    public LinearLayout getContainerLoading() {
        return containerLoading;
    }
}
