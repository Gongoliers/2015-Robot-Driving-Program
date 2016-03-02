package org.usfirst.frc.team5112.robot;

import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends SampleRobot {
	private double initialGyro = 0;
	RobotDrive myRobot;
	Joystick stick;
	Talon FL;
	Talon FR;
	Talon BR;
	Talon BL;
	AnalogGyro gyro;
//	final String defaultAuto = "Default";
//	final String customAuto = "My Auto";
//	SendableChooser chooser;

	public Robot() {
		stick = new Joystick(0);

		FR = new Talon(3);
		FL = new Talon(2);
		BR = new Talon(0);
		BL = new Talon(1);
		gyro = new AnalogGyro(0);
	
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
			double y = stick.getY();
			y = Math.max(-1, y);
			y = Math.min(1, y);
			double rotation = stick.getZ();
			if (Math.abs(rotation) >= 0.1) {
				myRobot.arcadeDrive(3 * Math.copySign(1, y) * Math.pow(y, 2) / 4.0,
						3.0 * Math.copySign(1, stick.getZ()) * Math.pow(stick.getZ(), 2) / 4.0);
				initialGyro = gyro.getAngle();
			} else {
				myRobot.arcadeDrive(3 * Math.copySign(1, y) * Math.pow(y, 2) / 4.0,
						-0.03 * (gyro.getAngle() - initialGyro));
			}
			Timer.delay(0.005);
		}
	}

	public void test() {
	}
}
