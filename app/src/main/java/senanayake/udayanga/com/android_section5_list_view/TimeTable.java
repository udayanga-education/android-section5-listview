package senanayake.udayanga.com.android_section5_list_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class TimeTable extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        SeekBar seekBar = findViewById(R.id.seekBar);
        listView = findViewById(R.id.listView);

        seekBar.setMax(20);
        seekBar.setProgress(10);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timeTable;
                if (progress < min) {
                    timeTable = min;
                    seekBar.setProgress(min);
                } else {
                    timeTable = progress;
                }
//                Log.i("Seek bar value", Integer.toString(timeTable));
                generateTimesTable(timeTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        generateTimesTable(10);

    }

    public void generateTimesTable(int timesTable) {

        ArrayList<String> timeTableContent = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) {
            timeTableContent.add(Integer.toString(i * timesTable));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, timeTableContent);
        listView.setAdapter(arrayAdapter);
    }
}