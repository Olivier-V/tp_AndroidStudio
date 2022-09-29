package com.example.communes;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Commune {
    protected String nom;
    protected String code;
    protected String codeDepartement;
    protected String population;
    protected String siren;
    protected String epci;
    protected String codeRegion;

    public Commune(String nom, String code, String codeDepartement, String population, String siren, String epci, String codeRegion) {
        this.nom = nom;
        this.code = code;
        this.codeDepartement = codeDepartement;
        this.population = population;
        this.siren = siren;
        this.epci = epci;
        this.codeRegion = codeRegion;
    }

    public Commune(JSONObject json) throws JSONException {
        this.nom = json.getString("nom");
        this.code = json.getString("code");
        this.codeDepartement = json.getString("codeDepartement");
        this.population = json.getString("population");
        this.siren = json.getString("siren");
        this.epci = json.getString("codeEpci");
        this.codeRegion = json.getString("codeRegion");
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeDepartement() {
        return codeDepartement;
    }

    public void setCodeDepartement(String codeDepartement) {
        this.codeDepartement = codeDepartement;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getSiren() {
        return siren;
    }

    public void setSiren(String siren) {
        this.siren = siren;
    }

    public String getEpci() {
        return epci;
    }

    public void setEpci(String epci) {
        this.epci = epci;
    }

    public String getCodeRegion() {
        return codeRegion;
    }

    public void setCodeRegion(String codeRegion) {
        this.codeRegion = codeRegion;
    }
}
