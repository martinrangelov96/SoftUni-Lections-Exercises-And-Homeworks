package exercise08_petClinics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Clinic> clinics = new HashMap<>();
        Map<String, Pet> pets = new HashMap<>();

        int numberOfLines = Integer.parseInt(reader.readLine());
        while (numberOfLines-- > 0) {
            String[] input = reader.readLine().split("\\s+");
            String command = input[0];
            String clinicName = null;
            Clinic clinic = null;
            switch (command) {
                case "Create":
                    String petOrClinic = input[1];
                    switch (petOrClinic) {
                        case "Pet":
                            String petName = input[2];
                            int petAge = Integer.parseInt(input[3]);
                            String petKind = input[4];
                            Pet pet = new Pet(petName, petAge, petKind);
                            pets.put(petName, pet);
                            break;
                        case "Clinic":
                            clinicName = input[2];
                            int clinicRooms = Integer.parseInt(input[3]);
                            try {
                                clinic = new Clinic(clinicName, clinicRooms);
                                clinics.put(clinicName, clinic);
                            } catch (IllegalArgumentException iae) {
                                System.out.println(iae.getMessage());
                            }
                            break;
                    }
                    break;
                case "Add":
                    String petName = input[1];
                    clinicName = input[2];

                    Pet pet = pets.get(petName);
                    clinic = clinics.get(clinicName);
                    try {
                        System.out.println(clinic.addPetToClinic(pet));
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "Release":
                    clinicName = input[1];
                    clinic = clinics.get(clinicName);
                    clinic.releasePet();
                    break;
                case "HasEmptyRooms":
                    clinicName = input[1];
                    clinic = clinics.get(clinicName);
                    System.out.println(clinic.hasEmptyRooms());
                    break;
                case "Print":
                    clinicName = input[1];
                    clinic = clinics.get(clinicName);
                    if (input.length == 2) {
                        clinic.printAllRooms();
                    } else if (input.length == 3) {
                        int roomNumber = Integer.parseInt(input[2]);
                        clinic.printRoom(roomNumber);
                    }
                    break;
            }
        }
    }
}
