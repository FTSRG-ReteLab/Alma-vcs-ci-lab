package hu.bme.mit.train.interfaces;

public interface TrainUser {

	int getJoystickPosition();

	boolean getAlarmFlag();

	void overrideJoystickPosition(int joystickPosition);
	
	public boolean getALarmState();
	
	public void setAlarmState(boolean alarmState);

}
