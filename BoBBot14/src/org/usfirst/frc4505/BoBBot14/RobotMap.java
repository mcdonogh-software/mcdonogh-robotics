// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc4505.BoBBot14;
    
import edu.wpi.first.wpilibj.*;
 import edu.wpi.first.wpilibj.livewindow.LiveWindow;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController drivetrainFrontLeftWheel;
    public static SpeedController drivetrainBackLeftWheel;
    public static SpeedController drivetrainFrontRightWheel;
    public static SpeedController drivetrainBackRightWheel;
    public static RobotDrive drivetrainMecanumDrive;
    public static SpeedController grabberSucker;
    public static DoubleSolenoid grabberGrabberSolenoid;
    public static Compressor grabberCompressor;
    public static DoubleSolenoid grabberShooterSolenoid;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        drivetrainFrontLeftWheel = new Victor(1, 1);
	LiveWindow.addActuator("Drivetrain", "Front Left Wheel", (Victor) drivetrainFrontLeftWheel);
        
        drivetrainBackLeftWheel = new Victor(1, 2);
	LiveWindow.addActuator("Drivetrain", "Back Left Wheel", (Victor) drivetrainBackLeftWheel);
        
        drivetrainFrontRightWheel = new Victor(1, 3);
	LiveWindow.addActuator("Drivetrain", "Front Right Wheel", (Victor) drivetrainFrontRightWheel);
        
        drivetrainBackRightWheel = new Victor(1, 4);
	LiveWindow.addActuator("Drivetrain", "Back Right Wheel", (Victor) drivetrainBackRightWheel);
        
        drivetrainMecanumDrive = new RobotDrive(drivetrainFrontLeftWheel, drivetrainBackLeftWheel,
              drivetrainFrontRightWheel, drivetrainBackRightWheel);
	
        drivetrainMecanumDrive.setSafetyEnabled(true);
        drivetrainMecanumDrive.setExpiration(0.1);
        drivetrainMecanumDrive.setSensitivity(0.5);
        drivetrainMecanumDrive.setMaxOutput(1.0);
        drivetrainMecanumDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        drivetrainMecanumDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        grabberSucker = new Jaguar(1, 10);
	LiveWindow.addActuator("Grabber", "Sucker", (Jaguar) grabberSucker);
        
        grabberGrabberSolenoid = new DoubleSolenoid(1, 7, 8);      
	
        
        grabberCompressor = new Compressor(1, 1, 1, 1);
	
        
        grabberShooterSolenoid = new DoubleSolenoid(1, 5, 6);      
	
        
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}