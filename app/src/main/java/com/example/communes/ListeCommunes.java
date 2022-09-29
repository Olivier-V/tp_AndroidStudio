package com.example.communes;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListeCommunes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_communes);
        ArrayList<Commune> listeCommunes = new ArrayList<>();

        RecyclerView rvListeCommunes = findViewById(R.id.rvListeCommunes);
        rvListeCommunes.setLayoutManager(new LinearLayoutManager(this));

        String monDep = "57";

        JsonArrayRequest requete = new JsonArrayRequest(
                    Request.Method.GET,
                    "https://geo.api.gouv.fr/departements/"+monDep+"/communes",
                    null,
                    resultat -> {
                        try {
                            for ( int i=0 ; i<resultat.length(); i++){
                                JSONObject json = resultat.getJSONObject((i));
                                Commune commune = new Commune(json);
                                listeCommunes.add(commune);
                            }

                            rvListeCommunes.setAdapter(new AdapterListeCommunes(listeCommunes));

                            Toast.makeText(
                                    this,
                                    "Affichage de "+listeCommunes.size()+" communes",
                                    Toast.LENGTH_LONG
                            ).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    },
                    error -> error.printStackTrace()
                    );

        RequestManager.getInstance(this).addToRequestQueue(requete);
    }
}