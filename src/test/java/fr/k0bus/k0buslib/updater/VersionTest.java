package fr.k0bus.k0buslib.updater;

import junit.framework.TestCase;

public class VersionTest extends TestCase {
    public void test()
    {
        Version v1 = new Version("4.6");
        Version v2 = new Version("4.6.16");
        System.out.println(v2.compareTo(v1));

        if(v2.compareTo(v1) >= 0)
        {
            System.out.println("Latest version !");
        }
        else
        {
            System.out.println("Please update !");
        }
    }
}