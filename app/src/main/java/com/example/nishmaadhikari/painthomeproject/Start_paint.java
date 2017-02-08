package com.example.nishmaadhikari.painthomeproject;

/**
 * Created by nishmaadhikari on 2/7/17.
 */

import java.util.List;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.content.Context;
import yuku.ambilwarna.AmbilWarnaDialog;
import yuku.ambilwarna.widget.AmbilWarnaPreference;
import com.example.nishmaadhikari.painthomeproject.Color_Pallete;


public class Start_paint extends Activity {
    private Paint mPaint;
    private View homeView;

    int color = 0xffffff00;
    Button btn;
    TextView text1;

    //  TextView text2 = (TextView) findViewById(R.id.text1);

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.paint_start);

        openDialog(false);

        this.setFinishOnTouchOutside(false);


        // String col1=getActivity().getIntent().getStringExtra("color");
        // TextView text=(TextView) homeView.findViewById(R.id.texthex);
        //  text.setText(col1);

         text1 = (TextView) findViewById(R.id.texthex);


        // btn1.setOnClickListener(new View.OnClickListener() {
        //  @Override
        //  public void onClick(View v) {
        //  openDialog(false);

        //      startActivity(new Intent(getActivity(), Color_Pallete.class));
        //   new ColorPickerDialog(getContext(), mPaint.getColor()).show();

        //   }
        //  });


        Button btn2 = (Button) findViewById(R.id.calculate);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Start_paint.this, Calculated_output.class));
            }
        });


        String[] values2 =
                {"Rough", "Smooth", "Paris"};
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Start_paint.this, android.R.layout.simple_spinner_item, values2);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner3.setAdapter(adapter);


        String[] values1 =
                {"Primer", "Distemper", "Enamel"};
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Start_paint.this, android.R.layout.simple_spinner_item, values1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

    }

    void openDialog(boolean supportsAlpha) {
        AmbilWarnaDialog dialog = new AmbilWarnaDialog(Start_paint.this, color, supportsAlpha, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_SHORT).show();
                Start_paint.this.color = color;
                displayColor();


            }

            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                Toast.makeText(getApplicationContext(), "cancel", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }

    void displayColor() {
        text1.setText(String.format("0x%08x", color));

    }

}




