import fr.k0bus.k0buslib.updater.Version;

public class TestVersion {
    public void testVersion()
    {
        Version v1 = new Version("1.9.3-RC");
        Version v2 = new Version("1.10.3-SNAPSHOT");
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
