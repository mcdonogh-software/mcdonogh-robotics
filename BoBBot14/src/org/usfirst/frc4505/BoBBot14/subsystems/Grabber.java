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
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc4505.BoBBot14.Robot;
import org.usfirst.frc4505.BoBBot14.RobotMap;
import org.usfirst.frc4505.BoBBot14.commands.*;
/**
 *
 */
public class Grabber extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController sucker = RobotMap.grabberSucker;
    DoubleSolenoid grabberSolenoid = RobotMap.grabberGrabberSolenoid;
    Compressor compressor = RobotMap.grabberCompressor;
    DoubleSolenoid shooterSolenoid = RobotMap.grabberShooterSolenoid;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    public Grabber() {
        compressor.start();
    }
    
    public void useSucker() {
        if (Robot.oi.getTrigger2()< -.8) {
            grabberSolenoid.set(DoubleSolenoid.Value.kReverse);
            sucker.set(1.0);
        }
        if (Robot.oi.getXboxControllerTwo().getRawButton(5)) {
            grabberSolenoid.set(DoubleSolenoid.Value.kForward);
            sucker.set(0.0);
        }
    }
    
    public void useShooter() {
        if (Robot.oi.getTrigger2() > .8) {
            sucker.set(0.0);
            shooterSolenoid.set(DoubleSolenoid.Value.kForward);
        }
    }
    
    
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new ControlBall());
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
