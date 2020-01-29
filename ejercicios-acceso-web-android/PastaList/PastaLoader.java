package /* TODO package */;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

public class PastaLoader extends AsyncTask<Object, Void, Bitmap>
{
    ImageView mImageView = null;
    Pasta mPastaItem = null;

    @Override
    protected Bitmap doInBackground(Object... params)
    {
        mPastaItem = (Pasta) params[0];
        mImageView = (ImageView) params[1];

        return prv_imageLoader( mPastaItem.getUrl() );
    }

    @Override
    protected void onPostExecute (Bitmap result)
    {
        if (result != null)
        {
            mImageView.setImageBitmap(result);
            mPastaItem.setBitmap( result );
        }
    }

    private Bitmap prv_imageLoader(String url)
    {
        /* TODO: completar la descarga de imágenes */
        return null;
    }

}
