// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc4505.MecanumBot14.commands;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc4505.MecanumBot14.Robot;
import org.usfirst.frc4505.MecanumBot14.RobotMap;
/**
 *
 */
public class  MoveCaptureArms extends Command {
    public MoveCaptureArms() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.grabber);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute(){
        SmartDashboard.putNumber("Arm_Value", Robot.oi.getTrigger2());
        SmartDashboard.putBoolean("Ready to Grab", Robot.grabber.readyToGrab());
        SmartDashboard.putBoolean("Holding Ball", Robot.grabber.hasBall());
        Robot.grabber.moveArms(Robot.oi.getControllerDos().getRawAxis(4), Robot.oi.getControllerDos().getX());
        Robot.grabber.MoveBelts(Robot.oi.getLBumper(), Robot.oi.getRBumper());
        
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
    // Called once after isFinished returns true
    protected void end() {
        RobotMap.grabberLeftArm.set(0);
        RobotMap.grabberRightArm.set(0);
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
    
}
