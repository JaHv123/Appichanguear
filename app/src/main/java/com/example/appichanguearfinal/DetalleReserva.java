package com.example.appichanguearfinal;

public class DetalleReserva {
    private int mImageResource;
    private String mText1;
    private String mtext2;

    public DetalleReserva(int mImageResource, String mText1, String mtext2) {
        this.mImageResource = mImageResource;
        this.mText1 = mText1;
        this.mtext2 = mtext2;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public void setmImageResource(int mImageResource) {
        this.mImageResource = mImageResource;
    }

    public String getmText1() {
        return mText1;
    }

    public void setmText1(String mText1) {
        this.mText1 = mText1;
    }

    public String getMtext2() {
        return mtext2;
    }

    public void setMtext2(String mtext2) {
        this.mtext2 = mtext2;
    }
}
