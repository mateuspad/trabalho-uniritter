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
        // return 0;
        return listaUsuarios.size();
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        holder.layout.findViewById(R.id.layoutDoFundo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.layout.findViewById(R.id.estrelinha).setVisibility(View.VISIBLE);
                listaUsuarios.get(position).setNome("Troquei para "+position);
                ((TextView) holder.layout.findViewById(R.id.tvNome)).setText(listaUsuarios.get(position).getNome());
            }
        });
        ((TextView) holder.layout.findViewById(R.id.tvLogin)).setText(listaUsuarios.get(position).getLogin());
        ((TextView) holder.layout.findViewById(R.id.tvNome)).setText(listaUsuarios.get(position).getNome());
        ((TextView) holder.layout.findViewById(R.id.tvMatricula)).setText(listaUsuarios.get(position).getMatricula()+"");
    }

    class UsuarioViewHolder extends RecyclerView.ViewHolder {
        public View layout;

        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);
            this.layout = itemView;
        }
    }
}
