package com.example.videoclubandroid; /* TODO package */

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.URL;

;

public class MovieLoader extends AsyncTask<Object, Void, Bitmap>
{
    ImageView mImageView = null;
    Movie mMovieItem = null;

    @Override
    protected Bitmap doInBackground(Object... params)
    {
        mMovieItem = (Movie) params[0];
        mImageView = (ImageView) params[1];

        return prv_imageLoader( mMovieItem.getPoster() );
    }

    @Override
    protected void onPostExecute (Bitmap result)
    {
        if (result != null)
        {
            mImageView.setImageBitmap(result);
            mMovieItem.setImagen(new SoftReference<>(result));
        }
    }

    private Bitmap prv_imageLoader(String strURL)
    {
        /* TODO: completar la descarga de imágenes */
        HttpURLConnection http = null;
        Bitmap bitmap = null;
        try {
            URL url = new URL( strURL );
            http = (HttpURLConnection)url.openConnection();
            if( http.getResponseCode() == HttpURLConnection.HTTP_OK )
                bitmap = BitmapFactory.decodeStream(http.getInputStream());
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            if( http != null )
                http.disconnect();
        }
        return bitmap;
    }

}
