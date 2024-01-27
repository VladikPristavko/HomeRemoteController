package by.vp.homeremotecontroller.Buildings;

import by.vp.homeremotecontroller.Devices.Device;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static by.vp.homeremotecontroller.CommandCreator.*;

@Getter
@Setter
public abstract class Building {
    private final Map<String, Device> devices;
    protected Building(Device... devices){
        this.devices = new HashMap<>();
        int length = devices.length;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            Method[] methods = devices[i].getClass().getDeclaredMethods();
            int methodsLength = methods.length;
            String[] buttons = new String[methodsLength];
            for (int j = methodsLength - 1; j >= 0 ; j--) {
                builder.append(this.getClass().getSimpleName())
                        .append(devices[i].getClass().getSimpleName());
                String methodName = methods[j].getName();
                String command = methodName.substring(0, 1).toUpperCase()
                        + methodName.substring(1);
                buttons[methodsLength - j - 1] = command;
                builder.append(command);
                commands.put(builder.toString(), create(this, methodName, devices[i]));
                builder.delete(0, builder.length());
            }
            labelsAndButtons.put(this.getClass().getSimpleName() + " "
                    + devices[i].getClass().getSimpleName(), buttons);
        }
        Arrays.stream(devices).forEach(device -> {
            String deviceName = device.getClass().getSimpleName();
            this.devices.put(deviceName, device);
        });
        onCreate(this.devices);
    }
    private void onCreate(Map<String, Device> deviceMap){
        System.out.print(
                this.getClass().getSimpleName() +
                        " creates with devices : (");
        deviceMap.keySet().forEach(key -> System.out.print(" " + key));
        System.out.print(" )" + System.lineSeparator());
    }
}
