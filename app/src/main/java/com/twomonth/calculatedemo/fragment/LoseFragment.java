package com.twomonth.calculatedemo.fragment;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twomonth.calculatedemo.R;
import com.twomonth.calculatedemo.databinding.FragmentLoseBinding;
import com.twomonth.calculatedemo.viewmodel.MyViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoseFragment extends Fragment {


    public LoseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        MyViewModel viewModel = ViewModelProviders.of(requireActivity(),new SavedStateViewModelFactory(requireActivity().getApplication(),this))
                .get(MyViewModel.class);
        FragmentLoseBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_lose,container,false);
        binding.setData(viewModel);
        binding.setLifecycleOwner(requireActivity());

        binding.buttonLoseBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController controller = Navigation.findNavController(view);
                controller.navigate(R.id.action_loseFragment_to_titleFragment);
            }
        });

        return binding.getRoot();
    }

}
