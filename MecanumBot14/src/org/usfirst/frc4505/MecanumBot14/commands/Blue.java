/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc4505.MecanumBot14.commands;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc4505.MecanumBot14.Robot;
import org.usfirst.frc4505.MecanumBot14.RobotMap;

/**
 *
 * @author Developer
 */
public class Blue extends Command {
    public Blue() {
        requires(Robot.driveTrain);
    }
    protected void initialize() {
        SmartDashboard.putData("BlueIt", this);
  //      boolean blueTeam = true;
  //      SmartDashboard.putBoolean("Team Color", blueTeam); //green if blue, red if red
        Robot.sensors.setColorBlue(false);
        Robot.sensors.setColorRed(false);   
        Robot.sensors.setColorGreen(false);
    }
    protected void execute() {
 //       double start = Timer.getFPGATimestamp();
        DriverStation.Alliance color;
        color = DriverStation.getInstance().getAlliance();
        Robot.sensors.setColorBlue(color == DriverStation.Alliance.kBlue);
        Robot.sensors.setColorBlue(color == DriverStation.Alliance.kRed);
        Robot.sensors.setColorBlue(true);
        Timer.delay(0.05);
        Robot.sensors.setColorBlue(false);
        Robot.sensors.setColorRed(true);
        Timer.delay(0.1);
        Robot.sensors.setColorRed(false);
        Robot.sensors.setColorGreen(true);
        Timer.delay(0.15);
        Robot.sensors.setColorGreen(false);
    }
    protected void end() {
        Robot.sensors.setColorBlue(false);
        Robot.sensors.setColorRed(false);
        Robot.sensors.setColorGreen(false);
    }
    protected boolean isFinished() {
        return false;
    }
    protected void interrupted() {
        
    }
    
}
