package com.mpazi.service.template;

import com.mpazi.domain.template.Treatment;
import com.mpazi.factory.template.factory.TreatmentFactory;
import com.mpazi.repository.template.TreatmentRepository;
import com.mpazi.repository.template.impl.TreatmentRepositoryImpl;
import com.mpazi.service.template.impl.TreatmentServiceImpl;
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
public class TreatmentServiceImplTest {

    Map<String,String> values;
    TreatmentService service;

    Treatment treatment;
    @Before
    public void setUp() throws Exception {
        service = TreatmentServiceImpl.getInstance();
        values = new HashMap<>();
        values.put("treatment_ID","3245");

        this.treatment = TreatmentFactory.getTreatment(values,8);

    }

    @Test
    public void create() throws Exception{
        Treatment created = this.service.create(treatment);
        System.out.println("In create, created = " + created);
        service.create(created);
        Assert.assertSame(created, this.treatment);

    }

    @Test
    public void read() throws Exception {
        Treatment newTreament = new Treatment.Builder()
                .treatment_ID(values.get("treatment_ID"))
                .drugDosage(8)
                .build();
        service.update(newTreament);
        Treatment read = service.read("3245");
        assertEquals(8,read.getDrugDosage());
    }

    @Test
    public void update() throws Exception{
        Treatment newTreament = new Treatment.Builder()
                .treatment_ID(values.get("treatment_ID"))
                .drugDosage(2)
                .build();
        service.update(newTreament);
        Treatment UpdateTreatment = service.read("3245");
        assertEquals(2,UpdateTreatment.getDrugDosage());
    }

    @Test
    public void delete() throws Exception{
        service.delete("3245");
        treatment= service.read("3245");
        assertNull(treatment);
    }


}