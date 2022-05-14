package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.coollection.R;
import models.Usuario;

import java.util.ArrayList;

public class adapterUsuario extends BaseAdapter {

    Context context;
    ArrayList<Usuario> listausuario;

    public adapterUsuario(Context context, ArrayList<Usuario> listausuario) {
        this.context = context;
        this.listausuario = listausuario;
    }

    @Override
    public int getCount() {
        return listausuario.size();
    }

    @Override
    public Object getItem(int i) {
        return listausuario.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(context).inflate(R.layout.usuario_item, null);//Decirle que layout va utilizar

        //Crear cada elemento del layout a utilizar, varia en cada caso
        TextView idusuario = (TextView) view.findViewById(R.id.usu_id);
        TextView nombre = (TextView) view.findViewById(R.id.usu_nombre);
        TextView apellido = (TextView) view.findViewById(R.id.usu_apellido);
        TextView correo = (TextView) view.findViewById(R.id.usu_correo);
        TextView password = (TextView) view.findViewById(R.id.usu_password);
        TextView username = (TextView) view.findViewById(R.id.usu_username);

        //Llenar con datos los elementos creados
        Usuario item = (Usuario) getItem(i);
        idusuario.setText(item.getId());
        nombre.setText(item.getNombre());
        apellido.setText(item.getApellido());
        correo.setText(item.getCorreo());
        username.setText(item.getUsername());
        password.setText(item.getPassword());

        return view;
    }
}
