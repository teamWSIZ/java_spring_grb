package wsi.wykop;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class CpuMem {
    public static void main(String[] args) {
        //odczytanie obciazenia systemu za ostatnia minute...
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        double x = operatingSystemMXBean.getSystemLoadAverage();
        System.out.println(x);
    }
}
