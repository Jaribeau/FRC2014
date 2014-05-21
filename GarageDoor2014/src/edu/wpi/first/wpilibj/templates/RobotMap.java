package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    
    //NOTE!! The "RobotMap" is for setting up constants for the ports of each 
    //  component. The actual components will be initialized in their respective
    //  subsystem classes.
    
    
    /*******************************************/
    /************* PARAMETERS ******************/
    /*******************************************/
    
    //Auton Vars
    public static boolean hot = false;
    
    
    //Global Parameters
    public static final double LONG_LAUNCH_TIME = 0.1;      //Long Ball
    public static final double LONG_LAUNCH_POWER = 0.25;
    
    public static final double TRUSS_LAUNCH_TIME = 0.1;     //Truss
    public static final double TRUSS_LAUNCH_POWER = 1.0;
    
    public static final double SAFE_LAUNCH_TIME = 0.5;      //Sweet spot shot
    public static double SAFE_LAUNCH_SPEED = 0.25;
    public static final double SAFE_LAUNCH_STOP_POINT = 300;
    
    public static final double SHORT_PASS_TIME = 1.0;       //Pass
    public static final double SHORT_PASS_POWER = 0.5;
    
    public static final double RETRACT_TIME = 0.5;          //Launcher retract
    public static final double RETRACT_POWER = -0.1;
    
    //Auton Parameters
    public static final int TICKS_PER_FOOT = 1600;
    public static final int GYRO_HEADING_KP = 1;
    
    
    /*******************************************/
    /************* JOY STICKS ******************/
    /*******************************************/
    public static final int DRIVE_JOYSTICK_PORT = 1;
    public static final int OPERATOR_JOYSTICK_PORT = 2;
    
    
    /*******************************************/
    /***************** PWM *********************/
    /*******************************************/
    //Left Drive
    public static final int LEFT_DRIVE_MOTOR_1 = 1;
    public static final int LEFT_DRIVE_MOTOR_2 = 2;
    public static final int LEFT_DRIVE_MOTOR_3 = 3;
    //Right Drive
    public static final int RIGHT_DRIVE_MOTOR_1 = 4;
    public static final int RIGHT_DRIVE_MOTOR_2 = 5;
    public static final int RIGHT_DRIVE_MOTOR_3 = 6;
    
    //Launcher
    public static final int LAUCNHER_MOTOR_1 = 7;
    public static final int LAUCNHER_MOTOR_2 = 8;
    public static final int LAUCNHER_MOTOR_3 = 9;
    public static final int LAUCNHER_MOTOR_4 = 10;
    
    
    /*******************************************/
    /************** Digital IO *****************/
    /*******************************************/
    public static final int LEFT_DRIVE_ENCODER_1 = 1;
    public static final int LEFT_DRIVE_ENCODER_2 = 2;
    public static final int RIGHT_DRIVE_ENCODER_1 = 3;
    public static final int RIGHT_DRIVE_ENCODER_2 = 4;
    
    public static final int LAUNCHER_ENCODER_1 = 5;
    public static final int LAUNCHER_ENCODER_2 = 6;
    
    public static final int PRESSURE_SWITCH = 7;
    public static final int LAUNCHER_SWITCH = 8;
    
    
    /*******************************************/
    /************** Analog IO *****************/
    /*******************************************/
    public static final int GYRO = 1;
    
    
    /*******************************************/
    /*************** Relays ****************/
    /*******************************************/
    public static final int COMPRESSOR_RELAY = 2;
    public static final int INTAKE_ROLLER_RELAY = 3;
    
    
    /*******************************************/
    /*************** Solenoids *****************/
    /*******************************************/
    public static final int INTAKE_SOLENOID_A = 1;
    public static final int INTAKE_SOLENOID_B = 2;  
    public static final int SHIFTERS_SOLENOID_A = 3;
    public static final int SHIFTERS_SOLENOID_B = 4;
    public static final int WINGS_SOLENOID_A = 5;
    public static final int WINGS_SOLENOID_B = 6;
    
    public static void setSafeLaunchSpeed(double speed)
    {
        SAFE_LAUNCH_SPEED = speed;
    }
    
}//End of RobotMap class
