
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.ActivateIntakeRoller;
import edu.wpi.first.wpilibj.templates.commands.FlapWings;
import edu.wpi.first.wpilibj.templates.commands.LaunchBall;
import edu.wpi.first.wpilibj.templates.commands.MoveIntake;
import edu.wpi.first.wpilibj.templates.commands.ShiftGears;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    
    //Define Joysticks
    public Joystick driveStick = new Joystick(RobotMap.DRIVE_JOYSTICK_PORT);
    public Joystick operatorStick = new Joystick(RobotMap.OPERATOR_JOYSTICK_PORT);
    
    //Define Buttons
    Button button1a = new JoystickButton(driveStick, 1),     //A         //Trigger
            button2a = new JoystickButton(driveStick, 2),    //B
            button3a = new JoystickButton(driveStick, 3),    //X
            button4a = new JoystickButton(driveStick, 4),    //Y
            button5a = new JoystickButton(driveStick, 5),    //Left Bumper
            button6a = new JoystickButton(driveStick, 6),    //Right Bumper
            button7a = new JoystickButton(driveStick, 7),    //Back
            button8a = new JoystickButton(driveStick, 8),    //Back
            button9a = new JoystickButton(driveStick, 9),    //Back
            button10a = new JoystickButton(driveStick, 10),    //Start
            button11a = new JoystickButton(driveStick, 11);    //Start
            
    public OI()
    {
        /********  Tuning Launcher  **********/
        /* 
        ***** !SET UP CABLE STOP! *****
        1. Find encoder rate by slowly increasing SAFE_LAUNCH_SPEED
        2. Set the retract rate based on low end of findings
        3. Continue to increase until increase in output no longer happens (find/record max rate)
        4. Adjust Kp up to see if the max is being reached, record new max if applicable
        5. Tune Kp until oscillation, set tolerance %
        6. Add in some Ki
        7. Add in some Kd if necessary
        */
        
        //Use axis to set launcher parameters for tuning
        System.out.println(driveStick.getRawAxis(3));
        RobotMap.setSafeLaunchSpeed(driveStick.getRawAxis(3));
        
        button1a.whenPressed(new LaunchBall("SAFE"));
        button2a.whenPressed(new ActivateIntakeRoller("FORWARD"));
        button3a.whenPressed(new ActivateIntakeRoller("REVERSE"));
        button6a.whenPressed(new MoveIntake("EXTEND"));
        button7a.whenPressed(new MoveIntake("RETRACT"));
        button8a.whenPressed(new ShiftGears("LOW"));
        button9a.whenPressed(new ShiftGears("HIGH"));
        
        
        button10a.whenPressed(new FlapWings("CLOSE"));
        button11a.whenPressed(new FlapWings("OPEN"));
        
        
    }
    
    
    
    
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
}


//        //Checks if override button is pressed
//        if(button5.get() == true)
//        {
//            if(driveStick.getRawAxis(3) >= 114)        //Top of scroll axis
//            {
//                System.out.println("Top of scroll axis!");
//                //button1.whileHeld(new LaunchBall("SAFE"));
//            }
//            else if(driveStick.getRawAxis(3) <= -114)  //Bottom of scroll axis
//            {
//                System.out.println("Bottom of scroll axis!");
//                //button1.whileHeld(new LaunchBall("SAFE"));
//            }
//            else if(driveStick.getRawAxis(3) > -114 && driveStick.getRawAxis(3) < 114) //Middle of scroll axis
//            {
//                System.out.println("Middle of scroll axis!");
//                //button1.whileHeld(new LaunchBall("SAFE"));  //Bottom of scroll axis
//            }
//        }
//        else
//        {
//            System.out.println("Standard Launch!");
//            //button1.whenPressed(new LaunchBall("SAFE"));
//        }
        