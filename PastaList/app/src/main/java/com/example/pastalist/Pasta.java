package com.example.pastalist; /* TODO package */;

import android.graphics.Bitmap;

import java.lang.ref.SoftReference;

public class Pasta
{
    private String mUrl;
    private String mName;
    private Bitmap mBitmap;

    private SoftReference<Bitmap> imagen;

    Pasta( String _url, String _name ) {
        mUrl = _url;
        mName = _name;
        mBitmap = null;
    }

    public String getUrl() { return mUrl; }
    public void setUrl( String _url ) { mUrl = _url; }

    public String getName() { return mName; }
    public void setName( String _name ) { mName = _name; }

    public Bitmap getBitmap() { return mBitmap; }
    public void setBitmap( Bitmap _bitmap ) { mBitmap = _bitmap; }

    public SoftReference<Bitmap> getImagen() {
        return imagen;
    }

    public void setImagen(SoftReference<Bitmap> imagen) {
        this.imagen = imagen;
    }
}
