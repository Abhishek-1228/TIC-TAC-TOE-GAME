package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
     boolean gameActive=true;
    //0-X
    //1-O

    int activePlayer=0;
    int[] gameState={2,2,2,2,2,2,2,2,2};
    int counter=1;
    //state meanings
    //0-X
    //1-O
    //2-NULL
    int[][] winPos={{0,1,2},{3,4,5},{6,7,8},
                     {0,3,6},{1,4,7},{2,5,8},
                      {0,4,8},{2,4,6}};
    public void tap(View view){

        ImageView img=(ImageView)view;
              int tappedImage=Integer.parseInt(img.getTag().toString());
              if(!gameActive)
              {
                  gameReset(view);
              }
              if(counter==9) {
                  for (int value : gameState) {
                      if (value != 2) {
                          gameReset(view);
                      }
                  }
              }
              counter++;
              if(gameState[tappedImage]==2 && gameActive)
              {
                  gameState[tappedImage] = activePlayer;
                  img.setTranslationY(-1000f);
                  if (activePlayer == 0) {
                      img.setImageResource(R.drawable.cross);
                      activePlayer = 1;
                      TextView status=findViewById(R.id.status);
                      status.setText("O's turn tap to play");
                  } else {
                      img.setImageResource(R.drawable.zero);
                      activePlayer = 0;
                      TextView status=findViewById(R.id.status);
                      status.setText("X's turn tap to play");
                  }


                  img.animate().translationYBy(1000f).setDuration(300);
              }
              //check if any player has won
        for (int[] w : winPos)
        {
            if(gameState[w[0]]==gameState[w[1]] && gameState[w[1]]==gameState[w[2]] && gameState[w[0]]!=2)
            {
                String winner;
                gameActive=false;
                if(gameState[w[0]]==0)
                {
                    winner="X has won";
                }
                else
                {
                    winner="O has won";
                }
                TextView status= findViewById(R.id.status);
                status.setText(winner);
            }


        }



    }
    public void gameReset (View view)
    {
        gameActive=true;
        activePlayer=0;
        for(int i=0;i<gameState.length;i++)
        {
            gameState[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        counter=1;



    }


}
