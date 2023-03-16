// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class ArmDistance extends CommandBase {
  private Arm arm = null;
  private double armrevs, pos;
  /** Creates a new ArmDistance. */
  public ArmDistance(Arm arm, double armrevs) {
    this.arm = arm;
    this.armrevs = armrevs;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    pos = arm.getEncoder() + armrevs;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    arm.moveArm(pos);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    arm.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}