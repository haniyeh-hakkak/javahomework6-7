package model.servic;

import model.entity.CarEnt;
import model.repository.CarRepo;

import java.util.List;

public class CarServ {

    private CarServ(){
    }
    public static CarServ carServ=new CarServ();

    public static CarServ getInstance() {
        return carServ;
    }
    public void save(CarEnt carEnt) throws Exception {
        try (CarRepo carRepo = new CarRepo()) {
            carEnt.setprice(carEnt.getPrice() + (carEnt.getPrice() * 30 / 100));
            carRepo.insert(carEnt);
            carRepo.commit();
        }
    }
        public void edit(CarEnt carEnt) throws Exception{
            try (CarRepo carRepo=new CarRepo()){
                carRepo.update (carEnt);
                carRepo.commit ();
            }
        }
        public void remove(long id) throws Exception{
            try (CarRepo carRepo=new CarRepo()){
                carRepo.delete (id);
                carRepo.commit ();
            }
        }
        public List<CarEnt> report() throws Exception{
            List<CarEnt> carEnts;
            try (CarRepo carRepo=new CarRepo()){
                carEnts=carRepo.select ();
            }
            return carEnts;
        }
    }
