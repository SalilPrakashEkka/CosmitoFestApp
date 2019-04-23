package backcodes.com.cosmitosemifinal;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class Map extends Fragment {
    private Spinner spinner;
    private static final String[] paths = {"--Select--","Hall-1", "Hall-2", "Knowledge Center","OAT"};
    int imagedome[]={R.drawable.m10,R.drawable.m11,R.drawable.screenshot5,R.drawable.scan};
    int imagefood[]={R.drawable.screenshot5,R.drawable.m11,R.drawable.m10,R.drawable.scan};
    int imagenew[]={R.drawable.m11,R.drawable.m10,R.drawable.screenshot5,R.drawable.scan};
    Context context;
    ImageView imgqr,imvshowmap;
    String startposition="";
    IntentIntegrator qrScan;
    EditText edmap;

    public Map() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);

        spinner = (Spinner) view.findViewById(R.id.spinner);
        context = container.getContext();
        edmap = (EditText) view.findViewById(R.id.edstart);
        qrScan = new IntentIntegrator(getActivity());
        imgqr = (ImageView) view.findViewById(R.id.imvqr);
        imvshowmap=(ImageView)view.findViewById(R.id.imvshowmap);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,
                android.R.layout.simple_spinner_item, paths);

        adapter.setDropDownViewResource(R.layout.spinnertext);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
                    Toast.makeText(context, "Dome", Toast.LENGTH_SHORT).show();
                    if(startposition.equalsIgnoreCase("Dome")==true)
                    {
                        imvshowmap.setImageResource(imagedome[position-1]);
                    }
                    else  if(startposition.equalsIgnoreCase("Food court")==true)
                    {
                        imvshowmap.setImageResource(imagefood[position-1]);
                    }
                    else  if(startposition.equalsIgnoreCase("New Building")==true)
                    {
                        imvshowmap.setImageResource(imagenew[position-1]);
                    }
                } else if (position == 2) {
                    Toast.makeText(context, "Food Court", Toast.LENGTH_SHORT).show();
                    if(startposition.equalsIgnoreCase("Dome")==true)
                    {
                        imvshowmap.setImageResource(imagedome[position-1]);
                    }
                    else  if(startposition.equalsIgnoreCase("Food court")==true)
                    {
                        imvshowmap.setImageResource(imagefood[position-1]);
                    }
                    else  if(startposition.equalsIgnoreCase("New Building")==true)
                    {
                        imvshowmap.setImageResource(imagenew[position-1]);
                    }
                } else if (position == 3) {
                    Toast.makeText(context, "New Building", Toast.LENGTH_SHORT).show();
                    if(startposition.equalsIgnoreCase("Dome")==true)
                    {
                        imvshowmap.setImageResource(imagedome[position-1]);
                    }
                    else  if(startposition.equalsIgnoreCase("Food court")==true)
                    {
                        imvshowmap.setImageResource(imagefood[position-1]);
                    }
                    else  if(startposition.equalsIgnoreCase("New Building")==true)
                    {
                        imvshowmap.setImageResource(imagenew[position-1]);
                    }
                }
                else if(position == 4) {
                    Toast.makeText(context, "New Building", Toast.LENGTH_SHORT).show();
                    if(startposition.equalsIgnoreCase("Dome")==true)
                    {
                        imvshowmap.setImageResource(imagedome[position-1]);
                    }
                    else  if(startposition.equalsIgnoreCase("Food court")==true)
                    {
                        imvshowmap.setImageResource(imagefood[position-1]);
                    }
                    else  if(startposition.equalsIgnoreCase("New Building")==true)
                    {
                        imvshowmap.setImageResource(imagenew[position-1]);
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        imgqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qrScan.forSupportFragment(Map.this).initiateScan();
            }
        });
        return view;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            //if qrcode has nothing in it
            if (result.getContents() == null) {
                Toast.makeText(context, "Result Not Found", Toast.LENGTH_LONG).show();
            } else {
                //if qr contains data
                try {

                    //converting the data to json
                    JSONObject obj = new JSONObject(result.getContents());
                    //setting values to textviews
                    startposition=obj.getString("name");
                    edmap.setText(obj.getString("name"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    //if control comes here
                    //that means the encoded format not matches
                    //in this case you can display whatever data is available on the qrcode
                    //to a toast

                    //Toast.makeText(context, result.getContents(), Toast.LENGTH_LONG).show();
                    edmap.setText(result.getContents());
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}