package com.trevorpc.piglatincoder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String message;
    String essagemay;

    TextView tvEssagemay;
    EditText etMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = "The Quick Snail jump Through the Fence";

        tvEssagemay = findViewById(R.id.tvEssagemay);
        etMessage = findViewById(R.id.etMessage);


    }

    public void Translate(View view) {

        message = etMessage.getText().toString();
        WordConverter converter = new WordConverter(message);
        essagemay = converter.pigLatin();
        Log.d("TAG", "onCreate: " + essagemay);
        tvEssagemay.setText(essagemay);
    }
}
