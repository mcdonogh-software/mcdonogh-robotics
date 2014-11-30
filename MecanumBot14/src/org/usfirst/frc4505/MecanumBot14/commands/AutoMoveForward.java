package org.usfirst.frc4505.MecanumBot14.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc4505.MecanumBot14.Robot;
import org.usfirst.frc4505.MecanumBot14.RobotMap;


public class AutoMoveForward extends Command {
    double timeToMoveForward;
    double start;
    public AutoMoveForward() {
        requires(Robot.driveTrain);
    }
    
    protected void initialize() {
        timeToMoveForward = SmartDashboard.getNumber("timeToMoveForward");
        start = Timer.getFPGATimestamp();

    }

    protected void execute() {
        Robot.driveTrain.driveBot(.5, 0, 0);
    }

    protected boolean isFinished() {
        return (Timer.getFPGATimestamp()-start >= timeToMoveForward);
    }

    protected void end() {
        Robot.driveTrain.driveBot(0.0, 0.0, 0.0);
    }
    protected void interrupted() {
        end();
    }
    
}
