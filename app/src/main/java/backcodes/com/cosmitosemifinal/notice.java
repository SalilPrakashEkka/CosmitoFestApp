package backcodes.com.cosmitosemifinal;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import java.util.Calendar;

public class notice extends Service {
    Calendar cal;
    static int i=0;
    Intent intent;
    PendingIntent pendingIntent;
    int a[]={13,13};
    int b[]={32,34};
    int c=0,d=0,e=0,f=0;
    boolean run=true; //set it to false if you want to stop the timer
    Handler mHandler = new Handler();
    AlarmManager alarmManager;
    int myAlarmDayOfTheWeek;
    int myAlarmHour ;
    int myAlarmMinute ;
    int day1,min1,mon1,mon2,min2,day2;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferences sp = getSharedPreferences("backcodes.com.cosmitosemifinal.1st"  ,Context.MODE_PRIVATE);
        day1 = sp.getInt("day1",9);
        min1=sp.getInt("min1",02);
        mon1=sp.getInt("mon1",4);

        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        day1=day2=11;
        min1=10;
        min2=20;
        mon1=mon2=12;
        Intent notificationIntent = new Intent(getApplicationContext(),notibroad.class);
        notificationIntent.addCategory("android.intent.category.DEFAULT");
        /*Bundle bundle=new Bundle();
        bundle.putString("Event","Khelo");
        notificationIntent.putExtras(bundle);*/
        PendingIntent broadcast = PendingIntent.getBroadcast(this, 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, mon1);
        cal.set(Calendar.HOUR_OF_DAY, day1);
        cal.set(Calendar.MINUTE,min1);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(), broadcast);
        //notificationIntent.putExtra("Event","Padho" );
        AlarmManager alarmManager1 = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        PendingIntent broadcast1 = PendingIntent.getBroadcast(this, 101, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.DAY_OF_MONTH, mon2);
        cal1.set(Calendar.HOUR_OF_DAY,day2 );
        cal1.set(Calendar.MINUTE,min2);
        //alarmManager.cancel(broadcast);
        alarmManager1.setExact(AlarmManager.RTC_WAKEUP,cal1.getTimeInMillis(), broadcast1);


        AlarmManager alarmManager2 = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        PendingIntent broadcast2 = PendingIntent.getBroadcast(this, 102, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        Calendar cal2 = Calendar.getInstance();
        cal2.set(Calendar.DAY_OF_MONTH,12);
        cal2.set(Calendar.HOUR_OF_DAY,11);
        cal2.set(Calendar.MINUTE,15);
        //alarmManager1.cancel(broadcast1);
        alarmManager2.setExact(AlarmManager.RTC_WAKEUP,cal2.getTimeInMillis(), broadcast2);

        AlarmManager alarmManager3 = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        PendingIntent broadcast3 = PendingIntent.getBroadcast(this, 103, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        Calendar cal3 = Calendar.getInstance();
        cal3.set(Calendar.DAY_OF_MONTH,12);
        cal3.set(Calendar.HOUR_OF_DAY,11);
        cal3.set(Calendar.MINUTE,25);
        // alarmManager2.cancel(broadcast2);
        alarmManager3.setExact(AlarmManager.RTC_WAKEUP,cal3.getTimeInMillis(), broadcast3);

       /* AlarmManager alarmManager4 = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        PendingIntent broadcast4 = PendingIntent.getBroadcast(this, 104, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        Calendar cal4 = Calendar.getInstance();
        cal4.set(Calendar.DAY_OF_MONTH,4);
        cal4.set(Calendar.HOUR_OF_DAY,20 );
        cal4.set(Calendar.MINUTE,30);
      //  alarmManager3.cancel(broadcast3);
        alarmManager4.setExact(AlarmManager.RTC_WAKEUP,cal4.getTimeInMillis(), broadcast4);*/
        /*cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 2);
        cal.set(Calendar.HOUR_OF_DAY,9 );
        cal.set(Calendar.MINUTE,1);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP,AlarmManager.INTERVAL_DAY, broadcast);

        cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 2);
        cal.set(Calendar.HOUR_OF_DAY,9 );
        cal.set(Calendar.MINUTE,5);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP,AlarmManager.INTERVAL_DAY, broadcast);

        cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 2);
        cal.set(Calendar.HOUR_OF_DAY,9 );
        cal.set(Calendar.MINUTE,10);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP,AlarmManager.INTERVAL_DAY, broadcast);


        cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 2);
        cal.set(Calendar.HOUR_OF_DAY,9 );
        cal.set(Calendar.MINUTE,12);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP,AlarmManager.INTERVAL_DAY, broadcast);

        cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 2);
        cal.set(Calendar.HOUR_OF_DAY,9 );
        cal.set(Calendar.MINUTE,18);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP,AlarmManager.INTERVAL_DAY, broadcast);

        cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 2);
        cal.set(Calendar.HOUR_OF_DAY,9 );
        cal.set(Calendar.MINUTE,21);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP,AlarmManager.INTERVAL_DAY, broadcast);

        cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 2);
        cal.set(Calendar.HOUR_OF_DAY,9 );
        cal.set(Calendar.MINUTE,25);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP,AlarmManager.INTERVAL_DAY, broadcast);

        cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 2);
        cal.set(Calendar.HOUR_OF_DAY,9 );
        cal.set(Calendar.MINUTE,30);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP,AlarmManager.INTERVAL_DAY, broadcast);*/

      /*  Calendar timestamp = Calendar.getInstance();

//Check whether the day of the week was earlier in the week:
        if( myAlarmDayOfTheWeek > timestamp.get(Calendar.DAY_OF_WEEK) ) {
            //Set the day of the AlarmManager:
            timestamp.add(Calendar.DAY_OF_YEAR, (myAlarmDayOfTheWeek - timestamp.get(Calendar.DAY_OF_WEEK)));
        }
        else {
            if( myAlarmDayOfTheWeek < timestamp.get(Calendar.DAY_OF_WEEK) ) {
                //Set the day of the AlarmManager:
                timestamp.add(Calendar.DAY_OF_YEAR, (7 - (timestamp.get(Calendar.DAY_OF_WEEK) - myAlarmDayOfTheWeek)));
            }
            else {  // myAlarmDayOfTheWeek == time.get(Calendar.DAY_OF_WEEK)
                //Check whether the time has already gone:
                if ( (myAlarmHour < timestamp.get(Calendar.HOUR_OF_DAY)) || ((myAlarmHour == timestamp.get(Calendar.HOUR_OF_DAY)) && (myAlarmMinute < timestamp.get(Calendar.MINUTE))) ) {
                    //Set the day of the AlarmManager:
                    timestamp.add(Calendar.DAY_OF_YEAR, 7);
                }
            }
        }

//Set the time of the AlarmManager:
        timestamp.set(Calendar.HOUR_OF_DAY, myAlarmHour);
        timestamp.set(Calendar.MINUTE, myAlarmMinute);
        timestamp.set(Calendar.SECOND, 0);*/

    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return Service.START_STICKY;
    }



}
