package backcodes.com.cosmitosemifinal;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Events extends Fragment {
TextView tvframe;

    public Events() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_events, container, false);
        // Inflate the layout for this fragment
        BottomNavigationView navigation = (BottomNavigationView) view.findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        tvframe=(TextView)view.findViewById(R.id.tvframe);
        Fragment fragment = new Technical();
        loadFragment(fragment);
        tvframe.setText("Technical");
        return view;
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_shop:
                    tvframe.setText("Technical");
                    fragment = new Technical();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_gifts:
                    tvframe.setText("Cultural");
                    fragment = new Cultural();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_cart:
                    tvframe.setText("Fun");
                    fragment = new Fun();
                    loadFragment(fragment);
                    return true;

            }
            return false;
        }
    };
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
