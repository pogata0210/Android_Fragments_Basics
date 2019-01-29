package com.example.android_fragments_basics;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class MtgCardFragment extends Fragment {
    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    private static List<String> filter = new ArrayList<>();
    public static String page = "page=%s";
    public static String pageSize = "pageSize=%s";
    private static final String STARTING_PAGE = "1";
    private static final String ITEMS_PER_PAGE = "50";
    static List<Card> mtgCards;
    public static Adapter adapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MtgCardFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static MtgCardFragment newInstance(int columnCount) {
        MtgCardFragment fragment = new MtgCardFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        filter.add(String.format(page, STARTING_PAGE));
        filter.add(String.format(pageSize, ITEMS_PER_PAGE));
      Cards = new ArrayList<>();


        @Override
        public void onViewCreated (@NonNull View view, @Nullable Bundle savedInstanceState){
            super.onViewCreated(view, savedInstanceState);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Cards.add(card1);
                   Cards.add(card2);
                   Cards.add(card3);
                   Cards.add(card4);
                   Cards.add(card5);
                  Cards.add(card6);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    });
                }
            }).start();
        }

        @Override
        public void onActivityCreated (@Nullable Bundle savedInstanceState){
            super.onActivityCreated(savedInstanceState);
        }

        @Override
        public void onAttach (Context context){
            super.onAttach(context);
            if (context instanceof OnListFragmentInteractionListener) {
                mListener = (OnListFragmentInteractionListener) context;
            } else {
                throw new RuntimeException(context.toString()
                        + " must implement OnListFragmentInteractionListener");
            }
        }

        @Override
        public void onDetach () {
            super.onDetach();
            mListener = null;
        }


        public interface OnListFragmentInteractionListener {
            // TODO: Update argument type and name
            void onListFragmentInteraction(Card item);
        }
    }
}