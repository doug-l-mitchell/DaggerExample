package ex.dagger.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import ex.dagger.MyApp;
import ex.dagger.service.StringGeneratorService;


public class MultipleDependencyActivity extends ActionBarActivity {

    @Inject StringGeneratorService stringGeneratorService;

    private TextView result;
    private Button newString;
    private Button goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_dependency);
        ((MyApp)getApplication()).getObjectGraph().inject(this);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        result = (TextView)findViewById(R.id.result);
        updateString();

        newString = (Button)findViewById(R.id.newString);
        newString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateString();
            }
        });

        goBack = (Button)findViewById(R.id.goBack);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void updateString(){
        result.setText(stringGeneratorService.generateString());
    }
}
