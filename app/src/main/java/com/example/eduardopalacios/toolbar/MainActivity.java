package com.example.eduardopalacios.toolbar;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Adaptador.AdapterListview;
import clases.Item;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    SearchView searchView;
    ListView lista;
    List<Item> items=new ArrayList<Item>();
    AdapterListview adapter;
    Context context=this;
   // String [] elementos={"México","Estados Unidos","Canada","España","Alemania","Colombia","Argentina","Uruguay"};
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista=(ListView)findViewById(R.id.lista);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Contactos");
        toolbar.setTitleTextColor(Color.parseColor("#ffffffff"));
        setSupportActionBar(toolbar);

        items.add(new Item("Pedro","5545678900",R.drawable.contacto));
        items.add(new Item("Mario","5543231234",R.drawable.contacto1));
        items.add(new Item("Luis","5577890987",R.drawable.contacto2));
        items.add(new Item("Guadalupe","5512342312",R.drawable.contacto3));
        items.add(new Item("Rodrigo","55234568887",R.drawable.contacto4));
        items.add(new Item("Pablo","552134567776",R.drawable.contacto5));
        items.add(new Item("Rocio","554312345633",R.drawable.contacto6));
        items.add(new Item("Luisa","5523456789",R.drawable.contacto7));
        items.add(new Item("Saul","5523445677",R.drawable.contacto8));
        items.add(new Item("Victor","5523456789",R.drawable.contacto9));





        adapter=new AdapterListview(this,R.layout.listviewdisenio,items);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(context,items.get(i).getNombre(),Toast.LENGTH_SHORT).show();
            }
        });

        //ArrayAdapter<String> adaptador;
        //adaptador=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        //adaptador.addAll(elementos);
        //lista.setAdapter(adaptador);

        //lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          //  @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            //@Override
            //public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
              //  Toast.makeText(getApplicationContext(),elementos[i],Toast.LENGTH_SHORT).show();
            //}
        //});

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        SearchView(menu);


       // menu.add(Menu.NONE,1,Menu.NONE,"setings");
       // SubMenu subMenu=menu.addSubMenu(Menu.NONE,0,Menu.NONE,"settings");
        //subMenu.add(Menu.NONE,1,Menu.NONE,"opcion1");
        //subMenu.add(Menu.NONE,2,Menu.NONE,"opcion2");
        //subMenu.add(Menu.NONE,3,Menu.NONE,"opcion3");


        //menu.add(Menu.NONE,5,Menu.NONE,"search").setIcon(R.drawable.ic_search_white_24dp).setShowAsAction(1);
        //menu.add(Menu.NONE,4,Menu.NONE,"favoritos").setIcon(R.drawable.ic_favorite_white_24dp).setShowAsAction(1);


        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {



            case R.id.opcion1:
                Toast.makeText(getApplicationContext(),"opcion1",Toast.LENGTH_SHORT).show();
                break;

            case R.id.opcion2:
                Toast.makeText(getApplicationContext(),"opcion2",Toast.LENGTH_SHORT).show();
                break;

            case R.id.opcion3:
                Toast.makeText(getApplicationContext(),"opcion3",Toast.LENGTH_SHORT).show();
                break;



            case R.id.favorito:
                Toast.makeText(getApplicationContext(),"like",Toast.LENGTH_SHORT).show();
                break;

            case R.id.buscar:
                Toast.makeText(getApplicationContext(),"buscar",Toast.LENGTH_SHORT).show();
                break;
                default:

                    break;
        }

        return super.onOptionsItemSelected(item);
    }


    public void SearchView(Menu menu)
    {
        MenuItem searchItem = menu.findItem(R.id.buscar);

        searchView = (SearchView)searchItem.getActionView();
        searchView.setQueryHint("Buscar");


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {


                BuscarItemsSubmit(query);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.length()==0)
                {
                    getAdapter(items);
                }
                else {

                    BuscarItemsonQuery(newText);
                }


                return false;
            }
        });
    }


    public void BuscarItemsSubmit(String buscar)
    {
        String nombre,telefono;
        int imagen;
        List<Item> itemsSubmit=new ArrayList<Item>();
        for (int i=0;i<items.size();i++)
        {
            nombre=items.get(i).getNombre();

            if (buscar.equalsIgnoreCase(nombre))
            {
                telefono=items.get(i).getTelefono();
                imagen=items.get(i).getImagen();
                itemsSubmit.add(new Item(nombre,telefono,imagen));
            }
        }
        getAdapter(itemsSubmit);

    }

    public void BuscarItemsonQuery(String buscar)
    {
        String nombre,telefono;
        String temporal="";
        int imagen;
        List<Item> itemsOnquery=new ArrayList<Item>();
        for (int i=0;i<items.size();i++)
        {
            nombre=items.get(i).getNombre();

            for (int j=0;j<nombre.length();j++)
            {
                temporal+=String.valueOf(nombre.charAt(j));
                if (buscar.equalsIgnoreCase(temporal))
                {
                    telefono=items.get(i).getTelefono();
                    imagen=items.get(i).getImagen();
                    itemsOnquery.add(new Item(nombre,telefono,imagen));
                }
            }
            temporal="";
        }
        //if (itemsOnquery.size()==0)
          //  Toast.makeText(getApplicationContext(),"Nose encontro valor",Toast.LENGTH_SHORT).show();
            getAdapter(itemsOnquery);

    }


    public void getAdapter(List<Item> item)
    {
        adapter=new AdapterListview(context,R.layout.listviewdisenio,item);
        lista.setAdapter(adapter);
    }
}
