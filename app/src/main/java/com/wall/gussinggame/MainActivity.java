package com.wall.gussinggame;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button button2;
    private Button button3;
    private Button button5;
    private Button button7;
    private Button pop;
    private TextView textView2;
    private TextView textView3;
    private EditText editText;
    MediaPlayer mysong;
    Dialog mdialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mysong = MediaPlayer.create(MainActivity.this,R.raw.bgmusic);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        editText = findViewById(R.id.editTextNumber);
        pop = findViewById(R.id.button4);
        mdialog = new Dialog(MainActivity.this);
        mdialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.pop));
        mdialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        mdialog.setCancelable(true);




        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.wrong);
        final MediaPlayer mediaPlayer2 = MediaPlayer.create(this,R.raw.correct);
        final MediaPlayer mediaPlayer3 = mediaPlayer.create(this,R.raw.reset);
        final int[] attempt = {0};
        int userGuessNumber = 0;
        int secretNumber = (int) (Math.random() * 99 + 1);


            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    if (s.toString().trim().length() >= 0) {
                        button.setEnabled(true);


                    } else {
                        button.setEnabled(false);

                    }
                }
//
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

        if (editText.length() == 0)
        {
            editText.setError("Enter Number");
        }

        else
        {
        }


        button.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String s = editText.getText().toString();
                int userInput = Integer.parseInt(s);

                do {
                    attempt[0]++;

                        if (userInput== secretNumber)
                        {
                            textView2.setText("OOhhOO!, Your Number is Correct. You Win the Game!");
                            textView3.setText(" Total numbers of attempts : " + attempt[0]);
                            mediaPlayer2.start();
                            button.setEnabled(false);
                            break;
                        }
                        else if (userInput==0)
                        {
                            textView2.setText("your Input Is ZERO\nTry Again");
                            mediaPlayer.start();
                            break;
                        }
                        else if (userInput < secretNumber)
                        {
                            textView2.setText("Your Guess Number is Smaller Than the Secret Number Try Again.");
                            mediaPlayer.start();
                            break;
                        }
                        else if (userInput > secretNumber)
                        {
                            textView2.setText("Your Guess Number is Greater Than the Secret Number Try Again..");
                            mediaPlayer.start();
                            break;
                        }
                        else
                        {
                            textView2.setText("An Error occurred");
                        }
                    } while (userInput != secretNumber);
                }
        });

        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                mdialog.show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(MainActivity.this, "Reset! Done", Toast.LENGTH_SHORT).show();
                mediaPlayer3.start();
                mysong.pause();
                finish();
                startActivity(getIntent());

            }
        });
    }
}

