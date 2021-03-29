package com.example.petshare.classes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.petshare.R;

public class lojas extends AppCompatActivity {

    ListView lista;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getSupportActionBar().setTitle("lista de Sites");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        setContentView(R.layout.activity_lojas);

        //listview objeto da tela
        ListView lista = findViewById(R.id.lista);
        //dados da lista
        String[] dados = new String[] {

                "https://www.paodeacucar.com/secoes/C4236/limpeza-pet?qt=12&p=0&gt=list&utm_source=Google&utm_medium=cpc&utm_campaign=pao-acucar-categoria-limpeza-sp&utm_term=dsa-limpeza-sp&utm_content=limpeza-geral-keyword-alcance",
                 "https://www.cobasi.com.br/animais?gclid=CjwKCAjw8pH3BRAXEiwA1pvMsR9QwLGvY8Df7TLxKYJQOEmSbesxYeKuRntIyLC8VyNfW1PORj0JXxoC5vsQAvD_BwE",
                "https://www.merceariadoanimal.com.br/",
                "https://www.cachorrogato.com.br/cachorros/loja-animais/",
                "https://www.supermercadodospets.com.br/",
                "http://www.petserra.com.br/?gclid=CjwKCAjw8pH3BRAXEiwA1pvMsVoHARjPt709Pd47kYawkP6zqfGEwAlYut2IuZ7_Lu_X7jNAW0WXuBoC-FsQAvD_BwE"};






        //adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dados);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String texto = "";
                TextView tv = (TextView) view;
                texto = tv.getText().toString();
                Toast.makeText(getApplicationContext(),
                       "clicou no item" + texto, Toast.LENGTH_LONG).show();

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(texto));
                startActivity(i);
            }
        });

    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
