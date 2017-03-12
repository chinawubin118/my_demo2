package com.lotte.mydemo2.util;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/2/10.
 */

public class LotteUtil {

    public static String loadTextFromAsset(Context context) {
        // load text
        try {
            // get input stream for text
            InputStream is = context.getAssets().open("text.txt");
            // check size
            int size = is.available();
            // create buffer for IO
            byte[] buffer = new byte[size];
            // get data to buffer
            is.read(buffer);
            // close stream
            is.close();
            // set result to TextView
//            mText.setText(new String(buffer));

            return new String(buffer);

        } catch (IOException ex) {
            return "";
        }
    }

    public static Drawable loadImageFromAsset(Context context) {

        // load image
        try {
            // get input stream
            InputStream ims = context.getAssets().open("avatar.jpg");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
//            mImage.setImageDrawable(d);
            return d;
        } catch (IOException ex) {
            return null;
        }
    }
}
