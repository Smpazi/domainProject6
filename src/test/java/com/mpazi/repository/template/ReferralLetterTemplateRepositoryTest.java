package com.mpazi.repository.template;

import com.mpazi.domain.template.ReferralLetterTemplate;
import com.mpazi.factory.template.factory.ReferralLetterTemplateFactory;
import com.mpazi.repository.template.impl.ReferralLetterTemplateRepositoryImpl;
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
public class ReferralLetterTemplateRepositoryTest {
    Map<String, String> values;
    private ReferralLetterTemplateRepository repository;
    private ReferralLetterTemplate letterTemplete;

    @Before
    public void setUp() throws Exception {
        this.repository = ReferralLetterTemplateRepositoryImpl.getRepository();
        values = new HashMap<>();
        values.put("Referral_ID","9797");
        values.put("Referral_HospitalName","StellyHospital");
        this.letterTemplete = ReferralLetterTemplateFactory.getReferralLetter(values);

    }

    @Test
    public void create() {
        ReferralLetterTemplate created = this.repository.create(letterTemplete);
        System.out.println("In create, created = " + created);
        repository.create(created);

        Assert.assertSame(created, this.letterTemplete);

    }
    @Test
    public void read() {
        ReferralLetterTemplate appoint = new ReferralLetterTemplate.Builder()
                .referral_ID(values.get("Referral_ID"))
                .referral_HospitalName(values.get("Referral_HospitalName"))
                .build();
        repository.create(appoint);
        ReferralLetterTemplate read = repository.read("9797");
        assertEquals("StellyHospital",read.getReferral_HospitalName());
        System.out.println("In read, read = " +read.getReferral_HospitalName());
    }
    @Test
    public void update()  {
        ReferralLetterTemplate letterTemplete = new ReferralLetterTemplate.Builder()
                .referral_ID(values.get("Referral_ID"))
                .referral_HospitalName("CrossHospital")
                .build();
        repository.update(letterTemplete);
        ReferralLetterTemplate updated = repository.read("9797");
        assertEquals("CrossHospital",updated.getReferral_HospitalName());
    }


    @Test
    public void delete() {

        this.repository.delete("9797");
        ReferralLetterTemplate letterTemplete= repository.read("9797");
        assertNull(letterTemplete);

    }

    @Test
    public void  getAll(){
        Map<String, ReferralLetterTemplate> all = this.repository.getAll();
        System.out.println(all);
    }

}