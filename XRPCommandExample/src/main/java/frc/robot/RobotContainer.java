// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveWithJoystickCommand;
import frc.robot.commands.MoveArmWIthLeftJoystick;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem();
  private final Arm arm = new Arm();
  private final MoveArmWIthLeftJoystick moveArmWIthLeftJoystick = new MoveArmWIthLeftJoystick(arm);
  private final DriveWithJoystickCommand driveWithJoystickCommand= new DriveWithJoystickCommand(drivetrainSubsystem);
  //private final XRPDrivetrain m_xrpDrivetrain = new XRPDrivetrain();
 // private final Arm m_arm = new Arm();

  //private final ExampleCommand m_autoCommand = new ExampleCommand(m_xrpDrivetrain);

  public static XboxController m_driverController = new XboxController(0);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    drivetrainSubsystem.setDefaultCommand(driveWithJoystickCommand);
    arm.setDefaultCommand(moveArmWIthLeftJoystick);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    new JoystickButton(m_driverController, XboxController.Button.kA.value).whileTrue(new RunCommand(() -> arm.ArmSet0()));


  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return driveWithJoystickCommand;
    
  }
}
