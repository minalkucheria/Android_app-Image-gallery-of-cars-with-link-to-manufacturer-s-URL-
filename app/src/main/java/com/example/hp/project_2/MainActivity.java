package com.example.hp.project_2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import static android.content.Intent.ACTION_VIEW;

public class MainActivity extends Activity {

    //Identifiers defined for passing in an intent
    protected static final String identifier1="A";
    protected static final String identifier2="B";
    protected static final String identifier3="C";
    GridView gridview;  //Creating object of GridView

    //Integer array consisting of IDs of images stored in resource drawable
    public static int[] ThumbId = {
            R.drawable.audi,R.drawable.bmw,R.drawable.chevrolet,
            R.drawable.honda,R.drawable.hyundai,R.drawable.jaguar,
            R.drawable.lamborghini, R.drawable.maruti_ciaz,R.drawable.mercedes};

    // String array consisting of official Websites of car manufacturers with reference to car images.
    public static String[] manufacturers_website= {"http://www.audi.com/en.html","https://www.bmwusa.com/", "http://www.chevrolet.com",
            "http://www.honda.com/","https://www.hyundaiusa.com/", "https://www.jaguarusa.com/index.html",
    "https://www.lamborghini.com/en-en/","https://www.marutisuzuki.com/", "https://www.mbusa.com/mercedes/index"};

    // String array consisting of car manufacturer's names which will be displayed below every image.
    public static String[] Image_name={ "Audi", "BMW", "CHEVROLET","HONDA","HYUNDAI","JAGUAR", "LAMBORGHINI", "MARUTI", "MERCEDES"};

    @Override
    //Activity Initialization
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);         //Set layout for this activity

        gridview= (GridView)findViewById(R.id.gridview);  //Retrieve the widgets

        gridview.setAdapter(new ImageAdapter(this,Image_name,ThumbId)); //Sets a custom adapter (ImageAdapter) as the source for all items to be displayed in the grid
                                                                        //Image name i.e car manufacturer's name and Image ID is passed



        //Function when an item in grid view is clicked
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                //Create a new intent calling activity to call activity view_image
                Intent i = new Intent(getApplicationContext(),view_image.class);
                // Pass image index
                i.putExtra(identifier1,ThumbId[position]);
                //Pass website associated with image
                i.putExtra(identifier2,manufacturers_website[position]);
                //Starting activity view_image
                startActivity(i);
            }
        });

        //To have same context menu for each item in gridview
        registerForContextMenu(gridview);
    }

        //Called when context menu is being built for a view invokes on long press
        public void onCreateContextMenu(ContextMenu menu, View v,
                ContextMenu.ContextMenuInfo menuInfo) {
            super.onCreateContextMenu(menu, v, menuInfo);
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.context_menu, menu); //Inflate a menu hierarchy from the specified XML resource.
        }

        //Operation when an item is selected from context menu
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        //ID of selected item defines the choice of operation to be done and is specified in switch case
        switch (item.getItemId()) {
            case R.id.item1:
                //New intent to start activity view image
                Intent intent = new Intent(getApplicationContext(),view_image.class);
                // Pass image index
                intent.putExtra(identifier1,ThumbId[info.position]);
                intent.putExtra(identifier2,manufacturers_website[info.position]);
                startActivity(intent);
                return true;
            case R.id.item2:
                //Intent to open official website
                String url= manufacturers_website[info.position];
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                return true;
            case R.id.item3:
                //Call activity Dealer_list which will display the list of 3 dealers of that specific car
                Intent dealer = new Intent(getApplicationContext(),Dealer_list.class);
                // Pass image index
                dealer.putExtra(identifier3,info.position);
                startActivity(dealer);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    }
