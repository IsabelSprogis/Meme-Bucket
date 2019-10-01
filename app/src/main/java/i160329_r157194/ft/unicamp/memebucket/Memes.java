package i160329_r157194.ft.unicamp.memebucket;

import android.net.Uri;

import java.net.URI;

public class Memes {
    public String nome;
    public String descricao;
    public Uri uri;

    public Memes(String nome, String descricao, Uri uri){
        this.nome = nome;
        this.descricao = descricao;
        this.uri = uri;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }

    public Uri getUri() { return uri; }

    public void setUri(Uri uri) { this.uri = uri; }
}