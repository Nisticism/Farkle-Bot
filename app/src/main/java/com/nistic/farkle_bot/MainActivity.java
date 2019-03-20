package com.nistic.farkle_bot;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "";

    //  Buttons

    Button randomize;
    Button update;
    Button endTurn;
    Button doneKeep;

    Button keep1;
    Button keep2;
    Button keep3;
    Button keep4;
    Button keep5;
    Button keep6;

    ImageView moreInfo;

    //  Images

    ImageView farklebot;

    //  Lists

    String[] diceNums;
    Integer rolledNums[];
    ArrayList<String> countArray;
    ArrayList<Integer> counterIndices;
    ArrayList<Integer> keeperPossibilities;

    //  Ints

    Integer sampleIndex = 10;
    Integer totalPoints = 0;
    Integer turnCount = 0;
    Integer rollCount = 0;
    Integer subtotal = 0;
    Integer keptTotal = 0;
    Integer keptSubtotal = 0;
    Integer subSubTotal = 0;
    Integer startOvers = 0;

    //  EditTexts

    EditText one;
    EditText two;
    EditText three;
    EditText four;
    EditText five;
    EditText six;

    //  TextView

    TextView suggestion;
    TextView pointsAndTurns;

    //   Booleans

    Boolean diceOneKept = false;
    Boolean diceTwoKept = false;
    Boolean diceThreeKept = false;
    Boolean diceFourKept = false;
    Boolean diceFiveKept = false;
    Boolean diceSixKept = false;
    Boolean newRollHappened;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        rolledNums = new Integer[6];

        randomize = findViewById(R.id.randomize);
        update = findViewById(R.id.updateButtons);
        endTurn = findViewById(R.id.endTurn);
        doneKeep = findViewById(R.id.doneKeep);

        moreInfo = findViewById(R.id.moreInfo);

        keep1 = findViewById(R.id.keep1);
        keep2 = findViewById(R.id.keep2);
        keep3 = findViewById(R.id.keep3);
        keep4 = findViewById(R.id.keep4);
        keep5 = findViewById(R.id.keep5);
        keep6 = findViewById(R.id.keep6);

        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);

        suggestion = findViewById(R.id.suggestion);
        pointsAndTurns = findViewById(R.id.pointsAndTurns);

        farklebot = findViewById(R.id.farklebot);

        diceNums = new String[]{"1","2","3","4","5","6"};

        rolledNums = rolledArray();

        newRollHappened = true;
        one.setText("");
        two.setText("");
        three.setText("");
        four.setText("");
        five.setText("");
        six.setText("");

        moreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), appDescrip.class));
            }
        });

        keep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getButtonBackgroundColor(keep1) == getResources().getColor(R.color.red) && !farkleTurn(rolledArray()) && checkIfValidKeep(keep1)) {
                    keep1.setBackgroundColor(getResources().getColor(R.color.green));
                    keptSubtotal += 1;
                }  else if (keep1.getSolidColor() == getResources().getColor(R.color.red) && farkleTurn(rolledArray())) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Can't keep numbers from Farkle rolls.",
                            Toast.LENGTH_SHORT);

                    toast.show();
                }  else if (getButtonBackgroundColor(keep1) == getResources().getColor(R.color.red) && !farkleTurn(rolledArray()) && !checkIfValidKeep(keep1)) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Cannot keep numbers that are not part of a set, straight, 1, or 5.",
                            Toast.LENGTH_SHORT);

                    toast.show();
                }  else if (getButtonBackgroundColor(keep1) == getResources().getColor(R.color.green) && !diceOneKept) {
                    keep1.setBackgroundColor(getResources().getColor(R.color.red));
                    keptSubtotal -=1;
                }
            }
        });

        keep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getButtonBackgroundColor(keep2) == getResources().getColor(R.color.red) && !farkleTurn(rolledArray()) && checkIfValidKeep(keep2)) {
                    keep2.setBackgroundColor(getResources().getColor(R.color.green));
                    keptSubtotal += 1;
                }  else if (keep2.getSolidColor() == getResources().getColor(R.color.red) && farkleTurn(rolledArray())) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Can't keep numbers from Farkle rolls.",
                            Toast.LENGTH_SHORT);

                    toast.show();
                }  else if (getButtonBackgroundColor(keep2) == getResources().getColor(R.color.red) && !farkleTurn(rolledArray()) && !checkIfValidKeep(keep2)) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Cannot keep numbers that are not part of a set, straight, 1, or 5.",
                            Toast.LENGTH_SHORT);

                    toast.show();
                }  else if (getButtonBackgroundColor(keep2) == getResources().getColor(R.color.green) && !diceTwoKept) {
                    keep2.setBackgroundColor(getResources().getColor(R.color.red));
                    keptSubtotal -=1;
                }
            }
        });

        keep3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getButtonBackgroundColor(keep3) == getResources().getColor(R.color.red) && !farkleTurn(rolledArray()) && checkIfValidKeep(keep3)) {
                    keep3.setBackgroundColor(getResources().getColor(R.color.green));
                    keptSubtotal += 1;
                }  else if (keep3.getSolidColor() == getResources().getColor(R.color.red) && farkleTurn(rolledArray())) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Can't keep numbers from Farkle rolls.",
                            Toast.LENGTH_SHORT);

                    toast.show();
                }  else if (getButtonBackgroundColor(keep3) == getResources().getColor(R.color.red) && !farkleTurn(rolledArray()) && !checkIfValidKeep(keep3)) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Cannot keep numbers that are not part of a set, straight, 1, or 5.",
                            Toast.LENGTH_SHORT);

                    toast.show();
                }  else if (getButtonBackgroundColor(keep3) == getResources().getColor(R.color.green) && !diceThreeKept) {
                    keep3.setBackgroundColor(getResources().getColor(R.color.red));
                    keptSubtotal -=1;
                }
            }
        });

        keep4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getButtonBackgroundColor(keep4) == getResources().getColor(R.color.red) && !farkleTurn(rolledArray()) && checkIfValidKeep(keep4)) {
                    keep4.setBackgroundColor(getResources().getColor(R.color.green));
                    keptSubtotal += 1;
                }  else if (keep4.getSolidColor() == getResources().getColor(R.color.red) && farkleTurn(rolledArray())) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Can't keep numbers from Farkle rolls.",
                            Toast.LENGTH_SHORT);

                    toast.show();
                }  else if (getButtonBackgroundColor(keep4) == getResources().getColor(R.color.red) && !farkleTurn(rolledArray()) && !checkIfValidKeep(keep4)) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Cannot keep numbers that are not part of a set, straight, 1, or 5.",
                            Toast.LENGTH_SHORT);

                    toast.show();
                }  else if (getButtonBackgroundColor(keep4) == getResources().getColor(R.color.green) && !diceFourKept) {
                    keep4.setBackgroundColor(getResources().getColor(R.color.red));
                    keptSubtotal -=1;
                }
            }
        });

        keep5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getButtonBackgroundColor(keep5) == getResources().getColor(R.color.red) && !farkleTurn(rolledArray()) && checkIfValidKeep(keep5)) {
                    keep5.setBackgroundColor(getResources().getColor(R.color.green));
                    keptSubtotal += 1;
                }  else if (keep5.getSolidColor() == getResources().getColor(R.color.red) && farkleTurn(rolledArray())) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Can't keep numbers from Farkle rolls.",
                            Toast.LENGTH_SHORT);

                    toast.show();
                }  else if (getButtonBackgroundColor(keep5) == getResources().getColor(R.color.red) && !farkleTurn(rolledArray()) && !checkIfValidKeep(keep5)) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Cannot keep numbers that are not part of a set, straight, 1, or 5.",
                            Toast.LENGTH_SHORT);

                    toast.show();
                }  else if (getButtonBackgroundColor(keep5) == getResources().getColor(R.color.green) && !diceFiveKept) {
                    keep5.setBackgroundColor(getResources().getColor(R.color.red));
                    keptSubtotal -=1;
                }
            }
        });

        keep6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getButtonBackgroundColor(keep6) == getResources().getColor(R.color.red) && !farkleTurn(rolledArray()) && checkIfValidKeep(keep6)) {
                    keep6.setBackgroundColor(getResources().getColor(R.color.green));
                    keptSubtotal += 1;
                }  else if (keep6.getSolidColor() == getResources().getColor(R.color.red) && farkleTurn(rolledArray())) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Can't keep numbers from Farkle rolls.",
                            Toast.LENGTH_SHORT);

                    toast.show();
                }  else if (getButtonBackgroundColor(keep6) == getResources().getColor(R.color.red) && !farkleTurn(rolledArray()) && !checkIfValidKeep(keep6)) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Cannot keep numbers that are not part of a set, straight, 1, or 5.",
                            Toast.LENGTH_SHORT);

                    toast.show();
                }  else if (getButtonBackgroundColor(keep6) == getResources().getColor(R.color.green) && !diceSixKept) {
                    keep6.setBackgroundColor(getResources().getColor(R.color.red));
                    keptSubtotal -=1;
                }
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!updateReady()) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Must enter at least one number to update.",
                            Toast.LENGTH_SHORT);

                    toast.show();
                }
                if (rollOrUpdateReady() && updateReady()) {
                    updateTurnsPointsText();
                    updateButtons();
                    suggestion.setText("Click me to get my advice!");
                    doneKeep.setBackgroundColor(getResources().getColor(R.color.lightGray));
                    rolledNums = rolledArray();
                    if (farkleTurn(rolledNums)) {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Wow looks like you farkled!  Not very good at the game.",
                                Toast.LENGTH_SHORT);

                        toast.show();
                        subtotal = 0;
                        endTurn.performClick();
                    }
                }
                if (!rollOrUpdateReady()) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Must press the 'Finished Selection' button before updating.",
                            Toast.LENGTH_SHORT);

                    toast.show();
                }
            }
        });

        farklebot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                suggestion.setText(makeSuggestion());
            }
        });

        randomize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rollOrUpdateReady()) {
                    updateTurnsPointsText();
                    roll();
                    suggestion.setText("Click me to get my advice!");
                    doneKeep.setBackgroundColor(getResources().getColor(R.color.lightGray));
                    newRollHappened = false;
                    if (farkleTurn(rolledArray())) {
                        suggestion.setText("Wow looks like it's a farkle!  Not very good at the game.");
                        subtotal = 0;
                        endTurn.performClick();
                    }
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Must keep at least one number before rolling (make sure to press 'Finish Selection')",
                            Toast.LENGTH_SHORT);

                    toast.show();
                }
            }
        });

        endTurn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //  We need to avoid the double farkle problem by not allowing "end turn" without finished selection, or delegate farkles to update and roll only.
                addPoints();
                totalPoints += subtotal;
                subtotal = 0;
                doneKeep.setBackgroundColor(getResources().getColor(R.color.lightGray));
                resetAllButtons();
                rolledNums = rolledArray();
                turnCount += 1;
                rollCount = 0;
                updateTurnsPointsText();
                newRollHappened = false;
            }
        });

        pointsAndTurns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPoints();
                updateTurnsPointsText();
            }
        });

        doneKeep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedOne()) {

                    //  Just need to make sure the kept array is valid.  For instance if you have 6 sixes should not be able to keep only 2 of them.
                    Boolean validKeeps = true;
                    for (int i = 0; i < getCurrentNums().length; i++) {
                        if (!checkIfValidKeepKept(getCorrectButton(i + 1))
                                && getButtonBackgroundColor(getCorrectButton(i + 1)) == getResources().getColor(R.color.green)
                                && !getCorrectBoolean(i + 1)) {
                            validKeeps = false;
                        }
                    }


                    if (validKeeps) {
                        addPoints();
                        updateTurnsPointsText();
                        doneKeep.setBackgroundColor(getResources().getColor(R.color.green));
                    }  else if (!validKeeps) {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Must select only dice that can increase your score.",
                                Toast.LENGTH_SHORT);

                        toast.show();
                    }
                } else if (!selectedOne()) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Must select at least one new number before clicking this.",
                            Toast.LENGTH_SHORT);

                    toast.show();
                }
                if (ifAllKept() == true) {
                    resetAllButtons();
                    startOvers += 1;
                }
            }
        });

    }

    public Boolean updateReady() {
        Boolean updateRead = false;
        if (!(one.getText().toString().equals("") && two.getText().toString().equals("") && three.getText().toString().equals("") && four.getText().toString().equals("") && five.getText().toString().equals("") && six.getText().toString().equals(""))) {
            updateRead = true;
        }
        String test = one.getText().toString();
        Log.d(TAG, test);
        return updateRead;
    }

    public int getButtonBackgroundColor(Button b) {
        ColorDrawable cd = (ColorDrawable) b.getBackground();
        return cd.getColor();
    }

    public void addPoints() {

        // this is to avoid farkle crashes
        if (keptArray().length > 0) {
            if (checkIfStraight(keptArray())) {
                subtotal += 1500;
            }
            if (checkSameNumberCount(keptArray()) == 3) {
                if (keptArray()[getSampleIndex(keptArray())] == 1) {
                    subtotal += 300;
                } else if (keptArray()[getSampleIndex(keptArray())] != 1) {
                    subtotal += keptArray()[getSampleIndex(keptArray())] * 100;
                }
            }
            if (checkSameNumberCount(keptArray()) == 4) {
                subtotal += 1000;
            }
            if (checkSameNumberCount(keptArray()) == 5) {
                subtotal += 2000;
            }
            if (checkSameNumberCount(keptArray()) == 6) {
                subtotal += 3000;
            }

            //  Three pair or two triplets
            if (checkSameNumberCount(keptArray()) == 9 || checkSameNumberCount(keptArray()) == 10) {
                subtotal += 1500;
            }
            if (checkSameNumberCount(keptArray()) == 12) {
                subtotal += 1500;
            }

            if (!checkIfStraight(keptArray())) {
                if (checkSameNumberCount(keptArray()) < 3 || keptArray()[getSampleIndex(keptArray())] != 1) {
                    subtotal += totalOnes(keptArray()) * 100;
                }
                if (checkSameNumberCount(keptArray()) < 3 || keptArray()[getSampleIndex(keptArray())] != 5) {
                    subtotal += totalFives(keptArray()) * 50;
                }
            }
            toggleKeptBools();
        }
    }

    public Integer pointsOfRoll(Integer[] redUnkeptArray) {
        Integer points = 0;
        // this is to avoid farkle crashes
        if (redUnkeptArray.length > 0) {
            if (checkIfStraight(redUnkeptArray)) {
                points += 1500;
            }
            if (checkSameNumberCount(redUnkeptArray) == 3) {
                if (redUnkeptArray[getSampleIndex(redUnkeptArray)] == 1) {
                    points += 300;
                } else if (redUnkeptArray[getSampleIndex(redUnkeptArray)] != 1) {
                    points += redUnkeptArray[getSampleIndex(redUnkeptArray)] * 100;
                }
            }
            if (checkSameNumberCount(redUnkeptArray) == 4) {
                points += 1000;
            }
            if (checkSameNumberCount(redUnkeptArray) == 5) {
                points += 2000;
            }
            if (checkSameNumberCount(redUnkeptArray) == 6) {
                points += 3000;
            }

            //  Three pair or two triplets
            if (checkSameNumberCount(redUnkeptArray) == 9 || checkSameNumberCount(keptArray()) == 10) {
                points += 1500;
            }
            if (checkSameNumberCount(redUnkeptArray) == 12) {
                points += 1500;
            }

            if (!checkIfStraight(redUnkeptArray)) {
                if (checkSameNumberCount(redUnkeptArray) < 3 || redUnkeptArray[getSampleIndex(redUnkeptArray)] != 1) {
                    points += totalOnes(redUnkeptArray) * 100;
                }
                if (checkSameNumberCount(redUnkeptArray) < 3 || redUnkeptArray[getSampleIndex(redUnkeptArray)] != 5) {
                    points += totalFives(redUnkeptArray) * 50;
                }
            }
        }
        else if (redUnkeptArray.length == 0) {
            return 0;
        }
        return points;
    }

    public Boolean selectedOne() {
        Boolean oneSelectedAtLeast = false;
        if ((getButtonBackgroundColor(keep1) == getResources().getColor(R.color.green) && diceOneKept == false)
                || (getButtonBackgroundColor(keep2) == getResources().getColor(R.color.green)  && diceTwoKept == false)
                || (getButtonBackgroundColor(keep3) == getResources().getColor(R.color.green)  && diceThreeKept == false)
                || (getButtonBackgroundColor(keep4) == getResources().getColor(R.color.green)  && diceFourKept == false)
                || (getButtonBackgroundColor(keep5) == getResources().getColor(R.color.green)  && diceFiveKept == false)
                || (getButtonBackgroundColor(keep6) == getResources().getColor(R.color.green)  && diceSixKept == false)) {
            oneSelectedAtLeast = true;
        }
        return  oneSelectedAtLeast;
    }

    public void resetAllButtons() {
        keep1.setBackgroundColor(getResources().getColor(R.color.red));
        keep2.setBackgroundColor(getResources().getColor(R.color.red));
        keep3.setBackgroundColor(getResources().getColor(R.color.red));
        keep4.setBackgroundColor(getResources().getColor(R.color.red));
        keep5.setBackgroundColor(getResources().getColor(R.color.red));
        keep6.setBackgroundColor(getResources().getColor(R.color.red));

        diceOneKept = false;
        diceTwoKept = false;
        diceThreeKept = false;
        diceFourKept = false;
        diceFiveKept = false;
        diceSixKept = false;
    }

    public Boolean ifAllKept() {
        Boolean allKept = false;
        if (getButtonBackgroundColor(keep1) == getResources().getColor(R.color.green) && diceOneKept == true
            && getButtonBackgroundColor(keep2) == getResources().getColor(R.color.green)  && diceTwoKept == true
            && getButtonBackgroundColor(keep3) == getResources().getColor(R.color.green)  && diceThreeKept == true
            && getButtonBackgroundColor(keep4) == getResources().getColor(R.color.green)  && diceFourKept == true
            && getButtonBackgroundColor(keep5) == getResources().getColor(R.color.green)  && diceFiveKept == true
            && getButtonBackgroundColor(keep6) == getResources().getColor(R.color.green)  && diceSixKept == true) {
            allKept = true;
        }
        return allKept;
    }

    public Boolean rollOrUpdateReady() {
        Boolean rollAndUpdateReady = false;
        if (((getButtonBackgroundColor(keep1) == getResources().getColor(R.color.green) && diceOneKept == true) || getButtonBackgroundColor(keep1) == getResources().getColor(R.color.red))
                && ((getButtonBackgroundColor(keep2) == getResources().getColor(R.color.green)  && diceTwoKept == true) || getButtonBackgroundColor(keep2) == getResources().getColor(R.color.red))
                && ((getButtonBackgroundColor(keep3) == getResources().getColor(R.color.green)  && diceThreeKept == true) || getButtonBackgroundColor(keep3) == getResources().getColor(R.color.red))
                && ((getButtonBackgroundColor(keep4) == getResources().getColor(R.color.green)  && diceFourKept == true) || getButtonBackgroundColor(keep4) == getResources().getColor(R.color.red))
                && ((getButtonBackgroundColor(keep5) == getResources().getColor(R.color.green)  && diceFiveKept == true) || getButtonBackgroundColor(keep5) == getResources().getColor(R.color.red))
                && ((getButtonBackgroundColor(keep6) == getResources().getColor(R.color.green)  && diceSixKept == true) || getButtonBackgroundColor(keep6) == getResources().getColor(R.color.red))) {
            rollAndUpdateReady = true;
        }
        return rollAndUpdateReady;
    }

    public Integer[] getCurrentNums() {
        Integer[] currentNums = new Integer[6];
        currentNums[0] = Integer.parseInt(keep1.getText().toString());
        currentNums[1] = Integer.parseInt(keep2.getText().toString());
        currentNums[2] = Integer.parseInt(keep3.getText().toString());
        currentNums[3] = Integer.parseInt(keep4.getText().toString());
        currentNums[4] = Integer.parseInt(keep5.getText().toString());
        currentNums[5] = Integer.parseInt(keep6.getText().toString());
        return currentNums;
    }

    public Integer[] rolledArray() {
        ArrayList<Integer> redButtons = new ArrayList();
            if (diceOneKept == false) {
                redButtons.add(Integer.parseInt(keep1.getText().toString()));
            }
            if (diceTwoKept == false) {
                redButtons.add(Integer.parseInt(keep2.getText().toString()));
            }
            if (diceThreeKept == false) {
                redButtons.add(Integer.parseInt(keep3.getText().toString()));
            }
            if (diceFourKept == false) {
                redButtons.add(Integer.parseInt(keep4.getText().toString()));
            }
            if (diceFiveKept == false) {
                redButtons.add(Integer.parseInt(keep5.getText().toString()));
            }
            if (diceSixKept == false) {
                redButtons.add(Integer.parseInt(keep6.getText().toString()));
            }
        Integer[] newArray = redButtons.toArray(new Integer[redButtons.size()]);
        return newArray;
    }

    public Integer[] keptArray() {
        ArrayList<Integer> greenButtons = new ArrayList();
        if (getButtonBackgroundColor(keep1) == getResources().getColor(R.color.green) && diceOneKept == false) {
            greenButtons.add(Integer.parseInt(keep1.getText().toString()));
        }
        if (getButtonBackgroundColor(keep2) == getResources().getColor(R.color.green)  && diceTwoKept == false) {
            greenButtons.add(Integer.parseInt(keep2.getText().toString()));
        }
        if (getButtonBackgroundColor(keep3) == getResources().getColor(R.color.green)  && diceThreeKept == false) {
            greenButtons.add(Integer.parseInt(keep3.getText().toString()));
        }
        if (getButtonBackgroundColor(keep4) == getResources().getColor(R.color.green)  && diceFourKept == false) {
            greenButtons.add(Integer.parseInt(keep4.getText().toString()));
        }
        if (getButtonBackgroundColor(keep5) == getResources().getColor(R.color.green)  && diceFiveKept == false) {
            greenButtons.add(Integer.parseInt(keep5.getText().toString()));
        }
        if (getButtonBackgroundColor(keep6) == getResources().getColor(R.color.green)  && diceSixKept == false) {
            greenButtons.add(Integer.parseInt(keep6.getText().toString()));
        }
        Integer[] newArray = greenButtons.toArray(new Integer[greenButtons.size()]);
        return newArray;
    }

    public void toggleKeptBools() {
        if (getButtonBackgroundColor(keep1) == getResources().getColor(R.color.green)  && diceOneKept == false) {
            diceOneKept = true;
        }
        if (getButtonBackgroundColor(keep2) == getResources().getColor(R.color.green)  && diceTwoKept == false) {
            diceTwoKept = true;
        }
        if (getButtonBackgroundColor(keep3) == getResources().getColor(R.color.green)  && diceThreeKept == false) {
            diceThreeKept = true;
        }
        if (getButtonBackgroundColor(keep4) == getResources().getColor(R.color.green)  && diceFourKept == false) {
            diceFourKept = true;
        }
        if (getButtonBackgroundColor(keep5) == getResources().getColor(R.color.green)  && diceFiveKept == false) {
            diceFiveKept = true;
        }
        if (getButtonBackgroundColor(keep6) == getResources().getColor(R.color.green)  && diceSixKept == false) {
            diceSixKept = true;
        }
    }

    public Integer getUnkeptCount() {
        Integer unkept = 6;
        if (getButtonBackgroundColor(keep1) == getResources().getColor(R.color.green)) {
            unkept -= 1;
        }
        if (getButtonBackgroundColor(keep2) == getResources().getColor(R.color.green)) {
            unkept -= 1;
        }
        if (getButtonBackgroundColor(keep3) == getResources().getColor(R.color.green)) {
            unkept -= 1;
        }
        if (getButtonBackgroundColor(keep4) == getResources().getColor(R.color.green)) {
            unkept -= 1;
        }
        if (getButtonBackgroundColor(keep5) == getResources().getColor(R.color.green)) {
            unkept -= 1;
        }
        if (getButtonBackgroundColor(keep6) == getResources().getColor(R.color.green)) {
            unkept -= 1;
        }
        return unkept;
    }

    public void roll() {
        newRollHappened = false;
        Random r = new Random();
        if (getButtonBackgroundColor(keep1) == getResources().getColor(R.color.red)) {
            Integer random = r.nextInt(6) + 1;
            keep1.setText(random.toString());
            newRollHappened = true;
        }
        if (getButtonBackgroundColor(keep2) == getResources().getColor(R.color.red)) {
            Integer random = r.nextInt(6) + 1;
            keep2.setText(random.toString());
            newRollHappened = true;
        }
        if (getButtonBackgroundColor(keep3) == getResources().getColor(R.color.red)) {
            Integer random = r.nextInt(6) + 1;
            keep3.setText(random.toString());
            newRollHappened = true;
        }
        if (getButtonBackgroundColor(keep4) == getResources().getColor(R.color.red)) {
            Integer random = r.nextInt(6) + 1;
            keep4.setText(random.toString());
            newRollHappened = true;
        }
        if (getButtonBackgroundColor(keep5) == getResources().getColor(R.color.red)) {
            Integer random = r.nextInt(6) + 1;
            keep5.setText(random.toString());
            newRollHappened = true;
        }
        if (getButtonBackgroundColor(keep6) == getResources().getColor(R.color.red)) {
            Integer random = r.nextInt(6) + 1;
            keep6.setText(random.toString());
            newRollHappened = true;
        }
        if (newRollHappened) {
            rollCount += 1;
            updateTurnsPointsText();
        }
        if (!newRollHappened) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Must click 'Finished Selection' if all numbers are kept.",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public boolean farkleTurn(Integer[] farkleMaybe) {
        Boolean farkle = true;

        for (int i = 0; i < farkleMaybe.length; i++) {
            if (farkleMaybe[i] == 1 || farkleMaybe[i] == 5) {
                farkle = false;
            }
        }

        if (checkSameNumberCount(farkleMaybe) > 2) {
            farkle = false;
        }

        return  farkle;
    }


    //  This must be on point !
    public boolean partOfCombo(Button b, Integer[] newUnkept) {
        Boolean isPartOfCombo = false;
        Integer buttonValue = Integer.parseInt(b.getText().toString());
        if (checkSameNumberCount(newUnkept) == 3 ||
                checkSameNumberCount(newUnkept) == 4 ||
                checkSameNumberCount(newUnkept) == 5 ||
                checkSameNumberCount(newUnkept) == 6 ||
                checkSameNumberCount(newUnkept) == 9 ||
                checkSameNumberCount(newUnkept) == 10 ||
                checkSameNumberCount(newUnkept) == 12) {

            Integer oneCount = 0;
            Integer twoCount = 0;
            Integer threeCount = 0;
            Integer fourCount = 0;
            Integer fiveCount = 0;
            Integer sixCount = 0;

            for(int i = 0; i < newUnkept.length; i++){
                if (newUnkept[i] == 1) {
                    oneCount += 1;
                    if (oneCount > 2) {
                        //   if there is a combo to be found, and if the button's value is the same as the combo, that button must be part of it?
                        if (buttonValue == 1) {
                            isPartOfCombo = true;
                        }
                    }
                }
            }
            for(int i = 0; i < newUnkept.length; i++){
                if (newUnkept[i] == 2) {
                    twoCount += 1;
                    if (twoCount > 2) {
                        if (buttonValue == 2) {
                            isPartOfCombo = true;
                        }
                    }
                }
            }
            for(int i = 0; i < newUnkept.length; i++){
                if (newUnkept[i] == 3) {
                    threeCount += 1;
                    if (threeCount > 2) {
                        if (buttonValue == 3) {
                            isPartOfCombo = true;
                        }
                    }
                }
            }
            for(int i = 0; i < newUnkept.length; i++){
                if (newUnkept[i] == 4) {
                    fourCount += 1;
                    if (fourCount > 2) {
                        if (buttonValue == 4) {
                            isPartOfCombo = true;
                        }
                    }
                }
            }
            for(int i = 0; i < newUnkept.length; i++){
                if (newUnkept[i] == 5) {
                    fiveCount += 1;
                    if (fiveCount > 2) {
                        if (buttonValue == 5) {
                            isPartOfCombo = true;
                        }
                    }
                }
            }
            for(int i = 0; i < newUnkept.length; i++){
                if (newUnkept[i] == 6) {
                    sixCount += 1;
                    if (sixCount > 2) {
                        if (buttonValue == 6) {
                            isPartOfCombo = true;
                        }
                    }
                }
            }

            if (checkSameNumberCount(newUnkept) == 9 || checkSameNumberCount(newUnkept) == 10 || checkSameNumberCount(newUnkept) == 12) {
                isPartOfCombo = true;
            }
        }

        if (checkIfStraight(newUnkept)) {
            isPartOfCombo = true;
        }
        return isPartOfCombo;
    }

    public Boolean checkIf1Or5(Button b) {
        Boolean oneOrFive = false;
        Integer whichButton = Integer.parseInt(b.getHint().toString());
        if ((Integer.parseInt(b.getText().toString()) == 1 || Integer.parseInt(b.getText().toString()) == 5)
                && getButtonBackgroundColor(getCorrectButton(whichButton)) == getResources().getColor(R.color.red)) {
            oneOrFive = true;
        }
        return oneOrFive;
    }

    public Boolean checkIf1Or5inKept(Button b) {
        Boolean oneOrFive = false;
        Integer whichButton = Integer.parseInt(b.getHint().toString());
        if ((Integer.parseInt(b.getText().toString()) == 1 || Integer.parseInt(b.getText().toString()) == 5)
                && getButtonBackgroundColor(getCorrectButton(whichButton)) == getResources().getColor(R.color.green)
                && getCorrectBoolean(whichButton) == false) {
            oneOrFive = true;
        }
        return oneOrFive;
    }


    public Boolean checkIfValidKeep(Button b) {
        Boolean isValidKeep = false;
        if (partOfCombo(b, rolledArray()) || checkIf1Or5(b)) {
            isValidKeep = true;
        }
        return isValidKeep;
    }

    public Boolean checkIfValidKeepKept(Button b) {
        Boolean isValidKeep = false;
        if (partOfCombo(b, keptArray()) || checkIf1Or5inKept(b)) {
            isValidKeep = true;
        }
        return isValidKeep;
    }

    public Button getCorrectButton(Integer b) {
        if (b == 1) {
            return keep1;
        }
        if (b == 2) {
            return keep2;
        }
        if (b == 3) {
            return keep3;
        }
        if (b == 4) {
            return keep4;
        }
        if (b == 5) {
            return keep5;
        }
        if (b == 6) {
            return keep6;
        }
        else {
            return keep1;
        }
    }

    public Boolean getCorrectBoolean (Integer b) {
        if (b == 1) {
            return diceOneKept;
        }
        if (b == 2) {
            return diceTwoKept;
        }
        if (b == 3) {
            return diceThreeKept;
        }
        if (b == 4) {
            return diceFourKept;
        }
        if (b == 5) {
            return diceFiveKept;
        }
        if (b == 6) {
            return diceSixKept;
        }
        else {
            return diceOneKept;
        }
    }

    public String makeSuggestion() {
        String suggestion = "";

        if (farkleTurn(rolledArray()) == false) {
            if (!youGetToRollAgain()) {
                if (rolledArray().length == 6) {
                    if (checkSameNumberCount(rolledArray()) == 5) {
                        suggestion += "I think you should keep the 5 of a kind and stop rolling. Nice!";
                    } else if (checkSameNumberCount(rolledArray()) == 4 && totalKeepableNumbers(rolledArray()) == 4) {
                        suggestion += "I think you should keep the 4 of a kind and stop rolling.  Nice!";
                    } else if (checkSameNumberCount(rolledArray()) == 4 && totalKeepableNumbers(rolledArray()) == 5) {
                        suggestion += "I think you should keep the 4 of a kind and 1 or 5 and stop rolling.  Nice!";
                    }
                    else if (checkSameNumberCount(rolledArray()) == 3) {
                        if (totalPoints == 0) {
                                if (Integer.parseInt(getCorrectButton(getSampleIndex(getCurrentNums())+1).getText().toString()) == 6) {
                                    if (totalOnes(rolledArray()) == 0 && totalFives(rolledArray()) == 0) {
                                        suggestion += "I think you should keep the 3 of a kind and stop rolling.  You're on the board.  Nice!";
                                    }
                                    else if (totalOnes(rolledArray()) > 0 && totalFives(rolledArray()) == 0) {
                                        suggestion += "I think you should keep the 3 of a kind and the 1(s) and stop rolling.  You're on the board.  Nice!";
                                    }
                                    else if (totalOnes(rolledArray()) == 0 && totalFives(rolledArray()) > 0) {
                                        suggestion += "I think you should keep the 3 of a kind and the 5(s) and stop rolling.  You're on the board.  Nice!";
                                    }
                                    else if (totalOnes(rolledArray()) > 0 && totalFives(rolledArray()) > 0) {
                                        suggestion += "I think you should keep the 3 of a kind, the 1, and the 5, and stop rolling.  You're on the board.  Nice!";
                                    }
                                }
                                else if (Integer.parseInt(getCorrectButton(getSampleIndex(getCurrentNums())+1).getText().toString()) == 5) {
                                    if (totalOnes(rolledArray()) == 0) {
                                        suggestion += "I think you should keep the 3 of a kind and stop rolling.  You're on the board.  Nice!";
                                    }
                                    else if (totalOnes(rolledArray()) > 0) {
                                        suggestion += "I think you should keep the 3 of a kind and the 1(s) and stop rolling.  You're on the board.  Nice!";
                                    }
                                    else if (totalOnes(rolledArray()) > 0 && totalFives(rolledArray()) > 0) {
                                        suggestion += "I think you should keep the 3 of a kind, the 1, and the 5, and stop rolling.  You're on the board.  Nice!";
                                    }
                                }
                                if (Integer.parseInt(getCorrectButton(getSampleIndex(getCurrentNums())+1).getText().toString()) < 5) {
                                    if (pointsOfRoll(rolledArray()) >= 500) {
                                        suggestion += "I think you should keep the 3 of a kind and all of the 1s and 5s and stop rolling.";
                                    }
                                    else if (pointsOfRoll(rolledArray()) < 500 && Integer.parseInt(getCorrectButton(getSampleIndex(getCurrentNums())+1).getText().toString()) != 2) {
                                        suggestion += "I think you should keep the 3 of a kind and all of the 1s and 5s and roll again.  Need to get on the board!";
                                    }
                                    else if (pointsOfRoll(rolledArray()) < 500 && Integer.parseInt(getCorrectButton(getSampleIndex(getCurrentNums())+1).getText().toString()) == 2) {
                                        if (totalOnes(getCurrentNums()) > 0 && totalFives(getCurrentNums()) >= 0) {
                                            suggestion += "I think you should keep a single 1 and roll again.";
                                        }
                                        else if (totalOnes(getCurrentNums()) == 0 && totalFives(getCurrentNums()) > 0) {
                                            suggestion += "I think you should keep a single 5 and roll again.";
                                        }
                                        else if (totalOnes(getCurrentNums()) == 0 && totalFives(getCurrentNums()) == 0) {
                                            suggestion += "I think you should keep the 2s and roll again.  Terrible.";
                                        }
                                    }
                                }
                        }
                        else if (totalPoints > 0 || subtotal > 1000) {
                                if (Integer.parseInt(getCorrectButton(getSampleIndex(getCurrentNums())+1).getText().toString()) >= 5 && totalKeepableNumbers(rolledArray()) == 5) {
                                    suggestion += "I think you should keep the 3 of a kind and 2 ones and/or fives, and stop rolling.  Nice!";
                                }
                                else if (Integer.parseInt(getCorrectButton(getSampleIndex(getCurrentNums())+1).getText().toString()) >= 5 && totalKeepableNumbers(rolledArray()) == 4) {
                                    suggestion += "I think you should keep the 3 of a kind and the 1 or 5 and stop rolling.";
                                }
                                else if (Integer.parseInt(getCorrectButton(getSampleIndex(getCurrentNums())+1).getText().toString()) >= 5 && totalKeepableNumbers(rolledArray()) == 3) {
                                    if (subtotal > 1000) {
                                        suggestion += "I think you should keep the 3 of a kind and stop rolling.";
                                    }
                                    else if (subtotal < 1000) {
                                        suggestion += "I think you should keep the 3 of a kind and roll again.";
                                    }
                                }
                                else if (Integer.parseInt(getCorrectButton(getSampleIndex(getCurrentNums())+1).getText().toString()) < 5) {
                                    if (Integer.parseInt(getCorrectButton(getSampleIndex(getCurrentNums())+1).getText().toString()) != 2 && totalKeepableNumbers(rolledArray()) == 5) {
                                        suggestion += "I think you should keep the 3 of a kind and 2 ones or fives, and stop rolling.";
                                    }
                                    else if (Integer.parseInt(getCorrectButton(getSampleIndex(getCurrentNums())+1).getText().toString()) != 2 && totalKeepableNumbers(rolledArray()) == 4) {
                                        suggestion += "I think you should keep the 3 of a kind the 1 or 5 and stop rolling.";
                                    }
                                    else if (Integer.parseInt(getCorrectButton(getSampleIndex(getCurrentNums())+1).getText().toString()) != 2 && totalKeepableNumbers(rolledArray()) == 3) {
                                        suggestion += "I think you should keep the 3 of a kind and roll again.";
                                    }
                                    else if (Integer.parseInt(getCorrectButton(getSampleIndex(getCurrentNums())+1).getText().toString()) == 2) {
                                        if (totalOnes(getCurrentNums()) > 0 && totalFives(getCurrentNums()) >= 0) {
                                            suggestion += "I think you should keep a single 1 and roll again.";
                                        }
                                        else if (totalOnes(getCurrentNums()) == 0 && totalFives(getCurrentNums()) > 0) {
                                            suggestion += "I think you should keep a single 5 and roll again.";
                                        }
                                        else if (totalOnes(getCurrentNums()) == 0 && totalFives(getCurrentNums()) == 0) {
                                            suggestion += "I think you should keep the 2s and roll again.  Terrible.";
                                        }
                                    }
                                }
                        }

                    }
                    else if (checkSameNumberCount(rolledArray()) == 0 && totalOnes(rolledArray()) > 0) {
                        suggestion += "I think you should keep a single 1 and roll again.";
                    }
                    else if (checkSameNumberCount(rolledArray()) == 0 && totalOnes(rolledArray()) == 0 && totalFives(rolledArray()) > 0) {
                        suggestion += "I think you should keep a single 5 and roll again.";
                    }

                }  else if (rolledArray().length == 5) {
                    if (checkSameNumberCount(rolledArray()) == 4 && totalKeepableNumbers(rolledArray()) == 5) {
                        suggestion += "I think you should keep the 4 of a kind and 1 or 5 and stop rolling.  Nice!";
                    }
                    else if (checkSameNumberCount(rolledArray()) == 4 && totalKeepableNumbers(rolledArray()) == 4) {
                        suggestion += "I think you should keep the 4 of a kind and stop rolling.  Nice!";
                    }
                    else if (checkSameNumberCount(rolledArray()) == 3 && rolledArray()[getSampleIndex(rolledArray())] != 2 && totalKeepableNumbers(rolledArray()) == 3) {
                        if (totalPoints == 0 && subtotal <= 150) {
                            suggestion += "I think you should keep the 3 of a kind and roll again.  Need to get on the board.";
                        }
                        else if (totalPoints == 0 && subtotal > 150) {
                            suggestion += "I think you should keep the 3 of a kind and stop rolling.";
                        }
                        else if (totalPoints > 0) {
                            suggestion += "I think you should keep the 3 of a kind and stop rolling.";
                        }
                    }
                    else if (checkSameNumberCount(rolledArray()) == 3 && rolledArray()[getSampleIndex(rolledArray())] != 2 && totalKeepableNumbers(rolledArray()) == 4) {
                        if (pointsOfRoll(rolledArray()) + subtotal >= 500 && totalPoints == 0) {
                            suggestion += "I think you should keep the 3 of a kind and the 1 or 5, and stop rolling.";
                        }
                        else if (pointsOfRoll(rolledArray()) + subtotal < 500 && totalPoints == 0) {
                            suggestion += "I think you should keep the 3 of a kind and the 1 or 5, and roll again.  Need to get on the board.";
                        }
                        else if (totalPoints > 0) {
                            suggestion += "I think you should keep the 3 of a kind and the 1 or 5 and stop rolling.";
                        }
                    }
                    else if (checkSameNumberCount(rolledArray()) == 3 && rolledArray()[getSampleIndex(rolledArray())] == 2) {
                        if (totalOnes(rolledArray()) > 0) {
                            suggestion += "I think you should keep a single 1 and roll again";
                        }
                        else if (totalOnes(rolledArray()) == 0 && totalFives(rolledArray()) > 0) {
                            suggestion += "I think you should keep a single 5 and roll again";
                        }
                        else if (totalOnes(rolledArray()) == 0 && totalFives(rolledArray()) == 0 && totalPoints > 0 && subtotal <= 200) {
                            suggestion += "I think you should keep the three 2s and roll again.  Terrible";
                        }
                        else if (totalOnes(rolledArray()) == 0 && totalFives(rolledArray()) == 0 && totalPoints > 0 && subtotal > 200) {
                            suggestion += "You're terrible, but I think you should keep the three 2s and stop rolling.";
                        }
                        else if (totalOnes(rolledArray()) == 0 && totalFives(rolledArray()) == 0 && totalPoints == 0) {
                            suggestion += "I think you should keep the three 2s and roll again to try to get on the board.";
                        }
                    }
                    else if (checkSameNumberCount(rolledArray()) == 0) {
                        if (totalOnes(rolledArray()) > 0) {
                            suggestion += "I think you should keep a single 1 and roll again.";
                        }
                        else if (totalOnes(rolledArray()) == 0 & totalFives(rolledArray()) > 0) {
                            suggestion += "I think you should keep a single 5 and roll again.";
                        }
                    }
                } else if (rolledArray().length == 4) {
                    if (checkSameNumberCount(rolledArray()) == 3 && totalKeepableNumbers(rolledArray()) == 3) {
                        if (pointsOfRoll(rolledArray()) + subtotal >= 500 && totalPoints == 0) {
                            suggestion += "I think you should keep the 3 of a kind and stop rolling.";
                        } else if (pointsOfRoll(rolledArray()) + subtotal < 500 && totalPoints == 0) {
                            suggestion += "I think you should keep the 3 of a kind and roll again.  Need to get on the board.";
                        } else if (totalPoints > 0) {
                            suggestion += "I think you should keep the 3 of a kind and stop rolling.";
                        }
                    }
                    else if (checkSameNumberCount(rolledArray()) == 0) {
                        if (totalOnes(rolledArray()) == 2) {
                            suggestion += "I think you should keep the 1s and stop rolling.";
                        }
                        else if (totalFives(rolledArray()) == 2 && subtotal < 1000) {
                            suggestion += "I think you should keep a single 5 and roll again.";
                        }
                        else if (totalFives(rolledArray()) == 2 && subtotal > 1000) {
                            suggestion += "I think you should keep both 5s and stop rolling.";
                        }
                        else if (totalFives(rolledArray()) == 1 && totalOnes(rolledArray()) == 1 && subtotal > 1000) {
                            suggestion += "I think you should keep both the 1 and the 5 and stop rolling.";
                        }
                        else if (totalFives(rolledArray()) == 1 && totalOnes(rolledArray()) == 1 && subtotal < 1000) {
                            suggestion += "I think you should keep the 1 and roll again";
                        }
                        else if (totalOnes(rolledArray()) == 1 && totalFives(rolledArray()) == 0 && subtotal < 1000) {
                            suggestion += "I think you should keep the 1 and roll again.";
                        }
                        else if (totalOnes(rolledArray()) == 1 && totalFives(rolledArray()) == 0 && subtotal > 1000) {
                            suggestion += "I think you should keep the 1 stop rolling.";
                        }
                        else if (totalOnes(rolledArray()) == 0 && totalFives(rolledArray()) == 1 && subtotal < 1000) {
                            suggestion += "I think you should keep the 5 and roll again.";
                        }
                        else if (totalOnes(rolledArray()) == 0 && totalFives(rolledArray()) == 1 && subtotal < 1000) {
                            suggestion += "I think you should keep the 5 and stop rolling.";
                        }

                    }

                } else if (rolledArray().length == 3) {
                    if (totalPoints > 0) {
                        if (totalOnes(rolledArray()) == 2) {
                            suggestion += "I think you should keep the 1s and stop rolling.";
                        }
                        if (totalFives(rolledArray()) == 2) {
                            suggestion += "I think you should keep the 5s and stop rolling.";
                        } else if (totalFives(rolledArray()) == 1 && totalOnes(rolledArray()) == 1) {
                            suggestion += "I think you should keep both the 1 and the 5 and stop rolling.";
                        } else if (totalOnes(rolledArray()) == 1 && totalFives(rolledArray()) == 0) {
                            suggestion += "I think you should keep the 1 and stop rolling.";
                        } else if (totalOnes(rolledArray()) == 0 && totalFives(rolledArray()) == 1) {
                            suggestion += "I think you should keep the 5 and stop rolling.";
                        }
                    }  else if (totalPoints == 0) {
                        if (totalOnes(rolledArray()) == 2) {
                            if (subtotal >= 300) {
                                suggestion += "I think you should keep the 1s and stop rolling.  You're on the board!  Nice.";
                            }
                            else if (subtotal <300) {
                                suggestion += "I think you should keep the 1s and roll again.  Need to get on the board.";
                            }
                        }
                        else if (totalOnes(rolledArray()) == 1 && totalFives(rolledArray()) == 1) {
                            if (subtotal >= 350) {
                                suggestion += "I think you should keep the 1 and the 5 and stop rolling.  You're on the board!  Nice.";
                            }
                            else if (subtotal <350) {
                                if (subtotal == 300) {
                                    suggestion += "I think you should keep the 1 and roll again.  Need to get on the board, just need another 1 (or 2 fives).";
                                }
                                else if (subtotal < 300) {
                                    suggestion += "I think you should keep the 1 and the 5.  Need to get on the board, 1/3 chance to roll again afterwards.";
                                }
                            }
                        }
                        else if (totalOnes(rolledArray()) == 1 && totalFives(rolledArray()) == 0) {
                            if (subtotal >= 400) {
                                suggestion += "I think you should keep the 1 and stop rolling.  You're on the board.";
                            }
                            else if (subtotal < 400) {
                                suggestion += "I think you should keep the 1 and roll again.  Need to get on the board.";
                            }
                        }
                        else if (totalOnes(rolledArray()) == 0 && totalFives(rolledArray()) == 1) {
                            if (subtotal >= 450) {
                                suggestion += "I think you should keep the 5 and stop rolling.  You're on the board.";
                            }
                            else if (subtotal < 450) {
                                suggestion += "I think you should keep the 5 and roll again.  Need to get on the board.";
                            }
                        }
                    }

                } else if (rolledArray().length == 2) {
                    if (totalPoints > 0) {
                        if (totalOnes(rolledArray()) == 1) {
                            suggestion += "I think you should keep the 1 and stop rolling.";
                        } else if (totalFives(rolledArray()) == 1) {
                            suggestion += "I think you should keep the 5 and stop rolling.";
                        }
                    }
                    else if (totalPoints == 0) {
                        if (totalOnes(rolledArray()) == 1) {
                            if (subtotal >= 400) {
                                suggestion += "I think you should keep the 1 and stop rolling.  You're on the board.";
                            }
                            else if (subtotal < 400) {
                                suggestion += "I think you should keep the 1 and roll again.  Need to get on the board.";
                            }
                        } else if (totalFives(rolledArray()) == 1) {
                            if (subtotal >= 450) {
                                suggestion += "I think you should keep the 5 and stop rolling.  You're on the board.";
                            }
                            else if (subtotal < 450) {
                                suggestion += "I think you should keep the 5 and roll again.  Need to get on the board.";
                            }
                        }
                    }
                }
            }
            else if (youGetToRollAgain()) {
                if (checkIfStraight(rolledArray()) == true) {
                    suggestion += "I think you should keep the straight and roll again.  Nice!";
                } else if (checkSameNumberCount(rolledArray()) == 6 && rolledArray().length == 6) {
                    suggestion += "I think you should keep the 6 of a kind and roll again.  1/7776th chance.  Most impressive!";
                } else if (checkSameNumberCount(rolledArray()) == 12 && rolledArray().length == 6) {
                    suggestion += "I think you should keep the two triplets and roll again.  Fantastic skills!";
                } else if (checkSameNumberCount(rolledArray()) == 9 && rolledArray().length == 6) {
                    suggestion += "I think you should keep the three pair and roll again.  Fantastic skills!";
                } else if (checkSameNumberCount(rolledArray()) == 10 && rolledArray().length == 6) {
                    suggestion += "I think you should keep the full house and roll again.  Fantastic skills!";
                } else if (checkSameNumberCount(rolledArray()) == 5  && rolledArray().length == 5) {
                    suggestion += "I think you should keep the five of a kind and roll again.  Nice!";
                } else if (checkSameNumberCount(rolledArray()) == 4 && rolledArray().length == 4) {
                    suggestion += "I think you should keep the four of a kind and roll again.  Nice!";
                }
                else if (totalKeepableNumbers(rolledArray()) == rolledArray().length){
                    suggestion += "Keep everything and roll again!  Nice.";
                }
            }
        }

        else if (farkleTurn(rolledArray()) == true) {
            suggestion += "Wow looks like it's a farkle... at least I think so.  Be sure to roll, update, or end turn in between suggestions.";
        }

        return suggestion;
    }

    //   Make sure to make this array only include diceOneKept = false numbers, etc
    public Boolean youGetToRollAgain() {

        Boolean rollAgain = true;
        ArrayList<Button> buttonArrayList = new ArrayList<Button>();
        if (!diceOneKept) {
            buttonArrayList.add(keep1);
        }
        if (!diceTwoKept) {
            buttonArrayList.add(keep2);
        }
        if (!diceThreeKept) {
            buttonArrayList.add(keep3);
        }
        if (!diceFourKept) {
            buttonArrayList.add(keep4);
        }
        if (!diceFiveKept) {
            buttonArrayList.add(keep5);
        }
        if (!diceSixKept) {
            buttonArrayList.add(keep6);
        }

        for (int i = 0; i < buttonArrayList.size(); i++) {
            if (!checkIfValidKeep(buttonArrayList.get(i))) {
                rollAgain = false;
            }
        }
        return rollAgain;
    }

    public Integer totalKeepableNumbers(Integer[] remainingUnkept) {
        Integer keepableNumbers = 0;

        ArrayList<Button> buttonArrayList = new ArrayList<Button>();
        for (int i = 0; i < remainingUnkept.length; i++) {
            buttonArrayList.add(getCorrectButton(i + 1));
        }
        for (int i = 0; i < buttonArrayList.size(); i++) {
            if (checkIfValidKeep(buttonArrayList.get(i))) {
                keepableNumbers += 1;
            }
        }
        return keepableNumbers;
    }

    public void updateTurnsPointsText() {
        pointsAndTurns.setText("Subtotal:  " + subtotal + "\nTotal Points:  " + totalPoints + "\nRolls this Turn:  " + rollCount + "\nTurns:  " + turnCount);
    }

    public Integer totalOnes(Integer[] numsShowing) {
        Integer count = 0;
        for (int i = 0; i < numsShowing.length; i++) {
            if (numsShowing[i] == 1)
                count += 1;
        }
        return count;
    };

    public Integer totalFives(Integer[] numsShowing) {
        Integer count = 0;
        for (int i = 0; i < numsShowing.length; i++) {
            if (numsShowing[i] == 5)
                count += 1;
        }
        return count;
    };

    public Boolean checkIfStraight(Integer[] numsShowing) {
        if (numsShowing.length == 6) {
            for (int i = 0; i < numsShowing.length - 1; i++) {
                for (int j = i + 1; j < numsShowing.length; j++) {
                    if (numsShowing[i] == numsShowing[j])
                        return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public Integer checkSameNumberCount(Integer[] numsShowing) {
        Integer count = 0;

        Integer oneCount = 0;
        Integer twoCount = 0;
        Integer threeCount = 0;
        Integer fourCount = 0;
        Integer fiveCount = 0;
        Integer sixCount = 0;
        for(int i = 0; i < numsShowing.length; i++){
            if (numsShowing[i] == 1) {
                oneCount += 1;
            }
        }
        for(int i = 0; i < numsShowing.length; i++){
            if (numsShowing[i] == 2) {
                twoCount += 1;
            }
        }
        for(int i = 0; i < numsShowing.length; i++){
            if (numsShowing[i] == 3) {
                threeCount += 1;
            }
        }
        for(int i = 0; i < numsShowing.length; i++){
            if (numsShowing[i] == 4) {
                fourCount += 1;
            }
        }
        for(int i = 0; i < numsShowing.length; i++){
            if (numsShowing[i] == 5) {
                fiveCount += 1;
            }
        }
        for(int i = 0; i < numsShowing.length; i++){
            if (numsShowing[i] == 6) {
                sixCount += 1;
            }
        }
        Integer[] counts = new Integer[6];
        counts[0] = oneCount;
        counts[1] = twoCount;
        counts[2] = threeCount;
        counts[3] = fourCount;
        counts[4] = fiveCount;
        counts[5] = sixCount;

        //  Three of a Kind

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 3) {
                count = 3;
            }
        }

        //  Four of a Kind

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 4) {
                count = 4;
            }
        }

        //  Five of a Kind

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 5) {
                count = 5;
            }
        }

        //  Six of a Kind

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 6) {
                count = 6;
            }
        }

        //  Three Pairs

        Integer threePairsMaybe = 0;
        for (int i = 0; i < counts.length; i++) {
            if(counts[i] == 2) {
                threePairsMaybe += 1;
            }
        }
        if (threePairsMaybe == 3) {
            count = 9;
        }

        //  Three Fairs when 2 are the same

        Integer fullHouseLarge = 0;
        Integer fullHouseSmall = 0;
        for (int i = 0; i < counts.length; i++) {
            if(counts[i] == 2) {
                fullHouseSmall += 1;
            }
            if(counts[i] == 4) {
                fullHouseLarge += 1;
            }
        }
        if (fullHouseLarge == 1 && fullHouseSmall == 1) {
            count = 10;
        }

        //  Two Triples

        Integer twoTriples = 0;
        for (int i = 0; i < counts.length; i++) {
            if(counts[i] == 3) {
                twoTriples += 1;
            }
        }
        if (twoTriples == 2) {
            count = 12;
        }

        return count;
    }

    public void updateButtons() {
        newRollHappened = false;
        if (!(one.getText().toString().equals(null) || one.getText().toString().equals(""))) {
            if (Integer.parseInt(one.getText().toString()) < 1 || Integer.parseInt(one.getText().toString()) > 6) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "All numbers must be valid d6 choices",
                        Toast.LENGTH_SHORT);

                toast.show();
            } else {
                if (!diceOneKept) {
                    keep1.setText(one.getText());
                    newRollHappened = true;
                    one.setText("");
                }  else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Cannot update already kept selections.",
                            Toast.LENGTH_SHORT);

                    toast.show();
                }
            }
        }
        if (!(two.getText().toString().equals(null) || two.getText().toString().equals(""))) {
            if (Integer.parseInt(two.getText().toString()) < 1 || Integer.parseInt(two.getText().toString()) > 6) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "All numbers must be valid d6 rolls",
                        Toast.LENGTH_SHORT);

                toast.show();
            } else {
                if (!diceTwoKept) {
                    keep2.setText(two.getText());
                    newRollHappened = true;
                    two.setText("");
                }  else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Cannot update already kept selections.",
                            Toast.LENGTH_SHORT);

                    toast.show();
                }
            }
        }

        if (!(three.getText().toString().equals(null) || three.getText().toString().equals(""))) {
            if (Integer.parseInt(three.getText().toString()) < 1 || Integer.parseInt(three.getText().toString()) > 6) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "All numbers must be valid d6 rolls",
                        Toast.LENGTH_SHORT);

                toast.show();
            } else {
                if (!diceThreeKept) {
                    keep3.setText(three.getText());
                    newRollHappened = true;
                    three.setText("");
                }  else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Cannot update already kept selections.",
                            Toast.LENGTH_SHORT);

                    toast.show();
                }
            }
        }

        if (!(four.getText().toString().equals(null) || four.getText().toString().equals(""))) {
            if (Integer.parseInt(four.getText().toString()) < 1 || Integer.parseInt(four.getText().toString()) > 6) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "All numbers must be valid d6 rolls",
                        Toast.LENGTH_SHORT);

                toast.show();
            } else {
                if (!diceFourKept) {
                    keep4.setText(four.getText());
                    newRollHappened = true;
                    four.setText("");
                }  else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Cannot update already kept selections.",
                            Toast.LENGTH_SHORT);

                    toast.show();
                }
            }
        }

        if (!(five.getText().toString().equals(null) || five.getText().toString().equals(""))) {
            if (Integer.parseInt(five.getText().toString()) < 1 || Integer.parseInt(five.getText().toString()) > 6) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "All numbers must be valid d6 rolls",
                        Toast.LENGTH_SHORT);

                toast.show();
            } else {
                if (!diceFiveKept) {
                    keep5.setText(five.getText());
                    newRollHappened = true;
                    five.setText("");
                }  else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Cannot update already kept selections.",
                            Toast.LENGTH_SHORT);

                    toast.show();
                }
            }
        }

        if (!(six.getText().toString().equals(null) || six.getText().toString().equals(""))) {
            if (Integer.parseInt(six.getText().toString()) < 1 || Integer.parseInt(six.getText().toString()) > 6) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "All numbers must be valid d6 rolls",
                        Toast.LENGTH_SHORT);

                toast.show();
            } else {
                if (!diceSixKept) {
                    keep6.setText(six.getText());
                    newRollHappened = true;
                    six.setText("");
                }  else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Cannot update already kept selections.",
                            Toast.LENGTH_SHORT);

                    toast.show();
                }
            }
        }

        if (newRollHappened) {
            rollCount += 1;
            updateTurnsPointsText();
        }

    }

    public Integer getSampleIndex(Integer[] numsShowing) {
        Integer sampleIndex = 0;

        //  numsShowing must be of length 6 in order for retrieving the button value to work
        Integer oneCount = 0;
        Integer twoCount = 0;
        Integer threeCount = 0;
        Integer fourCount = 0;
        Integer fiveCount = 0;
        Integer sixCount = 0;
        for(int i = 0; i < numsShowing.length; i++){
            if (numsShowing[i] == 1) {
                oneCount += 1;
                if (oneCount == 3) {
                    sampleIndex = i;
                }
            }
        }
        for(int i = 0; i < numsShowing.length; i++){
            if (numsShowing[i] == 2) {
                twoCount += 1;
                if (twoCount == 3) {
                    sampleIndex = i;
                }
            }
        }
        for(int i = 0; i < numsShowing.length; i++){
            if (numsShowing[i] == 3) {
                threeCount += 1;
                if (threeCount == 3) {
                    sampleIndex = i;
                }
            }
        }
        for(int i = 0; i < numsShowing.length; i++){
            if (numsShowing[i] == 4) {
                fourCount += 1;
                if (fourCount == 3) {
                    sampleIndex = i;
                }
            }
        }
        for(int i = 0; i < numsShowing.length; i++){
            if (numsShowing[i] == 5) {
                fiveCount += 1;
                if (fiveCount == 3) {
                    sampleIndex = i;
                }
            }
        }
        for(int i = 0; i < numsShowing.length; i++){
            if (numsShowing[i] == 6) {
                sixCount += 1;
                if (sixCount == 3) {
                    sampleIndex = i;
                }
            }
        }

        return sampleIndex;
    }
}
