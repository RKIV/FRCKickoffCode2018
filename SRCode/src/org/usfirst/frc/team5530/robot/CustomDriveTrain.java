package org.usfirst.frc.team5530.robot;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;


public class CustomDriveTrain {
	//Creating Talon Objects
	SpeedController rDrive1;
	SpeedController rDrive2;
	SpeedController lDrive1;
	SpeedController lDrive2;
	
	//Constructor that assigns talons and controllers to their respective ports
	CustomDriveTrain(int r1, int r2, int l1, int l2){
		
		rDrive1 = new Talon(r1);
		rDrive2 = new Talon(r2);
		lDrive1 = new Talon(l1);
		lDrive2 = new Talon(l2);
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
		
		rDrive1.set(XBControllerR(lStick, rTrigger, lTrigger));
		rDrive2.set(XBControllerR(lStick, rTrigger, lTrigger));
		lDrive1.set(XBControllerL(lStick, rTrigger, lTrigger));
		lDrive2.set(XBControllerL(lStick, rTrigger, lTrigger));
		
		
	}
	limit
};
