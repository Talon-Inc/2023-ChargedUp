// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;
public class AutoMiddle extends CommandBase {
  private Arm arm = null;
  private boolean flag = false;
  /** Creates a new AutoMiddle. */
  public AutoMiddle(Arm arm) {
    this.arm = arm;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    arm.automiddleLimit();
    arm.extend();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    initialize();
    if (arm.m_armMotor.getAppliedOutput() == 0){
      end(true);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    arm.stop();
    flag = true;
    System.out.println("Ended");
    return;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (flag) {
      return true;
    }
    return false;
  }
}
