
package org.usfirst.frc4505.FinalCompetitionBot14.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc4505.FinalCompetitionBot14.Robot;

/**
 *
 * @author Developer
 */
public class WhiteLight extends Command {
    public WhiteLight() {
        requires(Robot.drivetrain);
    }
    protected void initialize() {
  //      boolean blueTeam = true;
  //      SmartDashboard.putBoolean("Team Color", blueTeam); //green if blue, red if red
        Robot.sensors.setColorBlue(false);
        Robot.sensors.setColorRed(false);   
        Robot.sensors.setColorGreen(false);
        Robot.sensors.setColor("white");
    }
    protected void execute() {
         Robot.drivetrain.driveBot(Robot.oi.xboxControllerOne.getMagnitude(), Robot.oi.xboxControllerOne.getDirectionDegrees(), Robot.oi.getSecondX());
    }
    protected void end() {
//        Robot.sensors.setColorBlue(false);
//        Robot.sensors.setColorRed(false);
//        Robot.sensors.setColorGreen(false);
    }
    protected boolean isFinished() {
        return false;
    }
    protected void interrupted() {
        
    }
    
}
