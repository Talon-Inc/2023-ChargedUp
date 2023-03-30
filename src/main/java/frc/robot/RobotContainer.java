// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static frc.robot.Constants.OperatorConstants.CONTROLLER_PORT;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
    new CommandXboxController(CONTROLLER_PORT);
 
  // Subsystems
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final Arm arm = new Arm();
  private final Drivetrain drivetrain = new Drivetrain();
  private final Intake intake = new Intake();
  private final Limelight limelight = new Limelight();
  private final Sensor sensor = new Sensor(intake.talonMotor());
  private final LEDIndicator ledIndicator = new LEDIndicator();

  // Commands
  private final Balance balance = new Balance(drivetrain, sensor);
  // private final Drive drive = new Drive(drivetrain, m_driverController.getLeftY(), m_driverController.getLeftX());
  private final Drive drive = new Drive(drivetrain, m_driverController);
  private final Noodle noodle = new Noodle(intake);
  private final High highExtend = new High(arm);
  private final Middle middleExtend = new Middle(arm);
  private final Retract retract = new Retract(arm);
  // private final Reverse reverseDrive = new Reverse(drivetrain);
  private final Turbo turbo = new Turbo(drivetrain);
  public final RetractNolimit retractNolimit = new RetractNolimit(arm);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    // new Trigger(pneumatics::isOpenClaw)
    //     .onTrue(new LEDBlack(ledIndicator));

    // new Trigger(pneumatics::isOpenClaw)
    //     .onFalse(new LEDGreen(ledIndicator));

    // Arm buttons
    m_driverController.a().whileTrue(retract);
    m_driverController.start().whileTrue(retractNolimit);
    m_driverController.x().whileTrue(middleExtend);
    m_driverController.y().whileTrue(highExtend);

    // Intake button
    // m_driverController.rightBumper().whileTrue(claw);
    
    // Drive modifier buttons
    m_driverController.leftBumper().whileTrue(balance);
    m_driverController.rightTrigger().whileTrue(turbo);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // Our auto command will be run in autonomous
    // return Autos.exampleAuto(m_exampleSubsystem);
    return Autos.balanceAuto(drivetrain, intake, arm, sensor, ledIndicator);
  }

  /**
   * Use this to pass the drive command to the main {@link Robot} class.
   *
   * @return the drive command to run in teleop
   */
  public Command getDrive() {
    return drive;
  }
}
