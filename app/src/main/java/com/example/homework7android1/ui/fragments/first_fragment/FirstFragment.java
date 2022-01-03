package com.example.homework7android1.ui.fragments.first_fragment;

import android.location.SettingInjectorService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homework7android1.R;
import com.example.homework7android1.databinding.FragmentFirstBinding;
import com.example.homework7android1.interfaces.OnItemClickListener;
import com.example.homework7android1.model.TextModel;
import com.example.homework7android1.ui.fragments.first_fragment.adapter.AdapterText;
import com.example.homework7android1.ui.fragments.second_fragment.SecondFragment;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Set;


public class FirstFragment extends Fragment {
    private FragmentFirstBinding binding;
    ArrayList<TextModel> text = new ArrayList<>();
    TextModel textModel;
    AdapterText adapterText = new AdapterText(text);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapterText = new AdapterText(text);
        binding.recyclerView.setAdapter(adapterText);
        setupSecondFragment();
        getData();
        setData();

    }


    private void setupSecondFragment() {
        binding.btnButtonFr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_firstFragment_to_secondFragment);
            }
        });
    }

    private void getData() {
        String s = textModel.getTextInput();
        TextModel textModel = new TextModel(s);
        Bundle bundle = new Bundle();
        bundle.putSerializable("key1", textModel);
        Navigation.findNavController(binding.getRoot()).navigate(R.id.action_firstFragment_to_secondFragment, bundle);
    }

    private void setData() {
        if (getArguments() != null) {
            textModel = (TextModel) getArguments().getSerializable("key");
            adapterText.setText(textModel);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
