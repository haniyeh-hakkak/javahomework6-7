package controller;

import model.entity.CarpetEnt;
import model.servic.CarpetServ;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            CarpetServ.getInstance ().save (
                    new CarpetEnt().setId(1).setModel ("Arghavaan").setTarakom (2550).setShaane (700).setPrice(1480000));
            System.out.println ("saved successfully");
        }catch (Exception e){
            System.out.println ("Fail to save!"+e.getMessage ());
        }

        try {
            CarpetServ.getInstance ().save (
                    new CarpetEnt().setId(2).setModel ("Tandis").setTarakom (3000).setShaane (1200).setPrice(2000000));
            System.out.println ("saved successfully");
        }catch (Exception e){
            System.out.println ("Fail to save!"+e.getMessage ());
        }

        try {
            CarpetServ.getInstance ().save (
                    new CarpetEnt().setId(3).setModel ("Nahaal").setTarakom (2700).setShaane (1000).setPrice(1800000));
            System.out.println ("saved successfully");
        }catch (Exception e){
            System.out.println ("Fail to save!"+e.getMessage ());
        }

        try {
            CarpetServ.getInstance ().edit (
                    new CarpetEnt().setId(1).setModel ("Sheyda").setTarakom (3000).setShaane (1200).setPrice(2300000));
            System.out.println ("edited successfully");
        }catch (Exception e){
            System.out.println ("Fail to edit!"+e.getMessage ());
        }


        try {
            CarpetServ.getInstance ().remove (3);
            System.out.println ("removed successfully");
        }catch (Exception e){
            System.out.println ("Fail to delete!"+e.getMessage ());
        }


        try {
            List<CarpetEnt> carpetList = CarpetServ.getInstance().report ();
            for (CarpetEnt carpetEnt : carpetList) {
                System.out.println(carpetEnt.getModel());
                System.out.println(carpetEnt.getTarakom());
                System.out.println(carpetEnt.getShaane());
                System.out.println(carpetEnt.getPrice());
                System.out.println(carpetEnt.getId());
            }}
        catch (Exception e){
            System.out.println ("Fail to report!"+e.getMessage ());
        }
    }
}

