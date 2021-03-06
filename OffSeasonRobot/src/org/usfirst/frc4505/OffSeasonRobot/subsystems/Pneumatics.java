// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc4505.OffSeasonRobot.subsystems;
import org.usfirst.frc4505.OffSeasonRobot.RobotMap;
import org.usfirst.frc4505.OffSeasonRobot.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class Pneumatics extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    DoubleSolenoid doubleSolenoid = RobotMap.pneumaticsDoubleSolenoid;
    Compressor compressor = RobotMap.pneumaticsCompressor;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    boolean currentGear;
    
    public Pneumatics() {
        compressor.start();
    }
    
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setHighGear() {
        doubleSolenoid.set(DoubleSolenoid.Value.kForward);
        currentGear = true;
    }
    
    public void setLowGear (){
        doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
        currentGear = false;
    }
    
    public DoubleSolenoid.Value getGear() {
        return doubleSolenoid.get();
    }
    
    public String getGearString() {
        if (getGear() == DoubleSolenoid.Value.kForward)
            return "High Gear";
        return "Low Gear";
    }
}
