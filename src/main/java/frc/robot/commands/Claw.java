// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LEDIndicator;
import frc.robot.subsystems.Pneumatics;

public class Claw extends CommandBase {
  private Pneumatics pneumatics = null;
  private LEDIndicator ledIndicator = null;
  private boolean flag = false;

  /** 
   * Creates a new Claw command.
   * 
   * @param pneumatics Gets the Pneumatics subsystem
   */
  public Claw(Pneumatics pneumatics, LEDIndicator ledIndicator) {
    this.pneumatics = pneumatics;
    this.ledIndicator = ledIndicator;
    // Use addRequirements() here to declare subsystem dependencies.
    //addRequirements(pneumatics);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //pneumatics.closeClaw();
    pneumatics.toggleclaw();
    if (pneumatics.isOpenClaw()) {
      ledIndicator.setYellow();
    } else {
      ledIndicator.setGreen();
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //pneumatics.openClaw();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
