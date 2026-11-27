
package tn.esprit.backend.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.backend.entity.ProjetDetaille;
import tn.esprit.backend.service.IProjetDetailleService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjetDetailleControllerTest {

    @Mock
    private IProjetDetailleService projetDetailleService;

    @InjectMocks
    private ProjetDetailleController projetDetailleController;

    @Test
    void testAddProjetDetaille() {
        ProjetDetaille detaille = new ProjetDetaille();

        when(projetDetailleService.addProjetDetaille(detaille))
                .thenReturn(detaille);

        ProjetDetaille result =
                projetDetailleController.addProjetDetaille(detaille);

        assertNotNull(result);
        assertSame(detaille, result);
        verify(projetDetailleService).addProjetDetaille(detaille);
    }

    @Test
    void testUpdateProjetDetaille() {
        ProjetDetaille detaille = new ProjetDetaille();

        when(projetDetailleService.updateProjetDetaille(detaille))
                .thenReturn(detaille);

        ProjetDetaille result =
                projetDetailleController.updateProjetDetaille(detaille);

        assertNotNull(result);
        assertSame(detaille, result);
        verify(projetDetailleService).updateProjetDetaille(detaille);
    }

    @Test
    void testDeleteProjetDetaille() {
        Long id = 1L;

        projetDetailleController.deleteProjetDetaille(id);

        verify(projetDetailleService).deleteProjetDetaille(id);
    }

    @Test
    void testGetProjetDetailleById() {
        Long id = 1L;
        ProjetDetaille detaille = new ProjetDetaille();

        when(projetDetailleService.getProjetDetailleById(id))
                .thenReturn(detaille);

        ProjetDetaille result =
                projetDetailleController.getProjetDetailleById(id);

        assertNotNull(result);
        assertSame(detaille, result);
        verify(projetDetailleService).getProjetDetailleById(id);
    }

    @Test
    void testGetAllProjetsDetailles() {
        ProjetDetaille detaille1 = new ProjetDetaille();
        ProjetDetaille detaille2 = new ProjetDetaille();

        List<ProjetDetaille> details =
                Arrays.asList(detaille1, detaille2);

        when(projetDetailleService.getAllProjetsDetailles())
                .thenReturn(details);

        List<ProjetDetaille> result =
                projetDetailleController.getAllProjetsDetailles();

        assertEquals(2, result.size());
        assertSame(detaille1, result.get(0));
        assertSame(detaille2, result.get(1));
        verify(projetDetailleService).getAllProjetsDetailles();
    }

    @Test
    void testGetProjetDetaillesByProjet() {
        Long projetId = 1L;
        ProjetDetaille detaille = new ProjetDetaille();

        when(projetDetailleService.getProjetDetaillesByProjet(projetId))
                .thenReturn(Arrays.asList(detaille));

        List<ProjetDetaille> result =
                projetDetailleController.getProjetDetaillesByProjet(projetId);

        assertEquals(1, result.size());
        assertSame(detaille, result.get(0));
        verify(projetDetailleService).getProjetDetaillesByProjet(projetId);
    }

    @Test
    void testAssignProjetDetailleToProjet() {
        Long detailleId = 1L;
        Long projetId = 2L;
        ProjetDetaille detaille = new ProjetDetaille();

        when(projetDetailleService.assignProjetDetailleToProjet(
                detailleId, projetId))
                .thenReturn(detaille);

        ProjetDetaille result =
                projetDetailleController.assignProjetDetailleToProjet(
                        detailleId, projetId);

        assertNotNull(result);
        assertSame(detaille, result);
        verify(projetDetailleService)
                .assignProjetDetailleToProjet(detailleId, projetId);
    }
}
