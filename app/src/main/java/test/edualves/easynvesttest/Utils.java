package test.edualves.easynvesttest;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

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

    public enum FieldValidationUtil {
        ;
        private static final Pattern mailValidationPattern = Pattern.compile(
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                        "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        public static boolean isValidEmail(String email) {
            return mailValidationPattern.matcher(email).matches();
        }

    }

}
