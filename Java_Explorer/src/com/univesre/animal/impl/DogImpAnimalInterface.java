//package com.univesre.animal.impl;
package animal.impl;

//import com.univesre.animal.*;
//import com.univesre.annotation.ForthThing;
import animal.*;
import factory.annotation.ForthThing;

public class DogImpAnimalInterface implements AnimalInterface {

    @ForthThing(value = "Lumia")
    private String name;
    private String property;

    public DogImpAnimalInterface() {
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void say() {
        System.out.println("Dog: bark..");
    }

    @Override
    @ForthThing(Property = "水陆两栖战士")
    public void setProperty(String property) {
        this.property = property;
    }

    @Override
    public void getProperty() {
        System.out.println(this.name + this.property);
    }

}
