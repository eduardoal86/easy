package test.edualves.easynvesttest;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by edualves on 28/05/17.
 */

public class Utils {

    public static String readJsonCells(Context context) {

        String json;

        try {
            InputStream inputStream = context.getResources().openRawResource(R.raw.cells);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return json;
    }
}
