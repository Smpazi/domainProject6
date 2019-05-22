package com.mpazi.factory.template.factory;

import com.mpazi.domain.template.TransferLetterTemplate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TransferLetterTemplateFactoryTest {
    Map<String, String> values;
    @Before
    public void setUp() throws Exception {

        values = new HashMap<>();
        values.put("Transfer_DoctorName","Dr. Sloan");

    }
    @Test
    public void getTransferLetterTemplateTest() {

        TransferLetterTemplate letterTemplate= TransferLetterTemplateFactory.getTransferLetter(values);

        Assert.assertEquals("Dr. Sloan",letterTemplate.getTransfer_DoctorName());

    }
}