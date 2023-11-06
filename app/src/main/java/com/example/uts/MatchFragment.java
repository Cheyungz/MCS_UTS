package com.example.uts;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MatchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MatchFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MatchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MatchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MatchFragment newInstance(String param1, String param2) {
        MatchFragment fragment = new MatchFragment();
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
    }

    RecyclerView matchRecycler;
    MatchAdapter matchAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(MatchAdapter.match.isEmpty()){
            MatchAdapter.match.add(new Match("Team 1", "Team 2",R.drawable.left, R.drawable.right, 1, "27-04-2023 : 20.00"));
            MatchAdapter.match.add(new Match("Team 3", "Team 4",R.drawable.left, R.drawable.right, 2, "28-04-2023 : 21.00"));
            MatchAdapter.match.add(new Match("Team 5", "Team 6",R.drawable.left, R.drawable.right, 3, "29-04-2023 : 22.00"));
            MatchAdapter.match.add(new Match("Team 7", "Team 8",R.drawable.left, R.drawable.right, 4, "30-04-2023 : 23.00"));
            MatchAdapter.match.add(new Match("Team 9", "Team 10",R.drawable.left, R.drawable.right, 5, "30-04-2023 : 23.30"));
            MatchAdapter.match.add(new Match("Team 11", "Team 12",R.drawable.left, R.drawable.right, 6, "30-04-2023 : 24.00"));
        }
        return inflater.inflate(R.layout.fragment_match, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        matchRecycler = view.findViewById(R.id.matchRV);
        matchRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        matchAdapter = new MatchAdapter(this.getContext());
        matchRecycler.setAdapter(matchAdapter);
    }
}