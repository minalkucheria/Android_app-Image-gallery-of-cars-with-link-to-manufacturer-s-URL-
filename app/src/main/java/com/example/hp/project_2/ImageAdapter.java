package com.example.hp.project_2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by HP on 10/1/2017.
 */
//Adapter used to bind data for the main list of photos
public class ImageAdapter extends BaseAdapter {

   //Maintains the state of our data
    private Context mContext;
    String[] result;
    int[] Image_Id;
    public ImageAdapter(Context c, String[] Image_name,int[] ThumbId) {
        mContext = c;
        result=Image_name;
        Image_Id=ThumbId;
    }

    public int getCount() {
        return result.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    /**
     * Returns a view to display the image at a specified position
     *
     * @param position The position to display
     * @param convertView An existing view that we can reuse. May be null.
     * @param parent The parent view that will eventually hold the view we return.
     * @return A view to display the image at a specified position
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.layout, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);

            //Creating low resolution images to be displayed in thumbnails to reduce RAM usage.
            Bitmap bmp = BitmapFactory.decodeResource(mContext.getResources(),Image_Id[position]);
            Bitmap scaled = Bitmap.createScaledBitmap(bmp, 150, 150, true);

            textView.setText(result[position]);
            imageView.setImageBitmap(scaled); //Image is set in thumbnail
            grid.setPadding(5,5,5,5);//defines the padding for all sides
        } else {
            grid = (View) convertView;
        }


        return grid;
    }

}

