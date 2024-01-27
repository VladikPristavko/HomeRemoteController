package by.vp.homeremotecontroller.Devices;
import lombok.Getter;
@Getter
public enum FanConditions {
    On(0),
    Cool(1),
    Heat(2),
    Fan(3),
    Dry(4),
    Health(5),
    Sleep(6),
    Off(7);
    private final int value;
    FanConditions(int value){
        this.value = value;
    }
}
