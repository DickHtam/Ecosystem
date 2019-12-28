package com.company;

public class Main {



    public static void main(String[] args) throws Exception {
        EcosystemModel ecosystemModel = new EcosystemModel(15, 15 );
        ecosystemModel.addUnit(10, Plant.class);
        ecosystemModel.addUnit(5, Animal.class);
        EcosystemFrame obj = new EcosystemFrame();
        obj.add(new DisplayEcosystemField(ecosystemModel));
        obj.start();





    }
}
