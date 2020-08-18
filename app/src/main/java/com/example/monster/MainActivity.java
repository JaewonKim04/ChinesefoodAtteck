package com.example.monster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button gotostore;
    ImageView zza;
    TextView heart,coins;
//버튼,이미지뷰,텍스트뷰 변수를 선언(이름 아무거나 해도 상관없음)

    static int change=0;
    static int life = 10;
    static int coin=0;
    static int liferemem=0;
//전역변수들 선언
    @Override //오버라이드 할수있는(덮어쓸수있는) 매서드인지를 확인
    protected void onCreate(Bundle savedInstanceState)//엑티비티 안의 정보들을 저장시킨다(가로세로 변환할때 사용)
    {
        super.onCreate(savedInstanceState); //super은 MainActivity를 의미(부모클래스), onCreate 매서드에서 저장했던 값들을 집어넣어준다.
        setContentView(R.layout.activity_main);
        gotostore = (Button) findViewById(R.id.gotostore);
        zza = (ImageView)findViewById(R.id.zza);
        heart = (TextView)findViewById(R.id.heart);
        coins=(TextView)findViewById(R.id.coins);
        //findViewById는 텍스트나 이미지를 변경하거나, 버튼의 클릭을 입력받을수있는 메서드를 지원한다.
        coins.setText(String.format("현재코인:%d",coin));
        if(change==0)
        {
            zza.setImageResource(R.drawable.zza);
        }
        else if(change==1)
        {
            zza.setImageResource(R.drawable.jjamb);
        }
        else if(change==2)
        {
            zza.setImageResource(R.drawable.tang);
        }
        else if(change==3)
        {
            zza.setImageResource(R.drawable.shreemp);
        }
        else if(change==4)
        {
            zza.setImageResource(R.drawable.yoo);
        }
        else
        {
            zza.setImageResource(R.drawable.kkan);// 이미지를 지정한다
        }
        heart.setText(life+"");//setText에는 문자열이 꼭 들어가야하므로 꼭 (+"")를 붙여주자
        liferemem=life;
        Button.OnClickListener onClickListener = new Button.OnClickListener() //Button.OnClickListener클래스에있는 메서드를 사용할수있는 객체를 만듦
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StoreActivity.class);//여기에 들어가는 매개변수들은 어디에 어떻게 쓰는거죠..?
                startActivity(intent);

            }
        };
        gotostore.setOnClickListener(onClickListener);//이것도 뭔지 잘 모르겠어요
        ImageView.OnClickListener onClickListenerImg = new ImageView.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(life-StoreActivity.attack>=0)
                {
                    life -= StoreActivity.attack;
                }

                else if(life-StoreActivity.attack<0)
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "괴물을 무찔렀어요!(+1coin)", Toast.LENGTH_SHORT);
                    toast.show();
                    coin++;
                    life=liferemem;
                    coins.setText("현재코인:"+coin);
                }

                heart.setText(life+"");

            }
        };
        zza.setOnClickListener(onClickListenerImg);
    }

}