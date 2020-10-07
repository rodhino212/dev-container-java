package io.github.rodhino212.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;

@Entity
public class Etudiant 
{


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer Id;

    public String Nom;

    public String Prenom;

    public LocalDate date_naissance;

    public String Telephone;

@Override
public String toString(){
return String.format("[%d] %s %s", Id, Prenom, Nom);
}


private static final String persistenceUnitName="mabase-unit";
private static EntityManagerFactory factory;

    public static void main( String[] args )
    {
        factory = Persistence.createEntityManagerFactory(persistenceUnitName);

        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        Etudiant etu = new Etudiant();

        etu.Nom="Billy";
        etu.Prenom="Tomy";
        etu.date_naissance=LocalDate.of(2002, 07, 14);
        etu.Telephone="0696124578";

        em.persist(etu);
        em.getTransaction().commit();
        List<Etudiant> liste_etu = em.createQuery("select e from Etudiant e", Etudiant.class).getResultList();


        for (Etudiant e : liste_etu) {

          System.out.println(e);

        }

        em.close();
    }
    
}

