package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.coollection.R;

import java.util.ArrayList;

import models.Publicacion;

public class adapterPublicacion extends BaseAdapter {

    Context context;
    ArrayList<Publicacion> listapublicaciones;

    public adapterPublicacion(Context context, ArrayList<Publicacion> listapublicaciones) {
        this.context = context;
        this.listapublicaciones = listapublicaciones;
    }

    @Override
    public int getCount() {
        return listapublicaciones.size();
    }

    @Override
    public Object getItem(int i) {
        return listapublicaciones.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(context).inflate(R.layout.publicacion_item, null);//Decirle que layout va utilizar

        //Crear cada elemento del layout a utilizar, varia en cada caso
        TextView id = (TextView) view.findViewById(R.id.publicacion_id);
        TextView idusuario = (TextView) view.findViewById(R.id.publicacion_idusuario);
        TextView idimagen = (TextView) view.findViewById(R.id.publicacion_idimagen);

        //Llenar con datos los elementos creados
        Publicacion item = (Publicacion) getItem(i);
        id.setText(item.getIdimagen());
        idusuario.setText(item.getIdusuario());
        idimagen.setText(item.getIdimagen());

        return view;
    }
}
