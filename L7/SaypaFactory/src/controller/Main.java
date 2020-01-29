package controller;

import model.entity.CarEnt;
import model.servic.CarServ;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            CarServ.getInstance ().save (
                    new CarEnt().setId(1).setName ("Pride").setColor ("white").setprice (40000000).setGearbox("manual"));
            System.out.println ("saved successfully");
        }catch (Exception e){
            System.out.println ("Fail to save!"+e.getMessage ());
        }
        try {
            CarServ.getInstance ().save (
                    new CarEnt().setId(2).setName ("Tiba").setColor ("red").setprice (45000000).setGearbox("manual"));
            System.out.println ("saved successfully");
        }catch (Exception e){
            System.out.println ("Fail to save!"+e.getMessage ());
        }

        try {
            CarServ.getInstance ().edit (
                    new CarEnt().setId(1).setName ("Tiba2").setColor ("black").setprice (50000000).setGearbox("automatic"));
            System.out.println ("edited successfully");
        }catch (Exception e){
            System.out.println ("Fail to edit!"+e.getMessage ());
        }
        try {
            CarServ.getInstance ().remove (2);
            System.out.println ("removed successfully");
        }catch (Exception e){
            System.out.println ("Fail to delete!"+e.getMessage ());
        }
        try {
            List<CarEnt> carList = CarServ.getInstance().report ();
            for (CarEnt carEnt : carList) {
                System.out.println(carEnt.getPrice());
                System.out.println(carEnt.getName());
                System.out.println(carEnt.getColor());
                System.out.println(carEnt.getGearbox());
                System.out.println(carEnt.getId());
            }}
        catch (Exception e){
            System.out.println ("Fail to report!"+e.getMessage ());
        }
    }
}

