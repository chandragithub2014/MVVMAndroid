package com.andr.mvvm.RetofitMVVM.RetrofitViews;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andr.mvvm.R;
import com.andr.mvvm.RetofitMVVM.Repository.ResultModel;
import com.andr.mvvm.RetofitMVVM.RetrofitViewModel.RetroViewModel;
import com.andr.mvvm.repository.User;
import com.andr.mvvm.viewmodels.UserListViewModel;
import com.andr.mvvm.views.UserListAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RetroFitPostFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RetroFitPostFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View view = null;
    RetroViewModel retroViewModel;
    public RetroFitPostFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RetroFitPostFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RetroFitPostFragment newInstance(String param1, String param2) {
        RetroFitPostFragment fragment = new RetroFitPostFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        retroViewModel = ViewModelProviders.of(getActivity()).get(RetroViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_retro_fit_post, container, false);
        initViews(view);
        setAdapter();
        retroViewModel.getProjectRetroListObservable().observe(this, new Observer<List<ResultModel>>() {
            @Override
            public void onChanged(@Nullable final List<ResultModel> users) {
                // Update the cached copy of the words in the adapter.
                adapter.setWords(users);
            }
        });
        return  view;
    }

    RecyclerView recyclerView;
    private void initViews(View view){
        recyclerView = (RecyclerView)view.findViewById(R.id.post_list);
    }


    RetroPostListAdapter adapter = null;
    private void setAdapter(){
        adapter = new RetroPostListAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

}
