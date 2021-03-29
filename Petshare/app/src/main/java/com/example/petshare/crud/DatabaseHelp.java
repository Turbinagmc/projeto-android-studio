package com.example.petshare.crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
// extende a classe Databasehelp "extends SQLiteOpenHelp",
// ao exender o SQLiteOpenHelp aparecerá um erro pois é necessário implementar os métodos onCreate, onUpgrade e também o construtor.
//Esses métodos e construtot pode ser criado automaticamente com alt insert
// link de video com referência https://www.youtube.com/watch?v=1WPAXHhG6u0&t=762s
public class DatabaseHelp extends SQLiteOpenHelper  {
     // caso craido automaticamente só apagar e deixar somente até context.
    // Já super context o contexto , Login.db nome do banco de dados, null não passa nenhum parâmetro , version  a versão do banco de dados
    public DatabaseHelp(@Nullable Context context) {
        super(context, "Login.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // aqui cria a tabela db do SQLite acima db.execSQL dentro escreve para cria a tabela passa nome dela no caso usuario
        // define o id integer como autoincremente para gerar automaticamente e passa os outro elementos da tabela
        db.execSQL("Create table usuario( id integer primary key autoincrement,email text,senha text, nome text,nomeus text)");
        db.execSQL("Create table animais(id integer primary key autoincrement, numero text, data text, descricao, raca text,cor text, porte text, sexo text, animaldes text, bairro tex)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // novamente o db.exSQL código para retornar a tabela se existir
        db.execSQL("drop table if exists usuario");
        db.execSQL("drop table if exists animais");
    }

    // esse é o metodo de inserir na tabela
    public boolean insert(String nome,String senha,String email,String nomeus){
        // novo SQLite db para mexer no SQLite .
        // this.getWritableDatabase(); para alterar dados no banco no caso incluilos
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("nome",nome);
        contentValues.put("senha",senha);
        contentValues.put("email",email);
        contentValues.put("nomeus",nomeus);
        long ins= db.insert("usuario",null,contentValues);
        //contenteValues usado para colocar os dados na tabela
        // a variável ins verifica a inserção dos dados
        if (ins==1) return false;
        else return true;
    }
     public boolean insertanimais(String numero,String data, String descricao, String raca, String cor, String porte, String sexo, String animaldes, String bairro){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("numero",numero);
        contentValues.put("data",data);
        contentValues.put("descricao",descricao);
        contentValues.put("raca",raca);
        contentValues.put("cor",cor);
        contentValues.put("porte",porte);
        contentValues.put("sexo",sexo);
        contentValues.put("animaldes",animaldes);
        contentValues.put("bairro",bairro);
        long ins = db.insert("animais",null,contentValues);
        if(ins == 1) return false;
        else return true;

     }
      // método para verificar se o e-mail existe no banco de dados
    public Boolean chkemail(String email ){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from usuario where email=?", new String[]{email});
        if(cursor.getCount()>0) return false;
        else return true;
    }
    public  Boolean chjnomeus (String nomeus){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from usuario where nomeus=?", new String[]{nomeus});
        if(cursor.getCount()>0) return false;
        else  return true;
    }
   // método para verificar se nome e senha existem no banco de dados
    public Boolean nomesenha(String nomeus,String senha){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from usuario where nomeus=? and senha=?", new String[]{nomeus,senha});
        if(cursor.getCount()>0) return true;
        else return false;
    }
    //método para pegar os dados no banco de dados
    // Do tipo Cursor e nome do curso
    public Cursor getLista(){
        SQLiteDatabase db = this.getReadableDatabase();
        // outra variável do curso
        // seletct para selecionar a tabela from usuario from indicamos o nome da tabela
        Cursor lista = db.rawQuery("select * from usuario ",null);
        return lista;
    }
    public  Cursor getListaAnimais(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor lista = db.rawQuery("select * from animais",null);
        return lista;
    }
}
