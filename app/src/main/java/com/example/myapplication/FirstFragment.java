package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.submitButton.setOnClickListener(v -> {

            String name = binding.nameInput.getText().toString().trim();
            String college = binding.courseInput.getText().toString().trim();
            String course = binding.submitButton.getText().toString().trim();

            if (name.isEmpty() || college.isEmpty() || course.isEmpty()) {

                Toast.makeText(requireContext(),
                        "Please fill all details",
                        Toast.LENGTH_SHORT).show();

            } else {

                Toast.makeText(requireContext(),
                        "Profile Saved!\nName: " + name
                                + "\nCollege: " + college
                                + "\nCourse: " + course,
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}