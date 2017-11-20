package com.example.hp.project_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
//Activity in which the list of dealers will be displayed
public class Dealer_list extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealer_list);
        Intent i = getIntent(); //Receive intent
        ListView lv = (ListView) findViewById(R.id.ListView);
        int pos = i.getIntExtra(MainActivity.identifier3, 0);//Receive position passed by calling activity
        ArrayList<SearchResults> searchResults = GetSearchResults(pos); //Generate an arraylist which will contain information of dealers returned from function GetSearchResults
        lv.setAdapter(new MyCustomBaseAdapter(this, searchResults));
    }

    //function that will return arraylist of information for a particular manufacturer identified by pos
    private ArrayList<SearchResults> GetSearchResults(int pos) {

        switch (pos) {
            case 0: {
                ArrayList<SearchResults> results = new ArrayList<SearchResults>();
                SearchResults sr0 = new SearchResults();
                sr0.setName("Ron's Auto Sales");
                sr0.setAddress("5727 West Roosevelt Road, Chicago, IL 60608");
                results.add(sr0);

                sr0 = new SearchResults();
                sr0.setName("Champion Motor Sports");
                sr0.setAddress("12717 Cal Sag Rd, Chicago, IL");
                results.add(sr0);

                sr0 = new SearchResults();
                sr0.setName("Chicago Auto Place");
                sr0.setAddress("768 Thomas DR, Chicago,IL");
                results.add(sr0);
                return results;
            }
            case 1: {
                ArrayList<SearchResults> results = new ArrayList<SearchResults>();
                SearchResults sr1 = new SearchResults();
                sr1.setName("John Smith");
                sr1.setAddress("1312 W Lexington, Chicago, IL");
                results.add(sr1);

                sr1 = new SearchResults();
                sr1.setName("Jane Doe");
                sr1.setAddress("398 E 147th ST, Chicago, IL");
                results.add(sr1);

                sr1 = new SearchResults();
                sr1.setName("Premier Auto Haus");
                sr1.setAddress("2401 Warrenville Rd, Chicago, IL");
                results.add(sr1);
                return results;
            }
            case 2: {
                ArrayList<SearchResults> results = new ArrayList<SearchResults>();
                SearchResults sr2 = new SearchResults();
                sr2.setName("Joey Jones");
                sr2.setAddress("542 W Raccine, Chicago, IL");
                results.add(sr2);

                sr2 = new SearchResults();
                sr2.setName("Smith Jones");
                sr2.setAddress("248 W Flournoy St, Chicago, IL");
                results.add(sr2);

                sr2 = new SearchResults();
                sr2.setName("Steve Young");
                sr2.setAddress("1240 Aberdeen St, Chicago, IL");
                results.add(sr2);
                return results;
            }
            case 3: {
                ArrayList<SearchResults> results = new ArrayList<SearchResults>();
                SearchResults sr3 = new SearchResults();
                sr3.setName("Brian Moulson");
                sr3.setAddress("458 Aberdeen St, Chicago, IL");
                results.add(sr3);

                sr3 = new SearchResults();
                sr3.setName("Sarah Motors");
                sr3.setAddress("547 Claremont Ave, Chicago, IL");
                results.add(sr3);

                sr3 = new SearchResults();
                sr3.setName("Steve Blank");
                sr3.setAddress("238 Washington Ave,Chicago ,IL");
                results.add(sr3);
                return results;
            }
            case 4: {
                ArrayList<SearchResults> results = new ArrayList<SearchResults>();
                SearchResults sr4 = new SearchResults();
                sr4.setName("Peter automobiles");
                sr4.setAddress("148 W Polk St, Chicago, IL");
                results.add(sr4);

                sr4 = new SearchResults();
                sr4.setName("Ross Mike");
                sr4.setAddress("352 Washington Ave, Chicago, IL");
                results.add(sr4);

                sr4 = new SearchResults();
                sr4.setName("Mehemat Ali");
                sr4.setAddress("789 Ogden Ave,Chicago, IL");
                results.add(sr4);
                return results;

            }
            case 5: {
                ArrayList<SearchResults> results = new ArrayList<SearchResults>();
                SearchResults sr5 = new SearchResults();
                sr5.setName("Harvey Pearson");
                sr5.setAddress("542 California Ave, Chicago, IL");
                results.add(sr5);

                sr5 = new SearchResults();
                sr5.setName("Peter and Sons Automobiles");
                sr5.setAddress("5874 W Halsted street, Chicago, IL");
                results.add(sr5);

                sr5 = new SearchResults();
                sr5.setName("Steve Young");
                sr5.setAddress("Chicago, IL");
                results.add(sr5);
                return results;
            }
            case 6: {
                ArrayList<SearchResults> results = new ArrayList<SearchResults>();
                SearchResults sr6 = new SearchResults();
                sr6.setName("Michelle Blank");
                sr6.setAddress("1250 W Flournoy St, Chicago, IL");
                results.add(sr6);

                sr6 = new SearchResults();
                sr6.setName("Jane Doe");
                sr6.setAddress("1432 W Taylor St, Chicago, IL");
                results.add(sr6);

                sr6 = new SearchResults();
                sr6.setName("Steve Motors");
                sr6.setAddress("1251 Halsted Street, Chicago, IL");
                results.add(sr6);
                return results;
            }
            case 7: {
                ArrayList<SearchResults> results = new ArrayList<SearchResults>();
                SearchResults sr7 = new SearchResults();
                sr7.setName("John Piotr");
                sr7.setAddress("568 W Roosevelt, Chicago, IL");
                results.add(sr7);

                sr7 = new SearchResults();
                sr7.setName("Jane and Jones Motors");
                sr7.setAddress("1312 Taylor St, Chicago, IL");
                results.add(sr7);

                sr7 = new SearchResults();
                sr7.setName("Suzuki Motors");
                sr7.setAddress("1255 Harrison Street, Chicago, IL");
                results.add(sr7);
                return results;
            }
            case 8: {
                ArrayList<SearchResults> results = new ArrayList<SearchResults>();
                SearchResults sr8 = new SearchResults();
                sr8.setName("Silver Auto");
                sr8.setAddress("198 Industry Avenue, Chicago, IL");
                results.add(sr8);

                sr8 = new SearchResults();
                sr8.setName("Mercedes Benz motors");
                sr8.setAddress("2110 Ogden, Chicago, IL");
                results.add(sr8);

                sr8 = new SearchResults();
                sr8.setName("Bob Moulson");
                sr8.setAddress("1444 Jackson Boulevard, Chicago, IL");
                results.add(sr8);
                return results;
            }
            default: return null

                    ;
        }

    }
}

