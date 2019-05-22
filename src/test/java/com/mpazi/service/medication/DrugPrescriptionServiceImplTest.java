package com.mpazi.service.medication;

import com.mpazi.domain.medication.DrugPrescription;
import com.mpazi.factory.medication.factory.DrugPrescriptionFactory;
import com.mpazi.repository.medication.DrugPrescriptionRepository;
import com.mpazi.repository.medication.impl.DrugPrescriptionRepositoryImpl;
import com.mpazi.service.medication.impl.DrugPrescriptionServiceImpl;
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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DrugPrescriptionServiceImplTest {
    Map<String,String> values;
    DrugPrescriptionService service;

    DrugPrescription drugPrescription;
    @Before
    public void setUp() throws Exception {
        service = DrugPrescriptionServiceImpl.getInstance();
        values = new HashMap<>();
        values.put("drug_prescriptionId","3245");
        values.put("drugName","Panado");

        this.drugPrescription = DrugPrescriptionFactory.getDrugPrescription(values,"Headache");

    }

    @Test
    public void create() {
        DrugPrescription created = this.service.create(drugPrescription);
        System.out.println("In create, created = " + created);
        service.create(created);

        Assert.assertSame(created, this.drugPrescription);
    }

    @Test
    public void read() {
        DrugPrescription appoint = new DrugPrescription.Builder()
                .drug_prescriptionId(values.get("drug_prescriptionId"))
                .drugName(values.get("drugName"))
                .build();
        service.create(appoint);
        DrugPrescription read = service.read("3245");
        assertEquals("Panado",read.getDrugName()) ;

        System.out.println("In read, read = " +read.getDrugName() );
    }

    @Test
    public void update() {
        DrugPrescription newDrug = new DrugPrescription.Builder()
                .drug_prescriptionId(values.get("drug_prescriptionId"))
                .drugName(values.get("drugName"))
                .drugType("Headache")
                .build();
        service.update(newDrug);
        DrugPrescription UpdateDrug = service.read("3245");
        assertEquals("Headache",UpdateDrug.getDrugType());
    }

    @Test
    public void delete() throws Exception{
        service.delete("3245");
        DrugPrescription drugPrescription= service.read("3245");
        assertNull(drugPrescription);
    }

}