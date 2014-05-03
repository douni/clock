package com.example.clock;

import com.example.clock.widget.ClockWidget;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Paint;
import android.view.Menu;

public class MainActivity extends Activity {
	private ClockWidget clockWidget;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		clockWidget = (ClockWidget) this.findViewById(R.id.clock);
		ClockWidget.ParamsBuilder paramsBuilder = new ClockWidget.ParamsBuilder();
		clockWidget.init(paramsBuilder.createClockParams());
	}

}
