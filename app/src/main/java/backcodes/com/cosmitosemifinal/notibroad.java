package backcodes.com.cosmitosemifinal;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import android.app.NotificationChannel;
import android.app.NotificationManager;

public class notibroad extends BroadcastReceiver {
    static int i=0;
    //PendingIntent pendingIntent;
    //NotificationCompat.Builder builder;
    //NotificationManager manager;
    //Intent notif;
    String mess;
    String event[]={"Fun","Treasure Hunt","Construct it","Thank You"};
    String timearray[]={"11:10 AM","11:20 AM","11:25 AM","11:30 AM"};
    String dayarray[]={"Nov 12","Nov 12","Nov 12","Nov 12"};
    String record="";
    int flag=0;
    int rece=0;
    @Override
    public void onReceive(Context context, Intent intent) {

        SharedPreferences sp = context.getSharedPreferences("backcodes.com.cosmitosemifinal.1st"  ,Context.MODE_PRIVATE);
        flag=0;
        i  = sp.getInt("i broad",0);
        rece= sp.getInt("rece",0);
        DateFormat time = new SimpleDateFormat("h:mm a");
        String timenow = time.format(Calendar.getInstance().getTime());
        Log.d("TheBackCodes time","time "+ timenow);
        // Toast.makeText(context, timenow, Toast.LENGTH_SHORT).show();
        DateFormat day = new SimpleDateFormat("MMM d");
        String daynow = day.format(Calendar.getInstance().getTime());
        Log.d("TheBackCodes time","day "+ daynow);

        /*Gson gson = new Gson();
        String jsonText = sp.getString("record", null);
        record = gson.fromJson(jsonText, String[].class);
        if(record==null) {
            record[0]="0";
            record[1]="0";record[2]="0";record[3]="0";


        }*/


        // Toast.makeText(context, daynow, Toast.LENGTH_SHORT).show();
        /*Intent notificationIntent = new Intent(context, MainActivity.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(notificationIntent);

        PendingIntent pendingIntent = stackBuilder.getPendingIntent(100, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"notify_001");
        builder.setAutoCancel(true);
        builder.build().flags |= Notification.FLAG_AUTO_CANCEL;
        Notification notification = builder.setContentTitle("Demo App Notification")
                .setContentText("New Notification From Demo App..")
                .setTicker("New Message Alert!")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent).build();
       // notification.flags |=Notification.FLAG_AUTO_CANCEL;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.O)
        {
            NotificationChannel channel=new NotificationChannel("notify_001","Channel human readable title",NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }
        notificationManager.notify(i, builder.build());
        i++;
        //notificationManager.notify(0, notification);*/
        if(timenow.equalsIgnoreCase(timearray[0])==true&&daynow.equalsIgnoreCase(dayarray[0])==true)
        {
            mess=event[0];
            Log.d("TheBackCodes message","event "+ event[0]);
            flag=1;
        }
        else  if(timenow.equalsIgnoreCase(timearray[1])==true&&daynow.equalsIgnoreCase(dayarray[1])==true)
        {
            mess=event[1];
            Log.d("TheBackCodes message","event "+ event[1]);
            flag=1;
        }
        else  if(timenow.equalsIgnoreCase(timearray[2])==true&&daynow.equalsIgnoreCase(dayarray[2])==true)
        {
            mess=event[2];
            Log.d("TheBackCodes message","event "+ event[2]);
            flag=1;
        }
        else  if(timenow.equalsIgnoreCase(timearray[3])==true&&daynow.equalsIgnoreCase(dayarray[3])==true)
        {
            mess=event[3];
            Log.d("TheBackCodes message","event "+ event[3]);
            flag=1;
        }


        if(flag==1) {
            Log.d("TheBackCodes aya", "aya " + i);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "notify_001")
                    .setSmallIcon(R.drawable.home)
                    .setContentTitle("Cosmita")
                    .setContentText(mess)
                    //.setStyle(new NotificationCompat.BigTextStyle().bigText("Ajj kal bahot he jada Moja he atta hai kya to bole"))
                    .setAutoCancel(true);
            //event[1][i] = String.valueOf(1);

            Intent notifi = new Intent(context, MainActivity.class);
            notifi.putExtra("not", Integer.toString(i));
            PendingIntent pendingIntent = PendingIntent.getActivity(context, i, notifi, PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(pendingIntent);
            NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel("notify_001", "Channel human readable title", NotificationManager.IMPORTANCE_DEFAULT);
                manager.createNotificationChannel(channel);
            }
            manager.notify(i, builder.build());

            if (i <= 3)
                i++;


            SharedPreferences sp1 = context.getSharedPreferences("backcodes.com.cosmitosemifinal.1st", Context.MODE_PRIVATE);
            sp1.edit().putInt("i broad", i).commit();

            // Log.d("TheBackCodes rece","rece "+ rece);
            Log.d("TheBackCodes record", "gaya " + record);
            /*Gson gson1 = new Gson();
            List<String> textList = new ArrayList<String>();
            textList.addAll(Arrays.asList(record));
            String jsonText1 = gson1.toJson(textList);
            sp1.edit().putString("record", jsonText1).commit();*/


        }


    }
}
