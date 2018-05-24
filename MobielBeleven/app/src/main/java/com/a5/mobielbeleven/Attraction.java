package com.a5.mobielbeleven;

import java.io.Serializable;

public class Attraction implements Serializable
{
    String name;
    String type;
    String description;
    String image;
    String functionType;
    String functionDetails;

    public Attraction(String name, String type, String description, String image, String functionType, String functionDetails)
    {
        this.name = name;
        this.type = type;
        this.description = description;
        this.image = image;
        this.functionType = functionType;
        this.functionDetails = functionDetails;
    }

    public String getName()
    {
        return name;
    }
    public String getType()
    {
        return type;
    }
    public String getDescription()
    {
        return description;
    }
    public String getImage()
    {
        return image;
    }
    public String getFunctionType()
    {
        return functionType;
    }
    public String getFunctionDetails()
    {
        return functionDetails;
    }

    @Override
    public String toString()
    {
        return "Attraction{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", functionType='" + functionType + '\'' +
                ", functionDetails='" + functionDetails + '\'' +
                '}';
    }
}
