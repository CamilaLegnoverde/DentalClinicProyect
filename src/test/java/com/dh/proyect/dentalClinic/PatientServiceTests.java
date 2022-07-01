package com.dh.proyect.dentalClinic;


import com.dh.proyect.dentalClinic.dto.PatientDTO;
import com.dh.proyect.dentalClinic.entity.Dentist;
import com.dh.proyect.dentalClinic.entity.Patient;
import com.dh.proyect.dentalClinic.service.impl.PatientService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
public class PatientServiceTests {
    @Autowired
    PatientService patientService;
    /* ---------------------------------------------------------------------*/
                        /*Testing save patient method*/
    @Test
    public void _1_savingAPatientTest(){
        Patient patientTest = new Patient();
        patientTest.setName("patientNameT1");
        patientTest.setSurname("patientSurnameT1");

        Patient patientTest2 = new Patient();
        patientTest.setName("patientNameT2");
        patientTest.setSurname("patientSurnameT2");

        patientService.savePatient(patientTest);
        patientService.savePatient(patientTest2);
    }

    /* ---------------------------------------------------------------------*/
                /*Testing search a patient by id method*/
    @Test
    public void _2_searchingAPatientByIdTest(){
        Patient patientTest3 = new Patient();
        patientTest3.setName("patientNameT3");
        patientTest3.setSurname("patientSurnameT3");
        patientService.savePatient(patientTest3);

        PatientDTO patientTest = patientService.findPatientById(1L);
        assertNotNull(patientTest);
    }

    /* ---------------------------------------------------------------------*/
                    /*Testing list all patients method*/
    @Test
    public void _3_patientListTest(){
        Patient patientTest4 = new Patient();
        patientTest4.setName("patientNameT4");
        patientTest4.setSurname("patientSurnameT4");
        patientService.savePatient(patientTest4);

        List<PatientDTO> patientTest = patientService.patientList();

        assertFalse(patientTest.isEmpty());
    }

    /* ---------------------------------------------------------------------*/
                    /*Testing update patients method*/
    @Test
    public void _4_updatingPatientTest(){
        Patient patientTest5 = new Patient();
        patientTest5.setName("patientNameT5");
        patientTest5.setSurname("patientSurnameT5");
        patientTest5 = patientService.savePatient(patientTest5);
        patientTest5.setName("patient5UpdatedName");

        patientService.updatePatient(patientTest5);
        PatientDTO expectedResoult = patientService.findPatientById(patientTest5.getId());

        assertEquals(expectedResoult.getName(), patientTest5.getName());
    }
    /* ---------------------------------------------------------------------*/
}
