package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class DriveTrain_old {
    private final PWMSparkMax m_leftfrontDrive = new PWMSparkMax(0);
    private final PWMSparkMax m_leftrearDrive = new PWMSparkMax(1);
    MotorControllerGroup m_leftDrive = new MotorControllerGroup(m_leftfrontDrive, m_leftrearDrive);

    private final PWMSparkMax m_rightfrontDrive = new PWMSparkMax(2);
    private final PWMSparkMax m_rightrearDrive = new PWMSparkMax(3);
    MotorControllerGroup m_rightDrive = new MotorControllerGroup(m_rightfrontDrive, m_rightrearDrive);

    private final DifferentialDrive m_RoboDrive = new DifferentialDrive(m_leftDrive, m_rightDrive);
    private final Timer m_Timer = new Timer();
    /*
     * The code above runs when the robot is first started up. 
     * All the intialization code goes above.
     */
    @Override 
    public void RobotInit(){
        m_rightDrive.setInverted(true);
    /*
     * According to FIRST, we have to "invert one side of the drivetrain so that
     * positive voltages result in both sides moving forward." However, depending 
     * on how the gearbox's are set up, we might have to invert the other side
     * meaning that we change "m_rightDrive" to "m_leftDrive" and leave everything the same.
     */
    }
}
