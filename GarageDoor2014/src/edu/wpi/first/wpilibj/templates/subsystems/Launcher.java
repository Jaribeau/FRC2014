/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Jared
 */
public class Launcher extends Subsystem 
{
    //Initialize Launcher Components
    public Talon launcherMotor1 = new Talon(RobotMap.LAUCNHER_MOTOR_1);
    public Talon launcherMotor2 = new Talon(RobotMap.LAUCNHER_MOTOR_2);
    public Talon launcherMotor3 = new Talon(RobotMap.LAUCNHER_MOTOR_3);
    public Talon launcherMotor4 = new Talon(RobotMap.LAUCNHER_MOTOR_4);
    public Encoder launcherEncoder = new Encoder(RobotMap.LAUNCHER_ENCODER_1, RobotMap.LAUNCHER_ENCODER_2, true);
    public DigitalInput launcherLimitSwitch = new DigitalInput(RobotMap.LAUNCHER_SWITCH);
    
    
    public Launcher()
    {
        launcherEncoder.setDistancePerPulse(1.0);
        launcherEncoder.start();
        launcherEncoder.reset();
    }
    
    //
    public void setSpeed(double speed)
    {
        launcherMotor1.set(-speed);
        launcherMotor2.set(-speed);
        launcherMotor3.set(speed);
        launcherMotor4.set(speed);
    }

    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
