package com.mpazi.repository.medication;

import com.mpazi.domain.medication.DrugPrescription;
import com.mpazi.factory.medication.factory.DrugPrescriptionFactory;
import com.mpazi.repository.medication.impl.DrugPrescriptionRepositoryImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class DrugPrescriptionRepositoryTest {

    Map<String,String> values;
    DrugPrescriptionRepository repository;

    DrugPrescription drugPrescription;
    @Before
    public void setUp() throws Exception {
        repository = DrugPrescriptionRepositoryImpl.getInstance();
        values = new HashMap<>();
        values.put("drug_prescriptionId","3245");
        values.put("drugName","Panado");

    }

    @Test
    public void create() throws Exception{
         drugPrescription= DrugPrescriptionFactory.getDrugPrescription(values,"Headache");
        repository.create(drugPrescription);
        assertEquals("Headache",drugPrescription.getDrugType());
    }

    @Test
    public void read() throws Exception {
        drugPrescription = repository.read("3245");
        assertEquals("Headache",drugPrescription.getDrugType());
    }

    @Test
    public void update() throws Exception{
        DrugPrescription drugPrescription = repository.read("3245");
        DrugPrescription newDrug = new DrugPrescription.Builder()
                .drug_prescriptionId(values.get("drug_prescriptionId"))
                .drugName(values.get("drugName"))
                .drugType("brain")
                .build();
        repository.update(newDrug);
        DrugPrescription UpdateDrug = repository.read("3245");
        assertEquals("brain",UpdateDrug.getDrugType());
    }

    @Test
    public void delete() throws Exception{
        repository.delete("3245");
        DrugPrescription drugPrescription= repository.read("3245");
        assertNull(drugPrescription);
    }


}