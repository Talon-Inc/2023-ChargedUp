package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;



public class Arm {
    public class Robot extends TimedRobot {
        private Joystick m_stick;
        private static final int deviceID = 1;
        private CANSparkMax m_motor;
    } 
}
   