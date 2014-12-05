// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc4505.DriveTrainBuild14.subsystems;
import org.usfirst.frc4505.DriveTrainBuild14.RobotMap;
import org.usfirst.frc4505.DriveTrainBuild14.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc4505.DriveTrainBuild14.Robot;
/**
 *
 */
public class Drivetrain extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController frontLeft = RobotMap.drivetrainFrontLeft;
    SpeedController frontRight = RobotMap.drivetrainFrontRight;
    SpeedController backLeft = RobotMap.drivetrainBackLeft;
    SpeedController backRight = RobotMap.drivetrainBackRight;
    RobotDrive robotDrive = RobotMap.drivetrainRobotDrive;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new DriveRobot());
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void driveRobot() {
        robotDrive.arcadeDrive(Robot.oi.getY()*isCoasting()*slowDown(), Robot.oi.getX()*isCoasting()*slowDown());
        //command to drive robot
    }
    
    public double slowDown() {
        if (Robot.oi.getTrigger() >= 0.8)
            return 0.5;
        return 1.0;
    }
    
    public double isCoasting() {
        if (Robot.oi.getY() <=0.24 || Robot.oi.getX() <= 0.24) {
            return 0.0;
        }
        return 1.0;
    }
}
