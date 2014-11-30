package org.usfirst.frc4505.MecanumBot14.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc4505.MecanumBot14.Robot;
import org.usfirst.frc4505.MecanumBot14.RobotMap;

public class AutoShoot extends Command {
    double start;
    public AutoShoot () {
        requires(Robot.catapult);
        start = Timer.getFPGATimestamp();
    }
    
     protected void initialize() {
         RobotMap.catapultCatapult.set(1);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return (Timer.getFPGATimestamp() - start > SmartDashboard.getNumber("timeToFire"));
    }

    protected void end() {
        RobotMap.catapultCatapult.set(0);
    }

    protected void interrupted() {
        end();
    }
}
