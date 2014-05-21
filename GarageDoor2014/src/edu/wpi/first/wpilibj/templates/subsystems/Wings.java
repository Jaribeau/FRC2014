/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Jared
 */
public class Wings extends Subsystem 
{
    //Inialize shifter solenoids
    DoubleSolenoid wingsSolenoid = new DoubleSolenoid(RobotMap.WINGS_SOLENOID_A, RobotMap.WINGS_SOLENOID_B);
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void openWings()
    {
        wingsSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void closeWings()
    {
        wingsSolenoid.set(DoubleSolenoid.Value.kForward);
    }
}
