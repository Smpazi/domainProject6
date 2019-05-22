package com.mpazi.repository.information;

import com.mpazi.domain.information.CheckUpPatient;
import com.mpazi.factory.information.factory.CheckUpPatientFactory;
import com.mpazi.repository.information.impl.CheckUpPatientRepositoryImpl;
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
public class CheckUpPatientRepositoryTest {

    Map<String, String> values;
    private CheckUpPatientRepository repository;
    private CheckUpPatient checkUpPatient;

    @Before
    public void setUp() throws Exception {
        this.repository = CheckUpPatientRepositoryImpl.getRepository();
        values = new HashMap<>();
        values.put("CheckUp_ID","2222");
        values.put("CheckUp_Date","02/03/2011");
        values.put("CheckUp_Reason","Wound dressing");

        this.checkUpPatient = CheckUpPatientFactory.getCheckUpPatient(values);

    }

    @Test
    public void create() {
        CheckUpPatient created = this.repository.create(checkUpPatient);
        System.out.println("In create, created = " + created);
        repository.create(created);

        Assert.assertSame(created, this.checkUpPatient);

    }
    @Test
    public void read() {
        CheckUpPatient checkUpPatient = new CheckUpPatient.Builder()
                .checkUp_Id(values.get("CheckUp_ID"))
                .checkUp_Reason(values.get("CheckUp_Reason"))
                .returnDate(values.get("CheckUp_Date"))
                .build();
        repository.create(checkUpPatient);
        CheckUpPatient read = repository.read("2222");
        assertEquals("Wound dressing",read.getCheckUp_Reason());
        System.out.println("In read, read = " + read.getCheckUp_Reason());
    }
    @Test
    public void update()  {
        CheckUpPatient checkUpPatient = new CheckUpPatient.Builder()
                .checkUp_Id(values.get("CheckUp_ID"))
                .checkUp_Reason(values.get("CheckUp_Reason"))
                .returnDate("10/06/2011")
                .build();
        repository.update(checkUpPatient);
        CheckUpPatient UpdateCheckUp = repository.read("2222");
        assertEquals("10/06/2011",UpdateCheckUp.getReturnDate());
        System.out.println("In update, updated = " + UpdateCheckUp.getReturnDate());

    }


    @Test
    public void delete() {
        this.repository.delete("Wound dressing");
        CheckUpPatient checkUpPatient= repository.read("Wound dressing");
        assertNull(checkUpPatient);

    }

    @Test
    public void  getAll(){
        Map<String,CheckUpPatient> all = this.repository.getAll();
        System.out.println(all);
    }



}