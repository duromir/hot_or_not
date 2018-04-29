package net.firstcolor.ivan.hotornot.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.firstcolor.ivan.hotornot.R;
import net.firstcolor.ivan.hotornot.fragments.DetailsFragment.OnListFragmentInteractionListener;
import net.firstcolor.ivan.hotornot.fragments.dummy.DummyContent.DummyItem;
import net.firstcolor.ivan.hotornot.models.helper_models.ShortForecast;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class WeatherDetailRecyclerViewAdapter extends RecyclerView.Adapter<WeatherDetailRecyclerViewAdapter.ViewHolder> {

    private final List<ShortForecast> mValues;
    private final OnListFragmentInteractionListener mListener;

    //private ListItemB

    public WeatherDetailRecyclerViewAdapter(List<ShortForecast> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_weatherdetail, parent, false);
        //ListItemB
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.setForecast(mValues.get(position));
//        holder.mIdView.setText(mValues.get(position).id);
//        holder.mContentView.setText(mValues.get(position).content);

//        holder.mView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (null != mListener) {
//                    // Notify the active callbacks interface (the activity, if the
//                    // fragment is attached to one) that an item has been selected.
//                    mListener.onListFragmentInteraction(holder.mItem);
//                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        private final TextView txtTemp;
//        public final TextView mIdView;
//        public final TextView mContentView;
        public void setForecast(ShortForecast forecast){
            txtTemp.setText(forecast.getTemperatureFormatted());
        }

        public ViewHolder(View view) {
            super(view);
            mView = view;
            txtTemp = view.findViewById(R.id.txt_weather_temp);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + /*mContentView.getText() +*/ "'";
        }
    }
}
