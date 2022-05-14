package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.coollection.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import models.Imagen;
import models.Usuario;

public class adapterImagen extends BaseAdapter {

    Context context;
    ArrayList<Imagen> listaimagenes;

    public adapterImagen(Context context, ArrayList<Imagen> listaimagenes) {
        this.context = context;
        this.listaimagenes = listaimagenes;
    }

    @Override
    public int getCount() {
        return listaimagenes.size();
    }

    @Override
    public Object getItem(int i) {
        return listaimagenes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.imagen_item, null);//Decirle que layout va utilizar

        //Crear cada elemento del layout a utilizar, varia en cada caso
        CircleImageView imagen = (CircleImageView) view.findViewById(R.id.imagen_imagen);
        TextView id = (TextView) view.findViewById(R.id.imagen_id);
        TextView descripcion = (TextView) view.findViewById(R.id.imagen_descripcion);

        //Llenar con datos los elementos creados
        Imagen item = (Imagen) getItem(i);
        id.setText(item.getIdimagen());
        descripcion.setText(item.getDescripcion());
        Glide.with(view).load(item.getImagen()).into(imagen);

        return view;
    }
}
