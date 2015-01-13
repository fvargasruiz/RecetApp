package dad.recetapp.ui.utils;

import java.util.TimerTask;

import javafx.application.Platform;

public abstract class Timer extends java.util.Timer {
	
	private long delay, period;
	
	public Timer(long delay, long period) {
		super();
		this.delay = delay;
		this.period = period;
	}
	
	public void start() {
		scheduleAtFixedRate(new TimerTask() {
			public void run() {
				Platform.runLater(new Runnable() {
					public void run() {
						task();
					}
				});
			}
		}, delay, period);
	}
	
	protected abstract void task();

}
