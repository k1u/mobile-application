package com.jenky.codebuddy.ui.activities;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.jenky.codebuddy.R;
import com.jenky.codebuddy.util.Utilities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class StatsActivity extends AppCompatActivity {
    Toolbar toolbar;
    LineChart chart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivty_stats);
        setViews();
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        chart.setScaleEnabled(true);
        chart.setData(getTestData());
        chart.setDescription("");
        chart.animateX(1000);
        chart.setVisibleXRangeMaximum(10);
        chart.invalidate();
    }

    private void setViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        chart = (LineChart) findViewById(R.id.chart);
    }

    private LineData getData() {
        ArrayList<Entry> valsComp1 = new ArrayList<>();
        Entry c1e1 = new Entry(100.000f, 0);
        valsComp1.add(c1e1);
        Entry c1e2 = new Entry(50.000f, 1);
        valsComp1.add(c1e2);

        LineDataSet setComp1 = new LineDataSet(valsComp1, "Company 1");
        ILineDataSet set;

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(setComp1);

        ArrayList<String> xVals = new ArrayList<String>();
        xVals.add("1.Q"); xVals.add("2.Q"); xVals.add("3.Q"); xVals.add("4.Q");

        LineData data = new LineData(xVals, dataSets);
        return data;
    }

    private LineData getTestData() {
        ArrayList<Entry> valsComp1 = new ArrayList<>();

        ArrayList<Integer> values = new ArrayList<>();
        ArrayList<Calendar> dates = new ArrayList<>();
        ArrayList<String> xVals = new ArrayList<String>();
        for(int i = 0; i < 50; i++){
            Calendar cal = Calendar.getInstance();
            Random rand = new Random();
            Integer value =  rand.nextInt(10) + i;
            cal.add(Calendar.DAY_OF_MONTH, i);
            values.add(value);
            dates.add(cal);
        }
        for(int i = 0; i < values.size(); i++){
            Entry c1e1 = new Entry(values.get(i), i);
            valsComp1.add(c1e1);
        }
        for(int i = 0; i < dates.size(); i++){
            xVals.add(Utilities.ddMMyyyyToString(dates.get(i)));
          }

        LineDataSet setComp1 = new LineDataSet(valsComp1, "Metric 1");
        setComp1.setColor(ContextCompat.getColor(getApplicationContext(), R.color.blue));
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(setComp1);
        LineData data = new LineData(xVals, dataSets);
        return data;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
