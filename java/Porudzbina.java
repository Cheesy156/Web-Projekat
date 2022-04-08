package com.company;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.UUID;

enum status{obrada, u_pripremi, ceka_dostavljaca, u_transportu, dostavljena, otkazana;}

public class Porudzbina{
    private String uniqueID = UUID.randomUUID().toString();
    private ArrayList<String> poruceni_Artikli;
    private String restoran;

    LocalDateTime vreme = LocalDateTime.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String vreme_formatirano = vreme.format(format);

    private double cena;
    private String kupac; // korisnicko ime

    private status status;
}
