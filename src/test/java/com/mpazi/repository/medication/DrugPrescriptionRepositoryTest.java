package com.mpazi.repository.medication;

import com.mpazi.domain.medication.DrugPrescription;
import com.mpazi.factory.medication.factory.DrugPrescriptionFactory;
import com.mpazi.repository.medication.impl.DrugPrescriptionRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class DrugPrescriptionRepositoryTest {

    Map<String,String> values;
    DrugPrescriptionRepository repository;

    DrugPrescription drugPrescription;
    @Before
    public void setUp() throws Exception {
        repository = DrugPrescriptionRepositoryImpl.getRepository();
        values = new HashMap<>();
        values.put("drug_prescriptionId","3245");
        values.put("drugName","Panado");

        this.drugPrescription = DrugPrescriptionFactory.getDrugPrescription(values,"Headache");

    }

    @Test
    public void create() {
        DrugPrescription created = this.repository.create(drugPrescription);
        System.out.println("In create, created = " + created);
        repository.create(created);

        Assert.assertSame(created, this.drugPrescription);
    }

    @Test
    public void read() throws Exception {
        DrugPrescription appoint = new DrugPrescription.Builder()
                .drug_prescriptionId(values.get("drug_prescriptionId"))
                .drugName(values.get("drugName"))
                .build();
        repository.create(appoint);
        DrugPrescription read = repository.read("3245");
        assertEquals("Panado",read.getDrugName()) ;

        System.out.println("In read, read = " +read.getDrugName() );
    }

    @Test
    public void update() throws Exception{
        DrugPrescription newDrug = new DrugPrescription.Builder()
                .drug_prescriptionId(values.get("drug_prescriptionId"))
                .drugName(values.get("drugName"))
                .drugType("Headache")
                .build();
        repository.update(newDrug);
        DrugPrescription UpdateDrug = repository.read("3245");
        assertEquals("Headache",UpdateDrug.getDrugType());
    }

    @Test
    public void delete() throws Exception{
        repository.delete("3245");
        DrugPrescription drugPrescription= repository.read("3245");
        assertNull(drugPrescription);
    }

}