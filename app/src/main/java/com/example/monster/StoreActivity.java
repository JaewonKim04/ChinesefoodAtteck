package com.example.monster;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class StoreActivity extends AppCompatActivity {

    static int attack=1;
    Button Gotomon,plus,reset;
    TextView textView,textView2;

    static int cheack=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        Gotomon=(Button)findViewById(R.id.Gotomon);
        plus=(Button)findViewById(R.id.plus);
        reset=(Button)findViewById(R.id.reset);
        textView=(TextView)findViewById(R.id.textView);
        textView2=(TextView)findViewById(R.id.textView2);
        textView.setText(String.format("현재공격력:%s",attack));
        textView2.setText(String.format("현재코인:%s",MainActivity.coin));


        Button.OnClickListener onClickListener = new Button.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);

                if(cheack==1) {
                    MainActivity.life = MainActivity.liferemem + 10;
                    Toast toast = Toast.makeText(getApplicationContext(), "괴물이 커졌어요!", Toast.LENGTH_SHORT); toast.show();
                    MainActivity.change += 1;
                    cheack = 0;
                }

                startActivity(intent);
                           }
        };
        Gotomon.setOnClickListener(onClickListener);

        Button.OnClickListener onClickListenerplus=new Button.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                if(MainActivity.coin>0)
                {
                    attack+=1;
                    MainActivity.coin--;
                    textView.setText("현재공격력:" + attack);
                    Toast toast = Toast.makeText(getApplicationContext(), "공격력이1 증가했습니다", Toast.LENGTH_SHORT); toast.show();
                    cheack=1;
                }
               else
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "코인이 부족합니다", Toast.LENGTH_SHORT); toast.show();
                }
               textView2.setText("현재코인:" + MainActivity.coin);
            }

        };
        plus.setOnClickListener(onClickListenerplus);

        Button.OnClickListener onClickListenerreset= new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                 attack=1;
                textView.setText("현재공격력:"+ attack);
                Toast toast = Toast.makeText(getApplicationContext(), "모두 리셋시켰어요!", Toast.LENGTH_SHORT); toast.show();
                MainActivity.life=10;
                MainActivity.change=0;
                MainActivity.coin=0;
                textView2.setText("현재코인:" + MainActivity.coin);
            }
        };
        reset.setOnClickListener((onClickListenerreset));
    }
}