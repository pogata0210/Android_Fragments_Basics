package com.example.android_fragments_basics;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailsFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";



    private ImageView cardImage;
    private TextView cardName, cardText;

    public DetailsFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            card = (Card)getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cardImage = view.findViewById(R.id.card_image);
        cardName = view.findViewById(R.id.card_name);
        cardText = view.findViewById(R.id.card_text);

        Glide
                .with(getActivity())
                .load(card.getImageUrl())
                .thumbnail(.5f)
                .into(cardImage);
        cardName.setText(card.getName());
        cardText.setText(card.getText());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
