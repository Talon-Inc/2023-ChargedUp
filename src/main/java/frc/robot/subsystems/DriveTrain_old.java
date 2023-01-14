package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class DriveTrain_old {
    private final PWMSparkMax m_leftfrontDrive = new PWMSparkMax(0);
    private final PWMSparkMax m_leftrearDrive = new PWMSparkMax(1);
    private final MotorControllerGroup m_leftDrive = new MotorControllerGroup(m_leftfrontDrive, m_leftrearDrive);

    private final PWMSparkMax m_rightfrontDrive = new PWMSparkMax(2);
    private final PWMSparkMax m_rightrearDrive = new PWMSparkMax(3);
    private final MotorControllerGroup m_rightDrive = new MotorControllerGroup(m_rightfrontDrive, m_rightrearDrive);

    private final DifferentialDrive m_RoboDrive = new DifferentialDrive(m_leftDrive, m_rightDrive);
    private final Timer m_Timer = new Timer();
}
