package com.example.spring_test.controllers;

import java.util.ArrayList;
import java.util.List;

public class KompisDAO {
    public List<Kompis> getAllKompisar() {
        List<Kompis> kompisList = new ArrayList<>();
        kompisList.add(new Kompis(1, "Namn1", "Adress1", "000-000 00 00"));
        kompisList.add(new Kompis(2, "Namn2", "Adress2", "111-111 11 11"));
        kompisList.add(new Kompis(3, "Namn3", "Adress3", "222-222 22 22"));
        kompisList.add(new Kompis(4, "Namn4", "Adress4", "333-333 33 33"));
        kompisList.add(new Kompis(5, "Namn5", "Adress5", "444-444 44 44"));
        kompisList.add(new Kompis(6, "Namn6", "Adress6", "555-555 55 55"));
        return kompisList;
    }
}
