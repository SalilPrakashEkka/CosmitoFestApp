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
public class day3 extends Fragment {
    RecyclerView rcvday3;
    //int image[] = { R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};
    String name[] = {"Event 1", "Event 2", "Event 3"};
    String time[]={"9:00-10:00","9:00-10:00","9:00-10:00"};
    String venue[]={"Dome","Hall-1","OAT"};


    public day3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_day3, container, false);
        rcvday3 = (RecyclerView) view.findViewById(R.id.rcvday3);
        Context context = container.getContext();
        day3adapter day3adapter=new day3adapter(context,name,time,venue);
        rcvday3.setLayoutManager(new LinearLayoutManager(context));
        rcvday3.setAdapter(day3adapter);
        return view;
    }

}
