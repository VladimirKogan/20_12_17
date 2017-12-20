package com.example.vladimir.a20_12_17;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button next_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next_btn = findViewById(R.id.next_btn);
        next_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.next_btn){
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("NAME", "VladiK");
            intent.putExtra("EMAIL", "yang236nrn@gmail.com");
            //startActivity(intent);

            startActivityForResult(intent, 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == 1){
                Toast.makeText(this, data.getExtras().getString("CALLBACK"), Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(this, "RESULT CANCELED", Toast.LENGTH_LONG).show();}
    }
}
