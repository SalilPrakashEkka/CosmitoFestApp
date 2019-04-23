package backcodes.com.cosmitosemifinal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class day1adapter extends RecyclerView.Adapter<day1adapter.Myholder> {
    Context context;

    String name[];
    String time[];
    String venue[];
    day1adapter(Context ct,String nam[],String tim[],String ven[])
    {

        name=nam;
        time=tim;
        venue=ven;
        context=ct;
    }
    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.schedulecard, parent, false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {

       holder.tvname.setText(name[position]);
       holder.tvtime.setText(time[position]);
       holder.tvvenue.setText(venue[position]);
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class Myholder extends RecyclerView.ViewHolder {
        TextView tvname,tvtime,tvvenue;

        public Myholder(View itemView) {
            super(itemView);
            tvname=(TextView)itemView.findViewById(R.id.tvname);
            tvtime=(TextView)itemView.findViewById(R.id.tvtime);
            tvvenue=(TextView)itemView.findViewById(R.id.venueid);

        }
    }
}
