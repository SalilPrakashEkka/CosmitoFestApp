package backcodes.com.cosmitosemifinal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class slideadapter extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private int[] images = {R.drawable.home,R.drawable.event,R.drawable.schedule,R.drawable.map};
    ImageView imageView;

    slideadapter(Context ctx)
    {
        context=ctx;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slideimage, null);
        imageView = (ImageView) view.findViewById(R.id.imageViewslide);
        // imageView.setImageDrawable(context.getResources().getDrawable(images[position]));
        //imageView.setImageResource(images[position]);
        //Picasso.get().load(R.drawable.m10).into(imageView);
        imageView.setImageResource(images[position]);

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}
