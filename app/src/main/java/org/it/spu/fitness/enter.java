package org.it.spu.fitness;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class enter extends AppCompatActivity {

    EditText login;
    EditText password;
    Intent news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);


    }

    protected boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        assert cm != null;
        return cm.getActiveNetworkInfo() != null;
    }

    public void Enter(View view) {
        if (!isOnline()) {
            Toast.makeText(this, "Проверьте подключение к интернету", Toast.LENGTH_LONG).show();
        } else {

            login = findViewById(R.id.login);
            password = findViewById(R.id.password);

            String Slogin = login.getText().toString();
            String Spass = password.getText().toString();

            news = new Intent(this, News.class);
            news.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            news.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(news);
            finish();
        }
    }
}
