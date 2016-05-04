package johannpolania.com.colombiaturistica3;


import android.content.Intent;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;

import android.support.v4.widget.DrawerLayout;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
DrawerLayout drawerlayout;
    FragmentManager fm;
    private ActionBarDrawerToggle drawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String []tagTitles;

         final ActionBar bar=getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        tagTitles=getResources().getStringArray(R.array.opciones);
        drawerlayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        ListView lista=(ListView)findViewById(R.id.left_drawer);


        final ArrayList<DrawerItem> items=new ArrayList<DrawerItem>();
        items.add(new DrawerItem(tagTitles[0], R.drawable.ic_home_black_36dp));
        items.add(new DrawerItem(tagTitles[1], R.drawable.hotel));
        items.add(new DrawerItem(tagTitles[2], R.drawable.sides));
        items.add(new DrawerItem(tagTitles[3], R.drawable.restaurante));
        items.add(new DrawerItem(tagTitles[4], R.drawable.mapa3));
        lista.setAdapter(new DrawerListAdapter(this, items));

        final android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.indice);
        ab.setDisplayHomeAsUpEnabled(true);

        HomeFragment principal=new HomeFragment();

        fm=getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.content_frame,principal).commit();
                lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                        if (position == 0) {
                            HomeFragment frag = new HomeFragment();
                            fm = getSupportFragmentManager();
                            fm.beginTransaction().replace(R.id.content_frame, frag).commit();

                        }

                        if (position == 1) {
                            HotelesFragment frag = new HotelesFragment();
                            fm = getSupportFragmentManager();
                            fm.beginTransaction().replace(R.id.content_frame, frag).commit();
                            drawerlayout.closeDrawers();


                        }


                        if (position == 2)

                        {
                            SitiosFragment frag = new SitiosFragment();
                            fm = getSupportFragmentManager();
                            fm.beginTransaction().replace(R.id.content_frame, frag).commit();
                            drawerlayout.closeDrawers();

                        }
                        else if(position==3)

                        {    RestauranteFragment frag=new RestauranteFragment();
                            fm=getSupportFragmentManager();
                            fm.beginTransaction().replace(R.id.content_frame,frag).commit();
                            drawerlayout.closeDrawers();





                        }
                        else if(position==4)

                        {    InfoFragment frag=new InfoFragment();
                            fm=getSupportFragmentManager();
                            fm.beginTransaction().replace(R.id.content_frame,frag).commit();
                            drawerlayout.closeDrawers();





                        }


                    }
                });





    }




    public void ubicar(View view)
    {    Double latitud=0.0;
        Double longitud=0.0;
String leyenda="";
        Intent i=new Intent(this,MapsActivity.class);
        if(findViewById(R.id.bRosales)==view)
        {
            latitud=4.6539201;
            longitud=-74.0543962;
           leyenda="Hotel Rosales";
        }
        if(findViewById(R.id.bMercure)==view)
        {

            latitud=-0.204818;
            longitud=-78.495105;
            leyenda="Hotel Mercure Calle 100";
        }

        else if(findViewById(R.id.bTequendama)==view)

        {
                latitud=  4.6130758;
                longitud=-74.0705498;
            leyenda="Hotel Tequendama";

        }
        else if(findViewById(R.id.bAguapanela)==view)

        {


            latitud=  4.689314;
            longitud=-74.069825;
            leyenda="Bar Aguapanelas";


        }
        else if(findViewById(R.id.bAndres)==view)

        {
            latitud=  4.666205;
            longitud=-74.0545175;
            leyenda=" Andres Carne de Res";
        }

        else if(findViewById(R.id.bGaira)==view)

        {

            latitud=   4.6806033;
            longitud=-74.0477375;
            leyenda="Cafe Gaira";

        }


        else if(findViewById(R.id.bCandelaria)==view)

        {

            latitud=  4.5963988;
            longitud=-74.0885437;
            leyenda="Candelaria";
        }

        else if(findViewById(R.id.bMonserrate)==view)

        {

            latitud=   4.6013839;
            longitud=-74.0660022;
            leyenda="Monserrate";
        }
        else if(findViewById(R.id.bSabana)==view)

        {

            latitud=  4.6908375;
            longitud=-74.0376467;
            leyenda="Tren de la Sabana";
        }
        else if(findViewById(R.id.bInfo)==view)

        {

            latitud=  4.6482837;
            longitud=-74.2478938;
            leyenda="Bogota";
        }


        i.putExtra("latitud",latitud);
        i.putExtra("longitud",longitud);
        i.putExtra("etiqueta",leyenda);
  startActivity(i);



    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                if(drawerlayout.isDrawerOpen(GravityCompat.START)){
                    drawerlayout.closeDrawer(GravityCompat.START);
                }else{
                    drawerlayout.openDrawer(GravityCompat.START);
                    //Toast.makeText(this, "aqui", Toast.LENGTH_SHORT).show();
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
