package org.usfirst.frc.team5530.robot;

//importing FRC classes
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.XboxController;

//importing custom made classes
import org.usfirst.frc.team5530.robot.CustomDriveTrain;
import org.usfirst.frc.team5530.robot.Controllers;

public class Robot extends SampleRobot {
	final String defaultAuto = "Default";
	final String customAuto = "My Auto";
	SendableChooser<String> chooser = new SendableChooser<>();
	//CustomDriveTrain Object with Args Talon port r1, r2, l1, l2
	CustomDriveTrain DriveTrain = new CustomDriveTrain(0, 1, 2, 3);
	//Controllers with Args Xbox Port, Joystick Port
	Controllers controllers = new Controllers(0,1);
	
	public Robot() {
		
	}

	@Override
	public void robotInit() {
		chooser.addDefault("Default Auto", defaultAuto);
		chooser.addObject("My Auto", customAuto);
		SmartDashboard.putData("Auto modes", chooser);
	}

	@Override
	public void autonomous() {
		String autoSelected = chooser.getSelected();
		System.out.println("Auto selected: " + autoSelected);

	}

	@Override
	public void operatorControl() {
		while(isOperatorControl()&&isEnabled()){
			//set speeds of motors using output from Controllers class
			DriveTrain.setSpeeds(controllers.getStickHorizontal('l'), controllers.getTriggerValue('r'), controllers.getTriggerValue('l'));
	
		}
	}	

	@Override
	public void test() {
	}
}
