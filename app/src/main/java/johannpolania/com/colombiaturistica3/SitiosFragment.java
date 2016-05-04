package johannpolania.com.colombiaturistica3;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class SitiosFragment extends Fragment {
private TabLayout tab;
    private ViewPager pager;

    public SitiosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_sitios, container, false);
        tab=(TabLayout)rootView.findViewById(R.id.tabs2);
        pager=(ViewPager)rootView.findViewById(R.id.pager2);
        pager.setAdapter(new PageAdapterSitios(getChildFragmentManager()));
        tab.post(new Runnable() {
            @Override
            public void run() {
                tab.setupWithViewPager(pager);
            }
        });
        return rootView;

    }

}



class PageAdapterSitios extends FragmentPagerAdapter {

    public PageAdapterSitios(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {case 0:
            return new CandelariaFragment();
            case 1:
                return new MonserrateFragment();
            case 2:
                return new SabanaFragment();


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
                return "Candelaria";
            case 1:
                return "Monserrate";
            case 2:
                return "Tren de la Sabana";
        }
        return null;
    }


}
