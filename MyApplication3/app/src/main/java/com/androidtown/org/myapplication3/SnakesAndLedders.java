package com.androidtown.org.myapplication3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class SnakesAndLedders extends ActionBarActivity {


    View[]  imgBoard = new View[30];

    int[] snakeBlock = new int[3];
    int[] ladderBlock = new int[3];

    int currunt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snakes_and_ledders);

        Toast toast = Toast.makeText(getApplicationContext(),"게임을 시작합니다.", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
/*
        for(int i=0; i<25; i++){
            imgBoard[i] = (View) findViewById(R.id.block1 + i);
        }*/

        imgBoard[0] = (View) findViewById(R.id.block1);
        imgBoard[1] = (View) findViewById(R.id.block2);
        imgBoard[2] = (View) findViewById(R.id.block3);
        imgBoard[3] = (View) findViewById(R.id.block4);
        imgBoard[4] = (View) findViewById(R.id.block5);
        imgBoard[5] = (View) findViewById(R.id.block6);
        imgBoard[6] = (View) findViewById(R.id.block7);
        imgBoard[7] = (View) findViewById(R.id.block8);
        imgBoard[8] = (View) findViewById(R.id.block9);
        imgBoard[9] = (View) findViewById(R.id.block10);
        imgBoard[1] = (View) findViewById(R.id.block11);
        imgBoard[11] = (View) findViewById(R.id.block12);
        imgBoard[12] = (View) findViewById(R.id.block13);
        imgBoard[13] = (View) findViewById(R.id.block14);
        imgBoard[14] = (View) findViewById(R.id.block15);
        imgBoard[15] = (View) findViewById(R.id.block16);
        imgBoard[16] = (View) findViewById(R.id.block17);
        imgBoard[17] = (View) findViewById(R.id.block18);
        imgBoard[18] = (View) findViewById(R.id.block19);
        imgBoard[19] = (View) findViewById(R.id.block20);
        imgBoard[20] = (View) findViewById(R.id.block21);
        imgBoard[21] = (View) findViewById(R.id.block22);
        imgBoard[22] = (View) findViewById(R.id.block23);
        imgBoard[23] = (View) findViewById(R.id.block24);
        imgBoard[24] = (View) findViewById(R.id.block25);

        snakeBlock[0] = 11 ;
        snakeBlock[1] = 14 ;
        snakeBlock[2] = 23 ;

        ladderBlock[0] = 8;
        ladderBlock[1] = 14;
        ladderBlock[2] = 23;

        imgBoard[0].setBackgroundResource(R.drawable.rook7);

    }

    public void onResButtonCliked(View view){
        Toast toast = Toast.makeText(getApplicationContext(),"게임이 초기화 되었습니다.", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

        imgBoard[0] = (View) findViewById(R.id.block1);
        imgBoard[1] = (View) findViewById(R.id.block2);
        imgBoard[2] = (View) findViewById(R.id.block3);
        imgBoard[3] = (View) findViewById(R.id.block4);
        imgBoard[4] = (View) findViewById(R.id.block5);
        imgBoard[5] = (View) findViewById(R.id.block6);
        imgBoard[6] = (View) findViewById(R.id.block7);
        imgBoard[7] = (View) findViewById(R.id.block8);
        imgBoard[8] = (View) findViewById(R.id.block9);
        imgBoard[9] = (View) findViewById(R.id.block10);
        imgBoard[1] = (View) findViewById(R.id.block11);
        imgBoard[11] = (View) findViewById(R.id.block12);
        imgBoard[12] = (View) findViewById(R.id.block13);
        imgBoard[13] = (View) findViewById(R.id.block14);
        imgBoard[14] = (View) findViewById(R.id.block15);
        imgBoard[15] = (View) findViewById(R.id.block16);
        imgBoard[16] = (View) findViewById(R.id.block17);
        imgBoard[17] = (View) findViewById(R.id.block18);
        imgBoard[18] = (View) findViewById(R.id.block19);
        imgBoard[19] = (View) findViewById(R.id.block20);
        imgBoard[20] = (View) findViewById(R.id.block21);
        imgBoard[21] = (View) findViewById(R.id.block22);
        imgBoard[22] = (View) findViewById(R.id.block23);
        imgBoard[23] = (View) findViewById(R.id.block24);
        imgBoard[24] = (View) findViewById(R.id.block25);
    }

    public void onDiceButtonCliked(View view){
        int random = (int) (Math.random() * 10) + 1;
        int mySyte;
        random %= 6;
        if( random == 0 ) random = 6;

        currunt += random;

        Toast toast = Toast.makeText(getApplicationContext(),"당신의 주사위 눈은 " + random + " 입니다.", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

        mySyte = currunt + 1 ;
        Toast toast2 = Toast.makeText(getApplicationContext(),"당신의 위치는 " + mySyte + "번 블록 입니다.", Toast.LENGTH_SHORT);
        toast2.setGravity(Gravity.CENTER, 0, 0);
        toast2.show();

        imgBoard[currunt].setBackgroundResource(R.drawable.rook7);
        imgBoard[currunt - random].setBackgroundResource(0);


        for(int i=0; i<3; i++){
            if(currunt == snakeBlock[i]){
                Toast toast3 = Toast.makeText(getApplicationContext(),"Snake Block을 밟았습니다 ", Toast.LENGTH_SHORT);
                toast3.setGravity(Gravity.CENTER, 0, 0);
                toast3.show();

                imgBoard[currunt].setBackgroundResource(0);
                currunt = actSnakeBlcok(snakeBlock[i]);
                imgBoard[currunt].setBackgroundResource(R.drawable.rook7);

            }
            else if(currunt == ladderBlock[i]){

                Toast toast3 = Toast.makeText(getApplicationContext(),"Ladder Block을 밟았습니다 ", Toast.LENGTH_SHORT);
                toast3.setGravity(Gravity.CENTER, 0, 0);
                toast3.show();

                imgBoard[currunt].setBackgroundResource(0);
                currunt = actLadderBlock(ladderBlock[i]);
                imgBoard[currunt].setBackgroundResource(R.drawable.rook7);

            }
        }

        if(currunt >= 24) gameClear();


    }

    public int actSnakeBlcok(int key){
        if(key == 11) return 2;
        else if(key == 14) return 9;
        else if(key == 23) return 12;
        return 0;
    }
    public int actLadderBlock(int key){
        if(key == 19) return 24;
        else if(key == 10) return 16;
        else if(key == 8) return 13;
        return 0;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_snakes_and_ledders, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void gameClear(){
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Snakes and Ladders").setMessage("게임을 종료합니다.").setPositiveButton("예", new DialogInterface.OnClickListener(){
            @Override
            public void onClick( DialogInterface dialog, int which ){
                finish();
            }
        }).setNegativeButton( "아니요", null ).show();
    }
}


        /*
        imgBoard[0] = (ImageView) findViewById(R.id.block1);
        imgBoard[1] = (ImageView) findViewById(R.id.block2);
        imgBoard[2] = (ImageView) findViewById(R.id.block3);
        imgBoard[3] = (ImageView) findViewById(R.id.block4);
        imgBoard[4] = (ImageView) findViewById(R.id.block5);
        imgBoard[5] = (ImageView) findViewById(R.id.block6);
        imgBoard[6] = (ImageView) findViewById(R.id.block7);
        imgBoard[7] = (ImageView) findViewById(R.id.block8);
        imgBoard[8] = (ImageView) findViewById(R.id.block9);
        imgBoard[9] = (ImageView) findViewById(R.id.block10);
        imgBoard[1] = (ImageView) findViewById(R.id.block11);
        imgBoard[11] = (ImageView) findViewById(R.id.block12);
        imgBoard[12] = (ImageView) findViewById(R.id.block13);
        imgBoard[13] = (ImageView) findViewById(R.id.block14);
        imgBoard[14] = (ImageView) findViewById(R.id.block15);
        imgBoard[15] = (ImageView) findViewById(R.id.block16);
        imgBoard[16] = (ImageView) findViewById(R.id.block17);
        imgBoard[17] = (ImageView) findViewById(R.id.block18);
        imgBoard[18] = (ImageView) findViewById(R.id.block19);
        imgBoard[19] = (ImageView) findViewById(R.id.block20);
        imgBoard[20] = (ImageView) findViewById(R.id.block21);
        imgBoard[21] = (ImageView) findViewById(R.id.block22);
        imgBoard[22] = (ImageView) findViewById(R.id.block23);
        imgBoard[23] = (ImageView) findViewById(R.id.block24);
        imgBoard[24] = (ImageView) findViewById(R.id.block25);*/