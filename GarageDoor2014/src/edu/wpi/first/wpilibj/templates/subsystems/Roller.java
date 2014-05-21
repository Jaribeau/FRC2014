/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Jared
 */
public class Roller extends Subsystem 
{
    Relay intakeRoller = new Relay(RobotMap.INTAKE_ROLLER_RELAY, Relay.Direction.kBoth);
    
    public void setForward()
    {
        intakeRoller.set(Relay.Value.kForward);
    }
    
    public void setReverse()
    {
        intakeRoller.set(Relay.Value.kReverse);
    }
    
    public void setOff()
    {
        intakeRoller.set(Relay.Value.kOff);
    }
    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
