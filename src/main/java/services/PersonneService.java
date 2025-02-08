package services;

import models.Personne;
import util.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonneService implements IService<Personne> {
    Connection conn;

    public PersonneService() {
        this.conn = DBConnection.getInstance().getConn();
    }

    @Override
    public void add(Personne personne) {
        String SQL = "insert into personne (prenom, nom, age) values ('" +
                personne.getPrenom() + "','" + personne.getNom() + "','" +
                personne.getAge() + "')";
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(SQL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Personne personne) {

    }

    @Override
    public void delete(Personne personne) {

    }

    @Override
    public List<Personne> getAll() {
        String req = "SELECT * FROM `personne`";
        ArrayList<Personne> personnes = new ArrayList<>();
        Statement stm;
        try {
            stm = this.conn.createStatement();


            ResultSet rs=  stm.executeQuery(req);
            while (rs.next()){
                Personne p = new Personne();
                p.setId(rs.getInt("age"));
                p.setPrenom(rs.getString("prenom"));
                p.setNom(rs.getString("nom"));
                p.setAge(rs.getInt("age"));

                personnes.add(p);
            }


        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }
        return personnes;
    }

}
