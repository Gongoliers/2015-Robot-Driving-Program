package org.usfirst.frc.team5112.robot;

import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends SampleRobot {
	RobotDrive myRobot;
	Joystick stick;
	Talon FL;
	Talon FR;
	Talon BR;
	Talon BL;
//	final String defaultAuto = "Default";
//	final String customAuto = "My Auto";
//	SendableChooser chooser;

	public Robot() {
		stick = new Joystick(0);

		FR = new Talon(3);
		FL = new Talon(2);
		BR = new Talon(0);
		BL = new Talon(1);
		
		myRobot = new RobotDrive(BL, BR, FL, FR);
		myRobot.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, false);
		myRobot.setInvertedMotor(RobotDrive.MotorType.kRearLeft, false);
		myRobot.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		myRobot.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);		
	}

	public void robotInit() {
	}

	public void autonomous() {
	}

	public void operatorControl() {
		myRobot.setSafetyEnabled(true);
		while (isOperatorControl() && isEnabled()) {			
			myRobot.arcadeDrive(stick); // drive with arcade style (use right
										// stick)
			Timer.delay(0.005); // wait for a motor update time
		}
	}

	public void test() {
	}
}
