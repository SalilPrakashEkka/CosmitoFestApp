package backcodes.com.cosmitosemifinal;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class funadapter extends RecyclerView.Adapter<funadapter.Myholder> {
    int image[];
    String name[];
    Context context;
    popup popup;
    funadapter(Context ct,int im[],String nam[])
    {
        context=ct;
        image=im;
        name=nam;
        popup=new popup();

    }
    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardfun, parent, false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(Myholder holder, final int position) {
        holder.img.setImageResource(image[position]);
        holder.tv.setText(name[position]);
        final String w=name[position];
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.show(name[position],image[position],new Dialog(context));
                Toast.makeText(context, w, Toast.LENGTH_SHORT).show();
                //ShowPopup(name[position],image[position] );
                //popup.show(name[position],image[position],dialog);
            }
        });

    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    public class Myholder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tv;
        public Myholder(View itemView) {
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.ivshow);
            tv=(TextView)itemView.findViewById(R.id.tvname);
        }
    }
}
