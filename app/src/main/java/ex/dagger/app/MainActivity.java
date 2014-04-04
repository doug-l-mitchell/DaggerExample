package ex.dagger.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import ex.dagger.MyApp;
import ex.dagger.service.TimeService;


public class MainActivity extends ActionBarActivity {

    @Inject TimeService timeService;

    private TextView timeNow;
    private TextView timeTomorrow;
    private Button refreshTime;
    private Button goToNextActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MyApp)getApplication()).getObjectGraph().inject(this);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        timeNow = (TextView)findViewById(R.id.timeNow);
        timeTomorrow = (TextView)findViewById(R.id.timeTomorrow);

        updateTime();

        refreshTime = (Button)findViewById(R.id.refreshTime);
        goToNextActivity = (Button)findViewById(R.id.showNextActivity);

        refreshTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateTime();
            }
        });

        goToNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), MultipleDependencyActivity.class);
                startActivity(i);
            }
        });
    }

    private void updateTime() {
        timeNow.setText(timeService.getNow().toString());
        timeTomorrow.setText(timeService.getThisTimeTomorrow().toString());
    }
}
