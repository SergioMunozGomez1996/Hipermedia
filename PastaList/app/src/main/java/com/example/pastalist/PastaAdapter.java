package com.example.pastalist; /* TODO package */;

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

public class PastaAdapter extends BaseAdapter implements OnScrollListener
{
    private List<Pasta> mList;
    private Context mContext;
    /* TODO: mapa de descargas activas */
    Map<Pasta, PastaLoader> mImagenesCargando;

    boolean mBusy = false;

    public PastaAdapter(Context context, List<Pasta> objects)
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

        TextView tvTexto = (TextView) convertView.findViewById(R.id.textView);
        ImageView ivIcono = (ImageView) convertView.findViewById(R.id.imageView);

        Pasta pasta = mList.get(position);
        tvTexto.setText(pasta.getName());

        /* TODO: Completar la descarga lazy de imágenes */
        if(pasta.getImagen()!=null && pasta.getImagen().get()!=null) {
            ivIcono.setImageBitmap(pasta.getImagen().get());
        } else {
            // Ponemos esta imagen de momento
            ivIcono.setImageResource(R.mipmap.ic_launcher);

            // Si la imagen no está descargando...
            if(mImagenesCargando.get(pasta)==null && !mBusy) {
                PastaLoader task = new PastaLoader();
                mImagenesCargando.put(pasta, task);
                task.execute(pasta, ivIcono);
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
