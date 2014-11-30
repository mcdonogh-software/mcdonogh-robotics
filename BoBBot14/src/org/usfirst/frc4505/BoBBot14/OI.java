// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc4505.BoBBot14;
import org.usfirst.frc4505.BoBBot14.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public Joystick xboxControllerOne;
    public Joystick xboxControllerTwo;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public KinectStick rightArm;
    public KinectStick leftArm;
    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        xboxControllerTwo = new Joystick(2);
        
        xboxControllerOne = new Joystick(1);
        
	    
        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("DriveRobot", new DriveRobot());
        SmartDashboard.putData("ControlBall", new ControlBall());
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        rightArm = new KinectStick(2);
        leftArm = new KinectStick(1);
    }
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getXboxControllerOne() {
        return xboxControllerOne;
    }
    public Joystick getXboxControllerTwo() {
        return xboxControllerTwo;
    }
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public KinectStick getRightArm() {
        return rightArm;
    }
    public KinectStick getLeftArm() {
        return leftArm;
    }
    
    public double getSecondX(){
        return xboxControllerOne.getRawAxis(4);
    }
    
    public double getSecondY(){
        return xboxControllerOne.getRawAxis(5);
    }
    
    public double getTrigger1 () {
        return xboxControllerOne.getRawAxis(3);
    }
    
    public double getTrigger2 () {
        return xboxControllerTwo.getRawAxis(3);
    }
    
    public double getSecondX2 () {
        return xboxControllerTwo.getRawAxis(4);
    }
    
    public double getSecondY2 () {
        return xboxControllerTwo.getRawAxis(5);
    }
    
    public boolean getRBumper () {
        return xboxControllerTwo.getRawButton(6);
    }
    
    public boolean getLBumper () {
        return xboxControllerTwo.getRawButton(5);
    }
}