package com.anyone.message ;
 
 
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.content.pm.ApplicationInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.PackageManager;

import android.text.TextUtils;

import android.util.Log ;

import java.util.List;

 


public class dfpush extends BroadcastReceiver
{ 
	private static final String TAG = "dfpush_demo" ;
	
	// 注册
	public static boolean register( Context context )
	{
 		
		Intent i = new Intent( "com.dfpush.OPENPUSH.SERVICE" );
		PackageManager pm = context.getPackageManager();
		List<ResolveInfo> list = pm.queryIntentServices(i, 0);
		
		ServiceInfo ci = null ;	
		
 		for( ResolveInfo info : list )
		if ( info.serviceInfo.exported )
		if ( ( info.serviceInfo.applicationInfo.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP ) != 0 )
		{
			ci = info.serviceInfo ;	
			break ;
		}
		if ( ci == null )
		for( ResolveInfo info : list )
		if ( info.serviceInfo.exported )
		if ( ( info.serviceInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM ) != 0 )
		{
			ci = info.serviceInfo ;	
			break ;
		}
		if ( ci == null )
		for( ResolveInfo info : list )
		if ( info.serviceInfo.exported )
		{
			ci = info.serviceInfo ;	
			break ;
		}
			
		if( ci != null )
		{		
			Log.v( TAG, "dfpush found : " + ci.packageName );

			Intent t=new Intent( "com.dfpush.OPENPUSH.REGISTER" );
			t.setPackage(ci.packageName); 
			t.putExtra("package", context.getPackageName() );
			t.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
			context.sendBroadcast(t);
			
			return true; 
		}

 		Log.v( TAG, "dfpush not found" );

		return false ;
	}
	
	// 接收广播
	public void onReceive(Context context, Intent intent)
	{
 		
		String token = intent.getStringExtra("token");

		if ( ! TextUtils.isEmpty(token) )   
		{
			String server = intent.getStringExtra("server");
			String version = intent.getStringExtra("version");
			
			Log.v( TAG, "GET token="+ token  );
			Log.v( TAG, "GET server="+ server  );
			Log.v( TAG, "GET version="+ version  );
			
			 
			 
			return ;
		}

		String message = intent.getStringExtra("message");

		if ( ! TextUtils.isEmpty(message) )   
		{
			Log.v( TAG, "GET message : "+ message );
			
			 
		}

	}
 


}
