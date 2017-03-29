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
        TextView totalTextView;
        EditText percentageText;
        EditText numberText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        totalTextView = (TextView)findViewById(R.id.totalTextView);
        percentageText = (EditText)findViewById(R.id.percentageText);
        numberText = (EditText)findViewById(R.id.numberText);

            Button calcBtn = (Button) findViewById(R.id.calcBtn);
            calcBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (percentageText.getText().toString().equals("") || numberText.getText().toString().equals("")){
                        Toast.makeText(getApplicationContext(),"Enter the numbers", Toast.LENGTH_LONG).show();
                    } else {
                        float percentage = Float.parseFloat(percentageText.getText().toString());
                        float dec = percentage / 100;
                        float total = dec * Float.parseFloat(numberText.getText().toString());
                        totalTextView.setText(Float.toString(total));
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
