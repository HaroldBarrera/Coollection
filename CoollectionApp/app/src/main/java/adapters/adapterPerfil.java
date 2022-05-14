package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.coollection.R;

import java.util.ArrayList;

import models.Perfil;
import models.Usuario;

public class adapterPerfil extends BaseAdapter {

    Context c;
    ArrayList<Perfil> listaperfiles;

    public adapterPerfil(Context c, ArrayList<Perfil> listaperfiles) {
        this.c = c;
        this.listaperfiles = listaperfiles;
    }

    @Override
    public int getCount() {
        return listaperfiles.size();
    }

    @Override
    public Object getItem(int i) {
        return listaperfiles.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(c).inflate(R.layout.perfil_item, null);//Decirle que layout va utilizar

        //Crear cada elemento del layout a utilizar, varia en cada caso
        TextView idusuario = (TextView) view.findViewById(R.id.per_idusuario);
        TextView idperfil = (TextView) view.findViewById(R.id.per_id);
        TextView codigo = (TextView) view.findViewById(R.id.per_codigo);
        TextView tipo = (TextView) view.findViewById(R.id.per_tipo);

        //Llenar con datos los elementos creados
        Perfil item = (Perfil) getItem(i);
        idusuario.setText(item.getIdusuario());
        idperfil.setText(item.getIdperfil());
        codigo.setText(item.getCodigo());
        tipo.setText(item.getTipo());

        return view;
    }
}
