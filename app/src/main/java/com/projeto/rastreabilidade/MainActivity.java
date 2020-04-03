package com.projeto.rastreabilidade;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.transition.Fade;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final Activity activity = this;
    TextView edText;

    private final View.OnClickListener btnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String text = edText.getText().toString().trim();
            if (TextUtils.isEmpty(text)){
                edText.setError("Digite um ID");
            } else {
                Intent intentS = new Intent(MainActivity.this, RastreioActivity.class);
                getWindow().setEnterTransition(new Fade());
                intentS.putExtra("idProd", Integer.parseInt(String.valueOf(edText.getText())));
                startActivity(intentS, ActivityOptions.makeSceneTransitionAnimation(activity).toBundle());
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        View button = findViewById(R.id.buttonRastrear);
        edText = findViewById(R.id.editID);

        button.setOnClickListener(btnClickListener);

    }

}
