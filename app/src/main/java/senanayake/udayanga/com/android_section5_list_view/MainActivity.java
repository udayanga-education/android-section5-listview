package senanayake.udayanga.com.android_section5_list_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myListView = findViewById(R.id.myListView);

        ArrayList<String> myFamily = new ArrayList<>();
        myFamily.add("Mother");
        myFamily.add("Farther");
        myFamily.add("Sister");
        myFamily.add("Brother");
        myFamily.add("Wife");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, myFamily);

        myListView.setAdapter(arrayAdapter);

        myListView.setOnItemClickListener((parent, view, position, id) -> {

            Log.i("Pressed", myFamily.get(position));

            Toast.makeText(getApplicationContext(), "Hello " + myFamily.get(position), Toast.LENGTH_LONG).show();
        });

    }
}