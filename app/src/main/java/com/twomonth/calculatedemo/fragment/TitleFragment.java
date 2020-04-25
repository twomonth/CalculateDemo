package com.twomonth.calculatedemo.fragment;


import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.twomonth.calculatedemo.R;
import com.twomonth.calculatedemo.databinding.FragmentTitleBinding;
import com.twomonth.calculatedemo.viewmodel.MyViewModel;
import com.twomonth.study.StudyListActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class TitleFragment extends Fragment {

    public TitleFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MyViewModel viewModel= ViewModelProviders
                .of(requireActivity(),new SavedStateViewModelFactory(requireActivity().getApplication(),this))
                .get(MyViewModel.class);
        FragmentTitleBinding binding = DataBindingUtil
                .inflate(inflater,R.layout.fragment_title,container,false);
        binding.setData(viewModel);
        binding.setLifecycleOwner(requireActivity());
        binding.buttonEntrance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController controller = Navigation.findNavController(view);
                controller.navigate(R.id.action_titleFragment_to_questionFragment);
            }
        });
        binding.buttonEntrance.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                startActivity(new Intent(getActivity(), StudyListActivity.class));
                return false;
            }
        });
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
