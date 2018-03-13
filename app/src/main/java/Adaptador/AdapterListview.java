package Adaptador;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eduardopalacios.toolbar.R;

import java.util.List;

import Holders.HolderItems;
import clases.Item;

/**
 * Created by eduardopalacios on 28/02/18.
 */

public class AdapterListview extends ArrayAdapter<Item>{


    int resource;
    Context context;
    List<Item>items;
    public AdapterListview(Context context, int resource, List<Item>items) {
        super(context, resource, items);

        this.resource=resource;
        this.context=context;
        this.items=items;

    }

    public View getView(int position, View convertView, ViewGroup group)
    {
        View row=convertView;
        HolderItems holderItems = null;



        if (row==null)
        {
            LayoutInflater inflater =LayoutInflater.from(context);
            row=inflater.inflate(resource,group,false);
            holderItems= new HolderItems();
            holderItems.imagen=(ImageView)row.findViewById(R.id.imagen);
            holderItems.nombre=(TextView)row.findViewById(R.id.nombre);
            holderItems.telefono=(TextView)row.findViewById(R.id.telefono);
            row.setTag(holderItems);


        }
        else {
            holderItems=(HolderItems)row.getTag();
        }

        holderItems.imagen.setImageResource(items.get(position).getImagen());
        holderItems.nombre.setText(items.get(position).getNombre());
        holderItems.telefono.setText(items.get(position).getTelefono());


        return row;

    }
}
