package com.example.geolocation_application.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;

import java.util.List;
import androidx.recyclerview.widget.RecyclerView;
import com.example.geolocation_application.R;
import com.example.geolocation_application.model.Usuario;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder>{
    private List<Usuario> listaUsuarios;

    public UsuarioAdapter(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_usuario_viewholder, parent, false);

        return new UsuarioViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        holder.layout.findViewById(R.id.layoutDoFundoDoUsuario).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        ((TextView) holder.layout.findViewById(R.id.tvId)).setText(Integer.toString(listaUsuarios.get(position).getId()));
        ((TextView) holder.layout.findViewById(R.id.tvNome)).setText(listaUsuarios.get(position).getName());
        ((TextView) holder.layout.findViewById(R.id.tvUserName)).setText(listaUsuarios.get(position).getUserName());
        ((TextView) holder.layout.findViewById(R.id.tvEmail)).setText(listaUsuarios.get(position).getEmail());
        ((TextView) holder.layout.findViewById(R.id.tvAdress)).setText(listaUsuarios.get(position).getAddress().toString());
        ((TextView) holder.layout.findViewById(R.id.tvPhone)).setText(listaUsuarios.get(position).getPhone());
        ((TextView) holder.layout.findViewById(R.id.tvWebSite)).setText(listaUsuarios.get(position).getWebsite());
    }

    class UsuarioViewHolder extends RecyclerView.ViewHolder {
        public View layout;
        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);
            this.layout = itemView;
        }
    }
}
