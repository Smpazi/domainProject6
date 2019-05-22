package com.mpazi.repository.information;

import com.mpazi.domain.information.CheckUpRecord;
import com.mpazi.factory.information.factory.CheckUpRecordFactory;
import com.mpazi.repository.information.impl.CheckUpRecordRepositoryImpl;
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
import static org.junit.Assert.assertNull;
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class CheckUpRecordRepositoryTest {
    Map<String, String> values;
    private CheckUpRecordRepository repository;
    private CheckUpRecord checkUpRecord;

    @Before
    public void setUp() throws Exception {
        this.repository = CheckUpRecordRepositoryImpl.getRepository();
        values = new HashMap<>();
        values.put("CheckUpRecordId","3333");
        values.put("CheckUpRecordName","Treatments");

        this.checkUpRecord = CheckUpRecordFactory.getCheckUpRecord(values);

    }

    @Test
    public void create() {
        CheckUpRecord created = this.repository.create(checkUpRecord);
        System.out.println("In create, created = " + created);
        repository.create(created);

        Assert.assertSame(created, this.checkUpRecord);

    }
    @Test
    public void read() {
        CheckUpRecord check = new CheckUpRecord.Builder()
                .checkUpRecordId(values.get("CheckUpRecordId"))
                .checkUpRecordName(values.get("CheckUpRecordName"))
                .build();
        repository.create(check);
        CheckUpRecord read = repository.read("3333");
        assertEquals("Treatments",read.getCheckUpRecordName());

        System.out.println("In read, read = " +read.getCheckUpRecordName());
    }
    @Test
    public void update()  {
        CheckUpRecord check = new CheckUpRecord.Builder()
                .checkUpRecordId(values.get("CheckUpRecordId"))
                .checkUpRecordName("Ointments")
                .build();
        repository.update(check);
        CheckUpRecord update = repository.read("3333");
        assertEquals("Ointments",update.getCheckUpRecordName());
        System.out.println("In update, updated = " + update.getCheckUpRecordName());

    }


    @Test
    public void delete() {

        this.repository.delete("3333");
        CheckUpRecord check= repository.read("3333");
        assertNull(check);

        System.out.println(repository.read("3333"));

    }

    @Test
    public void  getAll(){
        Map<String,CheckUpRecord> all = this.repository.getAll();
        System.out.println(all);
    }




}