package com.mpazi.service.information;

import com.mpazi.domain.information.PatientNote;
import com.mpazi.factory.information.factory.PatientNoteFactory;
import com.mpazi.repository.information.PatientNoteRepository;
import com.mpazi.repository.information.impl.PatientNoteRepositoryImpl;
import com.mpazi.service.information.impl.PatientNoteServiceImpl;
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

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PatientNoteServiceImplTest {

    Map<String, String> values;
    private PatientNoteService service;
    private PatientNote patientNote;

    @Before
    public void setUp() throws Exception {
        this.service = PatientNoteServiceImpl.getInstance();
        values = new HashMap<>();
        values.put("PatientNote_Id","AZ21");
        values.put("PatientNoteType","AddMedication");


        this.patientNote = PatientNoteFactory.getPatientNote(values);

    }

    @Test
    public void create() {

        PatientNote created = this.service.create(patientNote);
        System.out.println("In create, created = " + created);
        service.create(created);

        Assert.assertSame(created, this.patientNote);

    }
    @Test
    public void read() {
        PatientNote patientNote = new PatientNote.Builder()
                .patientNoteId(values.get("PatientNote_Id"))
                .patientNoteType(values.get("PatientNoteType"))
                .build();
        service.create(patientNote);
        PatientNote read = service.read("AZ21");
        assertEquals("AddMedication",read.getPatientNoteType());

        System.out.println("In read, read = " + read.getPatientNoteType());
    }
    @Test
    public void update()  {
        PatientNote patientNote = new PatientNote.Builder()
                .patientNoteId(values.get("PatientNote_Id"))
                .patientNoteType("AddNote")
                .build();
        service.update(patientNote);
        PatientNote updated = service.read("AZ21");
        assertEquals("AddNote",updated.getPatientNoteType());
    }


    @Test
    public void delete() {
        this.service.delete("AZ21");
        PatientNote patientNote= service.read("AZ21");
        assertNull(patientNote);
    }

    @Test
    public void  getAll(){
        Map<String,PatientNote> all = this.service.getAll();
        System.out.println(all);
    }

}