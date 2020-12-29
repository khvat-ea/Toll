package jdev.servercore.db;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Points_Device")
public class PointDevice {
    @Id
    @Column(name = "time_point_taken")
    Long timePoint;

    @Column(name = "id_device")
    private int idDevice;

    @Column(name = "coords")
    String coords;

    @Override
    public String toString() {
        return "PointGPS{" +
                ", time='" + timePoint +
                ", idDevice='" + idDevice +
                ", autoId='" + coords +
                "'}";
    }

    public long getTimePoint() {
        return timePoint;
    }
    public void setTimePoint(long timePoint) {
        this.timePoint = timePoint;
    }

    public int getIdDevice() {return idDevice;}
    public void setIdDevice(int idDevice) {
        this.idDevice = idDevice;
    }

    public String getCoords(){return coords;}
    public void setCoords(String coords) {
        this.coords = coords;
    }

    public PointDevice(){ }
    public PointDevice(
            long timePoint,
            int idDevice,
            String coords
    ){
        this.idDevice = idDevice;
        this.timePoint = timePoint;
        this.coords = coords;
    }

}
