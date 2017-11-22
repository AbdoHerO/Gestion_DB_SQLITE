package com.example.abdohero.gestion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by abdohero on 11/19/17.
 */

class GestionContact extends AppCompatActivity implements View.OnClickListener{
    private EditText idsearch,nom, prenom, age, email, phone;
    private TextView id;
    ArrayList<Contact> Contacts= new ArrayList<>();;
    private ImageView add ,next , back, clear,remove, update, searche;
    private int conteur=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gestion_main);

        idsearch=(EditText)findViewById(R.id.idsearch);
        nom = (EditText) findViewById(R.id.nom);
        prenom = (EditText) findViewById(R.id.prenom);
        age = (EditText) findViewById(R.id.age);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        id  =(TextView) findViewById(R.id.id);

        searche =(ImageView) findViewById(R.id.search);
        add =(ImageView)findViewById(R.id.add);
        remove =(ImageView)findViewById(R.id.remove);
        update =(ImageView)findViewById(R.id.update);
        clear =(ImageView)findViewById(R.id.clear);
        next = (ImageView) findViewById(R.id.next);
        back = (ImageView) findViewById(R.id.back);


        searche.setOnClickListener(this);
        add.setOnClickListener(this);
        remove.setOnClickListener(this);
        update.setOnClickListener(this);
        clear.setOnClickListener(this);
        next.setOnClickListener(this);
        back.setOnClickListener(this);
        id.setText(""+conteur);
    }
    @Override
    public void onClick(View view) {

        if(view.getId()==searche.getId()){afficher();}
        if(view.getId()==add.getId()){ajouterContact();}
        if(view.getId()==remove.getId()){remove();}
        if(view.getId()==update.getId()){update();}
        if(view.getId()==clear.getId()){clear();}
        if(view.getId()==next.getId()){next();}
        if(view.getId()==back.getId()){back();}


    }
    public void clear(){
        nom.setText("");
        prenom.setText("");
        age.setText("");
        email.setText("");
        phone.setText("");
    }
    public void ajouterContact(){
        Contact c = new Contact();
        if(!nom.getText().toString().equals("")&&!prenom.getText().toString().equals("")&&
                !age.getText().toString().equals("")&&!email.getText().toString().equals("")&&
                !phone.getText().toString().equals("")) {

            c.setId(id.getText().toString().trim());//trim() ==> supprimer l'espace
            c.setNom(nom.getText().toString());
            c.setPrenom(prenom.getText().toString());
            c.setAge(Integer.parseInt("" + age.getText().toString().trim()));
            c.setPhone(phone.getText().toString());
            c.setEmail(email.getText().toString());
            Contacts.add(c);
            clear();
            conteur++;
            id.setText("" + conteur);
            Toast.makeText(this, "the contact is added", Toast.LENGTH_LONG).show();

        }
        else {
            Toast.makeText(this, "All fields are obligatory", Toast.LENGTH_LONG).show();
        }



    }
    public void remove() {
        boolean flag = false;
        int position = -1;

        if (idsearch.getText().toString().equals("")) {
            Toast.makeText(this, "the field is empty", Toast.LENGTH_LONG).show();
        } else {
            for (int i = 0; i < Contacts.size(); i++) {
                if (idsearch.getText().toString().equals(Contacts.get(i).getId().toString())) {
                    flag = true;
                    position = i;
                }
            }
            if (flag == false) {
                Toast.makeText(this, "the contact is not found", Toast.LENGTH_LONG).show();
            } else {
                Contacts.remove(position);
                clear();
                Toast.makeText(this, "the contact is deleted", Toast.LENGTH_LONG).show();
            }
        }

    }
    public void afficher(){
        boolean flag = false;
        int position = -1;
        if(idsearch.getText().toString().equals("")){
            Toast.makeText(this, "the field is empty", Toast.LENGTH_LONG).show();
        }
        else {
            for(int i=0;i<Contacts.size();i++){
                //if(Integer.parseInt(""+idsearch.getText().toString())==Contacts.get(i).getId()){
                if(idsearch.getText().toString().equals(Contacts.get(i).getId().toString())){
                    flag = true;
                    position = i;

                }
            }
            if(flag==false){
                Toast.makeText(this, "the contact is not found", Toast.LENGTH_LONG).show();
            }
            else {
                id.setText(Contacts.get(position).getId().toString());
                nom.setText(Contacts.get(position).getNom().toString());
                prenom.setText(Contacts.get(position).getPrenom().toString());
                age.setText(""+Contacts.get(position).getAge());
                email.setText(Contacts.get(position).getEmail().toString());
                phone.setText(Contacts.get(position).getPhone().toString());
                Toast.makeText(this, "the contact is display", Toast.LENGTH_LONG).show();
            }
        }
    }
    public void update(){
        boolean flag = false;
        int position=-1;
        for (int i = 0; i < Contacts.size(); i++) {
            if (id.getText().toString().equals(Contacts.get(i).getId().toString())) {
                flag = true;
                position=i;
            }
        }
        if (flag == false) {
            Toast.makeText(this, "the contact is not found in ArrayList", Toast.LENGTH_LONG).show();
        } else {
            Contact c = new Contact();
            if(!nom.getText().toString().equals("")&&!prenom.getText().toString().equals("")&&
                    !age.getText().toString().equals("")&&!email.getText().toString().equals("")&&
                    !phone.getText().toString().equals("")){
                //c.setId(Integer.parseInt(""+idsearch.getText().toString()));
                c.setId(id.getText().toString());//trim() ==> supprimer l'espace
                c.setNom(nom.getText().toString());
                c.setPrenom(prenom.getText().toString());
                c.setAge(Integer.parseInt(""+age.getText().toString().trim()));
                c.setPhone(phone.getText().toString());
                c.setEmail(email.getText().toString());
                Contacts.set(position,c);
                Toast.makeText(this, "the contact is Edited", Toast.LENGTH_LONG).show();
                clear();
            }
            else {
                Toast.makeText(this, "All fields are obligatory", Toast.LENGTH_LONG).show();
            }
        }

    }
    public void next(){
        int position = -1;
        int count=Integer.parseInt(""+id.getText().toString())-1;
        for(int i=0;i<Contacts.size();i++){
            if(id.getText().toString().equals(Contacts.get(i).getId().toString())){
                position = i;
            }
        }
        if(position<Contacts.size() && position!=-1){
            id.setText(Contacts.get(position+1).getId().toString());
            nom.setText(Contacts.get(position+1).getNom().toString());
            prenom.setText(Contacts.get(position+1).getPrenom().toString());
            age.setText(""+Contacts.get(position+1).getAge());
            email.setText(Contacts.get(position+1).getEmail().toString());
            phone.setText(Contacts.get(position+1).getPhone().toString());
            Toast.makeText(this, "the contact is display", Toast.LENGTH_LONG).show();
        }

    }
    public void back(){
        int position = -1;
        for(int i=0;i<Contacts.size();i++){
            if(id.getText().toString().equals(Contacts.get(i).getId().toString())){
                position = i;
            }
        }
        if(position>0){
            id.setText(Contacts.get(position-1).getId().toString());
            nom.setText(Contacts.get(position-1).getNom().toString());
            prenom.setText(Contacts.get(position-1).getPrenom().toString());
            age.setText(""+Contacts.get(position-1).getAge());
            email.setText(Contacts.get(position-1).getEmail().toString());
            phone.setText(Contacts.get(position-1).getPhone().toString());
            Toast.makeText(this, "the contact is display", Toast.LENGTH_LONG).show();

        }

    }

}
