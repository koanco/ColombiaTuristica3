package johannpolania.com.colombiaturistica3;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class RestauranteFragment extends Fragment {
private TabLayout tab;
    private ViewPager pager;

    public RestauranteFragment() {

    }



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=(View)inflater.inflate(R.layout.fragment_restaurante, container, false);
        tab=(TabLayout)rootView.findViewById(R.id.tabs3);
        pager=(ViewPager)rootView.findViewById(R.id.pager3);
         pager.setAdapter(new PageAdapterRestaurantes(getChildFragmentManager()));
        tab.post(new Runnable() {

            public void run() {
                tab.setupWithViewPager(pager);
            }
        });



        // Inflate the layout for this fragment
         return rootView;



    }





}

class PageAdapterRestaurantes extends FragmentPagerAdapter
{
    public PageAdapterRestaurantes(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
       switch (position)
       {case 0:
           return new GairaFragment();
           case 1:
               return new AguapanelaxFragment();
           case 2:
               return new AndresFragment();


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
                return "Café Gaira";
            case 1:
                return "Aguapanelas";
            case 2:
                return "Andrés Carne de res";
        }
        return null;
    }


}
