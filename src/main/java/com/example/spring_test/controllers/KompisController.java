package com.example.spring_test.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KompisController {
    KompisDAO kompisDAO = new KompisDAO();
    List<Kompis> kompisList = kompisDAO.getAllKompisar();


    @RequestMapping("/kompisar")
    public String index() {
        StringBuilder output = new StringBuilder();
        for (Kompis kompis : kompisList) {
            output.append("Namn: ").append(kompis.getName()).append("<br>Telefon: ").append(kompis.getPhoneNumber()).append("<br>");
        }
        return output.toString();
    }

    @RequestMapping("/kompisar/{id}")
    public String getKompisByID(@PathVariable("id") int id) {
        StringBuilder output = new StringBuilder();
        for (Kompis kompis : kompisList) {
            if (kompis.getId() == id) {
                return output.append("Namn: ").append(kompis.getName()).append("<br>Telefon: ").append(kompis.getPhoneNumber()).toString();
            }
        }
        return "Inkorrekt id";
    }

    @RequestMapping("/kompisar/{id}/delete")
    public Response deleteKompisByID(@PathVariable("id") int id) {
        Response response = new Response("Det fanns ingen kompis med det ID:t", Boolean.FALSE);

        int indexToRemove = -1;
        for (Kompis kompis : kompisList) {
            if (kompis.getId() == id) {
                indexToRemove = kompis.getId();
            }
        }

        if (indexToRemove != -1) {
            kompisList.remove(indexToRemove-1);
            response.setMessage("Kompis borttagen");
            response.setStatus(Boolean.TRUE);
        }
        return response;
    }

    @RequestMapping("/kompisar/add")
    public Response addKompis(@RequestBody Kompis kompis) {
        Response response = new Response("Kompis tillagd", Boolean.FALSE);
        kompisList.add(kompis);
        response.setStatus(Boolean.TRUE);
        return response;
    }

    @RequestMapping("/kompisar/update")
    public Response updateKompis(@RequestBody Kompis kompis) {
        Response response = new Response("Kompis uppdaterad", Boolean.FALSE);
        for (Kompis k:kompisList) {
            if (kompis.getId() == k.getId()) {
                k = kompis;
                response.setStatus(Boolean.TRUE);
                return response;
            }
        }
        kompisList.add(kompis);
        response.setMessage("Kompis tillagd");
        response.setStatus(Boolean.TRUE);
        return response;
    }
}
