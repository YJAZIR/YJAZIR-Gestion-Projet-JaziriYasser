
package tn.esprit.backend.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.backend.entity.Projet;
import tn.esprit.backend.service.IProjetService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjetControllerTest {

    @Mock
    private IProjetService projetService;

    @InjectMocks
    private ProjetController projetController;

    @Test
    void testAddProjet() {
        Projet projet = new Projet();

        when(projetService.addProjet(projet)).thenReturn(projet);

        Projet result = projetController.addProjet(projet);

        assertNotNull(result);
        assertSame(projet, result);
        verify(projetService).addProjet(projet);
    }

    @Test
    void testUpdateProjet() {
        Projet projet = new Projet();

        when(projetService.updateProjet(projet)).thenReturn(projet);

        Projet result = projetController.updateProjet(projet);

        assertNotNull(result);
        assertSame(projet, result);
        verify(projetService).updateProjet(projet);
    }

    @Test
    void testDeleteProjet() {
        Long id = 1L;

        projetController.deleteProjet(id);

        verify(projetService).deleteProjet(id);
    }

    @Test
    void testGetProjetById() {
        Long id = 1L;
        Projet projet = new Projet();

        when(projetService.getProjetById(id)).thenReturn(projet);

        Projet result = projetController.getProjetById(id);

        assertNotNull(result);
        assertSame(projet, result);
        verify(projetService).getProjetById(id);
    }

    @Test
    void testGetAllProjets() {
        Projet projet1 = new Projet();
        Projet projet2 = new Projet();

        List<Projet> projets = Arrays.asList(projet1, projet2);

        when(projetService.getAllProjets()).thenReturn(projets);

        List<Projet> result = projetController.getAllProjets();

        assertEquals(2, result.size());
        assertSame(projet1, result.get(0));
        assertSame(projet2, result.get(1));
        verify(projetService).getAllProjets();
    }
}
