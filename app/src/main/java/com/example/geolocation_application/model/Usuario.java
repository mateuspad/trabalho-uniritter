package com.example.geolocation_application.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class Usuario implements Parcelable {
    private String login;
    private String senha;
    private String nome;
    private int matricula;

    public Usuario(int matricula, String login, String senha, String nome) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.matricula = matricula;
    }

    protected Usuario(Parcel in) {
        login = in.readString();
        senha = in.readString();
        nome = in.readString();
        matricula = in.readInt();
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return matricula == usuario.matricula && Objects.equals(login, usuario.login) && Objects.equals(senha, usuario.senha) && Objects.equals(nome, usuario.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, senha, nome, matricula);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getMatricula());
        parcel.writeString(getLogin());
        parcel.writeString(getSenha());
        parcel.writeString(getNome());

    }
}
