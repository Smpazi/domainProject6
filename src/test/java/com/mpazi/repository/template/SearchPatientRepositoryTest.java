package com.mpazi.repository.template;

import com.mpazi.domain.template.SearchPatient;
import com.mpazi.factory.template.factory.SearchPatientFactory;
import com.mpazi.repository.template.impl.SearchPatientRepositoryImpl;
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
public class SearchPatientRepositoryTest {
    Map<String, String> values;
    private SearchPatientRepository repository;
    private SearchPatient searchPatient;

    @Before
    public void setUp() throws Exception {
        this.repository = SearchPatientRepositoryImpl.getRepository();
        values = new HashMap<>();
        values.put("SearchId","3");

        this.searchPatient = SearchPatientFactory.getSearchPatient(values);

    }

    @Test
    public void create() {
        SearchPatient created = this.repository.create(searchPatient);
        System.out.println("In create, created = " + created);
        repository.create(created);

        Assert.assertSame(created, this.searchPatient);

    }
    @Test
    public void read() {
        SearchPatient appoint = new SearchPatient.Builder()
                .searchId(values.get("SearchId"))
                .build();
        repository.create(appoint);
        SearchPatient read = repository.read("3");
        assertEquals("3",read.getSearchId());
        System.out.println("In read, read = " +read.getSearchId() );
    }
    @Test
    public void update()  {
        SearchPatient searchPatient = new SearchPatient.Builder()
                .searchId(values.get("SearchId"))
                .build();
        repository.update(searchPatient);
        SearchPatient updated = repository.read("3");
        assertEquals("3",updated.getSearchId());
    }


    @Test
    public void delete() {

        this.repository.delete("3");
        SearchPatient searchPatient= repository.read("3");
        assertNull(searchPatient);

    }

    @Test
    public void  getAll(){
        Map<String, SearchPatient> all = this.repository.getAll();
        System.out.println(all);
    }

}