
package org.usfirst.frc4505.MecanumBot14.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc4505.MecanumBot14.Robot;
import org.usfirst.frc4505.MecanumBot14.RobotMap;

/**
 *
 * @author McDonogh Robotics
 */
public class AutoMoveArmsOut extends Command {
    double start;
    public AutoMoveArmsOut() {
        requires(Robot.grabber);
        start = Timer.getFPGATimestamp();
    }
    
    protected void initialize() {
        RobotMap.grabberLeftArm.set(.5);
        RobotMap.grabberRightArm.set(-.5);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return (Timer.getFPGATimestamp() - start > 1.5);
    }

    protected void end() {
        RobotMap.grabberLeftArm.set(0);
        RobotMap.grabberLeftArm.set(0);
    }
    protected void interrupted() {
        end();
    }
}

