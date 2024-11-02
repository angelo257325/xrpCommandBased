// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.xrp.XRPMotor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {

  XRPMotor m_leftMotor = new XRPMotor(0);
  XRPMotor m_rigthMotor = new XRPMotor(1);

  DifferentialDrive differentialDrive = new DifferentialDrive(m_leftMotor, m_rigthMotor);

  /** Creates a new DrivetrainSubsystem. */
  public DrivetrainSubsystem() {
    differentialDrive.setSafetyEnabled(false);
    m_rigthMotor.setInverted(true);
  }

  public void arcadeDrive(double fwd, double rot){
    differentialDrive.arcadeDrive(fwd, rot);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
