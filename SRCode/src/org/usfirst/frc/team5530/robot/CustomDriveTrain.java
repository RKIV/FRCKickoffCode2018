package org.usfirst.frc.team5530.robot;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;


public class CustomDriveTrain {
	//Creating Talon Objects
	public static CANTalon rDrive1;
	public static CANTalon rDrive2;
	public static CANTalon lDrive1;
	public static CANTalon lDrive2;
	
	//Constructor that assigns talons and controllers to their respective ports
	CustomDriveTrain(int r1, int r2, int l1, int l2){
		
		rDrive1 = new CANTalon(r1);
		rDrive2 = new CANTalon(r2);
		lDrive1 = new CANTalon(l1);
		lDrive2 = new CANTalon(l2);
		
		lDrive2.changeControlMode(TalonControlMode.Follower);
		lDrive2.set(l1);
		
		rDrive2.changeControlMode(TalonControlMode.Follower);
		rDrive2.set(r1);
		
		lDrive1.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		lDrive1.configEncoderCodesPerRev(1024);
		
		rDrive1.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		rDrive1.configEncoderCodesPerRev(1024);
	}
	
	//Calculates right speed based on controller output
	public double XBControllerR(double lStick, double rTrigger, double lTrigger) {
		//speed of left side = amount Accelerator is pushed down minus
		//amount Deccelerator is pushed down - lateral input from left Joystick
		return rTrigger - lTrigger - lStick;
	}
	
	//Calculates left speed based on Controller output
	public double XBControllerL(double lStick, double rTrigger, double lTrigger){
		//speed of left side = amount Accelerator is pushed down minus
		//amount Deccelerator is pushed down + lateral input from left Joystick
		return rTrigger - lTrigger + lStick;
		
	}
	//Sets the speed for both sides using XBController methods
	public void setSpeeds(double lStick, double rTrigger, double lTrigger){
		
		lDrive1.changeControlMode(TalonControlMode.PercentVbus);
		rDrive1.changeControlMode(TalonControlMode.PercentVbus);
		rDrive1.set(XBControllerR(lStick, rTrigger, lTrigger));
		lDrive1.set(XBControllerL(lStick, rTrigger, lTrigger));
		
		
	}
};
