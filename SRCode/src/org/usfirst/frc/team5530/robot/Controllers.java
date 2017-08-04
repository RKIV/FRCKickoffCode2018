package org.usfirst.frc.team5530.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;

public class Controllers {
	//Creating Controller Objects
	XboxController XBController;
	Joystick Joystick;
	
	//Setting Controllers to their repecitve ports
	Controllers(int XBPort, int JSPort){
		XBController = new XboxController(XBPort);
		Joystick = new Joystick(JSPort);
		
	}
	
	public double getTriggerValue(char side){
		if(side == 'r'){
			return XBController.getTriggerAxis(Hand.kRight);
		
		}else if(side == 'l'){
			return XBController.getTriggerAxis(Hand.kLeft);
			
		}else{
			return 0;
			
		}
	}
	//A method to limit an input double to the range -1.0 to 1.0
	public double limit(double prelimNumber){
		if(prelimNumber >= 1.0){
			return 1.0;
					
		}else if(prelimNumber <= -1.0){
			
			return -1.0;
		}else if(prelimNumber < 1.0 && prelimNumber >-1.0){
			
			return prelimNumber;
		}else{
			
			return 0;
		}
		
		
	}
	//get xAxis value of Xbox joystick
	public double getStickHorizontal(char side){
		if(side == 'r'){
			return limit(XBController.getX(Hand.kRight));
		
		}else if(side == 'l'){
			return limit(XBController.getY(Hand.kLeft));
			
		}else{
			return 0;
		}
	}
	
};
