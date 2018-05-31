package com.a5.mobielbeleven;

import java.io.Serializable;

public class Attraction implements Serializable
{
    String name;
    String type;
    String description_nl;
    String description_en;
    String image;
    String functionType;
    String functionDetails;

    public Attraction(String name, String type, String description_nl, String description_en, String image, String functionType, String functionDetails)
    {
        this.name = name;
        this.type = type;
        this.description_nl = description_nl;
        this.description_en = description_en;
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
    public String getDescription_nl()
    {
        return description_nl;
    }
    public String getDescription_en()
    {
        return description_en;
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
                ", description_nl='" + description_nl + '\'' +
                ", description_en='" + description_en + '\'' +
                ", image='" + image + '\'' +
                ", functionType='" + functionType + '\'' +
                ", functionDetails='" + functionDetails + '\'' +
                '}';
    }
}
