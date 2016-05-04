package johannpolania.com.colombiaturistica3;


import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.design.widget.TabLayout;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelesFragment extends Fragment {
private TabLayout tabLayout;
    private ViewPager pager;

    public HotelesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_hoteles,container,false);
         tabLayout=(TabLayout)view.findViewById(R.id.tabs);
         pager=(ViewPager)view.findViewById(R.id.pager);
        pager.setAdapter(new PageAdapterHoteles(getChildFragmentManager()));

            tabLayout.post(new Runnable() {
                @Override
                public void run() {
                    tabLayout.setupWithViewPager(pager);
                }
            });




        return view;


    }



}


class PageAdapterHoteles extends FragmentPagerAdapter {

    public PageAdapterHoteles(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {case 0:
            return new Tequendama();
            case 1:
                return new RosalesFragment();
            case 2:
                return new MercureFragment();


        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Hotel Tequendama";
            case 1:
                return "Hotel Rosales";
            case 2:
                return "Hotel Mercure";
        }
        return null;
    }


}
