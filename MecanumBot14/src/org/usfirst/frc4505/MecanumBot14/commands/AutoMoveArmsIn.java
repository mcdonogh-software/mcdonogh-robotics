
package org.usfirst.frc4505.MecanumBot14.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc4505.MecanumBot14.Robot;
import org.usfirst.frc4505.MecanumBot14.RobotMap;

/**
 *
 * @author McDonogh Robotics
 */
public class AutoMoveArmsIn extends Command {

    public AutoMoveArmsIn() {
        requires(Robot.grabber);
    }
    
    protected void initialize() {
        RobotMap.grabberLeftArm.set(-.5);
        RobotMap.grabberRightArm.set(.5);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return !(RobotMap.grabberBackLArmLimit.get() && RobotMap.grabberBackRArmLimit.get());
    }

    protected void end() {
        RobotMap.grabberLeftArm.set(0);
        RobotMap.grabberLeftArm.set(0);
    }
    protected void interrupted() {
        end();
    }
    
}

