/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.templates.commands.Auton_Default_OneBallSweetSpot;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
//import edu.wpi.first.wpilibj.templates.commands.Auton_Test;
//import edu.wpi.first.wpilibj.templates.commands.Auton_TwoBallSweetSpot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot3756 extends IterativeRobot {

    Command autonomousCommand;
    SendableChooser autoChooser;
    Compressor compressor;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit()
    {        
        // instantiate the command used for the autonomous period        
//        autoChooser = new SendableChooser();
//        autoChooser.addDefault("Default - One ball, Sweet Spot", new Auton_Default_OneBallSweetSpot());
//        autoChooser.addObject("TEST", new Auton_Test());
//        autoChooser.addObject("2 Ball - UNTESTED", new Auton_TwoBallSweetSpot());
//        SmartDashboard.putData("Autonomous Mode Chooser", autoChooser);
        
        compressor = new Compressor(RobotMap.PRESSURE_SWITCH, RobotMap.COMPRESSOR_RELAY);
        compressor.start();

        // Initialize all subsystems
        CommandBase.init();
    }

    public void autonomousInit()
    {
        // schedule the autonomous command (example)
//        autonomousCommand = (Command) autoChooser.getSelected();
//        autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() 
    {
        Scheduler.getInstance().run();
    }

    public void teleopInit() 
    {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() 
    {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() 
    {
        LiveWindow.run();
    }
}//End of Swiggity Swag class
//My name is James Wood 
