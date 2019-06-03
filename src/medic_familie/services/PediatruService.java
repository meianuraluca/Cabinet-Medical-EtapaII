package medic_familie.services;

import medic_familie.Tools.Iesire;
import medic_familie.domain.entity.Copil;
import medic_familie.domain.entity.Pacient;
import medic_familie.domain.entity.Reteta;
import medic_familie.domain.entity.Trimitere;
import medic_familie.domain.entity.Doctor;
import java.util.Scanner;

public class PediatruService {
    public void scrieTrimitere(Copil pacient, Doctor doctor){
        Trimitere trimitere = new Trimitere();
        trimitere.setNume(pacient.getNume());
        trimitere.setPrenume(pacient.getPrenume());
        trimitere.setCabinet(doctor.getCabinetDoctor());
        trimitere.setDoctor(doctor.getNume() + doctor.getPrenume());
        System.out.println("Scrieti diagnosticul ");
        Scanner input1 = new Scanner(System.in);
        String diagnosticul = input1.nextLine();
        System.out.println("Scrieti specialistul ");
        Scanner input = new Scanner(System.in);
        String specialistul = input.nextLine();
        trimitere.setSpecialist(specialistul);
        System.out.println("scrietie locatia ");
        Scanner input2 = new Scanner(System.in);
        String locatia = input2.nextLine();
        trimitere.setLocatie(locatia);
    }
    public void scrieReteta(Pacient pacient, Doctor doctor){
        Reteta reteta = new Reteta();
        reteta.setNume(pacient.getNume());
        reteta.setPrenume(pacient.getPrenume());
        reteta.setCabinet(doctor.getCabinetDoctor());
        reteta.setDoctor(doctor.getNume() + doctor.getPrenume());
        System.out.println("Scrieti diagnosticul ");
        Scanner input1 = new Scanner(System.in);
        String diagnosticul = input1.nextLine();
        System.out.println("Dati pastila recomandata ");
        Scanner input = new Scanner(System.in);
        String pastila = input.nextLine();
        reteta.setPastila(pastila);
        System.out.println("Dati numarul de pastile");
        Scanner input2 = new Scanner(System.in);
        int nr_pastile = input2.nextInt();
        reteta.setNrPastileZi(nr_pastile);
    }
    public void verficaVaccin(Copil pacient){
        Iesire.getInstance().addToFile("Verifica vaccin");
        Iesire.getInstance().addToFile("Verifica vaccin");
        if (pacient.getVarsta() == 4) {
            System.out.println("Copilul trebuie sa faca vaccinul antidifterica");
            int nrVaccinuriActuale =pacient.getNrVaccin();
            nrVaccinuriActuale= nrVaccinuriActuale+1;
            pacient.setNrVaccin(nrVaccinuriActuale);
            String vaccinuriFacute =pacient.getVaccinuri().concat(" ").concat("antidifterica");
            pacient.setVaccinuri(vaccinuriFacute);
        }
        if(pacient.getVarsta() == 7) {
            System.out.println("Copilul trebuie sa faca vaccinul antitetanic");
            int nrVaccinuriActuale =pacient.getNrVaccin();
            nrVaccinuriActuale= nrVaccinuriActuale+1;
            pacient.setNrVaccin(nrVaccinuriActuale);
            String vaccinuriFacute =pacient.getVaccinuri().concat(" ").concat("antitetanic");
            pacient.setVaccinuri(vaccinuriFacute);
        }
        if(pacient.getVarsta()== 9) {
            System.out.println("Copilul trebuie sa faca vaccinul antipoliametic");
            int nrVaccinuriActuale =pacient.getNrVaccin();
            nrVaccinuriActuale= nrVaccinuriActuale+1;
            pacient.setNrVaccin(nrVaccinuriActuale);
            String vaccinuriFacute =pacient.getVaccinuri().concat(" ").concat("antipoliametic");
            pacient.setVaccinuri(vaccinuriFacute);
        }
        if (pacient.getVarsta() == 14) {
            System.out.println("Copilul trebuie sa faca vaccinul antituberculoza");
            int nrVaccinuriActuale =pacient.getNrVaccin();
            nrVaccinuriActuale= nrVaccinuriActuale+1;
            pacient.setNrVaccin(nrVaccinuriActuale);
            String vaccinuriFacute =pacient.getVaccinuri().concat(" ").concat("antituberculoza");
            pacient.setVaccinuri(vaccinuriFacute);
        }
    }
}
