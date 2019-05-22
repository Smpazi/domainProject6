package com.mpazi.service.information;

import com.mpazi.domain.information.CheckUpRecord;
import com.mpazi.factory.information.factory.CheckUpRecordFactory;
import com.mpazi.repository.information.CheckUpRecordRepository;
import com.mpazi.repository.information.impl.CheckUpRecordRepositoryImpl;
import com.mpazi.service.information.impl.CheckUpRecordServiceImpl;
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

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CheckUpRecordServiceImplTest {
    Map<String, String> values;
    private CheckUpRecordService service;
    private CheckUpRecord checkUpRecord;

    @Before
    public void setUp() throws Exception {
        this.service = CheckUpRecordServiceImpl.getInstance();
        values = new HashMap<>();
        values.put("CheckUpRecordId","3333");
        values.put("CheckUpRecordName","Treatments");

        this.checkUpRecord = CheckUpRecordFactory.getCheckUpRecord(values);

    }

    @Test
    public void create() {
        CheckUpRecord created = this.service.create(checkUpRecord);
        System.out.println("In create, created = " + created);
        service.create(created);

        Assert.assertSame(created, this.checkUpRecord);

    }
    @Test
    public void read() {
        CheckUpRecord check = new CheckUpRecord.Builder()
                .checkUpRecordId(values.get("CheckUpRecordId"))
                .checkUpRecordName(values.get("CheckUpRecordName"))
                .build();
        service.create(check);
        CheckUpRecord read = service.read("3333");
        System.out.println("In read, read = " +read.getCheckUpRecordName());
    }
    @Test
    public void update()  {
        CheckUpRecord check = new CheckUpRecord.Builder()
                .checkUpRecordId(values.get("CheckUpRecordId"))
                .checkUpRecordName("Ointments")
                .build();
        service.update(check);
        CheckUpRecord update = service.read("3333");
        assertEquals("Ointments",update.getCheckUpRecordName());
        System.out.println("In update, updated = " + update.getCheckUpRecordName());

    }


    @Test
    public void delete() {

        this.service.delete("3333");
        CheckUpRecord check= service.read("3333");
        assertNull(check);

        System.out.println(service.read("3333"));

    }

    @Test
    public void  getAll(){
        Map<String,CheckUpRecord> all = this.service.getAll();
        System.out.println(all);
    }



}