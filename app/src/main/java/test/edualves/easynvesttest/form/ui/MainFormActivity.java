package test.edualves.easynvesttest.form.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import test.edualves.easynvesttest.R;
import test.edualves.easynvesttest.model.Cell;
import test.edualves.easynvesttest.model.CellsList;

public class MainFormActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainFormActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_form);


        Log.d(LOG_TAG, "Json: " + readJsonCells());

        convertStringJsonToCellsObject(readJsonCells());

        goToFragment();
    }

    private void convertStringJsonToCellsObject(String json) {

        List<Cell> cells = new ArrayList<>();
        Gson gson = new Gson();

        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("cells");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject exploreObject = jsonArray.getJSONObject(i);
                Log.d(LOG_TAG, "Object " + i + " " + exploreObject.toString());
                cells.add(i, gson.fromJson(exploreObject.toString(), Cell.class));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d(LOG_TAG, "Message " + cells.get(0).getMessage());

    }

    private String readJsonCells() {

        //InputStream inputStream = getResources().openRawResource(R.raw.cells);
        //Reader reader = new BufferedReader(new InputStreamReader(inputStream));
        //Gson gson = new Gson();

        //CellsList cellsList = gson.fromJson(reader, CellsList.class);
        //Log.d(LOG_TAG, "message " + cellsList.getCellList().get(0).getMessage());

        String json = null;

        try {
            InputStream inputStream = getResources().openRawResource(R.raw.cells);
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

    private void goToFragment() {

        MainFormFragment fragment = new MainFormFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();
    }
}
