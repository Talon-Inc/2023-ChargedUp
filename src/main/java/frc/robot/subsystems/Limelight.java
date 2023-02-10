package frc.robot.subsystems;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Limelight extends SubsystemBase{
    
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    public NetworkTableEntry tid = table.getEntry("tid");
   // NetworkTable table = instance.getTable("limelight");

    public Double getTable() {
        double x = tid.getDouble(0.0);
        //NetworkTableEntry tx = table.getEntry("tx");
       return x;
    }
    
    //public NetworkTableEntry tx = table.getEntry("tx");
    //public NetworkTableEntry ty = table.getEntry("ty");
    //public NetworkTableEntry ta = table.getEntry("ta");
    //public NetworkTableEntry aid = table.getEntry("tid");
    //public double x = tx.getDouble(0.0);
    //public double y = ty.getDouble(0.0);
    //public double area = ta.getDouble(0.0);
    //public double id = aid.getDouble(0.0);


    @Override
    public void periodic(){
    }

}
