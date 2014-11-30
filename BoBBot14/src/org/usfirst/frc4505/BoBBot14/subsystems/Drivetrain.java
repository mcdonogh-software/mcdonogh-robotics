// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc4505.BoBBot14.subsystems;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc4505.BoBBot14.Robot;
import org.usfirst.frc4505.BoBBot14.RobotMap;
import org.usfirst.frc4505.BoBBot14.commands.*;
/**
 *
 */
public class Drivetrain extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController frontLeftWheel = RobotMap.drivetrainFrontLeftWheel;
    SpeedController backLeftWheel = RobotMap.drivetrainBackLeftWheel;
    SpeedController frontRightWheel = RobotMap.drivetrainFrontRightWheel;
    SpeedController backRightWheel = RobotMap.drivetrainBackRightWheel;
    RobotDrive mecanumDrive = RobotMap.drivetrainMecanumDrive;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public void driveBot(double magnitude, double direction, double rotation){
        mecanumDrive.mecanumDrive_Polar(slowDown(magnitudethreshold(magnitude)), reverseDirection(directionthreshold(direction)), slowDown(rotationthreshold(rotation)));
    }
    
    public double magnitudethreshold (double magnitude) {
        if(magnitude > .24){
            return magnitude;
        }
        else{
            return 0;
        }
    }
    
     public double rotationthreshold (double rotation) {
        return ((rotation > .2) || (rotation < -.2)) ? rotation*.7: 0;
    }
    
    public double directionthreshold (double direction) {
    //needs to account for right, left, up, and down
        if ((direction > 160) || (direction < -160))
            return 179.999999; //can you even do 180? doubt it
        if ((direction > 70) && (direction < 110))
            return 90;
        if ((direction < -70) && (direction > -110))
            return -90;
        if ((direction > -20) && (direction < 20))
            return 0;
        return direction;
    }
    
    public double reverseDirection (double direction) {
        if (Robot.oi.getXboxControllerOne().getRawButton(5)){
            if(direction == 179.99999)
                return 0;
            if (direction == 90)
                return -90;
            if (direction == -90)
                return 90;
            if (direction == 0)
                return 179.999999;
            if (direction > 0)
                return (direction-180)%360;
            if (direction < 0)
                return (direction+180)%360;
        }
        return direction;
    }
     
    public double slowDown(double initialValue) {
        return (Robot.oi.getTrigger1() < -.5) ? (initialValue * .5) : (Robot.oi.getTrigger1() > .5) ? (initialValue * .6) : initialValue;
    } 
    public void autoMoveFirstForward() {
        for (int i=100; i <=0; i--) {
            mecanumDrive.mecanumDrive_Polar(i/100.0, 0.0, 0.0);
            Timer.delay(3.0/100.0);
        }
    }
    public void autoMoveForward(double time, double pwr) {
        double start = Timer.getFPGATimestamp();
        while (Timer.getFPGATimestamp()-start < time) {
            mecanumDrive.mecanumDrive_Polar(pwr, 0.0, 0.0);
        }
        mecanumDrive.mecanumDrive_Polar(0.0, 0.0, 0.0);
    }
    public void autoMoveBackward (double time, double pwr) {
        double start = Timer.getFPGATimestamp();
        while (Timer.getFPGATimestamp()-start < time) {
            mecanumDrive.mecanumDrive_Polar(pwr, 179.999999, 0.0);
        }
        mecanumDrive.mecanumDrive_Polar(0.0, 0.0, 0.0);
    }
    
    public void autoMoveLeft (double time, double pwr) {
        double start = Timer.getFPGATimestamp();
        while (Timer.getFPGATimestamp()-start < time) {
            mecanumDrive.mecanumDrive_Polar(pwr, -90.0, 0.0);
        }
        mecanumDrive.mecanumDrive_Polar(0.0, 0.0, 0.0);
    }
    
    public void autoMoveRight (double time, double pwr) {
        double start = Timer.getFPGATimestamp();
        while (Timer.getFPGATimestamp()-start < time) {
            mecanumDrive.mecanumDrive_Polar(pwr, 90.0, 0.0);
        }
        mecanumDrive.mecanumDrive_Polar(0.0, 0.0, 0.0);
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new DriveRobot());
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}