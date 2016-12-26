package info.devexchanges.colorpicker;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import yuku.ambilwarna.AmbilWarnaDialog;

public class MainActivity extends AppCompatActivity {
    private int currentColor;
    private LinearLayout colorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentColor = ContextCompat.getColor(this, R.color.colorAccent);

        Button btnPick = (Button) findViewById(R.id.btn_1);
        colorLayout = (LinearLayout) findViewById(R.id.color_background);
        Button btnPickWithAlpha = (Button) findViewById(R.id.btn_2);
        btnPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(false);
            }
        });

        btnPickWithAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(true);
            }
        });
    }

    private void openDialog(boolean supportsAlpha) {
        AmbilWarnaDialog dialog = new AmbilWarnaDialog(this, currentColor, supportsAlpha, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                currentColor = color;
                colorLayout.setBackgroundColor(color);
            }

            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                Toast.makeText(getApplicationContext(), "Action canceled!", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }
}
