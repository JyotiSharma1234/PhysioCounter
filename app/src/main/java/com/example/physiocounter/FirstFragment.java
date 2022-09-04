package com.example.physiocounter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {
    TextView totalSetCountLabel;
    SeekBar totalSetSeekBar;
    TextView restTimeLabel;
    SeekBar restTimeSeekBar;
    TextView countsPerSetLabel;
    SeekBar countsPerSetSeekBar;
    TextView countDurationLabel;
    SeekBar countDurationSeekBar;

    Button nextButton;

//    Intent intent;

    Bundle bundle;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        totalSetSeekBar = view.findViewById(R.id.totalSetSeekBar);
        totalSetCountLabel = view.findViewById(R.id.setCount);

        restTimeSeekBar = view.findViewById(R.id.restTimeSeekBar);
        restTimeLabel = view.findViewById(R.id.restTimeLabel);

        countsPerSetSeekBar = view.findViewById(R.id.countsPerSetSeekBar);
        countsPerSetLabel = view.findViewById(R.id.countsPerSetLabel);

        countDurationSeekBar = view.findViewById(R.id.countDurationSeekBar);
        countDurationLabel = view.findViewById(R.id.countDurationLabel);

        nextButton = view.findViewById(R.id.button_first);

//        intent = new Intent(getActivity().getBaseContext(), SecondFragment.class);

        bundle = new Bundle();

        totalSetSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                totalSetCountLabel.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        restTimeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                restTimeLabel.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        countsPerSetSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                countsPerSetLabel.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        countDurationSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                countDurationLabel.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        nextButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getContext(), "Values are, Set Count = " + totalSetCountLabel.getText() + " , Rest Time = " + restTimeLabel.getText() + " , Counts/Set = " + countsPerSetLabel.getText() + " , Count Duration = " + countDurationLabel.getText(), Toast.LENGTH_SHORT).show();

                bundle.putCharSequence("totalSetCount", totalSetCountLabel.getText());
                bundle.putCharSequence("restTime", restTimeLabel.getText());
                bundle.putCharSequence("countsPerSet", countsPerSetLabel.getText());
                bundle.putCharSequence("countDuration", countDurationLabel.getText());

//                intent.putExtras(bundle);

                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment, bundle);
            }
        });
    }
}