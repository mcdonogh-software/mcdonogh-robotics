package org.usfirst.frc4505.MecanumBot14.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc4505.MecanumBot14.Robot;
import org.usfirst.frc4505.MecanumBot14.RobotMap;

public class AutoLowerCatapult extends Command {

    public AutoLowerCatapult() {
        requires(Robot.catapult);
    }

    protected void initialize() {
        RobotMap.catapultCatapult.set(-.2);
        Timer.delay(.5); //placeholder val - CHECK
    }

    protected void execute() {
        RobotMap.catapultCatapult.set(-.24);
    }

    protected boolean isFinished() {
        return !RobotMap.catapultCatapultLimit.get();
    }

    protected void end() {
        RobotMap.catapultCatapult.set(0);
    }

    protected void interrupted() {
        end();
    }
    
}
