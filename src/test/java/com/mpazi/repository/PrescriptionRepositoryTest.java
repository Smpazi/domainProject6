package com.mpazi.repository;

import com.mpazi.domain.medication.Prescription;
import com.mpazi.factory.other.factory.PrescriptionFactory;
import com.mpazi.repository.implementation.other.PrescriptionRepositoryImpl;
import com.mpazi.repository.other.PrescriptionRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PrescriptionRepositoryTest {

    List<Prescription> prescriptions;
    PrescriptionRepository repository;
    Prescription prescription;
    @Before
    public void setUp() throws Exception {
        repository = PrescriptionRepositoryImpl.getRepository();
        prescriptions = new ArrayList();

    }

    @Test
    public void create() throws Exception{
        prescription= PrescriptionFactory.getPrescription("get 2 pack of panado");
        repository.create(prescription);
        assertEquals("get 2 pack of panado",prescription.getPrescriptionAdvice());
    }

    @Test
    public void read() throws Exception {
        prescription = repository.read("2");
        assertEquals("get 2 pack of panado",prescription.getPrescriptionAdvice());
    }

    @Test
    public void update() throws Exception{
        prescription = repository.read("3245");
        Prescription newPre = new Prescription.Builder()
                .prescriptionId(12)
                .prescriptionAdvice("1 pack of panado")
                .build();
        repository.update(newPre);
        assertEquals("1 pack of panado",prescription.getPrescriptionAdvice());
    }

    @Test
    public void delete() throws Exception{
        repository.delete("0");
        Prescription prescription= repository.read("0");
        assertNull(prescription);
    }

}