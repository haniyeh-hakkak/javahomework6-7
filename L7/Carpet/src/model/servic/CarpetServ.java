package model.servic;

import model.entity.CarpetEnt;
import model.repository.CarpetRepo;

import java.util.List;

public class CarpetServ {

    private CarpetServ(){
    }
    public static CarpetServ carpetServ =new CarpetServ();

    public static CarpetServ getInstance() {
        return carpetServ;
    }
    public void save(CarpetEnt carpetEnt) throws Exception {
        try (CarpetRepo carpetRepo = new CarpetRepo()) {
            carpetEnt.setPrice(carpetEnt.getPrice() + (carpetEnt.getPrice() * 20 / 100));
            carpetRepo.insert(carpetEnt);
            carpetRepo.commit();
        }
    }
        public void edit(CarpetEnt carpetEnt) throws Exception{
            try (CarpetRepo carpetRepo=new CarpetRepo()){
                carpetRepo.update (carpetEnt);
                carpetRepo.commit ();
            }
        }
        public void remove(long id) throws Exception{
            try (CarpetRepo carpetRepo=new CarpetRepo()){
                carpetRepo.delete (id);
                carpetRepo.commit ();
            }
        }
        public List<CarpetEnt> report() throws Exception{
            List<CarpetEnt> carpetEnts;
            try (CarpetRepo carpetRepo=new CarpetRepo()){
                carpetEnts=carpetRepo.select ();
            }
            return carpetEnts;
        }
    }
