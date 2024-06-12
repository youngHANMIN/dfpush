
package com.anyone.demo;

import com.anyone.message.dfpush ;

import android.app.Activity;
import android.content.Context;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.util.Log ;


public class main extends Activity
{
  
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
 		
 		setContentView(R.layout.main);
 		
		TextView mtext = (TextView)findViewById(R.id.mtext);
 
 		if( dfpush.register( this ) )
		{
			mtext.setText( "dfpush service found" );
		}
		else
		{
			mtext.setText( "dfpush service not found" );
		}
		
		 
		
	}

 
 
}
