
package tn.esprit.backend.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.backend.entity.Equipe;
import tn.esprit.backend.service.IEquipeService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EquipeControllerTest {

    @Mock
    private IEquipeService equipeService;

    @InjectMocks
    private EquipeController equipeController;

    @Test
    void testAddEquipe() {
        Equipe equipe = new Equipe();

        when(equipeService.addEquipe(equipe)).thenReturn(equipe);

        Equipe result = equipeController.addEquipe(equipe);

        assertNotNull(result);
        assertSame(equipe, result);
        verify(equipeService).addEquipe(equipe);
    }

    @Test
    void testUpdateEquipe() {
        Equipe equipe = new Equipe();

        when(equipeService.updateEquipe(equipe)).thenReturn(equipe);

        Equipe result = equipeController.updateEquipe(equipe);

        assertNotNull(result);
        assertSame(equipe, result);
        verify(equipeService).updateEquipe(equipe);
    }

    @Test
    void testDeleteEquipe() {
        Long id = 1L;

        equipeController.deleteEquipe(id);

        verify(equipeService).deleteEquipe(id);
    }

    @Test
    void testGetEquipeById() {
        Long id = 1L;
        Equipe equipe = new Equipe();

        when(equipeService.getEquipeById(id)).thenReturn(equipe);

        Equipe result = equipeController.getEquipeById(id);

        assertNotNull(result);
        assertSame(equipe, result);
        verify(equipeService).getEquipeById(id);
    }

    @Test
    void testGetAllEquipes() {
        Equipe equipe1 = new Equipe();
        Equipe equipe2 = new Equipe();

        List<Equipe> equipes = Arrays.asList(equipe1, equipe2);

        when(equipeService.getAllEquipes()).thenReturn(equipes);

        List<Equipe> result = equipeController.getAllEquipes();

        assertEquals(2, result.size());
        assertSame(equipe1, result.get(0));
        assertSame(equipe2, result.get(1));
        verify(equipeService).getAllEquipes();
    }

    @Test
    void testGetEquipesByEntreprise() {
        Long entrepriseId = 1L;
        Equipe equipe = new Equipe();

        when(equipeService.getEquipesByEntreprise(entrepriseId))
                .thenReturn(Arrays.asList(equipe));

        List<Equipe> result =
                equipeController.getEquipesByEntreprise(entrepriseId);

        assertEquals(1, result.size());
        assertSame(equipe, result.get(0));
        verify(equipeService).getEquipesByEntreprise(entrepriseId);
    }

    @Test
    void testAssignEquipeToEntreprise() {
        Long equipeId = 1L;
        Long entrepriseId = 2L;
        Equipe equipe = new Equipe();

        when(equipeService.assignEquipeToEntreprise(equipeId, entrepriseId))
                .thenReturn(equipe);

        Equipe result =
                equipeController.assignEquipeToEntreprise(equipeId, entrepriseId);

        assertNotNull(result);
        assertSame(equipe, result);
        verify(equipeService).assignEquipeToEntreprise(equipeId, entrepriseId);
    }

    @Test
    void testAssignEquipeToProjet() {
        Long equipeId = 1L;
        Long projetId = 3L;
        Equipe equipe = new Equipe();

        when(equipeService.assignEquipeToProjet(equipeId, projetId))
                .thenReturn(equipe);

        Equipe result =
                equipeController.assignEquipeToProjet(equipeId, projetId);

        assertNotNull(result);
        assertSame(equipe, result);
        verify(equipeService).assignEquipeToProjet(equipeId, projetId);
    }
}
