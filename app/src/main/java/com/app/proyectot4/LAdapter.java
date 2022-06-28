package com.app.proyectot4;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.app.proyectot4.databinding.ListaLicoresItemBinding;
import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

public class    LAdapter extends ListAdapter<Categoria,LAdapter.LViewHolder> {

    public static final DiffUtil.ItemCallback<Categoria> DIIF_CALLBACK = new DiffUtil.ItemCallback<Categoria>(){

        @Override
        public boolean areItemsTheSame(@NonNull @NotNull Categoria oldItem, @NonNull @NotNull Categoria newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull @NotNull Categoria oldItem, @NonNull @NotNull Categoria newItem) {
            return oldItem.equals(newItem);
        }
    };

    protected LAdapter(@NonNull @org.jetbrains.annotations.NotNull DiffUtil.ItemCallback<Categoria> diffCallback) {
        super(DIIF_CALLBACK);
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public LAdapter.LViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        ListaLicoresItemBinding bin = ListaLicoresItemBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new LViewHolder(bin);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull LAdapter.LViewHolder holder, int position) {
        Categoria categoria = getItem(position);
        holder.bind(categoria);
    }

    private OnItemClickListener onItemClickListener;

    interface OnItemClickListener{
        void onItemClick(Categoria categoria);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public class LViewHolder extends RecyclerView.ViewHolder {
        private final ListaLicoresItemBinding bin;
        public LViewHolder(ListaLicoresItemBinding bin){
            super(bin.getRoot());
            this.bin=bin;
        }
        public void bind(Categoria categoria) {
            String URL_IMG = categoria.getImagen();

            bin.txtCodigo.setText((categoria.getId()));
            bin.txtNombre.setText(categoria.getNombre());
            Glide.with(bin.imgCoctel).load(URL_IMG).placeholder(R.drawable.loading).centerCrop().into(bin.imgCoctel);
            bin.getRoot().setOnClickListener(view -> {
                onItemClickListener.onItemClick(categoria);
            });
            bin.executePendingBindings();
        }
    }
}
