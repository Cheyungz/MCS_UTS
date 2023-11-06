package com.example.uts;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NewsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewsFragment newInstance(String param1, String param2) {
        NewsFragment fragment = new NewsFragment();
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

    RecyclerView newsRecycler;
    NewsAdapter newsAdapter;
    DBHelper DB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        if(NewsAdapter.news.isEmpty()){
            NewsAdapter.news.add(new News("Match 1 team 1 vs team 2", "Team 1 win with a score of 2-0", "Overwhelming victory by team 2", R.drawable.right));
            NewsAdapter.news.add(new News("Match 2 team 3 vs team 4", "Team 3 win with a score of 2-1", "With a leading score of 2, team 3 attained victory",R.drawable.left));
            NewsAdapter.news.add(new News("Match 3 team 5 vs team 6", "Team 6 win with a score of 1-2", "A 1 score difference for ",R.drawable.right));
            NewsAdapter.news.add(new News("match 4 team 7 vs team 8", "Team 8 win with a score of 2-3", "Team 8 got the next ticket for the next match",R.drawable.right));
            NewsAdapter.news.add(new News("match 5 team 9 vs team 10", "Team 9 win with a score of 3-2", "Team 9 win with 1 leading score",R.drawable.left));
            NewsAdapter.news.add(new News("match 6 team 11 vs team 12", "Team 12 win with a score of 1-3", "An unavoidable lost for team 11",R.drawable.right));

        }

        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DB = new DBHelper(this.getContext());

        newsRecycler = view.findViewById(R.id.newsRV);
        newsRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        newsAdapter = new NewsAdapter(this.getContext());
        newsRecycler.setAdapter(newsAdapter);
    }
}
