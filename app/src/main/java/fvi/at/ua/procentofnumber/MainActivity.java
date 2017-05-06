package fvi.at.ua.procentofnumber;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        final String LOG_MAIN = "log_main";
        private static final String KEY_TOTAL = "totalTextView";

        TextView totalTextView ;
        EditText percentageText;
        EditText numberText;

        float totalSave = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


            final ImageButton clean = (ImageButton) findViewById(R.id.clean);
            clean.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (percentageText.getText().toString().equals("") || numberText.getText().toString().equals("")){
                        Toast.makeText(getApplicationContext(),"Clears entered numbers", Toast.LENGTH_LONG).show();
                    } else {
                       clean();
                    }

                }
            });

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String stateSaved = savedInstanceState.getString(KEY_TOTAL);
        if (stateSaved == ""){
            Log.d(LOG_MAIN,"onRestoreInstanceState equals null");
            Toast.makeText(this,"NO state saved ", Toast.LENGTH_LONG).show();
        }else{
            Log.d(LOG_MAIN,"onRestoreInstanceState setText stateSaved");
            //Toast.makeText(this,"onRestoreInstanceState YES state saved ",Toast.LENGTH_LONG).show();
            totalTextView.setText(stateSaved);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInsSt) {
        super.onSaveInstanceState(savedInsSt);
        String stateToSave = totalTextView.getText().toString();
        savedInsSt.putString(KEY_TOTAL,stateToSave);
        //Toast.makeText(this,"onRestoreInstanceState YES state saved "+stateToSave,Toast.LENGTH_LONG).show();
        Log.d(LOG_MAIN,"onSaveInstanceState total.getText500");
    }

    public float calculate(){
        float percentage = Float.parseFloat(percentageText.getText().toString());
        float dec = percentage / 100;
        float total = dec * Float.parseFloat(numberText.getText().toString());
        totalSave = total;
        Log.d(LOG_MAIN,"calculate()");
        return totalSave;
    }

    public void clean(){
        percentageText.setText(null);
        numberText.setText(null);
        totalTextView.setText(null);
        Log.d(LOG_MAIN,"clean()");
    }


}
