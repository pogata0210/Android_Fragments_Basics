package com.example.android_fragments_basics;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private final List<Card> mValues;
    Activity activity;

    public Adapter(Activity activity, List<Card> mtgCards, MtgCardFragment.OnListFragmentInteractionListener listener) {
        this.activity = activity;
        mValues = mtgCards;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        Glide
                .with(activity.getApplicationContext())
                .load(mValues.get(position).getImageUrl())
                .thumbnail(.5f)
                .into(holder.image);

        holder.author.setText(mValues.get(position).getName());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView image;
        public final TextView author;
        public Card mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            image = view.findViewById(R.id.image);
            author = view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + author.getText() + "'";
        }
    }
}