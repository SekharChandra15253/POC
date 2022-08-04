package dataProvider;

import enums.DriverType;
import enums.EnvironmentType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader
{
    private Properties properties;
    private final String propertyFilePath = "Configs//configuration.properties";

    public ConfigFileReader()
    {
        BufferedReader reader;

        try
        {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties  = new Properties();
            try {
                properties.load(reader);
                reader.close();
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }catch (FileNotFoundException e)
        {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties file not found....");
        }

    }

    public String getDriverPath()
    {
        String driverpath = properties.getProperty("driverPath");
        if (driverpath!=null) return driverpath;
        else throw new RuntimeException("driver path is not specified....");
    }

    public int getImplicitWait()
    {
        String implcit = properties.getProperty("implicitWait");
        if (implcit!=null) return Integer.parseInt(implcit);
        else throw new RuntimeException("Implicit wait  is not specified....");
    }

    public String getAppURL()
    {
        String URL =  properties.getProperty("url");
        if (URL!=null) return URL;
        else throw new RuntimeException("App URL is not available");
    }

    public DriverType getBrowser()
    {
        String browserName = properties.getProperty("browser");
        if (browserName==null || browserName.equalsIgnoreCase("chrome"))
            return DriverType.CHROME;
        else if (browserName.equalsIgnoreCase("firefox"))
            return DriverType.FIREFOX;
        else if (browserName.equalsIgnoreCase("internetexplorer"))
            return DriverType.INTERNETEXPLORER;
        else throw new RuntimeException("Entered Browser is not available");
    }

    public EnvironmentType getEnvironment()
    {
        String environmentName = properties.getProperty("environment");
        if (environmentName==null || environmentName.equalsIgnoreCase("local"))
            return EnvironmentType.LOCAL;
        else if (environmentName.equalsIgnoreCase("remote"))
            return EnvironmentType.REMOTE;
        else throw new RuntimeException("Entered Environment is not available");
    }

    public String getReportConfigPath()
    {
        String reportConfigPath = properties.getProperty("reportConfigPath");
        if (reportConfigPath!=null) return reportConfigPath;
        else throw new RuntimeException("Path doesn't exists");
    }
}
