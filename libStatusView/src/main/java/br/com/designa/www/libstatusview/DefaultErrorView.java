package br.com.designa.www.libstatusview;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DefaultErrorView {
    private TextView errorTextView;
    private Button errorButton;
    private ImageView errorImg;
    private LinearLayout containerError;
    private LinearLayout.LayoutParams componentParams;

    DefaultErrorView(Context context) {
        containerError = new LinearLayout(context);
        containerError.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        containerError.setOrientation(LinearLayout.VERTICAL);
        containerError.setGravity(Gravity.CENTER);
        containerError.setPadding(16, 16, 16, 16);

        componentParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        errorImg = new ImageView(context);
        errorImg.setLayoutParams(componentParams);
        containerError.addView(errorImg);

        errorTextView = new TextView(context);
        errorTextView.setLayoutParams(componentParams);
        errorTextView.setGravity(Gravity.CENTER);
        errorTextView.setPadding(8, 8, 8, 8);
        errorTextView.setTextSize(18);
        errorTextView.setTextColor(context.getResources().getColor(android.R.color.tertiary_text_dark));
        containerError.addView(errorTextView);

        errorButton = new Button(context);
        errorButton.setLayoutParams(componentParams);
        errorButton.setPadding(32, 16, 32, 16);
        errorButton.setTextColor(context.getResources().getColor(android.R.color.background_dark));
        containerError.addView(errorButton);
    }

    public void setComponentParams(int left, int top, int right, int bottom) {
        componentParams.setMargins(left, top, right, bottom);
        errorImg.setLayoutParams(componentParams);
        errorTextView.setLayoutParams(componentParams);
        errorButton.setLayoutParams(componentParams);
    }

    public View getView() {
       return containerError;
    }

    public TextView getTextViewError(int left, int top, int right, int bottom) {
        errorTextView.setPadding(left, top, right, bottom);
        return errorTextView;
    }

    public TextView getTextViewError() {
        return errorTextView;
    }

    public TextView getMarginTextViewError() {
        return errorTextView;
    }

    public Button getButtonError() {
        return errorButton;
    }

    public Button getButtonError(int left, int top, int right, int bottom) {
        errorButton.setPadding(left, top, right, bottom);
        return errorButton;
    }

    public ImageView getImgError() {
        return errorImg;
    }
}
