package com.mpazi.repository.template;

import com.mpazi.domain.template.Treatment;
import com.mpazi.factory.template.factory.TreatmentFactory;
import com.mpazi.repository.template.impl.TreatmentRepositoryImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class TreatmentRepositoryTest {
    Map<String,String> values;
    TreatmentRepository repository;

    Treatment treatment;
    @Before
    public void setUp() throws Exception {
        repository = TreatmentRepositoryImpl.getRepository();
        values = new HashMap<>();
        values.put("treatment_ID","A234");
    }

    @Test
    public void create() throws Exception{
        treatment= TreatmentFactory.getTreatment(values,3);
        repository.create(treatment);
        assertEquals(3,treatment.getDrugDosage());
    }

    @Test
    public void read() throws Exception {
        treatment = repository.read("3245");
        assertEquals("A234",treatment.getTreatment_ID());
    }

    @Test
    public void update() throws Exception{
         treatment = repository.read("3245");
        Treatment newTreament = new Treatment.Builder()
                .treatment_ID(values.get("treatment_ID"))
                .drugDosage(2)
                .build();
        repository.update(newTreament);
        Treatment UpdateTreatment = repository.read("3245");
        assertEquals(2,treatment.getDrugDosage());
    }

    @Test
    public void delete() throws Exception{
        repository.delete("3245");
         treatment= repository.read("3245");
        assertNull(treatment);
    }



}