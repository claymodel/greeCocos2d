package com.elias.cocostwod.gree;

import net.gree.asdk.api.GreePlatform;
import android.app.Application;

public class greeCocoApplication extends Application {
		@Override
		public void onCreate(){
			super.onCreate();
			GreePlatform.initialize(getApplicationContext(), R.xml.gree_platform_configuration, null);
		}
}
