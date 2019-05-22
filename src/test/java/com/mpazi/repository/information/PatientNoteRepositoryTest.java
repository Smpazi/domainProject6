package com.mpazi.repository.information;

import com.mpazi.domain.information.PatientNote;
import com.mpazi.factory.information.factory.PatientNoteFactory;
import com.mpazi.repository.information.impl.PatientNoteRepositoryImpl;
import com.mpazi.util.Misc;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class PatientNoteRepositoryTest {
    Map<String, String> values;
    private PatientNoteRepository repository;
    private PatientNote patientNote;

    @Before
    public void setUp() throws Exception {
        this.repository = PatientNoteRepositoryImpl.getRepository();
        values = new HashMap<>();
        values.put("PatientNote_Id","AZ21");
        values.put("PatientNoteType","AddMedication");


        this.patientNote = PatientNoteFactory.getPatientNote(values);

    }

    @Test
    public void create() {

        PatientNote created = this.repository.create(patientNote);
        System.out.println("In create, created = " + created);
        repository.create(created);

        Assert.assertSame(created, this.patientNote);

    }
    @Test
    public void read() {
        PatientNote patientNote = new PatientNote.Builder()
                .patientNoteId(values.get("PatientNote_Id"))
                .patientNoteType(values.get("PatientNoteType"))
                .build();
        repository.create(patientNote);
        PatientNote read = repository.read("AZ21");
        assertEquals("AddMedication",read.getPatientNoteType());

        System.out.println("In read, read = " + read.getPatientNoteType());
    }
    @Test
    public void update()  {
        PatientNote patientNote = new PatientNote.Builder()
                .patientNoteId(values.get("PatientNote_Id"))
                .patientNoteType("AddNote")
                .build();
        repository.update(patientNote);
        PatientNote updated = repository.read("AZ21");
        assertEquals("AddNote",updated.getPatientNoteType());
    }


    @Test
    public void delete() {
        this.repository.delete("AZ21");
        PatientNote patientNote= repository.read("AZ21");
        assertNull(patientNote);
    }

    @Test
    public void  getAll(){
        Map<String,PatientNote> all = this.repository.getAll();
        System.out.println(all);
    }

}