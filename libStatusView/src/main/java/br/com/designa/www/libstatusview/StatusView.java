package br.com.designa.www.libstatusview;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class StatusView {
    private static final int LAYOUT_DEFAULT = 0;
    private static final int LAYOUT_ERROR = 1;
    private static final int LAYOUT_LOADING = 2;

    private Context context;
    private ArrayList<View> defaultLayout;
    private LinearLayout layoutContainer;
    private View errorLayout;
    private View loadingLayout;
    private ViewGroup recipientLayout;
    private DefaultErrorView defaultDefaultErrorView;
    private DefaultLoadingView defaultLoadingView;


    public StatusView(Context context) {
        this.context = context;
        layoutContainer = new LinearLayout(context);
        layoutContainer.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(16, 16, 16, 16);
        layoutContainer.setLayoutParams(layoutParams);

        defaultDefaultErrorView = new DefaultErrorView(context);
        defaultLoadingView = new DefaultLoadingView(context);
    }

    public StatusView setRecipientLayout(ViewGroup recipientLayout) {
        this.recipientLayout = recipientLayout;
        defaultLayout = getAllChildren(recipientLayout);
        return this;
    }

    public StatusView setErrorLayout(int errorLayoutId) {
        if (errorLayoutId != 0 && recipientLayout != null) {
            errorLayout = LayoutInflater.from(context).inflate(errorLayoutId, null);
        }

        return this;
    }

    public StatusView setLoadingLayout(int loadingLayoutId) {
        if (loadingLayoutId != 0 && recipientLayout != null) {
            loadingLayout = LayoutInflater.from(context).inflate(loadingLayoutId, null);
        }

        return this;
    }

    public void showErrorLayout(int gravity) {
        showLayout(LAYOUT_ERROR, gravity);
    }

    public void showLoadingLayout(int gravity) {
        showLayout(LAYOUT_LOADING, gravity);
    }

    public void showErrorLayout() {
        showLayout(LAYOUT_ERROR, Gravity.NO_GRAVITY);
    }

    public void showLoadingLayout() {
        showLayout(LAYOUT_LOADING, Gravity.NO_GRAVITY);
    }

    public void showDefaultLayout() {
        showLayout(LAYOUT_DEFAULT, Gravity.NO_GRAVITY);
    }

    private void showLayout(int layoutType, int gravity) {
        displayLayout(layoutType);

        if (layoutType != LAYOUT_DEFAULT) {
            for (View v : defaultLayout){
                v.setVisibility(View.GONE);
            }
        }

        int sizeParam = gravity != Gravity.NO_GRAVITY ?  ViewGroup.LayoutParams.WRAP_CONTENT : ViewGroup.LayoutParams.MATCH_PARENT;

        switch (layoutType) {
            case LAYOUT_ERROR: {
                if (errorLayout != null){
                    errorLayout.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
                    errorLayout.getLayoutParams().height = sizeParam;
                }

                break;
            }

            case LAYOUT_LOADING: {

                if (loadingLayout != null){
                    loadingLayout.getLayoutParams().width= ViewGroup.LayoutParams.MATCH_PARENT;
                    loadingLayout.getLayoutParams().height = sizeParam;
                }

                break;
            }
        }

        layoutContainer.setGravity(gravity);
    }

    private void displayLayout(int layout) {
        recipientLayout.removeView(layoutContainer);

        switch (layout) {
            case LAYOUT_DEFAULT: {
                for (View v : defaultLayout){
                    v.setVisibility(View.VISIBLE);
                }

                break;
            }

            case LAYOUT_ERROR: {
                if (errorLayout != null) {
                    setupContainerLayout(errorLayout);
                } else {
                    setupContainerLayout(defaultDefaultErrorView.getView());
                }

                break;
            }

            case LAYOUT_LOADING: {
                if (loadingLayout != null) {
                    setupContainerLayout(loadingLayout);
                } else {
                    setupContainerLayout(defaultLoadingView.getView());
                }

                break;
            }
        }
    }

    private void setupContainerLayout(View v) {
        layoutContainer.removeAllViews();
        layoutContainer.addView(v);
        recipientLayout.addView(layoutContainer);
        layoutContainer.setVisibility(View.VISIBLE);
    }

    private ArrayList<View> getAllChildren(View v) {
        ArrayList<View> result = new ArrayList<>();
        ViewGroup viewGroup = (ViewGroup) v;

        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View child = viewGroup.getChildAt(i);
            result.add(child);
        }

        return result;
    }

    public View getErrorLayout() {
        return errorLayout;
    }

    public View getLoadingLayout() {
        return loadingLayout;
    }

    public DefaultErrorView getDefaultDefaultErrorView(){
        return defaultDefaultErrorView;
    }
}
