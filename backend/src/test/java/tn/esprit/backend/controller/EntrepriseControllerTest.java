
package tn.esprit.backend.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.backend.entity.Entreprise;
import tn.esprit.backend.service.IEntrepriseService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EntrepriseControllerTest {

    @Mock
    private IEntrepriseService entrepriseService;

    @InjectMocks
    private EntrepriseController entrepriseController;

    @Test
    void testAddEntreprise() {
        Entreprise entreprise = new Entreprise();

        when(entrepriseService.addEntreprise(entreprise))
                .thenReturn(entreprise);

        Entreprise result =
                entrepriseController.addEntreprise(entreprise);

        assertNotNull(result);
        assertSame(entreprise, result);
        verify(entrepriseService).addEntreprise(entreprise);
    }

    @Test
    void testUpdateEntreprise() {
        Entreprise entreprise = new Entreprise();

        when(entrepriseService.updateEntreprise(entreprise))
                .thenReturn(entreprise);

        Entreprise result =
                entrepriseController.updateEntreprise(entreprise);

        assertNotNull(result);
        assertSame(entreprise, result);
        verify(entrepriseService).updateEntreprise(entreprise);
    }

    @Test
    void testDeleteEntreprise() {
        Long id = 1L;

        entrepriseController.deleteEntreprise(id);

        verify(entrepriseService).deleteEntreprise(id);
    }

    @Test
    void testGetEntrepriseById() {
        Long id = 1L;
        Entreprise entreprise = new Entreprise();

        when(entrepriseService.getEntrepriseById(id))
                .thenReturn(entreprise);

        Entreprise result =
                entrepriseController.getEntrepriseById(id);

        assertNotNull(result);
        assertSame(entreprise, result);
        verify(entrepriseService).getEntrepriseById(id);
    }

    @Test
    void testGetAllEntreprises() {
        Entreprise entreprise1 = new Entreprise();
        Entreprise entreprise2 = new Entreprise();

        List<Entreprise> entreprises =
                Arrays.asList(entreprise1, entreprise2);

        when(entrepriseService.getAllEntreprises())
                .thenReturn(entreprises);

        List<Entreprise> result =
                entrepriseController.getAllEntreprises();

        assertEquals(2, result.size());
        assertSame(entreprise1, result.get(0));
        assertSame(entreprise2, result.get(1));
        verify(entrepriseService).getAllEntreprises();
    }
}
