package tn.esprit;

import models.Personne;
import services.IService;
import services.PersonneService;

public class Main {
    public static void main(String[] args) {

        IService<Personne> service = new PersonneService();
        Personne p = new Personne(25,"Leao","Rafael");
        Personne p2 = new Personne(32,"Salah","Mohamed");

       service.add(p);


        System.out.println(service.getAll());



    }
}
