package com.mpazi.service.template;

import com.mpazi.domain.template.SearchPatient;
import com.mpazi.factory.template.factory.SearchPatientFactory;
import com.mpazi.repository.template.SearchPatientRepository;
import com.mpazi.repository.template.impl.SearchPatientRepositoryImpl;
import com.mpazi.service.template.impl.SearchPatientServiceImpl;
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
public class SearchPatientServiceImplTest {
    Map<String, String> values;
    private SearchPatientService service;
    private SearchPatient searchPatient;

    @Before
    public void setUp() throws Exception {
        this.service = SearchPatientServiceImpl.getInstance();
        values = new HashMap<>();
        values.put("SearchId","3");

        this.searchPatient = SearchPatientFactory.getSearchPatient(values);

    }

    @Test
    public void create() {
        SearchPatient created = this.service.create(searchPatient);
        System.out.println("In create, created = " + created);
        service.create(created);

        Assert.assertSame(created, this.searchPatient);

    }
    @Test
    public void read() {
        SearchPatient appoint = new SearchPatient.Builder()
                .searchId(values.get("SearchId"))
                .build();
        service.create(appoint);
        SearchPatient read = service.read("3");
        assertEquals("3",read.getSearchId());
        System.out.println("In read, read = " +read.getSearchId() );
    }
    @Test
    public void update()  {
        SearchPatient searchPatient = new SearchPatient.Builder()
                .searchId(values.get("SearchId"))
                .build();
        service.update(searchPatient);
        SearchPatient updated = service.read("3");
        assertEquals("3",updated.getSearchId());
    }


    @Test
    public void delete() {

        this.service.delete("3");
        SearchPatient searchPatient= service.read("3");
        assertNull(searchPatient);

    }

    @Test
    public void  getAll(){
        Map<String, SearchPatient> all = this.service.getAll();
        System.out.println(all);
    }

}