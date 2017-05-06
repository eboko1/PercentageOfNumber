package fvi.at.ua.procentofnumber;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        private static final String KEY_TOTAL = "totalTextView";
        TextView totalTextView ;
        EditText percentageText;
        EditText numberText;
        float totalSave = 0;

    public float calculate(){
        float percentage = Float.parseFloat(percentageText.getText().toString());
        float dec = percentage / 100;
        float total = dec * Float.parseFloat(numberText.getText().toString());
        totalSave = total;
        return totalSave;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){
            totalSave = savedInstanceState.getFloat(KEY_TOTAL);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        totalTextView = (TextView)findViewById(R.id.totalTextView);
        percentageText = (EditText)findViewById(R.id.percentageText);
        numberText = (EditText)findViewById(R.id.numberText);



            Button calcBtn = (Button) findViewById(R.id.calcBtn);
            calcBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (percentageText.getText().toString().equals("") || numberText.getText().toString().equals("")){
                        Toast.makeText(getApplicationContext(),"Enter the numbers", Toast.LENGTH_LONG).show();
                    } else {
                        calculate();
                        totalTextView.setText(Float.toString(totalSave));
                    }
                }
            });


            ImageButton clean = (ImageButton) findViewById(R.id.clean);
            clean.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (percentageText.getText().toString().equals("") || numberText.getText().toString().equals("")){
                        Toast.makeText(getApplicationContext(),"Clears entered numbers", Toast.LENGTH_LONG).show();
                    } else {
                        percentageText.setText(null);
                        numberText.setText(null);
                        totalTextView.setText(null);
                    }

                }
            });

    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putFloat(KEY_TOTAL,totalSave);
        super.onSaveInstanceState(savedInstanceState);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
