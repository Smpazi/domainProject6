package com.mpazi.repository.template;

import com.mpazi.domain.template.Treatment;
import com.mpazi.factory.template.factory.TreatmentFactory;
import com.mpazi.repository.template.impl.TreatmentRepositoryImpl;
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
public class TreatmentRepositoryTest {
    Map<String,String> values;
    TreatmentRepository repository;

    Treatment treatment;
    @Before
    public void setUp() throws Exception {
        repository = TreatmentRepositoryImpl.getRepository();
        values = new HashMap<>();
        values.put("treatment_ID","3245");

        this.treatment = TreatmentFactory.getTreatment(values,8);

    }

    @Test
    public void create() throws Exception{
        Treatment created = this.repository.create(treatment);
        System.out.println("In create, created = " + created);
        repository.create(created);
        Assert.assertSame(created, this.treatment);

    }

    @Test
    public void read() throws Exception {
        Treatment newTreament = new Treatment.Builder()
                .treatment_ID(values.get("treatment_ID"))
                .drugDosage(8)
                .build();
        repository.update(newTreament);
        Treatment read = repository.read("3245");
        assertEquals(8,read.getDrugDosage());
    }

    @Test
    public void update() throws Exception{
        Treatment newTreament = new Treatment.Builder()
                .treatment_ID(values.get("treatment_ID"))
                .drugDosage(2)
                .build();
        repository.update(newTreament);
        Treatment UpdateTreatment = repository.read("3245");
        assertEquals(2,UpdateTreatment.getDrugDosage());
    }

    @Test
    public void delete() throws Exception{
        repository.delete("3245");
         treatment= repository.read("3245");
        assertNull(treatment);
    }


}