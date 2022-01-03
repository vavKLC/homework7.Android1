package com.example.homework7android1.ui.fragments.first_fragment;

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


public class FirstFragment extends Fragment {
    private FragmentFirstBinding binding;
    ArrayList<TextModel> text = new ArrayList<>();
    TextModel textModel;
    AdapterText adapterText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater , container , false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        getData();
        setupSecondFragment();

    }


    private void getData() {
        if (getArguments() != null){
            textModel = (TextModel) getArguments().getSerializable("key");
            adapterText.setText(textModel);

        }
    }
    private void setupSecondFragment() {
        binding.btnButtonFr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = text.toString();
                TextModel textModel = new TextModel(s);
                Bundle bundle = new Bundle();
                bundle.putSerializable("key" , textModel);
                Navigation.findNavController(view).navigate(R.id.action_firstFragment_to_secondFragment,bundle) ;
            }
        });
    }

    }
