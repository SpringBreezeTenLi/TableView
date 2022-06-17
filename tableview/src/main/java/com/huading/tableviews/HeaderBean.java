package com.huading.tableviews;

public class HeaderBean {

    private String tip;
    private int clickCount;
    private boolean isDrawable;

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getClickCount() {
        return clickCount;
    }

    public void setClickCount(int clickCount) {
        this.clickCount = clickCount;
    }

    public boolean isDrawable() {
        return isDrawable;
    }

    public void setDrawable(boolean drawable) {
        isDrawable = drawable;
    }

    public HeaderBean(String tip, int clickCount, boolean isDrawable) {
        this.tip = tip;
        this.clickCount = clickCount;
        this.isDrawable = isDrawable;
    }
}
