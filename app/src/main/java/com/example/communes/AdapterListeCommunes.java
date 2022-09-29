package com.example.communes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterListeCommunes extends RecyclerView.Adapter<AdapterListeCommunes.ProduitViewHolder> {

    private ArrayList<Commune> listeCommunes;


    public AdapterListeCommunes(ArrayList<Commune> listeCommunes) {
        this.listeCommunes = listeCommunes;
    }

    static class ProduitViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvNom;
        private final TextView tvCode;
        private final TextView tvCodeDepartement;
        private final TextView tvPopulation;
        private final TextView tvSiren;
        private final TextView tvEpci;
        private final TextView tvCodeRegion;


        public ProduitViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNom = itemView.findViewById(R.id.tvNom);
            tvCode = itemView.findViewById(R.id.tvCode);
            tvCodeDepartement = itemView.findViewById(R.id.tvCodeDepartement);
            tvPopulation = itemView.findViewById(R.id.tvPopulation);
            tvSiren = itemView.findViewById(R.id.tvSiren);
            tvEpci = itemView.findViewById(R.id.tvEpci);
            tvCodeRegion = itemView.findViewById(R.id.tvCodeRegion);

        }

        public TextView getTvNom() {
            return tvNom;
        }

        public TextView getTvCode() {
            return tvCode;
        }

        public TextView getTvCodeDepartement() {
            return tvCodeDepartement;
        }

        public TextView getTvPopulation() {
            return tvPopulation;
        }

        public TextView getTvSiren() {
            return tvSiren;
        }

        public TextView getTvEpci() {
            return tvEpci;
        }

        public TextView getTvCodeRegion() {
            return tvCodeRegion;
        }
    }

    @NonNull
    @Override
    public ProduitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vueItem = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_commune,parent,false);

        return new ProduitViewHolder(vueItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ProduitViewHolder holder, int position) {
        Commune commune = listeCommunes.get(position);
        holder.getTvNom().setText(commune.getNom());
        holder.getTvCode().setText(commune.getCode());
        holder.getTvCodeDepartement().setText(commune.getCodeDepartement());
        holder.getTvPopulation().setText(commune.getPopulation());
        holder.getTvSiren().setText(commune.getSiren());
        holder.getTvEpci().setText(commune.getEpci());
        holder.getTvCodeRegion().setText(commune.getCodeRegion());
    }

    @Override
    public int getItemCount() {
        return listeCommunes.size();
    }
}
