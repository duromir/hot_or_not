package net.firstcolor.ivan.hotornot.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import net.firstcolor.ivan.hotornot.HomeActivity;
import net.firstcolor.ivan.hotornot.fragments.DetailsFragment;
import net.firstcolor.ivan.hotornot.fragments.OverallFragment;

public class TabsPagerAdapter extends FragmentPagerAdapter {

    private OverallFragment overAllTabFragment;
    private DetailsFragment detailsTabFragment;

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
        overAllTabFragment = new OverallFragment();
        detailsTabFragment = DetailsFragment.newInstance(1);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        if(position == 0){
            return overAllTabFragment;
        }
        else if(position == 1){
            return detailsTabFragment;
        }
        return null;
        //return HomeActivity.PlaceholderFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return 2;
    }
}
