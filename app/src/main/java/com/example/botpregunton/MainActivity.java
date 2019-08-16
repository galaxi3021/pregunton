package com.example.botpregunton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.GregorianCalendar;
public class MainActivity extends AppCompatActivity {
    private ListView lista;
    List<String> items;
    ArrayAdapter ADP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText txtNombre=findViewById(R.id.txtNombre);
        final Button btnAgregar=findViewById(R.id.btnAgregar);
        lista=findViewById(R.id.Lista);
        items=new ArrayList<>();
        ADP=new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,items);
        lista.setAdapter(ADP);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String f=txtNombre.getText().toString();
                int num=0;
                int numero;
                for (int i=0;i<f.length();i++){
                    if (f.charAt(i)=='¿') {
                        num=num+1;
                    }
                    if (f.charAt(i)=='?') {
                        num=num+1;
                    }
                }
                if(txtNombre.getText().toString().matches("") || f.length()==2){
                    Toast.makeText(getApplicationContext(),
                            "Ingrese alguna pregunta", Toast.LENGTH_SHORT).show();
                    num=3;
                }
                else if(num<2){
                    Toast.makeText(getApplicationContext(),
                            "Falto el simbolo de interrogacion", Toast.LENGTH_SHORT).show();
                }
                else if(num==2){
                    items.add(txtNombre.getText().toString());
                    txtNombre.setText("");
                    ADP.notifyDataSetChanged();
                    Date currentTime = GregorianCalendar.getInstance().getTime();
                    items.add(currentTime.toLocaleString());
                    num=0;


                    numero = (int) (Math.random() * 5);
                    if(numero==0){     items.add("                                                                              Si");}
                    else if(numero==1){items.add("                                                                              No");}
                    else if(numero==2){items.add("                                                               Pregunta de nuevo");}
                    else if(numero==3){items.add("                                                                     Es probable");}
                    else if(numero==4){items.add("                                                                      No lo creo");}

                }
                num=0;
            }
        });

    }
}
