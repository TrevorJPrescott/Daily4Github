package com.trevorpc.daily4_github;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.trevorpc.daily4_github.clients.OkHttpHelper;

public class MainActivity extends AppCompatActivity {
    private OkHttpHelper okhttpHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        okhttpHelper = new OkHttpHelper();
        okhttpHelper.execute();




    }

    public void ToRepo(View view)
    {
        Intent intent = new Intent(this, repoRV.class);
        startActivity(intent);
    }
}
