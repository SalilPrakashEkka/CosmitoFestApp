package backcodes.com.cosmitosemifinal;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class day2 extends Fragment {
    RecyclerView rcvday2;
    //int image[] = {R.drawable.home,R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};
    String name[] = {"Event 1", "Event 2", "Event 3","Event 4","Event 5"};
    String time[]={"9:00-10:00","9:00-10:00","9:00-10:00","9:00-10:00","9:00-10:00"};
    String venue[]={"Dome","Hall-1","Hall-2","KC","OAT"};


    public day2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_day2, container, false);
        rcvday2 = (RecyclerView) view.findViewById(R.id.rcvday2);
        Context context = container.getContext();
        day2adapter day2adapter=new day2adapter(context,name,time, venue);
        rcvday2.setLayoutManager(new LinearLayoutManager(context));
        rcvday2.setAdapter(day2adapter);
        return view;
    }

}
