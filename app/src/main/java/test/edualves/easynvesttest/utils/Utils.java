package test.edualves.easynvesttest.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

import test.edualves.easynvesttest.R;

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

    public static String readJsonFund(Context context) {

        String json;

        try {
            InputStream inputStream = context.getResources().openRawResource(R.raw.fund);
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

    public static String countCharsForSpace(String msg, int wordsSpace) {

        StringBuilder stringBuilder = new StringBuilder(msg);

        int i = 0;
        while ((i = stringBuilder.indexOf(" ", i + wordsSpace)) != -1) {

            stringBuilder.replace(i, i + 1, "\n");
        }

        return stringBuilder.toString();
    }

    public static Integer convertDpToPx(Float dp) {

        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();

        float px = dp * (metrics.densityDpi / 160f);

        return Math.round(px);
    }

}
