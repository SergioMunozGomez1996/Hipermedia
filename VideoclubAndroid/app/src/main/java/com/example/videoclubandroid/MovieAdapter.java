package com.example.videoclubandroid; /* TODO package */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

;

public class MovieAdapter extends BaseAdapter implements OnScrollListener
{
    private List<Movie> mList;
    private Context mContext;
    /* TODO: mapa de descargas activas */
    Map<Movie, MovieLoader> mImagenesCargando;

    boolean mBusy = false;

    public MovieAdapter(Context context, List<Movie> objects)
    {
        mContext = context;
        mList = objects;
        /* TODO: inicializar mapa de descargas activas */
        mImagenesCargando = new HashMap<>();
    }

    @Override
    public int getCount()
    {
        return mList.size();
    }

    @Override
    public Object getItem(int position)
    {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(convertView == null) {
            LayoutInflater li = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = li.inflate(R.layout.list_item, null);
        }

        TextView tvTexto = (TextView) convertView.findViewById(R.id.directorTextView);
        ImageView ivIcono = (ImageView) convertView.findViewById(R.id.imageView);

        Movie movie = mList.get(position);
        tvTexto.setText(movie.getTitle());

        /* TODO: Completar la descarga lazy de imágenes */
        if(movie.getImagen()!=null && movie.getImagen().get()!=null) {
            ivIcono.setImageBitmap(movie.getImagen().get());
        } else {
            // Ponemos esta imagen de momento
            ivIcono.setImageResource(R.mipmap.ic_launcher);

            // Si la imagen no está descargando...
            if(mImagenesCargando.get(movie)==null && !mBusy) {
                MovieLoader task = new MovieLoader();
                mImagenesCargando.put(movie, task);
                task.execute(movie, ivIcono);
            }
        }

        return convertView;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        switch(scrollState) {
            case OnScrollListener.SCROLL_STATE_IDLE:
                mBusy = false;
                notifyDataSetChanged();
                break;
            case OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
                mBusy = true;
                break;
            case OnScrollListener.SCROLL_STATE_FLING:
                mBusy = true;
                break;
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }
}
