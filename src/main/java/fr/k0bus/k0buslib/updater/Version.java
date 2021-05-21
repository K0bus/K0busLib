package fr.k0bus.k0buslib.updater;

import fr.k0bus.k0buslib.utils.Math;

import java.util.ArrayList;
import java.util.List;

public class Version implements Comparable<Version>{

    List<Integer> num = new ArrayList<>();
    VersionType type;

    public Version(String version)
    {
        for (VersionType vType:VersionType.values()) {
            String v = version.toLowerCase();
            if(v.contains(vType.getName()))
            {
                this.type = vType;
                break;
            }
        }
        if(type == null)
            type = VersionType.RELEASE;
        version = version.replaceAll("[^\\d.]", "");
        String[] args = version.split("\\.");
        for (String v:args) {
            if(Math.isInteger(v))
            {
                num.add(Integer.parseInt(v));
            }
        }
    }

    @Override
    public int compareTo(Version toCompare) {
        if(toCompare == null)
            return 1;
        int i = 0;
        for (int n : num) {
            int compare = toCompare.num.get(i);
            if(n > compare)
                return 1;
            if(n < compare)
                return -1;
            i++;
        }
        if(type.level < toCompare.type.level)
            return -1;
        else if(type.level > toCompare.type.level)
            return 1;
        return 0;
    }
}
