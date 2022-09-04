package com.example.physiocounter;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class SecondFragment extends Fragment {
    TextView setCounterText;
    Button startbtn, stopbtn, restartbtn;
    Chronometer simpleChronometer;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(SecondFragment.this)
//                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
//            }
//        });

        Bundle bundle = this.getArguments();
        CharSequence totalSetCount= bundle.getCharSequence("totalSetCount");
        CharSequence restTimeLabel = bundle.getCharSequence("restTime");
        CharSequence countsPerSetLabel = bundle.getCharSequence("countsPerSet");
        CharSequence countDurationLabel = bundle.getCharSequence("countDuration");
//        Toast.makeText(getContext(), "Values are, Set Count = " + totalSetCount + " , Rest Time = " + restTimeLabel + " , Counts/Set = " + countsPerSetLabel + " , Count Duration = " + countDurationLabel, Toast.LENGTH_SHORT).show();

        simpleChronometer = (Chronometer) view.findViewById(R.id.simpleChronometer);
        startbtn = (Button) view.findViewById(R.id.startButton);
        stopbtn = (Button) view.findViewById(R.id.stopButton);
        restartbtn = (Button) view.findViewById(R.id.restartButton);
        setCounterText = (TextView) view.findViewById(R.id.setCounterText);
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                simpleChronometer.start();
                startbtn.setEnabled(false);
                stopbtn.setEnabled(true);

            }
        });
        stopbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                simpleChronometer.stop();
                startbtn.setEnabled(true);
                stopbtn.setEnabled(false);

            }
        });

        restartbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                simpleChronometer.setBase(SystemClock.elapsedRealtime());
                startbtn.setEnabled(true);
                stopbtn.setEnabled(false);

            }
        });

        simpleChronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            int counter = 1;
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if (SystemClock.elapsedRealtime() - chronometer.getBase() > (Integer.parseInt(countsPerSetLabel.toString()) * 1000)) {
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    counter++;
                    setCounterText.setText("Set: " + counter);
                    if(counter > Integer.parseInt(totalSetCount.toString())){
                        chronometer.stop();
                        setCounterText.setText(" Mission Completed !!!");
                        startbtn.setEnabled(false);
                        stopbtn.setEnabled(false);
                        restartbtn.setEnabled(false);
                    }
                }
                else{
                    setCounterText.setText("Set: " + counter);

                }
            }

        });
    }
}