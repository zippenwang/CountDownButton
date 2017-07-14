package wzp.demo.countdownbuttondemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import wzp.library.countdownbutton.CountDownButton;

public class MainActivity extends BaseActivity {

    private CountDownButton cdbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cdbtn = (CountDownButton) findViewById(R.id.cdbtn);
        cdbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cdbtn.startCountDown(10);


            }
        });
    }

    public void next(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
