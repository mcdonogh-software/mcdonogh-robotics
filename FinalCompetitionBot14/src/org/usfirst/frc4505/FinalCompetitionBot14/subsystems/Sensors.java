// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc4505.FinalCompetitionBot14.subsystems;
import org.usfirst.frc4505.FinalCompetitionBot14.RobotMap;
import org.usfirst.frc4505.FinalCompetitionBot14.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class Sensors extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    AnalogChannel maxBotixBall = RobotMap.sensorsMaxBotixBall;
    AnalogChannel maxBotixWall = RobotMap.sensorsMaxBotixWall;
    DigitalOutput rgbRed = RobotMap.sensorsRgbRed;
    DigitalOutput rgbGreen = RobotMap.sensorsRgbGreen;
    DigitalOutput rgbBlue = RobotMap.sensorsRgbBlue;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private String LED = "off";
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public double getRangeToWall() {
        double voltage_per_inch_V = (.009765625);
        double measured_Voltage = maxBotixWall.getVoltage();
        double rangeInInches = (int) (measured_Voltage / voltage_per_inch_V);
        return rangeInInches;
    }
    public double getRangeToBall() {
        double voltage_per_inch_V = (.009765625);
        double measured_Voltage = maxBotixBall.getVoltage();
        double rangeInInches = (int) (measured_Voltage / voltage_per_inch_V);
        return rangeInInches;
    }
    public void setColorBlue(boolean setColor) {
        rgbBlue.set(setColor);
    }
    
    public void setColorRed(boolean setColor) {
        rgbRed.set(setColor);
    }
    
    public void setColorGreen(boolean setColor) {
        rgbGreen.set(setColor);
    }
    
    public void setColor(String color) {
        LED = color;
        if (color.equals("red")) {
            rgbRed.set(true);
            rgbGreen.set(false);
            rgbBlue.set(false);
            
        }
        if (color.equals("green")) {
            rgbRed.set(false);
            rgbGreen.set(true);
            rgbBlue.set(false);
        }
        if (color.equals("blue")) {
            rgbRed.set(false);
            rgbGreen.set(false);
            rgbBlue.set(true);
        }
        if (color.equals("yellow")) {
            rgbRed.set(true);
            rgbGreen.set(true);
            rgbBlue.set(false);
        }
        if (color.equals("cyan")) {
            rgbRed.set(false);
            rgbGreen.set(true);
            rgbBlue.set(true);
        }
        if (color.equals("magenta")) {
            rgbRed.set(true);
            rgbGreen.set(false);
            rgbBlue.set(true);
        }
        if (color.equals("white")) {
            rgbRed.set(true);
            rgbGreen.set(true);
            rgbBlue.set(true);
        }
        if (color.equals("off")) {
            rgbRed.set(false);
            rgbGreen.set(false);
            rgbBlue.set(false);
        }
    
    }
    
    public String getColor() {
        return LED;
    }
    
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
