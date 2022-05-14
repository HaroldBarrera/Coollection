package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.coollection.R;

import java.util.ArrayList;

import models.Comentario;
import models.Usuario;

public class adapterComentario extends BaseAdapter {

    Context context;
    ArrayList<Comentario> listacomentarios;

    public adapterComentario(Context context, ArrayList<Comentario> listacomentarios) {
        this.context = context;
        this.listacomentarios = listacomentarios;
    }

    @Override
    public int getCount() {
        return listacomentarios.size();
    }

    @Override
    public Object getItem(int i) {
        return listacomentarios.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(context).inflate(R.layout.comentario_item, null);//Decirle que layout va utilizar

        //Crear cada elemento del layout a utilizar, varia en cada caso
        TextView id = (TextView) view.findViewById(R.id.comentario_id);
        TextView idusuario = (TextView) view.findViewById(R.id.comentario_idusuario);
        TextView idpublicacion = (TextView) view.findViewById(R.id.comentario_idpublicacion);
        TextView texto = (TextView) view.findViewById(R.id.comentario_texto);

        //Llenar con datos los elementos creados
        Comentario item = (Comentario) getItem(i);
        id.setText(item.getIdcomentario());
        idusuario.setText(item.getIdusuario());
        idpublicacion.setText(item.getIdpublicacion());
        texto.setText(item.getTexto());

        return view;
    }
}
