package backcodes.com.cosmitosemifinal;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.journeyapps.barcodescanner.ViewfinderView;

public class popup {
    Dialog dialog;
    TextView tvnum1,tvnum2;
    public void show(String nam,int ima,Dialog di1)
    {
        dialog=di1;
        TextView tvname;
        ImageView imageView;
       // ImageView imvclose;

        dialog.setContentView(R.layout.allpopup);
        tvnum1=(TextView)dialog.findViewById(R.id.textView4) ;
        tvnum2=(TextView)dialog.findViewById(R.id.textView5) ;
        /*tvnum1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0123456789"));
                //startActivity(intent);
            }
        });*/
        tvname=(TextView)dialog.findViewById(R.id.tventname);
        imageView=(ImageView)dialog.findViewById(R.id.imveventshow);
       // imvclose=(ImageView)dialog.findViewById(R.id.imageView2);
        tvname.setText(nam);
        imageView.setImageResource(ima);
        /*imvclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });*/
        dialog.show();
    }

}
