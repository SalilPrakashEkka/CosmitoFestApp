package backcodes.com.cosmitosemifinal;


import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fun extends Fragment {

    RecyclerView rcvtech;
    int image[] = {R.drawable.m11, R.drawable.m10, R.drawable.insta, R.drawable.screenshot5};
    String name[] = {"Event 1", "Event 2", "Event 3","Event 4"};

    public Fun() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fun, container, false);
        // Inflate the layout for this fragment
        rcvtech = (RecyclerView) view.findViewById(R.id.rcvtech);
        Context context = container.getContext();
        techadapter techadapter = new techadapter(context, image, name);
        rcvtech.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        rcvtech.setAdapter(techadapter);
        SpacesItemDecoration decoration = new SpacesItemDecoration(16);
        rcvtech.addItemDecoration(decoration);
        // Inflate the layout for this fragment
        return view;
    }

    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private final int mSpace;

        public SpacesItemDecoration(int space) {
            this.mSpace = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.left = mSpace;
            outRect.right = mSpace;
            outRect.bottom = mSpace;

            // Add top margin only for the first item to avoid double space between items
            if (parent.getChildAdapterPosition(view) == 0)
                outRect.top = mSpace;
        }
    }
}


