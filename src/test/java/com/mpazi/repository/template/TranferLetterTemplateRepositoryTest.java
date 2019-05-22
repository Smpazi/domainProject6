package com.mpazi.repository.template;

import com.mpazi.domain.template.TransferLetterTemplate;
import com.mpazi.factory.template.factory.TransferLetterTemplateFactory;
import com.mpazi.repository.template.impl.TransferLetterTemplateRepositoryImpl;
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
public class TranferLetterTemplateRepositoryTest {
    Map<String, String> values;
    private TranferLetterTemplateRepository repository;
    private TransferLetterTemplate template;

    @Before
    public void setUp() throws Exception {
        this.repository = TransferLetterTemplateRepositoryImpl.getRepository();
        values = new HashMap<>();
        values.put("Transfer_Id","a2");
        values.put("Transfer_DoctorName","Dr.ROSSOW");


        this.template = TransferLetterTemplateFactory.getTransferLetter(values);

    }

    @Test
    public void create() {
        TransferLetterTemplate created = this.repository.create(template);
        System.out.println("In create, created = " + created);
        repository.create(created);

        Assert.assertSame(created, this.template);

    }
    @Test
    public void read() {
        TransferLetterTemplate appoint = new TransferLetterTemplate.Builder()
                .transfer_ID(values.get("Transfer_Id"))
                .transfer_DoctorName(values.get("Transfer_DoctorName"))
                .build();
        repository.create(appoint);
        TransferLetterTemplate read = repository.read("a2");
        assertEquals("Dr.ROSSOW",read.getTransfer_DoctorName());
        System.out.println("In read, read = " +read.getTransfer_DoctorName() );
    }
    
    @Test
    public void update()  {
        TransferLetterTemplate transferLetterTemplate = new TransferLetterTemplate.Builder()
                .transfer_ID(values.get("Transfer_Id"))
                .transfer_DoctorName("DR.Troll")
                .build();
        repository.update(transferLetterTemplate);
        TransferLetterTemplate updated = repository.read("a2");
        assertEquals("DR.Troll",updated.getTransfer_DoctorName());
    }


    @Test
    public void delete() {

        this.repository.delete("a2");
        TransferLetterTemplate template= repository.read("a2");
        assertNull(template);

    }

    @Test
    public void  getAll(){
        Map<String, TransferLetterTemplate> all = this.repository.getAll();
        System.out.println(all);
    }

}